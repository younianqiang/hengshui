package com.das.consultation.entity.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/10
 * describe:身份认证实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BindCardInfo {
    /**
     * 患者医疗卡号
     */
    private String cardno;

    /**
     * 姓名
     */
    private String patientname;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 性别（0:未知性别，1:男，2:女,9:为说明的性别）
     */
    private String sex;

    /**
     * 生日
     */
    private Date birthdate;

    /**
     * 病人ID/病案号
     */
    private String patientid;
    /**
     * 身份证号
     */
    private String cardid;


}
