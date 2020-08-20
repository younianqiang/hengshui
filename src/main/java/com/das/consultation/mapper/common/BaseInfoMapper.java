package com.das.consultation.mapper.common;

import com.das.consultation.entity.common.BaseInfo;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 基本信息-个人基本信息 （必传）(BaseInfo)表数据库访问层
 *
 * @author jun
 * @since 2020-08-07 13:39:16
 */
public interface BaseInfoMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param orgCode 医疗机构代码
     * @param patientId 病人id
     * @return 实例对象
     */
    BaseInfo getBaseInfoById(String orgCode,String patientId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BaseInfo> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param baseInfo 实例对象
     * @return 对象列表
     */
    List<BaseInfo> queryAll(BaseInfo baseInfo);

    /**
     * 新增数据
     *
     * @param baseInfo 实例对象
     * @return 影响行数
     */
    int insert(BaseInfo baseInfo);

    /**
     * 修改数据
     *
     * @param baseInfo 实例对象
     * @return 影响行数
     */
    int update(BaseInfo baseInfo);

    /**
     * 通过主键删除数据
     *
     * @param orgCode 主键
     * @return 影响行数
     */
    int deleteById(String orgCode);

}