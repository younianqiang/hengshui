package com.das.consultation.entity.xinyi;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/17
 * describe:患者事件信息查询实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventInfo {
    /**
     *事件时间
     */
    private String eventdate;
    /**
     *事件编码
     */
    private String eventcode;
    /**
     *事件名称
     */
    private String eventname;
    /**
     *就诊ID
     */
    private String visitid;
    /**
     *事件ID
     */
    private String eventid;
    /**
     *机构编码
     */
    private String orgcode;
    /**
     *机构名称
     */
    private String orgname;

}
