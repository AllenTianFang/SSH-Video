<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>登录系统</title>

<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>

<body>
	<div
		style="align-content: center; height: 300px; width: 300px; margin: 300px auto;">
		<img src="${pageContext.request.contextPath}/static/img/logo.png" />

		<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/login.action" method="post">

			<div class="form-group">

				<input type="text" class="form-control" name="loginName" placeholder="用户名" value="admin">

			</div>

			<div class="form-group">

				<input type="password" class="form-control" name="loginPwd" placeholder="登录密码" value="admin">

			</div>
			
			<div class="form-group">

                <span>${result }</span>
                
			</div>

			<div class="form-group">

				<input type="submit" class="btn btn-success btn-lg btn-block"
					value="登录" />

			</div>

		</form>

	</div>

</body>

</html>