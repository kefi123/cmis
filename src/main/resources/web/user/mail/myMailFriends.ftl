<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>myMailFriend</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

<div class="container-fluid" style="background-color: #f9f9f9">
    <div class="row">
        <span class="col-md-10 col-md-offset-1" style="font-size: 18px;margin-top: 50px;">邮箱好友列表：</span>
    </div>
    
    <#list mfs as mf>
		<div class="row">
			<div class="col-md-10 col-md-offset-1">
				<div class="row" style="margin-top: 8px;margin-bottom: 2px;background-color: #fff;height: 50px;border-radius: 5px;">
			        <div class="col-md-6 col-md-offset-1" style="margin-top: 15px;">
			            <span>${mf.mf_name}(${mf.mf_mail})</span>
			        </div>
			        <div class="col-md-2" style="margin-top: 15px;">
			            <span>已联系${mf.mf_num}次</span>
			        </div>
			        <div class="col-md-2 col-md-offset-1" style="margin-top: 10px;">
			            <a href="#" class="btn btn-info">邀请使用</a> 
			        </div>
			    </div>
			</div>
		</div>
	</#list>
	
</div>
</body>
</html>