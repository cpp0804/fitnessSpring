$(document).ready(function () {
/*    $.ajax({
        type: "GET",//请求方式
        url: "js/course.json",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
            debugger;
            console.log(xhr);
            addcourse_comb(xhr);
        }
    });
    function addcourse_comb(xhr){
        debugger;
        $.each(xhr,function (index,obj) {
            debugger;
            $("#course_comb").append(
                "            <div class=\"course_text fl\">\n" +
                "                <b id=\"course_title\">"+obj['title']+"</b><br>\n" +
                "                <span id=\"course_desc\">"+obj['desc']+"</span>\n" +
                "                <div class=\"appointment fr\"><button class=\'btn btn-primary btn-xs\' data-toggle=\"modal\" data-target=\"#modifyModal\"><span class=\'glyphicon glyphicon-edit\'></span>预约</button></div>\n" +
                "            </div>")

        });
    }*/
    $.ajax({
        type: "GET",//请求方式
        url: "/courseInstance/getByPage.do",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: response=>{
            console.log(response);
            var courseid = response.courseId;
            $('#classbooking').DataTable({
                "searching":false,
                "bAutoWidth": true, //是否自适应宽度
                "bScrollCollapse": true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
                "columns": [
                    {"data": "courseId"},
                    {"data": "courseName"},
                    {"data": "coach"},
                    {"data": "courseTime"},
                    {
                        "render": function () {
                            return "<button class=\"btn btn-primary btn-xs booking \" id=\"booking\">预约</button>"

                        }
                    }
                ],
                "data":response.data,
                'select': {
                    'style': 'multi'
                }
            });
            $.ajax({
                type: "post",//请求方式
                url: "/courseInstance/getByPage.do",//地址，就是json文件的请求路径
                data:{
                    courseId:courseid
                },
                dataType: "json",//数据类型可以为 text xml json  script  jsonp
                beforeSend: ()=>{console.log("开始")}, //加载执行方法
                error: (error)=>{console.log("错误",error)},  //错误执行方法
                success: function (info) {
                }
            });


        }
    });
});

$("#booking").click(function () {
  /*  var key = {};
    key["name"] = $("input[name = 'userName']").val();
    key["tel"] = $("input[name = 'userTel']").val();
    console.log(key["name"]);
    console.log(key["tel"]);
    key["timePre"] = $("input[name='timePre']").val();
    key["timeAfter"] = $("input[name='timeAfter']").val();
    console.log(key["timePre"]);
    console.log(key["timeAfter"]);*/
    $.ajax({
        type: "GET",//请求方式
        url: "/courseInstance/getByPage.do",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
            var id = xhr.courseInstanceId;
            $.ajax({
                type: "post",//请求方式
                url: "/reserve/reserve.do",//地址，就是json文件的请求路径
                data:{
                  courseInstanceId:id
                },
                dataType: "json",//数据类型可以为 text xml json  script  jsonp
                beforeSend: ()=>{console.log("开始")}, //加载执行方法
                error: (error)=>{console.log("错误",error)},  //错误执行方法
                success: function (info) {
                    alert(info.message);
                }
            });
        }
    });
});

/*日历*/
$.noConflict();
$(function () {
    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd',
        pickerPosition: "bottom-right",
        showMeridian: true,
        weekStart: 1,
        todayBtn:  1,
        autoclose: 1,
        todayHighlight: 1,
        startView: 2,
        minView: 2,
        forceParse: 0
    });
});