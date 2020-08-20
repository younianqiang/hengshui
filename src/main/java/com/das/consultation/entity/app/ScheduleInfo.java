package com.das.consultation.entity.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/11
 * describe:排班信息查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleInfo {
    /**
     * 排班id
     */
    private String scheduleid;
    /**
     *科室ID
     */
    private String depid;
    /**
     *科室名称
     */
    private String depname;
    /**
     *医生ID
     */
    private String doctorid;
    /**
     *医生姓名
     */
    private String doctorname;
    /**
     *出诊日期
     */
    private Date visitdate;
    /**
     *排班标记
     */
    private String isyuyue;
    /**
     *班别
     */
    private String timetype;
    /**
     *挂号级别
     */
    private String reglevel;
    /**
     *开始时间
     */
    private Date begintime;
    /**
     *结束时间
     */
    private Date endtime;
    /**
     *挂号金额
     */
    private float guahaoamt;
    /**
     *看诊费
     */
    private float visitamt;
    /**
     *总预约数
     */
    private int yuyuemax;
    /**
     * 已预约数
     */
    private int yuyuenum;

}
