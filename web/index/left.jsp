<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.text.DecimalFormat"%>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>瓷砖交易管理系统</title>
    <link rel="stylesheet" href="resources/css/reset.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="resources/css/style.css" type="text/css"
          media="screen" />
    <link rel="stylesheet" href="resources/css/invalid.css" type="text/css"
          media="screen" />

    <!--                       Javascripts                       -->
    <!-- jQuery -->
    <script type="text/javascript"
            src="resources/scripts/jquery-1.3.2.min.js"></script>

    <!-- jQuery Configuration -->
    <script type="text/javascript"
            src="resources/scripts/simpla.jquery.configuration.js"></script>
    <!-- Facebox jQuery Plugin -->
    <script type="text/javascript" src="resources/scripts/facebox.js"></script>

    <!-- jQuery WYSIWYG Plugin -->
    <script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>

    <!-- jQuery Datepicker Plugin -->
    <script type="text/javascript"
            src="resources/scripts/jquery.datePicker.js"></script>
    <script type="text/javascript" src="resources/scripts/jquery.date.js"></script>
    <script type="text/javascript">
        $(function() {
            var a = $("#main-nav a");
            var menu = $("#main-nav li ul a");
            menu.click(function() {
                for (var j = 0; j < a.size(); j++) {
                    a.eq(j).removeClass("current");
                }
                $(this).parent().parent().parent().find('a').addClass("current");

                for (var i = 0; i < menu.size(); i++) {
                    menu.eq(i).removeClass("current");
                }
                $(this).addClass("current");
            });
        })
    </script>
</head>
<body class="left">

<div id="body-wrapper">
    <div id="sidebar"
         style="background: url('../images/bg-sidebar.gif') top left no-repeat;">
        <div id="sidebar-wrapper">
            <h1 id="sidebar-title">
                <a href="" target="dmMain">瓷砖交易管理系统</a>
            </h1>
            <div id="profile-links">
                <p>
                    <a>欢迎您<br></a> <a href="" title="个人信息" target="dmMain">个人信息
                </a>| <a href="/logout.action" title="退出系统" target="_top">退出</a>
                </p>
            </div>

            <ul id="main-nav">
                <!-- Accordion Menu -->
                <!-- Add the class "no-submenu" to menu items with no sub menu -->
                <!---Add the class "current" to open the submenu when page show-->
                <li><a href="#" class="nav-top-item current">
                    瓷砖品牌管理
                </a>
                    <ul>
                        <li><a href="/brand/selectBrand.action" target="dmMain">品牌查询</a></li>
                        <li><a href="/brand/requestAddBrand.action" target="dmMain">新增品牌</a></li>
                    </ul>
                </li>

                <li><a href="#" class="nav-top-item">
                    订单管理
                </a>

                    <ul>
                        <li><a href="" target="dmMain">品牌查询</a></li>
                        <li><a href="" target="dmMain">新增品牌</a></li>
                    </ul>
                </li>

                <li><a href="#" class="nav-top-item">
                    库存管理
                </a>

                    <ul>
                        <li><a href="" target="dmMain">品牌查询</a></li>
                        <li><a href="" target="dmMain">新增品牌</a></li>
                    </ul>
                </li>

                <li><a href="#" class="nav-top-item">
                    财务管理
                </a>
                    <ul>
                        <li><a href="" target="dmMain">品牌查询</a></li>
                        <li><a href="" target="dmMain">新增品牌</a></li>
                    </ul>
                </li>

                <li><a href="#" class="nav-top-item">
                    客户信息管理
                </a>
                    <ul>
                        <li><a href="/client/addClient" target="dmMain">新增客户</a></li>
                        <li><a href="/client/selectClient.action" target="dmMain">客户信息列表</a></li>
                    </ul>
                </li>

                <li><a href="#" class="nav-top-item">
                    人力资源管理
                </a>

                    <ul>
                        <li><a href="/clerk/clerk_select.action" target="dmMain">业务员查询</a></li>
                        <li><a href="/clerk/addClerk.jsp" target="dmMain">新增业务员</a></li>
                        <li><a href="/clerkBrand/formAction.action" target="dmMain">新增业务</a></li>
                        <li><a href="/clerkBrand/selectAction.action" target="dmMain">业务查询</a></li>
                    </ul>
                </li>

            </ul>
            <!-- End #main-nav -->
        </div>
    </div>
    <!-- End #sidebar -->
</div>
</body>
</html>
