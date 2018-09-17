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
        url: 'driver/list-status',
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
            {field:'driverName',title:'驾驶员', sortable:true},
            //{field:'driverMobile',title:'联系方式',sortable:true},
            {field:'gender',title:'性别',sortable:true},
            {field:'position',title:'职位'},
            {field:'status',title:'派遣情况'},
            {field:'flag',title:'是否在岗'}
        ]]
    });
</script>