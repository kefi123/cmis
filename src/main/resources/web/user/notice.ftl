<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>notice</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container-fluid" style="background-color: #f9f9f9">
    	<#list nds as nd>
	        <div class="row">
	            <div class="col-md-10 col-md-offset-1" style="background-color: #fff;margin-top: 50px;margin-bottom : 50px;height: 80px;box-shadow: #3c3c3c;border-radius: 5px;">
	                <div class="row">
	                    <span class="col-md-1" style="font-size: 18px;margin-top: 30px;color: #2aabd2;">通知:</span>
	                    <div class="col-md-1 col-md-offset-1" style="margin-top: 15px;">
	                        <img src="${nd.user.u_avatar!}" alt="" style="width: 50px;height: 50px;border-radius: 50%;">
	                    </div>
	                    <span class="col-md-6" style="font-size: 18px;margin-top: 20px;"><a href="#">${nd.user.u_realname!}</a>&nbsp.&nbsp向你发送了好友请求~~<br><span style="font-size:14px;color:#000">${nd.notice.notice_time!}</span></span>
	                    <#if nd.notice.status==0>
	                    	<a href="updateNoticeStatus?notice_id=${nd.notice.notice_id}&status=1&senduser_id=${nd.notice.senduser_id}&receiveuser_id=${nd.notice.receiveuser_id}" class="col-md-1 btn btn-info" style="margin-top: 30px;">同意</a>
	                    	<a href="updateNoticeStatus?notice_id=${nd.notice.notice_id}&status=2&senduser_id=${nd.notice.senduser_id}&receiveuser_id=${nd.notice.receiveuser_id}" class="col-md-1 col-md-offset-1 btn btn-info" style="margin-top: 30px;margin-left:5px;">拒绝</a>
	                    <#elseif nd.notice.status==1>
	                    	<span class="col-md-3" style="font-size: 18px;margin-top: 30px;color: #2aabd2;">状态：已同意</span>
	                    <#else>
	                    	<span class="col-md-3" style="font-size: 18px;margin-top: 30px;color: #2aabd2;">状态：已拒绝</span>
	                    </#if>
	                </div>
	            </div>
	        </div>
        </#list>
    </div>

</body>
</html>