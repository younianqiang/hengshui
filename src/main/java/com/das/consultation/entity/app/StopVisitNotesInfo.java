package com.das.consultation.entity.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/11
 * describe:停诊通知实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StopVisitNotesInfo {
    private String scheduleid;//排班ID
    private String depid;//科室ID
    private String depname;//科室名称
    private String doctorid;//医生ID
    private String doctorname;//医生姓名
    private String visitdate;//出诊日期
    private String isyuyue;//排班标记
    private String timetype;//班别
    private String reglevel;//挂号级别
    private String begintime;//开始时间
    private String endtime;//结束时间
}
