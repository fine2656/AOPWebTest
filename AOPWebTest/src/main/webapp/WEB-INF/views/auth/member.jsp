<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 페이지</title>

<style type="text/css">
	a {text-decoration: none;}
</style>

<script type="text/javascript">
	alert("로그인 성공!!");
</script>

</head>
<body>

<h1>회원 페이지</h1>
	
	<p>ID명 <span style="color: red;">${sessionScope.loginuser}</span> 으로 로그인 성공한 상태입니다.</p>	
		
	<p>
		<a href="<%= request.getContextPath() %>/member/info.action">회원 전용 페이지로 이동합니다.(info)</a>
		<br/>
		<a href="<%= request.getContextPath() %>/member/my.action">회원 전용 페이지로 이동합니다.(my)</a> 
	</p>
	
	<p>
		<a href="<%= request.getContextPath() %>/auth/anonymous.action">로그아웃</a>
	</p>

</body>
</html>