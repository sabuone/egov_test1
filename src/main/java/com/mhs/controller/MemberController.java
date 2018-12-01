package com.mhs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springmodules.validation.commons.DefaultBeanValidator;

import com.mhs.service.DefaultVO;
import com.mhs.service.MemberService;
import com.mhs.service.MemberVO;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

@Controller
public class MemberController {

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
	
	// 목록
	@RequestMapping(value = "/MemberList.do")
	public String list(@ModelAttribute("searchVO") DefaultVO searchVO, ModelMap model) throws Exception {
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List<?> memberList = memberService.selectMemberList(searchVO);
		model.addAttribute("resultList", memberList);

		int cnt = memberService.selectMemberCount(searchVO);
		paginationInfo.setTotalRecordCount(cnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "member/list";
	}

	// 추가
	@RequestMapping(value = "/MemberAdd.do", method = RequestMethod.GET)
	public String add(@ModelAttribute("memberVO") MemberVO memberVO, Model model) throws Exception {
		model.addAttribute("memberVO", new MemberVO());
		return "member/add";
	}

	@RequestMapping(value = "/MemberAdd.do", method = RequestMethod.POST)
	public String processAdd(@ModelAttribute("memberVO") MemberVO memberVO, BindingResult bindingResult, Model model, SessionStatus status) throws Exception {
		beanValidator.validate(memberVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("memberVO", memberVO);
			return "member/add";
		}
		
		memberService.insertMember(memberVO);
		status.setComplete();
		return "redirect:/MemberList.do";
	}
	
	// 수정
	@RequestMapping(value = "/MemberEdit.do", method = RequestMethod.GET)
	public String edit(@RequestParam("num") int num, Model model) throws Exception {
		MemberVO memberVO = memberService.selectMember(num);
		model.addAttribute("memberVO", memberVO);
		return "member/edit";
	}

	@RequestMapping(value = "/MemberEdit.do", method = RequestMethod.POST)
	public String processEdit(@ModelAttribute("memberVO") MemberVO memberVO, BindingResult bindingResult, Model model, SessionStatus status) throws Exception {
		beanValidator.validate(memberVO, bindingResult);

		if (bindingResult.hasErrors()) {
			model.addAttribute("memberVO", memberVO);
			return "member/edit";
		}
		
		memberService.updateMember(memberVO);
		status.setComplete();
		return "redirect:/MemberList.do";
	}
	
	// 삭제
	@RequestMapping(value = "/MemberRemove.do", method = RequestMethod.POST)
	public String processRemove(@RequestParam("num") int num) throws Exception {
		memberService.deleteMember(num);
		return "redirect:/MemberList.do";
	}

}
