<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=charset=utf-8">
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
	width: 28%;
	height: 240px;
	margin-left: 37%;
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

a {
	margin-left: 65%;
}

.tip {
	margin-left: 40%;
	height: 11%;
}
</style>
<title>注册</title>
</head>
<body>
	<div class="container">
		<form class="form-signin" action="user?action=register" method="post">
			<h3 class="form-signin-heading">用户注册</h3>
			<div class="admin-login">
				<div class="form-group">
					<label for="username" class="form-label">用户名</label> <input
						type="text" id="username" name="username" class="form-control len" />
				</div>
				<div class="form-group">
					<label for="password" class="form-label">密码</label> <input
						type="password" id="password" name="password"
						class="form-control len" />
				</div>
				<div class="form-group">
					<label for="password" class="form-label">确认密码</label> <input
						type="password" id="password2" name="password2"
						class="form-control len" />
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

		<form class="form-signin" action="user?action=register" method="post">
			<h2 class="form-singin-heading">用户注册</h2>
			<label for="username" class="sr-only" value="${username}">用户名</label>
			<input type="text" id="username" name="username" class="form-control" />
			<label for="nickname" class="sr-only">昵称</label> <input type="text"
				id="nickname" name="nickname" class="form-control" /> <label
				for="password" class="sr-only">密码</label> <input type="password"
				id="password" name="password" class="form-control" /> <label
				for="password2" class="sr-only">确认密码</label> <input type="password"
				id="password2" name="password2" class="form-control" /> <input
				type="submit" value="注册" /> <input type="reset" value="重置 " />
			<div>
				<font color="red">${msg}</font>
			</div>
		</form>
	</div>

</body>
</html>