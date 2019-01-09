$(document).ready(function () {
    // $.ajax({
    //     type: "GET",//请求方式
    //     url: "/course/getByPageSimple.do",//地址，就是json文件的请求路径
    //     dataType: "json",//数据类型可以为 text xml json  script  jsonp
    //     // beforeSend: ()=>{console.log("开始")}, //加载执行方法
    //     error: function (error) {
    //         console.log("错误", error)
    //     },  //错误执行方法
    //     success: function (xhr) {
    //         debugger;
    //         console.log(xhr);
    // addcourse_comb(xhr);
    var title = document.querySelector("#coursetitle");
    title.innerHTML = $.cookie("courseName");
    $("#pay").click(function () {
        debugger;

        console.log()
        var unitprice = $.cookie("coursePrice")
        console.log("unitprice" + unitprice);
        var num = $("select[name='classSession']").find("option:selected").text();
        // var price = parseInt(unitprice);
        var courseNum = parseInt(num);
        // console.log(price);
        // console.log(courseNum);
        var total = unitprice * courseNum;
        console.log(total);
        var paytotal = document.querySelector("#total");
        paytotal.innerHTML = "￥" + total;
        var id = $.cookie("courseId")
        console.log("id:" + id)
        $.ajax({
            type: "POST",//请求方式
            url: "/course/buyCourse.do",//地址，就是json文件的请求路径
            data: {
                courseId: id,
                courseNum: courseNum
            },
            dataType: "json",//数据类型可以为 text xml json  script  jsonp
            //         beforeSend: () = > {console.log("开始")
            // }, //加载执行方法
            error: function (error) {
                console.log("错误", error)
            },  //错误执行方法
            success: function (info) {
                console.log(info["message"]);
                if (info["message"] == "您已有该课程正在进行中") {
                    alert("您已有该课程正在进行中");
                    setTimeout(function () {
                        window.location.href = "courseCombination.html";
                    }, 1000);
                } else {
                    alert("购买成功");
                    setTimeout(function () {
                        window.location.href = "courseCombination.html";
                    }, 1000);
                }
            }
        })
    });
    //
    //     }
    // });

    /*function addcourse_comb(xhr){
        debugger;
        $.each(xhr,function (index,obj) {
            debugger;
            $("#course_comb").append(
                "            <div class=\"course_text fr\">\n" +
                "                <b id=\"course_title\">"+obj['title']+"</b><br>\n" +
                // "                <div class=\"cost fr\" id=\"course_cost\"><button>"+obj['cost']+"</button></div>\n" +
                "            </div>")

        });
    }*/
});


