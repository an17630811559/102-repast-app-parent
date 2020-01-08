package com.aaa.lee.app.service;

import com.aaa.lee.app.base.BaseService;
import com.aaa.lee.app.mapper.OmsCartItemMapper;
import com.aaa.lee.app.model.OmsCartItem;
import com.aaa.lee.app.staticproperties.StaticProperties;
import com.aaa.lee.app.status.LoginStatus;
import com.aaa.lee.app.status.StatusEnum;
import com.aaa.lee.app.util.RestUtils;
import com.aaa.lee.app.utils.BigDecimalUtil;
import com.aaa.lee.app.utils.DateUtil;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;


import java.util.*;

/**
 * 添加购物车的service层
 */
@Service
@Transactional
public class CartItemService extends BaseService<OmsCartItem> {

    @Autowired
    private RestUtils restUtils;

    @Autowired
    private OmsCartItemMapper omsCartItemMapper;

    @Override
    public Mapper<OmsCartItem> getMapper() {
        return omsCartItemMapper;
    }


    /**
     * 添加购物车操作
     * 成功添加后减少库存
     * 如果库存不足就添加不了
     *
     * @param json
     * @param token
     * @param
     * @return
     */
    public Map<Object, Object> addCart(String json, String token) {
        Map<Object, Object> mapResult = new HashMap<Object, Object>();
        //把添加到购物车的map信息转换成list
        Map jsonObject = JSON.parseObject(json);
        OmsCartItem omsCartItem = new OmsCartItem();
        omsCartItem.setProductId(null == jsonObject.get("productId") ? null : Long.valueOf(jsonObject.get("productId").toString()));
        omsCartItem.setProductSkuId(null == jsonObject.get("productSkuId") ? null : Long.valueOf(jsonObject.get("productSkuId").toString()));
        omsCartItem.setMemberId(null == jsonObject.get("memberId") ? null : Long.valueOf(jsonObject.get("memberId").toString()));
        omsCartItem.setShopId(null == jsonObject.get("shopId") ? null : Long.valueOf(jsonObject.get("shopId").toString()));
        omsCartItem.setQuantity(null == jsonObject.get("quantity") ? null : Integer.valueOf(jsonObject.get("quantity").toString()));
        omsCartItem.setPrice(null == jsonObject.get("price") ? null : BigDecimalUtil.getBigDecimal(jsonObject.get("price")));
        omsCartItem.setSp1(null == jsonObject.get("sp1") ? null : jsonObject.get("sp1").toString());
        omsCartItem.setSp2(null == jsonObject.get("sp2") ? null : jsonObject.get("sp2").toString());
        omsCartItem.setSp3(null == jsonObject.get("sp3") ? null : jsonObject.get("sp3").toString());
        omsCartItem.setProductPic(null == jsonObject.get("productPic") ? null : jsonObject.get("productPic").toString());
        omsCartItem.setProductName(null == jsonObject.get("productName") ? null : jsonObject.get("productName").toString());
        omsCartItem.setProductSubTitle(null == jsonObject.get("productSubTitle") ? null : jsonObject.get("productSubTitle").toString());
        omsCartItem.setProductSkuCode(null == jsonObject.get("productSkuCode") ? null : jsonObject.get("productSkuCode").toString());
        omsCartItem.setMemberNickname(null == jsonObject.get("memberNickname") ? null : jsonObject.get("memberNickname").toString());
        omsCartItem.setCreateDate(DateUtil.getDateNow());
        omsCartItem.setDeleteStatus(0);
        omsCartItem.setProductCategoryId(null == jsonObject.get("productCategoryId") ? null : Long.valueOf(jsonObject.get("productCategoryId").toString()));
        omsCartItem.setProductBrand(null == jsonObject.get("productBrand") ? null : jsonObject.get("productBrand").toString());
        omsCartItem.setProductSn(null == jsonObject.get("productSn") ? null : jsonObject.get("productSn").toString());
        omsCartItem.setProductAttr(null == jsonObject.get("productAttr") ? null : jsonObject.get("productAttr").toString());
        //查询库存数量
        //Integer stock = restUtils.selectSku(omsCartItem.getProductId());
        //模拟库存数量
        Integer stock = 20;
        try {
            //如果库存数大于购买数量就保存到购物车,否则就提示库存不足
            if (stock >= omsCartItem.getQuantity()) {
                Integer saveResult = super.save(omsCartItem);
                if (saveResult > 0) {
                    //大于0保存成功就返回成功信息。
                    mapResult.put(StaticProperties.CODE, LoginStatus.ADD_CART.getCode());
                    mapResult.put(StaticProperties.MSG, LoginStatus.ADD_CART.getMsg());
                    //添加购物车成功去库存表减少库存
                } else {
                    //保存失败返回信息
                    mapResult.put(StaticProperties.CODE, LoginStatus.ADD_NOT_CART.getCode());
                    mapResult.put(StaticProperties.MSG, LoginStatus.ADD_NOT_CART.getMsg());
                }

            } else {
                mapResult.put(StaticProperties.CODE, LoginStatus.SKU_NOT_CART.getCode());
                mapResult.put(StaticProperties.MSG, LoginStatus.SKU_NOT_CART.getMsg());
            }
        } catch (Exception e) {
            mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
            e.printStackTrace();
        }
        return mapResult;
    }

