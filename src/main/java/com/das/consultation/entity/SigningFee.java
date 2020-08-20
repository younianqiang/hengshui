package com.das.consultation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 签约费用信息(SigningFee)实体类
 *
 * @author jun
 * @since 2020-08-14 15:30:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SigningFee implements Serializable {
    private static final long serialVersionUID = -66797531538111843L;
    /**
    * 最后修改时间##
    */
    private Date lastUpdateDtime;
    /**
    * 组织机构代码##STD_ORG_CODE
    */
    private String orgCode;
    /**
    * 病人ID##
    */
    private String patientId;
    /**
    * 城乡居民健康档案编号##
    */
    private String healthRecordNo;
    /**
    * 医保类型##0：新农合；1：职工医保；2：居民医保；9：其他
    */
    private String medicalInsuranceType;
    /**
    * 报补类型##农合和医疗
    */
    private String reimbursementType;
    /**
    * 签约金额##
    */
    private String signingAmount;
    /**
    * 公共卫生承担金额##
    */
    private String publicHealthAmount;
    /**
    * 服务包应收金额总计##
    */
    private String servicePackRecAmount;
    /**
    * 服务包减免金额总计##
    */
    private String servicePackRedAmount;
    /**
    * 服务包新农合（医保）补偿金额总计##
    */
    private String servicePackMedAmount;
    /**
    * 服务包应自付金额总计##
    */
    private String servicePackSlefAmount;
    /**
    * 实收金额总计##
    */
    private String collectedAmount;
    /**
    * 是否已收费##STD_WHETHER_MARK
    */
    private String chargeFlag;
    /**
    * 收费时间##
    */
    private String chargeTime;
    /**
    * 收款金额##
    */
    private String chargeAmount;
    /**
    * 结存金额##
    */
    private String depositAmount;
    /**
    * 收费人员姓名##
    */
    private String payee;
    /**
    * 收费机构名称##
    */
    private String cashRegister;
    /**
    * 结算提交人编码##
    */
    private String reckonerCode;

}