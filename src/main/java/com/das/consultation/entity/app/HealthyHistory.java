package com.das.consultation.entity.app;

/**
 * 医疗病史返回实际内容映射实体
 * @author zp
 *
 */
public class HealthyHistory {
	
	/**医疗机构代码**/
	public String orgcode;
	
	/**用户主索引**/
	public String empi;
	
	/**患者姓名**/
	public String patientname;
	
	/**证件类型**/
	public String idcardtype;
	
	/**证件号码**/
	public String iccardno;
	
	/**药物过敏史**/
	public String drugallergy;
	
	/**遗传病史**/
	public String genetichistory;
	
	/**暴露史**/
	public String exposurehistory;
	
	/**残疾情况**/
	public String deformity;
	
	/**既往手术**/
	public String operation;
	
	/**既往外伤**/
	public String trauma;
	
	/**既往输血**/
	public String transfusion;
	
	/**既往疾病**/
	public String disease;
	
	/**家族史-父亲**/
	public String father;
	
	/**家族史-母亲**/
	public String mother;
	
	/**家族史-兄弟姐妹**/
	public String brother;
	
	/**家族史-子女**/
	public String son;
	
	
	public String getDrugallergy() {
		return drugallergy;
	}
	public void setDrugallergy(String drugallergy) {
		this.drugallergy = drugallergy;
	}
	public String getGenetichistory() {
		return genetichistory;
	}
	public void setGenetichistory(String genetichistory) {
		this.genetichistory = genetichistory;
	}
	public String getExposurehistory() {
		return exposurehistory;
	}
	public void setExposurehistory(String exposurehistory) {
		this.exposurehistory = exposurehistory;
	}
	public String getDeformity() {
		return deformity;
	}
	public void setDeformity(String deformity) {
		this.deformity = deformity;
	}
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}
	public String getTrauma() {
		return trauma;
	}
	public void setTrauma(String trauma) {
		this.trauma = trauma;
	}
	public String getTransfusion() {
		return transfusion;
	}
	public void setTransfusion(String transfusion) {
		this.transfusion = transfusion;
	}
	public String getDisease() {
		return disease;
	}
	public void setDisease(String disease) {
		this.disease = disease;
	}
	public String getFather() {
		return father;
	}
	public void setFather(String father) {
		this.father = father;
	}
	public String getMother() {
		return mother;
	}
	public void setMother(String mother) {
		this.mother = mother;
	}
	public String getBrother() {
		return brother;
	}
	public void setBrother(String brother) {
		this.brother = brother;
	}
	public String getSon() {
		return son;
	}
	public void setSon(String son) {
		this.son = son;
	}
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getEmpi() {
		return empi;
	}
	public void setEmpi(String empi) {
		this.empi = empi;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getIdcardtype() {
		return idcardtype;
	}
	public void setIdcardtype(String idcardtype) {
		this.idcardtype = idcardtype;
	}
	public String getIccardno() {
		return iccardno;
	}
	public void setIccardno(String iccardno) {
		this.iccardno = iccardno;
	}
}
