<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/controller/board/write" method="post">
	<input type="text" name="title">
	<input type="text" name="content">
	<input type="hidden" name="id" value="${info.id}">
	<input type="hidden" name="name" value="${info.name}">
	<input type="submit" value="제출" id="sub">
</form>
<a href="list">목록으로</a>

</body>
</html>