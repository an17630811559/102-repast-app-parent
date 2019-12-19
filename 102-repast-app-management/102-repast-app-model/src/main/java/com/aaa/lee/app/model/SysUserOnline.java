package com.aaa.lee.app.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_user_online")
public class SysUserOnline {
    /**
     * 用户会话id
     */
    @Id
    @Column(name = "sessionId")
    private String sessionid;

    /**
     * 登录账号
     */
    @Column(name = "login_name")
    private String loginName;

    /**
     * 部门名称
     */
    @Column(name = "dept_name")
    private String deptName;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    @Column(name = "login_location")
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 在线状态on_line在线off_line离线
     */
    private String status;

    /**
     * session创建时间
     */
    @Column(name = "start_timestamp")
    private Date startTimestamp;

    /**
     * session最后访问时间
     */
    @Column(name = "last_access_time")
    private Date lastAccessTime;

    /**
     * 超时时间，单位为分钟
     */
    @Column(name = "expire_time")
    private Integer expireTime;

    /**
     * 获取用户会话id
     *
     * @return sessionId - 用户会话id
     */
    public String getSessionid() {
        return sessionid;
    }

    /**
     * 设置用户会话id
     *
     * @param sessionid 用户会话id
     */
    public void setSessionid(String sessionid) {
        this.sessionid = sessionid == null ? null : sessionid.trim();
    }

    /**
     * 获取登录账号
     *
     * @return login_name - 登录账号
     */
    public String getLoginName() {
        return loginName;
    }

    /**
     * 设置登录账号
     *
     * @param loginName 登录账号
     */
    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    /**
     * 获取部门名称
     *
     * @return dept_name - 部门名称
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * 设置部门名称
     *
     * @param deptName 部门名称
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    /**
     * 获取登录IP地址
     *
     * @return ipaddr - 登录IP地址
     */
    public String getIpaddr() {
        return ipaddr;
    }

    /**
     * 设置登录IP地址
     *
     * @param ipaddr 登录IP地址
     */
    public void setIpaddr(String ipaddr) {
        this.ipaddr = ipaddr == null ? null : ipaddr.trim();
    }

    /**
     * 获取登录地点
     *
     * @return login_location - 登录地点
     */
    public String getLoginLocation() {
        return loginLocation;
    }

    /**
     * 设置登录地点
     *
     * @param loginLocation 登录地点
     */
    public void setLoginLocation(String loginLocation) {
        this.loginLocation = loginLocation == null ? null : loginLocation.trim();
    }

    /**
     * 获取浏览器类型
     *
     * @return browser - 浏览器类型
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 设置浏览器类型
     *
     * @param browser 浏览器类型
     */
    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    /**
     * 获取操作系统
     *
     * @return os - 操作系统
     */
    public String getOs() {
        return os;
    }

    /**
     * 设置操作系统
     *
     * @param os 操作系统
     */
    public void setOs(String os) {
        this.os = os == null ? null : os.trim();
    }

    /**
     * 获取在线状态on_line在线off_line离线
     *
     * @return status - 在线状态on_line在线off_line离线
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置在线状态on_line在线off_line离线
     *
     * @param status 在线状态on_line在线off_line离线
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取session创建时间
     *
     * @return start_timestamp - session创建时间
     */
    public Date getStartTimestamp() {
        return startTimestamp;
    }

    /**
     * 设置session创建时间
     *
     * @param startTimestamp session创建时间
     */
    public void setStartTimestamp(Date startTimestamp) {
        this.startTimestamp = startTimestamp;
    }

    /**
     * 获取session最后访问时间
     *
     * @return last_access_time - session最后访问时间
     */
    public Date getLastAccessTime() {
        return lastAccessTime;
    }

    /**
     * 设置session最后访问时间
     *
     * @param lastAccessTime session最后访问时间
     */
    public void setLastAccessTime(Date lastAccessTime) {
        this.lastAccessTime = lastAccessTime;
    }

    /**
     * 获取超时时间，单位为分钟
     *
     * @return expire_time - 超时时间，单位为分钟
     */
    public Integer getExpireTime() {
        return expireTime;
    }

    /**
     * 设置超时时间，单位为分钟
     *
     * @param expireTime 超时时间，单位为分钟
     */
    public void setExpireTime(Integer expireTime) {
        this.expireTime = expireTime;
    }
}