<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
		<div class="navbar navbar-fixed-top navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navba-brand" href="#">在线交流平台</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right" style="margin-top:15px;">
					<c:if test="${admin==null}">
						<li><div>
								<i class="glyphicon glyphicon-log-in"></i> <a
									href="user?action=login">登录</a> <i
									class="glyphicon glyphicon-plus-sign"></i> <a
									href="user?action=register">注册</a> 
							</div></li>
					</c:if>
					<c:if test="${admin!=null}">
					<li><div>
					<i class="glyphicon glyphicon-user"></i> 
					<a href="#">${admin.nickname}</a>&nbsp;&nbsp;
					<i class="glyphicon glyphicon-off"></i> 
					<a href="admin?action=logout">退出</a>
					</div></li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<div class="container" style="margin-top:200px;">
	这是管理员主页</div>
</body>
</html>