<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SelectOne</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		var msg = '${msg}';
		if(msg!=''){
			alert(msg);
		}
	})
</script>
</head>
<body>

	<h2>${board} Select</h2>

	<h3>Title : ${dto.title}</h3>
	<h3>Writer : ${dto.writer}</h3>
	<h3>Contents : ${dto.contents}</h3>
	<h3>Date : ${dto.reg_date}</h3>
	<c:if test="${board eq 'qna'}">
		<h4>ref : ${dto.ref}</h4>
	
	</c:if>
	
	<div>
		<c:forEach items="${files}" var="file" varStatus="i">
			<div id="f${i.index}">
				<a href="../resources/${board}/${file.fname}">${file.oname}</a>
			</div>
		
		</c:forEach>
	
	</div>
	
	
	<form action="./${board}Delete" method="POST">
		<input type="hidden" value="${dto.num}" name="num">
		<button>delete</button>
	</form>
	<a href="./${board}Update?num=${dto.num}"><button>Update</button></a>
	<a href="./${board}List"><button>Back</button></a>

	<c:if test="${board eq 'qna'}">
		<a href="./reply?num=${dto.num}"><button>Reply</button></a>
	</c:if>

</body>
</html>