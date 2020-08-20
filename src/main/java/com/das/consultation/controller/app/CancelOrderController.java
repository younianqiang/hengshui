package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by jun on 2020/8/12
 * describe:取消预约控制层
 * version 1.0
 */
@RestController
public class CancelOrderController {

    @RequestMapping(value = "/HPS_cancelOrder",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_cancelOrder(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String orderId = data.getString("orderid");
        String payNo = data.getString("payno");
        String payamout = data.getString("payamout");
        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = "{'orderid':'453537534323'}";
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(orderId) && !StringUtils.isEmpty(payNo)&&!StringUtils.isEmpty(payamout)) {
                if (!StringUtils.isEmpty(object)) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("取消成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("取消失败");
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
            xmlMessage.setDesc("取消异常");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(object,xmlMessage);
    }
}
