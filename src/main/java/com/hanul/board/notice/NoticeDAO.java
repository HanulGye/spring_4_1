package com.hanul.board.notice;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hanul.board.BoardDAO;
import com.hanul.board.BoardDTO;
import com.hanul.util.Pager;
@Repository
public class NoticeDAO implements BoardDAO {

	@Inject
	private SqlSession sqlSession;
	private String nameSpace = "noticeMapper.";
	
	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		return sqlSession.selectList(nameSpace+"list", pager);
	}

	@Override
	public BoardDTO select(Integer num) throws Exception {
		return sqlSession.selectOne(nameSpace+"select", num);
	}

	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return sqlSession.insert(nameSpace+"insert", boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		return sqlSession.update(nameSpace+"update", boardDTO);
	}

	@Override
	public int delete(Integer num) throws Exception {
		return sqlSession.delete(nameSpace+"delete", num);
		
	}
	
	@Override
	public int getCount(Pager pager) throws Exception {
		return sqlSession.selectOne(nameSpace+"getCount", pager);
	}
	
	public int getNum() throws Exception{
		return sqlSession.selectOne(nameSpace+"getNum");
	}

}
