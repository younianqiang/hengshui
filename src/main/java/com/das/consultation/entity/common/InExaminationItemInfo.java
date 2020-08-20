package com.das.consultation.entity.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/17
 * describe:检查项目信息查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InExaminationItemInfo {
    /**
     * 检查ID
     */
    private String checkid;
    /**
     * 检查部位
     */
    private String bodypartname;
    /**
     * 检查方法
     */
    private String studymethodname;

}
