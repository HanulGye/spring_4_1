<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		var message = '${msg}';
		message = message.trim();
		if(message!=''){
			alert(message);
		}
	})
</script>
</head>
<body>
	
		<table>
			<colgroup>
				<col width="60%">
				<col width="20%">
				<col width="20%">
			</colgroup>
			
			<tr>
				<th>NAME</th>
				<td>${sessionMember.name}</td>
			</tr>
			<tr>
				<th>Email</th>
				<td>${sessionMember.email}</td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td>${sessionMember.phone}</td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td>${sessionMember.address}</td>
			</tr>
			
		</table>
		<a href="./update">Update</a>
		<form action="./delete" method="post">
			<input type="hidden" name="id" value="${sessionMember.id}">
			<button>Delete</button>
		</form>
		<a href="../">back</a>
</body>
</html>