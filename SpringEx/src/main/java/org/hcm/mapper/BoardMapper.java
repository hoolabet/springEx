package org.hcm.mapper;

import java.util.ArrayList;

import org.hcm.model.BoardVO;
import org.hcm.model.CriteriaVO;
import org.hcm.model.ReplyVO;

public interface BoardMapper {
	public void write(BoardVO bvo);
	
	public ArrayList<BoardVO> list(CriteriaVO cri);
	
	public int maxNum();
	
	public ArrayList<BoardVO> listSearch(CriteriaVO cri);
	
	public int maxNumSearch(CriteriaVO cri);
	
	public BoardVO detail(BoardVO bvo);
	
	public void count(BoardVO bvo);
	
	public void modify(BoardVO bvo);
	
	public void remove(BoardVO bvo);
	
	public ArrayList<ReplyVO> reply(ReplyVO rvo);
	
	public void writeRe(ReplyVO rvo);
	
	public void replyRemove(ReplyVO rvo);
}
