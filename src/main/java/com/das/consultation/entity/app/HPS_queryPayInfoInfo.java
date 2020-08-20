/**
 * EXPLAIN:
 */
package com.das.consultation.entity.app;

/**
 * EXPLAIN:查询支付单据
 * USER: youqiang
 * UPDATAUSER: 
 * DATE:2020-8-18
 * URL:
 * FILENAME:HPS_queryPayInfo.javaVersion
 * VERSION:1.0
 */
public class HPS_queryPayInfoInfo {
	private String orgcode ;//orgcode	医疗机构代码	STRING	是	医疗机构的代码 
	private String cardtype ;//cardtype	医疗卡类型	STRING	是	参照值域字典
	private String cardno ;//cardno	医疗卡号	STRING	是	
	//出参
	private String payinfo;//payinfo（每个payInfo可能有多个detail）
	private String hispayorderno ;//hispayorderno	支付订单号	STRING	是	
	private Float hispaytotalamt ;//hispaytotalamt	订单总金额	NUMBER	是	保留2位小数，单位：元
	private String mzlsh ;//mzlsh	门诊流水号	STRING	是	
	private String hispayno ;//hispayno	支付单据号	STRING	是	
	private Float hispayamt ;//hispayamt	支付总金额	NUMBER	是	保留2位小数，单位：元
	private Float selfpayamt ;//selfpayamt	自费支付金额	NUMBER	是	保留2位小数，单位：元
	private Float socialpayamt ;//socialpayamt	医保支付金额	NUMBER	是	保留2位小数，单位：元
	private String paytype ;//paytype	费用类型	STRING	是	中文名称
	private String paystate ;//paystate	支付状态	STRING	是	0：未支付，1：已支付
	private String creattime ;//creattime	处方单时间	STRING	否	
	private String depname ;//depname	科室名称	STRING	是	
	private String doctorname ;//doctorname	医生姓名	STRING	是	
	private String mztype ;//mztype	是否医保结算	STRING	是	1：自费，2：医保
	private String detail;//detail(多项)
	private String itemcodehis ;//itemcodehis	His项目代码	STRING	是	
	private String itemcodeyb ;//itemcodeyb	医保项目代码	STRING	否	
	private String itemname ;//itemname	项目名称	STRING	是	
	private String std ;//std	规格	STRING	否	
	private Float amt ;//amt	数量	NUMBER	是	保留2位小数
	private String unit ;//unit	数量单位	STRING	是	
	private Float price ;//price	单价	NUMBER	是	保留2位小数，单位：元
	private Float detailpayamt ;//detailpayamt	应收价格	NUMBER	是	保留2位小数，单位：元
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getPayinfo() {
		return payinfo;
	}
	public void setPayinfo(String payinfo) {
		this.payinfo = payinfo;
	}
	public String getHispayorderno() {
		return hispayorderno;
	}
	public void setHispayorderno(String hispayorderno) {
		this.hispayorderno = hispayorderno;
	}
	public Float getHispaytotalamt() {
		return hispaytotalamt;
	}
	public void setHispaytotalamt(Float hispaytotalamt) {
		this.hispaytotalamt = hispaytotalamt;
	}
	public String getMzlsh() {
		return mzlsh;
	}
	public void setMzlsh(String mzlsh) {
		this.mzlsh = mzlsh;
	}
	public String getHispayno() {
		return hispayno;
	}
	public void setHispayno(String hispayno) {
		this.hispayno = hispayno;
	}
	public Float getHispayamt() {
		return hispayamt;
	}
	public void setHispayamt(Float hispayamt) {
		this.hispayamt = hispayamt;
	}
	public Float getSelfpayamt() {
		return selfpayamt;
	}
	public void setSelfpayamt(Float selfpayamt) {
		this.selfpayamt = selfpayamt;
	}
	public Float getSocialpayamt() {
		return socialpayamt;
	}
	public void setSocialpayamt(Float socialpayamt) {
		this.socialpayamt = socialpayamt;
	}
	public String getPaytype() {
		return paytype;
	}
	public void setPaytype(String paytype) {
		this.paytype = paytype;
	}
	public String getPaystate() {
		return paystate;
	}
	public void setPaystate(String paystate) {
		this.paystate = paystate;
	}
	public String getCreattime() {
		return creattime;
	}
	public void setCreattime(String creattime) {
		this.creattime = creattime;
	}
	public String getDepname() {
		return depname;
	}
	public void setDepname(String depname) {
		this.depname = depname;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}
	public String getMztype() {
		return mztype;
	}
	public void setMztype(String mztype) {
		this.mztype = mztype;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getItemcodehis() {
		return itemcodehis;
	}
	public void setItemcodehis(String itemcodehis) {
		this.itemcodehis = itemcodehis;
	}
	public String getItemcodeyb() {
		return itemcodeyb;
	}
	public void setItemcodeyb(String itemcodeyb) {
		this.itemcodeyb = itemcodeyb;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getStd() {
		return std;
	}
	public void setStd(String std) {
		this.std = std;
	}
	public Float getAmt() {
		return amt;
	}
	public void setAmt(Float amt) {
		this.amt = amt;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Float getDetailpayamt() {
		return detailpayamt;
	}
	public void setDetailpayamt(Float detailpayamt) {
		this.detailpayamt = detailpayamt;
	}
	
	
}
