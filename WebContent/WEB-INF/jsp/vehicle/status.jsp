<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>


<div id="toolbar">
	<div>
		<button onclick="rescue.delMulti('vehicle/delMulti?')"
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</button>
	</div>
</div>

<table id="table"></table>

<script>
    $('#table').datagrid({
        url: 'vehicle/list-status',
        rownumbers: true,
        fit: true,
        pagination: true,
        toolbar:'#toolbar',
        columns:[[
            {field:'ck',checkbox:true},
            {field:'id',title:'操作',formatter:function(value,row,index){

                var url='vehicle/delete';
                return '<a onclick="rescue.deleteById('+value+',\''+url+'\')" href="javascript:void(0)">删除</a>';
            }},
            {field:'number',title:'编号',sortable:true},
            {field:'plateNumber',title:'牌照',sortable:true},
            {field:'driverName',title:'驾驶员', sortable:true},
            {field:'type',title:'车辆类型'},
            {field:'brand',title:'牌照'},
            {field:'model',title:'型号'},
            {field:'color',title:'颜色'},
            {field:'status',title:'派遣情况'}
        ]]
    });
</script>
