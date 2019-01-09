$(document).ready(function () {
    $.ajax({
        type: "GET",//请求方式
        url: "json/purchaseInfo.json",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
            debugger;
            console.log(xhr);
            console.log(xhr.title);
            // addcourse_comb(xhr);
            var title = document.querySelector("#coursetitle");
            title.innerHTML = xhr.title;
            $("#pay").click(function () {
                debugger;
                var unitprice = xhr.cost;
                console.log(unitprice);
                var coursenum = $("select[name='classSession']").find("option:selected").text();
                var price = parseInt(unitprice);
                var num = parseInt(coursenum);
                console.log(price);
                console.log(num);
                var total = price*num;
                console.log(total);
                var paytotal = document.querySelector("#total");
                paytotal.innerHTML = "￥"+total;
            });

        }
    });

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


