<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="toolbar">
	<form method="post" id="myform">
		<table class="form-table" >
			<tr>
				<td class="field">派车起止时间</td>
				<td class="value">
					<input type="text" id="time_begin" name="time_begin">
					-
					<input type="text" id="time_end" name="time_end">
				</td>
				<td class="field">油耗</td>
				<td class="value">
					<input type="text" id="oil" name="oil">
					元/公里
				</td>
				<td class="value">
					<button class="easyui-linkbutton" type="button" onclick="genReport()">生成报表</button>
					<button class="easyui-linkbutton" type="button">清空</button>
					<button class="easyui-linkbutton" type="button">打印</button>
				</td>
			</tr>
		</table>
	</form>
</div>
<table id="table"></table>

<script>
    
/* $('#table').datagrid({
    url: 'report/list',
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
	{field:'number',title:'车辆编号',sortable:true},
	{field:'plateNumber',title: '车牌号码',sortable:true},
	{field:'driverName',title: '驾驶员'}, 
	{field:'backShijifeiyong',title:'救援收入（元）'},
	{field:'backLicheng',title:'行驶里程（公里）'},
	{field:'backFeiyong',title:'油耗费用（元）'}
      ]]
}); */

</script>

	
<script>

$(function(){
	   var a=1;
	   var d;
	   $('#time_begin').datebox({    
	    required:true,
	    validateOnCreate: false,
	    formatter: function(date){
	    	if(a==1){
	    	a++;
	    	d=date;
	    	return moment(date).format('YYYY-MM-DD');
	    	}
	    	return moment(d).format('YYYY-MM-DD');;
	    }
	});  

	   var b=1;
	   	var e;
	$('#time_end').datebox({    
	    required:true,
	    validateOnCreate: false,
	    formatter: function(date){
	    	if(b==1){
		    	b++;
		    	e=date;
		    	return moment(date).format('YYYY-MM-DD');
		    	}
		    	return moment(e).format('YYYY-MM-DD');
	    }
	}); 
	$('#oil').numberbox({    
	    required:true,
	    validateOnCreate: false
	}); 
});

function genReport(){
	
 	 $('#myform').form('submit', {    
	    url:'report/list',    
	    onSubmit: function(){  
	    	return $(this).form('validate');
	    },    
	    success:function(data){
	    	
	    	console.log(data);
	    	data = JSON.parse(data);
	    	//$('#table').datagrid('destroy');//销毁
	    	$('#table').datagrid({
	    		data: data ,
	    		rownumbers: true,
	    	    fit: true,
	    	    toolbar:'#toolbar',
	    	  columns:[[
	    		{field:'number',title:'车辆编号',sortable:true},
	    		{field:'plateNumber',title: '车牌号码',sortable:true},
	    		{field:'driverName',title: '驾驶员'}, 
	    		{field:'backShijifeiyong',title:'救援收入（元）'},
	    		{field:'backLicheng',title:'行驶里程（公里）'},
	    		{field:'backFeiyong',title:'油耗费用（元）'}
	    	  ]] 
	    	});
	    	
	    	console.log('生成报表');
	    	
	    }    
	});    
}
</script>