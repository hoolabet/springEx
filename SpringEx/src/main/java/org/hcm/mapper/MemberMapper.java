package org.hcm.mapper;

import java.util.ArrayList;

import org.hcm.model.MemberVO;

public interface MemberMapper {
	public void signup(MemberVO mvo);
	
	public ArrayList<MemberVO> list();
	
	public MemberVO login(MemberVO mvo);
}
