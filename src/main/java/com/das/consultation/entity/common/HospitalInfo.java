package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/12
 * describe:医院查询实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospitalInfo {
    /**
     * 医院地址
     */
    private String orgaddress;
    /**
     * 医院名称
     */
    private String orgname;
    /**
     * 医院级别代码
     */
    private String unitlevel;
    /**
     * 医院级别名称
     */
    private String unitlevelname;
    /**
     * 医院电话号码
     */
    private String orgphone;
    /**
     * 医院路线
     */
    private String busline;
    /**
     * 医院机构代码
     */
    private String orgcode;
    /**
     * 医院简介
     */
    private String detail;
    /**
     * 支付要求
     */
    private String paytype;
    /**
     * 支付方式
     */
    private String apppaytype ;
    /**
     * 可预约天数
     */
    private String orderday;
    /**
     * 号源管理方式
     */
    private String resourcemanagertype;
    /**
     * 就诊卡必要性
     */
    private String patientcardneed;

}
