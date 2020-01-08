package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.*;
import com.aaa.lee.app.model.*;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.StatusEnum;
import com.aaa.lee.app.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 订单退货
 *
 * @author chh
 */
@Service
//事务
@Transactional
public class OmsOrderReturnApplyService extends BaseService<OmsOrderReturnApply> {
    @Autowired
    private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;
    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;
    @Autowired
    private UmsMemberMapper umsMemberMapper;
    @Autowired
    private UmsShopInformationMapper umsShopInformationMapper;
    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;
    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Override
    public Mapper<OmsOrderReturnApply> getMapper() {
        return omsOrderReturnApplyMapper;
    }

    public Map<String, String> getValue(Map<String, Object> map) {
        //           订单id
        String order_id = null == map.get("order_id") ? "" : map.get("order_id").toString();
//            退货商品id
        String product_id = null == map.get("product_id") ? "" : map.get("product_id").toString();
//            店铺id
        String shop_id = null == map.get("shop_id") ? "" : map.get("shop_id").toString();
//            会员id
        String member_id = null == map.get("member_id") ? "" : map.get("member_id").toString();
//            退货数量
        String product_count = null == map.get("product_count") ? "" : map.get("product_count").toString();
//            原因
        String reason = null == map.get("reason") ? "" : map.get("reason").toString();
//            描述
        String description = null == map.get("description") ? "" : map.get("description").toString();

        //      申请状态
        String status = null == map.get("status") ? "" : map.get("status").toString();

        Map<String, String> map2 = new HashMap<>();

        map2.put("order_id", order_id);
        map2.put("product_id", product_id);
        map2.put("shop_id", shop_id);
        map2.put("member_id", member_id);
        map2.put("product_count", product_count);
        map2.put("reason", reason);
        map2.put("description", description);
        return map2;
    }

    /**
     * 提交退货申请
     *
     * @return
     */
    public Map<String, Object> save(Map<String, Object> map) {
        Date dateNow = DateUtil.getDateNow();


        OmsOrderItem omsOrderItem = new OmsOrderItem();
        omsOrderItem.setOrderId(Long.valueOf(getValue(map).get("order_id"))).setProductId(Long.valueOf(getValue(map).get("product_id")));
        List<OmsOrderItem> omsOrderItems = omsOrderItemMapper.select(omsOrderItem);

        UmsMember umsMember = umsMemberMapper.selectByPrimaryKey(Long.valueOf(getValue(map).get("member_id")));

        BigDecimal num1 = new BigDecimal(Long.valueOf(getValue(map).get("product_count")));
        if (omsOrderItems.size() > 0) {
            OmsOrderItem omsOrderItem2 = omsOrderItems.get(0);
            OmsOrderReturnApply omsOrderReturnApply = new OmsOrderReturnApply()
                    .setShopId(Long.valueOf(getValue(map).get("shop_id")))
                    .setOrderId(Long.valueOf(getValue(map).get("order_id")))
                    .setProductId(Long.valueOf(getValue(map).get("product_id")))
                    .setOrderSn(omsOrderItem2.getOrderSn())
                    .setCreateTime(dateNow)
                    .setMemberUsername(umsMember.getNickname())
                    .setReturnAmount(omsOrderItem2.getRealAmount().multiply(num1))
                    .setReturnName(umsMember.getUsername())
                    .setReturnPhone(umsMember.getPhone())
                    .setStatus(0)
                    .setProductPic(omsOrderItem2.getProductPic())
                    .setProductName(omsOrderItem2.getProductName())
                    .setProductBrand(omsOrderItem2.getProductBrand())
                    .setProductAttr(omsOrderItem2.getProductAttr())
                    .setProductCount(Integer.valueOf(getValue(map).get("product_count")))
                    .setProductPrice(omsOrderItem2.getProductPrice())
                    .setProductRealPrice(omsOrderItem2.getRealAmount())
                    .setDescription(getValue(map).get("description"));
            int count = omsOrderReturnApplyMapper.insert(omsOrderReturnApply);


            /*OmsOrderReturnReason omsOrderReturnReason = new OmsOrderReturnReason();
            omsOrderReturnReason.setCreateTime(dateNow);
            int count2 = omsOrderReturnReasonMapper.insert(omsOrderReturnReason);*/
            if (count > 0) {
                map.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
                map.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());
            } else {
                map.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
                map.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
            }
        }

        return map;

    }

    /**
     * 同意退款？
     *
     * @return
     */
    @Scheduled(cron = "0/60 * * * * *")
    public Map<String, Object> agree(Map<String, Object> map) {
        Map<String, Object> info = new HashMap<>();


        //        如果为退款中则把商家地址、电话、收货人返回给前台
        if (Long.valueOf(getValue(map).get("status")) == 1) {
            info = info(map);

        }
        return info;
    }

    /**
     * 商家地址、电话、收货人返回给前台
     *
     * @param map
     * @return
     */
    public Map<String, Object> info(Map<String, Object> map) {
        UmsShopInformation umsShopInformation = umsShopInformationMapper.selectByPrimaryKey(Long.valueOf(getValue(map).get("shop_id")));
        OmsOrderReturnApply omsOrderReturnApply = new OmsOrderReturnApply();
        omsOrderReturnApply.setReceiveMan(umsShopInformation.getAddress());

        int count = omsOrderReturnApplyMapper.insert(omsOrderReturnApply);
        if (count > 0) {
            map.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
            map.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());
        } else {
            map.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            map.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
        }
        return map;
    }

    /**
     * 商家确认收货后退钱
     *
     * @return
     */
    public Map<String, Object> refund(Map<String, Object> map) {
        String note = null == map.get("note") ? "" : map.get("note").toString();
        Date dateNow = DateUtil.getDateNow();

        if (Long.valueOf(getValue(map).get("status")) == 3) {
            OmsOrderOperateHistory omsOrderOperateHistory = new OmsOrderOperateHistory();
            omsOrderOperateHistory.setOrderId(getValue(map).get("order_id"))
                    .setNote(note).setCreateTime(dateNow);
            int count = omsOrderOperateHistoryMapper.insert(omsOrderOperateHistory);
            if (count > 0) {
                //            toDo  调用微信接口退款
            }
        }
        Integer count2 = 1;
        if (count2 > 0) {
            map.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
            map.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());
        } else {
            map.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            map.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
        }
        return map;
    }

}
