<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="member.model.vo.Member, java.util.*, community.model.vo.Community"%>
<%
	String pageName = "Admin Main";
	int memberCount = (int)request.getAttribute("memberCount");
	int postCount = (int)request.getAttribute("postCount");
	int communityCount = (int)request.getAttribute("communityCount");
	int meetingCount = (int)request.getAttribute("meetingCount");
	
	ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
	ArrayList<Community> communityList = (ArrayList<Community>)request.getAttribute("communityList");
%>

<!doctype html>
<html lang="ko">
<%@ include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-warning text-center">
                                            <i class="ti-user"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Member</p>
                                            <%= memberCount %>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-success text-center">
                                            <i class="fa fa-users" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Community</p>
                                            <%= communityCount %>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-danger text-center">
                                            <i class="ti-clipboard"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Post</p>
                                            <%= postCount %>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card">
                            <div class="content">
                                <div class="row">
                                    <div class="col-xs-5">
                                        <div class="icon-big icon-info text-center">
                                            <i class="ti-map-alt"></i>
                                        </div>
                                    </div>
                                    <div class="col-xs-7">
                                        <div class="numbers">
                                            <p>Meeting</p>
                                            <%= meetingCount %>
                                        </div>
                                    </div>
                                </div>
                                <div class="footer">
                                    <hr />
                                    <div class="stats">
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">

                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Visitor Count</h4>
                                <p class="category">Once in a day</p>
                            </div>
                            <div class="content">
                            <%@ include file="visitorChart.jsp" %>
                            </div>
                        </div>
                    </div>
                	<div class="col-md-4">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Report</h4>
                                <p class="category">Last Campaign Performance</p>
                            </div>
                            <div class="content">
                                <div id="chartPreferences" class="ct-chart ct-perfect-fourth"></div>

                                <div class="footer">
                                    <div class="chart-legend">
                                        <i class="fa fa-circle text-info"></i> Open
                                        <i class="fa fa-circle text-danger"></i> Bounce
                                        <i class="fa fa-circle text-warning"></i> Unsubscribe
                                    </div>
                                    <hr>
                                    <div class="stats">
                                        <i class="ti-timer"></i> Campaign sent 2 days ago
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">TOP member of previous month</h4>
                                <p class="category">Highest attendance</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-striped" style="text-align: center">
                                    <thead>
                                        <th style="text-align: center"><font color="#68B3C8">ID</font></th>
                                    	<th style="text-align: center"><font color="#68B3C8">Name</font></th>
                                    	<th style="text-align: center"><font color="#68B3C8">Class</font></th>
                                    	<th style="text-align: center"><font color="#68B3C8">Time</font></th>
                                    	<th style="text-align: center"><font color="#68B3C8">AttendCount</font></th>
                                    </thead>
                                    <tbody>
                                    <% for(Member member : memberList){ %>
                                   		<tr>
                                   			<td><%= member.getmId() %></td>
                                   			<td><%= member.getmName() %></td>
                                   			<td><%= member.getmClass() %></td>
                                   			<td><%= member.getmTime() %></td>
                                   			<td><%= member.getmEmail() %></td>
                                   		</tr>
                                   	<% } %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6">
                                                <div class="card">
                            <div class="header">
                                <h4 class="title">Today Recruit Member</h4>
                            </div>
                            <div class="content">
                                <ul class="list-unstyled team-members">
                                <% for(Community community : communityList){ %>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-2" style="padding-left: 30px">
                                                        <div class="avatar">
                                                        	<!-- 이미지 삽입 -->
                                                            <img src="어쩌고저쩌고 <%= community.getCommunityImgUrl()  %>" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-8">
														<%= community.getCommunityName() %>
                                                        <br />
                                                        <p class="category"><%= community.getCommunityClass() %>class <%= community.getCommunityTime() %> / <%= community.getCommunityCategory() %> / <%= community.getCommunityLimit() %>명 / ~ <%= community.getCommunityEndDate() %></p>
                                                    </div>

                                                    <div class="col-xs-2 text-right" style="padding-right: 30px">
                                                        <btn class="btn btn-sm btn-success btn-icon"><a href="/acanity/admin/community/detail?no=<%= community.getCommunityNo() %>"><i class="ti-search"></i></a></btn>
                                                    </div>
                                                </div>
                                            </li>
                                <% } %>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-2" style="padding-left: 30px">
                                                        <div class="avatar">
                                                            <img src="/acanity/image/faces/face-0.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
														어쩌고 저쩌고 모집합니당
                                                        <br />
                                                        <p class="category">Category : StartDate ~ EndDate</p>
                                                        <!-- <span class="text-muted"><small></small></span> -->
                                                    </div>

                                                    <div class="col-xs-4 text-right" style="padding-right: 30px">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa ti-search"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                                                                        <li>
                                                <div class="row">
                                                    <div class="col-xs-2" style="padding-left: 30px">
                                                        <div class="avatar">
                                                            <img src="/acanity/image/faces/face-0.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
														어쩌고 저쩌고 모집합니당
                                                        <br />
                                                        <p class="category">Category : StartDate ~ EndDate</p>
                                                        <!-- <span class="text-muted"><small></small></span> -->
                                                    </div>

                                                    <div class="col-xs-4 text-right" style="padding-right: 30px">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                                                                        <li>
                                                <div class="row">
                                                    <div class="col-xs-2" style="padding-left: 30px">
                                                        <div class="avatar">
                                                            <img src="/acanity/image/faces/face-0.jpg" alt="Circle Image" class="img-circle img-no-padding img-responsive">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
														어쩌고 저쩌고 모집합니당
                                                        <br />
                                                        <p class="category">Category : StartDate ~ EndDate</p>
                                                        <!-- <span class="text-muted"><small></small></span> -->
                                                    </div>

                                                    <div class="col-xs-4 text-right" style="padding-right: 30px">
                                                        <btn class="btn btn-sm btn-success btn-icon"><a><i class="fa fa-envelope"></i></a></btn>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <%@ include file="footer.jsp" %>
</html>
