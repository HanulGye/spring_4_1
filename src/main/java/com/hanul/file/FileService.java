package com.hanul.file;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

@Service
public class FileService {

	@Inject
	private FileDAO fileDAO;
	
	public ModelAndView delete(int fnum) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		int result = fileDAO.delete(fnum);
		modelAndView.setViewName("common/result");
		modelAndView.addObject("result", result);
		return modelAndView;
	}
	
}
