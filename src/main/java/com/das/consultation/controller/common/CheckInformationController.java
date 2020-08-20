package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.CheckInformationInfo;
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
 * describe:检查信息查询
 * version 1.0
 */
@RestController
public class CheckInformationController {
    @RequestMapping(value = "/RDT_GetInExaminationInfo",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetInExaminationInfo(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String hoscardno = data.getString("hoscardno");
        CheckInformationInfo checkInformationInfo= new CheckInformationInfo();
        checkInformationInfo.setCheckapplpid("34567890543");
        checkInformationInfo.setCardid("343565787");
        checkInformationInfo.setStudyid("1346576898");
        checkInformationInfo.setDeptstudyid("69873434556676");
        checkInformationInfo.setDevicetypename("无");
        checkInformationInfo.setStudydescribe("无");
        checkInformationInfo.setStudytime(PublicMethodUtil.strToDate("2019-09-10 12:00:00"));
        checkInformationInfo.setImagecount(0);
        checkInformationInfo.setEmergencyflag(0);
        checkInformationInfo.setDstudyuid("UDA456789CDHJ234");
        checkInformationInfo.setPatientuid("YKL8967874345912");
        checkInformationInfo.setPatientname("张三");
        checkInformationInfo.setWeight((float) 68.34);
        checkInformationInfo.setTheight((float) 175.32);
        checkInformationInfo.setBirthdate(PublicMethodUtil.strToDateDay("1993-09-13"));
        checkInformationInfo.setAge(25);
        checkInformationInfo.setSex("1");
        checkInformationInfo.setCardid("51090219960883912");
        checkInformationInfo.setSocietyid("null");
        checkInformationInfo.setPhone("null");
        checkInformationInfo.setAddress("null");
        checkInformationInfo.setTypename("无");
        checkInformationInfo.setHoscardno("null");
        checkInformationInfo.setPatcardno("2456778989");
        checkInformationInfo.setFolk("10");
        checkInformationInfo.setSickroom("23");
        checkInformationInfo.setBedno("null");
        checkInformationInfo.setApplydoctor("null");
        checkInformationInfo.setApplydepartment("null");
        checkInformationInfo.setHospitalname("null");
        checkInformationInfo.setOrgcode(orgCode);
        checkInformationInfo.setPerformingphysicianname("null");
        checkInformationInfo.setReportdoctor("张医生");
        checkInformationInfo.setVerifydoctor("null");
        checkInformationInfo.setReporttime(PublicMethodUtil.strToDate("2019-09-19 12:00:00"));
        checkInformationInfo.setVerifytime(PublicMethodUtil.strToDate("2019-09-19 12:00:00"));
        checkInformationInfo.setReportdesc("null");
        checkInformationInfo.setReportdiagnose("null");
        checkInformationInfo.setSampleinfo("null");
        checkInformationInfo.setSampleacceptdoctor("null");
        checkInformationInfo.setNakedeyesee("null");
        checkInformationInfo.setFnmp((float) 0.34);

        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(checkInformationInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(hoscardno) ) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(checkInformationInfo)) {
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
