package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.SubmitSchInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import com.das.consultation.util.PublicMethodUtil;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jun on 2020/8/12
 * describe:预约提交控制层
 * version 1.0
 */
@RestController
public class SubmitSchController {

    @RequestMapping(value = "/HPS_submitSch",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_submitSch(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String schId = data.getString("schid");
        String patientId = data.getString("patientid");
        SubmitSchInfo submitSchInfo = new SubmitSchInfo();//模拟数据
        submitSchInfo.setOrderid("123124656");
        submitSchInfo.setTokeno("123456");
        submitSchInfo.setOrderstatus("12");
        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(submitSchInfo);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(schId) && !StringUtils.isEmpty(patientId)) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(submitSchInfo)) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("提交成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("提交失败");
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
            xmlMessage.setDesc("提交异常");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(object,xmlMessage);
    }

}
