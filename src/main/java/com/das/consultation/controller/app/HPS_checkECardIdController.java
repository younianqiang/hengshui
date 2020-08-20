package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.HPS_checkECardId;
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
public class HPS_checkECardIdController {

    @RequestMapping(value = "/HPS_checkECardId",method = {RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_checkECardId(@RequestBody String body) throws DocumentException {
        JSONObject jsonObject  = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String idtype = data.getString("idtype");
        String idno = data.getString("idno");
        String ecardid = data.getString("ecardid");
        List<HPS_checkECardId> hps_checkECardIds = new ArrayList<>();
        HPS_checkECardId hps_checkECardId = new HPS_checkECardId();
        hps_checkECardId.setIsvalid("111333");
        hps_checkECardIds.add(hps_checkECardId);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(hps_checkECardIds);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(idtype) && !StringUtils.isEmpty(idno) && !StringUtils.isEmpty(ecardid)) {
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
