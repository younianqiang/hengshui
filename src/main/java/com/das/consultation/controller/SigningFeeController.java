package com.das.consultation.controller;

import com.das.consultation.entity.SigningFee;
import com.das.consultation.service.SigningFeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 签约费用信息(SigningFee)表控制层
 *
 * @author makejava
 * @since 2020-08-14 15:30:45
 */
@RestController
public class SigningFeeController {
    /**
     * 服务对象
     */
    @Resource
    private SigningFeeService signingFeeService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/getSigningFee")
    public SigningFee selectOne(String id) {
        return this.signingFeeService.queryById(id);
    }

}