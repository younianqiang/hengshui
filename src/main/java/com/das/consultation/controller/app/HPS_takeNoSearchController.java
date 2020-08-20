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
import com.das.consultation.entity.app.HPS_takeNoSearchInfo;
import com.das.consultation.service.app.HPS_takeNoSearchService;
import com.das.consultation.util.funUtils;

import cn.hutool.core.util.XmlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * 
 * @EXPLAIN:患者队列查询
 * @USER: youqiang
 * @UPDATAUSER:
 * @DATE:2020-8-18
 * @URL:/springMvcSsmDome/hs/HPS_takeNoSearch?orgcode=123&appid=123
 * @URL:<orgcode>0001892039</orgcode><appid>0001892039</appid><depid>0001892039</depid><doctorid>0001892039</doctorid><endtime>0001892039</endtime><queueno>0001892039</queueno>
 * @FILENAME:HPS_takeNoSearchController.javaVersion
 * @VERSION:1.0
 */
@Api(value = "患者队列查询接口")
@Controller
@RequestMapping("/hs")
public class HPS_takeNoSearchController {

	@Autowired
	private HPS_takeNoSearchService hsService;
	// 必传参数
	private String[] parameter = { "orgcode", "appid" };

	/**
	 * 
	 * EXPLAIN: 患者队列查询
	 * 
	 * @param object
	 * @return
	 */
	@ResponseBody
	@ApiOperation(value = "患者队列查询", tags = { "APP" }, notes = "患者队列查询")
	@RequestMapping(value = "/HPS_takeNoSearch",produces="application/json;charset=utf-8", method = { RequestMethod.POST })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "响应成功"), @ApiResponse(code = 404, message = "未请求到资源") })
	@DataSource(DataSourceNames.JCYL)
	public String HPS_PersonalInformation(
			@ApiParam(value = "查询条件xml结构字符串", required = true) @RequestBody String object) {
		Map<String, Object> data = funUtils.ApiRequestHeaderValidation(parameter, object);
		String orgcode = ""; // 医疗机构代码
		String appid = ""; // 预约单号
		String depid = ""; // 科室ID
		String doctorid = ""; // 医生ID
		String endtime = ""; // 截至时间
		String queueno = ""; // 队列号
		try {
			orgcode = data.get("orgcode").toString(); // 医疗机构代码
			appid = data.get("appid").toString(); //// 预约单号
			if (data.containsKey("depid"))
				depid = data.get("depid").toString(); //// 科室ID
			if (data.containsKey("doctorid"))
				doctorid = data.get("doctorid").toString();// 医生ID
			if (data.containsKey("endtime"))
				endtime = data.get("endtime").toString(); // 截至时间
			if (data.containsKey("queueno"))
				queueno = data.get("queueno").toString(); // 队列号

		} catch (Exception e) {
			e.printStackTrace();
			String mapToXmlStr = XmlUtil.mapToXmlStr(data, "request");
			return mapToXmlStr;
		}
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> headMap = new HashMap<String, Object>();
//		HPS_takeNoSearchInfo my_map = hsService.getAPIHPS(orgcode, appid, depid, doctorid, endtime, queueno);
//		if (my_map == null) {
//			headMap.put("result", 1);
//			headMap.put("desc", "查询失败！无匹配信息。");
//			resultMap.put("head", headMap);
//			resultMap.put("data", null);
//			String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
//			return mapToXmlStr;
//		}
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("queuenum", my_map.getQueuenum()); // queuenum 当前队列人数
//		map2.put("hasno", my_map.getHasno()); // hasno 是否还有余号
//		map2.put("averagetime", my_map.getAveragetime()); // averagetime 看诊病人的平均时间
//-------------------------------------------------------------------------------
//		// 演示时不提供数据持久化相关操作
		Map<String, Object> map2 = hsService.HPS_HealthyHistory(orgcode, appid, depid, doctorid, endtime, queueno);
		headMap.put("result", 0);
		headMap.put("desc", "查询成功！");
		resultMap.put("head", headMap);
		resultMap.put("data", map2);
		String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
		return mapToXmlStr;
	}

}
