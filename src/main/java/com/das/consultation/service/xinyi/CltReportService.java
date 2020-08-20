package com.das.consultation.service.xinyi;

import com.das.consultation.entity.xinyi.ConsultationReportInfo;

/**
 * (ConsultationReportInfo)表服务接口
 *
 * @author jun
 * @since 2020-08-05 17:09:05
 */
public interface CltReportService {



    /**
     * 新增数据
     *
     * @param ConsultationReportInfo 实例对象
     * @return 实例对象
     */
    ConsultationReportInfo insert(ConsultationReportInfo ConsultationReportInfo);


}