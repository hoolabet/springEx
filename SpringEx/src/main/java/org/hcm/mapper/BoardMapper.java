package org.hcm.mapper;

import java.util.ArrayList;

import org.hcm.model.BoardVO;

public interface BoardMapper {
	public void write(BoardVO bvo);
	
	public ArrayList<BoardVO> list();
	
	public BoardVO detail(BoardVO bvo);
	
	public void modify(BoardVO bvo);
	
	public void remove(BoardVO bvo);
}
