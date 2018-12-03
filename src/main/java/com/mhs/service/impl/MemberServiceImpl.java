package com.mhs.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.mhs.service.DefaultVO;
import com.mhs.service.MemberService;
import com.mhs.service.MemberVO;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("memberService")
public class MemberServiceImpl extends EgovAbstractServiceImpl implements MemberService {
	
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Resource(name = "memberDAO")
	private MemberDAO memberDAO;

	@Override
	public void insertMember(MemberVO vo) throws Exception {
		memberDAO.insertMember(vo);
	}

	@Override
	public void updateMember(MemberVO vo) throws Exception {
		memberDAO.updateMember(vo);
	}

	@Override
	public void deleteMember(int num) throws Exception {
		memberDAO.deleteMember(num);
	}

	@Override
	public MemberVO selectMember(int num) throws Exception {
		MemberVO member = memberDAO.selectMember(num);
		if (member == null) throw processException("info.nodata.msg");
		return member;
	}

	@Override
	public List<?> selectMemberList(DefaultVO vo) throws Exception {
		return memberDAO.selectMemberList(vo);
	}
	
	@Override
	public List<?> selectMemberAllList() throws Exception {
		return memberDAO.selectMemberAllList();
	}

	@Override
	public int selectMemberCount(DefaultVO vo) {
		return memberDAO.selectMemberCount(vo);
	}

}