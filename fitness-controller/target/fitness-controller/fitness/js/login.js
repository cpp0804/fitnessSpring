$(document).ready(function () {
    // var user = {};
    $("#login").click(function () {
        debugger;
        uname = $("input[name='username']").val();
        console.log(username);
        pwd = $("input[name='password']").val();
        console.log(password);
        console.log(user);
        $.ajax({
            type: "GET",//请求方式
            url: "j_spring_security_check",//地址，就是json文件的请求路径
            data:{
                username: uname,
                password: pwd
            },
            dataType: "json",//数据类型可以为 text xml json  script  jsonp
            beforeSend: ()=>{console.log("开始")}, //加载执行方法
            error: (error)=>{console.log("错误",error)},  //错误执行方法
            success: function(xhr){
                if(xhr.status == true){
                    if(xhr.role == 'coach'){
                        window.location.href='managecoach.html';
                    }else{
                        window.location.href= 'manage.html';
                    }
                }
        }
    });
    });
});