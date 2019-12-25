package com.aaa.lee.app.mapper;

import com.aaa.lee.app.model.OmsOrder;
import com.aaa.lee.app.vo.OrderInfo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface OmsOrderMapper extends Mapper<OmsOrder> {

    OrderInfo getOrderInfo(String orderId);

}