package com.aaa.lee.app.controller;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.model.OmsOrderReturnApply;
import com.aaa.lee.app.model.OmsOrderReturnReason;
import com.aaa.lee.app.service.OmsOrderReturnApplyService;
import com.aaa.lee.app.service.omsOrderReturnReasonService;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.utils.DateUtil;
import com.aaa.lee.app.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 退货申请
 * @author chh
 */
@RestController
public class ReturnController {

    @Autowired
    private OmsOrderReturnApplyService omsOrderReturnApplyService;
    @Autowired
    private omsOrderReturnReasonService omsOrderReturnReasonService;

    /**
     * 选择服务类型
     * @return
     */
    @PostMapping("/serviceType")
    public Map<Object, Object> serviceType(String token){
        if (!StringUtil.isEmpty(token)){
            Map<Object, Object> tokenNuLL = new HashMap<Object, Object>(16);
            tokenNuLL.put(StaticProperties.CODE, LoginStatus.LOGIN_FAILED.getCode());
            tokenNuLL.put(StaticProperties.MSG, LoginStatus.LOGIN_FAILED.getMsg());
            return tokenNuLL;
        }
        return null;
    }

    /**
     * 退款不退货
     * @return
     */
    @PostMapping("/reimburse")
    public Map<Object, Object> reimburse(String token){
        if (!StringUtil.isEmpty(token)){
            Map<Object, Object> tokenNuLL = new HashMap<Object, Object>(16);
            tokenNuLL.put(StaticProperties.CODE, LoginStatus.LOGIN_FAILED.getCode());
            tokenNuLL.put(StaticProperties.MSG, LoginStatus.LOGIN_FAILED.getMsg());
            return tokenNuLL;
        }
        return null;

//        toDo 调用商品查询功能获取图片、价格、信息
    }

    /**
     * 图片上传
     * @return
     */
    @PostMapping("/ftp")
    public Map<Object, Object> ftp(String token){
        if (!StringUtil.isEmpty(token)){
            Map<Object, Object> tokenNuLL = new HashMap<Object, Object>(16);
            tokenNuLL.put(StaticProperties.CODE, LoginStatus.LOGIN_FAILED.getCode());
            tokenNuLL.put(StaticProperties.MSG, LoginStatus.LOGIN_FAILED.getMsg());
            return tokenNuLL;
        }
        return null;
//        toDo 上传图片
    }

    /**
     * 提交退货申请
     * @return
     */
    @PostMapping("/state")
    public Map<String,Object> state(OmsOrderReturnApply omsOrderReturnApply,OmsOrderReturnReason omsOrderReturnReason,String token) throws Exception {
        if (!StringUtil.isEmpty(token)){
            Date dateNow = DateUtil.getDateNow();
            omsOrderReturnApply.setCreateTime(dateNow);
            omsOrderReturnReason.setCreateTime(dateNow);

            HashMap<String, Object> map = new HashMap<>();
            map.put("data", omsOrderReturnApply);

            Integer count = omsOrderReturnApplyService.save(omsOrderReturnApply);
            Integer count2 = omsOrderReturnReasonService.save(omsOrderReturnReason);
            if (count>0&&count2>0){
                map.put("i", count);
            }else {
                map.put("i", 0);

            }
            return map;
        }
        return null;
    }
















}
