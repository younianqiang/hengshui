package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.ScheduleInfo;
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
import java.util.List;

/**
 * created by jun on 2020/8/11
 * describe:排版信息查询控制层
 * version 1.0
 */
@RestController
public class ScheduleController {

    @RequestMapping(value = "/HPS_getSchedule",method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_getSchedule (@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String depId = data.getString("depid");
        String doctorId = data.getString("doctorid");
        String beginDate = data.getString("begindate");
        String endDate = data.getString("enddate");
        List<ScheduleInfo> scheduleInfos = new ArrayList<>();
        ScheduleInfo scheduleInfo = new ScheduleInfo();
        scheduleInfo.setScheduleid("213142494");
        scheduleInfo.setDepid("12542076");
        scheduleInfo.setDepname("眼科");
        scheduleInfo.setDoctorid("235t32723115");
        scheduleInfo.setDoctorname("曾医生");
        scheduleInfo.setVisitdate(PublicMethodUtil.ToDateTime("2020-8-12",4));
        scheduleInfo.setIsyuyue("1");
        scheduleInfo.setTimetype("白班");
        scheduleInfo.setReglevel("普通门诊");
        String str = PublicMethodUtil.getStringDate();
        scheduleInfo.setBegintime(PublicMethodUtil.strToDate(str));
        scheduleInfo.setEndtime(PublicMethodUtil.strToDate(str));
        scheduleInfo.setGuahaoamt((float) 23.21);
        scheduleInfo.setVisitamt((float) 30.34);
        scheduleInfo.setYuyuemax(214);
        scheduleInfo.setYuyuenum(143);
        scheduleInfos.add(scheduleInfo);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(scheduleInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(depId)&& !StringUtils.isEmpty(doctorId) && !StringUtils.isEmpty(beginDate) && !StringUtils.isEmpty(endDate)) {
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
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"schedule",null,null);
    }
}
