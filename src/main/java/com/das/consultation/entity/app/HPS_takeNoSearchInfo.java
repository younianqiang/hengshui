package com.das.consultation.entity.app;

import java.util.Date;

/**
 * 患者队列查询 
 * @author youqiang
 *
 */
public class HPS_takeNoSearchInfo {
    //入参
	private String orgcode      ;  // orgcode	医疗机构代码	STRING	是	医疗机构的代码 
	private String appid        ;  // appid	预约单号	STRING	是	
	private String depid        ;  // depid	科室ID	STRING	否	
	private String doctorid     ;  // doctorid	医生ID	STRING	否	
	private Date endtime      ;  // endtime	截至时间	DATE	否	YYYY-MM-DD hh:mm:ss
	private int queueno      ;  // queueno	队列号	INT	否	取号时返回的队列号
	/**——————————————————————黄金分割线————————————————————————————————————————*/
	// 出参
	private String queuenum     ;  // queuenum	当前队列人数	STRING	是	
	private String hasno        ;  // hasno	是否还有余号	STRING	是	0：无，1：有
	private String averagetime  ;  // averagetime	看诊病人的平均时间	STRING	否	单位：分钟
	public String getOrgcode() {
		return orgcode;
	}
	public void setOrgcode(String orgcode) {
		this.orgcode = orgcode;
	}
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getDepid() {
		return depid;
	}
	public void setDepid(String depid) {
		this.depid = depid;
	}
	public String getDoctorid() {
		return doctorid;
	}
	public void setDoctorid(String doctorid) {
		this.doctorid = doctorid;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public int getQueueno() {
		return queueno;
	}
	public void setQueueno(int queueno) {
		this.queueno = queueno;
	}
	public String getQueuenum() {
		return queuenum;
	}
	public void setQueuenum(String queuenum) {
		this.queuenum = queuenum;
	}
	public String getHasno() {
		return hasno;
	}
	public void setHasno(String hasno) {
		this.hasno = hasno;
	}
	public String getAveragetime() {
		return averagetime;
	}
	public void setAveragetime(String averagetime) {
		this.averagetime = averagetime;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
