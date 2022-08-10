package org.hcm.service;

import java.util.ArrayList;

import org.hcm.mapper.MemberMapper;
import org.hcm.model.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberMapper mm;
	
	public void signup(MemberVO mvo) {
		mm.signup(mvo);
	}
	
	public ArrayList<MemberVO> list(){
		return mm.list();
	}
	
	public MemberVO login(MemberVO mvo) {
		return mm.login(mvo);
	}
}
