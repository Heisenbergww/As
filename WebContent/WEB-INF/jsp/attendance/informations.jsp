<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<form method="post" id="myform">
		<table class="form-table" style="border:0px;">
			<tr style="border:0px;">
				<td class="field" style="background-color:white;border:0px;">起止日期:</td>
				<td class="value"><input t class="easyui-datebox" type="text" id="time_begin"
					name="time_begin"> 到 <input t class="easyui-datebox" type="text" id="time_end"
					name="time_end">
					</td>
				<td class="field" style="background-color:white;">案字:</td>
				
				
				<td class="value"><SELECT name="caseword">
						<option name="all" value="%" selected="selected">不限</option>
						<option name="jingchu" value="经初">经初</option>
						<option name="xingyichu" value="刑一初">刑一初</option>
						<option name="jingzaizhong" value="经再终">经再终</option>
						<option name="jingxiazhong" value="经辖终">经辖终</option>
						<option name="minzhong" value="民终">民终</option>
						<option name="xingzhong" value="行终">行终</option>
						<option name="jingzhong" value="经终">经终</option>
						<option name="xingyizhong" value="刑一终">刑一终</option>
						<option name="minzaizhong"  value="民再终">民再终</option>
						<option name="xingerchu" value="刑二初">刑二初</option>
						
				</SELECT></td>
				<td class="field" style="background-color:white;">承办人:</td>
				<td class="value"><input t class="easyui-textbox" type="text" id="chengbanren"
					name="chengbanren"></td>
			</tr>
			<tr>
				<td class="field" style="background-color:white;">编号:</td>
				<td class="value"><input t class="easyui-textbox"  type="text" id="bh_begin"
					name="bh_begin"> 到 <input t class="easyui-textbox" type="text" id="bh_end"
					name="bh_end">
					</td>
				<td class="field" style="background-color:white;">案件性质:</td>
				<td class="value"><SELECT name="ajxz">
						<option name="all" value="%" selected="selected">不限</option>
						<option name="one" value="1">1</option>
						<option name="two" value="2">2</option>
						<option name="x">x</option>
					
				</SELECT></td>
				
				
				<td class="value">
					<button class="easyui-linkbutton" type="button"
						onclick="find()"  data-options="iconCls:'icon-search'">查询</button>
					<button class="easyui-linkbutton" type="button"
						onclick="addApplications()"  data-options="iconCls:'icon-edit'">增加</button>
				</td>
			</tr>
			<tr>

			</tr>
		</table>
	</form>



<div id="toolbar">
	<div>
		<button onclick="OpenUpload( )"
			class="easyui-linkbutton" data-options="iconCls:'icon-edit'">导入</button>
	
		<button onclick="rescue.OpenUpload( )"
			class="easyui-linkbutton" data-options="iconCls:'icon-edit'">编辑</button>

		<button onclick="rescue.VoteOpinion( )"
			class="easyui-linkbutton" data-options="iconCls:'icon-edit'">保存</button>

	</div>
</div>

<table style="height: 100%;width:100%;">
	<tr>
		<td style="height: 100%;width:60%;">
			<table id="table"
				style="height: 100%; width:100%; margin: 0px auto;">

			</table>
		</td>
		<td></td>
		<td style="height: 100%;width:40%;">
			<table id="table2"
				style="height: 100%; width:100%; margin: 0px auto;">

			</table>
		</td>
	</tr>
</table>

<div id="win" class="easyui-window" title="备选表决意见" closed="true" style="width:250px;height:400px;padding:5px;">
	<div id="toolbar2">
	<div>
	<button onclick="rescue.addVoteOpinion()" 
				class="easyui-linkbutton" data-options="iconCls:'icon-edit'">增加</button>
		<button onclick="rescue.delMulti('rescue/delmulti?')" 
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">删除</button>
	<button onclick="rescue.closeVoteOpinion()" 
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</button>
	</div>
</div>
	<table id="table3"
				style="height: 250px; width: 305px; margin: 0px auto;">

			</table>
</div>



<div id="ReportForApproval_window" class="easyui-window" title="报审批" closed="true" style="width:250px;height:400px;padding:5px;">
	<div id="ReportForApproval_toolbar">
	<div>
	<button onclick="rescue.ConfirmReportForApproval()" 
				class="easyui-linkbutton" data-options="iconCls:'icon-edit'">确定</button>
		
	<button onclick="rescue.closeReportForApproval()" 
				class="easyui-linkbutton" data-options="iconCls:'icon-cancel'">关闭</button>
	</div>
</div>
	<table id="ReportForApproval_table"
				style="height: 90%; width: 100%; margin: 0px auto;">

			</table>
</div>


<div id="upload_window" class="easyui-window" title="上传文档" closed="true" style="width:250px;height:300px;padding:5px;">
		<form id="myForm_upload" method="post"  enctype="multipart/form-data">
            
            <input class="easyui-filebox" name="file" /><br/><br/>
            <button type="button" onclick="upload()" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">上传文档</button>
        </form>
</div>

<script>
function OpenUpload( ){
		$('#upload_window').window('open');
}


function upload() {
	var form = new FormData(document.getElementById("myForm_upload")); 
	console.log(form);
    $.ajax({
        type: "POST",//方法类型
        dataType: "json",//预期服务器返回的数据类型
        url: "attendance/informations/uploadfile",//url
        data: form,
        cache: false,  
        processData: false,  
        contentType: false,  
        success: function (result) {
            console.log(result);//打印服务端返回的数据(调试用)
            if (result.success) {
            	$('#upload_window').window('close');
            	$.messager.alert('提示','上传文件成功！');
            }
            
        }
    });
}

	$('#table').datagrid({
		title : '申请登记',
		align : 'left',
		halign : 'center',
		url : 'process/applications',
		onClickRow: function (index, row){
			
			$('#table2').datagrid({
				title : '审批信息',
				align : 'left',
				halign : 'center',
				url : 'process/applications2?nbbh='+row["nbbh"],
				rownumbers : true,
				
				columns : [ [ {
					field : 'spr',
					title : '申请人'
				}, {
					field : 'sprq',
					title : '申请日期',
					formatter : function(date2) {
						if(!date)
 	    					return;
 	    				else
						return moment(date2).format('YYYY-MM-DD HH:mm:ss');
					}
				}, {
					field : 'spyj',
					title : '申请意见'
				}, {
					field : 'sply',
					title : '申请理由'
				} ] ]
			});
		},
		rownumbers: true,
		pagination : true,
		singleSelect:true,
		toolbar : '#toolbar',
		columns : [ [ {
			field : 'nbbh',
			title : '序号',hidden:true
		}, 
		{
			field : 'sqrq',
			title : '申请时间',
			formatter : function(date) {
				if(!date)
 					return;
 				else
				return moment(date).format('YYYY-MM-DD HH:mm:ss');
			}
		}
		, {
			field : 'state',
			title : '状态'
		}, {
			field : 'anzi',
			title : '案号'
		}, {
			field : 'jyms',
			title : '简易描述'
		} ] ]
	});
	


	


</script>
