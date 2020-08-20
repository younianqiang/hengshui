package com.das.consultation.controller.xinyi;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.xinyi.EventInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import com.das.consultation.util.PublicMethodUtil;
import lombok.NonNull;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jun on 2020/8/17
 * describe:患者事件信息查询
 * version 1.0
 */
@RestController
public class EventInfoController {
    @RequestMapping(value = "/RDT_GetEventInfo", method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetEventInfo(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String visitid = data.getString("visitid");
        @NonNull EventInfo eventInfo = new EventInfo();
        eventInfo.setEventdate("2019-09-10");
        eventInfo.setEventcode("2456778");
        eventInfo.setEventname("新冠肺炎");
        eventInfo.setVisitid(visitid);
        eventInfo.setOrgcode(orgCode);
        eventInfo.setOrgname("衡水卫生院");




        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(eventInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(visitid)) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(eventInfo)) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("查询成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("查询失败");
                    return JsonXmlUtils.jsonToXml(null, xmlMessage);
                }
            } else {
                xmlMessage.setResult("1");
                xmlMessage.setDesc("参数错误");
                return JsonXmlUtils.jsonToXml(null, xmlMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
            xmlMessage.setResult("1");
            xmlMessage.setDesc("查询异常");
        }
        return JsonXmlUtils.jsonToXml(object, xmlMessage);
    }
}
