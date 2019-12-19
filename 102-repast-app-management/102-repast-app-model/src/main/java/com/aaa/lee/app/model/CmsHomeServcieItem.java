package com.aaa.lee.app.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "cms_home_servcie_item")
public class CmsHomeServcieItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private String description;

    /**
     * 图标的名字，后续屏幕适配名字后面加X数字来拉去不同的图片
     */
    private String icon;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取图标的名字，后续屏幕适配名字后面加X数字来拉去不同的图片
     *
     * @return icon - 图标的名字，后续屏幕适配名字后面加X数字来拉去不同的图片
     */
    public String getIcon() {
        return icon;
    }

    /**
     * 设置图标的名字，后续屏幕适配名字后面加X数字来拉去不同的图片
     *
     * @param icon 图标的名字，后续屏幕适配名字后面加X数字来拉去不同的图片
     */
    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }
}