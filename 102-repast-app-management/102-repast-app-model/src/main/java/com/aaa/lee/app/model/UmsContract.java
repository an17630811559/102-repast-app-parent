package com.aaa.lee.app.model;

import javax.persistence.*;

@Table(name = "ums_contract")
public class UmsContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 签订者ID
     */
    @Column(name = "owner_id")
    private Long ownerId;

    /**
     * 合同类型
     */
    private Integer type;

    /**
     * 合同模版ID
     */
    @Column(name = "template_id")
    private Long templateId;

    /**
     * json格式，具体格式跟合同模块对应
     */
    private String content;

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
     * 获取签订者ID
     *
     * @return owner_id - 签订者ID
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * 设置签订者ID
     *
     * @param ownerId 签订者ID
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取合同类型
     *
     * @return type - 合同类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置合同类型
     *
     * @param type 合同类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取合同模版ID
     *
     * @return template_id - 合同模版ID
     */
    public Long getTemplateId() {
        return templateId;
    }

    /**
     * 设置合同模版ID
     *
     * @param templateId 合同模版ID
     */
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取json格式，具体格式跟合同模块对应
     *
     * @return content - json格式，具体格式跟合同模块对应
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置json格式，具体格式跟合同模块对应
     *
     * @param content json格式，具体格式跟合同模块对应
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}