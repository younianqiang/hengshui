/**
 * 患者队列查询
 */
package com.das.consultation.mapper.app;

import org.apache.ibatis.annotations.Param;

import com.das.consultation.entity.app.HPS_submitOrderInfo;

public interface HPS_submitOrderMapper {
	/**
	 * 患者队列查询
	 * 
	 * @param orgcode    医疗机构代码
	 * @param orderid    预约单号
	 * @param payno      交易流水号
	 * @param payamout   支付金额
	 * @param paymethod  支付方式
	 * @param paychannel 支付渠道
	 * @return
	 */
	public HPS_submitOrderInfo findAPIHPS(@Param("orgcode") String orgcode, @Param("orderid") String orderid,
			@Param("payno") String payno, @Param("payamout") String payamout, @Param("paymethod") String paymethod,
			@Param("paychannel") String paychannel);

	public HPS_submitOrderInfo insertAPIHPS(@Param("obj") HPS_submitOrderInfo obj);

//    public HPS_submitOrder insertAPIHPS(HPS_submitOrder student);
}
