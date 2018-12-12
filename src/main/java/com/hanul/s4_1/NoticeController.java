package com.hanul.s4_1;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanul.board.BoardDTO;
import com.hanul.board.notice.NoticeService;
import com.hanul.util.Pager;

@Controller
@RequestMapping(value="/notice/**")
public class NoticeController {

	@Inject
	private NoticeService noticeService;
	
	@RequestMapping(value="noticeList", method=RequestMethod.GET)
	public String list(Model model, Pager pager) throws Exception {
		//Pager pager = new Pager();
		/*pager.setCurPage(curPage);
		pager.setKind(kind);
		pager.setSearch(search);*/
		List<BoardDTO> ar = noticeService.list(pager);
		model.addAttribute("board", "notice");
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		//매개변수를
		return "board/boardList";
	}
	
	@RequestMapping(value="noticeSelect", method=RequestMethod.GET)
	public ModelAndView select(Integer num) throws Exception {
		ModelAndView modelAndView = noticeService.select(num);
		return modelAndView;
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String writeForm(Model model) throws Exception{
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public ModelAndView write(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
		ModelAndView modelAndView = noticeService.insert(boardDTO, f1, session);
		return modelAndView;
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public ModelAndView update(Integer num) throws Exception{
		ModelAndView modelAndView =  noticeService.select(num);
		modelAndView.setViewName("board/boardUpdate");
		return modelAndView;
	}
	
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public ModelAndView update(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
		ModelAndView modelAndView = noticeService.update(boardDTO, f1, session);
		return modelAndView;
	}
	
	@RequestMapping(value="noticeDelete", method=RequestMethod.POST)
	public String delete(Integer num, RedirectAttributes rd) throws Exception{
		int result = noticeService.delete(num);
		String message ="delete Fail";
		if(result<1) {
			rd.addFlashAttribute("msg", message);
			return "redirect:./noticeSelect?num="+num;
		}else {
			message="delete success";
			rd.addFlashAttribute("msg", message);
			return "redirect:./noticeList";
		}
	}
}
