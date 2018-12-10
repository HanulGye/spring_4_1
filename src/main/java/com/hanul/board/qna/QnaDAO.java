package com.hanul.board.qna;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanul.board.BoardDAO;
import com.hanul.board.BoardDTO;
import com.hanul.util.Pager;

@Repository
public class QnaDAO implements BoardDAO {

	@Inject
	private SqlSession sqlsession;
	private String nameSpace = "qnaMapper.";
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlsession.selectList(nameSpace+"list", pager);
	}

	@Override
	public BoardDTO select(Integer num) throws Exception {
		return sqlsession.selectOne(nameSpace+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return sqlsession.insert(nameSpace+"insert", boardDTO);
	}
 
	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlsession.update(nameSpace+"update", boardDTO);
	}

	@Override
	public int delete(Integer num) throws Exception {
		return sqlsession.delete(nameSpace+"delete", num);
	}
	
	@Override
	public int getCount(Pager pager) throws Exception {
		
		return sqlsession.selectOne(nameSpace+"getCount", pager);
	}
	
	public int reply(QnaDTO qnaDTO) throws Exception{
		return sqlsession.insert(nameSpace+"reply", qnaDTO);
	}
	
	public int replyUpdate(QnaDTO qnaDTO) throws Exception{
		return sqlsession.update(nameSpace+"replyUpdate", qnaDTO);
	}
}
