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
import com.das.consultation.entity.app.HPS_takeNoInfo;
import com.das.consultation.service.app.HPS_takeNoService;
import com.das.consultation.util.funUtils;

import cn.hutool.core.util.XmlUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
/**
 * 
 * @EXPLAIN:患者报到/取号 
 * @USER: youqiang 
 * @UPDATAUSER: 
 * @DATE:2020-8-18 
 * @URL:/springMvcSsmDome/hs/HPS_takeNo?orgcode=123&yuyueid=123
 * @URL:<orgcode>0001892039</orgcode><yuyueid>0001892039</yuyueid><orderno>0001892039</orderno><deptid>0001892039</deptid><truename>0001892039</truename><cardno>0001892039</cardno><cardtype>0001892039</cardtype>
 * @FILENAME:HPS_takeNoController.javaVersion 
 * @VERSION:1.0
 */
@Api(value = "患者报到/取号接口")
@Controller
@RequestMapping("/hs")
public class HPS_takeNoController {

	@Autowired
	private HPS_takeNoService hsService;
	// 必传参数
	private String[] parameter = { "orgcode", "yuyueid" };

	/**
	 * 
	 * EXPLAIN:患者报到/取号
	 * @param object
	 * @return
	 */
	@ResponseBody
	@ApiOperation(value = "患者报到/取号", tags = { "APP" }, notes = "患者报到/取号")
	@RequestMapping(value = "/HPS_takeNo",produces="application/json;charset=utf-8", method = { RequestMethod.POST })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "响应成功"), @ApiResponse(code = 404, message = "未请求到资源") })
	@DataSource(DataSourceNames.JCYL)
	public String HPS_PersonalInformation(
			@ApiParam(value = "查询条件xml结构字符串", required = true) @RequestBody String object) {
		Map<String, Object> data = funUtils.ApiRequestHeaderValidation(parameter, object);
		String orgcode = "";   //医疗机构代码     
		String yuyueid = "";   //预约订单id     
		String orderno = "";   //订单号        
		String deptid = "";    //科室id       
		String truename = "";  //姓名         
		String cardno = "";    //卡号         
		String cardtype = "";  //卡类型        
		try {
			orgcode = data.get("orgcode").toString(); // 医疗机构代码
			yuyueid = data.get("yuyueid").toString(); // 预约订单id
			if (data.containsKey("orderno"))
				orderno = data.get("orderno").toString(); // 订单号
			if (data.containsKey("deptid"))
				deptid = data.get("deptid").toString(); // 科室id
			if (data.containsKey("truename"))
				truename = data.get("truename").toString(); // 姓名
			if (data.containsKey("cardno"))
				cardno = data.get("cardno").toString(); // 卡号
			if (data.containsKey("cardtype"))
				cardtype = data.get("cardtype").toString(); // 卡类型

		} catch (Exception e) {
			e.printStackTrace();
			String mapToXmlStr = XmlUtil.mapToXmlStr(data, "request");
			return mapToXmlStr;
		}

		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> headMap = new HashMap<String, Object>();
//		HPS_takeNoInfo my_map = hsService.getAPIHPS(orgcode, yuyueid, orderno, deptid, truename, cardno, cardtype);
//		if (my_map == null) {
//			headMap.put("result", 1);
//			headMap.put("desc", "查询失败！无匹配信息。");
//			resultMap.put("head", headMap);
//			resultMap.put("data", null);
//			String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
//			return mapToXmlStr;
//		}
//		Map<String, Object> map2 = new HashMap<String, Object>();
//		map2.put("queueno", my_map.getQueueno()); // 排队号
//		map2.put("queuenum", my_map.getQueuenum()); // 排队人数
//		map2.put("mzlsh", my_map.getMzlsh()); // 门诊流水号
//		map2.put("qhfph", my_map.getQhfph()); // 取号发票号
//		// 演示时不提供数据持久化相关操作
		Map<String, Object> map2 = hsService.HPS_HealthyHistory(orgcode,yuyueid, orderno,deptid,truename,cardno, cardtype);
		headMap.put("result", 0);
		headMap.put("desc", "查询成功！");
		resultMap.put("head", headMap);
		resultMap.put("data", map2);
		String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
//		String mapToXmlStr = AppUtils.convertJsonStr(resultMap);
		return mapToXmlStr;
	}

}
