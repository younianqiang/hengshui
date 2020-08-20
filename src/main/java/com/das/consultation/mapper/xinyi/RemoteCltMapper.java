package com.das.consultation.mapper.xinyi;

import com.das.consultation.entity.xinyi.RemoteCltInfo;

/**
 * (RemoteCltInfo)表数据库访问层
 *
 * @author jun
 * @since 2020-08-05 09:28:25
 */
public interface RemoteCltMapper {

    /**
     * 新增数据
     *
     * @param RemoteCltInfo 实例对象
     * @return 影响行数
     */
    int insert(RemoteCltInfo RemoteCltInfo);


}