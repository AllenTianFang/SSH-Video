<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="zyz" uri="http://zhiyou100.com/common/"%>
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
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>
<script type="text/javascript">
function deleteCourse(the) {


	 $.confirm({
				title : '提示',
				content : '你确定删除吗?',
				buttons : {
					确认 : function() {

						
								$.get(
										"${pageContext.request.contextPath}/admin/course/deleteCourse.action",
										{
											"id" : the.name
										}, function(msg) {
											if (msg == "success") {
												location.reload();
											}
										}, "json"

								);
					},
					取消 : function() {
					}

				}
			}); 
	 
}
</script>

</head>

<body>
	<jsp:include page="/WEB-INF/view/admin/header.jsp">
		<jsp:param value="course" name="fromJsp" />
	</jsp:include>
	<div class="container">
		<div class=" jumbotron" style="padding-left: 30px;">
			<p style="font-size: 32px;">课程列表-课程管理</p>
		</div>
		<div>
			<a class="btn btn-primary"
				href="${pageContext.request.contextPath}/admin/course/addCourse.action"
				role="button">添加课程</a>

			<table class="table table-hover">
				<thead>
					<tr>
						<th>序号</th>
						<th>标题</th>
						<th>学科</th>
						<th width="70%">简介</th>
						<th>编辑</th>
						<th>删除</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${page.rows }" varStatus="status" var="li">
						<tr>
							<th scope="row">${status.count }</th>
							<td>${li.courseName }</td>
							<td>${li.sub.subjectName }</td>
							<td>${li.courseDescr }</td>
							<td><a class="glyphicon glyphicon-edit"
								href="${pageContext.request.contextPath}/admin/course/updateCourse.action?id=${li.id}"></a></td>
							<td><a class="glyphicon glyphicon-trash"
								onclick="deleteCourse(this)" name="${li.id}"></a></td>

						</tr>
					</c:forEach>
				</tbody>
			</table>
			<zyz:page
				url="${pageContext.request.contextPath}/admin/course/course.action"></zyz:page>
			<%-- <%@include file="/modal.jsp"%> --%>
		</div>
	</div>
</body>


<script type="text/javascript"
	src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<link href="${pageContext.request.contextPath}/static/css/jquery-confirm.css"
	rel="stylesheet">
<script src="${pageContext.request.contextPath}/static/js/jquery-confirm.js"></script>
</html>