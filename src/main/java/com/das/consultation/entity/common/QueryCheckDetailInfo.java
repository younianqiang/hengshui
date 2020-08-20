package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:检查报告详情查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryCheckDetailInfo {
    private String orgcode;
    private String orgname;
    private String patientname;
    private String sex;
    private String deptname;
    private String reportdoctor;
    private String checkdoctor;
    private String applydoctor;
    private String devmodel;
    private String checkpart;
    private String lczd;
    private Date reportdate;
    private String checksituation;
    private String checkresult;
    private String advice;
    private String imageurl;
}
