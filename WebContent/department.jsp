<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>部门统计</title>
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
                <li class="layui-nav-item" id="department-page"><a href="#">department</a></li>
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
                <h1 class="text-center mg-tpye1">签到情况</h1>
                <!-- <hr class="center-line"> -->
            </div>
        <!-- header -->

        <!-- fliter -->
        <div class="fliter layui-row">
            <form class="layui-form" action="">
                <div class="layui-form-item">
                    <div class="layui-inline">
                        <div class="layui-input-inline in1">
                            <input type="text" autocomplete="off" placeholder="from date XXX to date XXX:" class="layui-input" disabled>
                        </div>
                    </div>
        
                    <div class="layui-inline">
                        <div class="layui-input-inline in2">
                            <input type="text" name="begin_date" class="layui-input" id="start-date" placeholder="起始日期" lay-key="1">
                        </div>
                    </div>
        
                    <div class="layui-inline">
                        <div class="layui-input-inline in2">
                            <input type="text" name="end_date" class="layui-input" id="end-date" placeholder="结束日期" lay-key="2">
                        </div>
                    </div>
        
                    <div class="layui-inline">
                        <div class="layui-input-inline in3">
                            <select name="Department_ID"  id="ajax-dep" lay-verify="">
                                <option value="">部门</option>
                                <option value="010">人事部</option>
                                <option value="021">外事司</option>
                            </select>
                        </div>
                    </div>
        
                    <div class="layui-inline">
                        <div class="layui-input-inline in4">
                            <input type="text" name="id"  lay-verify="" placeholder="请输入员工ID" autocomplete="off" class="layui-input">
                        </div>
                    </div>
        
                    <div class="layui-inline">
                        <label class="layui-form-label label-1">加班时长</label>
                        <div class="layui-input-inline smaller-input">
                            <select name="mark1" lay-verify="">
                                <option value="0">></option>
                                <option value="1">=</option>
                                <option value="2"><</option>
                            </select>
                        </div>
                        <div class="layui-input-inline small-input">
                            <div class="layui-input-inline">
                                <input type="text" name="times1" lay-verify="" autocomplete="off" placeholder="" class="layui-input small-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-inline">
                        <label class="layui-form-label label-1">迟到次数</label>
                        <div class="layui-input-inline smaller-input">
                            <select name="mark2" lay-verify="">
                                <option value="0">></option>
                                <option value="1">=</option>
                                <option value="2"><</option>
                            </select>
                        </div>
                        <div class="layui-input-inline small-input">
                            <div class="layui-input-inline">
                                <input type="text" name="times2" lay-verify="" autocomplete="off" placeholder="" class="layui-input small-input">
                            </div>
                        </div>
                    </div>

                    <div class="layui-inline">
                        <button id="search" class="layui-btn" lay-submit lay-filter="formDemo">搜索</button>
                        
                    </div>                   
                </div>
            </form>
        </div>
        <!-- fliter -->
        
        <!-- chart-part -->
            <div class="show-part ">
                <table id="department-chart" lay-filter="depart"></table>
            </div>
        <!-- chart-part -->
        
        <!-- nav -->
            <!-- <div class="nav-part "> -->
                <!-- <button id="c " class="layui-btn layui-btn-radius layui-btn-primary ">出现</button> -->
                <!-- <button id="upload-text" class="layui-btn layui-btn-radius layui-btn-primary">导入数据</button>
                <button id="upload-edit" class="layui-btn layui-btn-radius layui-btn-primary">编辑</button>
                <button id="upload-save" class="layui-btn layui-btn-radius layui-btn-primary">保存</button>
                <a class="layui-btn layui-btn-radius layui-btn-primary " href="./department.html ">部门查询</a>
                <a class="layui-btn layui-btn-radius layui-btn-primary " href="./persons.html ">个人查询</a> -->
            <!-- </div> -->
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

<script src="src/js/department.js"></script>

</body>
</html>