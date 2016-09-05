<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account Book</title>
<%@ include file="common/common.jsp" %> 
<link href="/AccountBook/res/css/inOrOut.css" rel="stylesheet">
</head>
<body>
<%@ include file="common/top.jsp"%>
<div class="col-xs-10">
	<div class="add">
		<label class="add-label">添加支出:</label>
		<select class="add-select">
			<option>asdasd</option>
			<option>qqq</option>
			<option>ee</option>
			<option>www</option>
			<option>ttt</option>
		</select>
		<input class="add-money" placeholder="金额">
		<button class="add-button">添加</button>
	</div>
	
	<div class="addItem">
		<label class="addItem-label">添加支出项目:</label>
		<input class="addItem-name" placeholder="项目名称">
		<button class="addItem-button">添加</button>
	</div>	
		
	<div class="total"> 
		<label class="total-label1">月支出：</label>
		<label class="total-money1">3000元</label>
		
		<label class="total-label2">日均支出：</label>
		<label class="total-money2">300元</label>
	</div>
		
	<div>
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
		            <th>名称</th> 
		            <th>城市</th> 
		            <th>密码</th> 
		        </tr> 
		    </thead> 
		    <tbody> 
		        <tr> 
		            <td>Tanmay</td> 
		            <td>Bangalore</td> 
		            <td>560001</td> 
		        </tr> 
		        <tr> 
		            <td>Sachin</td> 
		            <td>Mumbai</td> 
		            <td>400003</td> 
		        </tr> 
		        <tr> 
		            <td>Uma</td> 
		            <td>Pune</td> 
		            <td>411027</td> 
		        </tr> 
		    </tbody> 
		</table>
	</div>
		
</div>
<%@ include file="common/bottom.jsp"%>