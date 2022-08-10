<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/controller/member/signup" method="POST">
		<p>
			아이디 : <input type="text" name="id">
		</p>
		<p>
			비밀번호 : <input type="password" name="password">
		</p>
		<p>
			이름 : <input type="text" name="name">
		</p>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>