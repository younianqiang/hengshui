package com.das.consultation.service.app.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.consultation.config.data.DataSource;
import com.das.consultation.config.data.DataSourceNames;
import com.das.consultation.entity.app.HealthyHistory;
import com.das.consultation.entity.app.PersonalInfo;
import com.das.consultation.mapper.app.AppMapper;
import com.das.consultation.service.app.HsMECService;

import cn.hutool.core.bean.BeanUtil;

@Service
public class HsMECServiceImpl implements HsMECService{
	
	@Autowired 
	private AppMapper app;

	@Override
	@DataSource(DataSourceNames.JCYL)
	public Map<String, Object> HPS_HealthyHistory(String orgCode, String patientId) {
		// TODO Auto-generated method stub
		HealthyHistory healthh = app.HPS_HealthyHistory(orgCode, patientId);
		return BeanUtil.beanToMap(healthh);
	}

	@Override
	@DataSource(DataSourceNames.JCYL)
	public Map<String, Object> HPS_PersonalInformation(String orgCode, String patientId) {
		// TODO Auto-generated method stub
		PersonalInfo persion = app.HPS_PersonalInformation(orgCode,patientId);
		return BeanUtil.beanToMap(persion);
	}
}
