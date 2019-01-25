package com.test.aop;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect // 관심사 class
@Component 
/*
  XML에서 빈을 만드는 대신에 클래스명 앞에 @Component 어노테이션을 적어주면
   해당 클래스(지금은 Cross)는 bean으로 자동 등록된다.
   그리고 bean의 이름(첫글자는 소문자)은 해당 클래스명(지금은 Cross)이 된다.
   지금은 bean의 이름은 cross 이 된다.
*/
public class Cross {
	
	// 로그인 되어진 회원만 접근이 가능하도록 하는 메소드들을 Pointcut 으로 선언한다.
	// - AOPController.memberinfo() : 회원 전용 정보페이지
	// - AOPController.membermy() : 회원 전용 개인페이지
	@Pointcut("execution(public * com.test.aop.AOPController.member*(..))")
	public void pcmember() {}
	
	// - 인증받지 못한 (로그인 안한 사용자)사용자는 회원 전용 페이지에 접속 할 수 없다.
	@Before("pcmember()")
	public void memberbefore(JoinPoint joinPoint) {
		// 로그인 유무를 확인하기 위해서 request (첫번째 파라미터)를 통해 session을 얻어온다.
		
		HttpServletRequest request = (HttpServletRequest)joinPoint.getArgs()[0];//AOPController 의 request를 받아온다 
		HttpServletResponse response =(HttpServletResponse)joinPoint.getArgs()[1];//
		
		HttpSession session =  request.getSession();
		if(session.getAttribute("loginuser") == null){
			try {
				String msg = "먼저 로그인 하세요 ";
				String loc = "/aop/index.action";
				
				request.setAttribute("msg", msg);
				request.setAttribute("loc", loc);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/msg.jsp");
			
				dispatcher.forward(request,response);
			} catch (ServletException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
				
	}// end of memberbefore
	
}
