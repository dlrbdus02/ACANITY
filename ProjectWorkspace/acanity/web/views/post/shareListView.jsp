<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.model.vo.Member, community.model.vo.Community,
				post.model.vo.Post, java.util.*" %>
<%
	//가짜데이터
	Member member = new Member("아이디", "비밀번호", "이름", "A", "오전", "01091901099", "이메일");
	Community community = new Community();
	community.setCommunityName("모임명");
	
	ArrayList<Post> list = new ArrayList<Post>();
	Post post1 = new Post(1, 2, "제목1", "내용1", 0, null, 0, "password", null, null, "작성자1", 1, 0, 1);
	Post post2 = new Post(2, 2, "제목2", "내용2", 0, null, 0, "password", null, null, "작성자2", 1, 0, 1);
	Post post3 = new Post(3, 2, "제목3", "내용3", 0, null, 0, "password", null, null, "작성자3", 1, 0, 1);
	Post post4 = new Post(4, 2, "제목4", "내용4", 0, null, 0, "password", null, null, "작성자4", 1, 0, 1);
	Post post5 = new Post(5, 2, "제목5", "내용5", 0, null, 0, "password", null, null, "작성자5", 1, 0, 1);
	Post post6 = new Post(6, 2, "제목6", "내용6", 0, null, 0, "password", null, null, "작성자6", 1, 0, 1);
	Post post7 = new Post(7, 2, "제목7", "내용7", 0, null, 0, "password", null, null, "작성자7", 1, 0, 1);
	Post post8 = new Post(8, 2, "제목8", "내용8", 0, null, 0, "password", null, null, "작성자8", 1, 0, 1);
	list.add(post1);
	list.add(post2);
	list.add(post3);
	list.add(post4);
	list.add(post5);
	list.add(post6);
	list.add(post7);
	list.add(post8);
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shareListView</title>
<link rel="stylesheet" href="../../css/sharepost.css">
</head>
<body>
<div id="list_box1">
	<div id="list_box1_sub1">자료공유방</div>
	<div id="list_box1_sub2"><b><%= member.getmId() %></b>님 환영합니다.</div>
</div>

<div id="list_box2">
	<div id="list_box2_sub0">
		<table id="list_table1">
		<tr><td width="8%">번호</td>
			<td width="46%">제목</td>
			<td width="15%">작성자</td>
			<td width="17%">작성일</td>
			<td width="9%">조회수</td></tr>
		</table>
	</div>
	<div id="list_box2_sub1">
		<table id="list_table2" cellspacing="0" style="border-collapse : collapse;">
<% for (Post p : list){ %>
		<tr><td width="8%"><%= p.getpNo() %></td>
			<td width="46%" style="text-align: left; padding-left: 6px"><%= p.getpTitle() %></td>
			<td width="15%"><%= p.getpId() %></td>
			<td width="17%"><%= p.getpDate() %></td>
			<td width="9%"><%= p.getReadCount() %></td></tr>
<% }%>
		</table>
	</div>
	<div id="list_box2_sub2">
		<div id="list_box2_sub2_1">
			<input id="list_input1" type="text" name="title" placeholder=" 제목을 입력하세요." size="26">
			<button id="list_button1">검색</button>
		</div>
		<div id="list_box2_sub2_2">
			<button id="list_button2">올리기</button>
		</div>
	</div>
</div>

</body>
</html>