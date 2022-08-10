<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Welcome , ${info.name} !
	<a href="login">로그인</a>
	<a href="signup">회원가입</a>
	<a href="/controller">홈으로</a>
	
	<table border=1>
		<tr>
			<td>아이디</td>
			<td>이름</td>
		</tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td>${list.id}</td>
				<td>${list.name}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>