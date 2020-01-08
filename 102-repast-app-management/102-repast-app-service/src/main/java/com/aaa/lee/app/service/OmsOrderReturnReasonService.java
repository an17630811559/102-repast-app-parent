package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsOrderReturnReasonMapper;
import com.aaa.lee.app.model.OmsOrderReturnReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

/**
 * 退货原因
 * @author chh
 */
@Service
@Transactional
public class OmsOrderReturnReasonService extends BaseService<OmsOrderReturnReason> {

    @Autowired
    private OmsOrderReturnReasonMapper omsOrderReturnReasonMapper;

    @Override
    public Mapper<OmsOrderReturnReason> getMapper() {
        return omsOrderReturnReasonMapper;
    }
}
