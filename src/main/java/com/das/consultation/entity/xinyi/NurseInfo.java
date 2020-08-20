package com.das.consultation.entity.xinyi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/17
 * describe:护理记录数据查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NurseInfo {
    /**
     *护理记录ID
     */
    private String id;
    /**
     *就诊ID
     */
    private String visitid;
    /**
     *记录时间
     */
    private Date time;
    /**
     *类别编码
     */
    private String typecode;
    /**
     *类别名
     */
    private String type;
    /**
     *结果单位
     */
    private String valueunit;
    /**
     *结果单位
     */
    private String nursevalue;
    /**
     *描述
     */
    private String describe;
    /**
     *机构编码
     */
    private String orgcode;
    /**
     *机构名称
     */
    private String orgname;
}
