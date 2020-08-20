package com.das.consultation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * created by jun on 2020/8/4
 * describe:会诊实体类混合主键
 * version 1.0
 */
@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoteCltInfoKey implements Serializable {

    @Column(name = "orgCode")
    private String orgCode;

    @Column(name = "patientId")
    private String patientId;
    @Column(name = "primid")
    private String primid;
}
