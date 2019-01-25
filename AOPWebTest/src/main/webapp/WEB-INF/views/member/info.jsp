<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 전용 정보 페이지(info)</title>

<style type="text/css">
	a {text-decoration: none;}
</style>

</head>
<body>

<h1>회원 전용 정보 페이지(info)</h1>
	
	<span style="color: blue;"> 로그인유저 ID : ${sessionScope.loginuser}</span> 	
	
	<p>
		<a href="<%= request.getContextPath() %>/auth/anonymous.action">로그아웃</a>
	</p>

</body>
</html>