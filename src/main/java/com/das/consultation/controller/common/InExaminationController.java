package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.InExaminationInfo;
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
 * describe:检查申请单信息控制层
 * version 1.0
 */
@RestController
public class InExaminationController {
    @RequestMapping(value = "/RDT_GetInExamination",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetInExamination(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String visitId = data.getString("visitid");
        InExaminationInfo inExaminationInfo = new InExaminationInfo();
        inExaminationInfo.setCheckapplpid("098346871890");
        inExaminationInfo.setCheckid("455667765454");
        inExaminationInfo.setApplydeptname("内科");
        inExaminationInfo.setApplydoctorname("张三");
        inExaminationInfo.setApplytime(PublicMethodUtil.strToDate("2019-09-10 12:00:00"));
        inExaminationInfo.setApplyid("34546576879");
        inExaminationInfo.setClinicalinfo("肠胃不适，恶心干呕");
        inExaminationInfo.setClinicalconclude("胃病");
        inExaminationInfo.setClinichistory("无");
        inExaminationInfo.setRequestcheckitem("长期饮酒，导致肠胃不适");




        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(inExaminationInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(visitId) ) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(inExaminationInfo)) {
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
