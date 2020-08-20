package com.das.consultation.repository.xinyi;

import com.das.consultation.entity.xinyi.ConsultationReportInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by jun on 2020/8/4
 * describe:会诊报告信息Repository
 * version 1.0
 */
public interface CltReportRepository extends JpaRepository<ConsultationReportInfo,String> {

}
