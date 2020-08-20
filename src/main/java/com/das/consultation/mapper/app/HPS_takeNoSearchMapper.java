package com.das.consultation.mapper.app;

import org.apache.ibatis.annotations.Param;

import com.das.consultation.entity.app.HPS_takeNoSearchInfo;

//orgcode	医疗机构代码
//appid	预约单号
//depid	科室ID
//doctorid	医生ID
//endtime	截至时间
//queueno	队列号
//---------------------------------------------------
//queuenum	当前队列人数
//hasno	是否还有余号
//averagetime	看诊病人的平均时间
public interface HPS_takeNoSearchMapper {
	/**
	 * 患者队列查询
	 * 
	 * @param orgcode  医疗机构代码
	 * @param appid    预约单号
	 * @param depid    科室ID
	 * @param doctorid 医生ID
	 * @param endtime  截至时间
	 * @param queueno  队列号
	 * @return
	 */
	public HPS_takeNoSearchInfo findAPIHPS(@Param("orgcode") String orgcode, @Param("appid") String appid,
			@Param("depid") String depid, @Param("doctorid") String doctorid, @Param("endtime") String endtime,
			@Param("queueno") String queueno);

	public HPS_takeNoSearchInfo insertAPIHPS(@Param("obj") HPS_takeNoSearchInfo obj);
}
