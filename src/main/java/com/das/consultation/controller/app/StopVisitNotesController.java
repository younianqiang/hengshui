package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.StopVisitNotesInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import org.dom4j.DocumentException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by jun on 2020/8/11
 * describe:停诊通知
 * version 1.0
 */
@RestController
public class StopVisitNotesController {
    @RequestMapping(value = "/HPS_getStopVisitNotes", method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_getStopVisitNotes(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String array = data.getString("schedule");
        List<StopVisitNotesInfo> stopVisitNotesInfoList = JSON.parseArray(array, StopVisitNotesInfo.class);
        XmlMessage xmlMessage = new XmlMessage();
        if (orgCode != null && stopVisitNotesInfoList.size() != 0) {
            xmlMessage.setResult("0");
            xmlMessage.setDesc("已停止");
        } else {
            xmlMessage.setResult("1");
            xmlMessage.setDesc("参数错误");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(null, xmlMessage);
    }
}
