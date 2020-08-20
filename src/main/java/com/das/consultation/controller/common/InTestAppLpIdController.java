package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.ApplicationFormInfo;
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
 * describe:5.2.14检验申请单信息查询控制层
 * version 1.0
 */
@RestController
public class InTestAppLpIdController {
    @RequestMapping(value = "/RDT_GetIntestapplpId",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetIntestapplpId(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String visitId = data.getString("visitid");
        ApplicationFormInfo applicationFormInfo = new ApplicationFormInfo();
        applicationFormInfo.setTestapplpid("0966554421");
        applicationFormInfo.setTestid("55676783112");
        applicationFormInfo.setTestname("糖尿病");
        applicationFormInfo.setTestername("张医生");
        applicationFormInfo.setTestdate(PublicMethodUtil.strToDateDay("2019-09-10"));
        applicationFormInfo.setReportername("李医生");
        applicationFormInfo.setReportdate(PublicMethodUtil.strToDateDay("2019-9-10"));
        applicationFormInfo.setVisitid(visitId);
        applicationFormInfo.setTestcode("445678654231");
        applicationFormInfo.setSamplename("null");
        applicationFormInfo.setOrgcode(orgCode);
        applicationFormInfo.setOrgname("衡水卫生院");




        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(applicationFormInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(visitId) ) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(applicationFormInfo)) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("查询成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("查询失败");
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
        }
        return JsonXmlUtils.jsonToXml(object,xmlMessage);
    }
}
