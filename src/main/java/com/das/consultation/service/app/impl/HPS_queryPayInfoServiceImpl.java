/**
 * EXPLAIN:
 */
package com.das.consultation.service.app.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.das.consultation.entity.app.HPS_queryPayInfoInfo;
import com.das.consultation.mapper.app.HPS_queryPayInfoMapper;
import com.das.consultation.service.app.HPS_queryPayInfoService;

/**
 *  EXPLAIN:查询支付单据
 *  USER: youqiang 
 *  UPDATAUSER: 
 *  DATE:2020-8-18 
 *  URL:
 *  FILENAME:HPS_queryPayInfoServiceImpl.javaVersion 
 *  VERSION:1.0
 */
@Service("HPS_queryPayInfoService")
public class HPS_queryPayInfoServiceImpl implements HPS_queryPayInfoService {

	@Resource
	private HPS_queryPayInfoMapper hr_submitOrder;

	@Override
	public HPS_queryPayInfoInfo getAPIHPS(String orgcode, String cardtype, String cardno) {
		return hr_submitOrder.findAPIHPS(orgcode, cardtype, cardno);
	}

	@Override
	public HPS_queryPayInfoInfo getInsertAPIHPS(HPS_queryPayInfoInfo
			obj) {
		return hr_submitOrder.insertAPIHPS(obj);
	}

	/**
	 * 
	 * EXPLAIN:查询支付单据
	 * @param orgcode   医疗机构代码
	 * @param cardtype  医疗卡类型
	 * @param cardno    医疗卡号
	 * @return
	 */
	public Map<String, Object> HPS_getSchedule(String orgcode, String cardtype, String cardno) {
		// 演示时不提供数据持久化相关操作
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("scheduleid", 1001);
		map2.put("payinfo", "y1234"); // （每个payInfo可能有多个detail）
		map2.put("hispayorderno", "0001234"); // 支付订单号
		map2.put("hispaytotalamt", "8532.12"); // 订单总金额
		map2.put("mzlsh", "00123445"); // 门诊流水号
		map2.put("hispayno", "0002145"); // 支付单据号
		map2.put("hispayamt", "245.12"); // 支付总金额
		map2.put("selfpayamt", "35.14"); // 自费支付金额
		map2.put("socialpayamt", "452.12"); // 医保支付金额
		map2.put("paytype", "1"); // 费用类型
		map2.put("paystate", "1"); // 支付状态
		map2.put("creattime", "2020-8-10"); // 处方单时间
		map2.put("depname", "儿科"); // 科室名称
		map2.put("doctorname", "张三"); // 医生姓名
		map2.put("mztype", "1"); // 是否医保结算
		map2.put("detail", "123"); // detail(多项)
		map2.put("itemcodehis", "1"); // His项目代码
		map2.put("itemcodeyb", "1"); // 医保项目代码
		map2.put("itemname", "检查"); // 项目名称
		map2.put("std", "12"); // 规格
		map2.put("amt", "45412"); // 数量
		map2.put("unit", "次"); // 数量单位
		map2.put("price", "25.32"); // 单价
		map2.put("detailpayamt", "32654.32"); // 应收价格		          
		return map2;
	}

	@Override
	public Map<String, Object> HPS_HealthyHistory(String orgcode, String cardtype, String cardno) {
		// TODO Auto-generated method stub

		return HPS_getSchedule(orgcode, cardtype, cardno);
	}
}
