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
<title>视频管理系统</title>

<link href="${pageContext.request.contextPath}/static/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

</head>

<body>

	<div class=" jumbotron" style="padding-left: 30px;">
		<p style="font-size: 32px;">编辑视频信息-视频管理</p>
	</div>
	<div>

		<form class="form-horizontal" method="post"
			action="${pageContext.request.contextPath}/admin/video/update.action">
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">视频标题</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputEmail3"
						name="videoTitle" value="${list.videoTitle }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">主讲人</label>
				<div class="col-sm-10">
					<select name="speaker.id" class="form-control">
						<option value="0">请选择主讲人</option>
						<c:forEach items="${speaker }" var="speaker">
							<option value="${speaker.id }" ${list.speaker.id==speaker.id?"selected":""}>${speaker.speakerName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="inputEmail3" class="col-sm-2 control-label">所属课程</label>
				<div class="col-sm-10">
					<select name="course.id" class="form-control">
						<option value="0">请选择课程</option>
						<c:forEach items="${course }" var="course">
							<option value="${course.id }" ${list.course.id==course.id?"selected":""}>${course.courseName }</option>
						</c:forEach>
					</select>
				</div>
			</div>

			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">视频时长</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						name="videoLength" value="${list.videoLength }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">封面图片</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						name="videoImageUrl" value="${list.videoImageUrl }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">视频播放地址</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="inputPassword3"
						name="videoUrl" value="${list.videoUrl }">
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">视频简介</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" name="videoDescr" >${list.videoDescr }</textarea>
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label"></label>
				<div class="col-sm-10">
					<input type="submit" class="btn btn-primary" value="保存" />
					<input type="hidden" name="id" value="${list.id }"> 
					<a class="btn btn-default" href="javascript:history.go(-1)"
						role="button">返回列表</a>
				</div>
			</div>

		</form>

	</div>

</body>

</html>