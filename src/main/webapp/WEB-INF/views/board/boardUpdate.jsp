<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
	.files, .del{
		color: red;
		cursor: pointer;
	}
</style>
<script>
	$(function() {
		$('.files').click(function() {
			var del = $(this).attr('title');
			var id = $(this).attr('id');
			$.ajax({
				url:"../file/delete",
				type: "GET",
				data:{
					fnum:id
				}, 
				success:function(){
					data = data.trim();
					if(data==1){
						$('#'+del).remove();
						count--;
					}else{
						alert('File Delete Fail');
					}
				}
			});
		})
		var count = ${files.size()};
		var index = 0;
		$('#btn').click(function() {
			var file = '<div id="a'+index+'"><input type="file" name="f1"><span class="del" title="a'+index+''">X</span></div>';
			
			if(count<5){
			var f = $('#f').html();
			$('#addFile').append(f);
			count++;
			index++;
			}else{
				alert('첨부 파일은 최대 5개');
			}
		})
		$('#addFile').on("click", ".del", function() {
			var id = $(this).attr("title");
			$('#'+id).remove();
			count--;
		})
	})
</script>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
<h2>${board} Update</h2>
	<form action="./${board}Update" method="post" enctype="multipart/form-data">
		<table style="width: 1000px">
			<colgroup>
				<col width="80%">
				<col width="20%">
			</colgroup>
			<tr>
				<th>title</th>
				<td><input type="text" value="${dto.title}" name="title"></td>
			</tr>
			<tr>
				<th>writer</th>
				<td><input type="text" placeholder="${dto.writer}" readonly="readonly"></td>
			</tr>
			<tr>
				<th>contents</th>
				<td>
					<textarea style="width: 500px; height: 500px" name="contents">${dto.contents}</textarea>
				</td>
			</tr>
			<tr>
				<td><input type="hidden" name="num" value="${dto.num}"></td>
			</tr>
			<tr id="addFile">
					
			</tr>			
			<c:forEach items="${files}" var="file" varStatus="i">
				<tr>
					<td>
						<div id="f${i.index}">
							<span>${file.oname}</span><span title="f${i.index}" class="files" id="${file.fnum}">X</span>
						</div>
					</td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" id="btn" value="Add File">
		<button>update</button>
	</form>
	<!-- <div id="f" style="display: none">
		<input type="file" name="f1"><span>X</span>
	</div> -->

</body>
</html>