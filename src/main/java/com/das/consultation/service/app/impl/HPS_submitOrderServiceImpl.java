package com.das.consultation.service.app.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.das.consultation.entity.app.HPS_submitOrderInfo;
import com.das.consultation.mapper.app.HPS_submitOrderMapper;
import com.das.consultation.service.app.HPS_submitOrderService;
/**
 * 预约支付
 * @author youqiang
 *
 */
@Service("HPS_submitOrderService")
public class HPS_submitOrderServiceImpl implements HPS_submitOrderService {

	@Resource
	private HPS_submitOrderMapper hr_submitOrder;

	@Override
	public HPS_submitOrderInfo getAPIHPS(String orgcode, String orderid, String payno, String payamout, String paymethod,
			String paychannel) {
		return hr_submitOrder.findAPIHPS(orgcode, orderid, payno, payamout, paymethod, paychannel);
	}
	@Override
	public HPS_submitOrderInfo getInsertAPIHPS(HPS_submitOrderInfo obj) {
		return hr_submitOrder.insertAPIHPS(obj);
	}

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
	public Map<String, Object> HPS_getSchedule(String orgcode, String orderid, String payno, String payamout,
			String paymethod, String paychannel) {
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("scheduleid", 1001);
		map2.put("receiptnum", "y1234"); //收据号
		map2.put("serialnum", "123456"); //就诊序号
		return map2;
	}

	@Override
	public Map<String, Object> HPS_HealthyHistory(String orgcode, String orderid, String payno, String payamout,
			String paymethod, String paychannel) {
		// TODO Auto-generated method stub

		return HPS_getSchedule(orgcode, orderid, payno, payamout, paymethod, paychannel);
	}
}