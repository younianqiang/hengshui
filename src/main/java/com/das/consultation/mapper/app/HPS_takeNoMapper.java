package com.das.consultation.mapper.app;

import org.apache.ibatis.annotations.Param;

import com.das.consultation.entity.app.HPS_takeNoInfo;
//orgcode	医疗机构代码	STRING	是	医疗机构的代码            
//yuyueid	预约订单id	STRING	是	                   
//orderno	订单号	STRING	否	                       
//deptid	科室id	STRING	否	                   
//truename	姓名	STRING	否	                       
//cardno	卡号	STRING	否	                       
//cardtype	卡类型	STRING	否	参照值域字典                 

//queueno	排队号	INT	是	                           
//queuenum	排队人数	INT	否	                       
//mzlsh	门诊流水号	STRING	否	                   
//qhfph	取号发票号	STRING	否	                   
public interface HPS_takeNoMapper {
	/**
	 * 患者报到/取号
	 * 
	 * @param orgcode  医疗机构代码
	 * @param yuyueid  预约订单id
	 * @param orderno  订单号
	 * @param deptid   科室id
	 * @param truename 姓名
	 * @param cardno   卡号
	 * @param cardtype 卡类型
	 * @return
	 */
	public HPS_takeNoInfo findAPIHPS(@Param("orgcode") String orgcode, @Param("yuyueid") String yuyueid,
			@Param("orderno") String orderno, @Param("deptid") String deptid, @Param("truename") String truename,
			@Param("cardno") String cardno, @Param("cardtype") String cardtype);

	public HPS_takeNoInfo insertAPIHPS(@Param("obj") HPS_takeNoInfo obj);
}
