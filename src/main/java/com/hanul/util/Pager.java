package com.hanul.util;



public class Pager {
	
	//
	private int curPage;
	//DAO rownum(�ѹ��� ������ ������ ���(1~10, 11~20 ��)�� ������ ��Ÿ�� ��)
	//startRow = ���� ���������� ù��°�� ������ �Խñ� ��ȣ
	//lastRow = ���� ���������� ���������� ������ �Խñ� ��ȣ
	private int startRow, lastRow;
	
	//perPage = �� �������� ������ �Խñ۵��� ��
	private int perPage;
	
	//perBlock = �� ���� ��� �������� �Ѹ��ų� 
	private int perBlock;
	
	//search(�Խ��� �˻� ��� kind = ��ȸ�� �÷�, search = �� �˻���)
	private String kind, search;
	
	//startNum = ������ �������� ���� ��ȣ , lastNum = ������ �������� ������ ��ȣ,
	//curBlock = 
	private int startNum, lastNum, curBlock, totalBlock ;
	
	
	public Pager() {
		this.perPage = 10;
		this.perBlock = 5;
	}
	
	
	public int getCurPage() {
		if(curPage==0) {
			curPage=1;
		}
		
		return curPage;
	}


	public void setCurPage(int curPage) {
		this.curPage = curPage;
		
	}


	public int getStartRow() {
		return startRow;
	}


	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}


	public int getLastRow() {
		return lastRow;
	}


	public void setLastRow(int lastRow) {
		this.lastRow = lastRow;
	}


	public int getPerPage() {
		if(perPage==0) {
			perPage=10;
		}
		return perPage;
	}


	public void setPerPage(int perPage) {
		if(perPage==0) {
			this.perPage = 10;
		}else {
			this.perPage = perPage;
		}
	}


	public int getPerBlock() {
		if(perBlock==0) {
			perBlock=5;
		}
		
		return perBlock;
	}


	public void setPerBlock(int perBlock) {
		this.perBlock = perBlock;
		if(this.perBlock==0) {
			this.perBlock = 5;
		}	
	}


	public String getKind() {
		if(kind==null||kind.equals("")) {
			kind="title";
		}
		
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
		if(this.kind == null|| this.kind.equals("")) {
			this.kind = "title";
		}
	}


	public String getSearch() {
		if(search==null) {
			search="";
		}
		return search;
	}


	public void setSearch(String search) {
		this.search = search;
		if(this.search==null) {
			this.search="";
		}
	}


	public int getStartNum() {
		return startNum;
	}


	public void setStartNum(int startNum) {
		this.startNum = startNum;
	}


	public int getLastNum() {
		return lastNum;
	}


	public void setLastNum(int lastNum) {
		this.lastNum = lastNum;
	}


	public int getCurBlock() {
		return curBlock;
	}


	public void setCurBlock(int curBlock) {
		this.curBlock = curBlock;
	}


	public int getTotalBlock() {
		return totalBlock;
	}


	public void setTotalBlock(int totalBlock) {
		this.totalBlock = totalBlock;
	}


	
	
	
	
	
	public void MakeRow() {
		this.startRow = (getCurPage()-1)*getPerPage()+1;
		this.lastRow = getCurPage()*getPerPage();
	}
	
	
	public void MakePage(int totalCount) {
		int totalPage = totalCount/perPage;
		if(totalCount%perPage!=0) {
			totalPage++;
		}
		
		
		this.totalBlock = totalPage/perBlock;
		if(totalPage%perBlock!=0) {
			totalBlock++;
		}
		
		this.curBlock = curPage/perBlock;
		if(curPage%perBlock!=0) {
			curBlock++;
		}
		
		this.startNum = (curBlock-1)*perBlock+1;
		this.lastNum = curBlock*perBlock;
		
		if(this.curBlock==this.totalBlock) {
			this.lastNum = totalPage;
		}
	}
}
