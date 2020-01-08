package com.aaa.lee.app.mapper;

import com.aaa.lee.app.model.OmsCartItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
public interface OmsCartItemMapper extends Mapper<OmsCartItem> {

    /**
     * 修改购物车的数量
     * @param omsCartItem
     * @return
     */
    Integer  updateCartQuantity(OmsCartItem omsCartItem);

}