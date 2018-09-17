<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	
	<div id="cc" class="easyui-calendar" style="width:400px;height:400px;"></div> 
	
<script>

$('#cc').calendar({
	onSelect: function(date){
		alert(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate());
	}
});



	


</script>



