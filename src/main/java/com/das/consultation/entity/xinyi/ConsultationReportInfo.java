package com.das.consultation.entity.xinyi;

import com.das.consultation.entity.ConsultationReportKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Date;

/**
 * created by jun on 2020/8/5
 * describe:会诊报告信息
 * version 1.0
 */
@Entity
@Table(name = "CONSULT_REPORT_INFO")
@IdClass(ConsultationReportKey.class)
@DynamicInsert
@DynamicUpdate
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationReportInfo {
    /**
     * 医疗机构代码
     */
    @Column
    private String orgcode;
    /**
     * 患者基本信息ID
     */
    @Column
    private String patientid;
    /**
     * 创建人
     */
    @Column
    private String createoperator;
    /**
     * 创建时间
     */
    @Column
    private Date createtime;
    /**
     * 诊断意见
     */
    @Column
    private String diagnose;
    /**
     * 病种主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String diseaseid;
    /**
     * 疫情
     */
    @Column
    private String epidemic;
    /**
     * 是否有效
     */
    @Column
    private String flag;
    /**
     * ICD10主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String icd10id;
    /**
     * 操作人
     */
    @Column
    private String operatorid;
    /**
     * 会诊主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String primid;
    /**
     * 书写报告科室id
     */
    @Column
    private String reportdeptid;
    /**
     * 书写报告科室名称
     */
    @Column
    private String reportdeptname;
    /**
     * 是否报告医生
     */
    @Column
    private String reportdoc;
    /**
     * 生成报告名称
     */
    @Column
    private String reportfilename;
    /**
     * 书写报告医院_ID
     */
    @Column
    private String reporthopitalid;
    /**
     * 书写报告医院名称
     */
    @Column
    private String reporthopitalname;
    /**
     * 书写报告用户名称
     */
    @Column
    private String reportusername;
    /**
     * 特别说明
     */
    @Column
    private String suggestion;
    /**
     * 治疗建议
     */
    @Column
    private String treatment;
    /**
     * 报告状态
     */
    @Column
    private String triamain;
    /**
     * 最后更新人姓名
     */
    @Column
    private String modifier;
    /**
     * 最后更新时间
     */
    @Column
    private Date modifiedtime;
    /**
     * 上传时间
     */
    @Column
    private Date uploadtime;

}
