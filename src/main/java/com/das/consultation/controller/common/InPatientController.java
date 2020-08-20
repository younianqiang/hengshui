package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.InPatientInfo;
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
 * describe:患者就诊信息查询控制层
 * version 1.0
 */
@RestController
public class InPatientController {


    @RequestMapping(value = "/RDT_GetInPatientInfo", method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetInPatientInfo(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgcode = data.getString("orgcode");
        String patientid = data.getString("patientid");
        InPatientInfo inPatientInfo = new InPatientInfo();//模拟数据
        inPatientInfo.setEmpi("UKDSI314312KKJK43");
        inPatientInfo.setVisitid("123124656");
        inPatientInfo.setOrgcode("13100414143");
        inPatientInfo.setOrgname("衡水卫生院");
        inPatientInfo.setPatientid("12312r36");
        inPatientInfo.setPatientname("赵五");
        inPatientInfo.setSex("1");
        inPatientInfo.setAge(26);
        inPatientInfo.setAgeunit("岁");
        inPatientInfo.setNation("01");
        inPatientInfo.setMarriage("10");
        inPatientInfo.setOccupation("无");
        inPatientInfo.setWorkplace("无");
        inPatientInfo.setAddress("无");
        inPatientInfo.setComplaints("无");
        inPatientInfo.setAllergichistory("无");
        inPatientInfo.setPhysicalexamination("无");
        inPatientInfo.setVisitdate(PublicMethodUtil.strToDateDay("2018-8-13"));
        inPatientInfo.setDischargedate(PublicMethodUtil.strToDateDay("2018-8-15"));
        inPatientInfo.setClinichistory("无");
        inPatientInfo.setPresentillnesshistory("无");
        inPatientInfo.setPasthistory("无");
        inPatientInfo.setClinicdiagnose("无");
        inPatientInfo.setInfectioushistory("无");
        inPatientInfo.setOperationhistory("无");
        inPatientInfo.setObstericalhistory("无");
        inPatientInfo.setTransfutionhistory("无");
        inPatientInfo.setPreventiveinoculationhistory("无");
        inPatientInfo.setPersonalhistory("无");
        inPatientInfo.setMenstrualhistory("无");
        inPatientInfo.setFamilyhistory("无");
        inPatientInfo.setWeight("无");
        inPatientInfo.setPathologicaldiagnosis("无");
        inPatientInfo.setTakenmedicien("无");
        inPatientInfo.setTreatmentprocess("无");
        inPatientInfo.setAssistantcheck("无");
        inPatientInfo.setNationality("无");
        inPatientInfo.setHeight("无");
        inPatientInfo.setMitype("无");
        inPatientInfo.setMicardno("无");
        inPatientInfo.setHealthcardnumber("无");
        inPatientInfo.setPatiillnessstatus("无");
        inPatientInfo.setPatiapplytype("无");
        inPatientInfo.setPhysicalexamination("无");
        inPatientInfo.setClintherapeuticadvice("无");
        inPatientInfo.setClincomment("无");
        inPatientInfo.setClinpurpose("无");

        inPatientInfo.setCardid("510902199308287890");
        inPatientInfo.setTel("13882513451");
        inPatientInfo.setDept("口腔科");
        inPatientInfo.setVisitdate(PublicMethodUtil.strToDateDay("2019-09-18"));
        inPatientInfo.setWards("1号");
        inPatientInfo.setBed("23床");
        inPatientInfo.setVisittype("1");
        inPatientInfo.setPatientno("23153352");
        inPatientInfo.setVisittime("4");
        XmlMessage xmlMessage = new XmlMessage();
        String object = "无";
        try {
            object = JSON.toJSONString(inPatientInfo);
            if (!StringUtils.isEmpty(orgcode) && !StringUtils.isEmpty(patientid)) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(inPatientInfo)) {
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
            xmlMessage.setDesc("提交异常");
            return JsonXmlUtils.jsonToXml(null, xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(object, xmlMessage);
    }
}
