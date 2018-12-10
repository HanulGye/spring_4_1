package com.hanul.board.qna;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.hanul.board.BoardDTO;
import com.hanul.spring_4_1.AbstractTestCase;
import com.hanul.util.Pager;

public class QnaDAOTest extends AbstractTestCase {

	@Inject
	QnaDAO qnaDAO = new QnaDAO();
	
	//@Test
	public void listTest() throws Exception{
		Pager pager = new Pager();
		pager.MakeRow();
		List<BoardDTO> ar = qnaDAO.list(pager);
		assertNotNull(ar);
	}
	
	//@Test
	public void getCountTest() throws Exception{
		Pager pager = new Pager();
		int result = qnaDAO.getCount(pager);
		assertNotEquals(0, result);
	}
	
	//@Test
	public void replyTest() throws Exception{
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("batisreplyTitle1");
		qnaDTO.setWriter("rw2");
		qnaDTO.setContents("batis reply Test 1");
		qnaDTO.setRef(5);
		qnaDTO.setStep(1);
		qnaDTO.setDepth(1);
		//ref, step, depth는 원래 service에서 처리해줘야 하는 것들
		
		int result = qnaDAO.reply(qnaDTO);
		assertEquals(1, result);
	}
	
	//@Test
	public void insertTest() {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("batisqnaTITLE");
		qnaDTO.setWriter("batisqnaWriter");
		qnaDTO.setContents("batisqnaCONtents");
		
		try {
			int result = qnaDAO.insert(qnaDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//exception method에서 throw시킬 수 있음.
	}
	
	//@Test
	public void deleteTest() {
		int num = 4;
		try {
			int result = qnaDAO.delete(num);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void updateTest() {
		QnaDTO qnaDTO = new QnaDTO();
		qnaDTO.setTitle("batisUpdate");
		qnaDTO.setContents("batisUpdateContents");
		qnaDTO.setNum(1);
		
		try {
			int result = qnaDAO.update(qnaDTO);
			assertNotEquals(0, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//@Test
	public void selectTest() {
		Integer num = 1;
		QnaDTO qnaDTO = new QnaDTO();
		try {
			qnaDTO = (QnaDTO)qnaDAO.select(num); 
			assertNotNull(qnaDTO.getRef());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
