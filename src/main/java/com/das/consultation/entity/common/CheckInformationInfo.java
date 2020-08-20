package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:检查信息查询实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CheckInformationInfo {

    private String checkapplpid;
    private String checkid;
    private String studyid;
    private String deptstudyid;
    private String devicetypename;
    private String studydescribe;
    private Date studytime;
    private int imagecount;
    private int emergencyflag;
    private String dstudyuid;
    private String patientuid;
    private String patientname;
    private float weight;
    private float theight;
    private Date birthdate;
    private int age;
    private String ageunit;
    private String sex;
    private String cardid;
    private String societyid;
    private String phone;
    private String address;
    private String typename;
    private String hoscardno;
    private String patcardno;
    private String folk;
    private String sickroom;
    private String bedno;
    private String applydoctor;
    private String applydepartment;
    private String hospitalname;
    private String orgcode;
    private String performingphysicianname;
    private String reportdoctor;
    private String verifydoctor;
    private Date reporttime;
    private Date verifytime;
    private String reportdesc;
    private String reportdiagnose;
    private String sampleinfo;
    private String sampleacceptdoctor;
    private String nakedeyesee;
    private float fnmp;
}
