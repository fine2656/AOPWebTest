<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시작페이지</title>

<style type="text/css">
	a {text-decoration: none;}
</style>

</head>
<body>

	<h1>시작페이지</h1>		
		<p>
			<a href="<%= request.getContextPath() %>/auth/member.action">회원으로 접속하기(로그인 페이지)</a>
			<br/>
			<a href="<%= request.getContextPath() %>/auth/anonymous.action">비회원으로 접속하기(로그아웃 페이지)</a> 
		</p>

</body>
</html>