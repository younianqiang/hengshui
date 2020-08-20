package com.das.consultation.service.common;

import com.das.consultation.entity.common.BaseInfo;
import java.util.List;

/**
 * 基本信息-个人基本信息 （必传）(BaseInfo)表服务接口
 *
 * @author jun
 * @since 2020-08-07 13:39:17
 */
public interface BaseInfoService {

    /**
     * 通过ID查询单条数据
     *
     * @param orgCode 医疗机构代码
     * @param patientId 病人id
     * @return 实例对象
     */
    BaseInfo getBaseInfoById(String orgCode,String patientId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<BaseInfo> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param baseInfo 实例对象
     * @return 实例对象
     */
    BaseInfo insert(BaseInfo baseInfo);

    /**
     * 修改数据
     *
     * @param baseInfo 实例对象
     * @return 实例对象
     */
    BaseInfo update(BaseInfo baseInfo);

    /**
     * 通过主键删除数据
     *
     * @param orgCode 主键
     * @return 是否成功
     */
    boolean deleteById(String orgCode);

}