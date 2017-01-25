<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
	<title>Customer</title>
	<link href="assets/easy-ui-1.4.5/themes/default/easyui.css" rel="stylesheet"/>
	<link href="assets/easy-ui-1.4.5/themes/icon.css" rel="stylesheet"/>
	<link href="" rel="stylesheet"/>	
	<link rel="StyleSheet" href="assets/css/style.css" type="text/css"/>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
	<script type="text/javascript" src="assets/easy-ui-1.4.5/jquery.easyui.js"></script>
	<script type="text/javascript" src="assets/easy-ui-1.4.5/easyloader.js"></script>
</head>
<body class="easyui-layout layout panel-noscroll">
	<div class="easyui-panel ms-style-background" id="menu-bar" style="padding:5px;width:100%;heigth:42px;">
		<div id="logo-wrap">
		</div>
		<div id="head-nav" style="float:right;">
			<button class="easyui-linkbutton" style="height:30px;padding:1px 6px;" data-options="iconCls:'icon-lock',plain:true">Setting</button>
			<button class="easyui-linkbutton" style="height:30px;padding:1px 6px;" data-options="iconCls:'icon-help',plain:true">Help</button>
			<button class="easyui-linkbutton" style="height:30px;padding:1px 6px;" data-options="iconCls:'icon-no',plain:true" onclick="window.location='/logout'">Logout</button>
		</div>
	</div>

