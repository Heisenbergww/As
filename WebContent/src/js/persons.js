$(document).ready(function(){
    //引入模块
    layui.use(['layer','form','table','upload','element'],function(){
        var layer = layui.layer,//提示
        form = layui.form,//表单
        table = layui.table,//表格
        upload = layui.upload;//上传
        element = layui.element;//导航

        var tableData  
        $('#persons-page').addClass('layui-this');
                
        //过滤
        //监听提交
        form.on('submit(formDemo)', function(data){
            console.log(JSON.stringify(data.field))
            var filterData = data.field
            // var filterData = JSON.stringify(data.field);
            // layer.msg(JSON.stringify(data.field));
            var json = {
            		"begin_date" :data.field.begin_date,
            		"end_date" : data.field.end_date,
            		"department_id" :data.field.Department_ID,
            		"user_id": data.field.User_ID,
            		"mark1" :data.field.mark1,
            		"mark2" : data.field.mark2,
            		"times1" :data.field.times1,
            		"times2" : data.field.times2,
            		
            	};
            $.ajax({
                type: 'POST',
                url: 'persons/find',
                data:  JSON.stringify(data.field),
                dataType : 'json' ,
        		contentType : 'application/json;charset=utf-8',
                success: function(res){
                     tableData = [];
                     for (let line of res) {
                 		var  obj = {
                 			 "f1":line.user_ID,
                             "f2": line.user_Name,
                             "f3": line.affiliation_name,
                             "f4": line.oldLateTime,
                             "f5": line.lateTime,
                             "f6": line.oldEarlyRetreatTime,
                             "f7": line.EarlyRetreatTime,
                             "f8": line.absenteeismTime,
                             "f9": line.bingTime,
                             "f10": line.nianTime,
                             "f11": line.shouldAttendTime,
                             "f12": line.attendTime,
                             "f13": line.beyondAttendTime,
                             "f14": line.overTime,
                             "f15": line.workdayOverTime,
                             "f16": line.holidayOverTime,
                             "f17": line.rank,
                             "f18": line.noPunchCardAtWorkTime,
                             "f19": line.noPunchCardAfterWorkTime
                         }
                    
                 		tableData.push(obj)
                     }
//                    tableData = TEST_DATA2;
                     console.log(res)
                    console.log(tableData)
                    var thisDate = '2018'+'年'+'7'+'月';
                    // var thisDate = res.year+'年'+res.month+'月';
                    var ins1 = table.render({
                        elem: '#persons-chart',
                        id : 'persons',
                        height: 512,
                        title : thisDate+'司长以下人员考勤情况统计表',
                        // url: '/src/js/var.json',
                        request: {
                            pageName: 'curr', //页码的参数名称，默认：page
                            limitName: 'nums', //每页数据量的参数名，默认：limit
                        },
                        where: {
                            token: 'sasasas',
                            id: 123
                        },
                        page: true, //开启分页
                        cols: [[ 
                            { field: 'f1', title: '用户ID' },
                            { field: 'f2', title: '姓名'},
                            { field: 'f3', title: '所在单位'},
                            { field: 'f4', title: '原始晚打卡记录（次）', sort:true },
                            { field: 'f5', title: '认定迟到（次）', sort:true },
                            { field: 'f6', title: '原始提前离岗记录(次）', sort:true },
                            { field: 'f7', title: '认定早退（次）', sort:true },
                            { field: 'f8', title: '旷工（天）', sort:true },
                            { field: 'f9', title: '病事假（天）', sort:true },
                            { field: 'f10', title: '年休假（天）', sort:true },
                            { field: 'f11', title: '应在班时间（小时）', sort:true },
                            { field: 'f12', title: '实际在班时间（小时）', sort:true },
                            { field: 'f13', title: '实际在班超出时间（小时）', sort:true },
                            { field: 'f14', title: '室人均在班超出时间（小时）', sort:true },
                            { field: 'f15', title: '工作日在班超出时间（小时）', sort:true },
                            { field: 'f16', title: '公休日在班超出时间（小时）', sort:true },
                            { field: 'f17', title: '加班排名', sort:true },
                            { field: 'f18', title: '早晨没打卡（次）', sort:true },
                            { field: 'f19', title: '下班没打卡（次）', sort:true },
                        ]],
                        data: tableData,
                    })


                    $('#export').on('click', function () {
                        //将上述表格示例导出为 xls文件
                        // console.log(ins1.config.id)
                        table.exportFile(ins1.config.id, ins1.config.data,'xls'); //data 为该实例中的任意数量的数据
                    })
                }
            });

            
            return false;
        });

        

    })

})