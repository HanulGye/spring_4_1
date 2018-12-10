package com.hanul.page;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.hanul.spring_4_1.AbstractTestCase;
import com.hanul.util.Pager;

public class PagerTest extends AbstractTestCase {

	private static Pager pager;
	
	@BeforeClass
	public static void setData() {
		pager = new Pager();
		
	}
	
	@Test
	public void test() {
		
		//assertEquals(1, pager.getCurPage());
		//assertEquals(5, pager.getPerBlock());
		//assertEquals(10, pager.getPerPage());
		//assertEquals("title", pager.getKind());
		//assertEquals("", pager.getSearch());
		
		//curPage = 0 -> 1
		//perBlock = 0 -> 5
		//perPage = 0 -> 10
		//kind = null -> "title"
		//search = null -> ""
		
		
		pager.MakeRow();
		assertEquals(10, pager.getLastRow());
		
	}

}
