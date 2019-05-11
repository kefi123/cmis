<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>recommend</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/extra.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid" style="background-color: #f9f9f9">
    <div class="row">
        <span class="col-md-10 col-md-offset-1" style="font-size: 18px;margin-top: 50px;">好友列表：</span>
    </div>
    
    <#list users as user>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="row" style="margin-top: 10px;margin-bottom: 5px;background-color: #fff;margin-top: 30px;margin-bottom: 15px;height: 80px;border-radius: 5px;">
			        <div class="col-md-1 col-md-offset-1" style="margin-top: 15px;">
			            <img src="${user.u_avatar!}" alt="" style="width: 50px;height: 50px;border-radius: 50%;">
			        </div>
			        <div class="col-md-5" style="margin-top: 15px;">
			            <a href="userDetail?u_id=${user.u_id}">
			            	<span class="username">${user.u_realname!}</span><br>
			            	<span class="userdetail">${user.u_company!}${user.u_position}</span>
			       		</a>
			        </div>
			        <div class="col-md-5" style="margin-top: 20px;">
			            <span>你们于2019-10-01&nbsp;15:31:00成为好友</span><br>
			            <span>现在已经10天了！</span>
			        </div>
			    </div>
			</div>
		</div>
	</#list>
	
</div>
</body>
</html>