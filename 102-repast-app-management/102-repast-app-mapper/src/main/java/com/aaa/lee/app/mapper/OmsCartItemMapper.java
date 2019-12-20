package com.aaa.lee.app.mapper;

import com.aaa.lee.app.model.OmsCartItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.Map;

@Repository
public interface OmsCartItemMapper extends Mapper<OmsCartItem> {


     Integer selectSku(OmsCartItem omsCartItem);

}