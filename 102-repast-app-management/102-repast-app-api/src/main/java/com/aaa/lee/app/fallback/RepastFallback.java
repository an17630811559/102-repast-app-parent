package com.aaa.lee.app.fallback;

import com.aaa.lee.app.api.IRepastService;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

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
                System.out.println("结算熔断数据");
                return null;
            }

            @Override
            public Map<Object, Object> selectByPrimaryKey(String token, Long id) {
                System.out.println("支付熔断数据");
                return null;
            }

            @Override
            public Map<String, Object> WMpay(String orderSn, String openid, BigDecimal amount) {
                System.out.println("测试微信支付");
                return null;
            }

            @Override
            public void wxNotify() throws Exception {
                System.out.println("测试微信支付回调");
            }
        };
        return repastService;
    }
}
