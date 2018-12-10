package com.hanul.board.qna;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.hanul.board.BoardDTO;
import com.hanul.board.BoardService;
import com.hanul.util.Pager;
@Service
public class QnaService implements BoardService {
	
	@Inject
	QnaDAO qnaDAO = new QnaDAO();
	
	
	@Override
	public int insert(BoardDTO boardDTO) throws Exception {
		return qnaDAO.insert(boardDTO);
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.update(boardDTO);
	}

	@Override
	public int delete(Integer num) throws Exception {
		// TODO Auto-generated method stub
		return qnaDAO.delete(num);
	}

	@Override
	public BoardDTO select(Integer num) throws Exception {
		return qnaDAO.select(num);
	}

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.MakeRow();
		int totalCount = qnaDAO.getCount(pager);
		pager.MakePage(totalCount);
		
		return qnaDAO.list(pager);
	}

	public int reply(QnaDTO qnaDTO) throws Exception{
		QnaDTO parentQnaDTO = (QnaDTO)qnaDAO.select(qnaDTO.getNum());
		
		qnaDAO.replyUpdate(parentQnaDTO);
		
		qnaDTO.setRef(parentQnaDTO.getRef());
		qnaDTO.setStep(parentQnaDTO.getStep()+1);
		qnaDTO.setDepth(parentQnaDTO.getDepth()+1);
		
		
		return qnaDAO.reply(qnaDTO);
	}
}
