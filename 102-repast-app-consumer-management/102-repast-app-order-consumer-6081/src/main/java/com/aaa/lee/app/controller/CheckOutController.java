package com.aaa.lee.app.controller;

import com.aaa.lee.app.api.IRepastService;
import com.aaa.lee.app.base.BaseController;
import com.aaa.lee.app.base.ResultData;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.StatusEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author AAA QY102 awb
 * @description 结算Controller
 * @date create in 11:08 2019/12/20
 */
@RestController
@Api(value = "订单信息", tags = "订单信息接口")
public class CheckOutController extends BaseController {
    @Autowired
    private IRepastService repastService;


    @PostMapping("/checkOut")
    @ApiOperation(value = "结算", notes = "执行结算操作")
    public ResultData checkout(String token, String json) {
        Map<Object, Object> result = repastService.checkOutCart(token, json);
        if(null!=result && StatusEnum.SUCCESS.getCode().equals(result.get(StaticProperties.CODE))) {
            // 操作成功
            return success(result);
        }
        return failed();
    }
}
