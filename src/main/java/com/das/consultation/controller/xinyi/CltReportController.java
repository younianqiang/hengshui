package com.das.consultation.controller.xinyi;


import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import com.das.consultation.entity.xinyi.ConsultationReportInfo;
import com.das.consultation.service.xinyi.CltReportService;
import com.das.consultation.util.PublicMethodUtil;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 会诊报告信息控制层
 *
 * @author jun
 * @since 2020-08-05 09:28:29
 */
@RestController
public class CltReportController {
    /**
     * 服务对象
     */
    @Resource
    private CltReportService cltReportService;

    @RequestMapping(value = "/RDT_SendychzConsReport", produces = {"application/xml;charset=UTF-8"})
    public String RDT_SendychzConsReport(@RequestBody String object) {
        JSONObject xmlJSONObj = XML.toJSONObject(object);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> headMap = new HashMap<>();
        try {
            JSONObject request = xmlJSONObj.getJSONObject("request");
            JSONObject data = request.getJSONObject("data");
            ConsultationReportInfo consultationReportInfo = new ConsultationReportInfo();
            Date modifiedTime = PublicMethodUtil.strToDate(data.getStr("modifiedtime"));
            Date uploadTime = PublicMethodUtil.strToDate(data.getStr("uploadtime"));
            String orgCode = data.getStr("orgcode");
            String patientId = data.getStr("patientid");
            consultationReportInfo.setOrgcode(orgCode);
            consultationReportInfo.setModifiedtime(modifiedTime);
            consultationReportInfo.setUploadtime(uploadTime);
            consultationReportInfo.setPatientid(patientId);
            consultationReportInfo.setPrimid(UUID.randomUUID().toString());
            consultationReportInfo.setIcd10id(UUID.randomUUID().toString());
            consultationReportInfo.setDiseaseid(UUID.randomUUID().toString());
            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(patientId) && !StringUtils.isEmpty(modifiedTime) && !StringUtils.isEmpty(uploadTime)) {
                ConsultationReportInfo rct = cltReportService.insert(consultationReportInfo);
                if (rct != null) {
                    headMap.put("result", 0);
                    headMap.put("desc", "新增成功！");
                } else {
                    headMap.put("result", 1);
                    headMap.put("desc", "新增失败！");
                }
            } else {
                headMap.put("result", 1);
                headMap.put("desc", "参数错误");
            }
        } catch (Exception e) {
            e.printStackTrace();
            headMap.put("result", 1);
            headMap.put("desc", "新增异常");
        }
        resultMap.put("data", null);
        resultMap.put("head", headMap);
        return XmlUtil.mapToXmlStr(resultMap, "request");
    }
}