    /**
     * 减少购物车中商品的数量
     *
     * @param id
     * @param token
     * @param quantity
     * @return
     */
    public Map<Object, Object> deleteCartQuantity(Long id, String token, Integer quantity) {
        Map<Object, Object> mapResult = new HashMap<Object, Object>();
        OmsCartItem omsCartItem = new OmsCartItem();
        try {
            //根据 id 查询购物车中的商品
            OmsCartItem omsCartItem1 = super.selectById(id);
            //如果商品不为空，证明有数据
            if (null != omsCartItem1) {
                //把传过来的id和quantity set到对象中
                omsCartItem.setId(id);
                omsCartItem.setQuantity(quantity);
                //修改购物车中的数量
                Integer update = omsCartItemMapper.updateCartQuantity(omsCartItem);
                //如果update大于0证明修该成功。
                if (update > 0) {
                    //用购物车的数量减去传过来的数量，就是减少的数量
                    //也就是库存添加的数量
                    Integer shuliang = omsCartItem1.getQuantity() - quantity;
                    //把要填加的数量set到实体类中
                    omsCartItem1.setQuantity(shuliang);
                    //修该成功，就调用添加库存的接口
                    //修该成功之后,添加库存  添加的数量就是  shuliang
                    boolean b = restUtils.updateAddSku(omsCartItem1);
                    //返回值为true 证明添加的库存成功
                    if (b) {
                        mapResult.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
                        mapResult.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());
                        //否则失败
                    } else {
                        mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
                        mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
                    }

                } else {
                    //否则修改失败
                    mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
                    mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
                }
            } else {
                //否则购物车中没有这条数据
                mapResult.put(StaticProperties.CODE, LoginStatus.CART_NOT_SHUJU.getCode());
                mapResult.put(StaticProperties.MSG, LoginStatus.CART_NOT_SHUJU.getMsg());
            }
        } catch (Exception e) {
            mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
            e.printStackTrace();
        }

        return mapResult;
    }

    /**
     * 添加购物车中商品的数量
     *
     * @param id
     * @param token
     * @param quantity
     * @return
     */
    public Map<Object, Object> addCartQuantity(Long id, String token, Integer quantity) {
        Map<Object, Object> mapResult = new HashMap<Object, Object>();
        OmsCartItem omsCartItem = new OmsCartItem();
        try {
            //根据 id 查询购物车中的商品
            OmsCartItem omsCartItem1 = super.selectById(id);
            //如果商品不为空
            if (null != omsCartItem1) {
                //传过来的值减去购物车商品中的值就是库存要减少的数量
                Integer shuliang = quantity - omsCartItem1.getQuantity();
                //远程调用 查询商品的库存
                Integer stock = restUtils.selectSku(id);
                //如果库存数量大于要减少的数量,才进行修改购物车中的数量和减少库存
                if (stock > shuliang) {
                    omsCartItem.setId(id);
                    omsCartItem.setQuantity(quantity);
                    //修改购物车中的数量
                    Integer update = omsCartItemMapper.updateCartQuantity(omsCartItem);
                    //说明修改成功
                    if (update > 0) {
                        //把修改的减少的库存熟练添加到对象中。
                        omsCartItem1.setQuantity(shuliang);
                        //修该成功之后,减少库存  减少的数量就是  shuliang
                        boolean b = restUtils.updatedeleteSku(omsCartItem1);
                        //返回值为true 证明减少的库存成功
                        if (b) {
                            mapResult.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
                            mapResult.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());
                            //否则失败
                        } else {
                            mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
                            mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
                        }
                    } else {
                        //否则修改失败
                        mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
                        mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
                    }
                } else {
                    //否则库存不足
                    mapResult.put(StaticProperties.CODE, LoginStatus.SKU_NOT_CART.getCode());
                    mapResult.put(StaticProperties.MSG, LoginStatus.SKU_NOT_CART.getMsg());
                }
            } else {
                //否则购物车中没有这条数据
                mapResult.put(StaticProperties.CODE, LoginStatus.CART_NOT_SHUJU.getCode());
                mapResult.put(StaticProperties.MSG, LoginStatus.CART_NOT_SHUJU.getMsg());
            }
        } catch (Exception e) {
            mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
            e.printStackTrace();

        }

        return mapResult;
    }

    /**
     * 清空购物车
     *
     * @param token
     * @param omsCartItems
     * @return
     */
    public Map<Object, Object> deleteAllCart(String token, List<OmsCartItem> omsCartItems) {
        Map<Object, Object> mapResult = new HashMap<Object, Object>();
        List<OmsCartItem> list = new ArrayList<OmsCartItem>();
        //循环遍历出购物车表的信息
        for (OmsCartItem ll : omsCartItems) {
            //如果修改时间为空的话，证明定时器还没有触发，库存还没有减少。
            if (null == ll.getModifyDate()) {
                ll.setDeleteStatus(1);
                int i = omsCartItemMapper.updateByPrimaryKeySelective(ll);
                //如果i大于0证明删除成功
                if (i > 0) {
                    list.add(ll);
                }
            }
        }
        //调用方法，添加库存
        boolean b = restUtils.deleteAllCart(list);
        if (b) {
            mapResult.put(StaticProperties.CODE, StatusEnum.SUCCESS.getCode());
            mapResult.put(StaticProperties.MSG, StatusEnum.SUCCESS.getMsg());
        } else {
            mapResult.put(StaticProperties.CODE, StatusEnum.FAILED.getCode());
            mapResult.put(StaticProperties.MSG, StatusEnum.FAILED.getMsg());
        }

        return mapResult;
    }


}
