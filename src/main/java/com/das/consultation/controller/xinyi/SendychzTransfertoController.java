package com.das.consultation.controller.xinyi;

import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jun on 2020/8/12
 * describe:转诊转院记录
 * version 1.0
 */
@RestController
public class SendychzTransfertoController {
    @RequestMapping(value = "/RDT_SendychzTransferto",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_SendychzTransferto(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String orgName = data.getString("orgname");
        String patientId = data.getString("patientid");
        String update = data.getString("update");
        XmlMessage xmlMessage = new XmlMessage();
        try {
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(orgName) && !StringUtils.isEmpty(patientId) && !StringUtils.isEmpty(update)) {
                if (!StringUtils.isEmpty(body)) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("成功");
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
            xmlMessage.setDesc("异常");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(null,xmlMessage);
    }
}
