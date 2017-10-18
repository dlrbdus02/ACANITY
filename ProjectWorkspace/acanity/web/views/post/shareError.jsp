<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareError</title>
<link rel="stylesheet" href="../../css/sharepost.css">
</head>
<body>
<div id="list_box1">
	<div id="list_box1_sub1">ERROR PAGE</div>
</div>

<div id="list_box2">
		<span id="error_span1">SharePost 서비스 에러 발생</span>
		<span id="error_span2"> <%= request.getAttribute("message") %></span>
	<div id="list_box2_sub2">
		<button id="error_button1">이전 페이지로</button>
	</div>
</div>

</body>
</html>