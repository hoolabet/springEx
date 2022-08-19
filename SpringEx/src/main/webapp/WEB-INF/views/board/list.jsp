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
	<form action="/controller/board/list" id="search_form">
		<input type="hidden" name="pageNum" value="1">
		<input type="hidden" name="amount" value="${paging.cri.amount}">
		<select name="type">
			<option value="t">제목</option>
			<option value="c">내용</option>
			<option value="tc">제목+내용</option>
			<option value="w">작성자</option>
		</select>
		<input type="text" name="search">
		<input type="submit" value="찾기">
	</form>
	<c:choose>
		<c:when test="${info ne null}">
			<a href="write">글쓰기</a>
		</c:when>
	</c:choose>
	<br>
	<a href="/controller/board/list?pageNum=1&amount=${paging.cri.amount}&type=${paging.cri.type}&search=${paging.cri.search}">처음으로</a>
	<c:if test="${paging.prev}">
		<a href="/controller/board/list?pageNum=${paging.endPage-10}&amount=${paging.cri.amount}&type=${paging.cri.type}&search=${paging.cri.search}">이전</a>
	</c:if>
	<c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="num">
		<a href="/controller/board/list?pageNum=${num}&amount=${paging.cri.amount}&type=${paging.cri.type}&search=${paging.cri.search}">${num}</a>
	</c:forEach>
	<c:if test="${paging.next}">
		<a href="/controller/board/list?pageNum=${paging.endPage+1}&amount=${paging.cri.amount}&type=${paging.cri.type}&search=${paging.cri.search}">다음</a>
	</c:if>
	<a href="/controller/board/list?pageNum=${paging.realEnd}&amount=${paging.cri.amount}&type=${paging.cri.type}&search=${paging.cri.search}">맨끝으로</a>
	<br>
	<a href="/controller">홈으로</a>
	<script>
		if(${remo}){
			alert("삭제되었습니다.");
		}
		<%
			session.setAttribute("remo", false);
		%>
	</script>
</body>
</html>