package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.QueryTestDetailInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * created by jun on 2020/8/17
 * describe:检验报告详情查询控制层
 * version 1.0
 */
@RestController
public class QueryTestDetailController {
    @RequestMapping(value = "/HPS_queryTestDetail",method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_queryTestDetail (@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String testId = data.getString("testId");

        List<QueryTestDetailInfo> queryTestDetailInfos = new ArrayList<>();
        QueryTestDetailInfo queryTestDetailInfo= new QueryTestDetailInfo();
        queryTestDetailInfo.setItemcode("UEW545676879898");
        queryTestDetailInfo.setItemname("肠胃");
        queryTestDetailInfo.setItemresult("正常");
        queryTestDetailInfo.setRefrange("无");
        queryTestDetailInfo.setUnit("无");
        queryTestDetailInfo.setAbnormal("H");
        queryTestDetailInfos.add(queryTestDetailInfo);

        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(queryTestDetailInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(testId)) {
                if (array.size() != 0) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("查询成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("失败");
                    return JsonXmlUtils.jsonToXml(null,xmlMessage);
                }
            } else {
                xmlMessage.setResult("1");
                xmlMessage.setDesc("参数错误");
                return JsonXmlUtils.jsonToXml(null,xmlMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            xmlMessage.setResult("1");
            xmlMessage.setDesc("查询异常");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"items",new String[]{"orgcode","resultid","testid"},new String[]{"131100","3257686334","32434567"});
    }
}
