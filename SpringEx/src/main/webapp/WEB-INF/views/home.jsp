<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>
		Hello world!
		<c:choose>
			<c:when test="${info eq null}">
				Guest !
			</c:when>
			<c:otherwise>
				${info.name} !
			</c:otherwise>
		</c:choose>
	</h1>

	<P>The time on the server is ${serverTime}.</P>
	<a href="board/list">글 목록</a>
	<a href="member/list">회원 목록</a>
	<c:choose>
		<c:when test="${info eq null}">
			<a href="member/login">로그인</a>
		</c:when>
		<c:otherwise>
			<a href="member/logout">로그아웃</a>
		</c:otherwise>
	</c:choose>
</body>
</html>
