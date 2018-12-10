package com.hanul.board.notice;

import static org.junit.Assert.*;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hanul.board.BoardDTO;
import com.hanul.spring_4_1.AbstractTestCase;
import com.hanul.util.Pager;

public class NoticeDAOTest extends AbstractTestCase {

	@Inject
	private NoticeDAO noticeDAO;
	
	
	/*@Test
	public void test() {
		
		
		
	}
	
	@BeforeClass
	public static void start() {
		System.out.println("startTest");
	}
	
	@AfterClass
	public static void finish() {
		System.out.println("finish Test");
	}
	
	@Before
	public void before() {
		System.out.println("Before TEST");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}*/
	
	
	//@Test
	public void listTest() {
		Pager pager = new Pager();
		pager.MakeRow();
		try {
			List<BoardDTO> ar = noticeDAO.list(pager);
			assertNotNull(ar);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void getCountTest() {
		Pager pager = new Pager();
		pager.setKind("title");
		pager.setSearch("batis");
		
		try {
			int totalCount = noticeDAO.getCount(pager);
			assertNotEquals(0, totalCount);
			System.out.println(totalCount);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void insertTest() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setTitle("batisInsert");
		boardDTO.setWriter("tester");
		boardDTO.setContents("dfdfdfdfdfasdfasdf");
		
		try {
			int result = noticeDAO.insert(boardDTO);
			assertNotEquals(0, result);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	//@Test
	public void updateTest() {
		BoardDTO boardDTO = new BoardDTO();
		boardDTO.setNum(15);
		boardDTO.setTitle("batisUpdate");
		boardDTO.setContents("hi");
		
		try {
			int result = noticeDAO.update(boardDTO);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void deleteTest() {
		try {
			int result = noticeDAO.delete(16);
			assertEquals(1, result);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void selectTest() {
		int num = 18;
		try {
			BoardDTO boardDTO = noticeDAO.select(num);
			assertNotNull(boardDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
