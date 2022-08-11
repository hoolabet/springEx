<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
<style>
table {
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	padding: 20px;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td>no</td>
			<td>title</td>
			<td>name</td>
			<td>regdate</td>
			<td>view</td>
		</tr>
		<c:forEach var="list" items="${list}" varStatus="status">
			<tr>
				<td>${list.bno}</td>
				<td><a href="detail?bno=${list.bno}">${list.title}</a></td>
				<td>${list.name}</td>
				<td>${list.regdate}</td>
				<td>${list.cnt}</td>
			</tr>
		</c:forEach>
	</table>
	<a href="write">글쓰기</a>
	<a href="/controller">홈으로</a>
</body>
</html>