package org.hcm.service;

import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import org.hcm.mapper.BoardMapper;
import org.hcm.model.BoardVO;
import org.hcm.model.CriteriaVO;
import org.hcm.model.ReplyVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper bm;
	
	public void write(BoardVO bvo) {
//		System.out.println("From Service : "+bvo);
		bm.write(bvo);
	}
	
	
	public ArrayList<BoardVO> list(CriteriaVO cri){
		return bm.list(cri);
	}
	
	public int maxNum() {
		return bm.maxNum();
	}
	
	public ArrayList<BoardVO> listSearch(CriteriaVO cri){
		return bm.listSearch(cri);
	}
	
	public int maxNumSearch(CriteriaVO cri) {
		return bm.maxNumSearch(cri);
	}
	
	//@Transactional
	public BoardVO detail(BoardVO bvo){
		return bm.detail(bvo);
	}
	
	public void count(BoardVO bvo) {
		bm.count(bvo);
	}
	
	public void modify(BoardVO bvo) {
		bm.modify(bvo);
	}
	
	public void remove(BoardVO bvo) {
		bm.remove(bvo);
	}
	
	public ArrayList<ReplyVO> reply(ReplyVO rvo){
		return bm.reply(rvo);
	}
	
	public void writeRe(ReplyVO rvo) {
		bm.writeRe(rvo);
	}
	
	public void replyRemove(ReplyVO rvo) {
		bm.replyRemove(rvo);
	}
}
