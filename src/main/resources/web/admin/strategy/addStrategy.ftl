<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add</title>
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
			<h3 class = "text-center">录入策略</h3><br>
					<form class="form"
				action="addStrategy"
				role="form" method="post">
				<div class="checkbox">
					<label class="checkbox-inline">
						<input type="checkbox" name="st_feature" value="内向型 "> 内向型 
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="st_feature" value="外向型"> 外向型
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="st_feature" value="幽默型"> 幽默型
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="st_feature" value="阳光开朗"> 阳光开朗
					</label>
					<label class="checkbox-inline">
						<input type="checkbox" name="st_feature" value="其他"> 其他
					</label>
				</div>
				<textarea name="st_content" placeholder="内容" class="form-control" rows="3"></textarea>

				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="submit" class="btn btn-primary">确定添加</button>
				</div>
			</form>
		</div>
		<div class="col-md-12">
			<#if status==true>
				<div class="alert alert-success" role="alert">
					<span style="margin-left: 75px;">添加成功</span>
				</div>
			<#else>
				<div></div>
			</#if>
		</div>
	</div>
</body>
</html>