package com.das.consultation.service.app.impl;

//orgcode	医疗机构代码
//appid	预约单号
//depid	科室ID
//doctorid	医生ID
//endtime	截至时间
//queueno	队列号
//---------------------------------------------------
//queuenum	当前队列人数
//hasno	是否还有余号
//averagetime	看诊病人的平均时间
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.das.consultation.entity.app.HPS_takeNoSearchInfo;
import com.das.consultation.mapper.app.HPS_takeNoSearchMapper;
import com.das.consultation.service.app.HPS_takeNoSearchService;

@Service("HPS_takeNoSearchService")
public class HPS_takeNoSearchServiceImpl implements HPS_takeNoSearchService {
	@Resource
	private HPS_takeNoSearchMapper hr_submitOrder;

	@Override
	public HPS_takeNoSearchInfo getAPIHPS(String orgcode, String appid, String depid, String doctorid, String endtime,String queueno) {
		return hr_submitOrder.findAPIHPS(orgcode, appid, depid, doctorid, endtime, queueno);
	}

	@Override
	public HPS_takeNoSearchInfo getInsertAPIHPS(HPS_takeNoSearchInfo obj) {
		return hr_submitOrder.insertAPIHPS(obj);
	}

	/**
	 * 患者队列查询
	 * @param orgcode   医疗机构代码
	 * @param appid     预约单号
	 * @param depid     科室ID
	 * @param doctorid  医生ID
	 * @param endtime   截至时间
	 * @param queueno   队列号
	 * @return
	 */
	public Map<String, Object> HPS_getSchedule(String orgcode, String appid, String depid, String doctorid, String endtime,String queueno) {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("scheduleid", 1001);
		map2.put("queuenum", "y41234"); // queuenum 当前队列人数
		map2.put("hasno", "20"); // hasno 是否还有余号
		map2.put("averagetime", "123456789"); // averagetime 看诊病人的平均时间
		
		return map2;
	}

	@Override
	public Map<String, Object> HPS_HealthyHistory(String orgcode, String appid, String depid, String doctorid, String endtime,String queueno) {
		// TODO Auto-generated method stub

		return HPS_getSchedule(orgcode, appid, depid, doctorid, endtime, queueno);
	}
}
