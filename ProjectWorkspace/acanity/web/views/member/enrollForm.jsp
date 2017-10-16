<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/head.jsp"%>
<!-- navbar -->
<%@ include file="/header.jsp"%>

<section id="join" class="section orange">
<h2 align="center">회원 가입 페이지</h2>
<br>
<!-- 웹에서의 절대경로 : "/context root명/대상경로/파일명.확장자" -->

<form action="/acanity/menroll" method="post">
<table align="center" width="600" height="350">
<tr><th width="150">아이디</th>
   <td width="450"><input type="text" name="m_id" value=""></td>
</tr>
<tr><th>이 름</th>
   <td><input type="text" name="m_name" value=""></td>
</tr>
<tr><th>암 호</th>
   <td><input type="password" name="m_pw" value=""></td>
</tr>
<tr><th>암호확인</th><td><input type="password" name="m_pw2"></td>
</tr>
<tr><th>전화번호</th>
   <td><input type="tel" name="m_tel" value=""></td>
</tr>
<tr><th>이메일</th>
   <td><input type="email" name="m_email" value=""></td>
</tr>
<tr><th>시간</th>
   <td>
   
     <table>
   <tr>
      <td width="60px"><input type="radio" name="m_time" value="오전"> 오전</td>
      <td>&nbsp;&nbsp;&nbsp;</td>
      <td width="60px"><input type="radio" name="m_time" value="오후"> 오후</td>
   </tr>
   </table>
  
   
   </td>
</tr>

<tr><th>클래스</th>
   <td>   
   <table>
   <tr>
      <td width="40px"><input type="radio" name="m_class" value="A"> &nbsp;A&nbsp;</td>   
      <td width="40px"><input type="radio" name="m_class" value="B"> &nbsp;B&nbsp;</td>   
      <td width="40px"><input type="radio" name="m_class" value="C"> &nbsp;C&nbsp;</td>   
   </tr>
   <tr>   
      <td width="40px"><input type="radio" name="m_class" value="D" > &nbsp;D&nbsp;</td>   
      <td width="40px"><input type="radio" name="m_class" value="E" > &nbsp;E&nbsp;</td>   
      <td width="40px"><input type="radio" name="m_class" value="F" > &nbsp;F&nbsp;</td>   
   </tr>
   <tr>   
      <td width="40px"><input type="radio" name="m_class" value="G" > &nbsp;G&nbsp;</td>   
      <td width="40px"><input type="radio" name="m_class" value="H" > &nbsp;H&nbsp;</td>   
      <td width="40px"><input type="radio" name="m_class" value="I" > &nbsp;I&nbsp;</td>   
   </tr>
   
   </table>   
   </td>
</tr>
<tr><td><br></td></tr>
<tr><th colspan="2">
   <button type="submit" class="btn btn-success">가입하기</button>&nbsp;
   <button type="reset" class="btn btn-success">취소</button>
   
</th></tr>
</table>
</form>
<br>
<div align="center">
   <a href="../../index.jsp">시작페이지로 이동</a>
</div>
<br>
</section>
<%@ include file="/footer.jsp"%>
<%@ include file="/headend.jsp"%>