package com.das.consultation;

import com.das.consultation.util.OkHttpUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;


/**
 * created by jun on 2020/8/14
 * describe:
 * version 1.0
 */
@SpringBootTest
public class DruidTest {
    @Autowired
    DataSource dataSource;
    @Test
    void TestContext(){
//        System.out.println(dataSource.getClass());
        String url = "http://192.168.2.83:8080/RDT_GetPatientInfo";
        String xml ="<request><head></head><data><patientid>mz3340549</patientid><orgcode>131102404796498</orgcode></data></request>";
        String postXml = OkHttpUtils.postXml(url, xml);
        System.out.println(postXml);
    }
}
