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
                <h4 class="M1">
                    <span></span>一级行业信息管理
                </h4>
                <div class="list-item none">
                    <a href='addPIndustryFtl' target="mainAction">添加一级行业信息</a>
                    <a href='getPIndustry?page=1&size=4' target="mainAction">查询一级行业信息</a>
                </div>
            </li>
            <li>
                <h4 class="M1">
                    <span></span>二级行业信息管理
                </h4>
                <div class="list-item none">
                    <a href='addCIndustryFtl' target="mainAction">添加二级行业信息</a>
                    <a href='getCIndustry?page=1&size=4' target="mainAction">查询二级行业信息</a>
                </div>
            </li>
            <li>
                <h4 class="M1">
                    <span></span>用户管理
                </h4>
                <div class="list-item none">
                    <a href='getUsers?page=1&size=4' target="mainAction">查询用户信息</a>
                </div>
            </li>
        </ul>
    </div>
    <script>
        navList(12);
    </script>
</body>
</html>
