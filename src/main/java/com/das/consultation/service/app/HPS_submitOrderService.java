package com.das.consultation.service.app;

import java.util.Map;

import com.das.consultation.entity.app.HPS_submitOrderInfo;
/**
 * 预约支付
 * @author youqiang
 *
 */
public interface HPS_submitOrderService {
/**
 * 预约支付
 * @param orgcode     医疗机构代码
 * @param orderid     预约单号
 * @param payno       交易流水号
 * @param payamout    支付金额
 * @param paymethod   支付方式
 * @param paychannel  支付渠道
 * @return
 */
	public HPS_submitOrderInfo getAPIHPS(String orgcode, String orderid, String payno, String payamout, String paymethod,String paychannel);
	public HPS_submitOrderInfo getInsertAPIHPS(HPS_submitOrderInfo obj);

	Map<String, Object> HPS_HealthyHistory(String orgcode, String orderid, String payno, String payamout, String paymethod,
			String paychannel);
	
}