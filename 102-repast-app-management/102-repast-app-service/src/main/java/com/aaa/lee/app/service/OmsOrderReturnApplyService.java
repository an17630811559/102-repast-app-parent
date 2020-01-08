package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsOrderReturnApplyMapper;
import com.aaa.lee.app.model.OmsOrderReturnApply;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

/**
 *订单退货申请
 * @author chh
 */
@Service
public class OmsOrderReturnApplyService extends BaseService<OmsOrderReturnApply> {
    @Autowired
    private OmsOrderReturnApplyMapper omsOrderReturnApplyMapper;

    @Override
    public Mapper<OmsOrderReturnApply> getMapper() {
        return omsOrderReturnApplyMapper;
    }

    @Override
    public Integer save(OmsOrderReturnApply omsOrderReturnApply){

        int count = omsOrderReturnApplyMapper.insert(omsOrderReturnApply);


    }

}
