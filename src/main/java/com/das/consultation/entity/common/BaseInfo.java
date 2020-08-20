package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 基本信息-个人基本信息 （必传）(Baseinfo)实体类
 *
 * @author jun
 * @since 2020-08-07 13:39:16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseInfo implements Serializable {
    private static final long serialVersionUID = -57029012064478484L;


    /**
     * 病人ID#DE99.02.003.00#
     */
    private String patientid;

    /**
     * 患者姓名#DE02.01.039.00#
     */
    private String patientname;

    /**
     * 出生日期#DE02.01.005.01#
     */
    private Date birthdate;
    /**
     * 身份证件号码#DE02.01.030.00#
     */
    private String cardid;
    /**
     * 性别代码#DE02.01.040.00#STD_SEX
     */
    private String sex;
    /**
     * 民族代码#DE02.01.025.00#STD_NATIONALITY
     */
    private String nation;
    /**
     * 医疗机构代码#DE08.10.052.00#STD_ORG_CODE
     */
    private String orgcode;
    /**
     * 机构名称
     */
    private String orgname;
}