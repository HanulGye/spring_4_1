<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta charset="UTF-8">
	<title>Home</title>
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
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./notice/noticeList">Notice List</a>
<a href="./qna/qnaList">QNA List</a>


<c:choose>
	<c:when test="${sessionMember.id ne null}">
		<a href="./member/myPage?id=${sessionMember.id}">myPage</a>
		<a href="./" id="logOut">LogOut</a>
	</c:when>
	<c:otherwise>
		<a href="./member/join">Join</a>
		<a href="./member/login">Login</a>
	</c:otherwise>
</c:choose>

</body>
</html>
