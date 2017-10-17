<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="member.model.vo.Member, java.util.*"%>
<%
	ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
	int memberCount = (int)request.getAttribute("memberCount");
	String pageName = "Member";
%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Member List</h4>
                                <p class="category">Total : <%= memberCount %></p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped" style="text-align: center">
                                    <thead>
                                        <th style="text-align: center">No</th>
                                    	<th style="text-align: center">ID</th>
                                    	<th style="text-align: center">Name</th>
                                    	<th style="text-align: center">Class</th>
                                    	<th style="text-align: center">Time</th>
                                    </thead>
                                    <tbody>
                                   	<% for(Member member : memberList){ %>
                                   		<tr>
                                   			<td>1</td>
                                   			<td><a href="/acanity/admin/member/detail?id=<%= member.getmId() %>"><%= member.getmId() %></a></td>
                                   			<td><%= member.getmName() %></td>
                                   			<td><%= member.getmClass() %></td>
                                   			<td><%= member.getmTime() %></td>
                                   		</tr>
                                   	<%} %>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
<%@ include file="footer.jsp" %>
</html>
