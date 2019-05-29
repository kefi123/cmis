<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>left</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.12.1.js"></script>
<script type="text/javascript" src="js/menu.js"></script>
<!-- bootstrap的核心css包 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src="js/bootstrap.min.js"></script>
</head>

<body>

    <div class="left_menu">
        <ul id="nav_dot">
            <li>
                <a style = "text-decoration : none" href = 'notice' target = "mainAction" class = "M1">
                    <h4 class="M1">
                        <span></span>通知
                    </h4>
                </a>
            </li>
            <li>
                <a style = "text-decoration : none" href = 'dynamic' target = "mainAction" class = "M1">
                    <h4 class="M1">
                        <span></span>发现
                    </h4>
                </a>
            </li>
            <li>
                <a style = "text-decoration : none" href = 'myFriends' target = "mainAction" class = "M1">
                    <h4 class="M1">
                        <span></span>我的好友
                    </h4>
                </a>
            </li>
            <li>
                <a style = "text-decoration : none" href = 'recommendFriend' target = "mainAction" class = "M1">
                    <h4 class="M1">
                        <span></span>智能推荐
                    </h4>
                </a>
            </li>
            <li>
                <h4 class="M1">
                    <span></span>我的邮箱
                </h4>
                <div class="list-item none">
                    <a href='getMailFriends' target="mainAction">导入邮箱好友</a>
                    <a href='getMf' target="mainAction">我的邮箱好友</a>
                    <a href='toMFGraph' target="mainAction">查看联络图</a>
                </div>
            </li>
        </ul>
    </div>
    <script>
        navList(12);
    </script>
</body>
</html>
