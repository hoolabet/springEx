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
	<form method="post">
		<input type="hidden" value="${detail.bno}" name="bno">
		<p>제목 : ${detail.title}</p>
		<p>
			제목 : <input type="text" name="title" value="${detail.title}">
		</p>
		<p>내용 : ${detail.content}</p>
		<p>
			내용 :
			<textarea name="content">${detail.content}</textarea>
		</p>
		<p>작성일 : ${detail.regdate}</p>
		<input type="submit" value="수정" formaction="/controller/board/modify">
		<input type="submit" value="삭제" formaction="/controller/board/remove">
	</form>
	<a href="list">목록으로</a>
</body>
</html>