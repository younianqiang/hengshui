package com.das.springboot.hengshui.mapper.app;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.das.springboot.hengshui.domain.PersonalInfo;


@Mapper
public interface AppMapper {

	
	 List<PersonalInfo> HPS_PersonalInformation(@Param("orgcode")String orgcode,@Param("iccardno")String iccardno);	
}
