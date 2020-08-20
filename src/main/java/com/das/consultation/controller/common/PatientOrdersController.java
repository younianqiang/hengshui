package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.PatientOrdersInfo;
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
 * describe:患者医嘱信息查询
 * version 1.0
 */
@RestController
public class PatientOrdersController {
    @RequestMapping(value = "/RDT_GetPatientOrders",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetPatientOrders(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String visitId = data.getString("visitid");
        PatientOrdersInfo patientOrdersInfo = new PatientOrdersInfo();
        patientOrdersInfo.setVisitid("2134545");
        patientOrdersInfo.setOrderid("213456787");
        patientOrdersInfo.setOrdergroupno("null");
        patientOrdersInfo.setOrdergroupsubno("null");
        patientOrdersInfo.setOrdertypecode("null");
        patientOrdersInfo.setOrdertypename("临时医嘱");
        patientOrdersInfo.setOrdername("护理长规");
        patientOrdersInfo.setOrdermemo("null");
        patientOrdersInfo.setMedicinetypename("null");
        patientOrdersInfo.setDrugname("null");
        patientOrdersInfo.setDrugspec("null");
        patientOrdersInfo.setDrugmainflag("null");
        patientOrdersInfo.setDosage("null");
        patientOrdersInfo.setTotaldosageunit("null");
        patientOrdersInfo.setNumberofherb("null");
        patientOrdersInfo.setDecoctionofherb("null");
        patientOrdersInfo.setDosageofherb("null");
        patientOrdersInfo.setFootnoteofherb("null");
        patientOrdersInfo.setOrderstatus("1");
        patientOrdersInfo.setOrderstatusname("正常");
        patientOrdersInfo.setOrdertime(PublicMethodUtil.strToDate("2018-08-18 12:00:00"));
        patientOrdersInfo.setStoppersonname("null");
        patientOrdersInfo.setStoptime(PublicMethodUtil.strToDate("2018-08-18 12:00:00"));
        patientOrdersInfo.setOpenexecutor("null");
        patientOrdersInfo.setStopexecutor("null");
        patientOrdersInfo.setPrescriptiondosageday("null");
        patientOrdersInfo.setDrugusage("null");
        patientOrdersInfo.setPrescriptiondosageday("null");
        patientOrdersInfo.setCapacityquantity("null");
        patientOrdersInfo.setExecutiontime(PublicMethodUtil.strToDate("2018-08-18 12:00:00"));
        patientOrdersInfo.setOrgcode(orgCode);
        patientOrdersInfo.setOrgname("衡水卫生院");




        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(patientOrdersInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(visitId) ) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(patientOrdersInfo)) {
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
