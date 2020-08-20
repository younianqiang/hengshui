package com.das.consultation.service.app;

import java.util.Map;

import com.das.consultation.entity.app.HPS_takeNoSearchInfo;

public interface HPS_takeNoSearchService {
	/**
	 * 患者队列查询
	 * @param orgcode  医疗机构代码
	 * @param appid    预约单号
	 * @param depid    科室ID
	 * @param doctorid 医生ID
	 * @param endtime  截至时间
	 * @param queueno  队列号
	 * @return
	 */
	public HPS_takeNoSearchInfo getAPIHPS(String orgcode, String appid, String depid, String doctorid, String endtime,String queueno);
	public HPS_takeNoSearchInfo getInsertAPIHPS(HPS_takeNoSearchInfo obj);

	Map<String, Object> HPS_HealthyHistory(String orgcode, String appid, String depid, String doctorid, String endtime,String queueno);

}
