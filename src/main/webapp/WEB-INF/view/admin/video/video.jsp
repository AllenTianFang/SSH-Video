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
function deleteVideo(the){
	$.confirm({
	    title: '提示',
	    content: '你确定删除吗?',
	    buttons: {
	    	确认: function () {
	        	$.get(
	        		"${pageContext.request.contextPath}/admin/video/deleteVideo.action",
	        		{"id":the.name},
	        		function(msg){
	        			if(msg == "success"){
	        				alert(111);
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

 $(function(){
	 var num = 0;
	 var nu = 0;
	 var arr = new Array();
	  $("#selectAll").click(function(){
			$(".select").each(function(index,dom){
				dom.checked = $("#selectAll")[0].checked;
			});
			if(this.checked){
				num = $(".select").size();
				$("#deleteCount").html(num);
			}else{
				num = 0;
				$("#deleteCount").html(num);
			}
		});
	 
	 $(".select").click(function(){
		 if(this.checked){
			 num++;
			 $("#deleteCount").html(num);
		 }else{
			 num--;
			 $("#deleteCount").html(num);
		 }
		 if(num != $(".select").size()){
			 $("#selectAll").prop("checked",false);
		 }else{
			 $("#selectAll").prop("checked",true);
		 }
	 });
	 
	 $("#multidelete").click(function(){
		 if(num == 0){
			 $.alert({
				    title: '警告',
				    content: '请先选择要删除的数据!',
				});
		 }else{
			 $.confirm({
				    title: '提示',
				    content: '你确定删除吗?',
				    buttons: {
				    	确认: function () {
				        	$("#formId").submit();
				        },
				                  取消: function () {
				        }
				        
				    }
				});
		 }
	 });
	 
	 
	 /* $("#multidelete").click(function(){
		 $(".select").each(function(index,dom){
			 if(dom.checked){
				 arr[nu] = dom.value;
				 nu++;
			 }
		 });
		 if(nu !=0 ){
			 $("#url").val("${pageContext.request.contextPath}/video/multiDeleteVideo.action?idArr="+arr);
			 $('#deleteModal').modal();
		} 
	 }); */
 });
 
	/* 
	$(function(){
		var $a = $(".checkbox-inline select").each(function(){});
		$a = $("#inlineCheckbox1").prop("checked");
		$("#deleteCount").text($(input:checked));
	}) */
	
	/* var num = 0;
	function selectAll(the) {
		var arr = document.getElementsByName("check");
		for (var i = 0; i < arr.length; i++) {
			arr[i].checked = the.checked;
		}
		if (the.checked) {
			num = arr.length;
			document.getElementById("deleteCount").innerHTML = num;
		} else {
			num = 0;
			document.getElementById("deleteCount").innerHTML = num;
		}
	}
	function deleteSingle(the) {
		if (the.checked) {
			num++;
			document.getElementById("deleteCount").innerHTML = num;
		} else {
			num--;
			document.getElementById("deleteCount").innerHTML = num;
		}
	}
	function multiDelete() {
		var arr1 = document.getElementsByName("check");
		var arr2 = new Array();
		var nu = 0;
		for (var i = 0; i < arr1.length; i++) {
			if (arr1[i].checked) {
				arr2[nu] = arr1[i].id;
				nu++;
			}
		}
		if (nu != 0) {
			if (confirm("确定删除" + nu + "条数据")) {
				document.location = "multiDeleteVideo.action?idArr=" + arr2;
			}
		}
	} */
</script>

</head>

<body>

<jsp:include page="/WEB-INF/view/admin/header.jsp">
		<jsp:param value="video" name="fromJsp" />
	</jsp:include>
	<div class="container">

	<div class=" jumbotron" style="padding-left: 30px;">
		<p style="font-size: 32px;">视频列表-视频管理</p>
	</div>
	<div>
		<a class="btn btn-primary"
			href="${pageContext.request.contextPath}/admin/video/addVideo.action">添加视频</a>
		<a class="btn btn-primary" id="multidelete" href="#" >批量删除<span
			id="deleteCount" class="badge">0</span></a>

		<form class="form-inline" style="float: right;"
			action="${pageContext.request.contextPath}/admin/video/video.action"
			method="get">
			<div class="form-group">
				<label class="sr-only" for="exampleInputEmail3">视频标题</label> <input
					type="text" class="form-control" id="exampleInputEmail3"
					name="video_title" placeholder="视频标题" value="${title }">
			</div>
			<div class="form-group">
				<label class="sr-only" for="exampleInputPassword3">主讲人</label> <select
					name="speaker_id" class="form-control">
					<option value="0">请选择主讲人</option>
					<c:forEach items="${speaker }" var="speaker">
						<option value="${speaker.id }" ${sid==speaker.id?"selected":""}>${speaker.speakerName }</option>
					</c:forEach>
				</select>
			</div>
			<div class="form-group">
				<label class="sr-only" for="exampleInputPassword3">课程</label> <select
					name="course_id" class="form-control">
					<option value="0">请选择课程</option>
					<c:forEach items="${course }" var="course">
						<option value="${course.id }" ${cid==course.id?"selected":""}>${course.courseName }</option>
					</c:forEach>
				</select>
			</div>

			<input type="submit" class="btn btn-primary" value="查询" />
		</form>
         <form action="${pageContext.request.contextPath}/admin/video/multiDeleteVideo.action" id="formId">
		<table class="table table-hover">
			<thead>
				<tr>
					<th><label class="checkbox-inline"> <input
							type="checkbox" id="selectAll" value="option1"
							> 序号
					</label></th>
					<th>名称</th>
					<th width="60%">介绍</th>
					<th>讲师</th>
					<th>课程</th>
					<th>时长(秒)</th>
					<th>播放次数</th>
					<th>编辑</th>
					<th>删除</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${page.rows }" varStatus="status" var="li">
					<tr>
						<th scope="row"><label class="checkbox-inline"> <input
								type="checkbox" value="${li.id }" class="select" name="check"
								> ${status.count }
						</label></th>
						<td>${li.videoTitle }</td>
						<td>${li.videoDescr }</td>
						<th>${li.speaker.speakerName }</th>
						<th>${li.course.courseName }</th>
						<th>${li.videoLength }</th>
						<th>${li.videoPlayTimes }</th>
						<td><a class="glyphicon glyphicon-edit"
							href="${pageContext.request.contextPath}/admin/video/updateVideo.action?id=${li.id}"></a></td>
						<td><a class="glyphicon glyphicon-trash" name="${li.id}"
							onclick="deleteVideo(this)"
							></a></td>
					</tr>
                  </c:forEach>
              </tbody>
		</table>
		</form> 
		<zyz:page url="${pageContext.request.contextPath}/admin/video/video.action"></zyz:page>
		<%-- <%@include file="/modal.jsp" %> --%>
	</div>
</div>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/static/js/jquery-1.12.4.min.js"></script>
<script src="${pageContext.request.contextPath}/static/js/jquery-confirm.js"></script>
<link href="${pageContext.request.contextPath}/static/css/jquery-confirm.css" rel="stylesheet">
</html>