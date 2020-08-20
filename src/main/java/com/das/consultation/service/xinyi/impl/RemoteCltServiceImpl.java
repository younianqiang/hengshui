package com.das.consultation.service.xinyi.impl;

import com.das.consultation.entity.xinyi.RemoteCltInfo;
import com.das.consultation.mapper.xinyi.RemoteCltMapper;
import com.das.consultation.service.xinyi.RemoteCltService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * (RemoteCltInfo)表服务实现类
 *
 * @author jun
 * @since 2020-08-05 09:28:29
 */
@Service
public class RemoteCltServiceImpl implements RemoteCltService {
    @Resource
    private RemoteCltMapper remoteCltMapper;

    /**
     * 新增数据
     *
     * @param RemoteCltInfo 实例对象
     * @return 实例对象
     */
    @Override
    public RemoteCltInfo insert(RemoteCltInfo RemoteCltInfo) {
        try {
            int result = remoteCltMapper.insert(RemoteCltInfo);
            if (result > 0) {
                return RemoteCltInfo;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}