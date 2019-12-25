package com.aaa.lee.app.api;

import com.aaa.lee.app.fallback.RepastFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
@RequestMapping("/provider")
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


    @PostMapping("/selectMyOrder")
    String selectAllOrder(@RequestParam("token") String token,@RequestBody Map<String, Object> map);

    @PostMapping("/selectMyOrderById")
    String selectByOrderId(@RequestParam("token") String token,@RequestBody Map<String, Object> map);
}
