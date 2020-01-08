package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsOrderItemMapper;
import com.aaa.lee.app.model.OmsOrderItem;
import com.aaa.lee.app.utils.DateUtil;
import com.aaa.lee.app.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chh
 */
@Service
@Transactional
public class OmsOrderItemService extends BaseService<OmsOrderItem> {
    @Autowired
    private OmsOrderItemMapper omsOrderItemMapper;

    @Override
    public Mapper<OmsOrderItem> getMapper() {
        return omsOrderItemMapper;
    }


}
