<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
</head>

<body>

    <div id="wrapper">
		<jsp:include page="menu/top.jsp"/>
        <!-- Navigation -->
        <div id="page-wrapper">'
                    <h1 class="page-header">Dashboard</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->aaa
            <div class="row">
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-user fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge" id="userCount">${userCount }</div>
                                    <div>Users</div>
                                </div>
                            </div>
                        </div>
                        <a href="admin/user/general">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-green">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-building-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${workspaceCount }</div>
                                    <div>Workspaces</div>
                                </div>
                            </div>
                        </div>
                        <a href="admin/workspace">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-yellow">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-comments-o fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${articleCount }</div>
                                    <div>Articles</div>
                                </div>
                            </div>
                        </div>
                        <a href="admin/board/freeboard">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
                <div class="col-lg-3 col-md-6">
                    <div class="panel panel-red">
                        <div class="panel-heading">
                            <div class="row">
                                <div class="col-xs-3">
                                    <i class="fa fa-info fa-5x"></i>
                                </div>
                                <div class="col-xs-9 text-right">
                                    <div class="huge">${jobCount }</div>
                                    <div>Jobs</div>
                                </div>
                            </div>
                        </div>
                        <a href="admin/board/recruit">
                            <div class="panel-footer">
                                <span class="pull-left">View Details</span>
                                <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                <div class="clearfix"></div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-8">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-bar-chart-o fa-fw"></i> Chart Analysis  
                            <div class="pull-right">
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div id="graph"></div>
<pre id="code" class="prettyprint linenums">
Morris.Bar({
  element: 'graph',
  data: [
    {x: '${m3 }m ${d3 }d', y: ${j3 }, z: ${a3 }, a: ${u3 }},
    {x: '${m2 }m ${d2 }d', y: ${j2 }, z: ${a2 }, a: ${u2 }},
    {x: '${m1 }m ${d1 }d', y: ${j1 }, z: ${a1 }, a: ${u1 }},
    {x: '${m }m ${d }d', y: ${j }, z: ${a }, a: ${u }}
  ],
  xkey: 'x',
  ykeys: ['y', 'z', 'a'],
  labels: ['Job', 'Article', 'User']
}).on('click', function(i, row){
  console.log(i, row);
});
</pre>
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-list-alt fa-fw"></i> Recently Articles
                            <div class="pull-right">
                                <div class="btn-group">
                                <a href="admin/board/freeboard">
                                    <button type="button" class="btn btn-default btn-xs dropdown-toggle">
                                        View all
                                    </button>
                                </a>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>  
                                            	    <th style="text-align: center; width: 17%">Type</th>
                                                    <th style="text-align: center; width: 45%">Title</th>
                                                    <th style="text-align: center; width: 17%">Writer</th>
                                                    <th style="text-align: center; width: 21%">Regdate</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                             <c:forEach items="${articleList}" var="article">
                                              <tr>
													<td style="text-align: center;">
													<c:choose>
														<c:when test="${article.boardId eq 1}">Freeboard</c:when>
														<c:when test="${article.boardId eq 2}">F A Q</c:when>
													</c:choose>
													</td>
													<td><a href="admin/board/detail?articleId=${article.articleId }">${article.title}</a></td>
													<td style="text-align: center;">${article.userId}</td>
													<td style="text-align: center;">${article.regdate}</td>
												</tr>
											</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.col-lg-4 (nested) -->
                            </div>
                            <!-- /.row -->
                        </div>
                        
                        <!-- /.panel-body -->
                    </div>
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-list-alt fa-fw"></i> Recently Jobs
                            <div class="pull-right">
                                <div class="btn-group">
                                <a href="admin/board/recruit">
                                   <button type="button" class="btn btn-default btn-xs dropdown-toggle">
                                        View all
                                    </button>
                                    </a>
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-12">
                                    <div class="table-responsive">
                                        <table class="table table-bordered table-hover table-striped">
                                            <thead>
                                                <tr>
                                                	<th style="text-align: center; width: 17%">Workspace</th>
                                                    <th style="text-align: center; width: 45%">Title</th>
                                                    <th style="text-align: center; width: 17%">Owner</th>
                                                    <th style="text-align: center; width: 21%">Regdate</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                             <c:forEach items="${jobList}" var="job">
                                              <tr>
													<td style="text-align: center;">${job.bizName}</td>
													<td><a href="admin/workspace/detail?bizNum=${job.bizNum }">${job.title}</a></td>
													<td style="text-align: center;">${job.name}</td>
													<td style="text-align: center;">${job.regdate}</td>
												</tr>
											</c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <!-- /.table-responsive -->
                                </div>
                                <!-- /.col-lg-4 (nested) -->
                            </div>
                            <!-- /.row -->
                        </div>
                        
                        <!-- /.panel-body -->
                    </div>
                    
                    <!-- /.panel -->
                    
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-8 -->
               
                <div class="col-lg-4">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <i class="fa fa-warning fa-fw"></i> Notifications Panel                            
                            <div class="pull-right">
                                <div class="btn-group">
                                </div>
                            </div>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <div class="list-group" id="messageList">
                            <c:forEach items="${messageList }" var="message">
                                <a id="message2" class="list-group-item" onclick="check( ${message.messageId })" style="display: table-layout; vertical-align: middle;">
                                    <i class="fa fa-comment fa-fw" style="vertical-align: middle; margin-bottom: 1em"></i>  
                                    <span style="white-space: nowrap; width: 15em; overflow: hidden; text-overflow: ellipsis; display: inline-block;">${message.content }</span>
                                    <span class="pull-right text-muted small"><em>${message.sendDate }</em></span>
                                </a>
                            </c:forEach>
                            </div>
                        </div>
                        
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                    <!-- /.panel -->
                    <!-- /.panel .chat-panel -->
                </div>
                <!-- /.col-lg-4 -->
            </div>
            <!-- /.row -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="/resources/dist/js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/resources/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="/resources/dist/js/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="/resources/dist/js/raphael-min.js"></script>
    <script src="/resources/dist/js/morris.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="/resources/dist/js/jquery.dataTables.js"></script>
	<script src="/resources/dist/js/dataTables.bootstrap.js"></script>
	
    <!-- Custom Theme JavaScript -->
    <script src="/resources/dist/js/sb-admin-2.js"></script>
    <script src="/resources/dist/js/chart.js"></script>
    <script src="http://cdnjs.cloudflare.com/ajax/libs/prettify/r224/prettify.min.js"></script>

	<script>
	
	setInterval(function(){
	        $.ajax({
	            url : "admin/messagerefresh",
	            type: "get",
	            dataType: "json",
	            success : function(data){
					var output = "";
					$.each(data, function(index, item){
						output += "<a id='message2' class='list-group-item' onclick='check(" + item.messageId + ")'>";
					    output += "<i class='fa fa-comment fa-fw' style='vertical-align: middle; margin-bottom: 1em'></i> ";
					    output += "<span style='white-space: nowrap; width: 15em; overflow: hidden; text-overflow: ellipsis; display: inline-block;'>" +item.content + "</span>";
					    output += "<span class='pull-right text-muted small'><em>" + item.sendDate + "</em></span>";
					});
					$("#messageList").html(output);
	            }
	        });
	    },10000);
	</script>
	<script>
    function check(id){
	        $.ajax({
	            url : "admin/checkmessage?id="+id,
	            type: "get",
	            dataType: "json",
	            success : function(data){
					var output = "";
					$.each(data, function(index, item){
						output += "<a id='message2' class='list-group-item' onclick='check(" + item.messageId + ")'>";
					    output += "<i class='fa fa-comment fa-fw' style='vertical-align: middle; margin-bottom: 1em'></i> ";
					    output += "<span style='white-space: nowrap; width: 15em; overflow: hidden; text-overflow: ellipsis; display: inline-block;'>" +item.content + "</span>";
					    output += "<span class='pull-right text-muted small'><em>" + item.sendDate + "</em></span>";
					});
					$("#messageList").html(output);
					}
	        });
	        
	        var windowWidth = 600;
			var windowHeight = 580;
			var x = (screen.width - windowWidth) / 2;
			var y = (screen.height - windowHeight*1.5) / 2;
			messageDetail = open("admin/message?id="+id, "messageDetail", "left="+x+", top="+y+", width="+windowWidth+", height="+windowHeight);
	    }
	</script>
	<script>

        $.ajax({
            url : "admin/userCount",
            type: "get",
            dataType: "text",
            success : function(data){
            	var count = "";
					count += "<div class='huge' id='userCount'>" + data + "</div>"; 
				$("#userCount").html(count);
				}
        });
	
	</script>
</body>

</html>
