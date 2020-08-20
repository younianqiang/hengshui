package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:5.2.14检验申请单信息查询实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationFormInfo {
    /**
     * 检验申请单ID
     */
    private String testapplpid;
    /**
     * 检验ID
     */
    private String testid;
    /**
     * 检验项名称
     */
    private String testname;
    /**
     * 检验医师姓名
     */
    private String testername;
    /**
     * 检验日期
     */
    private Date testdate;
    /**
     * 报告医师姓名
     */
    private String reportername;
    /**
     * 报告日期
     */
    private Date reportdate;
    /**
     * 审核医师姓名
     */
    private String reviewername;
    /**
     * 审核日期
     */
    private Date reviewdate;
    /**
     * 就诊ID
     */
    private String visitid;
    /**
     * 化验单号
     */
    private String testcode;
    /**
     * 样本名称
     */
    private String samplename;
    /**
     * 机构编码
     */
    private String orgcode;
    /**
     * 机构名称
     */
    private String orgname;


}
