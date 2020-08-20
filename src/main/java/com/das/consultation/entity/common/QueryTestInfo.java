package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:检验报告列表查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTestInfo {
    /**
     * 检验报告单id
     */
    private String testid;
    /**
     * 报告单名称
     */
    private String testname;
    /**
     * 患者姓名
     */
    private String patientname;
    /**
     * 科室名称
     */
    private String deptname;
    /**
     * 结果解释
     */
    private String resultexplan;
    /**
     * 性别
     */
    private String sex;
    /**
     * 临床诊断
     */
    private String diagnosis;
    /**
     * 门住号
     */
    private String clinichospno;
    /**
     * 申请医生
     */
    private String applydoctorname;
    /**
     * 审核医生
     */
    private String checkdoctorname;
    /**
     * 报告医生
     */
    private String reportdoctorname;
    /**
     * 送检日期
     */
    private Date sendtime;
}
