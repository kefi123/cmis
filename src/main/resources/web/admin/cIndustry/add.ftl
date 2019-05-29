<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加二级行业信息</title>
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
		<div class="col-md-6 col-md-offset-3">
			<h3 class = "text-center">录入二级行业信息</h3><br>
			<form class="form" action="addCIndustry" role="form" method="post">
				<div class="form-group" style="margin-bottom:30px;">
                    <div class="col-md-12">
                        <!-- 第一个下来列表-->
					    <select class="form-control" name="p_industry_id">
					        <option value="">--请选择行业--</option>
					        <#if pIndustrys?exists> 
					            <#list pIndustrys as item>  
					                <option value="${item.p_industry_id?if_exists}">
					                    ${item.p_industry_name?if_exists}</option>
					            </#list> 
					        </#if> 
					    </select>
                    </div>
                </div>
                <div class="form-group"  style="margin-bottom:30px;">
                	<div class="col-md-12">
                		<input type="text" class="form-control" name="c_industry_name" >
                	</div>
                </div>
				<div class="modal-footer">
					<button type="submit" class="btn btn-primary">确定添加</button>
				</div>
			</form>
		</div>
		<div class="col-md-12">
			<#if status??>
				<#if status==true>
					<div class="alert alert-success" role="alert">
						<span style="margin-left: 75px;">添加成功</span>
					</div>
				<#else>
					<div></div>
				</#if>
			</#if>
		</div>
	</div>
</body>
</html>