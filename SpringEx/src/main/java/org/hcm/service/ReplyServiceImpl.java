package org.hcm.service;

import java.util.ArrayList;

import org.hcm.mapper.ReplyMapper;
import org.hcm.model.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{
	@Autowired
	ReplyMapper rm;
	
	public int replyWrite(ReplyVO rvo) {
		return rm.replyWrite(rvo);
	}
	
	public ArrayList<ReplyVO> replyView(int bno) {
		return rm.replyView(bno);
	}
	
	public int replyDelete(int rno) {
		return rm.replyDelete(rno);
	}
}
