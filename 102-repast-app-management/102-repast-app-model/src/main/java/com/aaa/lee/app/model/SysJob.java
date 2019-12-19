package com.aaa.lee.app.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_job")
public class SysJob {
    /**
     * 任务ID
     */
    @Id
    @Column(name = "job_id")
    private Integer jobId;

    /**
     * 任务名称
     */
    @Id
    @Column(name = "job_name")
    private String jobName;

    /**
     * 任务组名
     */
    @Id
    @Column(name = "job_group")
    private String jobGroup;

    /**
     * 任务方法
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * 方法参数
     */
    @Column(name = "method_params")
    private String methodParams;

    /**
     * cron执行表达式
     */
    @Column(name = "cron_expression")
    private String cronExpression;

    /**
     * 计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     */
    @Column(name = "misfire_policy")
    private String misfirePolicy;

    /**
     * 状态（0正常 1暂停）
     */
    private String status;

    /**
     * 创建者
     */
    @Column(name = "create_by")
    private String createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 更新者
     */
    @Column(name = "update_by")
    private String updateBy;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remark;

    /**
     * 获取任务ID
     *
     * @return job_id - 任务ID
     */
    public Integer getJobId() {
        return jobId;
    }

    /**
     * 设置任务ID
     *
     * @param jobId 任务ID
     */
    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    /**
     * 获取任务名称
     *
     * @return job_name - 任务名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置任务名称
     *
     * @param jobName 任务名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName == null ? null : jobName.trim();
    }

    /**
     * 获取任务组名
     *
     * @return job_group - 任务组名
     */
    public String getJobGroup() {
        return jobGroup;
    }

    /**
     * 设置任务组名
     *
     * @param jobGroup 任务组名
     */
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup == null ? null : jobGroup.trim();
    }

    /**
     * 获取任务方法
     *
     * @return method_name - 任务方法
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * 设置任务方法
     *
     * @param methodName 任务方法
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName == null ? null : methodName.trim();
    }

    /**
     * 获取方法参数
     *
     * @return method_params - 方法参数
     */
    public String getMethodParams() {
        return methodParams;
    }

    /**
     * 设置方法参数
     *
     * @param methodParams 方法参数
     */
    public void setMethodParams(String methodParams) {
        this.methodParams = methodParams == null ? null : methodParams.trim();
    }

    /**
     * 获取cron执行表达式
     *
     * @return cron_expression - cron执行表达式
     */
    public String getCronExpression() {
        return cronExpression;
    }

    /**
     * 设置cron执行表达式
     *
     * @param cronExpression cron执行表达式
     */
    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression == null ? null : cronExpression.trim();
    }

    /**
     * 获取计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     *
     * @return misfire_policy - 计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     */
    public String getMisfirePolicy() {
        return misfirePolicy;
    }

    /**
     * 设置计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     *
     * @param misfirePolicy 计划执行错误策略（1立即执行 2执行一次 3放弃执行）
     */
    public void setMisfirePolicy(String misfirePolicy) {
        this.misfirePolicy = misfirePolicy == null ? null : misfirePolicy.trim();
    }

    /**
     * 获取状态（0正常 1暂停）
     *
     * @return status - 状态（0正常 1暂停）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态（0正常 1暂停）
     *
     * @param status 状态（0正常 1暂停）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取创建者
     *
     * @return create_by - 创建者
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建者
     *
     * @param createBy 创建者
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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
     * 获取更新者
     *
     * @return update_by - 更新者
     */
    public String getUpdateBy() {
        return updateBy;
    }

    /**
     * 设置更新者
     *
     * @param updateBy 更新者
     */
    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    /**
     * 获取更新时间
     *
     * @return update_time - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取备注信息
     *
     * @return remark - 备注信息
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注信息
     *
     * @param remark 备注信息
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}