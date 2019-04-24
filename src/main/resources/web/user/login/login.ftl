<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>登录界面</title>
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
					<div class="login_title">登录</div>
					<form id="logIn" action="login" method="post">

						<div class="form_text_ipt">
							<input name="us_name" type="text" placeholder="用户名">
						</div>
						<div class="ececk_warning">
							<span>用户名不能为空</span>
						</div>
						<div class="form_text_ipt">
							<input name="us_password" type="password" placeholder="密码">
						</div>
						<div class="ececk_warning">
							<span>密码不能为空</span>
						</div>
						<div class="form_check_ipt">
							<div class="left check_left">
								<label> <input type="radio" name="us_level" value="0"
									checked> 管理员</label> <label> <input type="radio"
									name="us_level" value="1" checked>用户</label> 
							</div>
							<div class="right check_right">
								<a href="#">忘记密码</a>
							</div>
						</div>
						<div class="form_btn">
							<button onclick="javascript:$("#logIn").submit();">登录</button>
						</div>
						<div class="form_reg_btn">
							<span>还没有帐号?</span><a href="registerFtl">马上注册</a>
							<span>还没有帐号?</span><a href="registerFtl">马上注册</a>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="login/js/jquery.min.js"></script>
</body>
</html>
