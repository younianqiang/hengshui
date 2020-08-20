package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.BindCardInfo;
import com.das.consultation.entity.XmlMessage;
import com.das.consultation.util.JsonXmlUtils;
import com.das.consultation.util.PublicMethodUtil;
import org.dom4j.DocumentException;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * created by jun on 2020/8/10
 * describe:身份绑定控制层
 * version 1.0
 */
@RestController
public class BindCardController {
    @RequestMapping(value = "/HPS_bindCard",method = {RequestMethod.GET, RequestMethod.POST},
            produces = {"application/xml;charset=UTF-8"})
    public String HPS_bindCard(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String cardNo = data.getString("cardno");
        String cardType = data.getString("cardtype");
        String patientName = data.getString("patientname");
        String sex = data.getString("sex");
        String birthDate = data.getString("birthdate");
        String orgCode = data.getString("orgcode");
        String cardId = data.getString("cardid");
        String phone = data.getString("phone");
        BindCardInfo bindCardInfo = new BindCardInfo();//模拟数据
        bindCardInfo.setCardno(cardNo);
        bindCardInfo.setPatientname(patientName);
        bindCardInfo.setPhone(phone);
        bindCardInfo.setSex(sex);
        bindCardInfo.setBirthdate(PublicMethodUtil.ToDateTime(birthDate,4));
        bindCardInfo.setPatientid("45241513t51");
        bindCardInfo.setCardid(cardId);
        XmlMessage xmlMessage = new XmlMessage();
        String object = null;
        try {
            object = JSON.toJSONString(bindCardInfo);
            if (!StringUtils.isEmpty(cardNo) && !StringUtils.isEmpty(cardType) && !StringUtils.isEmpty(patientName)) {
                if (PublicMethodUtil.checkObjFieldIsNotNull(bindCardInfo)) {
                    xmlMessage.setResult("0");
                    xmlMessage.setDesc("认证成功");
                } else {
                    xmlMessage.setResult("1");
                    xmlMessage.setDesc("认证失败");
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
            xmlMessage.setDesc("绑定异常");
            return JsonXmlUtils.jsonToXml(null,xmlMessage);
        }
        return JsonXmlUtils.jsonToXml(object,xmlMessage);
    }

}
