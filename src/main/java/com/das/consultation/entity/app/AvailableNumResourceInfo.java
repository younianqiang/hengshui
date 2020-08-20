package com.das.consultation.entity.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * created by jun on 2020/8/11
 * describe:号源信息查询
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvailableNumResourceInfo {
    /**
     * 排班id
     */
    private String scheduleid;
    /**
     *号源ID
     */
    private String numid;
    /**
     * 开始时间
     */
    private Date begintime;
    /**
     *结束时间
     */
    private Date endtime;
    /**
     * 总预约数
     */
    private int yuyuemax;
    /**
     * 已预约数
     */
    private int yuyuenum;

}
