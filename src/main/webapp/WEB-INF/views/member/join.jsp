<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function() {
		$('#jungBok').click(function() {
			var id = $('#inputId').val();
			$.ajax({
				url:"",
				type:"GET",
				data:{id:id},
				success: function(data) {
					data = data.trim();
					alert(data);
				}
			})
		})
	})	

</script>
</head>
<body>
	<form action="./join" method="post">
		<table>
			<colgroup>
				<col width="60%">
				<col width="20%">
				<col width="20%">
			</colgroup>
			<tr>
				<th>ID</th>
				<td><input type="text" name="id" id="inputId"></td>
				<td><button id="jungBok">중복 확인</button>
			</tr>
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
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>Email</th>
				<td><input type="email" name="email"></td>
			</tr>
			<tr>
				<th>PHONE</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>ADDRESS</th>
				<td><input type="text" name="address"></td>
			</tr>
			<tr>
				<th></th>
				<td><button>Join</button></td>
			</tr>
		</table>
	</form>
	<div id="result"></div>

</body>
</html>