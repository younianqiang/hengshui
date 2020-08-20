package com.das.consultation.mapper.app;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.das.consultation.entity.app.HealthyHistory;
import com.das.consultation.entity.app.PersonalInfo;

@Mapper
public interface AppMapper {

	
	PersonalInfo HPS_PersonalInformation(@Param("orgCode")String orgCode,@Param("patientId")String patientId);	
	 
	 
	HealthyHistory HPS_HealthyHistory(@Param("orgCode")String orgCode,@Param("patientId")String patientId);	
	 
}
