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
import com.das.consultation.entity.app.HPS_submitOrderInfo;
import com.das.consultation.service.app.HPS_submitOrderService;
import com.das.consultation.util.funUtils;

import cn.hutool.core.util.XmlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;






/**
 * 
 * @EXPLAIN:预约支付 
 * @USER: youqiang 
 * @UPDATAUSER: 
 * @DATE:2020-8-18
 * @URL:/springMvcSsmDome/hs/HPS_submitOrder?orgcode=123&orderid=123&payno=123&payamout=123&paymethod=1123&paychannel=123
 * @URL:<orgcode>0001892039</orgcode><orderid>0001892039</orderid><payno>0001892039</payno><payamout>0001892039</payamout><paymethod>0001892039</paymethod><paychannel>0001892039</paychannel>
 * @FILENAME:HPS_submitOrderController.javaVersion 
 * @VERSION:1.0
 */
@Api(value = "预约支付接口")
@Controller
@RequestMapping("/hs")
public class HPS_submitOrderController {

	@Autowired
	private HPS_submitOrderService hsService;
	// 必传参数
	private String[] parameter = { "orgcode", "orderid", "payno", "payamout", "paymethod", "paychannel" };

	/**
	 * 
	 * EXPLAIN:预约支付
	 * @param object
	 * @return
	 */
	@ResponseBody
	@ApiOperation(value = "预约支付", tags = { "APP" }, notes = "预约支付")
	@RequestMapping(value = "/HPS_submitOrder",produces="application/json;charset=utf-8", method = { RequestMethod.POST })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "响应成功"), @ApiResponse(code = 404, message = "未请求到资源") })
	@DataSource(DataSourceNames.JCYL)
	public String HPS_PersonalInformation(
			@ApiParam(value = "查询条件xml结构字符串", required = true) @RequestBody String object) {
		Map<String, Object> data = funUtils.ApiRequestHeaderValidation(parameter, object);
		String orgcode = "";     //医疗机构代码    
		String orderid = "";     //预约单号      
		String payno = "";       //交易流水号     
		String payamout = "";    //支付金额      
		String paymethod = "";   //支付方式      
		String paychannel = "";  //支付渠道      
		try {
			orgcode = data.get("orgcode").toString();         //医疗机构代码    
			orderid = data.get("orderid").toString();         //预约单号      
			payno = data.get("payno").toString();             //交易流水号     
			payamout = data.get("payamout").toString();       //支付金额      
			paymethod = data.get("paymethod").toString();     //支付方式      
			paychannel = data.get("paychannel").toString();   //支付渠道      
		} catch (Exception e) {
			e.printStackTrace();
			String mapToXmlStr = XmlUtil.mapToXmlStr(data, "request");
			return mapToXmlStr;
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> headMap = new HashMap<String, Object>();
//		HPS_submitOrderInfo my_map = hsService.getAPIHPS(orgcode, orderid, payno, payamout, paymethod, paychannel);
//		if (my_map == null) {
//			headMap.put("result", 1);
//			headMap.put("desc", "查询失败！无匹配信息。");
//			resultMap.put("head", headMap);
//			resultMap.put("data", null);
//			String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
//			return mapToXmlStr;
//		}
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("receiptnum", my_map.getReceiptnum()); // 收据号
//		map2.put("serialnum", my_map.getSerialnum()); // 就诊序号

//		// 演示时不提供数据持久化相关操作
		Map<String, Object> map2 = hsService.HPS_HealthyHistory(orgcode, orderid, payno, payamout, paymethod, paychannel);
		headMap.put("result", 0);
		headMap.put("desc", "查询成功！");
		resultMap.put("head", headMap);
		resultMap.put("data", map2);
		String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
		return mapToXmlStr;
	}

}
