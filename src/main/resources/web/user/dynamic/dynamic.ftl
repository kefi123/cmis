<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>发现</title>
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/extra.css">
    <link rel="stylesheet" type="text/css" href="css/webuploader.css">
    <script src="js/jquery-1.12.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/webuploader.js"></script>
</head>
<body style="background-color:#f9f9f9;">
    <div class="container excontainer">
    	<div class="row" style="background-color:#fff;border-bottom:1px solid #eeeeee;">
			<div class="col-md-10 col-md-offset-1">
				<h4 style="color:#2aabd2;margin-top:20px;">发布动态（发完刷新一下）~</h4>
    				<div class="form-group">
    					<textarea id="dynamic_content" name="dynamic_content" style="height:100px;" class="form-control" placeholder="说你所想..."></textarea>
    				</div>
    				<div class="form-group" style="margin-top:30px;">
						<!--webupload多图片预览上传-->
						<div id="fileList" name="fileList" class="uploader-list row"></div>
					    <div class="row">
					    	<div id="filePicker" class="col-md-3">选择图片(最多:2)</div>
    						<button id="release" name="release" class="btn btn-primary col-md-2 col-md-offset-7">发布</button>
					    </div>
    				</div>
    		</div>
    	</div>
        <div class="row">
            <div class="col-md-12 items" >
            	<!--遍历动态信息-->
            	<#list dds as dd>
            
	                <div class="col-md-12 item">
	                    <div class="row">
	                        <div class="col-md-2">
	                            <img src="${dd.user.u_avatar}" class="img-circle img-responsive item-avatar" alt="avatar" />
	                        </div>
	                        <div class="col-md-10 item-detail">
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <a href="userDetail?u_id=${dd.user.u_id}"><span class="username">${dd.user.u_realname}</span><span class="userdetail">&nbsp;&nbsp;&nbsp;${dd.user.u_company}${dd.user.u_position}</span></a>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <span class="userdetail">${dd.user.u_mail}</span>
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
	                                    <a href="dynamicDetail?dynamic_id=${dd.dynamic.dynamic_id}"><p>${dd.dynamic.dynamic_content}</p></a>
	
	                                </div>
	                            </div>
	                            <div class="row">
	                                <div class="col-md-12">
										<#list dd.dynamicPic as pic>	                         
	                                    	<img src="${pic.dynamic_picture_path}" class="img-rounded img-responsive dt-img" />
	                                    </#list>
	                                </div>
	                            </div>
	                            <div class="row item-bottom">
	                                <div class="col-md-2">
	                                    <img id="like_${dd.dynamic.dynamic_id}" onclick="like(this,'like_num_${dd.dynamic.dynamic_id}',${dd.dynamic.like_number})" src="images/like_icon.png" class="img-responsive item-bottom-img" />
	                                    <span id="like_num_${dd.dynamic.dynamic_id}" class="item-bottom-text">${dd.dynamic.like_number}</span>
	                                </div>
	                                <div class="col-md-2 col-md-offset-3">
	                                    <img src="images/comment_icon.png" class="img-responsive item-bottom-img" />
	                                    <span class="item-bottom-text">${dd.dynamic.comment_number}</span>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                </div>
                </#list>
                
            </div>
        </div>
        
        <div class="row" style="background-color:#fff;height:70px;">
        	<p class="col-md-12" style="text-align:center;margin-top:50px;">到底了呦~~</p>
        </div>
    </div>
    
    <!--WebUpload插件js代码部分-->
    <script>
    	jQuery(function() {
		    var $ = jQuery,
		        $list = $('#fileList'),
		        // 优化retina, 在retina下这个值是2
		        ratio = window.devicePixelRatio || 1,
		        // 缩略图大小
		        thumbnailWidth = 60,
		        thumbnailHeight = 60,
		        // Web Uploader实例
		        uploader;
		    // 初始化Web Uploader
		    uploader = WebUploader.create({
		        // 自动上传。
		        auto: false,
		        // swf文件路径
		        // swf文件路径
		        swf:  'js/Uploader.swf',
		        // 文件接收服务端。
		        server: 'http://localhost:8080/storageDynamicPic',
		        threads:'5',        //同时运行5个线程传输
		        fileNumLimit:'2',  //文件总数量只能选择10个，我们只需要一个，所以我选的1
		
		        // 选择文件的按钮。可选。
		        pick: {id:'#filePicker',  //选择文件的按钮
		            multiple:true},   //允许可以同时选择多个图片
		        // 图片质量，只有type为`image/jpeg`的时候才有效。
		        quality: 90,
		
		        //限制传输文件类型，accept可以不写
		        accept: {
		            title: 'Images',//描述
		            extensions: 'gif,jpg,jpeg,bmp,png',//类型
		            mimeTypes: 'image/*'//mime类型
		        }
		    });
		
		
		    // 当有文件添加进来的时候，创建img显示缩略图使用
		    uploader.on( 'fileQueued', function( file ) {
		        var $li = $(
		            '<div id="' + file.id + '" class="file-item thumbnail col-md-1">' +
		                '<img>' +
		                '<div class="info" style="color:#515151;font-size:12px;">' + file.name + '</div>' +
		            '</div>'
		            ),
		        $img = $li.find('img');
		
		        // $list为容器jQuery实例
		        $list.append( $li );
		
		        // 创建缩略图
		        // 如果为非图片文件，可以不用调用此方法。
		        // thumbnailWidth x thumbnailHeight 为 100 x 100
		        uploader.makeThumb( file, function( error, src ) {
		            if ( error ) {
		                $img.replaceWith('<span>不能预览</span>');
		                return;
		            }
		
		            $img.attr( 'src', src );
		        }, thumbnailWidth, thumbnailHeight );
		    });
		
			//点击发布按钮发布动态内容
			$("#release").click(function(){
				
				//点击发布时获取内容
				var content=$("#dynamic_content").val();
				
			    //通过Ajax把信息传到服务器
				$.ajax({
		            url: "storageDynamicContent",
		            type: "POST",
		            data: {
		            	dynamic_content:content
		            }
		        });
		        uploader.upload();   //执行手动提交
		        
		        //清空内容，记得每次发布完动态刷新一下
		        $("#dynamic_content").val("");
		        $("#fileList").empty();
		        
			});
		});
		
		function like(event,id,num){
			var src=event.src;
			if(src=="http://localhost:8080/images/like_icon.png"){
				event.src="images/my_like_icon.png";
				//通过Ajax把信息传到服务器
				$.ajax({
		            url: "like",
		            type: "POST",
		            data: {
		            	dynamic_id:event.id
		            },
		            success:function(data){
		            	$("#"+id).html(num+1);
		            }
		        });
			}
			else{
				event.src="images/like_icon.png";
				//通过Ajax把信息传到服务器
				$.ajax({
		            url: "unlike",
		            type: "POST",
		            data: {
		            	dynamic_id:event.id
		            },
		            success:function(data){
		            	$("#"+id).html(num);
		            }
		        });
			}
		};
    </script>
</body>
</html>