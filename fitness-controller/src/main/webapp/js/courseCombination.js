/*日历*/
$.noConflict();
$(function () {
    $(".form_datetime").datetimepicker({
        format: 'yyyy-mm-dd',
        pickerPosition: "bottom-right",
        showMeridian: true,
        weekStart: 1,
        todayBtn: 1,
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
        url: "/course/getByPageSimple.do",//地址，就是json文件的请求路径
        // dataType: "json",//数据类型可以为 text xml json  script  jsonp
        // beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: function (error) {
            console.log("错误", error)
        },  //错误执行方法
        success: function (aaData) {
            // debugger;
            console.log(aaData);
            addcourse_comb(aaData);
        }
    });

    function addcourse_comb(xhr) {
        console.log(xhr)
        // var obj=JSON.parse(xhr);
        // console.log(obj)
        //  debugger;
        var aaData = xhr["aaData"];
        for (var i = 0; i < aaData.length; i++) {
            var obj = aaData[i];
            console.log("obj" + obj);
            $("#course_comb").append("<img src=" + obj['picture'] + " height=\"314\" width=\"480\" class=\"image fl\"/>\n" +
                "            <div class=\"course_text fr\">\n" +
                "                <b id=\"course_title\">" + obj['name'] + "</b><br>\n" +
                "                <span id=\"course_desc\">" + obj['description'] + "</span>\n" +
                "                <div class=\"cost fr\" id=\"course_cost\"><button>" + obj['classPerPrice'] + "</button></div>\n" +
                "                <div class=\"appointment fr\"><a href='purchase.html'>购买</a></div>\n" +
                "            </div>")
        }
        // $.each(xhr,function (index,obj) {
        //     debugger;
        //     console.log(obj[index])
        //     console.log(obj['name'])
        //
        //     $("#course_comb").append("<img src="+obj['picture']+" height=\"314\" width=\"480\" class=\"image fl\"/>\n" +
        //         "            <div class=\"course_text fr\">\n" +
        //         "                <b id=\"course_title\">"+obj['name']+"</b><br>\n" +
        //         "                <span id=\"course_desc\">"+obj['description']+"</span>\n" +
        //         "                <div class=\"cost fr\" id=\"course_cost\"><button>"+obj['classPerPrice']+"</button></div>\n" +
        //         "                <div class=\"appointment fr\"><a href='fitness/purchase.html'>购买</a></div>\n" +
        //         "            </div>")
        //
        // });
    }
});

/*
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
        type: "post",//请求方式
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
});*/
