package com.das.consultation.controller.app;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.consultation.service.app.HsMECService;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value = "个人信息查询和医疗病史接口")
@Controller
@RequestMapping("/hs")
public class HsMECController {

	@Autowired
	HsMECService hsService;
	
	/**
	 * 个人信息(后续还需要完善取值empi)
	 * @param orgcode
	 * @param iccardno
	 * @return
	   *   接收到的参数格式需要符合：<request><head></head><data><patientid>mz3340549</patientid><orgcode>131102404796498</orgcode></data></request>
	 * produces = {"application/xml;charset=UTF-8"}
	 * RequestMethod.GET 	 RequestParam  
	 * RequestMethod.POST    RequestBody
	 */
	@ResponseBody
	@ApiOperation(value="个人信息",tags={"APP"}, notes="个人信息查询")
	@RequestMapping(value="/HPS_PersonalInformation",method= {RequestMethod.POST})
	@ApiResponses(value = {
            @ApiResponse(code = 200, message="响应成功"),
            @ApiResponse(code = 404, message = "未请求到资源")
    })
	public String HPS_PersonalInformation(@ApiParam(value = "查询条件xml结构字符串",required=true )@RequestBody String object) {
		System.out.println(object); 
		Map<String, Object> resultMap = new HashMap<String, Object>();
		  Map<String, Object> headMap = new HashMap<String, Object>();
		  try {
			  JSONObject xmlJSONObj = XML.toJSONObject(object);
			  JSONObject requestJjson = xmlJSONObj.getJSONObject("request");
			  JSONObject dataJjson = requestJjson.getJSONObject("data");
			  String orgcode = dataJjson.getStr("orgcode");
			  String patientid = dataJjson.getStr("patientid");
			  if(StringUtils.isNotBlank(orgcode) && StringUtils.isNotBlank(patientid)) {
				  Map<String, Object> personInfo = hsService.HPS_PersonalInformation(orgcode, patientid);
				  if(personInfo == null) {
					  headMap.put("result", 1);
					  headMap.put("desc", "查询失败！无匹配信息。");
					  resultMap.put("data", null); 
				  }else {
					  headMap.put("result", 0);
					  headMap.put("desc", "查询成功！");
					  resultMap.put("data", personInfo);
				  }
			  }else {
				  headMap.put("result", 1);
				  headMap.put("desc", "查询失败！查询条件不能为空。");
				  resultMap.put("data", null);
			  }
		  	} catch (Exception e) {
		  		e.printStackTrace();
		  		headMap.put("result", 1);
		  		headMap.put("desc", "查询失败！未按指定格式传入对应参数。");
		  		resultMap.put("data", null);
		  	}
		  resultMap.put("head", headMap);
		  String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
//		  System.out.println(mapToXmlStr);
//		  return AppUtils.convertJsonStr(mapToXmlStr);
		  return mapToXmlStr;
	}
	
	/**
	 * 医疗病史（后续还需要完善取值 标准不一致）
	 * @param orgcode
	 * @param iccardno
	 * @return
	   *   接收到的参数格式需要符合：<request><head></head><data><patientid>mz3340549</patientid><orgcode>131102404796498</orgcode></data></request>
	 */
	@ApiOperation(value="医疗病史",tags={"APP"}, notes="医疗病史查询")
	@RequestMapping(value="/HPS_HealthyHistory",method= {RequestMethod.POST})
	@ResponseBody
	public String HPS_HealthyHistory(@ApiParam(value = "查询条件xml结构字符串",required=true)@RequestBody String object) {
		  Map<String, Object> resultMap = new HashMap<String, Object>();
		  Map<String, Object> headMap = new HashMap<String, Object>();
		  try {
			  JSONObject xmlJSONObj = XML.toJSONObject(object);
			  JSONObject requestJjson = xmlJSONObj.getJSONObject("request");
			  JSONObject dataJjson = requestJjson.getJSONObject("data");
			  String orgcode = dataJjson.getStr("orgcode");
			  String patientid = dataJjson.getStr("patientid");
			  if(StringUtils.isNotBlank(orgcode) && StringUtils.isNotBlank(patientid)) {
				  Map<String, Object> HealthyHistory = hsService.HPS_HealthyHistory(orgcode, patientid);
				  if(HealthyHistory == null) {
					  headMap.put("result", 1);
					  headMap.put("desc", "查询失败！无匹配信息。");
					  resultMap.put("data", null);
				  }else {
					  headMap.put("result", 0);
					  headMap.put("desc", "查询成功！");
					  resultMap.put("data", HealthyHistory);
				  }
			  }else {
				  headMap.put("result", 1);
				  headMap.put("desc", "查询失败！查询条件未录全。");
				  resultMap.put("data", null);
			  }
		  	} catch (Exception e) {
		  		e.printStackTrace();
		  		headMap.put("result", 1);
		  		headMap.put("desc", "查询失败！查询条件不能为空。");
		  		resultMap.put("data", null);
		  	}
		  resultMap.put("head", headMap);
		  String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
		  return mapToXmlStr;
	}
	
}
