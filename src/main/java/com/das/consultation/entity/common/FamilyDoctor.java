package com.das.consultation.entity.common;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 家庭医生签约医生 (FamilyDoctor)实体类
 *
 * @author jun
 * @since 2020-08-10 15:30:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JacksonXmlRootElement(localName = "FamilyDoctor")
public class FamilyDoctor implements Serializable {
    private static final long serialVersionUID = 166851772148121336L;
    /**
     * 医生id
     */
    private String doctorid;
    /**
     * 医生姓名
     */
    private String doctorname;
    /**
     * 医生职称
     */
    private String doctorzc;
    /**
     * 性别
     */
    private String sex;
    /**
     * 专业
     */
    private String expert;
    /**
     * 医生介绍
     */
    private String introduction;
    /**
     * 诊疗范围
     */
    private String deptscope;
    /**
     * 医生头像
     */
    private String doctorpic;

}