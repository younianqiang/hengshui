package com.das.springboot.hengshui.service;

import java.util.List;
import java.util.Map;

import com.das.springboot.hengshui.domain.PersonalInfo;


public interface HsMECService {

	
	public Map<String, Object> HPS_HealthyHistory(String orgcode,String depid,String doctorid,String begindate,String enddate);	

	/**
	 * 个人信息查询
	 * @param orgcode
	 * @param iccardno
	 * @return
	 */
	public List<PersonalInfo> HPS_PersonalInformation(String orgcode,String iccardno);	
	
}
