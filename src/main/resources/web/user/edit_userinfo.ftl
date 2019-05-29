<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>edit_info</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/edit-info-extra.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container-fluid container-extra">
        <div class="row">
            <div class="col-md-8 col-md-offset-2" style="background-color: #ffffff;margin-top: 50px;margin-bottom: 50px;">
                <div name="display" id="display">
                    <div class="row">
                        <div class="col-md-4" style="margin-top: 5px;"> 
                        	<h4 style="color:#2aabd2;">基本信息</h4>
                        </div>
                        <div id="editBtn" name="editBtn" class="col-md-2 col-md-offset-6" style="text-align: right; margin-top: 13px;">
                            <span class="glyphicon glyphicon-pencil">编辑</span>
                        </div>
                    </div>

                    <dl>
                        <div class="row" style="margin-top: 30px;">
                            <div class="col-md-6">
                                <dd class="info-dd">
                                    <label class="info-lable">真实姓名：</label>
                                    <span class="info-span">${ulogined.u_realname!} </span>
                                </dd>
                                <dd class="info-dd">
                                    <label class="info-lable">您的性别：</label>
                                    <#if ulogined.u_sex??>
	                                    <#if ulogined.u_sex==true>
	                                    	<span class="info-span">男</span>
	                                    <#else>
	                                    	<span class="info-span">女</span>
	                                    </#if> 
                                    </#if>
                                    
                                </dd>
                                <dd class="info-dd">
                                    <label class="info-lable"> 您的邮箱：</label>
                                    <span class="info-span">${ulogined.u_mail!}</span>
                                </dd>
                                <dd class="info-dd">
                                    <label class="info-lable" >行业方向：</label>
                                    <#if pIndustry??>
                                    	<span class="info-span">${pIndustry.p_industry_name!}</span>
                                    </#if>
                                    <#if cIndustry??>
                                    	<span style="margin-left: 3px;">${cIndustry.c_industry_name!}</span>
                                    </#if>
                                </dd>
                                <dd class="info-dd">
                                    <label class="info-lable">当前公司：</label>
                                    <span class="info-span">${ulogined.u_company!}</span>
                                </dd>
                                <dd class="info-dd">
                                    <label class="info-lable"> 当前职位：</label>
                                    <span class="info-span">${ulogined.u_position!}</span>
                                </dd>
                                
                            </div>
                            <div class="col-md-4 col-md-offset-2" style="margin-top: 20px;">
                                <dt>
                                    <img style="width: 141px;height: 141px;border-radius: 50%;border: 6px solid #e4e4e4;" src="${ulogined.u_avatar}" alt="avatar">
                                </dt>
                            </div>
                        </div>

                    </dl>
                </div>

                <div name="edit" id="edit" style="display: none;">
                    <h4 style="color: #2aabd2;">基本信息</h4>
                    <div class="row" style="margin-top: 35px;">
                        <div class="col-md-9">
                            <form action="updateUser" class="form-horizontal">
                                <div class="form-group">
                                    <label for="u_realname" class="sr-only">真实姓名</label>
                                    <div class="col-md-6">
                                        <input value="${ulogined.u_realname!}" class="form-control" placeholder="真实姓名" type="text" id="u_realname" name="u_realname">
                                    </div>
                                    <div class="col-md-4">
                                    	<#if ulogined.u_sex??>
	                                    	<#if ulogined.u_sex==false>
		                                    	<label class="radio-inline">
		                                            <input type="radio" name="u_sex" id="u_sex" value="1" > 男
		                                        </label>
		                                        <label class="radio-inline">
		                                            <input type="radio" name="u_sex" id="u_sex" value="0" checked> 女
		                                        </label>
		                                    <#else>
		                               			<label class="radio-inline">
		                                            <input type="radio" name="u_sex" id="u_sex" value="1" checked> 男
		                                        </label>
		                                        <label class="radio-inline">
		                                            <input type="radio" name="u_sex" id="u_sex" value="0"> 女
		                                        </label>
		                                    </#if>
		                                <#else>
	                               			<label class="radio-inline">
	                                            <input type="radio" name="u_sex" id="u_sex" value="1" checked> 男
	                                        </label>
	                                        <label class="radio-inline">
	                                            <input type="radio" name="u_sex" id="u_sex" value="0"> 女
	                                        </label>
	                                    </#if>
                                        
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="" class="sr-only"></label>
                                    <div class="col-md-12">
                                        <input name="u_mail" value="${ulogined.u_mail!}" type="text" class="form-control" placeholder="E-mail">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <div class="col-md-6">
                                        <!-- 第一个下来列表-->
									    <select class="form-control" name="p_industry_id" id="p_industry_id" onchange="getchilds()">
									        <option value="">--请选择行业--</option>
									        <#if pIndustrys?exists> 
									            <#list pIndustrys as item>  
									                <option value="${item.p_industry_id?if_exists}">
									                    ${item.p_industry_name?if_exists}</option>
									            </#list> 
									        </#if> 
									    </select>
                                    </div>
                                    <div class="col-md-6">
                                        <!--第二个下拉列表-->
									    <select class="form-control" id="c_industry_id" name="c_industry_id">
									        <option value="">--请选择行业方向--</option>
									    </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="" class="sr-only"></label>
                                    <div class="col-md-12">
                                        <input name="u_company" value="${ulogined.u_company!}" type="text" class="form-control" placeholder="当前公司">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="" class="sr-only"></label>
                                    <div class="col-md-12">
                                        <input name="u_position" value="${ulogined.u_position!}" type="text" class="form-control" placeholder="当前职位">
                                    </div>
                                </div>
                                <div class="form-group" style="margin-left: 1px;">
                                    <button class="btn btn-info col-md-2" type="submit">保存</button>
                                    <button id="cancelBtn" class="btn btn-info col-md-2 col-md-offset-1" type="reset">取消</button>
                                </div>
                            </form>
                        </div>
                        <div class="col-md-3">
                            <img src="${ulogined.u_avatar}" alt="avatar" style="width: 100px;height: 100px;margin-top: 20px;margin-left: 5px;">
                            <form class="form" action="uploadAvatar" enctype="multipart/form-data" method="post">
		                        <div class="form-group">
		                            <label for="" class="sr-only">upload</label>
		                            <div style="width: 100px;margin-left: 5px;">
		                                <input name="file" type="file" class="form-control"> 
		                           </div>
		                        </div>
		                        <button type="submit" class="btn btn-info btn-sm" style="width:100px;margin-left: 5px;" >上传</button>
                            <form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script>
    	$(document).ready(
		    function(){
		        $("#editBtn").click(function () {
	                $("#display").hide();
	                $("#edit").show();
	                <#if ulogined.p_industry_id??>
		                $("#p_industry_id").val("${ulogined.p_industry_id}");
		                getchilds();
	               	</#if>
		        });
		        $("#cancelBtn").click(
		            function () {
		                $("#display").show();
		                $("#edit").hide();
		            }
		        );
			        
			}
		);
		
		function getchilds() {
		    //获取第一个下拉列表的值
		    var pid=$("#p_industry_id").val();
		    var obj=document.getElementById("c_industry_id");
		    obj.options.length=1;//第一个下拉列表不管选哪个，第二个下拉列表都应该首先显示第一个
		    if (pid!=null){
		        //通过Ajax获取childs的数据
		        $.ajax({
		            type : 'GET',
		            contentType : 'application/json',
		            url : 'p2c?p_industry_id='+pid,
		            dataType : 'json',
		            success : function(data) {
		                $.each(data,function(i,item) {
		                    if(item.c_industry_id==${ulogined.c_industry_id})
		                    	$("#c_industry_id").append("<option selected = 'selected' value='"+item.c_industry_id+"'>"+item.c_industry_name+"</option>");
		                    else
		                    	$("#c_industry_id").append("<option value='"+item.c_industry_id+"'>"+item.c_industry_name+"</option>");
		                });
		            }
		        });
		    }
		}
    </script>
</body>
</html>