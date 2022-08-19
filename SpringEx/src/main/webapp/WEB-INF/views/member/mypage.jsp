<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${info.name} 의 페이지</title>
</head>
<body>
	<table>
		<tr>
			<td>아이디</td>
			<td>${info.id}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${info.name}</td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${info.password}</td>
		</tr>
	</table>
	<form>
		<input type="submit" value="수정" formaction="">
		<input type="submit" value="삭제" formaction="">
	</form>
</body>
</html>