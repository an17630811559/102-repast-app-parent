package com.aaa.lee.app.vo;

import com.aaa.lee.app.model.OmsOrder;
import com.aaa.lee.app.model.OmsOrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author AAA QY102 awb
 * @description 订单详情 vo 类
 * @date create in 13:43 2019/12/24
 */
@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class OrderInfo extends OmsOrder  {

    /**
     * 订单详情
     */
    private List<OmsOrderItem> omsOrderItem;
}
