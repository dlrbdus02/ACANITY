<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QnAPostError</title>
</head>
<body>
<h2>board 서비스 에러 발생 : <%= request.getAttribute("message") %></h2>
<a href="/acanity/index.jsp">시작페이지로 이동</a>
</body>
</html>