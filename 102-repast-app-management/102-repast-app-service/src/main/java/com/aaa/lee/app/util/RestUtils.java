package com.aaa.lee.app.util;

import com.aaa.lee.app.model.OmsCartItem;
import com.aaa.lee.app.model.PmsProduct;
import com.aaa.lee.app.model.UmsMember;
import com.aaa.lee.app.utils.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description 远程调用封装类
 * @date create in 15:18 2019/12/23
 */
@Service
public class RestUtils {

    @Autowired
    public RestTemplate restTemplate ;


    /**
     * 根据token查询用户信息
     *
     * @param token
     * @return
     */
    public  UmsMember getUser(String token) {
        //远程调用
        //根据token查询用户
        UmsMember umsMember = null;
        try {
            Map<String, Object> hashMap = new HashMap<String, Object>(16);
            hashMap.put("token", token);
            String result = restTemplate.postForObject("http://192.168.1.15:6081/getUser", hashMap, String.class);
            if(null!=result) {
                umsMember = JSONUtil.toObject(result, UmsMember.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return umsMember;
    }

    /**
     * 远程调用 添加库存方法
     * @param
     * @param
     * @return
     */
    public  boolean updateAddSku(OmsCartItem omsCartItem) {
        List<OmsCartItem> list = new ArrayList<>();
        list.add(omsCartItem);
        Boolean aBoolean = restTemplate.postForObject("http://192.168.1.13:6086/addStock", list, boolean.class);
        if (aBoolean){
            return true;
        }
        return false;
    }
    /**
     * 远程调用 添加库存方法
     * @param
     * @param
     * @return
     */
    public  boolean deleteAllCart(List<OmsCartItem> omsCartItem) {
        Boolean aBoolean = restTemplate.postForObject("http://192.168.1.13:6086/addStock", omsCartItem, boolean.class);
        if (aBoolean){
            return true;
        }
        return false;
    }

    /**
     * 远程调用 减少库存方法
     * @param
     * @param
     * @return
     */
    public  boolean updatedeleteSku(OmsCartItem omsCartItem) {
        List<OmsCartItem> list = new ArrayList<>();
        list.add(omsCartItem);
        Boolean aBoolean = restTemplate.postForObject("http://192.168.1.13:6086/subtracStock", list, boolean.class);
        if (aBoolean){
            return true;
        }
        return false;
    }


    /**
     * 远程调用  查询商品的详情信息 并获取到商品的库存数量
     * @return
     */
    public   Integer  selectSku(Long productId){
        PmsProduct pmsProduct = restTemplate.postForObject("http://192.168.1.13:6086/productdatailed", productId, PmsProduct.class);
        Integer stock = pmsProduct.getStock();
        return stock;
    }

}
