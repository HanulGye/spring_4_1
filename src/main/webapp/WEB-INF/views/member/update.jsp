<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="./update" method="post">
		<table>
			<colgroup>
				<col width="60%">
				<col width="20%">
				<col width="20%">
			</colgroup>
			<tr>
				<th>PW</th>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<th>PW확인</th>
				<td><input type="password" name="confirmPw"></td>
			</tr>
			<tr>
				<th>NAME</th>
				<td><input type="text" name="name" value="${sessionMember.name}"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email" value="${sessionMember.email}"></td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td><input type="text" name="phone" value="${sessionMember.phone}"></td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td><input type="text" name="address" value="${sessionMember.address}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="${sessionMember.id}"></td>
			</tr>
			<tr>
				<th></th>
				<td><button>Update</button></td>
			</tr>
		</table>
	</form>
</body>
</html>