package com.aaa.lee.app.controller;

import com.aaa.lee.app.service.OmsOrderReturnApplyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 退货申请
 *
 * @author chh
 */
@RestController
@RequestMapping("/provider")
public class ReturnController {

    @Autowired
    private OmsOrderReturnApplyService omsOrderReturnApplyService;



    /**
     * 图片上传
     *
     * @return
     */
    @PostMapping("/ftp")
    public Map<Object, Object> ftp(@RequestParam("token") String token, @RequestParam("json")String json) {

            /*Map<Object, Object> tokenNuLL = new HashMap<Object, Object>(16);
            tokenNuLL.put(StaticProperties.CODE, LoginStatus.LOGIN_FAILED.getCode());
            tokenNuLL.put(StaticProperties.MSG, LoginStatus.LOGIN_FAILED.getMsg());
            return tokenNuLL;*/
//        toDo 上传图片

        return null;

    }

    /**
     * 提交退货申请
     *
     * @return
     */
    @PostMapping("/state")
    public Map<String, Object> state(@RequestParam("token") String token, @RequestParam("json")String json) {

            Map<String, Object> map = JSON.parseObject(json);
            return omsOrderReturnApplyService.save(map);


    }

    /**
     * 是否同意退款
     *
     * @return
     */
    @PostMapping("/agree")
    public Map<String, Object> agree(@RequestParam("token") String token, @RequestParam("json")String json) {

            Map<String, Object> map = JSON.parseObject(json);
            return omsOrderReturnApplyService.agree(map);

    }

    /**
     * 商家确认收货后退钱
     *
     * @return
     */
    @PostMapping("/refund")
    public Map<String, Object> refund(@RequestParam("token") String token, @RequestParam("json")String json)  {

            Map<String, Object> map = JSON.parseObject(json);
            return omsOrderReturnApplyService.refund(map);

    }


}
