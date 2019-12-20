package com.aaa.lee.app.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "oms_order_return_reason")
public class OmsOrderReturnReason {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 退货类型
     */
    private String name;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 状态：0->不启用；1->启用
     */
    private Integer status;

    /**
     * 添加时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取店铺ID
     *
     * @return shop_id - 店铺ID
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * 设置店铺ID
     *
     * @param shopId 店铺ID
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取退货类型
     *
     * @return name - 退货类型
     */
    public String getName() {
        return name;
    }

    /**
     * 设置退货类型
     *
     * @param name 退货类型
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取排序
     *
     * @return sort - 排序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置排序
     *
     * @param sort 排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取状态：0->不启用；1->启用
     *
     * @return status - 状态：0->不启用；1->启用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态：0->不启用；1->启用
     *
     * @param status 状态：0->不启用；1->启用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取添加时间
     *
     * @return create_time - 添加时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置添加时间
     *
     * @param createTime 添加时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}