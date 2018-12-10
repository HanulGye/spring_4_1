package com.hanul.board.qna;

import com.hanul.board.BoardDTO;

public class QnaDTO extends BoardDTO {
	private int ref, step, depth;
	//ref = 그룹(원글과 해당글에 대한 답글만을 묶은 그룹)
	//step = 순서(해당 그룹의 원글 및 댓글들의 순서 )
	//depth = 원글 및 댓글들 사이에 들여쓰기를 통한 위계 설정 (a라는 원글에 대한 b댓글은 a보다 한번 들여쓰기 된다는 식) 

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
