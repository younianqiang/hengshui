package com.das.consultation.service.app;

import java.util.Map;

public interface HsMECService {

	
	/**
	 * 个人信息查询
	 * @param orgcode
	 * @param iccardno
	 * @return
	 */
	public Map<String, Object> HPS_PersonalInformation(String orgCode,String patientId);
	
	/**
	 * 医疗病史
	 * @param orgCode
	 * @param patientId
	 * @return
	 */
	public Map<String, Object> HPS_HealthyHistory(String orgCode,String patientId);	
	
}
