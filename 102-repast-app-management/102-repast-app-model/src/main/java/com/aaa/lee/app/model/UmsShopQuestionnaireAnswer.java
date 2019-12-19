package com.aaa.lee.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ums_shop_questionnaire_answer")
public class UmsShopQuestionnaireAnswer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 问卷ID
     */
    @Column(name = "question_id")
    private Long questionId;

    private String title;

    /**
     * 问卷的回答
     */
    private String answer;

    /**
     * 会员ID
     */
    @Column(name = "member_id")
    private Long memberId;

    /**
     * 店铺ID
     */
    @Column(name = "shop_id")
    private Long shopId;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 0-5星
     */
    private Byte star;

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
     * 获取问卷ID
     *
     * @return question_id - 问卷ID
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * 设置问卷ID
     *
     * @param questionId 问卷ID
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
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
     * 获取问卷的回答
     *
     * @return answer - 问卷的回答
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 设置问卷的回答
     *
     * @param answer 问卷的回答
     */
    public void setAnswer(String answer) {
        this.answer = answer == null ? null : answer.trim();
    }

    /**
     * 获取会员ID
     *
     * @return member_id - 会员ID
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * 设置会员ID
     *
     * @param memberId 会员ID
     */
    public void setMemberId(Long memberId) {
        this.memberId = memberId;
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
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取0-5星
     *
     * @return star - 0-5星
     */
    public Byte getStar() {
        return star;
    }

    /**
     * 设置0-5星
     *
     * @param star 0-5星
     */
    public void setStar(Byte star) {
        this.star = star;
    }
}