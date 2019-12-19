package com.aaa.lee.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Table(name = "ums_shop_questionnaire")
public class UmsShopQuestionnaire {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    /**
     * 问卷问题
     */
    private String question;

    /**
     * 业务点：1. 用户反馈的问卷
     */
    private Integer type;

    private Integer sort;

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
     * 获取问卷问题
     *
     * @return question - 问卷问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 设置问卷问题
     *
     * @param question 问卷问题
     */
    public void setQuestion(String question) {
        this.question = question == null ? null : question.trim();
    }

    /**
     * 获取业务点：1. 用户反馈的问卷
     *
     * @return type - 业务点：1. 用户反馈的问卷
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置业务点：1. 用户反馈的问卷
     *
     * @param type 业务点：1. 用户反馈的问卷
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return sort
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}