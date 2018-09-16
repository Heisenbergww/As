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
                <h1 class="text-center mg-tpye1">人员管理</h1>
                <!-- <hr class="center-line"> -->
            </div>
        <!-- header -->

        <!-- fliter -->
        <div class="fliter layui-row">
            <form class="layui-form" action="" id="person-chose-form">
                <div class="layui-form-item">
            
                    <div class="layui-inline">
                        <div class="layui-input-inline in3">
                            <select name="department_id" id="ajax-dep" lay-verify="">
                                <option value="">部门</option>
                                <option value="010">人事部</option>
                                <option value="021">外事司</option>
                            </select>
                        </div>
                    </div>
            
                    <div class="layui-inline">
                        <div class="layui-input-inline in4">
                            <input type="text" name="user_id" lay-verify="" placeholder="请输入员工ID" autocomplete="off" class="layui-input">
                        </div>
                    </div>
            
                    <div class="layui-inline">
                        <div class="layui-input-inline in4">
                            <input type="text" name="user_name" lay-verify="" placeholder="请输入员工姓名" autocomplete="off" class="layui-input">
                        </div>
                    </div>
            
                    <div class="layui-inline">
                        <button id="person-chose" class="layui-btn" lay-submit lay-filter="personChose">搜索</button>
                    </div>

                    <div class="layui-inline">
                        <button id="person-add" class="layui-btn" lay-submit lay-filter="personAdd">添加</button>                        
                    </div>  
                </div>
            </form>
        </div>
        <!-- fliter -->
        
        <!-- chart-part -->
            <div class="show-part">                
                <table id="relation-chart" lay-filter="relation-chart"></table>
                <!-- <button id="relation-upload" class="layui-btn" lay-submit lay-filter="relationUpload">同步</button> -->
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
<script src="src/js/departlist.js"></script>
<script src="src/js/main.js "></script>
<script src="src/js/VAR.js "></script>
<!-- js -->

<script src="src/js/relation.js"></script>
<script type="text/html" id="barDemo">
    <a class="layui-btn layui-btn-xs" lay-event="edit">保存</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>

</body>
</html>