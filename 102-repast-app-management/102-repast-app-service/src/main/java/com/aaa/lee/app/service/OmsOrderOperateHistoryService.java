package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsOrderOperateHistoryMapper;
import com.aaa.lee.app.model.OmsOrderOperateHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chh
 */
@Service
@Transactional
public class OmsOrderOperateHistoryService extends BaseService<OmsOrderOperateHistory> {
    @Autowired
    private OmsOrderOperateHistoryMapper omsOrderOperateHistoryMapper;
    @Override
    public Mapper<OmsOrderOperateHistory> getMapper() {
        return omsOrderOperateHistoryMapper;
    }

    public Map<String,Object>up(OmsOrderOperateHistory omsOrderOperateHistory){
        HashMap<String, Object> map = new HashMap<>();
        try {
            Integer i = super.update(omsOrderOperateHistory);
            map.put("result",i);
        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }
}
