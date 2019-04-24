<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>注册界面</title>
<link rel="stylesheet" href="login/css/reset.css" />
<link rel="stylesheet" href="login/css/common.css" />
<link rel="stylesheet" href="login/css/font-awesome.min.css" />
</head>
<body>
	<div class="wrap login_wrap">
		<div class="content">

			<div class="logo"></div>

			<div class="login_box">

				<div class="login_form">
					<div class="login_title">注册</div>
					<form id="register" name="register" action="register" method="post" onsubmit="return validateForm()">

						<div class="form_text_ipt">
							<input name="us_name" type="text" placeholder="*用户名">
						</div>
						<div class="form_text_ipt">
							<input name="us_password" type="password" placeholder="*密码">
						</div>
						<div class="form_text_ipt" style="display:none;" id="mail">
							<input name="us_mail" type="text" placeholder="*邮箱">
						</div>
						<div class="form_text_ipt" style="display:none;" id="authcode">
							<input name="us_authcode" type="text" placeholder="*授权码">
						</div>
						<div class="form_check_ipt">
							<div class="left check_left">
								<label> <input onClick="dropMail()" type="radio" name="us_level" value="false"
									checked> 管理员</label> <label> <input onClick="inMail()" type="radio"
									name="us_level" value="true">用户</label> 
							</div>
						</div>
						<div class="form_btn">
							<button onclick="javascript:$("#register").submit();">注册</button>
						</div>
						<div class="form_reg_btn">
							<span>已有帐号？</span><a href="loginFtl">马上登录</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script src="login/js/jquery.min.js"></script>
	<script type="text/javascript">
	    //验证表单数据
		function validateForm(){
		  var us_name= document.forms["register"]["us_name"].value;
		  var us_password=document.forms["register"]["us_password"].value;
		  var us_mail=document.forms["register"]["us_mail"].value;
		  var us_authcode=document.forms["register"]["us_authcode"].value;
		  if (us_name==null || us_name=="")
		  {
		    alert("用户名必须填写");
		    return false;
		  }
		  if (us_password==null || us_password=="")
		  {
		    alert("密码必须填写");
		    return false;
		  }
		  if (us_mail==null || us_mail=="")
		  {
		    alert("邮箱必须填写");
		    return false;
		  }
		  if (us_authcode==null || us_authcode=="")
		  {
		    alert("授权码必须填写");
		    return false;
		  }
		}
		
		//点击用户时显示邮箱和授权码输入框
		function inMail(){
			document.getElementById("mail").style.display="";
			document.getElementById("authcode").style.display="";
		}
		//点击管理员时隐藏邮箱和授权码输入框
		function dropMail(){
			document.getElementById("mail").style.display="none";
			document.getElementById("authcode").style.display="none";
		}
	</script>
</body>
</html>
