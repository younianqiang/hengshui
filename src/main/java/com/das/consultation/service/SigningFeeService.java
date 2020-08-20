package com.das.consultation.service;

import com.das.consultation.entity.SigningFee;
import java.util.List;

/**
 * 签约费用信息(SigningFee)表服务接口
 *
 * @author makejava
 * @since 2020-08-14 15:30:45
 */
public interface SigningFeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param orgCode 主键
     * @return 实例对象
     */
    SigningFee queryById(String orgCode);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SigningFee> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param signingFee 实例对象
     * @return 实例对象
     */
    SigningFee insert(SigningFee signingFee);

    /**
     * 修改数据
     *
     * @param signingFee 实例对象
     * @return 实例对象
     */
    SigningFee update(SigningFee signingFee);

    /**
     * 通过主键删除数据
     *
     * @param orgCode 主键
     * @return 是否成功
     */
    boolean deleteById(String orgCode);

}