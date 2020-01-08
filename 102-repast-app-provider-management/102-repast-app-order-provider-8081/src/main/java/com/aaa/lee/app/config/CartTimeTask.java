package com.aaa.lee.app.config;

import com.aaa.lee.app.mapper.OmsCartItemMapper;
import com.aaa.lee.app.model.OmsCartItem;
import com.aaa.lee.app.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class CartTimeTask {

    @Autowired
    private OmsCartItemMapper omsCartItemMapper;

    @Autowired
    private RestConfig restConfig;

    /**
     * 定时任务，如果加入购物车30分钟后没有操作就返回库存
     */
    @Scheduled(cron = "0/60 * * * * *")
    public void runTime() {
        List<OmsCartItem> omsCartItems = omsCartItemMapper.selectAll();
        List<OmsCartItem> list = new ArrayList<OmsCartItem>();
        if (null != omsCartItems && omsCartItems.size() > 0) {
            for (OmsCartItem ll : omsCartItems) {
                if (null == ll.getModifyDate()) {
                    Date createDate = ll.getCreateDate();
                    Date dateNow = DateUtil.getDateNow();
                    if (DateUtil.checkDate(createDate, dateNow)) {
                        ll.setDeleteStatus(1);
                        ll.setModifyDate(dateNow);
                        omsCartItemMapper.updateByPrimaryKeySelective(ll);
                        list.add(ll);
                    }
                }
            }
            Boolean aBoolean = restConfig.restTemplate().postForObject("http://192.168.1.13:6086/addStock", list, boolean.class);
        }
    }
}
