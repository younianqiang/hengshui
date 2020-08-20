package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.AvailableNumResourceInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import com.das.consultation.util.PublicMethodUtil;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * created by jun on 2020/8/11
 * describe:号源信息查询控制层
 * version 1.0
 */
@RestController
public class AvailableNumResourceController {
    @RequestMapping(value = "/HPS_getAvailableNumResource",
            method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_getAvailableNumResource (@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String depId = data.getString("depid");
        String doctorId = data.getString("doctorid");
        String scheduleId = data.getString("scheduleid");
        List<AvailableNumResourceInfo> availableNumResourceInfos = new ArrayList<>();
        AvailableNumResourceInfo availableNumResourceInfo =new AvailableNumResourceInfo();
        availableNumResourceInfo.setScheduleid(scheduleId);
        availableNumResourceInfo.setNumid("134");
        availableNumResourceInfo.setBegintime(PublicMethodUtil.strToDate("2018-08-18 12:00:23"));
        availableNumResourceInfo.setEndtime(PublicMethodUtil.strToDate("2018-08-18 15:00:34"));
        availableNumResourceInfo.setYuyuemax(2314);
        availableNumResourceInfo.setYuyuenum(1324);
        availableNumResourceInfos.add(availableNumResourceInfo);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(availableNumResourceInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(depId)&& !StringUtils.isEmpty(doctorId)&& !StringUtils.isEmpty(scheduleId)) {
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
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"que",null,null);
    }
}
