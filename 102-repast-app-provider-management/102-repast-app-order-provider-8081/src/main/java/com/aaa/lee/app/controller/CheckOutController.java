package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.CheckOutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description  结算
 * @date create in 19:14 2019/12/19
 */
@RestController
@RequestMapping("/provider")
public class CheckOutController {

    @Autowired
    private CheckOutService checkOutService;

    /**
     * @author awb
     * @description
     *              map中所要包含的属性
     *              1、购物车总金额
     *              2、商品的所有信息（包括购买数量）
     *              3、店铺的信息
     * @date create in 19:34 2019/12/19
     * @param
     * @return
    */
    @PostMapping("/checkOut")
    public Map<Object,Object> checkOutCart(@RequestParam("token") String token, @RequestParam("json")String json){

        return checkOutService.checkOutCart(token, json);
    }


}
