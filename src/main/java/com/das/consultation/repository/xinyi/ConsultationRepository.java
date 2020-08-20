package com.das.consultation.repository.xinyi;

import com.das.consultation.entity.xinyi.RemoteCltInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * created by jun on 2020/8/4
 * describe:远程会诊信息Repository
 * version 1.0
 */
public interface ConsultationRepository extends JpaRepository<RemoteCltInfo,String> {

}
