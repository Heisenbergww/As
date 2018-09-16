$(document).ready(function(){
	var backlist ;
    $.ajax({
        type: 'post',
        url: 'departmentManagement/find',
        data: 'department',
        // data: modifyList,
        success: function (res) {
            backlist = res;
            
            showDep()
        },
        error:function(res){
        }
    })
    function showDep() {
      console.log(backlist)
        var depList = [
            {
                'id': '',
                'department': '请选择'
            }
        ]
        for (let line of backlist) {
            depList.push({
                'id': line.department_id,
                'department': line.department_name
            })
        }
        var depHTML = ''
        for (let line of depList) {
            depHTML += '<option value="' + line.id + '">' + line.department+ '</option>'
        }
        $('#ajax-dep').html(depHTML)
    }

    
})