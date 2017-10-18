<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
    import="member.model.vo.Member, java.util.*, community.model.vo.Community"%>
<!doctype html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="/acanity/image/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="/acanity/image/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Admin Main Page</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />

    <!-- Bootstrap core CSS     -->
    <link href="/acanity/css/admin/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="/acanity/css/admin/animate.min.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="/acanity/css/admin/paper-dashboard.css" rel="stylesheet"/>

    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="/acanity/css/admin/demo.css" rel="stylesheet" />

    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href="/acanity/css/admin/themify-icons.css" rel="stylesheet">
    <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body>
<div class="wrapper">
    <div class="sidebar" data-background-color="white" data-active-color="danger">

    <!--
		Tip 1: you can change the color of the sidebar's background using: data-background-color="white | black"
		Tip 2: you can change the color of the active button using the data-active-color="primary | info | success | warning | danger"
	-->

    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    Acanity
                </a>
            </div>

            <ul class="nav">
            <% if(pageName ==  "Admin Main") {%>
                <li class="active">
             <%} else{ %>
            	 <li>
             <% } %>
                    <a href="/acanity/admin/index">
                        <i class="ti-panel"></i>
                        <p>Dashboard</p>
                    </a>
                </li>
            <% if(pageName == "Member" || pageName == "Member Profile") {%>
                <li class="active">
             <%} else{ %>
            	 <li>
             <% } %>
                    <a href="/acanity/admin/member">
                        <i class="ti-user"></i>
                        <p>Member</p>
                    </a>
                </li>
            <% if(pageName == "Community" || pageName == "Community Detail") {%>
                <li class="active">
             <%} else{ %>
            	 <li>
             <% } %>
                    <a href="/acanity/admin/community">
                        <i class="fa fa-users" aria-hidden="true"></i>
                        <p>Community</p>
                    </a>
                </li>
            <% if(pageName == "Q & A" || pageName == "Q & A Detail") {%>
                <li class="active">
             <%} else{ %>
            	 <li>
             <% } %>
                    <a href="/acanity/admin/qna">
                        <i class="fa fa-question" aria-hidden="true"></i>
                        <p>Q & A</p>
                    </a>
                </li>
                <li>
                    <a href="icons.html">
                        <i class="ti-pencil-alt2"></i>
                        <p>Icons</p>
                    </a>
                </li>
                <li>
                    <a href="maps.html">
                        <i class="ti-map"></i>
                        <p>Maps</p>
                    </a>
                </li>
                <li>
                    <a href="notifications.html">
                        <i class="ti-bell"></i>
                        <p>Notifications</p>
                    </a>
                </li>
            </ul>
    	</div>
    </div>

    <div class="main-panel">
        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand"><%= pageName %></a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        <li>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <i class="ti-panel"></i>
								<p>Stats</p>
                            </a>
                        </li>
                        <li class="dropdown">
                              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <i class="ti-bell"></i>
                                    <p class="notification">5</p>
									<p>Notifications</p>
									<b class="caret"></b>
                              </a>
                              <ul class="dropdown-menu">
                                <li><a href="#">Notification 1</a></li>
                                <li><a href="#">Notification 2</a></li>
                                <li><a href="#">Notification 3</a></li>
                                <li><a href="#">Notification 4</a></li>
                                <li><a href="#">Another notification</a></li>
                              </ul>
                        </li>
						<li>
                            <a href="#">
								<i class="ti-settings"></i>
								<p>Settings</p>
                            </a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
</body>
</html>