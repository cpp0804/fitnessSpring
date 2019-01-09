$(document).ready(function () {
    var user = {};
    $("#login").click(function () {
        debugger;
        user["name"] = $("input[name='form_username']").val();
        console.log(user["name"]);
        user["psd"] = $("input[name='form_password']").val();
        console.log(user["psd"]);
        console.log(user);
        $.ajax({
            type: "GET",//请求方式
            url: "test.json",//地址，就是json文件的请求路径
            data:{
                user: user
            },
            dataType: "json",//数据类型可以为 text xml json  script  jsonp
            beforeSend: ()=>{console.log("开始")}, //加载执行方法
            error: (error)=>{console.log("错误",error)},  //错误执行方法
            success: response=>{
                console.log(user);
                console.log(response);
                alert("发送成功");
            }
        });
    });
});