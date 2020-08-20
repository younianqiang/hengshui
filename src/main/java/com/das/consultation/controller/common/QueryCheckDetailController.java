package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.QueryCheckDetailInfo;
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
 * describe:检查报告详情查询
 * version 1.0
 */
@RestController
public class QueryCheckDetailController {
    @RequestMapping(value = "/HPS_queryCheckDetail", method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_queryCheckDetail(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String checkid = data.getString("checkid");
        QueryCheckDetailInfo queryCheckDetailInfo = new QueryCheckDetailInfo();
        queryCheckDetailInfo.setOrgcode(orgCode);
        queryCheckDetailInfo.setOrgname("衡水卫生院");
        queryCheckDetailInfo.setPatientname("张三");
        queryCheckDetailInfo.setSex("1");
        queryCheckDetailInfo.setDeptname("消化内科");
        queryCheckDetailInfo.setReportdoctor("曾医生");
        queryCheckDetailInfo.setCheckdoctor("赵医生");
        queryCheckDetailInfo.setApplydoctor("肖医生");
        queryCheckDetailInfo.setDevmodel("null");
        queryCheckDetailInfo.setCheckpart("肠胃");
        queryCheckDetailInfo.setLczd("null");
        queryCheckDetailInfo.setReportdate(PublicMethodUtil.strToDateDay("2019-09-19"));
        queryCheckDetailInfo.setChecksituation("null");
        queryCheckDetailInfo.setAdvice("null");
        queryCheckDetailInfo.setImageurl("null");



        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(queryCheckDetailInfo);
            if (!StringUtils.isEmpty(orgCode)&&!StringUtils.isEmpty(checkid)) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(queryCheckDetailInfo)) {
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
            xmlMessage.setDesc("查询异常");
        }
        return JsonXmlUtils.jsonToXml(object, xmlMessage);
    }
}
