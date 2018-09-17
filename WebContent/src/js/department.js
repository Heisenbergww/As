
$(document).ready(function(){
    //引入模块
    layui.use(['layer','form','table','upload','element'],function(){
        var layer = layui.layer,//提示
        form = layui.form,//表单
        table = layui.table,//表格
        upload = layui.upload;//上传
        element = layui.element;//导航

        var tableData  
        $('#department-page').addClass('layui-this');
                
        //过滤
        //监听提交
        form.on('submit(formDemo)', function(data){
            console.log(JSON.stringify(data.field))
            var filterData = JSON.stringify(data.field)
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
                url: 'department/find',
                data: JSON.stringify(json),
                dataType : 'json' ,
        		contentType : 'application/json;charset=utf-8',
                success: function(res){
                	 tableData = [];
                     for (let line of res) {
                 		var  obj = {
                 			 "f1":line.department_name,
                             "f2": line.department_total,
                             "f3": line.shouldAttendTime,
                             "f4": line.attendTime,
                             "f5": line.overTime,
                             "f6": line.overTimeRank,
                             "f7": line.workdayOverTime,
                             "f8": line.workdayOverTimeRank,
                             "f9": line.holidayOverTime,
                             "f10": line.holidayOverTimeRank,
                             "f11": line.averageOverTime,
                             "f12": line.allAverageOverTime,
                             "f13": line.averageOverTimeRank,
                             "f14": line.oldLateTime,
                             "f15": line.LateTime,
                             "f16": line.oldEarlyRetreatTime,
                             "f17": line.EarlyRetreatTime,
                             "f18": line.absenteeismTime,
                             "f19": line.bingTime,
                             "f20": line.nianTime
                         }
                    
                 		tableData.push(obj)
                     }
                    
                   
                    console.log(res)
                    table.render({
                        elem: '#department-chart',
                        height: 512,
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
                            { field: 'f1', title: '部门' },
                            { field: 'f2', title: '人数'},
                            { field: 'f3', title: '应出勤时间',sort:true},
                            { field: 'f4', title: '工作时长',sort:true},
                            { field: 'f5', title: '加班时长',sort:true},
                            { field: 'f6', title: '加班排名',sort:true},
                            { field: 'f7', title: '工作日加班时长',sort:true},
                            { field: 'f8', title: '工作日加班时长排名',sort:true},
                            { field: 'f9', title: '公休日加班时长',sort:true},
                            { field: 'f10', title: '公休日加班时长排名',sort:true},
                            { field: 'f11', title: '司内人均加班时长',sort:true},
                            { field: 'f12', title: '室人均加班时长（均值）',sort:true},
                            { field: 'f13', title: '司内人均加班时长排名',sort:true},
                            { field: 'f14', title: '原始迟到次数',sort:true},
                            { field: 'f15', title: '认定迟到次数',sort:true},
                            { field: 'f16', title: '原始早退次数',sort:true},
                            { field: 'f17', title: '认定早退次数',sort:true},
                            { field: 'f18', title: '旷工次数',sort:true},
                            { field: 'f19', title: '病事假（次）',sort:true},
                            { field: 'f20', title: '年休假（次）',sort:true}
                        ]],
                        data: tableData,
                    })
                }
            });
            return false;
        });

    })

})