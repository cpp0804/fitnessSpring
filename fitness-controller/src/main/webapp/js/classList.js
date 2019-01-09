$(document).ready(function () {
    $.ajax({
        type: "GET",//请求方式
        url: "/userCourse/getByPageUser.do",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
            debugger;
            console.log(xhr);
            var aaData=xhr["aaData"]
            // addcourse_comb(xhr);
            var name = document.querySelector("#name");
            var num = document.querySelector("#num");
            var purchasedate = document.querySelector("#purchasedate");
            name.innerHTML = aaData["courseName"];
            num.innerHTML = aaData["courseNum"];
            purchasedate.innerHTML = aaData["createTime"];
        }
    });
    /*function addcourse_comb(xhr){
        debugger;
        $.each(xhr,function (index,obj) {
            debugger;
            $("#course_comb").append("<img src="+obj['image']+" height=\"314\" width=\"480\" class=\"image fl\"/>\n" +
                "            <div class=\"course_text fr\">\n" +
                "                <b id=\"course_title\">"+obj['title']+"</b><br>\n" +
                "                <span id=\"course_desc\">"+obj['desc']+"</span>\n" +
                "                <div class=\"cost fr\" id=\"course_cost\"><button>"+obj['cost']+"</button></div>\n" +
                "            </div>")

        });
    }*/
});

