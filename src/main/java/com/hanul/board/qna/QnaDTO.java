package com.hanul.board.qna;

import com.hanul.board.BoardDTO;

public class QnaDTO extends BoardDTO {
	private int ref, step, depth;
	//ref = �׷�(���۰� �ش�ۿ� ���� ��۸��� ���� �׷�)
	//step = ����(�ش� �׷��� ���� �� ��۵��� ���� )
	//depth = ���� �� ��۵� ���̿� �鿩���⸦ ���� ���� ���� (a��� ���ۿ� ���� b����� a���� �ѹ� �鿩���� �ȴٴ� ��) 

	public int getRef() {
		return ref;
	}

	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getStep() {
		return step;
	}

	public void setStep(int step) {
		this.step = step;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}
	
	
}
