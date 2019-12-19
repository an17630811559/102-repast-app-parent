package com.aaa.lee.app.model;

import javax.persistence.*;
import java.util.Date;

@Table(name = "ums_shop_information")
public class UmsShopInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 店铺所有者ID
     */
    @Column(name = "owner_id")
    private Long ownerId;

    /**
     * 店铺名称
     */
    private String name;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String borough;

    /**
     * 地址
     */
    private String address;

    private String lng;

    private String lat;

    /**
     * 是否打烊（手动打烊标示）和营业时间一起使用
     */
    private Byte closed;

    /**
     * 字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割
     */
    @Column(name = "open_time")
    private String openTime;

    /**
     * 商家电话
     */
    private String phone;

    /**
     * 商家实景照片URL，json格式 {realimsg:['http://xxx','http://xxx']}
     */
    private String images;

    /**
     * 0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭
     */
    private Byte status;

    /**
     * 授权开始时间
     */
    @Column(name = "auth_start_time")
    private Date authStartTime;

    /**
     * 授权时长，单位是月
     */
    @Column(name = "auth_long")
    private Integer authLong;

    /**
     * 授权版本的ID
     */
    @Column(name = "template_id")
    private Integer templateId;

    /**
     * 营业执照图片链接
     */
    @Column(name = "business_license")
    private String businessLicense;

    /**
     * 食品安全许可证图片链接
     */
    @Column(name = "food_license")
    private String foodLicense;

    /**
     * 卫生许可证图片链接
     */
    @Column(name = "sanitation_license")
    private String sanitationLicense;

    /**
     * 量化考核图片链接
     */
    private String assess;

    /**
     * 合同ID
     */
    @Column(name = "contract_id")
    private Long contractId;

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
     * 获取店铺所有者ID
     *
     * @return owner_id - 店铺所有者ID
     */
    public Long getOwnerId() {
        return ownerId;
    }

    /**
     * 设置店铺所有者ID
     *
     * @param ownerId 店铺所有者ID
     */
    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    /**
     * 获取店铺名称
     *
     * @return name - 店铺名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置店铺名称
     *
     * @param name 店铺名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 获取区
     *
     * @return borough - 区
     */
    public String getBorough() {
        return borough;
    }

    /**
     * 设置区
     *
     * @param borough 区
     */
    public void setBorough(String borough) {
        this.borough = borough == null ? null : borough.trim();
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return lng
     */
    public String getLng() {
        return lng;
    }

    /**
     * @param lng
     */
    public void setLng(String lng) {
        this.lng = lng == null ? null : lng.trim();
    }

    /**
     * @return lat
     */
    public String getLat() {
        return lat;
    }

    /**
     * @param lat
     */
    public void setLat(String lat) {
        this.lat = lat == null ? null : lat.trim();
    }

    /**
     * 获取是否打烊（手动打烊标示）和营业时间一起使用
     *
     * @return closed - 是否打烊（手动打烊标示）和营业时间一起使用
     */
    public Byte getClosed() {
        return closed;
    }

    /**
     * 设置是否打烊（手动打烊标示）和营业时间一起使用
     *
     * @param closed 是否打烊（手动打烊标示）和营业时间一起使用
     */
    public void setClosed(Byte closed) {
        this.closed = closed;
    }

    /**
     * 获取字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割
     *
     * @return open_time - 字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割
     */
    public String getOpenTime() {
        return openTime;
    }

    /**
     * 设置字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割
     *
     * @param openTime 字符串，如：1-5|10:00-14:00，1-5|17:00-22:00，6-7|9:00-24:00  周和时间用“|”分割，周几到周几用“-”分割，多个设置用“，”分割
     */
    public void setOpenTime(String openTime) {
        this.openTime = openTime == null ? null : openTime.trim();
    }

    /**
     * 获取商家电话
     *
     * @return phone - 商家电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置商家电话
     *
     * @param phone 商家电话
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 获取商家实景照片URL，json格式 {realimsg:['http://xxx','http://xxx']}
     *
     * @return images - 商家实景照片URL，json格式 {realimsg:['http://xxx','http://xxx']}
     */
    public String getImages() {
        return images;
    }

    /**
     * 设置商家实景照片URL，json格式 {realimsg:['http://xxx','http://xxx']}
     *
     * @param images 商家实景照片URL，json格式 {realimsg:['http://xxx','http://xxx']}
     */
    public void setImages(String images) {
        this.images = images == null ? null : images.trim();
    }

    /**
     * 获取0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭
     *
     * @return status - 0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭
     *
     * @param status 0：冻结状态，1：正常，2：违规关闭，3：店铺到期关闭
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * 获取授权开始时间
     *
     * @return auth_start_time - 授权开始时间
     */
    public Date getAuthStartTime() {
        return authStartTime;
    }

    /**
     * 设置授权开始时间
     *
     * @param authStartTime 授权开始时间
     */
    public void setAuthStartTime(Date authStartTime) {
        this.authStartTime = authStartTime;
    }

    /**
     * 获取授权时长，单位是月
     *
     * @return auth_long - 授权时长，单位是月
     */
    public Integer getAuthLong() {
        return authLong;
    }

    /**
     * 设置授权时长，单位是月
     *
     * @param authLong 授权时长，单位是月
     */
    public void setAuthLong(Integer authLong) {
        this.authLong = authLong;
    }

    /**
     * 获取授权版本的ID
     *
     * @return template_id - 授权版本的ID
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置授权版本的ID
     *
     * @param templateId 授权版本的ID
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取营业执照图片链接
     *
     * @return business_license - 营业执照图片链接
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照图片链接
     *
     * @param businessLicense 营业执照图片链接
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense == null ? null : businessLicense.trim();
    }

    /**
     * 获取食品安全许可证图片链接
     *
     * @return food_license - 食品安全许可证图片链接
     */
    public String getFoodLicense() {
        return foodLicense;
    }

    /**
     * 设置食品安全许可证图片链接
     *
     * @param foodLicense 食品安全许可证图片链接
     */
    public void setFoodLicense(String foodLicense) {
        this.foodLicense = foodLicense == null ? null : foodLicense.trim();
    }

    /**
     * 获取卫生许可证图片链接
     *
     * @return sanitation_license - 卫生许可证图片链接
     */
    public String getSanitationLicense() {
        return sanitationLicense;
    }

    /**
     * 设置卫生许可证图片链接
     *
     * @param sanitationLicense 卫生许可证图片链接
     */
    public void setSanitationLicense(String sanitationLicense) {
        this.sanitationLicense = sanitationLicense == null ? null : sanitationLicense.trim();
    }

    /**
     * 获取量化考核图片链接
     *
     * @return assess - 量化考核图片链接
     */
    public String getAssess() {
        return assess;
    }

    /**
     * 设置量化考核图片链接
     *
     * @param assess 量化考核图片链接
     */
    public void setAssess(String assess) {
        this.assess = assess == null ? null : assess.trim();
    }

    /**
     * 获取合同ID
     *
     * @return contract_id - 合同ID
     */
    public Long getContractId() {
        return contractId;
    }

    /**
     * 设置合同ID
     *
     * @param contractId 合同ID
     */
    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }
}