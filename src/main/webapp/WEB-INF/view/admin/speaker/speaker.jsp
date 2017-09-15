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
<script src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="${pageContext.request.contextPath}/static/js/bootstrap.min.js"></script>

<script type="text/javascript">
/* function deleteSpeaker(the){
	$("#url").val(the.name);
	$('#deleteModal').modal();
} */

function deleteSpeaker(the){
$.confirm({
    title: '提示',
    content: '你确定删除吗?',
    buttons: {
    	确认: function () {
    		$.get(
	        		"${pageContext.request.contextPath}/admin/speaker/deleteSpeaker.action",
	        		{"id":the.name},
	        		function(msg){
	        			if(msg == "success"){
	        				location.reload();
	        			}
	        		},
	        	    "json"
	        	
	        	);
        },
                  取消: function () {
        }
        
    }
});
}






</script>

</head>

<body>
   <jsp:include page="/WEB-INF/view/admin/header.jsp">
   <jsp:param value="speaker" name="fromJsp"/>
   </jsp:include>
  <div class="container">
	<div class="jumbotron" style="padding-left: 30px;">
		<p style="font-size: 32px;">主讲人列表-主讲人管理</p>
	</div>
	<div>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin/speaker/addSpeaker.action"
			role="button">添加主讲人</a>

		<form class="form-inline" style="float: right;"
			action="${pageContext.request.contextPath}/admin/speaker/speaker.action"
			method="post">
			<div class="form-group">
				<label for="exampleInputName2">名称</label> <input type="text"
					name="speaker_name" value="${speaker_name }" class="form-control"
					id="exampleInputName2" placeholder="主讲人名称">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail2">职位</label> <input type="text"
					name="speaker_job" value="${speaker_job }" class="form-control"
					id="exampleInputEmail2" placeholder="主讲人职位">
			</div>
			<button type="submit" class="btn btn-primary">查询</button>
		</form>

		<table class="table table-hover">
			<thead>
				<tr>
					<th>序号</th>
					<th>名称</th>
					<th>职位</th>
					<th width="70%">简介</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${page.rows }" varStatus="status" var="li">
					<tr>
						<th scope="row">${status.count }</th>
						<td>${li.speakerName }</td>
						<td>${li.speakerJob }</td>
						<td>${li.speakerDescr }</td>
						<td><a class="glyphicon glyphicon-edit"
							href="${pageContext.request.contextPath}/admin/speaker/updateSpeaker.action?id=${li.id}"></a></td>
						<td><a class="glyphicon glyphicon-trash deleteId"
							name="${li.id}"
							onclick="deleteSpeaker(this)"></a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<zyz:page
			url="${pageContext.request.contextPath}/admin/speaker/speaker.action"></zyz:page>
		<%-- <%@include file="/modal.jsp"%> --%>

	</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-confirm.js"></script>
<link href="${pageContext.request.contextPath}/static/css/jquery-confirm.css" rel="stylesheet">
</html>