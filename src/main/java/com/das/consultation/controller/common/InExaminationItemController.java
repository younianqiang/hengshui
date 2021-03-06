package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.InExaminationItemInfo;
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
 * created by jun on 2020/8/17
 * describe:检查项目信息查询
 * version 1.0
 */
@RestController
public class InExaminationItemController {
    @RequestMapping(value = "/RDT_GetInExaminationItem", method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetInExaminationItem(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String checkapplpid = data.getString("checkapplpid");
        String checkid = data.getString("checkid");
        InExaminationItemInfo inExaminationItemInfo = new InExaminationItemInfo();
        inExaminationItemInfo.setCheckid("34567890");
        inExaminationItemInfo.setBodypartname("肠胃");
        inExaminationItemInfo.setStudymethodname("ct");


        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(inExaminationItemInfo);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(checkapplpid)&& !StringUtils.isEmpty(checkid)) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(inExaminationItemInfo)) {
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
