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
                <a style = "text-decoration : none" href = 'began' target = "mainAction" class = "M1">
                    <h4 class="M1">
                        <span></span>首页
                    </h4>
                </a>
            </li>
			<#if ulogined.us_level=false>
                <li>
                    <h4 class="M2">
                        <span></span>特征管理
                    </h4>
                    <div class="list-item none">
                        <a href='addFeature' target="mainAction">添加特征</a>
                        <a href='getFeature?page=1&size=4' target="mainAction">查询特征</a>
                    </div>
                </li>
                <li>
                    <h4 class="M2">
                        <span></span>策略管理
                    </h4>
                    <div class="list-item none">
                        <a href='addStrategyFtl' target="mainAction">添加策略</a>
                        <a href='getStrategy?page=1&size=4' target="mainAction">查询策略</a>
                    </div>
                </li>  
                <li>
                    <h4 class="M2">
                        <span></span>话题管理
                    </h4>
                    <div class="list-item none">
                        <a href='addTopicFtl' target="mainAction">添加话题</a>
                        <a href='getTopic?page=1&size=4' target="mainAction">查询话题</a>
                    </div>
                </li>
            <#else>
                <li>
                    <h4 class="M1">
                        <span></span>人脉管理
                    </h4>
                    <div class="list-item none">
                        <a href='addConnectionFtl' target="mainAction">添加人脉</a>
                        <a href='getConnection?page=1&size=4' target="mainAction">查询人脉</a>
                        <a href='exConFtl' target="mainAction">拓展人脉</a>
                    </div>
                </li>
                <li>
                    <a style = "text-decoration : none" href = 'test' target = "mainAction" class = "M1">
                        <h4 class="M1">
                            <span></span>发现
                        </h4>
                    </a>
                </li>
                <li>
                    <a style = "text-decoration : none" href = 'conGraph2' target = "mainAction" class = "M1">
                        <h4 class="M1">
                            <span></span>人脉关系网
                        </h4>
                    </a>
                </li>
                <li>
                    <a style = "text-decoration : none" href = 'getDate' target = "mainAction" class = "M1">
                        <h4 class="M1">
                            <span></span>日程管理
                        </h4>
                    </a>
                </li>
                <li>
                    <a style = "text-decoration : none" href = '#' target = "" class = "M1">
                        <h4 class="M1">
                            <span></span>更新人脉信息
                        </h4>
                    </a>
                </li>
          </#if>
        </ul>
    </div>
    <script>
        navList(12);
    </script>
</body>
</html>
