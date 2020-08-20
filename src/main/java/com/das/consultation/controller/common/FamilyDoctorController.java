package com.das.consultation.controller.common;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.FamilyDoctor;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 家庭医生签约医生 (FamilyDoctor)表控制层
 *
 * @author jun
 * @since 2020-08-10 15:30:57
 */
@RestController
public class FamilyDoctorController {
//    /**
//     * 服务对象
//     */
//    @Resource
//    private FamilyDoctorService familyDoctorService;

    //    @GetMapping(value = "/HPS_queryDoctorInfo", produces = {"application/xml;charset=UTF-8"})
//    public String HPS_PersonalInformation(@RequestBody String object) {
//        JSONObject xmlJSONObj = XML.toJSONObject(object);
//        Map<String, Object> resultMap = new HashMap<>();
//        Map<String, Object> headMap = new HashMap<>();
//        try {
//            JSONObject request = xmlJSONObj.getJSONObject("request");
//            JSONObject data = request.getJSONObject("data");
//
//            String orgCode = data.getStr("orgCode");
//            String depId = data.getStr("depId");
//            String beginDate = data.getStr("beginDate");
//            String endDate = data.getStr("endDate");
//            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(depId)&& !StringUtils.isEmpty(beginDate)&& !StringUtils.isEmpty(endDate)) {
//                FamilyDoctor familyDoctor = new FamilyDoctor();//模拟数据
//                familyDoctor.setDoctorId("1314135");
//                familyDoctor.setDoctorName("张医生");
//                familyDoctor.setDoctorZc("主任医师");
//                familyDoctor.setSex("1");
//                familyDoctor.setExpert("内科");
//                familyDoctor.setIntroduction("无");
//                familyDoctor.setDeptScope("呼吸道");
//                familyDoctor.setDoctorPic(null);
//                Map<String, Object> stringObjectMap = PublicMethodUtil.objectToMap(familyDoctor);
//                List<Map<String,Object> >doctors = new ArrayList<>();
//                doctors.add(stringObjectMap);
//                if (doctors.size() != 0) {
//                    headMap.put("result", 0);
//                    headMap.put("desc", "查询成功");
//                    resultMap.put("data",data);
//
//                } else {
//                    headMap.put("result", 1);
//                    headMap.put("desc", "没有该医生信息！");
//                    resultMap.put("data", null);
//                }
//            } else {
//                headMap.put("result", 1);
//                headMap.put("desc", "参数错误");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            headMap.put("result", 1);
//            headMap.put("desc", "查询异常");
//            resultMap.put("data", null);
//        }
//
//        resultMap.put("head", headMap);
//        return XmlUtil.mapToXmlStr(resultMap, "request");
//    }
    @RequestMapping(value = "/HPS_queryDoctorInfo",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_queryDoctorInfo(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String depId = data.getString("depid");
        String beginDate = data.getString("begindate");
        String endDate = data.getString("enddate");
        List<FamilyDoctor> familyDoctorList = new ArrayList<>();
        FamilyDoctor familyDoctor = new FamilyDoctor();//模拟数据
        familyDoctor.setDoctorid("1314135");
        familyDoctor.setDoctorname("张医生");
        familyDoctor.setDoctorzc("主任医师");
        familyDoctor.setSex("1");
        familyDoctor.setExpert("内科");
        familyDoctor.setIntroduction("无");
        familyDoctor.setDeptscope("呼吸道");
        familyDoctor.setDoctorpic(null);
        FamilyDoctor familyDoctor2 = new FamilyDoctor();//模拟数据
        familyDoctor2.setDoctorid("1344335");
        familyDoctor2.setDoctorname("赵医生");
        familyDoctor2.setDoctorzc("主任医师");
        familyDoctor2.setSex("2");
        familyDoctor2.setExpert("内科");
        familyDoctor2.setIntroduction("无");
        familyDoctor2.setDeptscope("口腔");
        familyDoctor2.setDoctorpic(null);
        familyDoctorList.add(familyDoctor2);
        familyDoctorList.add(familyDoctor);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(familyDoctorList);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(depId) && !StringUtils.isEmpty(beginDate) && !StringUtils.isEmpty(endDate)) {
                if (array.size() != 0) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("查询成功");
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
            xmlMessage.setDesc("查询异常");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"doctor",null,null);
    }
}