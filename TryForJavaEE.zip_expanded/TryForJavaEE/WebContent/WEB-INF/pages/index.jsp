<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script src="scripts/bootstrap.min.js"></script>

<title>主页</title>
</head>

<body>
	<div class="navbar navbar-fixed-top navbar-default">
		<div class="container">
			<div class="navbar-header">
				<a class="navba-brand" href="#">在线交流平台</a>
			</div>
			<div id="navbar" class="collapse navbar-collapse">
				<ul class="nav navbar-nav navbar-right" style="margin-top:15px;">
					<c:if test="${user==null}">
						<li><div>
								<i class="glyphicon glyphicon-log-in"></i> <a
									href="user?action=login">登录</a> <i
									class="glyphicon glyphicon-plus-sign"></i> <a
									href="user?action=register">注册</a> 
							</div></li>
					</c:if>
					<c:if test="${user!=null}">
					<li><div>
					<i class="glyphicon glyphicon-user"></i> 
					<a href="#">${user.nickname}</a>&nbsp;&nbsp;
					<i class="glyphicon glyphicon-off"></i> 
					<a href="user?action=logout">退出</a>
					</div></li>
					</c:if>
				</ul>
				<form class="navbar-form navbar-right" method="get" action="search">
					<div class="form-group">
						<input type="text" name="word" placeholder="请输入帖子的标题/作何/分类">
						<button type="submit" class="btn btn-primary">搜索</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="container" style="width: 100%; padding-top: 60px;">
		<form class="form-horizontal" action="topic?action=publish"
			method="post">
			<div class="modal fade bs-example-modal-lg" id="myModal"
				tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
				aria-hidden="true">
				<div class="modal-dialog modal-lg">

					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">&times;</button>
							<h4 class="modal-title" id="myModalLabel">发布新帖</h4>
						</div>
						<div class="modal-body">
							<div class="form-group">
								<label for="title" class="col-sm-1 control-label">标题</label>
								<div class="col-sm-11">
									<input type="text" class="form-control" name="title" id="title">
								</div>
							</div>

							<div class="form-group">
								<label for="tag" class="col-sm-1 control-label">分类</label>
 								<div class="col-sm-2">
						 			<select class="form-control" id="tag" name="tagId">
										<option value="0">无</option>
										<c:forEach var="tag" items="${tags}">
											<option value="${tag.id}">${tag.name}</option>										
										</c:forEach>									
									</select> 
								</div>
							</div>

							<div class="form-group">
								<label for="content" class="col-sm-1 control-label">正文</label>
								<div class="col-sm-11">
									<textarea class="form-control" name="content" rows="5"></textarea>
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-primary">发表</button>
							<button type="reset" class="btn btn-warning">清空</button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">关闭</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal -->
			</div>
		</form>
		<div class="container">
			<div class="row">
				<div class="col-md-11">
					<div class="dropdown">
						<button type="button" class="btn btn-default dropdown-toggle"
							data-toggle="dropdown">
							分类 <span class="caret"></span>
						</button>
						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
							<li><a href="#">全部</a></li>
							<c:forEach var="tag" items="${tags}">
								<li><a href="search?tagId=${tag.id}">${tag.name}</a></li>										
							</c:forEach>	
						</ul> 
					</div>
				</div>
				<div class="col-md-1">
					<button type="button" class="btn btn-success" data-trigger="focus"
						data-container="body" tabindex="0" data-toggle="popover"
						data-placement="top" data-content="请登录后发帖">新主题</button>
				</div>
			</div>
		</div>


		<div class="row">
			<table class="table table-hover">
				<thead class="row">
					<th class="col-md-5">
						<p>主题</p>
					</th>
					<th class="col-md-2">
						<p>分类</p>
					</th>
					<th class="col-md-2">
						<p>作者</p>
					</th>
					<th class="col-md-1">
						<p>回复数</p>
					</th>
					<th class="col-md-2">
						<p>发表时间</p>
					</th>

				</thead>
				<tbody>
				<c:forEach var="topic" items="${topics}">
				
					<tr>
						<td><a href="topic?id=${topic.id}">${topic.title}</a></td>
						<td><a href="search?tagId=${topic.tagId}">${topic.tagName}</a></td>
						 <td><p>${topic.nickname}</p></td>
						<td><p>${topic.replyCount}</p></td>
						<td><p>${fn:substring(topic.createTime,0,19)}</p></td>
					</tr>
				</c:forEach>
				<c:if test="${empty topics}">
				<tr><td>暂无数据</td></tr>
				</c:if>
				</tbody>
			</table>
		</div>
	</div>


	<nav aria-label="Page navigation">
	<ul class="pagination">
		<li><a href="#" aria-label="Previous"> <span
				aria-hidden="true">&laquo;</span>
		</a></li>
		<li><a href="#">1</a></li>
		<li><a href="#">2</a></li>
		<li><a href="#">3</a></li>
		<li><a href="#">4</a></li>
		<li><a href="#">5</a></li>
		<li><a href="#" aria-label="Next"> <span aria-hidden="true">&raquo;</span>
		</a></li>
	</ul>
	</nav>
	<footer>
	<p style="text-align: center">Copyright&nbsp;&nbsp;&nbsp;2017&nbsp;&nbsp;</p>
	</footer>
</body>

<script>
	var user = '${user}', msg = '${msg}';
</script>
<script src="scripts/checkLogin.js"></script>
</html>