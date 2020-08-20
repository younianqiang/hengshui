package com.das.consultation.service.app.impl;

import com.das.consultation.config.data.DataSource;
import com.das.consultation.config.data.DataSourceNames;
import com.das.consultation.entity.SigningFee;
import com.das.consultation.mapper.SigningFeeMapper;
import com.das.consultation.service.SigningFeeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 签约费用信息(SigningFee)表服务实现类
 *
 * @author jun
 * @since 2020-08-14 15:30:45
 */
@Service("signingFeeService")
public class SigningFeeServiceImpl implements SigningFeeService {
    @Resource
    private SigningFeeMapper signingFeeMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param orgCode 主键
     * @return 实例对象
     */
    @DataSource(DataSourceNames.JTYS)
    @Override
    public SigningFee queryById(String orgCode) {
        return this.signingFeeMapper.queryById(orgCode);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SigningFee> queryAllByLimit(int offset, int limit) {
        return this.signingFeeMapper.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param signingFee 实例对象
     * @return 实例对象
     */
    @Override
    public SigningFee insert(SigningFee signingFee) {
        this.signingFeeMapper.insert(signingFee);
        return signingFee;
    }

    /**
     * 修改数据
     *
     * @param signingFee 实例对象
     * @return 实例对象
     */
    @Override
    public SigningFee update(SigningFee signingFee) {
        this.signingFeeMapper.update(signingFee);
        return this.queryById(signingFee.getOrgCode());
    }

    /**
     * 通过主键删除数据
     *
     * @param orgCode 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String orgCode) {
        return this.signingFeeMapper.deleteById(orgCode) > 0;
    }
}