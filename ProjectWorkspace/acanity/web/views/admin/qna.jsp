<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="post.model.vo.Post, java.util.*"%>
<%
	ArrayList<Post> qnaList = (ArrayList<Post>)request.getAttribute("qnaList");
	int qnaCount = (int)request.getAttribute("qnaCount");
	String pageName = "Q & A";
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
                                <h4 class="title">Q & A List</h4>
                                <p class="category">Total : <%= qnaCount %></p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped" style="text-align: center">
                                    <thead>
                                        <th style="text-align: center">No</th>
                                    	<th style="text-align: center">Title</th>
                                    	<th style="text-align: center">Writer</th>
                                    	<th style="text-align: center">Reply</th>
                                    	<th style="text-align: center">Hit</th>
                                    	<th style="text-align: center">Date</th>
                                    </thead>
                                    <tbody>
                                    <% for(Post qna : qnaList){ %>
                                   		<tr>
                                   			<td>1</td>
                                   			<td style="text-align: left"><a href="/acanity/admin/qna/detail?no=<%= qna.getpNo() %>"><%= qna.getpTitle() %></a></td>
                                   			<td><%= qna.getpId() %></td>
											<% if(qna.getOriginalFileName().equals("Y")) {%>
												<td><i class="fa fa-check" aria-hidden="true"></i></td>
                                   			<% } else { %>
												<td><i class="fa fa-times" aria-hidden="true"></i></td>                                   			
                                   			<% } %>
                                   			<td><%= qna.getReadCount() %></td>
                                   			<td><%= qna.getpDate() %></td>
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