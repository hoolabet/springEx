package org.hcm.service;

import java.util.ArrayList;

import org.hcm.mapper.BoardMapper;
import org.hcm.model.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	@Autowired
	BoardMapper bm;
	
	public void write(BoardVO bvo) {
//		System.out.println("From Service : "+bvo);
		bm.write(bvo);
	}
	
	
	public ArrayList<BoardVO> list(){
		return bm.list();
	}
	
	public BoardVO detail(BoardVO bvo){
		return bm.detail(bvo);
	}
	
	public void modify(BoardVO bvo) {
		bm.modify(bvo);
	}
	
	public void remove(BoardVO bvo) {
		bm.remove(bvo);
	}
}
