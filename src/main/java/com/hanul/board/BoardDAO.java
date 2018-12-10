package com.hanul.board;

import java.util.List;

import com.hanul.util.Pager;

public interface BoardDAO {
	
	public List<BoardDTO> list(Pager pager) throws Exception;
	
	public BoardDTO select(Integer num) throws Exception;
	
	public int insert(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(Integer num) throws Exception;
	
	public int getCount(Pager pager) throws Exception;
}
