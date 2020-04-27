<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="layout/header.jsp"%>
  <!-- 主要内容 -->
  <div class="content-wrapper">
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0 text-dark">仪表盘</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">仪表盘</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->

    <!-- Main content -->
    <div class="content">
      <div class="container-fluid">
        <div class="row">
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-green">
					<div class="inner">
						<h3>${topic_count}</h3>

						<p>今天新增话题数</p>
					</div>
					<div class="icon">
						<i class="fas fa-chart-line"></i>
					</div>
					<a href="${pageContext.request.contextPath}/admin/topic/list" class="small-box-footer">更多 <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>
			</div>
			
			<!-- ./col -->
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-yellow">
					<div class="inner">
						<h3>${comment_count}</h3>
						<p>今天新增评论数</p>
					</div>
					<div class="icon">
						<i class="fas fa-chart-pie"></i>
					</div>
					<a href="${pageContext.request.contextPath}/admin/comment/list" class="small-box-footer">更多 <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>
			</div>
			<!-- ./col -->
			<div class="col-lg-4 col-xs-6">
				<!-- small box -->
				<div class="small-box bg-red">
					<div class="inner">
						<h3>${user_count}</h3>

						<p>今天新增用户数</p>
					</div>
					<div class="icon">
						<i class="fas fa-user-plus"></i>
					</div>
					<a href="${pageContext.request.contextPath}/admin/user/list" class="small-box-footer">更多 <i
						class="fa fa-arrow-circle-right"></i></a>
				</div>
			</div>
			<!-- ./col -->
		</div>
        <!-- /.row -->
      </div><!-- /.container-fluid -->
      
    </div>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->

  <!-- Control Sidebar -->
  <aside class="control-sidebar control-sidebar-dark">
    <!-- Control sidebar content goes here -->
    <div class="p-3">
      <h5>Title</h5>
      <p>Sidebar content</p>
    </div>
  </aside>
<%@ include file="layout/footer.jsp"%>
