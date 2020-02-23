<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<style type="text/css">
.form-signin-heading {
	text-align: center;
	margin-top: 10%;
}

.admin-login {
	border-radius: 20px;
	background-color: #87CEEB;
	width: 20%;
	height: 220px;
	margin-left: 40%;
	margin-top: 2%;
}

.button {
	margin-left: 20%;
}

.reset {
	margin-left: 40px;
}

label {
	margin-top: 2%;
	margin-left: 10%;
}

.len {
	width: 80%;
	margin-left: 10%;
	margin-botttom: 20%;
}

.tip {
	margin-left: 40%;
	height: 11%;
}
</style>
 <title>adminLogin</title>
	 <script type="text/javascript">
	   function refresh(obj) {
	       obj.src = "imageServlet?"+Math.random();
	   }
	  </script>
</head>
<body>

	<form class="form-signin" action="admin?action=login" method="post">
		<h3 class="form-signin-heading">管理员登录</h3>
		<div class="admin-login">
			<div class="form-group">
				<label for="username" class="form-label">用户名</label> <input
					type="text" id="username" name="username" class="form-control len"
					value="${username}" />
			</div>
			<div class="form-group">
				<label for="password" class="form-label">密码</label> <input
					type="password" id="password" name="password"
					class="form-control len psd" />
			</div>
			<div class="form-group">
				<label for="varify" class="form-label">验证码</label>				        
                <input type="text" name="randomCode"/>
                <img title="点击更换" onclick="javascript:refresh(this);" src="imageServlet"><br/>
			</div>
			<div class="tip">
				<font color="red">${msg}</font>
			</div>
			<div class="button">
				<button type="submit" value="登录" class="btn btn-primary">登录</button>
				<button type="reset" value="重置 " class="btn reset">重置</button>
			</div>
		</div>


	</form>

</body>
</html>