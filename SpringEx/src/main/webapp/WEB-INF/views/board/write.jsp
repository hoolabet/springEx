<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/board/write" method="post">
	<input type="text" name="title">
	<input type="text" name="content">
	<input type="submit" value="제출">
</form>
</body>
</html>