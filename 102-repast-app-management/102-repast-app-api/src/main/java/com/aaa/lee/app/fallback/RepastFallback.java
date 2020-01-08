package com.aaa.lee.app.fallback;

import com.aaa.lee.app.api.IRepastService;
import com.aaa.lee.app.model.OmsCartItem;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/19 14:57
 * @Description
 **/
@Component
public class RepastFallback implements FallbackFactory<IRepastService> {

    @Override
    public IRepastService create(Throwable throwable) {
        IRepastService repastService = new IRepastService(){

            @Override
            public Map<Object, Object> checkOutCart(String token, String json) {
                return null;
            }

            @Override
            public Map<Object, Object> addCart(String json, String token) {
                return null;
            }

            @Override
            public Map<Object, Object> deleteCartQuantity(Long id, String token, Integer quantity) {
                return null;
            }

            @Override
            public Map<Object, Object> addCartQuantity(Long id, String token, Integer quantity) {
                return null;
            }

            @Override
            public Map<Object, Object> selectByPrimaryKey(String token, Long id) {
                return null;
            }

            @Override
            public Map<String, Object> WMpay(String orderSn, String openid, BigDecimal amount) {
                return null;
            }

            @Override
            public void wxNotify() throws Exception {

            }

            @Override
            public String selectByOrderId(String token, Map<String, Object> map) {
                return null;
            }

            @Override
            public Map<Object, Object> deleteAllCart(String token, List<OmsCartItem> omsCartItems) {
                return null;
            }

            @Override
            public String selectAllOrder(String token, Map<String, Object> map) {
                return null;
            }

            @Override
            public Map<String, Object> state(String token, String json) {
                return null;
            }

            @Override
            public Map<String, Object> agree(String token, String json) {
                return null;
            }

            @Override
            public Map<String, Object> refund(String token, String json) {
                return null;
            }
        };
        return repastService;
    }
}
