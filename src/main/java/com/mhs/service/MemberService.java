package com.mhs.service;

import java.util.List;

public interface MemberService {

	void insertMember(MemberVO vo) throws Exception;

	void updateMember(MemberVO vo) throws Exception;

	void deleteMember(int num) throws Exception;

	MemberVO selectMember(int num) throws Exception;

	List<?> selectMemberList(DefaultVO vo) throws Exception;
	
	List<?> selectMemberAllList() throws Exception;
	
	int selectMemberCount(DefaultVO vo);

}
