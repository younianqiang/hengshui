package com.das.consultation.entity.app;

import lombok.Data;

import java.util.Date;

@Data
public class HPS_RefundFee {
    private String invoiceno;
    private String refundstate;
    private String refundtradeno;
    private Date refundtime;
    private String refundmchdd;
}
