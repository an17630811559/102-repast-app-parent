package com.aaa.lee.app.config;

import com.aaa.lee.app.mapper.OmsOrderMapper;
import com.aaa.lee.app.model.OmsOrder;
import com.aaa.lee.app.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

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
        List<OmsOrder> omsOrders = omsOrderMapper.selectAll();
        if(null==omsOrders&&omsOrders.size()>0) {
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
}
