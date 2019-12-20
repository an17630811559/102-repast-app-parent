package com.aaa.lee.app.api;

import com.aaa.lee.app.fallback.CartItemFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@FeignClient(value = "order-interface-provider",fallbackFactory = CartItemFallback.class)
public interface ICartItemService {
    /**
     * 添加购物车
     *  熔断数据
     * @return
     */
    @PostMapping("/addCart")
    Map<Object,Object> addCart(Map<Object,Object> omsCartItem);
}
