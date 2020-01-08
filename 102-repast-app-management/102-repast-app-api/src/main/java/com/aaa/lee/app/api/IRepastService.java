package com.aaa.lee.app.api;

import com.aaa.lee.app.fallback.RepastFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/19 14:55
 * @Description
 *      如果是简单类型传递数据可以传递多个，但是每一个必须要用@RequestParam
 *      但是如果是包装类型，只能传递一个，也必须要用@RequestBody
 **/
@FeignClient(value = "order-interface-provider", fallbackFactory = RepastFallback.class)
public interface IRepastService {


    /**
     * @author awb
     * @description
     *      结算
     * @date create in 14:27 2019/12/20
     * @param
     * @return
    */
    @PostMapping("/checkOut")
    Map<Object,Object>  checkOutCart(@RequestParam("token") String token,@RequestParam("json") String json);

    /**
     * @author zws
     * @description
     *     支付
     * @date create in 13:10 2019/12/24
     * @param
     * @return
    */
    @PostMapping("/pay")
    Map<Object, Object> selectByPrimaryKey(@RequestParam("token") String token,@RequestParam("json") Long id);

    /**
     * @Author zws
     * @Description
     *      微信支付接口
     * @Param [orderSn, openid, amount]
     * @Return java.util.Map<java.lang.String,java.lang.Object>
     * @Date 2019/12/6
     */
    @GetMapping("/WMpay")
    Map<String, Object> WMpay(@RequestParam("orderSn")String orderSn, @RequestParam(name = "openid") String openid, @RequestParam(name = "amount") BigDecimal amount);

    /**
     * @Author zws
     * @Description
     *      微信支付回调接口
     * @Param []
     * @Return void
     * @Date 2019/12/6
     */
    @PostMapping("/wxNotify")
    void wxNotify() throws Exception;

}
