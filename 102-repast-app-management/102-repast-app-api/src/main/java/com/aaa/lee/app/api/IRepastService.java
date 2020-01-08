package com.aaa.lee.app.api;

import com.aaa.lee.app.model.OmsCartItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/19 14:55
 * @Description
 *      如果是简单类型传递数据可以传递多个，但是每一个必须要用@RequestParam
 *      但是如果是包装类型，只能传递一个，也必须要用@RequestBody
 **/
@FeignClient(value = "order-interface-provider")//, fallbackFactory = RepastFallback.class)
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
    Map<Object,Object>  checkOutCart(@RequestParam("token") String token,@RequestParam("json") String json);
    /**
     * 添加购物车
     *  熔断数据
     * @return
     */
    @PostMapping("/addCart")
    Map<Object,Object> addCart(@RequestParam("json")String json,@RequestParam("token") String token);

    /**
     *减少购物车中的商品数量
     *  熔断数据
     * @return
     */
    @PostMapping("/deleteCartQuantity")
    Map<Object,Object> deleteCartQuantity(@RequestParam("id") Long id ,@RequestParam("token") String token,@RequestParam("quantity") Integer quantity);
 /**
     *添加购物车中的商品数量
     *  熔断数据
     * @return
     */
    @PostMapping("/addCartQuantity")
    Map<Object,Object> addCartQuantity(@RequestParam("id") Long id ,@RequestParam("token") String token,@RequestParam("quantity") Integer quantity);

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

    @PostMapping("/selectMyOrderById")
    String selectByOrderId(@RequestParam("token") String token,@RequestBody Map<String, Object> map);

    /**
     * 清空购物车
     * @param token
     * @param omsCartItems
     * @return
     */
    @PostMapping("/deleteAllCart")
    Map<Object,Object> deleteAllCart(@RequestParam("token") String token,@RequestParam("omsCartItems") List<OmsCartItem> omsCartItems);



    @PostMapping("/selectMyOrder")
    String selectAllOrder(@RequestParam("token") String token,@RequestBody Map<String, Object> map);


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
