package com.aaa.lee.app.fallback;

import com.aaa.lee.app.api.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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
                System.out.println("结算熔断数据");
                return null;
            }

            @Override
            public String selectAllOrder(String token, Map<String, Object> map) {
                return null;
            }

            @Override
            public String selectByOrderId(String token, Map<String, Object> map) {
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
