package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsCartItemMapper;
import com.aaa.lee.app.model.OmsCartItem;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.status.StatusEnum;
import com.aaa.lee.app.utils.JSONUtil;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 添加购物车的service层
 */
@Service
public class CartItemService extends BaseService<OmsCartItem> {

    @Autowired
    private OmsCartItemMapper omsCartItemMapper;

    @Override
    public Mapper<OmsCartItem> getMapper() {
        return omsCartItemMapper;
    }

    /**
     * 添加购物车
     *
     * @return
     */
    public Map<Object, Object> addCart(Map<Object, Object> omsCartItem, String token) {
        Map<Object, Object> mapResult = new HashMap<Object, Object>();
        //把添加到购物车的map信息转换成实体类类型。
        List<OmsCartItem> omsCartItems = JSONUtil.toList(JSONUtil.toJsonString(omsCartItem), OmsCartItem.class);
        try {
            for (OmsCartItem omsCartItem1 : omsCartItems) {
                //先查询库存数量
                Boolean aBoolean = this.selectSku(omsCartItem);
                //如果库存数量大于购买数量执行保存,否则说明库存不足
                if (aBoolean) {
                    Integer saveResult = super.save(omsCartItem1);
                    if (saveResult > 0) {
                        //大于0保存成功就返回成功信息。
                        mapResult.put(StaticProperties.CODE, LoginStatus.ADD_CART.getCode());
                        mapResult.put(StaticProperties.MSG, LoginStatus.ADD_CART.getMsg());
                        //添加购物车成功去库存表删除添加的数量
                    } else {
                        //保存失败返回信息
                        mapResult.put(StaticProperties.CODE, LoginStatus.ADD_NOT_CART.getCode());
                        mapResult.put(StaticProperties.MSG, LoginStatus.ADD_NOT_CART.getMsg());
                    }
                }else {
                    mapResult.put(StaticProperties.CODE, LoginStatus.SKU_NOT_CART.getCode());
                    mapResult.put(StaticProperties.MSG, LoginStatus.SKU_NOT_CART.getMsg());
                }
            }

        } catch (Exception e) {
            mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
            e.printStackTrace();
        }
        return mapResult;
    }

    /**
     * 根据商品的名称查询商品的库存数量
     *
     * @param omsCartItem
     * @return
     */
    private Boolean selectSku(Map<Object, Object> omsCartItem) {

        List<OmsCartItem> omsCartItems = JSONUtil.toList(JSONUtil.toJsonString(omsCartItem), OmsCartItem.class);
        for (OmsCartItem omsCartItem1 : omsCartItems) {
            //查询库存数量
            Integer skuResult = omsCartItemMapper.selectSku(omsCartItem1);
            //返回值大于0证明库存有数量
            if (skuResult > omsCartItem1.getQuantity()) {
                return true;
            }
        }
        return false;
    }

}
