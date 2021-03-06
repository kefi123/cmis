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
				action="updateCIndustry?c_industry_id=${cIndustry.c_industry_id}"
				role="form" method="post">
				<div class="form-group" style="margin-bottom:30px;">
                	<div class="col-md-12">
                        <!-- 第一个下来列表-->
					    <select class="form-control" name="p_industry_id" value="${cIndustry.p_industry_id}">
					        <option value="">--请选择行业--</option>
					        <#if pIndustrys?exists> 
					            <#list pIndustrys as item>
					            	<#if item.p_industry_id=cIndustry.p_industry_id>
										<option value="${item.p_industry_id?if_exists}" selected = "selected">
					                    	${item.p_industry_name?if_exists}</option>	            	
					            	<#else>
					            		<option value="${item.p_industry_id?if_exists}">
					                    	${item.p_industry_name?if_exists}</option>
					            	</#if>  
					            </#list> 
					        </#if> 
					    </select>
                    </div>
                </div>
                <div class="form-group"  style="margin-bottom:30px;">
                	<div class="col-md-12">
                		<input type="text" class="form-control" name="c_industry_name" value="${cIndustry.c_industry_name}">
                	</div>
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