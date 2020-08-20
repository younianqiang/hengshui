
package com.das.consultation.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;


public class funUtils {
	public static Map<String, Object> ApiRequestHeaderValidation(String[] parameter,String object) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		Map<String, Object> headMap = new HashMap<String, Object>();
		Map<String, Object> valMap = new HashMap<String, Object>();
		try {
			JSONObject xmlJSONObj = XML.toJSONObject(object);
			JSONObject requestJjson = xmlJSONObj.getJSONObject("request").getJSONObject("data");
			JSONObject row = null;
			int i=0;
			for (String str : requestJjson.keySet()) {
				String valString = requestJjson.get(str).toString();
				if (Arrays.asList(parameter).contains(str)) {
					i++;
					if (valString == null || valString == "") {
						headMap.put("result", 1);
						headMap.put("desc", "查询失败！查询条件不能为空“"+str+"”。");
						resultMap.put("head", headMap);
						resultMap.put("data", null);
//						String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
						return resultMap;
					}
				}
				valMap.put(str, valString);
			}
			if(i!=parameter.length) {
				headMap.put("result", 1);
				headMap.put("desc", "查询失败！查询参数不足。");
				resultMap.put("head", headMap);
				resultMap.put("data", null);
//				String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
				return resultMap;
			}
			
		} catch (Exception e) {
	  		e.printStackTrace();
	  		headMap.put("result", 1);
	  		headMap.put("desc", "查询失败！未按指定格式传入对应参数。");
	  		resultMap.put("head", headMap);
	  		resultMap.put("data", null);
//	  		String mapToXmlStr = XmlUtil.mapToXmlStr(resultMap, "request");
			return resultMap;
	  	}
		return valMap;
	}
}
