<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="java.util.*, post.model.vo.Post"%>
<%
	ArrayList<Post> qnaList = (ArrayList<Post>)request.getAttribute("qnaList");
	int no = 0;
	String pageName = "Q & A Detail";
%>
<!doctype html>
<html lang="ko">
<%@ include file="header.jsp" %>
        <div class="content">
            <div class="container-fluid">
                <div class="row">
                	<div class="col-lg-1 col-md-1">
                	</div>
                    <div class="col-lg-10 col-md-10">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Detail</h4>
                            </div>
                            <div class="content">
                                <form>
                                <% for(Post qna : qnaList) { %>
                                <% if(qna.getDepth() == 1) {
                                	no = qna.getpNo();
                               	%>
                                
                                    <div class="row">
                                        <div class="col-md-8">
                                            <div class="form-group">
                                                <label>Title</label>
                                                <input type="text" class="form-control border-input" value="<%= qna.getpTitle() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Writer</label>
                                                <input type="text" class="form-control border-input" value="<%= qna.getpId() %>">
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Attached File</label>
                                                <input type="text" class="form-control border-input" value="<%= qna.getOriginalFileName() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-4">
                                            <div class="form-group">
                                                <label>Written Date</label>
                                                <input type="text" class="form-control border-input" value="<%= qna.getpDate() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Hit</label>
                                                <input type="text" class="form-control border-input" value="<%= qna.getReadCount() %>">
                                            </div>
                                        </div>
                                        <div class="col-md-2">
                                            <div class="form-group">
                                                <label>Open</label>
                                                <% if(qna.getpOpen() == 0){ %>
                                                <input type="text" class="form-control border-input" value="Private">
                                                <% } else{ %>
                                                <input type="text" class="form-control border-input" value="Open">
                                                <% } %>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                                <label>Content</label>
                                                <textarea rows="5" class="form-control border-input" placeholder="Here can be your description"><%= qna.getpContent() %></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <% } else {%>
                                    <div class="row">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                            <label>
                                            	<% for(int i = 1; qna.getDepth() > i; i++){ %>
                                            	<i class="fa fa-share" aria-hidden="true"></i> &nbsp;
                                            	<% } %>
                                            : &nbsp; <%= qna.getpTitle() %></label>
                                                <textarea rows="5" class="form-control border-input" placeholder="Here can be your description"><%= qna.getpContent() %></textarea>
                                            </div>
                                        </div>
                                    </div>
                                    <% } %>
                                  <% } %>
                                    <div class="row" id="reply" style="display: none;">
                                        <div class="col-md-12">
                                            <div class="form-group">
                                            	<label>Reply</label>
                                            	<textarea id="content" rows="5" class="form-control border-input" placeholder="Here can be your description"></textarea>
                                            </div>
                                        </div>
                                    </div>
                                       <div class="row">
                                        <div class="col-md-12">
                                      <div class="text-center">
                                      <input id="btn" type="button" class="btn btn-info btn-fill btn-wd" value="Reply" onclick="reply()">
                                    </div>
                                            </div>
                                        </div>
                                    </div>
                            </div>
                        </div>
                    </div>
                	<div class="col-lg-1 col-md-1">
                	</div>
                </div>
<script type="text/javascript">
function reply(){
	if($("#reply").attr("style") == "display: block"){
		
	}else {
		$("#reply").attr("style", "display: block");
		$("#btn").attr("value", "Add");
		$("#btn").attr("onclick", "replyAction()");
	}
}

function replyAction(){
	var content = $("#content").val();
	location.href = "/acanity/admin/qna/insert?no=" + <%= no %> + "&content=" + content;
}
</script>
<%@ include file="footer.jsp" %>
</html>
