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
			<li class="active">用户列表</li>
			<li style="float:right">
			<a href="${base}/loginOut">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;</li>
		</ol>
		
		<!-- 主体内容开始 -->
			<!-- 第一行开始 -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
				<!-- 表单开始 -->
				<form action="${pageContext.request.contextPath}/users/index" class="form-horizontal">
					<!-- panel开始 -->
					<div class="panel panel-info">
						<div class="panel-heading"><i class="fa fa-search"></i>&nbsp;&nbsp;查询</div>
						<!-- panel-body开始 -->
						<div class="panel-body">
							
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-5 col-lg-5 ">
										<div class="form-group">
											<label for="userName" class="col-sm-3 control-label">用户名</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="userName" name="userName"
													   value="${keyword}" placeholder="用户名">
											</div>
										</div>
										
									</div>

								</div>

						</div>
						<!-- panel-body结束 -->
						<div class="panel-footer text-right">
							<button type="reset" name="resetBtn" id="resetBtn"
								class="btn btn-warning">重置</button>
							<input type="submit" value="查询" class="btn btn-primary"></input>
							<button type="button" name="addBtn" class="btn btn-info"
								 onclick="location.href='${pageContext.request.contextPath}/users/preAdd'">添加用户</button>
						</div>
					</div>
					<!-- panel结束 -->
					</form>
					<!--表单结束 -->
				</div>

			</div>
			<!-- 第一行结束 -->
		
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-primary">
					<div class="panel-heading">用户列表</div>
					<table class="table table-bordered table-hover text-center">
						<thead>
							<tr class="info">
								<td>用户名称</td>
								<td>用户密码</td>
								<td>操作</td>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="u" items="${userList}">
								<tr>
									<td>${u.userName}</td>
									<td>${u.password}</td>
									<td>
										<button type="button" name="queryBtn" class="btn btn-success btn-xs" 
										onclick="location.href='${pageContext.request.contextPath}/users/editPage?id=${u.id }'">更新</button>|
										<button type="button" name="queryBtn" class="btn btn-danger btn-xs"
										onclick="location.href='${pageContext.request.contextPath}/users/delete?id=${u.id }'">删除</button>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>

				</div>
			</div>

		</div>

	</div>
</body>
</html>