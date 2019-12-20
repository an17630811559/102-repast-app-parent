package com.aaa.lee.app.controller;

import com.aaa.lee.app.api.ICartItemService;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@Api(value = "购物车", tags = "购物车接口")
public class CartItemController extends BaseController {

    @Autowired
    private ICartItemService iCartItemService;

    /**
     * 添加购物车
     * @return
     */
    @PostMapping("/addCart")
    @ApiOperation(value = "添加购物车", notes = "添加购物车操作")
    public ResultData addCart(Map<Object,Object> omsCartItem){
        Map<Object, Object> objectObjectMap = iCartItemService.addCart(omsCartItem);
        if (objectObjectMap.get("code").equals("300")){
            //保存购物车成功
            success();
        }
        return failed();
    }



}
