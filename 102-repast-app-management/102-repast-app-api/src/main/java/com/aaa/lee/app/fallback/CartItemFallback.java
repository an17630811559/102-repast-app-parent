package com.aaa.lee.app.fallback;


import com.aaa.lee.app.api.ICartItemService;
import feign.hystrix.FallbackFactory;

import java.util.Map;

public class CartItemFallback implements FallbackFactory<ICartItemService> {
    /**
     * 购物车进入熔断
     * @param throwable
     * @return
     */
    @Override
    public ICartItemService create(Throwable throwable) {
        ICartItemService cartItemService = new ICartItemService() {
            @Override
            public Map<Object, Object> addCart(Map<Object, Object> omsCartItem) {
                System.out.println("添加购物车按钮进入熔断");
                return null;
            }
        };
        return cartItemService;
    }
}
