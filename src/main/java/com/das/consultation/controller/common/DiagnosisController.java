package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.DiagnosisInfo;
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
 * describe:患者诊断信息查询
 * version 1.0
 */
@RestController
public class DiagnosisController {
    @RequestMapping(value = "/RDT_GetDiagnosisInfo",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetDiagnosisInfo(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String visitId = data.getString("visitid");
        DiagnosisInfo diagnosisInfo = new DiagnosisInfo();
        diagnosisInfo.setDiagnosisid("23456784567");
        diagnosisInfo.setDiagnosistypename("高血压");
        diagnosisInfo.setChndiagclass(PublicMethodUtil.strToDate("2019-08-10 12:00:00"));
        diagnosisInfo.setIcdcode("UZK12E329OP00345");
        diagnosisInfo.setDiagnosisdescribe("高血压");
        diagnosisInfo.setSyndromename("null");
        diagnosisInfo.setDiagsequence("无");
        diagnosisInfo.setOperator("张医生");
        diagnosisInfo.setOperatetime(PublicMethodUtil.strToDate("2019-08-10 12:00:00"));
        diagnosisInfo.setVisited("UI3DSG234");
        diagnosisInfo.setOrgcode("1245656788");
        diagnosisInfo.setOrgname("衡水卫生院");


        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(diagnosisInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(visitId) ) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(diagnosisInfo)) {
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
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(object,xmlMessage);
    }
}
