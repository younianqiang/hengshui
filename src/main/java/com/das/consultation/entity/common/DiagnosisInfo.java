package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:患者诊断信息查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DiagnosisInfo {

    private String diagnosisid;
    private String diagnosistypename;
    private Date chndiagclass;
    private String icdcode;
    private String diagnosisdescribe;
    private String syndromename;
    private String diagsequence;
    private String operator;
    private Date operatetime;
    private String visited;
    private String orgcode;
    private String orgname;
}
