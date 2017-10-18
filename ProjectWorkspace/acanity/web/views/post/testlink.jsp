<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료공유게시판 테스트</title>
<script type="text/javascript">
	function openWin(){
		var width=720, height=391;
		var left = (window.screen.width / 2) - (width / 2);
		var top = (window.screen.height / 2) - (height / 1.7);
		var specs = "width=" + width;
		specs += ",height=" + height;
		specs += ",left=" + left;
		specs += ",top=" + top;
		specs += ",toolbar=no, channelmode=no, menubar=no, status=no, scrollbars=no, resizable=no";

		//가짜데이터
		var cno = 2;	//모임번호
		
		window.open("/acanity/splist?cno=" + cno, "자료공유방", specs);
	}
</script>
</head>
<body>
<a href="javascript:openWin();">자료공유방 열기</a>
<br>
<a href="shareError.jsp">에러페이지 form</a>
</body>
</html>