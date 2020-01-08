package com.aaa.lee.app.controller;


import com.aaa.lee.app.model.OmsCartItem;
import com.aaa.lee.app.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/provider")
public class CartItemController {


    @Autowired
    private CartItemService cartItemService;

    /**
     * 添加购物车
     *
     * @param
     * @param token
     * @return
     */
    @PostMapping("/addCart")
    public Map<Object, Object> addCart(@RequestParam("json") String json, @RequestParam("token") String token) {
        return cartItemService.addCart(json, token);
    }

    /**
     * 减少购物车中的商品数量
     * @param id
     * @param token
     * @param quantity
     * @return
     */
    @PostMapping("/deleteCartQuantity")
    public Map<Object,Object> deleteCartQuantity(@RequestParam("id") Long id ,@RequestParam("token") String token,@RequestParam("quantity") Integer quantity){
        return cartItemService.deleteCartQuantity(id,token,quantity);
    }/**
     * 添加购物车中的商品数量
     * @param id
     * @param token
     * @param quantity
     * @return
     */
    @PostMapping("/addCartQuantity")
    public Map<Object,Object> addCartQuantity(@RequestParam("id") Long id ,@RequestParam("token") String token,@RequestParam("quantity") Integer quantity){
        return cartItemService.addCartQuantity(id,token,quantity);
    }

    /**
     * 清空购物车
     * @param token
     * @param omsCartItems
     * @return
     */
    @PostMapping("/deleteAllCart")
    public Map<Object,Object> deleteAllCart(String token, List<OmsCartItem> omsCartItems){
    return  cartItemService.deleteAllCart(token,omsCartItems);
    }

}
