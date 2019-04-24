<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>head</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/head-extra.css">
    <script src="js/jquery-1.12.1.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>

    <div class="container-fluid container-extra">
        <div class="row">
            <div class="col-md-3">
                <img src="images/logo.png" class="logo" alt="logo">
            </div>
            <div class="col-md-3 col-md-offset-6 head-right">
                 <img src="${ulogined.u_avatar}"  class="avatar" alt="avatar">
                 <span>${ulogined.u_name} </span>
                 <a href="edit_userinfo" target="mainAction" class="btn btn-default btn-sm" style="margin-left:10px;">编辑资料</a>
                 <a href="#" class="btn btn-primary btn-sm" style="margin-left:10px;">退出</a>
            </div>
        </div>
    </div>

</body>
</html>