package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/12
 * describe:患者就诊信息实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InPatientInfo {
    private String empi;
    private String visitid;
    private String orgcode;
    private String orgname;
    private String patientid;
    private String patientname;
    private String sex;
    private int age;
    private String ageunit;
    private String nation;
    private String marriage;
    private String occupation;
    private String workplace;
    private String address;
    private String cardid;
    private String tel;
    private String complaints;
    private String allergichistory;
    private String physicalexamination;
    private String dept;
    private Date visitdate;
    private Date dischargedate;
    private String wards;
    private String bed;
    private String visittype;
    private String patientno;
    private String visittime;
    private String clinichistory;
    private String presentillnesshistory;
    private String pasthistory;
    private String clinicdiagnose;
    private String infectioushistory;
    private String operationhistory;
    private String obstericalhistory;
    private String transfutionhistory;
    private String preventiveinoculationhistory;
    private String personalhistory;
    private String menstrualhistory;
    private String familyhistory;
    private String weight;
    private String pathologicaldiagnosis;
    private String takenmedicien;
    private String treatmentprocess;
    private String assistantcheck;
    private String nationality;
    private String height;
    private String mitype;
    private String micardno;
    private String healthcardnumber;
    private String patiillnessstatus;
    private String patiapplytype;
    private String clintherapeuticadvice;
    private String clincomment;
    private String clinpurpose;
}
