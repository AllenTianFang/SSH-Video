<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Insert title here</title>
		<link href="${pageContext.request.contextPath }/static/css/bootstrap.min.css" rel="stylesheet">
		<script src="${pageContext.request.contextPath }/static/js/jquery-1.12.4.min.js"></script>
		<script src="${pageContext.request.contextPath }/static/js/bootstrap.min.js"></script>
		<style>
			.container-fluid{
				border: 0px solid black;
				margin-left: 20%;
				margin-right: 20%;
			}
		</style>
</head>
<body>
	<nav class="navbar navbar-inverse" style="margin-bottom: 0px;">
			<div class="container-fluid">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-9" aria-expanded="false"></button>
					<a class="navbar-brand" href="#">视频管理系统</a>
				</div>
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-9">
					<ul class="nav navbar-nav">
						<li ${param.fromJsp=="video" ? "class='active'" : "" }>
							<a  href="${pageContext.request.contextPath }/admin/video/video.action">视频管理</a>
						</li>
						<li ${param.fromJsp=="speaker" ? "class='active'" : "" }>
							<a   href="${pageContext.request.contextPath }/admin/speaker/speaker.action">主讲人管理</a>
						</li>
						<li ${param.fromJsp=="course" ? "class='active'" : "" }>
							<a   href="${pageContext.request.contextPath }/admin/course/course.action">课程管理</a>
						</li>
						<li ${param.fromJsp=="statistic" ? "class='active'" : "" }>
							<a  href="${pageContext.request.contextPath }/admin/statistic/statistic.action">统计分析</a>
						</li>
					</ul>
					<ul class="nav navbar-nav nav navbar-right">
						<li>
							<a href="#">${sessionScope.admin.loginName }</a>
						</li>
						<li>
							<a class="glyphicon glyphicon-log-in" href="${pageContext.request.contextPath }/admin/adminLogout.action"></a>
						</li>
					</ul>
				</div>
			</div>
		</nav>
		
</body>
</html>
