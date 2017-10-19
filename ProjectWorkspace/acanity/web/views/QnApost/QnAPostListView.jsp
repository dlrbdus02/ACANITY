<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<%@ include file="/head.jsp" %>

<%@ include file="/header.jsp" %>
<html>
<head>
<meta charset="UTF-8">
<title>QnAPostListView</title>
</head>
<body>
<table align="center">
	<tr><td>번호</td>
	<td>제목</td>
	<td>작성자</td>
	<td>작성일</td>
	<td>조회수</td></tr>
</table>
<table align="center">
<% for(Post p : list){ %>
	<tr><td><%=p.getpNo() %></td>
		  <td><%=p.getpTitle() %></td>
		  <td><%=p.getpId() %></td>
		  <td><%=p.getpDate() %></td>
		  <td><%=p.getpReadCount() %></td></tr>
<% } %>
</table>


</body>
<%@ include file="/footer.jsp" %>


<%@ include file="/headend.jsp" %>
</html>