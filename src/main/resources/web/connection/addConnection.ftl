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
			<h3 class = "text-center">人脉的录入</h3><br>
					<form class="form-horizontal" action="addConnection" role="form" method="post">
						<div class="form-group">
						    <div class="col-sm-6"> 
						      	<input type="text" class="form-control" name="co_name"
								placeholder="姓名">
							</div>
							<div class="col-sm-6">
								<input type="text" class="form-control" placeholder="电话"
									name="co_phone">
						    </div>
						 </div>
						 <div class="form-group">
							<div class="radio col-sm-3">
								<label> <input type="radio" name="co_sex" value="0"
									checked> 男</label> <label> <input type="radio"
									name="co_sex" value="1">女</label> 
							</div>
							<div class="col-sm-9">
								<input type="text" class="form-control" placeholder="邮箱"
										name="co_mail">
							</div>
						</div>
						<div class="form-group">
							<div class="checkbox col-md-12">
							  	<label class="checkbox-inline">
								  <input type="checkbox" name="co_feature" value="内向型 "> 内向型 
								</label>
								<label class="checkbox-inline">
								  <input type="checkbox" name="co_feature" value="外向型"> 外向型
								</label>
								<label class="checkbox-inline">
								  <input type="checkbox" name="co_feature" value="幽默型"> 幽默型
								</label>
								<label class="checkbox-inline">
								  <input type="checkbox" name="co_feature" value="阳光开朗"> 阳光开朗
								</label>
								<label class="checkbox-inline">
								  <input type="checkbox" name="co_feature" value="其他"> 其他
								</label>
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-12">
								<input type="text" class="form-control" placeholder="地址"
									name="co_address">
							</div>
						</div>
						
						<textarea name="co_remarks" placeholder="备注" class="form-control" rows="3"></textarea>
						
						<div class="modal-footer">
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
							<button type="submit" class="btn btn-primary">确定添加</button>
						</div>
					</form>
		</div>
		<div class="col-md-12">
			<!--判断添加的状态-->
			<!--??两个问号判断status是否为空-->
			<#if status??>
				<!--用一个等号判断是否相等-->
				<#if status=true>
					<div class="alert alert-success" role="alert">
						<span style="margin-left: 75px;">添加成功</span>
					</div>
				<#else>
					<div class="alert alert-danger" role="alert">
						<span style="margin-left: 75px;">添加失败</span>
					</div>
				</#if>
			<#else>
				<div></div>
			</#if>
		</div>
	</div>
</body>
</html>