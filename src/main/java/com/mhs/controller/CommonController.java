package com.mhs.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.mhs.service.MemberService;

import egovframework.rte.fdl.property.EgovPropertyService;

@Controller
public class CommonController {

	@Resource(name = "memberService")
	private MemberService memberService;

	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	@Resource(name = "beanValidator")
	protected DefaultBeanValidator beanValidator;
	
	@RequestMapping(value = "/validator.do")
	protected String getValidator() throws Exception {
		return "common/validator";
	}
	
	@RequestMapping(value = "/Grid.do")
	public String list() throws Exception {
		return "grid/list";
	}

	@ResponseBody
	@RequestMapping(value = "/grid.json", method=RequestMethod.GET)
	public HashMap<String, Object> json() throws Exception {
		List<?> list = memberService.selectMemberAllList();
		
		HashMap<String, Object> map = new HashMap<>();
	//	map.put("total", 14);
	//	map.put("page", 1);
	//	map.put("records", 133);
		map.put("rows", list);
		return map;
	}

}
