<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="community.model.vo.Community, java.util.*"%>
<%
	ArrayList<Community> communityList = (ArrayList<Community>)request.getAttribute("communityList");
	int communityCount = (int)request.getAttribute("communityCount");
	String pageName = "Community";
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
                                <h4 class="title">Community List</h4>
                                <p class="category">Total : <%= communityCount %></p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped" style="text-align: center">
                                    <thead>
                                        <th style="text-align: center">No</th>
                                    	<th style="text-align: center">Category</th>
                                    	<th style="text-align: center">Name</th>
                                    	<th style="text-align: center">Class</th>
                                    	<th style="text-align: center">Time</th>
                                    </thead>
                                    <tbody>
                                   	<% for(Community community : communityList){ %>
                                   		<tr>
                                   			<td>1</td>
                                   			<td><%= community.getCommunityCategory() %></td>
                                   			<td style="text-align: left"><a href="/acanity/admin/community/detail?no=<%= community.getCommunityNo() %>"><%= community.getCommunityName() %></a></td>
                                   			<td><%= community.getCommunityClass() %></td>
                                   			<td><%= community.getCommunityTime() %></td>
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
