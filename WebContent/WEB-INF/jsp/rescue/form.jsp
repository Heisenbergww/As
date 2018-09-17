<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form method="post" id="myform">
	<table class="form-table">
		<tr>
			<td class="field">电话号码</td>
			<td class="value">
				<input type="text" id="smsMob" name="smsMob" >
				多个手机号用逗号分开
			</td>
		</tr>
		<tr>
			<td class="field">短信内容</td>
			<td class="value">
	 			<input type="text" id="smsText" name="smsText" style="width:100%;height:200px">
			</td>
		</tr>
		<tr>
			<td class="submit" colspan="2">
				<button class="easyui-linkbutton" type="button" onclick="sendSms()">发送</button>
			</td>
		</tr>
	</table>
</form>

<script>

$(function(){
	$('#smsMob').textbox({    
	    required:true,
	    validateOnCreate: false
	}); 
	$('#smsText').textbox({    
	    required:true,
	    validateOnCreate: false,
	    multiline:true
	}); 
});

function sendSms(){
	$('#myform').form('submit', {    
	    url:'rescue/send',    
	    onSubmit: function(){  
	    	return $(this).form('validate');
	    },    
	    success:function(data){  
	    	console.log('发送成功');
	    	if(data.result > 0){
	    		$.messager.alert('提示', '发送' + data.result + '条短信成功', 'info');
	    	}
	    }    
	});    
}
</script>
