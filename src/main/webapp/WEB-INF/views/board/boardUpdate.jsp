<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>        
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Page</title>
</head>
<body>
<h2>${board} Update</h2>
	<form action="./${board}Update" method="post">
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
		</table>
		<button>update</button>
	</form>


</body>
</html>