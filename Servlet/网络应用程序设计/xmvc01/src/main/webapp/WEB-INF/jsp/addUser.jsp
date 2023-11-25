<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户列表</title>
<link rel="stylesheet" type="text/css" media="screen"
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<ol class="breadcrumb">
			<li><a href="#">用户管理</a></li>
			<li class="active">用户添加</li>
			<li style="float:right">
			<a href="${base}/loginOut">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</ol>
		
		<!-- 主体内容开始 -->
	
			<!-- 表单开始 -->
			<form action="${pageContext.request.contextPath}/users/add" class="form-horizontal" id="commForm">
				<!-- 待编辑区 panel开始 -->
				<div class="panel panel-info">
					<div class="panel-heading">
						<i class="fa fa-pencil"></i>&nbsp;&nbsp;添加
					</div>
					<!-- panel-body开始 -->
					<div class="panel-body">

						<div class="form-group">
							<label for="userName" class="col-sm-3 control-label">用户名称</label>
							<div class="col-sm-5">
								<input type="text" class="form-control" id="userName"
									name="userName" placeholder="用户名称" value="${USER.userName}">
							</div>
						</div>

					<div class="form-group">
							<label for="password" class="col-sm-3 control-label">用户密码</label>
							<div class="col-sm-5">
								<input type="password" class="form-control" id="password"
									name="password" placeholder="用户密码" value="${USER.password}">
							</div>
						</div>
						
						
					</div>
					<!-- panel-body结束 -->
					<!-- panel-footer开始 -->
					<div class="panel-footer text-right">
						<button type="button" name="returnBtn" class="btn btn-default"
							id="returnBtn" onclick="location.href='${pageContext.request.contextPath}/users/index'">返回</button>
						<button type="reset" name="resetBtn" id="resetBtn"
							class="btn btn-warning">重置</button>
						<button type="submit" name="submitBtn" class="btn btn-primary"
							id="submitBtn">提交</button>
					</div>
					<!-- panel-footer结束 -->
				</div>
				<!-- 待编辑区panel结束 -->
			</form>
			<!--表单结束 -->
	</div>
</body>
<script>
	// 在JSP文件中获取后端传递的错误信息
	var errorMessage = "${errorMessage}";

	// 如果错误信息不为空，则显示弹窗
	if (errorMessage) {
		alert(errorMessage);
	}

</script>
</html>