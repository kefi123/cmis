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
					<form class="form-horizontal"
						action="updateConnection?co_id=${connection.co_id}"
						role="form" method="post">
						<div class="form-group">
						    <div class="col-sm-6">
						      	<input type="text" class="form-control" name="co_name" value="${connection.co_name!}"
								placeholder="姓名">
							</div>
							<div class="col-sm-6">
								<input type="text" class="form-control" placeholder="电话"
									name="co_phone" value="${connection.co_phone!}">
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
										name="co_mail" value="${connection.co_mail!}">
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
								<input type="text" class="form-control" placeholder="地址" value="${connection.co_address!}"
									name="co_address">
							</div>
						</div>
						
						<textarea name="co_remarks" placeholder="备注" class="form-control" rows="3">${connection.co_remarks!}</textarea>
						
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