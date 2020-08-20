package com.das.consultation.entity.app;
/**
 * 患者报到/取号
 * @author youqiang
 *
 */
public class HPS_takeNoInfo {
	//入参
	private String orgcode  ;  //  orgcode	医疗机构代码	STRING	是	医疗机构的代码                     
	private String yuyueid  ;  //  yuyueid	预约订单id	STRING	是	                            
	private String orderno  ;  //  orderno	订单号	STRING	否	                                
	private String deptid   ;  //  deptid	科室id	STRING	否	                            
	private String truename ;  //  truename	姓名	STRING	否	                            
	private String cardno   ;  //  cardno	卡号	STRING	否	                                
	private String cardtype ;  //  cardtype	卡类型	STRING	否	参照值域字典  
	//出参
	private int queueno  ;  //  queueno	排队号	INT	是	                                    
	private int queuenum ;  //  queuenum	排队人数	INT	否	                            
	private String mzlsh    ;  //  mzlsh	门诊流水号	STRING	否	                            
	private String qhfph    ;  //  qhfph	取号发票号	STRING	否	                            
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getYuyueid() {
		return yuyueid;
	}
	public void setYuyueid(String yuyueid) {
		this.yuyueid = yuyueid;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public String getCardno() {
		return cardno;
	}
	public void setCardno(String cardno) {
		this.cardno = cardno;
	}
	public String getCardtype() {
		return cardtype;
	}
	public void setCardtype(String cardtype) {
		this.cardtype = cardtype;
	}
	public int getQueueno() {
		return queueno;
	}
	public void setQueueno(int queueno) {
		this.queueno = queueno;
	}
	public int getQueuenum() {
		return queuenum;
	}
	public void setQueuenum(int queuenum) {
		this.queuenum = queuenum;
	}
	public String getMzlsh() {
		return mzlsh;
	}
	public void setMzlsh(String mzlsh) {
		this.mzlsh = mzlsh;
	}
	public String getQhfph() {
		return qhfph;
	}
	public void setQhfph(String qhfph) {
		this.qhfph = qhfph;
	}
	
}




















