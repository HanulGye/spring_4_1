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
	
	<form action="./${board}Write" method="post">
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
		</table>
		<button>Write</button>
	</form>

</body>
</html>