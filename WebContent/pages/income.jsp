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
<script src="/AccountBook/res/js/income.js"></script>


</head>
<body>
<%@ include file="common/top.jsp"%>
<script language="JavaScript" type="text/JavaScript"> 
	document.onload = setLeftColumn();
</script>
<div class="col-xs-10">
	<div class="add">
		<label class="add-label">添加收入:</label>
		<select class="add-select" id="item">
			<option value="1">asdasd</option>
			<option value="2">qqq</option>
			<option value="3">ee</option>
			<option value="4">www</option>
			<option value="5">ttt</option>
		</select>
		<input class="add-money" placeholder="金额" id="money">
		<input class="add-money-remark" placeholder="备注" id="remarkForIncome">
		<button class="add-button" onclick="addMoney()">添加</button>
	</div>
	
	<div class="addItem">
		<label class="addItem-label">添加收入项目:</label>
		<input class="addItem-name" placeholder="项目名称" id="itemName">
		<input class="addItem-remark" placeholder="备注" id="remarkForItem">
		<button class="addItem-button" onclick="addItem()">添加</button>
	</div>	
		
	<div class="total"> 
		<label class="total-label1">月收入：</label>
		<label class="total-money1">3000元</label>
		
		<label class="total-label2">日均收入：</label>
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