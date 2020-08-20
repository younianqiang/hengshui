package com.das.consultation.entity.app;

/*
 * 个人信息返回数据实体类(按照规范返回指定数据内容)
 *  @author zp
 */
public class PersonalInfo {
	
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
	
	/**性别**/
	public String sex;
	
	/**出生日期**/
	public String birthdate;
	
	/**联系电话**/
	public String phone;
	
	/**居住地址**/
	public String address;
	
	/**民族**/
	public String nation;
	
	/**婚姻状态**/
	public String marriage;
	
	/**文化程度**/
	public String education;
	
	/**常住类型**/
	public String Livetype;
	
	/**户籍地址**/
	public String idadress;
	
	/**职业**/
	public String job;
	
	/**工作单位**/
	public String work;
	
	/**ABO血型**/
	public String ABO;
	
	/**RH血型**/
	public String RH;
	
	/**支付方式**/
	public String medicalpaytype;
	
	/**应急联系人姓名**/
	public String familyname;
	
	/**应急联系人电话**/
	public String familytelephone;
	
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getMarriage() {
		return marriage;
	}
	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getLivetype() {
		return Livetype;
	}
	public void setLivetype(String livetype) {
		Livetype = livetype;
	}
	public String getIdadress() {
		return idadress;
	}
	public void setIdadress(String idadress) {
		this.idadress = idadress;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public String getABO() {
		return ABO;
	}
	public void setABO(String aBO) {
		ABO = aBO;
	}
	public String getRH() {
		return RH;
	}
	public void setRH(String rH) {
		RH = rH;
	}
	public String getMedicalpaytype() {
		return medicalpaytype;
	}
	public void setMedicalpaytype(String medicalpaytype) {
		this.medicalpaytype = medicalpaytype;
	}
	public String getFamilyname() {
		return familyname;
	}
	public void setFamilyname(String familyname) {
		this.familyname = familyname;
	}
	public String getFamilytelephone() {
		return familytelephone;
	}
	public void setFamilytelephone(String familytelephone) {
		this.familytelephone = familytelephone;
	}
}
