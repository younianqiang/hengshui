package com.das.consultation.controller.common;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.common.HospitalInfo;
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
 * describe:医院查询控制层
 * version 1.0
 */
@RestController
public class HospitalController {
    @RequestMapping(value = "/HPS_queryHospitalInfo",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_queryHospitalInfo(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgcode = data.getString("orgcode");
        HospitalInfo hospitalInfo = new HospitalInfo();//模拟数据
        hospitalInfo.setOrgaddress("四川省成都市武侯区599号");
        hospitalInfo.setOrgname("第三人民医院");
        hospitalInfo.setUnitlevel("3");
        hospitalInfo.setUnitlevelname("二甲");
        hospitalInfo.setOrgphone("1331299313");
        hospitalInfo.setBusline("无");
        hospitalInfo.setOrgcode(orgcode);
        hospitalInfo.setDetail("简介");
        hospitalInfo.setPaytype("1");
        hospitalInfo.setApppaytype("微信");
        hospitalInfo.setOrderday("1");
        hospitalInfo.setResourcemanagertype("0");
        hospitalInfo.setPatientcardneed("1");

        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(hospitalInfo);
            if (!StringUtils.isEmpty(orgcode) ) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(hospitalInfo)) {
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
