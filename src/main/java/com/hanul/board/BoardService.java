package com.hanul.board;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hanul.util.Pager;
@Service
public interface BoardService {

	public int insert(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(Integer num) throws Exception;
	
	public BoardDTO select(Integer num) throws Exception;
	
	public List<BoardDTO> list(Pager pager) throws Exception;
	
}
