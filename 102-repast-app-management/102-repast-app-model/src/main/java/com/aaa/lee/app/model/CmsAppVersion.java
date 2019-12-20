package com.aaa.lee.app.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "cms_app_version")
public class CmsAppVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 类型：0->餐饮
     */
    private Integer type;

    /**
     * 版本名称
     */
    private String name;

    /**
     * 版本描述
     */
    private String description;

    /**
     * 小程序模板ID
     */
    @Column(name = "wx_template_id")
    private String wxTemplateId;

    private Long price;

    /**
     * 说明
     */
    private String note;

    /**
     * 封面链接
     */
    private String image;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "update_time")
    private Date updateTime;

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
     * 获取类型：0->餐饮
     *
     * @return type - 类型：0->餐饮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置类型：0->餐饮
     *
     * @param type 类型：0->餐饮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 获取版本名称
     *
     * @return name - 版本名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置版本名称
     *
     * @param name 版本名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取版本描述
     *
     * @return description - 版本描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置版本描述
     *
     * @param description 版本描述
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取小程序模板ID
     *
     * @return wx_template_id - 小程序模板ID
     */
    public String getWxTemplateId() {
        return wxTemplateId;
    }

    /**
     * 设置小程序模板ID
     *
     * @param wxTemplateId 小程序模板ID
     */
    public void setWxTemplateId(String wxTemplateId) {
        this.wxTemplateId = wxTemplateId == null ? null : wxTemplateId.trim();
    }

    /**
     * @return price
     */
    public Long getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * 获取说明
     *
     * @return note - 说明
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置说明
     *
     * @param note 说明
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    /**
     * 获取封面链接
     *
     * @return image - 封面链接
     */
    public String getImage() {
        return image;
    }

    /**
     * 设置封面链接
     *
     * @param image 封面链接
     */
    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
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
     * @return update_time
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}