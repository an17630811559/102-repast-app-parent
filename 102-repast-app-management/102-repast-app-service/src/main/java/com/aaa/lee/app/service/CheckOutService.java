package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsOrderItemMapper;
import com.aaa.lee.app.mapper.OmsOrderMapper;
import com.aaa.lee.app.mapper.OmsOrderOperateHistoryMapper;
import com.aaa.lee.app.model.OmsOrder;
import com.aaa.lee.app.model.OmsOrderItem;
import com.aaa.lee.app.model.OmsOrderOperateHistory;
import com.aaa.lee.app.model.UmsMember;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.StatusEnum;
import com.aaa.lee.app.util.RestUtils;
import com.aaa.lee.app.utils.BigDecimalUtil;
import com.aaa.lee.app.utils.DateUtil;
import com.aaa.lee.app.utils.IDUtil;
import com.aaa.lee.app.utils.JSONUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tk.mybatis.mapper.common.Mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description 结算service层
 * @date create in 19:16 2019/12/19
 */
@Service
public class CheckOutService extends BaseService<OmsOrder> {

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;

    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;

    @Autowired
    private RestUtils restUtils;


    @Override
    public Mapper<OmsOrder> getMapper() {
        return omsOrderMapper;
    }

    /**
     * @author awb
     * @description
     *      结算按钮  需要参数
     * @date create in 19:53 2019/12/19
     * @param
     * @return
    */
    public Map<Object,Object> checkOutCart(String token,String json){

        Map map= JSON.parseObject(json);

        //拿到订单总金额
        BigDecimal totalMoney = BigDecimalUtil.getBigDecimal(map.get("total_money"));
        List<Map<String,Object>> product = (List) map.get("product");

        //远程调用 获取用户信息
        UmsMember umsMember = restUtils.getUser(token);

        //查询库存
        //TODO

        //生成订单id
        String orderId = IDUtil.getUUID();
        //生成订单的时间
        Date date=DateUtil.getDateNow();

        //添加订单主表
         omsOrderMapper.insert(
                new OmsOrder().setId(null)
                        .setShopId(map.get("shop_id") == null ? null : Long.valueOf(map.get("shop_id").toString()))
                        .setMemberId(null!=umsMember?umsMember.getId():null)
                        .setOrderSn(orderId)
                        .setCreateTime(date)
                        .setTotalAmount(totalMoney)
                        .setReceiverName("待更新")
                        .setReceiverPhone("待更新")
                        .setDeleteStatus(0)
        );
        //添加订单详情表  因为订单中的商品不止有一个  所以for循环
        for (Map<String,Object> pd :product){

            omsOrderItemMapper.insert(
                    new OmsOrderItem().setOrderId(null)
                            .setOrderSn(orderId)
                            .setProductId(null==pd.get("product_id")?null:Long.valueOf(pd.get("product_id").toString()))
                            .setProductPic(null==pd.get("product_pic")?"":pd.get("product_pic").toString())
                            .setProductName(null==pd.get("product_name")?"":pd.get("product_name").toString())
                            .setProductBrand(null==pd.get("product_brand")?"":pd.get("product_brand").toString())
                            .setProductSn(null==pd.get("product_sn")? "" :pd.get("product_sn").toString() )
                            .setProductPrice(null==pd.get("product_price")? null :BigDecimalUtil.getBigDecimal(pd.get("product_price")) )
                            .setProductQuantity(null==pd.get("product_quantity")? null :Integer.valueOf(pd.get("product_quantity").toString()))
                            .setProductSkuId(null==pd.get("product_sku_id")?null  :Long.valueOf(pd.get("product_sku_id").toString()) )
                            .setProductSkuCode(null==pd.get("product_sku_code")?""  :pd.get("product_sku_code").toString() )
                            .setProductCategoryId(null==pd.get("product_category_id")? null :Long.valueOf(pd.get("product_category_id").toString()) )
                             .setPromotionName(null==pd.get("promotion_name")?""  :pd.get("promotion_name").toString() )
                            .setProductAttr(null==pd.get("product_attr")?"":pd.get("product_attr").toString())
                    //TODO
            );
        }
        //添加订单历史表
        omsOrderOperateHistoryMapper.insert(
                new OmsOrderOperateHistory().setId(null)
                            .setOrderId(null)
                            .setShopId(map.get("shop_id") == null ? null : Long.valueOf(map.get("shop_id").toString()))
                            .setOperateMan("0")
                            .setCreateTime(date)
                             .setOrderStatus(0)
        );

        map.put("orderId",orderId);
        map.put("create_date",date);
        map.put("token",token);
        map.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
        map.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());

        return map;
    }





}
