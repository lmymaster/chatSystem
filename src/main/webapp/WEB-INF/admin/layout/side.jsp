 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="#" class="brand-link">
      <img src="${pageContext.request.contextPath}/static/default/images/logo.jpg" alt="AdminLTE Logo" class="brand-image img-circle "
           style="opacity: .8">
      <span class="brand-text font-weight-light">后台</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user panel (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
        <!-- 用户图片 -->
          <img src="${pageContext.request.contextPath}/static/default/${user.avatar}" class="img-circle" style="width:40px;height:40px" alt="User Image">
        </div>
        <div class="info">
          <a href="#" class="d-block">${user.username}<i class="fa fa-circle text-success"></i>管理员</a>
        </div>
      </div>

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
         <!--  <li class="nav-item has-treeview menu-open">
            <a href="#" class="nav-link active">
              <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                                            仪表盘
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="#" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Active Page</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="#" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Inactive Page</p>
                </a>
              </li>
            </ul>
          </li> -->
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/toadminmain" class="nav-link ">
             <i class="nav-icon fas fa-tachometer-alt"></i>
              <p>
                                            仪表盘
              </p>
            </a>
          </li>
         
             <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/comment/list" class="nav-link">
             <i class="nav-icon  far fa-comments"></i>
              <p>
                                            评论
              </p>
            </a>
          </li>
            <li class="nav-item">
            <a href="${pageContext.request.contextPath}/admin/topic/list" class="nav-link">
             <i class="nav-icon far fa-comment"></i>
              <p>
                                            话题
              </p>
            </a>
          </li>
            </li>
          <li class="nav-item">
            <a href="${pageContext.request.contextPath}/upmovies" class="nav-link">
             <i class="nav-icon fa fa-film" aria-hidden="true"></i>
              <p>
                                           上传影片
              </p>
            </a>
          </li>
        <li class="nav-item has-treeview menu-close">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-users" aria-hidden="true"></i>
              <p>
               用户
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/user/list" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>普通用户</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/user/adminlist" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>超级管理员</p>
                </a>
              </li>
            </ul>
        </li>
            <li class="nav-item has-treeview menu-close">
            <a href="#" class="nav-link ">
              <i class="nav-icon fas fa-cog " aria-hidden="true"></i>
              <p>
             系统设置
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/lunbo" class="nav-link active">
                  <i class="far fa-circle nav-icon"></i>
                  <p>轮播管理</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="${pageContext.request.contextPath}/admin/user/adminlist" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>公告管理</p>
                </a>
              </li>
            </ul>
        </li>
          <li class="nav-item">
        <a href="javascript:signout_confirm();" class="nav-link">
          <i class="nav-icon fas fa-tags"></i>
           <p>
                                           安全退出
              </p>
        </a>
      </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
  <script>
    function signout_confirm()
    {
        var r=confirm("确定退出?")
        if (r==true)
        {
            window.location.href="${pageContext.request.contextPath}/signout";
        }
        else
        {

        }
    }
    
</script>