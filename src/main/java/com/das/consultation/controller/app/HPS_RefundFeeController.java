package com.das.consultation.controller.app;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.das.consultation.entity.app.HPS_RefundFee;
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

@RestController
public class HPS_RefundFeeController {
    @RequestMapping(value = "/HPS_RefundFee",method = {RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String HPS_RefundFee(@RequestBody String body) throws DocumentException{
        JSONObject jsonObject  = JsonXmlUtils.xmlToJson(body);
        JSONObject request = jsonObject.getJSONObject("request");
        JSONObject data = request.getJSONObject("data");
        String orgCode = data.getString("orgcode");
        String time = data.getString("time");
        String refundtype = data.getString("refundtype");
        String invoiceno = data.getString("invoiceno");
        String paytradeno = data.getString("paytradeno");
        String paymethod = data.getString("paymethod");
        String refundamt = data.getString("refundamt");
        String refundtime = data.getString("refundtime");
        String refundman = data.getString("refundman");
        List<HPS_RefundFee> hps_refundFees = new ArrayList<>();
        HPS_RefundFee hps_refundFee = new HPS_RefundFee();
        hps_refundFee.setInvoiceno("1233211234567");
        hps_refundFee.setRefundmchdd("1");
        hps_refundFee.setRefundstate("1");
        hps_refundFee.setRefundtradeno("1233211234567");
        hps_refundFee.setRefundtime(PublicMethodUtil.ToDateTime("2020-8-12",4));
        hps_refundFees.add(hps_refundFee);
        XmlMessage xmlMessage = new XmlMessage();
        JSONArray array = null;
        try {
            array = (JSONArray) JSON.toJSON(hps_refundFees);
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(paytradeno)&& !StringUtils.isEmpty(time)&& !StringUtils.isEmpty(paymethod)&& !StringUtils.isEmpty(refundamt)&& !StringUtils.isEmpty(refundtime)&& !StringUtils.isEmpty(refundman)) {
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
