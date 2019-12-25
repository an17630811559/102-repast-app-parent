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
import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.status.StatusEnum;
import com.aaa.lee.app.util.RestUtils;
import com.aaa.lee.app.utils.BigDecimalUtil;
import com.aaa.lee.app.utils.DateUtil;
import com.aaa.lee.app.utils.IDUtil;
import com.aaa.lee.app.utils.JSONUtil;
import com.aaa.lee.app.vo.OrderInfo;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
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
@Transactional
public class MyOrderService extends BaseService<OmsOrder> {

    @Autowired
    private OmsOrderMapper omsOrderMapper;

    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;

    @Autowired
    private RestUtils restUtils;


    @Override
    public Mapper<OmsOrder> getMapper() {
        return omsOrderMapper;
    }

    /**
     * @author awb
     * @description
     *        查询所有订单
     * @date create in 19:53 2019/12/19
     * @param
     * @return
    */
    public Map<String,Object> selectAllOrder(String token,Map<String, Object> map) {

        //先根据token把用户信息查出来
        UmsMember umsMember = restUtils.getUser(token);

        if (null!=umsMember){
            List<OmsOrder> data = omsOrderMapper.select(new OmsOrder().setMemberId(umsMember.getId()));
            if (null!=data&&data.size()>0){
                for (OmsOrder omsOrder:data){
                    int count = omsOrderItemMapper.selectCount(new OmsOrderItem().setOrderSn(omsOrder.getOrderSn()));
                    if (count!=0){
                        omsOrder.setNote(count+"");
                    }
                }
                //查询成功
                map.put(StaticProperties.CODE, LoginStatus.LOGIN_SUCCESS.getCode());
                map.put(StaticProperties.MSG,"查询成功");
                map.put(StaticProperties.DATA,data);
                return map;
            }
        }

        return null;
    }


    /**
     * @author awb
     * @description
     *        查询单个订单
     * @date create in 19:53 2019/12/19
     * @param
     * @return
     */
    public Map<String,Object> selectOrderById(Map<String, Object> map) {
        HashMap<String, Object> result = new HashMap<String, Object>();
        String orderSn = null == map.get("orderSn") ? null : map.get("orderSn").toString();

        //判断订单编号是否为空
        if (!"".equals(orderSn)){
            OrderInfo orderInfo = omsOrderMapper.getOrderInfo(orderSn);
            result.put(StaticProperties.CODE,200);
            result.put(StaticProperties.MSG,"查询成功");
            result.put(StaticProperties.DATA,orderInfo);
            return result;
        }


        return null;
    }




}
