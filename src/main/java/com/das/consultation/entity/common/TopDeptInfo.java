package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/12
 * describe:一级科室查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TopDeptInfo {
    /**
     * 科室编码
     */
    private String depid;
    /**
     * 科室名称
     */
    private String depname;
    /**
     * 科室简介
     */
    private String depintro;
    /**
     * 科室分类编码
     */
    private String catno;
    /**
     * 科室分类编码名称
     */
    private String catname;
    /**
     * 诊疗范围
     */
    private String deptscope;
    /**
     * 重点科室
     */
    private String isimportant;
    /**
     * 预约范围
     */
    private String orderscope;
}
