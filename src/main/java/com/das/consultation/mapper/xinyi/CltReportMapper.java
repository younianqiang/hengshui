package com.das.consultation.mapper.xinyi;

import com.das.consultation.entity.xinyi.ConsultationReportInfo;

/**
 * (ConsultationReportInfo)表数据库访问层
 *
 * @author jun
 * @since 2020-08-05 17:09:04
 */
public interface CltReportMapper {


    /**
     * 新增数据
     *
     * @param ConsultationReportInfo 实例对象
     * @return 影响行数
     */
    int insert(ConsultationReportInfo ConsultationReportInfo);



}