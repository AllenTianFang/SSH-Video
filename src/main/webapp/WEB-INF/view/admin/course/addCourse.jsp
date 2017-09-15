<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html lang="zh-CN">

<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>视频管理系统</title>

<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css" rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>

<body>

	<div class=" jumbotron" style="padding-left: 30px;">
		<p style="font-size: 32px;">编辑课程-课程管理</p>
	</div>
	<div>

		<form class="form-horizontal" action="${pageContext.request.contextPath}/admin/course/add.action" method="post">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">所属学科</label>
				<div class="col-sm-10">
					<select name="sub.id" class="form-control">
						<option value="">请选择所属学科</option>
						<c:forEach items="${subject }" var="subject">
						<option value="${subject.id }">${subject.subjectName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">标题</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3" name="courseName"
						placeholder="课程标题">
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" name="courseDescr"></textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label"></label>
				<div class="col-sm-10">
					<input type="submit" class="btn btn-primary" value="保存" /> <a
						class="btn btn-default" href="javascript:history.go(-1)"
						role="button">返回列表</a>
				</div>
			</div>

		</form>

	</div>

</body>

</html>