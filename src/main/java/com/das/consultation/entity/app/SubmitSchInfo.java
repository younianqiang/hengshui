package com.das.consultation.entity.app;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * created by jun on 2020/8/12
 * describe:预约提交实体
 * version 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubmitSchInfo {
    /**
     *预约单号
     */
    private String orderid;
    /**
     * 取号密码
     */
    private String tokeno;
    /**
     * 订单状态
     */
    private String orderstatus;

}
