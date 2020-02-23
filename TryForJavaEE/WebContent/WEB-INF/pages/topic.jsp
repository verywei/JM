<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<style>
html, body {
	overflow-x: hidden;
	padding-top: 7px;
}
</style>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="navbar navbar-fixed-top navbar-default">
		<div id="navbar" class="collapse navbar-collapse">
			<ul class="nav navbar-nav navbar-right" style="margin-top: 15px;">
				<c:choose>
					<c:when test="${user==null}">
						<li>
							<div>

								<i class="glyphicon glyphicon-log-in"></i> <a
									href="user?action=login">登录</a> <i
									class="glyphicon glyphicon-plus-sign"></i> <a
									href="user?action=register">注册</a>
							</div>
						</li>
					</c:when>
					<c:otherwise>
						<li><div>
								<i class="glyphicon glyphicon-user"></i> <a href="#">${user.nickname}</a>&nbsp;&nbsp;
								<i class="glyphicon glyphicon-off"></i> <a
									href="user?action=logout">注销</a>
							</div></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<form class="navbar-form navbar-right" method="get" action="search">
				<div class="form-group">
					<input type="text" name="word" placeholder="请输入帖子的标题/作何/分类">
					<button type="submit" class="btn btn-primary">搜索</button>
				</div>
			</form>
		</div>
	</div>

	<form class="form-horizontal" action="reply?action=reply" method="post">
		<input type="hidden" name="topicId" value="${topic.id}"> 
		<div class="modal fade bs-example-modal-lg" id="myModal" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-lg">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">&times;</button>
						<h4 class="modal-title" id="myModalLabel">发表回复</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">
							<div class="col-sm-12">
								<textarea class="form-control" name="content" rows="5"></textarea>
							</div>
						</div>
					</div>
					<div class="modal-footer">
						<button type="submit" class="btn btn-primary">发表</button>
						<button type="reset" class="btn btn-warning">清空</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal -->
		</div>
	</form>

	<div class="container" style="margin-top: 50px;">
		<div class="row">
			<div class="col-md-10">
				<h3>${topic.title}</h3>
			</div>
			<div class="col-md-2 text-right">
				<div class="btn-group" role="group" aria-lable="...">
					<a href="#" class="btn btn-primary">收藏本帖</a>
					<button type="button" class="btn btn-success" data-trigger="focus"
						data-container="body" tabindex="0" data-toggle="popover"
						data-placement="top" data-content="请登录后回复">快速回帖</button>
				</div>
			</div>
		</div>
		<div class="row">
			<table class="table table-hover">
				<tbody>
					<tr>
						<td>
							<div class="row">
								<div class="col-md-2 text-center">
									<img src="${topic.imgUrl}" width="140px" ;height="100px"
										class="img-thumbnail" />
									<h5>${topic.nickname}</h5>
								</div>
								<div class="col-md-10">
									<div class="row text-right">
										<div class="col-sm-offset-9 col-sm-3">
											<span class="label label-danger">楼主</span> <span
												class="label label-default">${fn:substring(topic.createTime,0,19)}</span>
										</div>
									</div>
									<div class="row col-sm-12">
										<!--正文  -->
										${topic.content}
									</div>
								</div>
							</div>
						</td>
					</tr>
					<c:forEach var="reply" items="${replys}" varStatus="status">

						<tr>
							<td>
								<div class="row">
									<div class="col-md-2 text-center">
										<img src="${reply.imgUrl}" width="140px" ;height="100px"
											class="img-thumbnail" />
										<h5>${reply.nickName}</h5>
									</div>
									<div class="col-md-10">
										<div class="row text-right">
											<div class="col-sm-offset-9 col-sm-3">
												<span class="label label-danger">${status.count}楼</span> <span
													class="label label-default">${fn:substring(reply.createTime,0,19)}</span>
											</div>
										</div>
										<div class="row col-sm-12">
											<!--正文  -->
											${reply.content}
										</div>
									</div>
								</div>
							</td>
						</tr>
					</c:forEach>

				</tbody>

			</table>
		</div>

		<div class="row col-sm-12">
			<form class="form-horizontal" action="reply?action=reply" method="post">
				<input type="hidden" name="topicId" value="${topic.id}"> 
				<h4>发表回复</h4>
				<div class="form-group">
					<div class="col-sm-12">
						<textarea class="form-control" name="content" rows="5"></textarea>
					</div>
				</div>
				<button type="submit" class="btn btn-primary">发表</button>
				<button type="reset" class="btn btn-warning">清空</button>
			</form>
		</div>
	</div>

</body>
<script>
	var user = '${user}', msg = '${msg}';
</script>
<script src="scripts/checkLogin.js"></script>
</html>