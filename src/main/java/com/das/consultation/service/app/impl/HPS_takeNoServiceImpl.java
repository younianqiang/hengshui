package com.das.consultation.service.app.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.das.consultation.entity.app.HPS_takeNoInfo;
import com.das.consultation.mapper.app.HPS_takeNoMapper;
import com.das.consultation.service.app.HPS_takeNoService;

//orgcode	医疗机构代码	STRING	是	医疗机构的代码            
//yuyueid	预约订单id	STRING	是	                   
//orderno	订单号	STRING	否	                       
//deptid	科室id	STRING	否	                   
//truename	姓名	STRING	否	                       
//cardno	卡号	STRING	否	                       
//cardtype	卡类型	STRING	否	参照值域字典                 
                                              
//queueno	排队号	INT	是	                           
//queuenum	排队人数	INT	否	                       
//mzlsh	门诊流水号	STRING	否	                   
//qhfph	取号发票号	STRING	否	
/**
 * 患者报到/取号
 * @author youqiang
 *
 */
@Service("HPS_takeNoService")
public  class HPS_takeNoServiceImpl implements HPS_takeNoService {

	@Resource
	private HPS_takeNoMapper hr_submitOrder;

	@Override
	public HPS_takeNoInfo getAPIHPS(String orgcode, String yuyueid, String orderno, String deptid, String truename,String cardno,String cardtype) {
		return hr_submitOrder.findAPIHPS( orgcode,  yuyueid,  orderno,  deptid,  truename, cardno, cardtype);
	}
	@Override
	public HPS_takeNoInfo getInsertAPIHPS(HPS_takeNoInfo obj) {
		return hr_submitOrder.insertAPIHPS(obj);
	}

	/**
	 * 患者报到/取号
	 * @param orgcode   医疗机构代码
	 * @param yuyueid   预约订单id
	 * @param orderno   订单号
	 * @param deptid    科室id
	 * @param truename  姓名
	 * @param cardno    卡号
	 * @param cardtype  卡类型
	 * @return
	 */
	public Map<String, Object> HPS_getSchedule(String orgcode, String yuyueid, String orderno, String deptid, String truename,String cardno,String cardtype) {
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("scheduleid", 1001);
		map2.put("queueno", "y41234");  //queueno	排队号	INT	是	 
		map2.put("queuenum", "20");  //queuenum	排队人数	INT	否
		map2.put("mzlsh", "123456789");  //mzlsh	门诊流水号	STRING	否
		map2.put("qhfph", "1234561234568");  //qhfph	取号发票号	STRING	否
		return map2;
	}

	@Override
	public Map<String, Object> HPS_HealthyHistory(String orgcode, String yuyueid, String orderno, String deptid, String truename,String cardno,String cardtype) {
		// TODO Auto-generated method stub

		return HPS_getSchedule(orgcode,  yuyueid,  orderno,  deptid,  truename, cardno, cardtype);
	}
}