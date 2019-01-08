$(function () {

    $("table").css({"border": "1px solid red", "margin": "0px auto"});

    $("input[name='register']").click(function () {
        window.location = "register.jsp";
    });

    // 登陆
    $("#login").unbind("click").bind("click", function () {
        var uname = $("input[name=uname]").val();
        var pwd = $("input[name=pwd]").val();
        if (uname == "" || uname == null) {
            alert("用户名不能为空！");
            return false;
        } else if (pwd == "" || pwd == null) {
            alert("密码不能为空！");
            return false;
        } else {
            $.ajax({  // ajax登陆请求
                url: getContextPath() + "j_spring_security_check",
                type: "post",
                data: {
                    username: uname,
                    password: pwd
                },
                dataType: "json",
                async: false,

                success: function (res) {
                    window.location.href = "login2.html";
                }
            });
        }
    });

});