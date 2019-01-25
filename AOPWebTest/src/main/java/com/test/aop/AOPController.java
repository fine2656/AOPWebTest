package com.test.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController {
	@Autowired
	ICore core;
	
	// 로그인한 회원만 사용하는 전용기능에 대해서 인증받지 못한 사용자는 특정 페이지로 리디렉트를 시키는 보조 업무
	//시작페이지
	@RequestMapping(value="/index.action",method= {RequestMethod.GET})
	public String  index() {
		
		return "index";
		
	}
	// 이 페이지를 통해서 접속하면 인증을 받았다고 가정한다.
		@RequestMapping(value="/auth/member.action", method={RequestMethod.GET}) 
		public String authmember(HttpSession session) {
			
			// 로그인 성공!!
			session.setAttribute("loginuser", "hongkd");
			
			return "auth/member";
		}
		
		
		// 이 페이지를 통해서 접속하면 인증을 받지 않았다고 가정한다.
		@RequestMapping(value="/auth/anonymous.action", method={RequestMethod.GET}) 
		public String authanonymous(HttpSession session) {
			
			// 로그아웃!!
			// session.removeAttribute("loginuser");
			session.invalidate(); // 세션 삭제
			
			
			return "auth/anonymous";
		}
	
		// 회원전용 페이지 1
		@RequestMapping(value="/member/info.action", method={RequestMethod.GET}) 
		public String memberinfo(HttpServletRequest request, HttpServletResponse response) { 
					
			return "member/info";
		}
		
		
		// 회원전용 페이지 2
		@RequestMapping(value="/member/my.action", method={RequestMethod.GET}) 
		public String membermy(HttpServletRequest request, HttpServletResponse response) {
					
			return "member/my";
		}
		
}
