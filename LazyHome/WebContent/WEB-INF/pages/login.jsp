<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Creative - Bootstrap 3 Responsive Admin Template">
    <meta name="author" content="GeeksLabs">
    <meta name="keyword" content="Creative, Dashboard, Admin, Template, Theme, Bootstrap, Responsive, Retina, Minimal">
    <link rel="shortcut icon" href="img/favicon.png">


    <title>Login Page 2 | Creative - Bootstrap 3 Responsive Admin Template</title>

    <!-- Bootstrap CSS -->    
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="css/elegant-icons-style.css" rel="stylesheet" />
    <link href="css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="css/style.css" rel="stylesheet">
    <link href="css/style-responsive.css" rel="stylesheet" />
        <style>
        .verimg{
            margin-top: 20px;
        }
        .btn-log{
            font-size: 14px;
            border-radius: 80px;
            margin-top: 2%;           
            margin-left: 10%;
            width:25%;
        }
        .btn-reg{
            font-size: 14px;
            border-radius: 80px;
            margin-top: 2%;           
            margin-left: 25%;
            width:25%;
        }

    </style>
    <!-- HTML5 shim and Respond.js IE8 support of HTML5 -->
    <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
    <script src="js/respond.min.js"></script>
    <![endif]-->
</head>

  <body class="login-img3-body">

    <div class="container">

      <form class="login-form" action="index.html">        
        <div class="login-wrap">
            <div class="form-group">
                <label for="nickname">用户名</label>
                <input type="text" class="form-control" placeholder="邮箱" name="user_count" >
            </div>
            <div class="form-group">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="psd" placeholder="请输入密码" name="pwd" >
            </div>
            <div class="form-group" id="container">
                <label for="identify">验证码</label>
                <input type="text" class="form-control" id="identify" placeholder="请输入验证码" name="verify">
                <img src="__CONTROLLER__/verifyImg" onclick="this.src=this.src+'__CONTROLLER__/verifyImg'+Math.random()" class="verimg">
            </div>
            <label class="checkbox">
                <input type="checkbox" value="remember-me"> Remember me
                <span class="pull-right"> <a href="#"> Forgot Password?</a></span>
            </label>
            <button type="submit" class="btn btn-info btn-log" value="登陆">登录</button>
            <button type="button" class="btn btn-info btn-reg" value="注册">注册</button>     
        </div>
      </form>

    </div>


  </body>
</html>
