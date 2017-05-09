<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>		
		<base href="<%=basePath%>">		
		<title>瓷砖交易管理系统</title>
		<link rel="stylesheet" href="resources/css/reset.css" type="text/css" media="screen" />	  
		<link rel="stylesheet" href="resources/css/style.css" type="text/css" media="screen" />
		<link rel="stylesheet" href="resources/css/invalid.css" type="text/css" media="screen" />	
				
		<!--                       Javascripts                       -->  
		<!-- jQuery -->
		<script type="text/javascript" src="resources/scripts/jquery-1.3.2.min.js"></script>
		
		<!-- jQuery Configuration -->
		<script type="text/javascript" src="resources/scripts/simpla.jquery.configuration.js"></script>		
		<!-- Facebox jQuery Plugin -->
		<script type="text/javascript" src="resources/scripts/facebox.js"></script>
		
		<!-- jQuery WYSIWYG Plugin -->
		<script type="text/javascript" src="resources/scripts/jquery.wysiwyg.js"></script>
		
		<!-- jQuery Datepicker Plugin -->
		<script type="text/javascript" src="resources/scripts/jquery.datePicker.js"></script>
		<script type="text/javascript" src="resources/scripts/jquery.date.js"></script>		
	</head>
				
	<FRAMESET frameSpacing="0" cols="260,*">
		<FRAME name=menu src="index/left.jsp"  frameBorder=0>
		<FRAME name=dmMain src="index/right.jsp" frameBorder=0 >	
	</FRAMESET>
  	
</html>
