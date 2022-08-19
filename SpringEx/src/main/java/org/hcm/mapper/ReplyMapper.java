package org.hcm.mapper;

import java.util.ArrayList;

import org.hcm.model.ReplyVO;

public interface ReplyMapper {
	public int replyWrite(ReplyVO rvo);
	
	public ArrayList<ReplyVO> replyView(int bno);
	
	public int replyDelete(int rno);
}
