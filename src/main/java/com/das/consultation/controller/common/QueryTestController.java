package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.QueryTestInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import com.das.consultation.util.PublicMethodUtil;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * created by jun on 2020/8/17
 * describe:检验报告列表查询控制层
 * version 1.0
 */
@RestController
public class QueryTestController {
    @RequestMapping(value = "/HPS_queryTest",method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_queryTest (@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String hoscardno = data.getString("hoscardno");
        String patcardno = data.getString("patcardno");
        Date begindate = PublicMethodUtil.strToDateDay(data.getString("begindate"));
        Date enddate = PublicMethodUtil.strToDateDay(data.getString("enddate"));
        String testid = data.getString("testid");

        List<QueryTestInfo> queryTestInfos = new ArrayList<>();
        QueryTestInfo  queryCheckInfo = new QueryTestInfo();
        queryCheckInfo.setTestid("24345674567");
        queryCheckInfo.setTestname("糖尿病检查");
        queryCheckInfo.setPatientname("张三");
        queryCheckInfo.setDeptname("内科");
        queryCheckInfo.setResultexplan("null");
        queryCheckInfo.setSex("1");
        queryCheckInfo.setDiagnosis("无");
        queryCheckInfo.setClinichospno("34567823456");
        queryCheckInfo.setApplydoctorname("张医生");
        queryCheckInfo.setCheckdoctorname("张医生");
        queryCheckInfo.setReportdoctorname("肖医生");
        queryCheckInfo.setSendtime(PublicMethodUtil.strToDateDay("2019-8-10"));

        queryTestInfos.add(queryCheckInfo);

        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(queryTestInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(hoscardno)&& !StringUtils.isEmpty(patcardno) && !StringUtils.isEmpty(patcardno) && !StringUtils.isEmpty(begindate)
                    && !StringUtils.isEmpty(enddate)&& !StringUtils.isEmpty(testid)) {
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
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"items",new String[]{"orgcode","orgname"},new String[]{"7656525623","衡水卫生院"});
    }
}
