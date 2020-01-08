package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.model.OmsOrderReturnReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 * 退货原因
 * @author chh
 */
@Service
public class omsOrderReturnReasonService extends BaseService<OmsOrderReturnReason> {
    @Autowired
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    @Override
    public Mapper<OmsOrderReturnReason> getMapper() {
        return omsOrderReturnReasonMapper;
    }
}
