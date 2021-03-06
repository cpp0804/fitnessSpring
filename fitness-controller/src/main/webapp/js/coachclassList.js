$(document).ready(function () {
    $.ajax({
        type: "POST",//请求方式
        url: "/user/getStudentList.do",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
        debugger;
        var obj = xhr["aaData"];
        console.log(obj);
        /* console.log(xhr);
         var aaData=xhr["aaData"]
         // addcourse_comb(xhr);
         var name = document.querySelector("#name");
         var num = document.querySelector("#num");
         var purchasedate = document.querySelector("#purchasedate");
         name.innerHTML = aaData["courseName"];
         num.innerHTML = aaData["courseNum"];
         purchasedate.innerHTML = aaData["createTime"];*/
        $("#classlist").DataTable({
            "searching":false,
            "bAutoWidth": true, //是否自适应宽度
            "bScrollCollapse": true, //是否开启DataTables的高度自适应，当数据条数不够分页数据条数的时候，插件高度是否随数据条数而改变
            "columns": [
                // {"data": "courseName"},
                {"data": "name"},
                {"data":"phone"}
            ],
            "data":obj,
            'select': {
                'style': 'multi'
            }
        })
    }
});

});

