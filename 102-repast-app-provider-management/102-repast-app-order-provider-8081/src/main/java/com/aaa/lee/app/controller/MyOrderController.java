package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.MyOrderService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description 我的订单接口
 * @date create in 14:42 2019/12/23
 */
@RestController
@RequestMapping("/provider")
public class MyOrderController {
    @Autowired
    private MyOrderService myOrderService;

    /**
     * @author awb
     * @description
     *              我的订单接口
     *              查询所有订单
     * @date create in 19:34 2019/12/19
     * @param
     * @return
     */
    @PostMapping("/selectMyOrder")
    public String selectAllOrder(@RequestParam("token") String token,@RequestBody Map<String, Object> map){
        Map<String, Object> map1 = myOrderService.selectAllOrder(token, map);
        if (!map1.isEmpty()){
            return JSON.toJSON(map1).toString();
        }
        return  "";
    }


    /**
     * @author awb
     * @description
     *              我的订单接口
     *              查询单个订单
     * @date create in 19:34 2019/12/19
     * @param
     * @return
     */
    @PostMapping("/selectMyOrderById")
    public String selectByOrderId(@RequestParam("token") String token, @RequestBody Map<String, Object> map){

        Map<String, Object> map1 = myOrderService.selectOrderById(map);
        if (!map1.isEmpty()){
            return JSON.toJSON(map1).toString();
        }
        return "";
    }

}
