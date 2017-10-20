<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="community.model.vo.Community, java.util.ArrayList, java.sql.Date" %>
<%
	ArrayList<Community> list = (ArrayList<Community>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Company NAME</title>
    
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,600&amp;subset=latin-ext" rel="stylesheet">
    <link href="../../css/community/bootstrap.min.css" rel="stylesheet">
    <link href="../../css/community/font-awesome.min.css" rel="stylesheet">
    <link href="../../css/community/style.css" rel="stylesheet">
</head>
<body> <br><br>
    <main class="site-main category-main">
        <div class="container">
            <div class="row">
                <section class="category-content col-sm-9">
                    <h2 class="category-title">CATEGORY NAME</h2>
                    <ul class="media-list">
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h1.jpeg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                            <% for(Community c : list) { %>
                                <h3 class="media-heading"><%= c.getCommunityName() %></h3>
                            <% } %>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 0 Comment</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h2.jpg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 1 Comment</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h3.jpeg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 2 Comments</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h4.jpeg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 2 Comments</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h1.jpeg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 12 Comments</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h2.jpg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 2 Comments</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h3.jpeg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 3 Comments</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>
                        <li class="media">
                            <div class="media-left">
                                <a href="#" title="Post">
                                    <img class="media-object" src="../../img/community/h4.jpeg" alt="Post">
                                </a>
                            </div>
                            <div class="media-body">
                                <h3 class="media-heading"><a href="#" title="Post Title">Post Title</a></h3>
                                <p>Aenean vitae dolor sed purus tempus ullamcorper. Integer urna orci, lacinia ut ornare sit amet, luctus quis est. Ut interdum lorem in mattis lobortis. Maecenas tincidunt justo a lobortis facilisis.</p>
                                <aside class="meta category-meta">
                                    <div class="pull-left">
                                        <div class="arc-comment"><a href="#" title="Comment"><i class="fa fa-comments"></i> 8 Comments</a></div>
                                        <div class="arc-date">10/15/2016</div>
                                    </div>
                                </aside>                                
                            </div>
                        </li>                        
                    </ul>                    
                </section>
            </div>
        </div>
    </main>
    <script src="../../js/community/jquery-3.2.1.min.js"></script>
    <script src="../../js/community/bootstrap.min.js"></script>
</body>
</html>