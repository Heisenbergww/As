$(document).ready(function(){
    layui.use(['layer','laydate','form','table','upload','element'],function(){
        var layer = layui.layer,//提示
        laydate = layui.laydate,//日期
        form = layui.form,//表单
        table = layui.table,//表格
        upload = layui.upload;//上传
        element = layui.element;//导航

        $.ajax({
            type: 'POST',
            url: 'departmentManagement/find',
            data: 'department',
            success: function(res){
                 var departmentList = res;
                //var departmentList = TEST_DATA5;
                table.render({
                    elem: '#department-chart',
                    // height: 350,
                    // url: '/hello/',                       
                    page: true, //开启分页
                    cols: [[ 
                        { field: 'department_id', title: '部门ID'},
                        { field: 'department_name', title: '部门名字', edit:'text'},   
                        { field: 'department_total', title: '部门人数'},
                        {fixed: 'right', title:'操作', toolbar: '#barDemo'}          
                    ]],
                    data: departmentList,
                })   
                table.on('tool(department-chart)', function (obj) {
                    var data = obj.data;
                    //console.log(obj)
                    if (obj.event === 'del') {
                        layer.confirm('确定要删除吗?', function (index) {
                            console.log(obj)
                            obj.del();
                            layer.close(index);
                            $.ajax({
                                type: 'POST',
                                url: 'departmentManagement/delete',
                                data: { 'res':JSON.stringify(data.department_id)},
                                success: function(res){
                                    layer.msg('删除成功');              
                                },
                                error:function(res){
                                    layer.msg('删除失败'); 
                                }
                            });
                        });
                    } else if (obj.event === 'edit') {
                    
                    	var depExisted = false;
                        for(let line of departmentList){
                            console.log(line.department,obj.data.department)
                            if(obj.data.department==line.department){
                                depExisted = true;
                                console.log('存在')
                            }
                        }
                        if (!depExisted) {
                            $.ajax({
                                type: 'POST',
                                url: 'departmentManagement/modify',
                                data:  JSON.stringify(data),
                                dataType : 'json' ,
                        		contentType : 'application/json;charset=utf-8',
                                success: function (res) {
                                    layer.msg('编辑成功');
                                },
                                error: function (res) {
                                    layer.msg('编辑失败');
                                }
                            });
                        }else{
                            layer.msg('该部门名已存在!')
                        }

                    }
                })  
                
            },
            error:function(res){
                
                layer.msy('网络故障，请重试!')
            }
        }); 

        var departmentHTML = 
        '<form class="layui-form open-dep-form" action="">'+
            '<div class="layui-form-item"> '+
                '<div class="layui-inline">'+
                    '<div class="layui-input-inline open-input">'+
                        '<input type="text" name="department_id"  id="c1" requried lay-verify="" placeholder="请输入部门ID" autocomplete="off" class="layui-input">'+
                    '</div>'+
                '</div>' +
                '<div class="layui-inline">'+
                    '<div class="layui-input-inline open-input">'+
                        '<input type="text" name="department_name"  id="c2" requried lay-verify="" placeholder="请输入部门名字" autocomplete="off" class="layui-input">'+
                    '</div>'+
                '</div>'+ 
                '<div class="layui-inline">'+
                    '<a id="department-save" class="layui-btn" lay-submit lay-filter="formDep">确定</a>'+                
                '</div>'+                 
            '</div>'+
        '</form>';

        //添加部门
        $('#department-add').on('click',function(){
            layer.open({
                type: 1,
                skin: 'layui-layer-rim', //加上边框
                area: ['420px', '240px'], //宽高
                content: departmentHTML
            });
            $('#department-save').on('click',function(){
                console.log($('#c1').val())
                console.log($('#c2').val())
                var departmentCode = $('#c1').val();
                var department = $('#c2').val();
                var can = true;
                console.log(departmentList)
                if(departmentCode!=''&&department!=''){
                    for(let line of departmentList){
                        if(departmentCode==line.departmentCode||department==line.department){
                            console.log('存在')
                            can = false;
                            break;
                        }
                    }
                    console.log(can)
                    if(can){
                        var filterData= {
                            'depid':$('#c1').val(),
                            'depname':$('#c2').val()
                        }
                        $.ajax({
                            type: 'post',
                            url: 'departmentManagement/add',
                           data: JSON.stringify(filterData),
                           dataType : 'json' ,
                     		contentType : 'application/json;charset=utf-8',
                            success: function(res){
                            	res
                                layer.msg('添加成功');  
                                setTimeout(function(){
                                    layer.closeAll()
                                  }, 1200);                
                            },
                            error:function(res){
                                layer.msg('添加失败'); 
                            }
                        });
                        return false;
                    }else{
                        layer.msg('部门名或id已存在，请重新输入'); 
                    }
                }else{
                    layer.msg('请填写完整表格'); 
                }    
            })
//            form.on('submit(formDep)', function(data){
//                console.log(JSON.stringify(data.field))
//                var filterData = data.field
//                
//                // var filterData = JSON.stringify(data.field);
//                // layer.msg(JSON.stringify(data.field));
//                $.ajax({
//                    type: 'GET',
//                    // url: 'c/jsar.json',
//                    data: filterData,
//                    success: function(res){
//                        layer.msg('添加成功');  
//                        setTimeout(function(){
//                            layer.closeAll()
//                          }, 1200);                
//                    },
//                    error:function(){
//                        layer.msg('添加失败'); 
//                    }
//                });
//                return false;
//            });
////            form.on('submit(formDep)', function(data){
////                
////            	console.log(JSON.stringify(data.field))
////                var filterData = data.field
////                console.log(data.field)
////                //名称或部门id存在判断
////                var Existed = false;
////                for (let line of departmentList) {
////                    console.log(line)
////                    if (data.field.department_id == line.department||data.field.department_name == line.department) {
////                        Existed = true;
////                        alert("ok"+Existed);
////                        console.log('部门id或名称已存在!')
////                        layer.msg('部门id或名称已存在,请重新输入!')
////                    }
////                }
////                if(!Existed){
////                	alert("ok");
////                    $.ajax({
////                        type: 'POST',
////                        url: 'departmentManagement/add',
////                        data: JSON.stringify(data.field),
////                        dataType : 'json' ,
////                		contentType : 'application/json;charset=utf-8',
////                        data: filterData,
////                        success: function(res){
////                            layer.msg('添加成功');  
////                            setTimeout(function(){
////                                layer.closeAll()
////                              }, 1200);                
////                        },
////                        error:function(){
////                            layer.msg('添加失败'); 
////                        }
////                    });
////                }
////
////                return false;
////            });
        })
    }) 
})