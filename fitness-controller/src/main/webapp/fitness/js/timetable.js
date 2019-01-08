var courseList = [
    ['', '', '', '', '', '', '马甲线基础塑性', '', '', '', '', ''],
    ['', '', '', '', '背部训练', '', '', '', '', '', '', ''],
    ['', '', '', '', '', '', '瑜伽养生课程', '', '', '', '', ''],
    ['', '', '', '', '', '', '', '', '', '', '', ''],
    ['', '', '', '', '', '', '', '', '核心力量训练', '', '', ''],
];
/*$(document).ready(function () {
    $.ajax({
        type: "GET",//请求方式
        url: "js/course.json",//地址，就是json文件的请求路径
        dataType: "json",//数据类型可以为 text xml json  script  jsonp
        beforeSend: ()=>{console.log("开始")}, //加载执行方法
        error: (error)=>{console.log("错误",error)},  //错误执行方法
        success: function (xhr) {
            debugger;
            console.log(xhr);
        }
    });
});*/


var week = window.innerWidth > 360 ? ['周一', '周二', '周三', '周四', '周五'] :
    ['一', '二', '三', '四', '五'];
var day = new Date().getDay();
var courseType = [
    [{index: '1', name: '8:30'}, 1],
    [{index: '2', name: '9:30'}, 1],
    [{index: '3', name: '10:30'}, 1],
    [{index: '4', name: '11:30'}, 1],
    [{index: '5', name: '12:30'}, 1],
    [{index: '6', name: '14:30'}, 1],
    [{index: '7', name: '15:30'}, 1],
    [{index: '8', name: '16:30'}, 1],
    [{index: '9', name: '17:30'}, 1],
    [{index: '10', name: '18:30'}, 1],
    [{index: '11', name: '19:30'}, 1],
    [{index: '12', name: '20:30'}, 1]
];
// 实例化(初始化课表)
var Timetable = new Timetables({
    el: '#coursesTable',
    timetables: courseList,
    week: week,
    timetableType: courseType,
    highlightWeek: day,
    gridOnClick: function (e) {
        alert(e.name + '  ' + e.week + ', 第' + e.index + '节课, 课长' + e.length + '节');
        console.log(e);
    },
    styles: {
        Gheight: 50
    }
});