<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>누구나 페이지</title>

<style type="text/css">
	a {text-decoration: none;}
</style>

<script type="text/javascript">
	alert("로그인을 안했거나 로그아웃 됨~~~");
</script>

</head>
<body>

<h1>누구나 페이지</h1>
	
	<p>로그인을 하지 않은 상태입니다.</p>	
		
	<p>	
		<a href="<%= request.getContextPath() %>/member/info.action">회원 전용 페이지로 이동합니다.(info)</a>
		<br/>
		<a href="<%= request.getContextPath() %>/member/my.action">회원 전용 페이지로 이동합니다.(my)</a> 
	</p>
	
</body>
</html>