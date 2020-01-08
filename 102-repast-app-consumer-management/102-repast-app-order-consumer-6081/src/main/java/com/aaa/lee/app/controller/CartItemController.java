package com.aaa.lee.app.controller;

import com.aaa.lee.app.annotation.LoginLogAnnotation;
import com.aaa.lee.app.api.IRepastService;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.model.OmsCartItem;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@Api(value = "购物车", tags = "购物车接口")
public class CartItemController extends BaseController {

    @Autowired
    private IRepastService iRepastService;

    /**
     * 添加购物车
     * @return
     */
    @PostMapping("/addCart")
    @ApiOperation(value = "商品添加购物车", notes = "商品添加购物车操作")
    @LoginLogAnnotation()
    public ResultData addCart(String json , String token){
        Map<Object, Object> objectObjectMap = iRepastService.addCart(json,token);
        if (objectObjectMap.get("code").equals("300")){
            //保存购物车成功
            return addCart();
        }else if (objectObjectMap.get("code").equals("501")){
            //证明商品库存不足
            return productSku();
        }
        return failed();
    }

    /**
     *购物车中减少商品的数量
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteCartQuantity")
    @ApiOperation(value = "购物车中减少商品的数量", notes = "购物车中减少商品的数量的操作")
    public  ResultData deleteCartQuantity(Long id,String token,Integer quantity){
        Map<Object, Object> objectObjectMap = iRepastService.deleteCartQuantity(id, token, quantity);
        if (objectObjectMap.get("code").equals("1")) {
            return caozuo();
        }
        return shibai();
    }

    /**
     *购物车中添加商品的数量
     * @param
     * @param
     * @return
     */
    @PostMapping("/addCartQuantity")
    @ApiOperation(value = "购物车中添加商品的数量", notes = "购物车中添加商品的数量的操作")
    public  ResultData addCartQuantity(Long id,String token,Integer quantity){
        Map<Object, Object> objectObjectMap = iRepastService.deleteCartQuantity(id, token, quantity);
        if (objectObjectMap.get("code").equals("1")) {
            return caozuo();
        }
        return shibai();
    }


    /**
     *清空购物车
     * @param
     * @param
     * @return
     */
    @PostMapping("/deleteAllCart")
    @ApiOperation(value = "清空购物车", notes = "清空购物车操作")
    public  ResultData deleteAllCart(String token, List<OmsCartItem> omsCartItems){
        Map<Object, Object> objectObjectMap = iRepastService.deleteAllCart(token,omsCartItems);
        if (objectObjectMap.get("code").equals("1")) {
            return caozuo();
        }
        return shibai();
    }

}
