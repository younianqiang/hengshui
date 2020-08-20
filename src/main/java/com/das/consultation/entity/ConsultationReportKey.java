package com.das.consultation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * created by jun on 2020/8/5
 * describe:会诊报告混合主键
 * version 1.0
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationReportKey implements Serializable {
    @Column(name = "diseaseid")
    private String diseaseid;
    @Column(name = "icd10id")
    private String icd10id;
    @Column(name = "primid")
    private String primid;
}
