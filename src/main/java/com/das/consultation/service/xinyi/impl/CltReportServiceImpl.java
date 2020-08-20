package com.das.consultation.service.xinyi.impl;

import com.das.consultation.entity.xinyi.ConsultationReportInfo;
import com.das.consultation.mapper.xinyi.CltReportMapper;
import com.das.consultation.service.xinyi.CltReportService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (ConsultationReportInfo)表服务实现类
 *
 * @author jun
 * @since 2020-08-05 17:09:05
 */
@Service
public class CltReportServiceImpl implements CltReportService {
    @Resource
    private CltReportMapper cltReportMapper;


    /**
     * 新增数据
     *
     * @param consultationReportInfo 实例对象
     * @return 实例对象
     */
    @Override
    public ConsultationReportInfo insert(ConsultationReportInfo consultationReportInfo) {
        try {
            int result = cltReportMapper.insert(consultationReportInfo);
            if (result>0){
                return  consultationReportInfo;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}