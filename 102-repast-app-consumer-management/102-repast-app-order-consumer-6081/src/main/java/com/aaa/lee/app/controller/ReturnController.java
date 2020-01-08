package com.aaa.lee.app.controller;

import com.aaa.lee.app.annotaion.ReturnLogAnnotaion;
import com.aaa.lee.app.api.IRepastService;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.StatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author chh
 *  /*请求方式   1、resttemplate  模拟http请求调用 controller 调controller
 *             2、feign  声明式调用   controller 调 api   api调controller    fei不需要这么写  因为 注入api工程
 *     他们两个都需要eureka
 *     现在的请球方式全部用feign   跨域用resttemplate  但是公司里面还是feign
 */

@RestController
@Api(value = "退款", tags = "退款接口")
public class ReturnController extends BaseController{

    @Autowired
    private IRepastService repastService;

    @PostMapping("/state")
    @ApiOperation(value = "提交退货申请", notes = "提交退货申请操作")

    public ResultData state(String token,String json) {
        ResultData resultData = new ResultData();
        Map<String, Object> map = repastService.state(token, json);
        if (map.get(StaticProperties.CODE).equals(StatusEnum.SUCCESS.getCode())){
            resultData.setCode(StatusEnum.SUCCESS.getCode());
            resultData.setMsg(StatusEnum.SUCCESS.getMsg());

        }else {

            resultData.setCode(StatusEnum.FAILED.getCode());
            resultData.setMsg(StatusEnum.FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * 同意退款？
     *
     * @return
     */
    @PostMapping("/agree")
    @ApiOperation(value = "同意退款", notes = "商家是否同意退款")
    public ResultData agree(String token,String json){
        ResultData resultData = new ResultData();
        Map<String, Object> map = repastService.agree(token, json);
        if (map.get(StaticProperties.CODE).equals(StatusEnum.SUCCESS.getCode())){
            resultData.setCode(StatusEnum.SUCCESS.getCode());
            resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        }else {
            resultData.setCode(StatusEnum.FAILED.getCode());
            resultData.setMsg(StatusEnum.FAILED.getMsg());
        }
        return resultData;
    }

    /**
     * 商家确认收货后退钱
     *
     * @return
     */
    @PostMapping("/refund")
    @ApiOperation(value = "退款", notes = "退款")
    public ResultData refund(@RequestParam("token") String token, @RequestParam("json")String json){
        ResultData resultData = new ResultData();
        Map<String, Object> map = repastService.refund(token, json);
        if (map.get(StaticProperties.CODE).equals(StatusEnum.SUCCESS.getCode())){
            resultData.setCode(StatusEnum.SUCCESS.getCode());
            resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        }else {
            resultData.setCode(StatusEnum.FAILED.getCode());
            resultData.setMsg(StatusEnum.FAILED.getMsg());
        }
        return resultData;
    }



}
