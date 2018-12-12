package com.hanul.s4_1;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hanul.board.BoardDTO;
import com.hanul.board.qna.QnaDTO;
import com.hanul.board.qna.QnaService;
import com.hanul.util.Pager;

@Controller
@RequestMapping(value="/qna/**")
public class QnaController {
	/*@Inject
	private QnaService qnaService;
	
	@RequestMapping(value="qnaList")
	public String list(Model model, Pager pager) throws Exception {
		List<BoardDTO> ar = qnaService.list(pager);
		model.addAttribute("board", "qna");
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/boardList";
	}
	
	@RequestMapping(value="qnaSelect")
	public String select(Model model, Integer num) throws Exception{
		QnaDTO qnaDTO = (QnaDTO)qnaService.select(num);
		model.addAttribute("board", "qna");
		model.addAttribute("dto", qnaDTO);
		return "board/boardSelect";
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.GET)
	public String writeForm(Model model) throws Exception{
		model.addAttribute("board", "qna");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="qnaWrite", method=RequestMethod.POST)
	public String wrtie(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.insert(qnaDTO);
		return "redirect:./qnaList";
	}
	
	@RequestMapping(value="reply")
	public String replyForm(Model model, Integer num) throws Exception{
		model.addAttribute("board", "QnaReply");
		model.addAttribute("refContents", num);
		return "board/boardWrite";
	}
	
	@RequestMapping(value="QnaReplyWrite", method=RequestMethod.POST)
	public String reply(QnaDTO qnaDTO) throws Exception{
		int result = qnaService.reply(qnaDTO);
		return "redirect:./qnaList";
	}*/
}
