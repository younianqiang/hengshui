package com.das.springboot.hengshui.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.das.springboot.hengshui.domain.PersonalInfo;
import com.das.springboot.hengshui.mapper.app.AppMapper;
import com.das.springboot.hengshui.service.HsMECService;


@Service
public class HsMECServiceImpl implements HsMECService{
	
	@Autowired 
	private AppMapper app;

	/**
	 * 排班表演示接口
	 * @param orgcode
	 * @param depid
	 * @param doctorid
	 * @param begindate
	 * @param enddate
	 * @return
	 */
	public Map<String, Object> HPS_getSchedule(String orgcode, String depid, String doctorid, String begindate, String enddate) {
		Map<String, Object> map = new HashMap<String, Object>();
		//演示时不提供数据持久化相关操作
		map.put("code", 0);
		map.put("msg", "排班信息查询成功！");
		ArrayList<Map<String, Object>> scheduleList = new ArrayList<Map<String, Object>>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("scheduleid", 1001);
		map2.put("depid", depid);
		map2.put("depname", "科室名称");
		map2.put("doctorid", doctorid);
		map2.put("doctorname", "医生姓名");
		map2.put("visitdate", "2020-07-27");
		map2.put("isyuyue", 1);
		map2.put("timetype", "1");
		map2.put("reglevel", "专家门诊");
		map2.put("begintime", begindate);
		map2.put("endtime", enddate);
		map2.put("guahaoamt", 88.95);
		map2.put("visitamt", 220);
		map2.put("yuyuemax", 20);
		map2.put("yuyuenum", 5);
		scheduleList.add(map2);
		map.put("schedule", scheduleList);
		return map;
	}

	@Override
	public Map<String, Object> HPS_HealthyHistory(String orgcode, String depid, String doctorid, String begindate,
			String enddate) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public List<PersonalInfo> HPS_PersonalInformation(String orgcode, String iccardno) {
		// TODO Auto-generated method stub
		return app.HPS_PersonalInformation(orgcode,iccardno);
	}

}
