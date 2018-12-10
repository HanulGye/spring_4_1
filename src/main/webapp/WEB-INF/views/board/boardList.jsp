<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
	$(function() {
		var message = '${msg}';
		if(message!=''){
			alert(message);
		}
		
		
	})

</script>

</head>
<body>
	<h2>${board} List</h2>
	<h3>${sessionMember.id}</h3>
	
	<table>
		<tr>
			<th>num</th>
			<th>title</th>
			<th>writer</th>
			<th>date</th>
			<th>hit</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		 <tr>
		 	<td>${dto.num}</td>
		 	<td>
		 		<a href="${board}Select?num=${dto.num}">
		 			${dto.title}
		 		</a>
		 	</td>
		 	<td>${dto.writer}</td>
		 	<td>${dto.reg_date}</td>
		 	<td>${dto.hit}</td>
		 </tr>	
		</c:forEach>
	</table>
	
	<!-- pagination -->
	<c:if test="${pager.curBlock>1}">
		<a href="./${board}List?curPage=${pager.startNum-1}">[이전]</a>
	</c:if>
	<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
		<a href="./${board}List?curPage=${i}">${i}</a>
	</c:forEach>
	<c:if test="${pager.curBlock<pager.totalBlock}">
		<a href="./${board}List?curPage=${pager.lastNum+1}">[다음]</a>
	</c:if>
	
	<a href="./${board}Write">Write</a>
	
</body>
</html>