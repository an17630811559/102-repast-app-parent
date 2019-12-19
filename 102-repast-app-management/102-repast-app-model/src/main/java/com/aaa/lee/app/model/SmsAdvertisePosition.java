package com.aaa.lee.app.model;

import javax.persistence.*;

@Table(name = "sms_advertise_position")
public class SmsAdvertisePosition {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 业务类型，餐饮小程序0
     */
    private Integer type;

    /**
     * 广告位置名称
     */
    private String name;

    /**
     * 广告位置名称
     */
    private String descrition;

    /**
     * 该位置最多几个广告
     */
    @Column(name = "max_count")
    private Integer maxCount;

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
     * 获取业务类型，餐饮小程序0
     *
     * @return type - 业务类型，餐饮小程序0
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置业务类型，餐饮小程序0
     *
     * @param type 业务类型，餐饮小程序0
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取广告位置名称
     *
     * @return name - 广告位置名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置广告位置名称
     *
     * @param name 广告位置名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取广告位置名称
     *
     * @return descrition - 广告位置名称
     */
    public String getDescrition() {
        return descrition;
    }

    /**
     * 设置广告位置名称
     *
     * @param descrition 广告位置名称
     */
    public void setDescrition(String descrition) {
        this.descrition = descrition == null ? null : descrition.trim();
    }

    /**
     * 获取该位置最多几个广告
     *
     * @return max_count - 该位置最多几个广告
     */
    public Integer getMaxCount() {
        return maxCount;
    }

    /**
     * 设置该位置最多几个广告
     *
     * @param maxCount 该位置最多几个广告
     */
    public void setMaxCount(Integer maxCount) {
        this.maxCount = maxCount;
    }
}