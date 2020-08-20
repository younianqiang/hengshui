/**
 * EXPLAIN:
 */
package com.das.consultation.mapper.app;

import org.apache.ibatis.annotations.Param;

import com.das.consultation.entity.app.HPS_queryPayInfoInfo;


/**
 * EXPLAIN:查询支付单据 USER: youqiang UPDATAUSER: DATE:2020-8-18 URL:
 * FILENAME:HPS_queryPayInfoDao.javaVersion VERSION:1.0
 */
//orgcode	医疗机构代码
//cardtype	医疗卡类型
//cardno	医疗卡号
//出参
//payinfo（每个payInfo可能有多个detail）
//hispayorderno	支付订单号
//hispaytotalamt	订单总金额
//mzlsh	门诊流水号
//hispayno	支付单据号
//hispayamt	支付总金额
//selfpayamt	自费支付金额
//socialpayamt	医保支付金额
//paytype	费用类型
//paystate	支付状态
//creattime	处方单时间
//depname	科室名称
//doctorname	医生姓名
//mztype	是否医保结算
//detail(多项)
//itemcodehis	His项目代码
//itemcodeyb	医保项目代码
//itemname	项目名称
//std	规格
//amt	数量
//unit	数量单位
//price	单价
//detailpayamt	应收价格
public interface HPS_queryPayInfoMapper {
	/**
	 * 
	 * EXPLAIN:查询支付单据
	 * 
	 * @param orgcode  医疗机构代码
	 * @param cardtype 医疗卡类型
	 * @param cardno   医疗卡号
	 * @return
	 */
	public HPS_queryPayInfoInfo findAPIHPS(@Param("orgcode") String orgcode, @Param("cardtype") String cardtype,
			@Param("cardno") String cardno);

	public HPS_queryPayInfoInfo insertAPIHPS(@Param("obj") HPS_queryPayInfoInfo obj);
}
