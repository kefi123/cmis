<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>userDetail</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/extra.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container-fluid" style="background-color:#f9f9f9 ">

        <div class="row" style="background-color: #21A2FC;width:90%;margin-left: 5%;">
            <div class="col-md-10 col-md-offset-1" style="background-color: #fff;margin-top: 30px;margin-bottom: 30px;border-radius: 5px;box-shadow: #3c3c3c">
                <div class="row">
                    <div class="col-md-2">
                        <img src="${udd.user.u_avatar!}" style="width:70px;height:70px;border-radius: 50%;margin-left: 20px;margin-top: 30px;">
                    </div>
                    <div class="col-md-3">
                        <h3>${udd.user.u_realname!}</h3>
                        <p>${udd.user.u_company!}${udd.user.u_position!}</p>
                        <p>${udd.pi.p_industry_name!}| ${udd.ci.c_industry_name!}</p>
                        <br>
                    </div>
                    <div class="col-md-2 col-md-offset-5" style="margin-top: 80px;">
                        <a href="#" class="btn btn-info">+加为好友</a>
                    </div>
                </div>

            </div>

        </div>

		<div class="row" style="width:90%;margin-left:5%;height:60px;">
			<h5 style="padding-top:20px;padding-left:10px;">他(她)的动态</h5>
		</div>

		<div class="row" style="width:90%;margin-left: 5%;">
            <div class="col-md-12 items" >
            	<!--遍历动态信息-->
            	<#list udd.dds as dd>
            
	                <div class="col-md-12 item">
	                    <div class="row">
	                        <div class="col-md-2">
	                            <img src="${dd.user.u_avatar}" class="img-circle img-responsive item-avatar" alt="avatar" />
	                        </div>
	                        <div class="col-md-10 item-detail">
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <span class="username">${dd.user.u_realname}</span><span class="userdetail">&nbsp;&nbsp;&nbsp;${dd.user.u_company}${dd.user.u_position}</span>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <span class="userdetail">${dd.user.u_mail}</span>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <p>${dd.dynamic.dynamic_content}</p>
	
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
										<#list dd.dynamicPic as pic>	                         
	                                    	<img src="${pic.dynamic_picture_path}" class="img-rounded img-responsive dt-img" />
	                                    </#list>
	                                </div>
	                            </div>
	                            <div class="row item-bottom">
	                                <div class="col-md-2">
	                                    <img src="images2/like_icon.png" class="img-responsive item-bottom-img" />
	                                    <span class="item-bottom-text">${dd.dynamic.like_number}</span>
	                                </div>
	                                <div class="col-md-2 col-md-offset-3">
	                                    <img src="images2/comment_icon.png" class="img-responsive item-bottom-img" />
	                                    <span class="item-bottom-text">${dd.dynamic.comment_number}</span>
	                                </div>
	                                <div class="col-md-2 col-md-offset-3">
	                                    <img src="images2/share_icon.png" class="img-responsive item-bottom-img" />
	                                    <span class="item-bottom-text">${dd.dynamic.forward_number}</span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
                </#list>
                
            </div>
        </div>
        
        <div class="row" style="background-color:#fff;height:70px;width:90%;margin-left: 5%;">
        	<p class="col-md-12" style="text-align:center;margin-top:50px;">到底了呦~~</p>
        </div>
    </div>

</body>
</html>