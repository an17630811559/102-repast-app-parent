package com.aaa.lee.app.base;

import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.status.StatusEnum;
import org.springframework.stereotype.Controller;

/**
 * @Company AAA软件教育
 * @Author Seven Lee
 * @Date Create in 2019/12/18 16:09
 * @Description
 *      统一使用该controller返回
 *      也就是说以后所有的controller都必须要继承BaseController
 **/
@Controller
public class BaseController {

    /**
     * @author Seven Lee
     * @description
     *      统一返回值，登录成功，使用系统消息返回
     * @param []
     * @date 2019/12/18
     * @return com.aaa.lee.app.base.ResultData
     * @throws 
    **/
    protected ResultData success() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      统一返回值，登录成功，自定义返回消息
     * @param []
     * @date 2019/12/18
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success(String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      统一返回值，登录成功，使用系统消息返回并返回数据
     * @param []
     * @date 2019/12/18
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success(Object data) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(LoginStatus.LOGIN_SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      统一返回值，登录成功，自定义返回消息并且返回结果
     * @param []
     * @date 2019/12/18
     * @return com.aaa.lee.app.base.ResultData
     * @throws
     **/
    protected ResultData success(Object data, String msg) {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }

    /**
     * @author Seven Lee
     * @description
     *      登录失败，返回系统消息
     * @param []
     * @date 2019/12/18
     * @return com.aaa.lee.app.base.ResultData
     * @throws
    **/
    protected ResultData failed() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.LOGIN_FAILED.getCode());
        resultData.setMsg(LoginStatus.LOGIN_FAILED.getMsg());
        return resultData;
    }

    /**
     * 添加购物车成功
     * @return
     */
    protected ResultData addCart() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.ADD_CART.getCode());
        resultData.setMsg(LoginStatus.ADD_CART.getMsg());
        return resultData;
    }
    /**
     * 商品库存不足
     * @return
     */
    protected ResultData productSku() {
        ResultData resultData = new ResultData();
        resultData.setCode(LoginStatus.SKU_NOT_CART.getCode());
        resultData.setMsg(LoginStatus.SKU_NOT_CART.getMsg());
        return resultData;
    }
    /**
     * 操作成功
     * @return
     */
    protected ResultData caozuo() {
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        return resultData;
    }
    /**
     * 操作失败
     * @return
     */
    protected ResultData shibai() {
        ResultData resultData = new ResultData();
        resultData.setCode(StatusEnum.FAILED.getCode());
        resultData.setMsg(StatusEnum.FAILED.getMsg());
        return resultData;
    }

    // TODO 暂时未完成，需要什么方法自己添加



    private ResultData resultData = new ResultData();
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功，返回系统信息
     * @Param  * @param
     * @Return com.aaa.lee.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        return resultData;
    }
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功返回自定义信息
     * @Param  * @param msg
     * @Return com.aaa.lee.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(String msg){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(msg);
        return resultData;
    }
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功，返回系统信息，自定义数据
     * @Param  * @param data
     * @Return com.aaa.lee.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(Object data){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(StatusEnum.SUCCESS.getMsg());
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author Zhang Lee
     * @Description
     *      操作成功，返回自定义信息，自定义数据
     * @Param  * @param msg
     * @param data
     * @Return com.aaa.lee.app.base.ResultData
     * @Date 2019/11/23
     */
    protected ResultData operateSuccess(String msg,Object data){
        resultData.setCode(StatusEnum.SUCCESS.getCode());
        resultData.setMsg(msg);
        resultData.setData(data);
        return resultData;
    }
    /**
     * @Author Lee
     * @Description
     *      操作失败，返回系统消息
     * @Param  * @param
     * @Return com.aaa.lee.app.base.ResultData
     * @Date 2019/11/21
     */
    protected ResultData operateFailed(){
        resultData.setCode(StatusEnum.FAILED.getCode());
        resultData.setMsg(StatusEnum.FAILED.getMsg());
        return resultData;
    }

    /**
     * @Author Zhang Wei
     * @Description
     *      操作失败，返回自定义消息
     * @Param  * @param
     * @Return com.aaa.lee.app.base.ResultData
     * @Date 2019/11/21
     */
    protected ResultData operateFailed(String msg){
        resultData.setCode(StatusEnum.FAILED.getCode());
        resultData.setMsg(msg);
        return resultData;
    }


}
