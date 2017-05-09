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
					<li><a href="#" class="nav-top-item current"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							基金产品管理
					</a>
						<ul>
							<li><a href="/test/test.action" target="dmMain">基金产品查询</a></li>
							<li><a href="/test/test.action" target="dmMain">新增基金产品</a></li>
						</ul></li>
					<li><a href="#" class="nav-top-item"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							客户信息管理
					</a>
						<ul>
							<li><a href="/test/test.action" target="dmMain">新客户开户</a></li>
							<li><a href="/test/test.action" target="dmMain">客户信息列表</a></li>
						</ul></li>

					<li><a href="#" class="nav-top-item"> <!-- Add the class "no-submenu" to menu items with no sub menu -->
							资金帐户管理
					</a>
						<ul>
							<li><a href="" target="dmMain">新增资金帐户</a></li>
							<li><a href="" target="dmMain">资金帐户查询</a></li>
							<li><a href="" target="dmMain">追加帐户资金</a></li>
							<li><a href="" target="dmMain">取出帐户资金</a></li>
						</ul></li>
					<li><a href="#" class="nav-top-item">基金产品交易</a>
						<ul>
							<li><a href="" target="dmMain">购买基金</a></li>
							<li><a href="" target="dmMain">赎回基金</a></li>
							<li><a href="" target="dmMain">基金交易记录</a></li>
							<li><a href="" target="dmMain">持仓情况</a></li>
						</ul></li>
				</ul>
				<!-- End #main-nav -->
			</div>
		</div>
		<!-- End #sidebar -->
	</div>
</body>
</html>
