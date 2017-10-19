<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, post.model.vo.Post, java.util.*" %>
<%
	Member member = (Member)session.getAttribute("member");
	int cno = Integer.parseInt(request.getParameter("cno"));
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareListView</title>
<link rel="stylesheet" href="../../css/sharepost.css">
<script type="text/javascript">
	function postWrite(){
		location.href = "shareWriteForm.jsp?cno=<%=cno%>";
	}
</script>
</head>
<body>
<div id="list_box1">
	<div id="list_box1_sub1">자료공유방</div>
	<div id="list_box1_sub2"><b><%= member.getmId() %></b>님 환영합니다.</div>
</div>

<div id="list_box2">
	<div id="write_box3">
		<span id="write_span1">파일 업로드</span>
		<span id="write_span2">뒤로</span>
	</div>
	<div id="write_box1">
		<div id="write_box1_sub1">
			<table id="write_table1" cellspacing="0" style="border-collapse : collapse;">
				<tr><th width="18%" style="border-top-width: 0;">제목</th>
					<td style="border-top-width: 0;">123</td></tr>
				<tr><th>작성자</th>
					<td>123</td></tr>
				<tr height="117"><th>내용</th>
					<td>231</td></tr>
				<tr><th>비밀번호</th>
					<td>23</td></tr>
				<!-- 게시물 수정 시 입력할 비밀번호입니다. -->
			</table>
		</div>
		<div id="write_box1_sub2">
		파일 목록
		<!-- <table id="write_table2" cellspacing="0" style="border-collapse : collapse;">
		<tr><td width="8%"></td>
			<td width="46%" style="text-align: left; padding-left: 6px"></td>
			<td width="15%"></td>
			<td width="17%"></td>
			<td width="9%"></td></tr>
		</table> -->
		</div>
	</div>
	<div id="write_box2">
			<button type="submit" id="write_button1" style="cursor: pointer">SUBMIT</button>
	</div>
</div>

</body>
</html>