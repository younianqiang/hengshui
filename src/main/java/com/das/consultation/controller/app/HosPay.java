package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.HosPayInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HosPay {

    @RequestMapping(value = "/HPS_confirmPayInfo",method = {RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_confirmPayInfo(@RequestBody String body) throws DocumentException {

        JSONObject jsonpObject  = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonpObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String cardno = data.getString("cardno");
        String hispayno = data.getString("hispayno");
        String hispayorderno = data.getString("hispayorderno");
        String paytype = data.getString("paytype");
        String webpayno = data.getString("webpayno");
        String paymethod = data.getString("paymethod");
        String payamt = data.getString("payamt");
        List<HosPayInfo> hosPayInfos = new ArrayList<>();
        HosPayInfo hosPayInfo = new HosPayInfo();
        hosPayInfo.setFph("1233211234567");
        hosPayInfos.add(hosPayInfo);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(hosPayInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(cardno)&& !StringUtils.isEmpty(hispayno)&& !StringUtils.isEmpty(hispayorderno)&& !StringUtils.isEmpty(paytype)&& !StringUtils.isEmpty(webpayno)&& !StringUtils.isEmpty(paymethod)&& !StringUtils.isEmpty(payamt)) {
                if (array.size() != 0) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("查询成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("失败");
                }
            } else {
                xmlMessage.setResult("0");
                xmlMessage.setDesc("参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            xmlMessage.setResult("0");
            xmlMessage.setDesc("查询异常");
        }
        return JsonXmlUtils.jsonArrayToXml(array,xmlMessage,"que",null,null);
    }

}
