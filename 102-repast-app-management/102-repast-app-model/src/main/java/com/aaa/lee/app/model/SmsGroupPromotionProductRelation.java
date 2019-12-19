package com.aaa.lee.app.model;

import javax.persistence.*;

@Table(name = "sms_group_promotion_product_relation")
public class SmsGroupPromotionProductRelation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 团购活动id
     */
    @Column(name = "group_promotion_id")
    private Integer groupPromotionId;

    /**
     * 商品ID
     */
    @Column(name = "product_id")
    private Integer productId;

    /**
     * 产品数量
     */
    private Integer count;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return shop_id
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * @param shopId
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取团购活动id
     *
     * @return group_promotion_id - 团购活动id
     */
    public Integer getGroupPromotionId() {
        return groupPromotionId;
    }

    /**
     * 设置团购活动id
     *
     * @param groupPromotionId 团购活动id
     */
    public void setGroupPromotionId(Integer groupPromotionId) {
        this.groupPromotionId = groupPromotionId;
    }

    /**
     * 获取商品ID
     *
     * @return product_id - 商品ID
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置商品ID
     *
     * @param productId 商品ID
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取产品数量
     *
     * @return count - 产品数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置产品数量
     *
     * @param count 产品数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }
}