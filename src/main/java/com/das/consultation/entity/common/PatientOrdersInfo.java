package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:患者医嘱信息查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatientOrdersInfo {
    private String visitid;
    private String orderid;
    private String ordergroupno;
    private String ordergroupsubno;
    private String ordertypecode;
    private String ordertypename;
    private String ordername;
    private String ordermemo;
    private String medicinetypename;
    private String drugname;
    private String drugspec;
    private String drugmainflag;
    private String Dosage;
    private String dosageunit;
    private String totaldosage;
    private String totaldosageunit;
    private String numberofherb;
    private String decoctionofherb;
    private String dosageofherb;
    private String footnoteofherb;
    private String orderstatus;
    private String orderstatusname;
    private String temporaryflag;
    private String orderpersonname;
    private Date ordertime;
    private String stoppersonname;
    private Date stoptime;
    private String openexecutor;
    private String opencollator;
    private String stopexecutor;
    private String stopcollator;
    private String prescriptionfrequency;
    private String drugusage;
    private String Prescriptiondosageday;
    private String capacityquantity;
    private Date executiontime;
    private String orgcode;
    private String orgname;
}
