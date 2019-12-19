package com.aaa.lee.app.model;

import javax.persistence.*;

@Table(name = "ums_integration_grant_setting")
public class UmsIntegrationGrantSetting {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 每一元需要抵扣的积分数量
     */
    @Column(name = "deduction_per_amount")
    private Integer deductionPerAmount;

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
     * 获取每一元需要抵扣的积分数量
     *
     * @return deduction_per_amount - 每一元需要抵扣的积分数量
     */
    public Integer getDeductionPerAmount() {
        return deductionPerAmount;
    }

    /**
     * 设置每一元需要抵扣的积分数量
     *
     * @param deductionPerAmount 每一元需要抵扣的积分数量
     */
    public void setDeductionPerAmount(Integer deductionPerAmount) {
        this.deductionPerAmount = deductionPerAmount;
    }
}