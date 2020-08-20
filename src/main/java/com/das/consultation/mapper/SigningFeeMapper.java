package com.das.consultation.mapper;

import com.das.consultation.entity.SigningFee;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 签约费用信息(SigningFee)表数据库访问层
 *
 * @author jun
 * @since 2020-08-14 15:30:44
 */
public interface SigningFeeMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param orgCode 主键
     * @return 实例对象
     */
    SigningFee queryById(String orgCode);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SigningFee> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param signingFee 实例对象
     * @return 对象列表
     */
    List<SigningFee> queryAll(SigningFee signingFee);

    /**
     * 新增数据
     *
     * @param signingFee 实例对象
     * @return 影响行数
     */
    int insert(SigningFee signingFee);

    /**
     * 修改数据
     *
     * @param signingFee 实例对象
     * @return 影响行数
     */
    int update(SigningFee signingFee);

    /**
     * 通过主键删除数据
     *
     * @param orgCode 主键
     * @return 影响行数
     */
    int deleteById(String orgCode);

}