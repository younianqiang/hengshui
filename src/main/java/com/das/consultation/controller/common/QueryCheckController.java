package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.QueryCheckInfo;
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
 * created by jun on 2020/8/17
 * describe:检查报告列表查询控制层
 * version 1.0
 */
@RestController
public class QueryCheckController {
    @RequestMapping(value = "/HPS_queryCheck",method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_queryCheck (@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String visittype = data.getString("visittype");
        String patientno = data.getString("patientno");
        String patcardno = data.getString("patcardno");
        String begindate = data.getString("begindate");
        String enddate = data.getString("enddate");
        String checkid = data.getString("checkid");

        List<QueryCheckInfo> queryCheckInfos = new ArrayList<>();
        QueryCheckInfo queryCheckInfo = new QueryCheckInfo();
        queryCheckInfo.setCheckid("21345466");
        queryCheckInfo.setDeptname("内科");
        queryCheckInfo.setPatientname("张三");
        queryCheckInfo.setCheckpart("心脏");
        queryCheckInfo.setCheckname("心律检查");
        queryCheckInfo.setChecktime(PublicMethodUtil.strToDate("2019-08-10 12:00:00"));
        queryCheckInfos.add(queryCheckInfo);

        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(queryCheckInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(visittype)&& !StringUtils.isEmpty(patientno) && !StringUtils.isEmpty(patcardno) && !StringUtils.isEmpty(begindate)
                    && !StringUtils.isEmpty(enddate)&& !StringUtils.isEmpty(checkid)) {
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
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"items",new String[]{"orgcode","orgname"},new String[]{"4576799887654","衡水卫生院"});
    }
}
