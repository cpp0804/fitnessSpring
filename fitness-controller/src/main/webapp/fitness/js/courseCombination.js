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
$(document).ready(function () {
    $.ajax({
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
            $("#course_comb").append("<img src="+obj['image']+" height=\"314\" width=\"480\" class=\"image fl\"/>\n" +
                "            <div class=\"course_text fr\">\n" +
                "                <b id=\"course_title\">"+obj['title']+"</b><br>\n" +
                "                <span id=\"course_desc\">"+obj['desc']+"</span>\n" +
                "                <div class=\"cost fr\" id=\"course_cost\"><button>"+obj['cost']+"</button></div>\n" +
                "                <div class=\"appointment fr\"><button class=\'btn btn-primary btn-xs\' data-toggle=\"modal\" data-target=\"#modifyModal\"><span class=\'glyphicon glyphicon-edit\'></span>购买</button></div>\n" +
                "            </div>")

        });
    }
});

$("#submit").click(function () {
    var key = {};
    key["name"] = $("input[name = 'userName']").val();
    key["tel"] = $("input[name = 'userTel']").val();
    console.log(key["name"]);
    console.log(key["tel"]);
    key["timePre"] = $("input[name='timePre']").val();
    key["timeAfter"] = $("input[name='timeAfter']").val();
    console.log(key["timePre"]);
    console.log(key["timeAfter"]);
    $.ajax({
        type: "GET",//请求方式
        url: "js/course.json",//地址，就是json文件的请求路径
        data:{
            key:key
        },
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function () {
            alert("提交成功");
        }
    });
});