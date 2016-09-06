<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.HashMap"%>
<% 
	String path = request.getContextPath();
	List<HashMap<String,Object>>items = (List<HashMap<String,Object>>)request.getAttribute("items");
	List<HashMap<String,Object>>list = (List<HashMap<String,Object>>)request.getAttribute("list");
	float generalIncome = (float)request.getAttribute("generalIncome");
	float averageIncome = (float)request.getAttribute("averageIncome");
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
			<% for(HashMap map:items) {%>
			<option value="<%=map.get("item_id") %>"><%=map.get("item_name")%></option>
			<%} %>
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
		<label class="total-money1"><%=generalIncome %>元</label>
		
		<label class="total-label2">日均收入：</label>
		<label class="total-money2"><%=averageIncome %>元</label>
	</div>
		
	<div>
		<table class="table table-bordered"> 
		    <thead> 
		        <tr> 
					<th>日期</th>
					<th>Money</th>
					<th>项目</th>
					<th>备注</th>
		        </tr> 
		    </thead> 
		    <tbody> 
		        <% for(HashMap map:list) {%>
		        <tr> 
					<td><%=map.get("date")%></td> 
					<td><%=map.get("money")%></td> 
					<td><%=map.get("item_name")%></td> 
					<td><%=map.get("remark")%></td> 
		        </tr> 
		        <%} %>
		    </tbody> 
		</table>
	</div>
		
</div>
<%@ include file="common/bottom.jsp"%>