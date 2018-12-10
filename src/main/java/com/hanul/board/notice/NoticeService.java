package com.hanul.board.notice;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanul.board.BoardDTO;
import com.hanul.board.BoardService;
import com.hanul.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Inject
	private NoticeDAO noticeDAO;
	
	
	public int insert(BoardDTO boardDTO) throws Exception{
		return noticeDAO.insert(boardDTO);
	}
	
	public int update(BoardDTO boardDTO) throws Exception{
		return noticeDAO.update(boardDTO);
	}
	
	public int delete(Integer num) throws Exception{
		return noticeDAO.delete(num);
	}
	
	public BoardDTO select(Integer num) throws Exception{
		return noticeDAO.select(num);
	}
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.MakeRow();
		int totalCount = noticeDAO.getCount(pager);
		pager.MakePage(totalCount);
		return noticeDAO.list(pager);
	}
}
