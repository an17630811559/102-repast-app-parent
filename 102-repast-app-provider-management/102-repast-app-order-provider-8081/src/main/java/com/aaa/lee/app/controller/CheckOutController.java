package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.CheckOutService;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description  结算
 * @date create in 19:14 2019/12/19
 */
@RestController
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
        if (StringUtil.isEmpty(token)){
            Map<Object,Object> tokenNull=new HashMap<Object, Object>(16);
            tokenNull.put(StaticProperties.CODE,LoginStatus.LOGIN_FAILED.getCode());
            tokenNull.put(StaticProperties.MSG,LoginStatus.LOGIN_FAILED.getMsg());
            return tokenNull;
        }
        Map<Object, Object> result = checkOutService.checkOutCart(token, json);
        return result;
    }


}
