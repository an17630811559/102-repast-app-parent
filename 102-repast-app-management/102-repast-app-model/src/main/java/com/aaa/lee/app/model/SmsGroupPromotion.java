package com.aaa.lee.app.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "sms_group_promotion")
public class SmsGroupPromotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Long shopId;

    private String title;

    /**
     * 团购活动的图片
     */
    private String images;

    /**
     * 开始日期
     */
    @Column(name = "start_date")
    private Date startDate;

    /**
     * 结束日期
     */
    @Column(name = "end_date")
    private Date endDate;

    /**
     * 上下线状态
     */
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * n人团
     */
    private Byte type;

    /**
     * 未成团，自动延期n天
     */
    @Column(name = "auto_delay")
    private Integer autoDelay;

    /**
     * 团购价格
     */
    private Long price;

    /**
     * 原价
     */
    @Column(name = "original_price")
    private Long originalPrice;

    /**
     * 1是自动成团，拼团时间到，不管人数是否到，自动开团
     */
    @Column(name = "auto_open")
    private Byte autoOpen;

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
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取团购活动的图片
     *
     * @return images - 团购活动的图片
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置团购活动的图片
     *
     * @param images 团购活动的图片
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    /**
     * 获取开始日期
     *
     * @return start_date - 开始日期
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * 设置开始日期
     *
     * @param startDate 开始日期
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * 获取结束日期
     *
     * @return end_date - 结束日期
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * 设置结束日期
     *
     * @param endDate 结束日期
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * 获取上下线状态
     *
     * @return status - 上下线状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置上下线状态
     *
     * @param status 上下线状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 获取n人团
     *
     * @return type - n人团
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置n人团
     *
     * @param type n人团
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取未成团，自动延期n天
     *
     * @return auto_delay - 未成团，自动延期n天
     */
    public Integer getAutoDelay() {
        return autoDelay;
    }

    /**
     * 设置未成团，自动延期n天
     *
     * @param autoDelay 未成团，自动延期n天
     */
    public void setAutoDelay(Integer autoDelay) {
        this.autoDelay = autoDelay;
    }

    /**
     * 获取团购价格
     *
     * @return price - 团购价格
     */
    public Long getPrice() {
        return price;
    }

    /**
     * 设置团购价格
     *
     * @param price 团购价格
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取原价
     *
     * @return original_price - 原价
     */
    public Long getOriginalPrice() {
        return originalPrice;
    }

    /**
     * 设置原价
     *
     * @param originalPrice 原价
     */
    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * 获取1是自动成团，拼团时间到，不管人数是否到，自动开团
     *
     * @return auto_open - 1是自动成团，拼团时间到，不管人数是否到，自动开团
     */
    public Byte getAutoOpen() {
        return autoOpen;
    }

    /**
     * 设置1是自动成团，拼团时间到，不管人数是否到，自动开团
     *
     * @param autoOpen 1是自动成团，拼团时间到，不管人数是否到，自动开团
     */
    public void setAutoOpen(Byte autoOpen) {
        this.autoOpen = autoOpen;
    }
}