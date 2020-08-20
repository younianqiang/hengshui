/**
 * EXPLAIN:
 */
package com.das.consultation.service.app;

import java.util.Map;
import com.das.consultation.entity.app.HPS_queryPayInfoInfo;


/**
 * EXPLAIN:查询支付单据
 * USER: youqiang
 * UPDATAUSER: 
 * DATE:2020-8-18
 * URL:
 * FILENAME:HPS_queryPayInfoService.javaVersion
 * VERSION:1.0
 */
public interface HPS_queryPayInfoService {
	/**
	 * 
	 * EXPLAIN:
	 * @param orgcode  医疗机构代码
	 * @param cardtype 医疗卡类型
	 * @param cardno   医疗卡号
	 * @return
	 */
	public HPS_queryPayInfoInfo getAPIHPS(String orgcode, String cardtype, String cardno);
	public HPS_queryPayInfoInfo getInsertAPIHPS(HPS_queryPayInfoInfo obj);
	Map<String, Object> HPS_HealthyHistory(String orgcode, String cardtype, String cardno);
}
