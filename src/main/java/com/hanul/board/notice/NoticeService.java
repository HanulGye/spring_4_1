package com.hanul.board.notice;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanul.board.BoardDTO;
import com.hanul.board.BoardService;
import com.hanul.file.FileDAO;
import com.hanul.file.FileDTO;
import com.hanul.util.FileSaver;
import com.hanul.util.Pager;

@Service
public class NoticeService implements BoardService {
	@Inject
	private NoticeDAO noticeDAO;
	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView insert(BoardDTO boardDTO, List<MultipartFile> f1 ,HttpSession sesion) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int num = noticeDAO.getNum();
		
		boardDTO.setNum(num);
		int result = noticeDAO.insert(boardDTO);
		
		//transaction 처리?
		if(result<1) {
			throw new Exception();
		}
		
		FileSaver fileSaver = new FileSaver();
		String realPath = sesion.getServletContext().getRealPath("resources/notice");
		
		for(MultipartFile multipartFile:f1) {
			if(multipartFile.isEmpty()) {
				continue;
			}
			String fname = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setFname(fname);
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setKind("notice");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
		modelAndView.setViewName("redirect:./noticeList");
		modelAndView.addObject("msg", "Write Success");
		return modelAndView;
	}
	
	public ModelAndView update(BoardDTO boardDTO, List<MultipartFile> f1, HttpSession session) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = noticeDAO.update(boardDTO);
		
		if(result<1) {
			throw new Exception();
		}
		FileSaver fileSaver = new FileSaver();
		String realPath = session.getServletContext().getRealPath("resources/notice");
		for(MultipartFile multipartFile:f1) {
			String fname = fileSaver.saveFile(realPath, multipartFile);
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(boardDTO.getNum());
			fileDTO.setOname(multipartFile.getOriginalFilename());
			fileDTO.setFname(fname);
			fileDTO.setKind("notice");
			result = fileDAO.insert(fileDTO);
			if(result<1) {
				throw new Exception();
			}
		}
		
		modelAndView.setViewName("redirect:./noticeSelect?num="+boardDTO.getNum());
		modelAndView.addObject("msg", "update Success");
		return modelAndView; 
	}
	
	public int delete(Integer num) throws Exception{
		return noticeDAO.delete(num);
	}
	
	public ModelAndView select(Integer num) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		BoardDTO boardDTO = noticeDAO.select(num);
		if(boardDTO!=null) {
			FileDTO fileDTO = new FileDTO();
			fileDTO.setNum(num);
			fileDTO.setKind("notice");
			List<FileDTO> ar = fileDAO.list(fileDTO);
			modelAndView.setViewName("board/boardSelect");
			modelAndView.addObject("dto", boardDTO);
			modelAndView.addObject("files", ar);
			
		}else {
			modelAndView.setViewName("redirect:./noticeList");
			modelAndView.addObject("msg", "해당 글이 없습니다.");
		}
		modelAndView.addObject("board", "notice");
		
		return modelAndView;
	}
	
	public List<BoardDTO> list(Pager pager) throws Exception{
		pager.MakeRow();
		int totalCount = noticeDAO.getCount(pager);
		pager.MakePage(totalCount);
		return noticeDAO.list(pager);
	}
}
