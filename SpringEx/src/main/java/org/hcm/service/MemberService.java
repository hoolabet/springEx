package org.hcm.service;

import java.util.ArrayList;

import org.hcm.model.MemberVO;

public interface MemberService {
	public void signup(MemberVO mvo);
	
	public ArrayList<MemberVO> list();
	
	public MemberVO login(MemberVO mvo);
}
