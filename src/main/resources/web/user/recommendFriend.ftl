<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>推荐好友</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/extra.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid">
    	<!--遍历推荐好友-->
    	<#list scores as score>
	        <div class="row" id="item">
	            <div class="col-md-8 col-md-offset-2" style="border: 2px solid #eeeeee;border-radius: 5px;height: 250px;margin-top: 40px;margin-bottom: 10px;box-shadow: 3px 3px 3px rgba(0, 0, 255, .2);">
	                <div class="row" style="height: 125px;border-bottom: 1px solid #eeeeee;width: 90%;margin-left: 5%;">
	                    <div class="col-md-2 col-md-offset-1" style="margin-top: 25px;">
	                        <img src="${score.udd.user.u_avatar}" alt="" style="width: 90px;height: 90px;border-radius: 50%;">
	                    </div>
	                    <div class="col-md-7" style="margin-top:40px;">
	                        <span class="username">${score.udd.user.u_realname}</span>
	                        &nbsp;&nbsp;
	                        <span class="userdetail">${score.udd.user.u_company}${score.udd.user.u_position}</span><br>
	                        <#if score.udd.user.u_sex=true>
	                        	<span class="userdetail">男</span>
	                        <#else>
	                        	<span class="userdetail">女</span>
	                        </#if>
	                        &nbsp;.&nbsp;
	                        <span class="userdetail">${score.udd.pi.p_industry_name}&nbsp;${score.udd.ci.c_industry_name}<span><br>
	                        <span class="userdetail">${score.udd.user.u_mail}</span>
	                    </div>
	                    <div class="col-md-1" style="margin-top:80px;">
	                        <a href="#" class="btn btn-info">加为好友</a>
	                    </div>
	                </div>
	                <div class="row" style="height: 124px;width: 90%;margin-left: 5%;">
	                    <div class="col-md-10 col-md-offset-1" style="margin-top:30px;">
	                        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;您与
	                        	<span class="calculateText">${score.udd.user.u_realname!}</span>
	                        	有<span class="calculateText">${score.intersection!}</span>个共同好友，经过系统推算，您有
	                        	<span class="calculateText">${score.score}%</span>的概率和她成为好友，
	                        	如果考虑您共同好友的好友数，您有
	                        	<span class="calculateText">${score.wscore!}%</span>的概率和她成为好友，点击加为好友按钮，把他收为人脉吧。
	                        	
	                    </div>
	                </div>
	            </div>
	        </div>
		</#list>
    </div>

</body>
</html>