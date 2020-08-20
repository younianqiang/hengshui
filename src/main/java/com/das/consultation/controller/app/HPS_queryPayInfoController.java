package com.das.consultation.controller.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.consultation.config.data.DataSource;
import com.das.consultation.config.data.DataSourceNames;
import com.das.consultation.entity.app.HPS_queryPayInfoInfo;
import com.das.consultation.service.app.HPS_queryPayInfoService;
import com.das.consultation.util.funUtils;

import cn.hutool.core.util.XmlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @EXPLAIN:查询支付单据 
 * @USER: youqiang 
 * @UPDATAUSER: 
 * @DATE:2020-8-18
 * @URL:/springMvcSsmDome/hs/HPS_queryPayInfo?orgcode=123&cardtype=123&cardno=123
 * @URL:<orgcode>0001892039</orgcode><cardtype>0001892039</cardtype><cardno>0001892039</cardno>
 * @FILENAME:HPS_queryPayInfoController.javaVersion 
 * @VERSION:1.0
 */
@Api(value = "查询支付单据接口")
@Controller
@RequestMapping("/hs")
public class HPS_queryPayInfoController {

	@Autowired
	private HPS_queryPayInfoService hsService;
	// 必传参数
	private String[] parameter = { "orgcode", "cardtype", "cardno" };

	/**
	 * 
	 * EXPLAIN:查询支付单据
	 * 
	 * @param object
	 * @return
	 */
	@ResponseBody
	@ApiOperation(value = "查询支付单据", tags = { "APP" }, notes = "查询支付单据")
	@RequestMapping(value = "/HPS_queryPayInfo",produces="application/json;charset=utf-8", method = { RequestMethod.POST })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "响应成功"), @ApiResponse(code = 404, message = "未请求到资源") })
	@DataSource(DataSourceNames.JCYL)
	public String HPS_PersonalInformation(
			@ApiParam(value = "查询条件xml结构字符串", required = true) @RequestBody String object) {
		Map<String, Object> data = funUtils.ApiRequestHeaderValidation(parameter, object);
		String orgcode = ""; // 医疗机构代码
		String cardtype = ""; // 医疗卡类型
		String cardno = ""; // 医疗卡号
		try {
			orgcode = data.get("orgcode").toString(); // 医疗机构代码
			cardtype = data.get("cardtype").toString(); // 医疗卡类型
			cardno = data.get("cardno").toString(); // 医疗卡号
		} catch (Exception e) {
			e.printStackTrace();
			String mapToXmlStr = XmlUtil.mapToXmlStr(data, "request");
			return mapToXmlStr;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> headMap = new HashMap<String, Object>();

//		HPS_queryPayInfoInfo my_map = hsService.getAPIHPS(orgcode, cardtype, cardno);
//		if (my_map == null) {
//			headMap.put("result", 1);
//			headMap.put("desc", "查询失败！无匹配信息。");
//			resultMap.put("head", headMap);
//			resultMap.put("data", null);
//			String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
//			return mapToXmlStr;
//		}
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("payinfo", my_map.getPayinfo()); // payinfo（每个payInfo可能有多个detail）
//		map2.put("hispayorderno", my_map.getHispayorderno()); // hispayorderno 支付订单号
//		map2.put("hispaytotalamt", my_map.getHispaytotalamt()); // hispaytotalamt 订单总金额
//		map2.put("mzlsh", my_map.getMzlsh()); // mzlsh 门诊流水号
//		map2.put("hispayno", my_map.getHispayno()); // hispayno 支付单据号
//		map2.put("hispayamt", my_map.getHispayamt()); // hispayamt 支付总金额
//		map2.put("selfpayamt", my_map.getSelfpayamt()); // selfpayamt 自费支付金额
//		map2.put("socialpayamt", my_map.getSocialpayamt()); // socialpayamt 医保支付金额
//		map2.put("paytype", my_map.getPaytype()); // paytype 费用类型
//		map2.put("paystate", my_map.getPaystate()); // paystate 支付状态
//		map2.put("creattime", my_map.getCreattime()); // creattime 处方单时间
//		map2.put("depname", my_map.getDepname()); // depname 科室名称
//		map2.put("doctorname", my_map.getDoctorname()); // doctorname 医生姓名
//		map2.put("mztype", my_map.getMztype()); // mztype 是否医保结算
//		map2.put("detail", my_map.getDetail()); // detail(多项)
//		map2.put("itemcodehis", my_map.getItemcodehis()); // itemcodehis His项目代码
//		map2.put("itemcodeyb", my_map.getItemcodeyb()); // itemcodeyb 医保项目代码
//		map2.put("itemname", my_map.getItemname()); // itemname 项目名称
//		map2.put("std", my_map.getStd()); // std 规格
//		map2.put("amt", my_map.getAmt()); // amt 数量
//		map2.put("unit", my_map.getUnit()); // unit 数量单位
//		map2.put("price", my_map.getPrice()); // price 单价
//		map2.put("detailpayamt", my_map.getDetailpayamt()); // detailpayamt 应收价格
//		// 演示时不提供数据持久化相关操作
		Map<String, Object> map2 = hsService.HPS_HealthyHistory(orgcode, cardtype, cardno);
		headMap.put("result", 0);
		headMap.put("desc", "查询成功！");
		resultMap.put("head", headMap);
		resultMap.put("data", map2);
		String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
		return mapToXmlStr;
	}

}
