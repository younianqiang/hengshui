package com.das.consultation.entity.app;
/**
 * 预约支付
 * @author youqiang
 *
 */
public class HPS_submitOrderInfo {
	private String orgcode;  //orgcode	医疗机构代码	STRING	是	医疗机构的代码                               
	private String orderid;  //orderid	预约单号	STRING	是	                                      
	private String payno;  //payno	交易流水号	STRING	是	                                      
	private Float payamout;  //payamout	支付金额	NUMBER	是	保留2位小数，单位：元                       
	private String paymethod;  //paymethod	支付方式	STRING	是	参照值域字典                            
	private String paychannel;  //paychannel	支付渠道	STRING	是	参照值域字典        
	//出参
	private String receiptnum;  //receiptnum	收据号	STRING	否	                                      
	private String serialnum;  //serialnum	就诊序号	STRING	否	                                  
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getPayno() {
		return payno;
	}
	public void setPayno(String payno) {
		this.payno = payno;
	}
	public Float getPayamout() {
		return payamout;
	}
	public void setPayamout(Float payamout) {
		this.payamout = payamout;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public String getPaychannel() {
		return paychannel;
	}
	public void setPaychannel(String paychannel) {
		this.paychannel = paychannel;
	}
	public String getReceiptnum() {
		return receiptnum;
	}
	public void setReceiptnum(String receiptnum) {
		this.receiptnum = receiptnum;
	}
	public String getSerialnum() {
		return serialnum;
	}
	public void setSerialnum(String serialnum) {
		this.serialnum = serialnum;
	}
	
}







