<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>动态详情页面</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/extra.css">
    <script src="js/jquery-1.12.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body style="background-color:#f9f9f9;">
    <div class="container excontainer">
        <div class="row">
            <div class="col-md-12 items" >
                <div class="col-md-12 item">
                    <div class="row">
                        <div class="col-md-2">
                            <img src="${dd.user.u_avatar!}" class="img-circle img-responsive item-avatar" alt="avatar" />
                        </div>
                        <div class="col-md-10 item-detail">
                            <div class="row">
                                <div class="col-md-12">
                                    <span class="username">${dd.user.u_realname!}</span><span class="userdetail">&nbsp;&nbsp;&nbsp;${dd.user.u_company!}${dd.user.u_position!}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <span class="userdetail">${dd.user.u_mail!}</span>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-12">
                                    <p>${dd.dynamic.dynamic_content!}</p>

                                </div>
                            </div>
                            <div class="row" style=";margin-bottom:50px;">
                                <div class="col-md-12">
									<#list dd.dynamicPic as pic>	                         
                                    	<img src="${pic.dynamic_picture_path!}" class="img-rounded img-responsive dt-img" />
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        
        <!--评论-->
        <div class="row" style="background-color:#fff">
            <div class="col-md-10 col-md-offset-1">
                <!--开始展示评论，一行一条-->
                
                <#list dd.cds as cd>
	                <div class="row" style="margin-top:30px;margin-bottom:30px;border-bottom:1px solid #eeeeee;height:100px;">
	                    <div class="col-md-1">
	                        <img src="${cd.user.u_avatar!}" alt="" style="width: 35px;height: 35px;border-radius: 50%;">
	                    </div>
	                    <div class="col-md-9">
	                        <span class="userdetail">${cd.user.u_realname!}</span><span class="userdetail">&nbsp.&nbsp${cd.user.u_company!}</span><span class="userdetail">${cd.user.u_position!}</span><br>
	                        <span>${cd.comment.comment_content}</span><br>
	                        <a href="#">回复</a>
	                    </div>
	                    <div class="col-md-1">
	                        <img class="img-responsive item-bottom-img" src="images2/like_icon.png"  alt="">
	                        <span>${cd.comment.comment_like_number!}</span>
	                    </div>
	                </div>
                </#list>
                
            </div>

        </div>
        
        <div class="row" style="background-color:#fff;border-bottom:1px solid #eeeeee;">
			<div class="col-md-10 col-md-offset-1" style="margin-top:30px;margin-bottom:30px;">
				<form role="form" method="post" class="form" action="storageDynamicComment?dynamic_id=${dd.dynamic.dynamic_id}&u_id=${ulogined.u_id}">
					<div class="form-group">
						<textarea  name="comment_content" id="comment_content" style="height:100px;" class="form-control" placeholder="说你所想..."></textarea>
					</div>
					<div class="form-group" style="margin-top:30px;">
						<button type="submit"  name="release" class="btn btn-primary col-md-2 col-md-offset-10">评论</button>
					</div>
				</form>
    		</div>
        </div>
    </div>
    
</body>
</html>