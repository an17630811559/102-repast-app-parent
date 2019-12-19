package com.aaa.lee.app.model;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "sys_job_log")
public class SysJobLog {
    /**
     * 任务日志ID
     */
    @Id
    @Column(name = "job_log_id")
    private Integer jobLogId;

    /**
     * 任务名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 任务组名
     */
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
     * 日志信息
     */
    @Column(name = "job_message")
    private String jobMessage;

    /**
     * 执行状态（0正常 1失败）
     */
    private String status;

    /**
     * 异常信息
     */
    @Column(name = "exception_info")
    private String exceptionInfo;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 获取任务日志ID
     *
     * @return job_log_id - 任务日志ID
     */
    public Integer getJobLogId() {
        return jobLogId;
    }

    /**
     * 设置任务日志ID
     *
     * @param jobLogId 任务日志ID
     */
    public void setJobLogId(Integer jobLogId) {
        this.jobLogId = jobLogId;
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
     * 获取日志信息
     *
     * @return job_message - 日志信息
     */
    public String getJobMessage() {
        return jobMessage;
    }

    /**
     * 设置日志信息
     *
     * @param jobMessage 日志信息
     */
    public void setJobMessage(String jobMessage) {
        this.jobMessage = jobMessage == null ? null : jobMessage.trim();
    }

    /**
     * 获取执行状态（0正常 1失败）
     *
     * @return status - 执行状态（0正常 1失败）
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置执行状态（0正常 1失败）
     *
     * @param status 执行状态（0正常 1失败）
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 获取异常信息
     *
     * @return exception_info - 异常信息
     */
    public String getExceptionInfo() {
        return exceptionInfo;
    }

    /**
     * 设置异常信息
     *
     * @param exceptionInfo 异常信息
     */
    public void setExceptionInfo(String exceptionInfo) {
        this.exceptionInfo = exceptionInfo == null ? null : exceptionInfo.trim();
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
}