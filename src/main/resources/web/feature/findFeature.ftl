<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>find</title>
<script type="text/javascript"
	src="js/jquery-1.12.1.js"></script>
<!-- bootstrap的核心css包 -->
<link
	href="css/bootstrap.min.css"
	rel="stylesheet">
<!-- bootstrap的核心js包 -->
<script type="text/javascript"
	src="js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container">
		<form class="form"
			action="getFeatureByName?page=1&size=4"
			role="form" method="post">
			<div class="col-md-12">
				<h3 class="text-center">&nbsp;</h3>
				<br>
			</div>

			<div class="form-group col-md-12">
				<input type="text" class="form-control" placeholder="输入特征"
					name="fe_name" style="width: 400px; height: 40px; float: left">
				<button type="submit" class="btn btn-primary col-md-1"
					style="height: 40px; width: 100px">查询</button>
			</div>
		</form>
		<table class="table text-info" style="margin-top: 50px;">
			<thead>
				<tr>
					<th>特征编号</th>
					<th>特征</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody id="features">
				<#list pageInfos.list as feature>
					<tr>
						<td>${feature.fe_id}</td>
						<td>${feature.fe_name}</td>
						<td><a href='deleteFeature?fe_id=${feature.fe_id}' class='btn btn-info'>删除</a>
							&nbsp;&nbsp;&nbsp;&nbsp;
							<a href='getFeatureByID?fe_id=${feature.fe_id}' class='btn btn-info'>修改</a>
						</td>
					</tr>
				</#list>
			</tbody>
		</table>
		<nav aria-label="...">
		  <ul class="pager ">
		  	
		  	<#assign preClass="" preHref="#" lastClass="" lastHref="#" href=hrefs>
		  	
			<#if pageInfos.isFirstPage==true>
				<#assign preClass="disabled" lastHref="${href}?page=${pageInfos.nextPage}&size=${pageInfos.pageSize}">
			<#elseif pageInfos.isLastPage==true>
				<#assign preHref="${href}?page=${pageInfos.prePage}&size=${pageInfos.pageSize}" lastClass="disabled">
			<#else>
				<#assign preHref="${href}?page=${pageInfos.prePage}&size=${pageInfos.pageSize}"
					lastHref="${href}?page=${pageInfos.nextPage}&size=${pageInfos.pageSize}">
			</#if>
				<li><a class="${preClass}" href="${preHref}">上一页</a></li>
			    <li>${pageInfos.pageNum}/${pageInfos.pages}</li>
			    <li><a class="${lastClass}"  href="${lastHref}">下一页</a></li>
		  </ul>
		</nav>
	</div>
</body>
</html>