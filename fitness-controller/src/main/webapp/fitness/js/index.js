$(function(){
    //获取渲染轮播图数据
    render();
    //移动端滑动产品页签
    // moblieScrollTab();

    $("[data-toggle='tooltip']").tooltip();
});

var getData = function (callback){
    //通过判断是否有缓存防止重复请求获取数据
    //由模板引擎根据isMoblie决定渲染哪种格式图片
    if(window.data){
        callback && callback(window.data);
    }else{
        $.ajax({
            url: 'json/data.json',
            type:'get',
            dataType:'json',
            success:function (data){
                //缓存数据到window
                window.data = data;
                callback && callback(window.data);
            }
        })
    }

};

var render = function (){
    getData(function (data){
        //获取页面宽度，判断使用哪种图片
        var isMoblie = $(window).width() < 768 ? true : false;
        // 获取模板引擎渲染数据
        var points = template('carousel-point',{list:data});
        var images = template('carousel-inner',{list:data,isM:isMoblie});
        //将获取的数据插入到轮播图标签
        $(".carousel-indicators").html(points);
        $(".carousel-inner").html(images);
    })
};

$(window).on('resize',function(){
   render();
});

//移动端手势
var startX = 0; //触碰时x值
var distX = 0;  //滑动距离x值
var isMove = false; //判断是否滑动
$(".wjs_banner").on('touchstart',function(e){
    //jquery将原生touchEvent封装在originalEvent里了
    startX = e.originalEvent.touches[0].clientX;

}).on('touchmove',function(e){
    var moveX = e.originalEvent.touches[0].clientX;
    distX = moveX - startX;
    isMove = true;

}).on('touchend',function(){
    if(!isMove) return;
    if(isMove && Math.abs(distX)>40){
        if(distX > 0){
            $('.carousel').carousel('prev');
        }else{
            $('.carousel').carousel('next');
        }
    }
    //重置参数
    startX = 0;
    distX = 0;
    isMove = false;
});

/*var moblieScrollTab = function (){
    var tabBox = $('.tab_box');
    var tabLi = tabBox.find('li');
    //设置获取所有li的宽度
    var getWidth = 0;
    tabLi.each(function(i,item){
        $currentLi = $(this);
        getWidth += $currentLi.outerWidth(true);
    });
    //将宽度赋予页签父盒子
    tabBox.find('ul').width(getWidth);
    new IScroll(document.querySelector('.tab_box'),{
        scrollX:true,
        scrollY:false,
        click:true
    })
};*/

$("#enroll").click(function () {
   var info = {};
   info["name"] = $("input[name='userName']").val();
   info["psd"] = $("input[name='userPsd']").val();
   console.log(info);
    $.ajax({
        type: "GET",//请求方式
        url: "js/course.json",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        data:{
          info:info
        },
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
            debugger;
            console.log(xhr);
        }
    });
});