## 金融类网站首页

#### 使用

- bootstrap
- iscroll
- jquery
- art-template

#### 介绍

- 顶部通栏(topbar)

  + 使用栅格系统，通过媒体查询使其成为响应式布局，当屏幕屏幕宽度<sm(768px)时隐藏查找部分， 
  + navbar菜单栏，屏幕缩小后变成汉堡菜单，适配移动端

- 轮播图部分

  + 为了使轮播图响应屏幕使用大图和小图。屏幕较大时，将大图作为背景居中，设高配合background-size：cover；
  + 当屏幕小于768px时(判断为移动端)，此时大图的高度太高，改用小图。 为了实现大图小图的切换，通过封装函数监听页面`resize`事件，利用`art-template`渲染替换图片。 大屏时，大图用作背景图；小图时，用媒体查询去掉容器的高度，使用小图以图片的形式width:100%;
  + 封装touch移动端手势事件，使轮播图在移动端也可实现用户自由切换滑动

- 图标使用字体图标 1、轻量：比图片小，可以减少http请求 2、灵活，但只能设单色 3、兼容性好 `[class^="icon-"], [class*=" icon-"] { font-family: weijinsuo; font-style: normal; }`

  `.icon-mobilephone::before { content: "\e908"; font-size: 13px; }`

