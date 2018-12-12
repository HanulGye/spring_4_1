package com.hanul.board;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.hanul.util.Pager;
@Service
public interface BoardService {

	public ModelAndView insert(BoardDTO boardDTO, List<MultipartFile> files ,HttpSession sesion) throws Exception;
	
	public ModelAndView update(BoardDTO boardDTO, List<MultipartFile> files ,HttpSession sesion) throws Exception;
	
	public int delete(Integer num) throws Exception;
	
	public ModelAndView select(Integer num) throws Exception;
	
	public List<BoardDTO> list(Pager pager) throws Exception;
	
}
