<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>添加节假日</title>
    <link rel="stylesheet" href="src/module/layui/css/layui.css">
    <link rel="stylesheet" href="src/css/main.css">
    <link rel="stylesheet" href="src/module/schedule/schedule.css">
    <link rel="stylesheet" href="src/css/dateadd.css">
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
                    <dl class="layui-nav-child"> <!-- 二级菜单 -->
                      <dd><a href="relation.jsp">relation</a></dd>
                      <dd><a href="departmentmanage.jsp">department manage</a></dd>
                      <dd><a href="#">dateadd</a></dd>
                    </dl>
                  </li>
            </ul>
        </div>
        <!-- header -->

        <!-- 部分 -->
        <div class="left-part layui-fluid">
            <!-- header -->
            <div class="layui-row">
                <h1 class="text-center mg-tpye1">节假日及工作日日期添加</h1>
                <!-- <hr class="center-line"> -->
            </div>        
            <!-- header -->

            <div class="date-add-part">
                <div id='schedule-box' class="boxshaw">            
                </div>

                <div style="display: none;">
                    <h3 id='h3Ele'></h3>
                </div>
                <div id='chose-part'>
                    <form class="layui-form" action="">
                        <div class="layui-form-item">
                            <div class="circle-point1"></div>
                            <div class="layui-input-block" id="unwork-check" work-state=0>
                                <input type="checkbox" title="公休日选择">
                            </div>
                        </div>
                        <div class="layui-form-item">
                            <div class="circle-point2"></div>
                            <div class="layui-input-block" id="work-check" work-state=0>
                                <input type="checkbox" title="工作日选择">
                            </div>
                        </div>            
                    </form> 
                    <div>
                        <button id="update-date" class="layui-btn">提交</button>
                    </div>
                </div>  
            
                <!-- chart-part -->
                <div class="show-part">
                    <table id="date-history" lay-filter="date-history"></table>
                </div>
                <!-- <div class="show-part">
                    <table id="twodate-chart2" lay-filter="twodate-chart2"></table>
                </div>                 -->
                <!-- chart-part -->
            </div>
            
        
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
<script src="src/module/schedule/schedule.js"></script>
<script src="src/js/main.js"></script>
<script src="src/js/dateadd.js"></script>
<script src="src/js/moment-with-locales.js "></script>
</body>
</html>