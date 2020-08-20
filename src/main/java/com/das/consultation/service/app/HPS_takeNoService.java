package com.das.consultation.service.app;

import java.util.Map;

import com.das.consultation.entity.app.HPS_takeNoInfo;

	/**
	 * 患者报到/取号       
	 * @author youqiang
	 *
	 */
public interface HPS_takeNoService {
	/**
	 * 
	 * @param orgcode  医疗机构代码
	 * @param yuyueid  预约订单id
	 * @param orderno  订单号
	 * @param deptid   科室id
	 * @param truename 姓名
	 * @param cardno   卡号
	 * @param cardtype 卡类型
	 * @return
	 */
	public HPS_takeNoInfo getAPIHPS(String orgcode, String yuyueid, String orderno, String deptid, String truename,String cardno,String cardtype);
	public HPS_takeNoInfo getInsertAPIHPS(HPS_takeNoInfo obj);

	Map<String, Object> HPS_HealthyHistory(String orgcode, String yuyueid, String orderno, String deptid, String truename,String cardno,String cardtype);
}
