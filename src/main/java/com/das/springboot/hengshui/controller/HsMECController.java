package com.das.springboot.hengshui.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.das.springboot.hengshui.domain.PersonalInfo;
import com.das.springboot.hengshui.service.HsMECService;
import com.das.springboot.hengshui.utils.AppUtils;


@Controller
@RequestMapping("/hs")
public class HsMECController {

	@Autowired
	private HsMECService hsService;
	
	/**
	 * 个人信息
	 * @param orgcode
	 * @param iccardno
	 * @return
	 * 131102404796498  131124196602241412 
	 */
	@RequestMapping("/HPS_PersonalInformation")
	@ResponseBody
	public  String HPS_PersonalInformation(@RequestParam("orgcode")String orgcode,@RequestParam("iccardno")String iccardno) {
		List<PersonalInfo> map = hsService.HPS_PersonalInformation(orgcode, iccardno);
		return AppUtils.convertJsonStr(map);
	}
	
//	@RequestMapping("/HPS_PersonalInformation")
//	@ResponseBody
//	public  String HPS_PersonalInformation2(PersonalInfo personalInfo)
//	{
//		return null;
//	}
	 
	
}
