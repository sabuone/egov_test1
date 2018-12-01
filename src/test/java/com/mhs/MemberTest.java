package com.mhs;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mhs.service.MemberService;
import com.mhs.service.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { 
	"classpath:spring/context-common.xml", 
	"classpath:spring/context-datasource.xml",
	"classpath:spring/context-sqlMap.xml",
})
public class MemberTest {

	@Resource(name = "memberService")
	private MemberService memberService;

	@Test
	public void insertMember() throws Exception {
		for (int i = 1; i < 135; i++) {
			MemberVO memberVO = new MemberVO();
			memberVO.setUserId("user"+i);
			memberVO.setUserName("사용자"+i);
			memberVO.setUserPassword("user20");
			memberService.insertMember(memberVO);
		}
	}

}
