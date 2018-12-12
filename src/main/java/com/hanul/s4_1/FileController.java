package com.hanul.s4_1;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hanul.file.FileService;
@Controller
@RequestMapping(value="/file/**")
public class FileController {
	
	@Inject
	FileService fileService;
	
	@RequestMapping(value="delete")
	public ModelAndView delete(int fnum) throws Exception{
		ModelAndView modelAndView = fileService.delete(fnum);
		return modelAndView;
	}
}
