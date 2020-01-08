package com.aaa.lee.app.config;

import com.aaa.lee.app.mapper.OmsOrderMapper;
import com.aaa.lee.app.model.OmsOrder;
import com.aaa.lee.app.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description 定时任务
 * @date create in 16:07 2019/12/21
 */
@Component
public class ScheduledTask {
    @Autowired
    private OmsOrderMapper omsOrderMapper;


    /**
     * @author awb
     * @description
     *      每60秒扫描一遍订单表  如果发现订单创建+30分钟还没有支付  关闭订单
     * @date create in 17:04 2019/12/21
     * @param
     * @return
    */
    @Scheduled(cron ="0/60 * * * * *")
    public void run(){
        OmsOrder omsOrder = new OmsOrder();
        List<OmsOrder> omsOrders = omsOrderMapper.select(omsOrder.setStatus(0));
        if(null!=omsOrders&&omsOrders.size()>0) {
            for (OmsOrder oo : omsOrders) {
                if (null == oo.getPaymentTime()) {
                    Date createTime = oo.getCreateTime();
                    Date dateNow = DateUtil.getDateNow();
                    if (DateUtil.checkDate(createTime, dateNow)) {
                        oo.setDeleteStatus(1);
                        omsOrderMapper.updateByPrimaryKeySelective(oo);
                    }
                }
            }
        }
    }

    /**
     * @author awb
     * @description
     *  定时收货  每天0点触发
     * @date create in 14:43 2019/12/30
     * @param
     * @return
    */
    @Scheduled(cron ="0 0 0 * * ?")
    public void take(){
        OmsOrder omsOrder = new OmsOrder();
        List<OmsOrder> omsOrders = omsOrderMapper.select(omsOrder.setStatus(2));
        if(null!=omsOrders&&omsOrders.size()>0) {
            for (OmsOrder oo : omsOrders) {
                if (null == oo.getReceiveTime()) {
                    if (DateUtil.autoTake(oo.getReceiveTime(), oo.getAutoConfirmDay())) {
                        //确认收货
                        oo.setConfirmStatus(1).setReceiveTime(DateUtil.getDateNow());
                        omsOrderMapper.updateByPrimaryKeySelective(oo);
                    }
                }
            }
        }
    }

    /**
     * 同意退款？
     *
     * @return
     */
   /* @Scheduled(cron = "0/60 * * * * *")
    public Map<String, Object> agree(Map<String, Object> map) {
        Map<String, Object> info = new HashMap<String, Object>();

        //        如果为退款中则把商家地址、电话、收货人返回给前台
        if (Long.valueOf(getValue(map).get("status")) == 1) {
            info = info(map);

        }
        return info;
    }*/
}
