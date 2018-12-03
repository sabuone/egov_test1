package com.mhs.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mhs.service.DefaultVO;
import com.mhs.service.MemberVO;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

@Repository("memberDAO")
public class MemberDAO extends EgovAbstractDAO {

	public void insertMember(MemberVO vo) throws Exception {
		insert("memberDAO.insertMember", vo);
	}

	public void updateMember(MemberVO vo) throws Exception {
		update("memberDAO.updateMember", vo);
	}

	public void deleteMember(int num) throws Exception{
		delete("memberDAO.deleteMember", num);
	}

	public MemberVO selectMember(int num) throws Exception{
		return (MemberVO) select("memberDAO.selectMember", num);
	}

	public List<?> selectMemberList(DefaultVO vo) throws Exception{
		return list("memberDAO.selectMemberList", vo);
	}

	public List<?> selectMemberAllList() throws Exception{
		return list("memberDAO.selectMemberAllList");
	}
	
	public int selectMemberCount(DefaultVO vo){
		return (Integer) select("memberDAO.selectMemberCount", vo);
	}

}
