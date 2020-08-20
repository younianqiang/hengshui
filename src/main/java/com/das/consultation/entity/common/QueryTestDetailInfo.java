package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/17
 * describe:检验报告详情查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QueryTestDetailInfo {
    /**
     * 检验细项编码
     */
    private String itemcode;
    /**
     * 检验细项名称
     */
    private String itemname;
    /**
     * 检验结果
     */
    private String itemresult;
    /**
     * 参考范围
     */
    private String refrange;
    /**
     * 单位
     */
    private String unit;
    /**
     * 异常提示代码
     */
    private String abnormal;
}
