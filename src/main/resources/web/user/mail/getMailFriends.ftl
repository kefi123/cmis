<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>getMailFriend</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.12.1.js"> </script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container-fluid" style="background-color: #f9f9f9">
        <div class="row">
            <div class="col-md-10 col-md-offset-1" style="border: 1px solid #eeeeee;background-color: #fff;margin-top: 30px;margin-bottom: 10px;">
                <form class="form-horizontal" action="addMailFriends">
                    <div class="form-group">
                    	<#list mfs as mf>
	                        <div class="col-sm-4">
	                            <div class="checkbox">
	                                <label>
	                                    <input name="mf_mail" type="checkbox" value="${mf.mf_mail}"> ${mf.mf_name}
	                                </label>
	                            </div>
	                        </div>
                        </#list>
                    </div>
                    <div class="form-group">
                    	<button type="submit" class="btn btn-info col-sm-4 col-sm-offset-4">导入数据</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>