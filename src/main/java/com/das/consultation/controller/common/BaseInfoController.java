package com.das.consultation.controller.common;


import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import com.das.consultation.entity.common.BaseInfo;
import com.das.consultation.service.common.BaseInfoService;
import com.das.consultation.util.PublicMethodUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * 基本信息-个人基本信息 （必传）(BaseInfo)表控制层
 *
 * @author jun
 * @since 2020-08-07 13:39:17
 */
@RestController
public class BaseInfoController {
    /**
     * 服务对象
     */
    @Resource
    private BaseInfoService baseinfoService;

    @RequestMapping(value = "/RDT_GetPatientInfo", method = {RequestMethod.GET, RequestMethod.POST}, produces = {"application/xml;charset=UTF-8"})
    public String RDT_GetPatientInfo(@RequestBody String object) {
        JSONObject xmlJSONObj = XML.toJSONObject(object);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> headMap = new HashMap<>();
        try {
            JSONObject request = xmlJSONObj.getJSONObject("request");
            JSONObject data = request.getJSONObject("data");
            String orgCode = data.getStr("orgcode");
            String patientId = data.getStr("patientid");
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(patientId)) {
                BaseInfo rct = baseinfoService.getBaseInfoById(orgCode, patientId);
                if (rct != null) {
                    headMap.put("result", 0);
                    headMap.put("desc", "查询成功！");
                    resultMap.put("data", PublicMethodUtil.objectToMap(rct));
                } else {
                    headMap.put("result", 1);
                    headMap.put("desc", "没有该条信息！");
                    resultMap.put("data", null);
                }
            } else {
                headMap.put("result", 1);
                headMap.put("desc", "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            headMap.put("result", 1);
            headMap.put("desc", "查询异常");
            resultMap.put("data", null);
        }

        resultMap.put("head", headMap);
        return XmlUtil.mapToXmlStr(resultMap, "request");
    }

}