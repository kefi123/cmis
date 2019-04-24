<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
<!-- 使用validate第一步，导入js库 -->
<script type="text/javascript" src = "js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript" src = "js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div style= "height:100px"></div>
		<div class="col-xs-6 col-md-offset-3">
			<h3 class = "text-center">更新</h3><br>
					<form class="form"
						action="updateFeature?fe_id=${feature.fe_id}"
						role="form" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="fe_name"
								 value="${feature.fe_name}">
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">更新</button>
						</div>
					</form>
		</div>
	</div>
</body>
</html>