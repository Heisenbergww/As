<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<div id="toolbar">
	<div>
		<button onclick="rescue.delMulti('driver/delmulti?')" 
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</button>
	</div>
</div>
<table id="table"></table>

<script>
    $('#table').datagrid({
		      url: 'driver/list-page',
		      rownumbers: true,
		      fit: true,
		      pagination: true,
		      toolbar:'#toolbar',
		    columns:[[
		    {field:'ck',checkbox:true},
		    {field:'id',title:'操作',formatter:function(value,row,index){
		    		
		    		var url='driver/delete';
		    		return '<a onclick="rescue.deleteById('+value+',\''+url+'\')" href="javascript:void(0)">删除</a>';
		    }},
			{field:'number',title:'编号',sortable:true},
			{field:'flag',title: '状态'},
			{field:'name',title: '姓名'}, 
			{field:'position',title:'职务'},
			{field:'mobile',title:'联系电话'},
			{field:'gender',title:'性别'},
			{field:'nativePlace',title:'籍贯'},
			{field:'nation',title:'民族'},
			{field:'education',title:'文化程度'},
			{field:'idNumber',title:'身份证号'},
			{field:'birthday',title:'出生年月',formatter:function(date){
				
				return moment(date).format('YYYY-MM-DD');
			} },
			{field:'hireDate',title:'聘入时间',formatter:function(date){
				return moment(date).format('YYYY-MM-DD');
			}},
			{field:'address',title:'家庭住址'},
			{field:'fileNumber',title:'驾驶证号'},
			{field:'clazz',title:'准驾车型'},
			{field:'issueDate',title:'领证时间' ,formatter:function(date){
				return moment(date).format('YYYY-MM-DD');
			}},
			{field:'common',title:'备注'}
		        ]]
	});

</script>