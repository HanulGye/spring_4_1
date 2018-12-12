<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WritePage</title>
</head>
<body>
	<h2>${board} Write Page</h2>
	
	<form action="./${board}Write" method="post" enctype="multipart/form-data">
		<table style="width: 1000px">
			<colgroup>
				<col width="80%">
				<col width="20%">
			</colgroup>
			<tr>
				<th>title</th>
				<td><input type="text" placeholder="제목 입력" name="title"></td>
			</tr>
			<tr>
				<th>writer</th>
				<td><input type="text" placeholder="작성자 입력" name="writer"></td>
			</tr>
			<tr>
				<th>contents</th>
				<td><textarea style="width: 500px; height: 500px" name="contents"></textarea></td>
			</tr>
			<tr>
				<td>
					<input type="button" value="ADD">
					<div id="files">
						<div>
							<input type="file" name="f1"><span>X</span>
							<input type="file" name="f1"><span>X</span>
						</div>
					</div>
				</td>
			</tr>
			
			<c:if test="${board eq 'QnaReply'}">
				<tr>
					<td><input type="hidden" name="num" value="${refContents}"></td>
				</tr>
			</c:if>
		</table>
		<button>Write</button>
	</form>

</body>
</html>