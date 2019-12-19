package com.aaa.lee.app.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "ums_message")
public class UmsMessage {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "shop_id")
    private Integer shopId;

    /**
     * 消息类型
     */
    private Integer type;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 该字段不为null 时为接受消息的用户ID
     */
    @Column(name = "send_to")
    private Long sendTo;

    /**
     * 1. 小程序消息 2. 后天管理系统消息
     */
    private Integer channel;

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
    public Integer getShopId() {
        return shopId;
    }

    /**
     * @param shopId
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * 获取消息类型
     *
     * @return type - 消息类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置消息类型
     *
     * @param type 消息类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取消息标题
     *
     * @return title - 消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置消息标题
     *
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取摘要
     *
     * @return summary - 摘要
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 设置摘要
     *
     * @param summary 摘要
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 获取消息内容
     *
     * @return content - 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置消息内容
     *
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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
     * 获取该字段不为null 时为接受消息的用户ID
     *
     * @return send_to - 该字段不为null 时为接受消息的用户ID
     */
    public Long getSendTo() {
        return sendTo;
    }

    /**
     * 设置该字段不为null 时为接受消息的用户ID
     *
     * @param sendTo 该字段不为null 时为接受消息的用户ID
     */
    public void setSendTo(Long sendTo) {
        this.sendTo = sendTo;
    }

    /**
     * 获取1. 小程序消息 2. 后天管理系统消息
     *
     * @return channel - 1. 小程序消息 2. 后天管理系统消息
     */
    public Integer getChannel() {
        return channel;
    }

    /**
     * 设置1. 小程序消息 2. 后天管理系统消息
     *
     * @param channel 1. 小程序消息 2. 后天管理系统消息
     */
    public void setChannel(Integer channel) {
        this.channel = channel;
    }
}