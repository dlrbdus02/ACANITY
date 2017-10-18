<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/head.jsp"%>
<!-- navbar -->
<%@ include file="/header.jsp"%>
<%
	member = (Member)request.getAttribute("member");
%>
<br>
<h2 align="center"><%= member.getmName() %>님 정보보기</h1>
<br><br>
<form action="/acanity/mupdate" method="post">
	
		<table align="center" width="600" height="350">
			<tr>
				<th width="150">아이디</th>
				<td width="450"><input name="mid" value="<%= member.getmId() %>" readonly></td>
			</tr>
			<tr>
				<th>이 름</th>
				<td><input type="text" name="mname" value="<%= member.getmName() %>"></td>
			</tr>
			<tr>
				<th>암 호</th>
				<td><input type="password" name="mpw" value="<%= member.getmPwd() %>"></td>
			</tr>
			<tr>
				<th>암호확인</th>
				<td><input type="password" name="mpw2">
				<div id="checkPwd">동일한 암호를 입력하세요.</div></td>
			</tr>
			<td><br></td>
			<tr>
				<th>전화번호</th>
				<td><input type="tel" name="mtel" value="<%= member.getmTel() %>"></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="email" name="memail" value="<%= member.getmEmail() %>"></td>
			</tr>
			<tr>
				<th>시간</th>
				<td><input type="text" name="mtime" value="<%= member.getmTime() %>" readonly></td>
			</tr>

			<tr>
				<th>클래스</th>
				<td><input type="text" name="mclass" value="<%= member.getmClass() %>" readonly></td>
			</tr>
			<tr>
				<td><br></td>
			</tr>
			<tr>
				<th colspan="2">
					<button type="submit" class="btn btn-success">정보수정완료</button>&nbsp;
					<a href="/acanity/views/mypage/mypageMain.jsp">취소</a>
				</th>
			</tr>
		</table>
	
</form>
<br>
<%@ include file="/footer.jsp"%>
<%@ include file="/headend.jsp"%>