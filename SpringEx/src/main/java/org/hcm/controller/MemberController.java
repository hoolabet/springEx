package org.hcm.controller;

import javax.servlet.http.HttpSession;

import org.hcm.model.MemberVO;
import org.hcm.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	@Autowired
	MemberService ms;
	
	@RequestMapping(value = "/member/list", method = RequestMethod.GET)
	public void list(Model model) {
		model.addAttribute("list", ms.list());
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.GET)
	public void login() {
		
	}
	
	@RequestMapping(value = "/member/login", method = RequestMethod.POST)
	public String loginPOST(MemberVO mvo, HttpSession session) {
		session.setAttribute("info", ms.login(mvo));
		if(session.getAttribute("info") == null) {
			return "/member/login";
		}else {
			return "redirect:/member/list";
		}
	}
	
	@RequestMapping(value = "/member/signup", method = RequestMethod.GET)
	public void signup() {
		
	}
	
	@RequestMapping(value = "/member/signup", method = RequestMethod.POST)
	public String signupPOST(MemberVO mvo) {
		ms.signup(mvo);
		return "/member/login";
	}
}
