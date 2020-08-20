package com.das.consultation.controller.xinyi;

import cn.hutool.core.util.XmlUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;
import com.das.consultation.entity.xinyi.RemoteCltInfo;
import com.das.consultation.service.xinyi.RemoteCltService;
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
 * 远程会诊信息控制层
 *
 * @author jun
 * @since 2020-08-05 09:28:29
 */
@RestController
public class RemoteCltController {
    /**
     * 服务对象
     */
    @Resource
    private RemoteCltService remoteCltService;


    @RequestMapping(value = "/RDT_SendychzCons", produces = {"application/xml;charset=UTF-8"})
    public String HPS_PersonalInformation(@RequestBody String object) {
        JSONObject xmlJSONObj = XML.toJSONObject(object);
        Map<String, Object> resultMap = new HashMap<>();
        Map<String, Object> headMap = new HashMap<>();
        try {
            JSONObject requestJjson = xmlJSONObj.getJSONObject("request");
            JSONObject dataJjson = requestJjson.getJSONObject("data");
            String orgCode = dataJjson.getStr("orgcode");
            String patientId = dataJjson.getStr("patientid");
            Date modifiedTime = PublicMethodUtil.strToDate(dataJjson.getStr("modifiedtime"));
            Date uploadTime = PublicMethodUtil.strToDate(dataJjson.getStr("uploadtime"));
            RemoteCltInfo remoteCltInfo = new RemoteCltInfo();
            remoteCltInfo.setOrgCode(orgCode);
            remoteCltInfo.setModifiedtime(modifiedTime);
            remoteCltInfo.setUploadtime(uploadTime);
            remoteCltInfo.setPatientId(patientId);
            remoteCltInfo.setPrimid(UUID.randomUUID().toString());

            if (!StringUtils.isEmpty(orgCode) && !StringUtils.isEmpty(patientId) && !StringUtils.isEmpty(modifiedTime) && !StringUtils.isEmpty(uploadTime)) {
                RemoteCltInfo rct = remoteCltService.insert(remoteCltInfo);
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