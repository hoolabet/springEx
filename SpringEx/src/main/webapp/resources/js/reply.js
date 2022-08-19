/**
 * 
 */


const bnoValue = $("#bno").val();	

replyView(bnoValue);



$("#reply_btn").on("click",function(){
	const idValue = $("#id").val();
	const nameValue= $("#name").val();
	const contentValue = $("#reply_content").val();
	const rw = {bno:bnoValue, id:idValue, name:nameValue, content:contentValue};
	replyWrite(rw);
	$("#reply_content").val("");
	setTimeout(() => {
		replyView(bnoValue);
	}, 100);
});

function replyWrite(rw) {
	$.ajax({
		type: "post", // method get (select) , post (insert) , put (update) , delete (delete)
		url: "/controller/replies/new", // RequestMapping value 와 일치시켜야함
		data: JSON.stringify(rw),
		contentType: "application/json; charset=utf-8",
		success:function(r){
			alert("작성되었습니다.");
		}
	})
}

function replyView(bno) {
	$.getJSON("/controller/replies/"+bno+".json",function(r){
		let reply = "";
		r.forEach(function(a){
			reply += `
				<tr class="reply">
					<td>${a.name}</td>
					<td>${a.content}</td>
					<td>${a.regdate}</td>
					<td id=${a.rno}><span class="reply_delete" style="cursor:pointer">✖</span><span class="reply_update" style="cursor:pointer">✏</span></td>
				</tr>`;
			
		})
		$("#reply_view").html(reply);
		
		$(".reply_delete").on("click",function(){
			replyDelete($(this).parent().attr("id"));	
			}
		);
	})
}

function replyDelete(rd){
	$.ajax({
		type: "delete", // method get (select) , post (insert) , put (update) , delete (delete)
		url: "/controller/replies/delete", // RequestMapping value 와 일치시켜야함
		data: rd,
		contentType: "application/json; charset=utf-8",
		success:function(r){
			alert("삭제되었습니다.");
			setTimeout(() => {
				replyView(bnoValue);
			}, 100);
		}
	})
}