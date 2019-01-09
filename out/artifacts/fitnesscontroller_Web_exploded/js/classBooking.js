$(document).ready(function () {
    $.ajax({
        type: "POST",//请求方式
        url: "/courseInstance/getByPage.do",//地址，就是json文件的请求路径
        // dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function f(response) {
            console.log(response);
            var aaData=response["aaData"];
            // var courseid = aaData["courseId"];
            // var courseInstanceId=aaData["courseInstanceId"];
            // console.log("courseInstanceId"+courseInstanceId);
            $('#classbooking').DataTable({
                "searching":false,
                "bAutoWidth": true, //是否自适应宽度
                "bScrollCollapse": true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
                "columns": [
                    // {"data": "courseId"},
                    {"data": "courseName"},
                    {"data": "coach"},
                    {"data": "courseTime"},
                    {
                        "sClass": "text-center",
                        "data": "courseInstanceId",
                        "render": function (data, type, full, meta) {
                            return "<button class='btn btn-primary btn-xs booking' id="+data+" onclick='test(this)'>预约</button>"
                        }
                    }
                ],
                "data":aaData,
                'select': {
                    'style': 'multi'
                }
            });
        }
    });
});

function test(obj) {
    // $.ajax({
    //     type: "GET",//请求方式
    //     url: "/courseInstance/getByPage.do",//地址，就是json文件的请求路径
    //     dataType: "json",//数据类型可以为 text xml json  script  jsonp
    //     beforeSend: ()=>{console.log("开始")}, //加载执行方法
    //     error: (error)=>{console.log("错误",error)},  //错误执行方法
    //     success: function (xhr) {
    //         var id = xhr.courseInstanceId;
    console.log(obj.id)
            $.ajax({
                type: "post",//请求方式
                url: "/reserve/reserve.do",//地址，就是json文件的请求路径
                data:{
                  courseInstanceId:obj.id
                },
                dataType: "json",//数据类型可以为 text xml json  script  jsonp
                beforeSend: ()=>{console.log("开始")}, //加载执行方法
                error: (error)=>{console.log("错误",error)},  //错误执行方法
                success: function (info) {
                    alert(info.message);
                }
            });
    //     }
    // });
}

/*日历*/
// $.noConflict();
// $(function () {
//     $(".form_datetime").datetimepicker({
//         format: 'yyyy-mm-dd',
//         pickerPosition: "bottom-right",
//         showMeridian: true,
//         weekStart: 1,
//         todayBtn:  1,
//         autoclose: 1,
//         todayHighlight: 1,
//         startView: 2,
//         minView: 2,
//         forceParse: 0
//     });
// });