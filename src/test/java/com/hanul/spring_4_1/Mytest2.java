package com.hanul.spring_4_1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.hanul.board.BoardDTO;
import com.hanul.board.notice.NoticeDAO;

public class Mytest2 extends AbstractTestCase {
	
	@Inject
	private NoticeDAO noticeDAO;
	
	@Test
	public void test() {
		try {
			BoardDTO boardDTO = noticeDAO.select(10);
			assertNull(boardDTO);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		BoardDTO boardDTO = new BoardDTO();
		
		
		try {
			int result = noticeDAO.insert(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void allSelect() {
		List<BoardDTO> ar = new ArrayList<BoardDTO>();
		
		/*try {
			ar = noticeDAO.list();
			assertNotNull(ar);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}
}
