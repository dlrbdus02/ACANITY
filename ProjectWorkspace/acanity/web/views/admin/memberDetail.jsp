<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="member.model.vo.Member, java.util.*, community.model.vo.Community"%>
<%
	Member member = (Member)request.getAttribute("member");
	ArrayList<Community> communityList = (ArrayList<Community>)request.getAttribute("communityList");
	System.out.println("케로로 : " + communityList);
	int keyGroupRate = (int)request.getAttribute("keyGroupRate");
	String className = null;
	if(keyGroupRate >= 80)
		className = "success";
	else if(keyGroupRate >= 60)
		className = "warning";
	else
		className = "danger";
	String pageName = "Member Profile";
%>
<!doctype html>
<html lang="ko">
<head>
<%@ include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                <% if(!communityList.isEmpty() && keyGroupRate != 0){  %>
                    <div class="col-lg-8 col-md-8">
                    <% } else {%>
                    <div class="col-lg-1 col-md-1"></div>
                    <div class="col-lg-10 col-md-10">
                    <div class="col-lg-1 col-md-1"></div>
                    <% } %>
                        <div class="card">
                            <div class="header">
                                <h4 class="title"><%= member.getmName() %> Profile</h4>
                            </div>
                            <div class="content">
                                <form>
                                    <div class="row">
                                        <div class="col-md-5">
                                            <div class="form-group">
                                                <label>ID</label>
                                                <input type="text" class="form-control border-input" placeholder="Id" value="<%= member.getmId() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Class</label>
                                                <input type="text" class="form-control border-input" placeholder="Class" value="<%= member.getmClass().trim() %> Class">
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <div class="form-group">
                                                <label for="exampleInputEmail1">Time</label>
                                                <input type="text" class="form-control border-input" placeholder="Time" value="<%= member.getmTime() %>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Email</label>
                                                <input type="email" class="form-control border-input" placeholder="Email" value="<%= member.getmEmail() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                            <div class="form-group">
                                                <label>Phone</label>
                                                <input type="tel" class="form-control border-input" placeholder="phone" value="<%= member.getmTel() %>">
                                            </div>
                                        </div>
                                    </div>

                                    <!-- <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Address</label>
                                                <input type="text" class="form-control border-input" placeholder="Home Address" value="Melbourne, Australia">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>City</label>
                                                <input type="text" class="form-control border-input" placeholder="City" value="Melbourne">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Country</label>
                                                <input type="text" class="form-control border-input" placeholder="Country" value="Australia">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Postal Code</label>
                                                <input type="number" class="form-control border-input" placeholder="ZIP Code">
                                            </div>
                                        </div>
                                    </div> -->
							<% if(!communityList.isEmpty()){ %>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group" style="margin-bottom: 0">
                                                <label>Community List</label>
                                               	<div class="col-md-12">
                        <div class="card card-plain" style="margin-bottom: 0">
                            <div class="content table-responsive table-full-width" style="padding-top: 0; padding-bottom: 0">
                                <table class="table table-hover" style="margin-bottom: 0">
                                    <thead>
                                        <th>No</th>
                                    	<th>Category</th>
                                    	<th>Name</th>
                                    	<th>Join Date</th>
                                    	<th>Group head</th>
                                    </thead>
                                     <tbody>
                                    <%for (Community community : communityList) {%> <!-- 그룹 가입한게 없으면 오류나나 확인해보자! -->
                                    	<tr style="background-color: #fffcf5">
                                    		<td>1</td>
                                    		<td><%= community.getCommunityCategory() %></td>
                                    		<td><a><%= community.getCommunityName() %></a></td>
                                    		<td><%= community.getCommunityStartDate() %></td>
                                    		<td><%= community.getCommunityId() %></td>
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
                                    <% } %>
                                    <hr style="margin-bottom: 0">
                               <div class="text-center">
                                <div class="row">
                                    <div class="col-md-4">
                                        <h5><%= request.getAttribute("postCount") %><br /><small>Post</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5><%= request.getAttribute("groupCount") %><br /><small>Community</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5><%= request.getAttribute("meetingCount") %><br /><small>Meeting</small></h5>
                                    </div>
                                </div>
                            </div>
                                    <hr style="margin-top: 0">
                                    <div class="text-center">
                                    	<button type="submit" class="btn btn-info btn-fill btn-wd">Reset Password</button> <!-- 아직 구현 안함 -->
                                    	&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
                                        <button type="submit" class="btn btn-info btn-fill btn-wd">Delete User</button> <!-- 아직 구현 안함 -->
                                    </div>
                                    <div class="clearfix"></div>
                                </form>
                            </div>
                        </div>
                    </div>
                    <% if(keyGroupRate != 0) {%>
                    <div class="col-lg-4 col-md-5">
                        <div class="card card-user">
                            <div class="image" style="overflow: hidden;">
                                <img src="/acanity/image/background.jpg" alt="..." style="overflow: hidden;"/>
                            </div>
                            <div class="content">
                                <div class="author">
                                  <img class="avatar border-white" src="/acanity/image/faces/face-2.jpg" alt="..." style="width: 150px; height: 150px"/> <!-- 그룹 이미지 -->
                                  <h4 class="title">그룹명<br />
                                     <small style="font-size: 20px">Attendance rate</small>
                                  </h4>
                                </div>
                                <br>
									<div class="progress">
									  <div class="progress-bar progress-bar-<%= className %> progress-bar-striped" role="progressbar"
									  aria-valuenow="<%= keyGroupRate %>" aria-valuemin="0" aria-valuemax="100" style="width: <%= keyGroupRate %>%">
									    <%= keyGroupRate %>% Complete
									  </div>
									</div>
                            </div>
<!--                             <hr>
                            <div class="text-center">
                                <div class="row">
                                    <div class="col-md-3 col-md-offset-1">
                                        <h5>12<br /><small>Files</small></h5>
                                    </div>
                                    <div class="col-md-4">
                                        <h5>2GB<br /><small>Used</small></h5>
                                    </div>
                                    <div class="col-md-3">
                                        <h5>24,6$<br /><small>Spent</small></h5>
                                    </div>
                                </div>
                            </div> -->
                        </div>
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Meeting Rate</h4>
                            </div>
                            <div class="content">
                            <%@ include file="meetingRateChart.jsp" %>
                            <br><br>
                            </div>
                        </div>
                    </div>
                    <% } %>

                </div>
            </div>
        </div>
<%@ include file="footer.jsp" %>
</html>