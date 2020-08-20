package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.TopDeptInfo;
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
 * created by jun on 2020/8/12
 * describe:一级科室查询
 * version 1.0
 */
@RestController
public class TopDeptController {
    @RequestMapping(value = "/HPS_getTopDeptInfo",method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_getTopDeptInfo (@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");

        List<TopDeptInfo> topDeptInfos = new ArrayList<>();
        TopDeptInfo topDeptInfo = new TopDeptInfo();
        topDeptInfo.setDepid("23154998");
        topDeptInfo.setDepname("内科");
        topDeptInfo.setDepintro("无");
        topDeptInfo.setCatno("1CK534KN12353");
        topDeptInfo.setCatname("内科");
        topDeptInfo.setDeptscope("肠胃");
        topDeptInfo.setIsimportant("1");
        topDeptInfo.setOrderscope("2");

        topDeptInfos.add(topDeptInfo);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(topDeptInfos);
            if (!StringUtils.isEmpty(orgCode)) {
                if (array.size() != 0) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("查询成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("查询失败请重试");
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
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"dept",null,null);
    }
}
