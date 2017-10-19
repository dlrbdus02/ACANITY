<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.*, community.model.vo.*, History.model.vo.History, member.model.vo.Member "%>
<%
	Community community = (Community)request.getAttribute("community");
	ArrayList<History> meetingList = (ArrayList<History>)request.getAttribute("meetingList");
	int memberCount = (int)request.getAttribute("memberCount");
	int meetingCount = (int)request.getAttribute("meetingCount");
	ArrayList<Member> memberList = (ArrayList<Member>)request.getAttribute("memberList");
	ArrayList<Vote> voteList = (ArrayList<Vote>)request.getAttribute("voteList");
	System.out.println(memberList);
	String pageName = "Community Detail";
%>
<!doctype html>
<html lang="ko">
<%@ include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image">
                                <img src="/acanity/image/background.jpg" alt="..."/>
                            </div>
                            <div class="content">
                            </div>
                            <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-3 col-md-offset-1">
                                        <h5><%= memberCount %><br /><small>Member</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5>0<br /><small>Post</small></h5>
                                    </div>
                                    <div class="col-md-3">
                                        <h5><%= meetingCount %><br /><small>Meeting</small></h5>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    </div>
                    <div class="col-lg-8 col-md-7">
                        <div class="card">
                            <div class="header">
                                <h4 class="title"><%= community.getCommunityName() %> Profile</h4>
                            </div>
                            <div class="content">
                                <form>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Category</label>
                                                <input type="text" class="form-control border-input" disabled value="<%= community.getCommunityCategory() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Class</label>
                                                <input type="text" class="form-control border-input" value="<%= community.getCommunityClass() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Time</label>
                                                <input type="text" class="form-control border-input" value="<%= community.getCommunityTime() %>">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Group head</label>
                                                <input type="text" class="form-control border-input" value="<%= community.getCommunityId() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Wanted status</label>
                                                <% if(community.getCommunityStartDate() != null){ %>
                                                <input type="text" class="form-control border-input" value="모집중">
                                                <% }else{ %>
                                                <input type="text" class="form-control border-input" value="모집 X">
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Content</label>
                                                <textarea rows="5" class="form-control border-input" placeholder="Here can be your description"><%= community.getCommunityContent() %></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <% if(!meetingList.isEmpty()){ %>
                                                                        <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group" style="margin-bottom: 0">
                                                <label>Meeting List</label>
                                               	<div class="col-md-12">
                        <div class="card card-plain" style="margin-bottom: 0">
                            <div class="content table-responsive table-full-width" style="padding-top: 0; padding-bottom: 0">
                                <table class="table table-hover" style="margin-bottom: 0">
                                    <thead>
                                        <th>No</th>
                                    	<th>Date</th>
                                    	<th>Time</th>
                                    	<th>Place</th>
                                    </thead>
                                     <tbody>
                                     <% for(History meeting : meetingList){ %>
                                    	<tr style="background-color: #fffcf5">
                                    		<td>1</td>
                                    		<td><%= meeting.getChDate() %></td>
                                    		<td><%= meeting.getChTime() %></td>
                                    		<td><%= meeting.getChPlace() %></td>
                                    	</tr>
                                    <% } %>
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                                            </div>
                                        </div>
                                    </div>
                                    <% } %>
                                </form>
                            </div>
                        </div>
                    </div>


                </div>
                
                <div class="row">
                <div class="col-md-3">
                <div class="card">
                            <div class="header">
                                <h4 class="title">Member List</h4>
                            </div>
                            <div class="content">
                                <ul class="list-unstyled team-members">
                                	<% for(Member member : memberList){ %>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                    	<%= member.getmId() %>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        <%= member.getmEmail() 	%> 가입
                                                    </div>
                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><a href="/acanity/admin/member/detail?id=<%= member.getmId() %>"><i class="fa fa-envelope"></i></a></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <% } %>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        Creative Tim
                                                        <br />
                                                        <span class="text-success"><small>Available</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-3">
                                                        <div class="avatar">
                                                        </div>
                                                    </div>
                                                    <div class="col-xs-6">
                                                        Flume
                                                        <br />
                                                        <span class="text-danger"><small>Busy</small></span>
                                                    </div>

                                                    <div class="col-xs-3 text-right">
                                                        <btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                        </ul>
                            </div>
                            </div>
                        </div>
<div class="col-md-5">
                <div class="card">
                            <div class="header">
                                <h4 class="title">Vote List</h4>
                            </div>
                            <div class="content">
                                <ul class="list-unstyled team-members">
                                <% for(Vote vote : voteList) { %>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-4" style="padding-top: 8px;">
                                                    	<%= vote.getVoteTitle() %>
                                                    </div>
                                                    <div class="col-xs-5" style="padding-top: 8px;">
                                                    	<%= vote.getVoteStartDate() %> ~ <%= vote.getVoteEndDate() %>
                                                    </div>
                                                    <div class="col-xs-1" style="padding-top: 8px; padding-right: 0px">
                                                    	<%= vote.getVoteResultNo() %>명
                                                    </div>
                                                    <div class="col-xs-2 text-right">
                                                    	<btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-4" style="padding-top: 8px;">
                                                    	<%= vote.getVoteTitle() %>
                                                    </div>
                                                    <div class="col-xs-5" style="padding-top: 8px;">
                                                    	<%= vote.getVoteStartDate() %> ~ <%= vote.getVoteEndDate() %>
                                                    </div>
                                                    <div class="col-xs-1" style="padding-top: 8px; padding-right: 0px">
                                                    	<%= vote.getVoteResultNo() %>명
                                                    </div>
                                                    <div class="col-xs-2 text-right">
                                                    	<btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                            <li>
                                                <div class="row">
                                                    <div class="col-xs-4" style="padding-top: 8px;">
                                                    	<%= vote.getVoteTitle() %>
                                                    </div>
                                                    <div class="col-xs-5" style="padding-top: 8px;">
                                                    	<%= vote.getVoteStartDate() %> ~ <%= vote.getVoteEndDate() %>
                                                    </div>
                                                    <div class="col-xs-1" style="padding-top: 8px; padding-right: 0px">
                                                    	<%= vote.getVoteResultNo() %>명
                                                    </div>
                                                    <div class="col-xs-2 text-right">
                                                    	<btn class="btn btn-sm btn-success btn-icon"><i class="fa fa-envelope"></i></btn>
                                                    </div>
                                                </div>
                                            </li>
                                 <% } %>
                                        </ul>
                            </div>
                            </div>
                        </div>
                        </div>
                        
                        
            </div>
        </div>
<%@ include file="footer.jsp" %>

</html>
