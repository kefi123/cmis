<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>admin_login</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/jquery-1.12.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
    <div class="container-fluid" style="background-color: #fcfcfc">
        <div class="row">
            <div class="col-md-6 col-md-offset-3" style="background-color: #fff;margin-top: 50px;margin-bottom: 100px;">
                <div class="row" style="margin-top: 150px;"> <h3 class="col-md-6 col-md-offset-4">后台管理系统</h3></div>
                <form action="adminLogin" class="form-horizontal" style="margin-top: 50px;">
                    <div class="form-group">
                        <label for="admin_name" class="control-label col-md-2 col-md-offset-2">账号：</label>
                        <div class="col-md-6">
                            <input id="admin_name" name="admin_name" type="text" class="form-control" placeholder="请输入账号">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="admin_password" class="control-label col-md-2 col-md-offset-2">密码：</label>
                        <div class="col-md-6">
                            <input id="admin_password" name="admin_password" type="password" class="form-control" placeholder="请输入密码">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-info" style="width: 307px;margin-top: 30px;margin-left: 230px;">登录</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>