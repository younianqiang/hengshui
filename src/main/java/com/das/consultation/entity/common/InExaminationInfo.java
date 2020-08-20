package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:检查申请单信息查询实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InExaminationInfo {
    /**
     * 检查申请单号
     */
    private String checkapplpid;
    /**
     * 检查ID
     */
    private String checkid;
    /**
     * 申请科室
     */
    private String applydeptname;
    /**
     * 申请医生
     */
    private String applydoctorname;
    /**
     * 申请时间
     */
    private Date applytime;
    /**
     * 申请单号
     */
    private String applyid;
    /**
     * 患者主述
     */
    private String clinicalinfo;
    /**
     * 临床诊断
     */
    private String clinicalconclude;
    /**
     * 患者病史
     */
    private String clinichistory;
    /**
     * 检查描述
     */
    private String requestcheckitem;

}
