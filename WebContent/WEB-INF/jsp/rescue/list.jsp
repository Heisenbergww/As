<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="toolbar">
	<div>
		<button onclick="rescue.delMulti('rescue/delmulti?')" 
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</button>
	</div>
</div>
<table id="table"></table>

<script>
    $('#table').datagrid({
		      url: 'rescue/list-page',
		      rownumbers: true,
		      fit: true,
		      pagination: true,
		      toolbar:'#toolbar',
		    columns:[[
		    {field:'ck',checkbox:true},
		    {field:'id',title:'操作',formatter:function(value,row,index){
		    		
		    		var url='rescue/delete';
		    		return '<a onclick="rescue.deleteById('+value+',\''+url+'\')" href="javascript:void(0)">删除</a>';
		    }},
			{field:'status',title:'状态'},
			{field:'dispatchDiaoduyuan',title: '调度员'},
			{field:'applyShenqingshijian',title: '申请时间',
				formatter:function(date){
				return moment(date).format('YYYY-MM-DD');
			}}, 
			{field:'applyLurushijian',title:'录入时间'},
			{field:'applyShenqingren',title:'申请人'},
			{field:'applyAnjianbianhao',title:'案件编号',sortable:true},
			{field:'applyLianxidianhua',title:'联系电话'},
			{field:'applyShiguyuanyin',title:'事故原因'},
			{field:'applyJiuyuandidian',title:'救援地点'}
		        ]]
	});

</script>