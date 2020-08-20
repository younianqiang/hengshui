package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:检查报告列表查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryCheckInfo {
    /**
     * 检查报告单id
     */
    private String checkid;
    /**
     * 科室名称
     */
    private String deptname;
    /**
     * 患者姓名
     */
    private String patientname;
    /**
     * 检查部位
     */
    private String checkpart;
    /**
     * 检查项目名称
     */
    private String checkname;
    /**
     * 检查日期
     */
    private Date checktime;

}
