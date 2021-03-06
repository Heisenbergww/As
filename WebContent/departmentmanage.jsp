<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>部门人员管理</title>
    <link rel="stylesheet" href="src/module/layui/css/layui.css">
    <link rel="stylesheet" href="src/css/main.css">
</head>

<body class="">

    <div class="layui-layout layui-layout-admin">
        <!-- header -->
        <div class="header">
            <ul class="layui-nav" lay-filter="">
                <li class="layui-nav-item" id="home-page"><a href="#">签到系统</a></li>
                <li class="layui-nav-item" id="index-page"><a href="index.jsp">home</a></li>
                <li class="layui-nav-item" id="department-page"><a href="department.jsp">department</a></li>
                <li class="layui-nav-item" id="persons-page"><a href="persons.jsp">persons</a></li>
                <li class="layui-nav-item">
                    <a href="javascript:;">management</a>
                    <dl class="layui-nav-child">
                        <!-- 二级菜单 -->
                        <dd><a href="relation.jsp">relation</a></dd>
                        <dd><a href="departmentmanage.jsp">department manage</a></dd>
                        <dd><a href="dateadd.jsp">dateadd</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
        <!-- header -->

        <!-- 左部分 -->
        <div class="left-part layui-fluid">
        <!-- header -->
            <div class="layui-row">
                <h1 class="text-center mg-tpye1">部门管理</h1>
                <!-- <hr class="center-line"> -->
            </div>
        <!-- header -->
        
        <!-- chart-part -->
            <div class="show-part">                
                <table id="department-chart" lay-filter="department-chart"></table>

                <button id="department-add" class="layui-btn">添加部门</button>
            </div>
        <!-- chart-part -->
        
        <!-- nav -->
            <!-- <div class="nav-part ">
                <button id="upload-text" class="layui-btn layui-btn-radius layui-btn-primary">导入数据</button>
                <button id="upload-edit" class="layui-btn layui-btn-radius layui-btn-primary">编辑</button>
                <button id="upload-save" class="layui-btn layui-btn-radius layui-btn-primary">保存</button>
                <a class="layui-btn layui-btn-radius layui-btn-primary " href="./department.html ">部门查询</a>
                <a class="layui-btn layui-btn-radius layui-btn-primary " href="./persons.html ">个人查询</a>
            </div> -->
        <!-- nav -->
        </div>
        

    </div>
<!-- js -->
<script src="src/module/layui/layui.js "></script>
<script src="src/module/jquery/jquery-3.3.1.min.js "></script>
<script src="src/js/main.js "></script>
<script src="src/js/VAR.js "></script>
<!-- js -->

<script src="src/js/depmanage.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">保存</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>