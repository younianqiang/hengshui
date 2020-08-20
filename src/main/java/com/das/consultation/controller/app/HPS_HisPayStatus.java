package com.das.consultation.controller.app;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.HPS_HisPayStatusInfo;
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
public class HPS_HisPayStatus {

    @RequestMapping(value = "/HPS_HisPayStatus",method = {RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_HisPayStatus(@RequestBody String body) throws DocumentException{
        JSONObject jsonObject  = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String paytradeno = data.getString("paytradeno");
        List<HPS_HisPayStatusInfo> hps_hisPayStatusInfos = new ArrayList<>();
        HPS_HisPayStatusInfo hps_hisPayStatusInfo = new HPS_HisPayStatusInfo();
        hps_hisPayStatusInfo.setFph("12332111111");
        hps_hisPayStatusInfos.add(hps_hisPayStatusInfo);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(hps_hisPayStatusInfos);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(paytradeno)) {
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