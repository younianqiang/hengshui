package com.das.consultation.service.common.impl;

import com.das.consultation.entity.common.BaseInfo;
import com.das.consultation.mapper.common.BaseInfoMapper;
import com.das.consultation.service.common.BaseInfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 基本信息-个人基本信息 （必传）(BaseInfo)表服务实现类
 *
 * @author jun
 * @since 2020-08-07 13:39:17
 */
@Service
public class BaseInfoServiceImpl implements BaseInfoService {
    @Resource
    private BaseInfoMapper baseInfoMapper;


    /**
     * 通过ID查询单条数据
     *
     * @param orgCode 医疗机构id
     * @param patientId 病例id
     * @return 实例对象
     */
    @Override
    public BaseInfo getBaseInfoById(String orgCode, String patientId) {
        BaseInfo baseInfo = null;
        try {
            baseInfo = baseInfoMapper.getBaseInfoById(orgCode,patientId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return baseInfo;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<BaseInfo> queryAllByLimit(int offset, int limit) {
        return this.baseInfoMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param baseInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BaseInfo insert(BaseInfo baseInfo) {
        this.baseInfoMapper.insert(baseInfo);
        return baseInfo;
    }

    /**
     * 修改数据
     *
     * @param baseInfo 实例对象
     * @return 实例对象
     */
    @Override
    public BaseInfo update(BaseInfo baseInfo) {
        this.baseInfoMapper.update(baseInfo);
        return this.getBaseInfoById(baseInfo.getOrgcode(),baseInfo.getPatientid());
    }

    /**
     * 通过主键删除数据
     *
     * @param orgCode 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orgCode) {
        return this.baseInfoMapper.deleteById(orgCode) > 0;
    }
}