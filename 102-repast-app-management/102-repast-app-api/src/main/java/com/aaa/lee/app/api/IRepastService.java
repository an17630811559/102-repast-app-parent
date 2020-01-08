package com.aaa.lee.app.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
@FeignClient(value = "userinfo-interface-provider")//, fallbackFactory = RepastFallback.class)
public interface IRepastService {


    /**
     * @author awb
     * @description
     *          结算
     * @date create in 11:04 2019/12/20
     * @param
     * @return
    */
    @PostMapping("/checkOut")
    Map<Object,Object> checkOutCart(@RequestParam("token") String token, @RequestParam("json")String json);

    @PostMapping("/selectMyOrder")
    String selectAllOrder(@RequestParam("token") String token,@RequestBody Map<String, Object> map);

    @PostMapping("/selectMyOrderById")
    public String selectByOrderId(@RequestParam("token") String token, @RequestBody Map<String, Object> map);

    /**
     * 提交退货申请
     *
     * @return
     */
    @PostMapping("/state")
    public Map<String, Object> state(@RequestParam("token") String token, @RequestParam("json")String json);

    /**
     * 同意退款？
     * @return
     */
    @PostMapping("/agree")
    public Map<String, Object> agree(@RequestParam("token") String token, @RequestParam("json")String json);

    /**
     * 商家确认收货后退钱
     *
     * @return
     */
    @PostMapping("/refund")
    public Map<String, Object> refund(@RequestParam("token") String token, @RequestParam("json")String json);

}
