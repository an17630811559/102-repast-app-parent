package com.aaa.lee.app.controller;

import com.aaa.lee.app.api.IRepastService;
import com.aaa.lee.app.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description 我的订单接口consumer
 * @date create in 15:47 2019/12/23
 */
@RestController
@Api(value = "我的订单接口", tags = "我的订单信息接口")
@RequestMapping("/consumer")
public class MyOrderController extends BaseController {
    @Autowired
    private IRepastService repastService;

    @PostMapping("/selectMyOrder")
    @ApiOperation(value = "查询全部订单", notes = "查询全部订单")
    public String selectAllOrder(@RequestBody Map<String, Object> map){
        if (!map.isEmpty()){
            String token=null==map.get("token")?"":map.get("token").toString();
            String s = repastService.selectAllOrder(token,map);
            return s;
        }
        return "";
    }

    @PostMapping("/selectMyOrderById")
    @ApiOperation(value = "查询单个全部订单", notes = "查询单个订单")
    public String selectMyOrderById(@RequestBody Map<String, Object> map){
        if (!map.isEmpty()){
            String token=null==map.get("token")?"":map.get("token").toString();
            String s = repastService.selectByOrderId(token,map);
            return  s;
        }
        return "";
    }

}
