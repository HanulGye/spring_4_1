package com.hanul.s4_1;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.hanul.member.MemberDTO;
import com.hanul.member.MemberService;

@Controller
@SessionAttributes("sessionMember")
@RequestMapping(value="/member/**")
public class MemberController {

	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="join")
	public void join() throws Exception{}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO, RedirectAttributes rd) throws Exception{
		int result = memberService.join(memberDTO);
		String path ="redirect:../";
		if(result<1) {
			path ="redirect:./join";
			rd.addFlashAttribute("msg", "회원가입 실패");
		}else {
			rd.addFlashAttribute("msg", "회원가입 성공");
		}
		
		return path;
	}
	
	@RequestMapping(value="checkId", method=RequestMethod.GET)
	public void checkId(String id) throws Exception{
		memberService.checkId(id);
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login() throws Exception{}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String login(RedirectAttributes rd, HttpSession session, MemberDTO memberDTO) throws Exception{
		MemberDTO member = memberService.login(memberDTO);
		String path ="redirect:../";
		if(member!=null) {
			session.setAttribute("sessionMember", member);
		}else {
			rd.addFlashAttribute("msg", "로그인 실패");
			path="redirect:./login";
		}
		
		return path;
	}
	
	@RequestMapping(value="myPage", method=RequestMethod.GET)
	public void myPage() throws Exception{}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update() throws Exception{}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(MemberDTO memberDTO, RedirectAttributes rd) throws Exception{
		int result = memberService.update(memberDTO);
		String path ="redirect:./myPage";
		if(result<1) {
			rd.addFlashAttribute("msg", "수정 실패");
		}
		return path;
	}
	
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public String delete(String id, RedirectAttributes rd, HttpSession session) throws Exception{
		int result = memberService.delete(id);
		String path ="redirect:../";
		if(result<1) {
			path="redirect:./myPage";
			rd.addFlashAttribute("msg", "계정 삭제 실패");
		}else {
			rd.addFlashAttribute("msg", "다음에 또 와요");
			session.invalidate();
		}
		return path;
	}
	
}
