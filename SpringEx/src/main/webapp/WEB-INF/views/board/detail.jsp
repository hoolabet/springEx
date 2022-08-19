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
		<c:choose>
			<c:when test="${info ne null}">
				<input type="button" value="수정" id="modi_btn">
				<input type="submit" value="수정"
					formaction="/controller/board/modify" id="modi_sub"
					style="display: none">
				<input type="submit" value="삭제"
					formaction="/controller/board/remove">
			</c:when>
		</c:choose>
		<a href="/controller/board/list?pageNum=${criValue.cri.pageNum}&amount=${criValue.cri.amount}&type=${criValue.cri.type}&search=${criValue.cri.search}">목록으로</a> 
		<input type="hidden" value="${detail.bno}"name="bno" id="bno">
		<input type="hidden" value="${detail.id}" name="id" id="detail">
		<div class="do_modi">
			<p>제목 : ${detail.title}</p>
			<p>내용 : ${detail.content}</p>
		</div>
		<div class="do_modi" style="display:none">
			<p>
				제목 : <input type="text" name="title" value="${detail.title}">
			</p>
			<p>
				내용 :
				<textarea name="content">${detail.content}</textarea>
			</p>
		</div>
		<p>작성자 : ${detail.name}</p>
		<p>작성일 : ${detail.regdate}</p>
	</form>
	<c:choose>
		<c:when test="${info ne null}">
			<!-- 동기
			<form action="/controller/board/reply" method="post">
				<textarea name="content" placeholder="reply"></textarea>
				<input type="submit" value="reply"> <input type="hidden"
					name="name" value="${info.name}"> <input type="hidden"
					name="id" value="${info.id}" id="info"> <input
					type="hidden" name="bno" value="${detail.bno}">
			</form>
			-->
			<div>
				<textarea rows="5" cols="25" id="reply_content"></textarea>
				<input type="button" value="reply" id="reply_btn">
				<input type="hidden" value="${info.id}" id="id">
				<input type="hidden" value="${info.name}" id="name">
			</div>
		</c:when>
	</c:choose>
	<!-- 동기
	<c:forEach var="reply" items="${reply}" varStatus="status">
		<p>${reply.name}<br> ${reply.regdate}<br>
			${reply.content}<br>
		</p>
		<form action="/controller/board/replyRemove" method="post">
			<c:choose>
				<c:when test="${info ne null}">
					<input type="submit" value="❌">
				</c:when>
			</c:choose>
			<input type="hidden" name="regdate" value="${reply.regdate}">
			<input type="hidden" name="id" value="${reply.id}"> <input
				type="hidden" name="bno" value="${reply.bno}">
		</form>
	</c:forEach>
	-->
	<div>
		<table id="reply_view">
			
		</table>
	</div>
	<script>
		if(!${Access}){
			alert("권한이 없습니다.");
		}
		if(${modi}){
			alert("수정되었습니다.");
		}
		<%session.setAttribute("Access", true);
			session.setAttribute("modi", false);%>
		const modiBtn = document.querySelector("#modi_btn");
		const modiSub = document.querySelector("#modi_sub");
		const doModi = document.querySelectorAll(".do_modi");
		const info = document.querySelector("#info");
		const detail = document.querySelector("#detail");
		
		modiBtn.onclick = (e) => {
			e.preventDefault();
			if(info.value == detail.value){
				modiBtn.style.display = "none";
				modiSub.style.display = "inline";
				doModi.forEach((m)=>{
					if(m.style.display != "none"){
						m.style.display = "none";
					}else{
						m.style.display = "inline";
					}
				})
			}
		}
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
	<script src="../resources/js/reply.js?ver=1"></script>
</body>
</html>