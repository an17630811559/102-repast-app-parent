package com.aaa.lee.app.controller;


import com.aaa.lee.app.service.CartItemService;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CartItemController {

    @Autowired
    private CartItemService cartItemService;

    /**
     * 添加购物车
     *
     * @param omsCartItem
     * @param token
     * @return
     */
    @PostMapping("/addCart")
    public Map<Object, Object> addCart(Map<Object, Object> omsCartItem, String token) {
        Map<Object, Object> mapResult = new HashMap<Object, Object>();
        if (!StringUtil.isEmpty(token)) {
            //token为空证明用户没有登陆
            mapResult.put(StaticProperties.CODE, LoginStatus.USER_NOT_EXIST.getCode());
            mapResult.put(StaticProperties.MSG, LoginStatus.USER_NOT_EXIST.getMsg());
            return mapResult;
        }
        return cartItemService.addCart(omsCartItem, token);
    }
}
