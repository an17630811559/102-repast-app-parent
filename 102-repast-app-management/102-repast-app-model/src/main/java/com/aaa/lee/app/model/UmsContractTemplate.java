package com.aaa.lee.app.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "ums_contract_template")
public class UmsContractTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 模版内容
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
     * 获取模版内容
     *
     * @return content - 模版内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置模版内容
     *
     * @param content 模版内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}