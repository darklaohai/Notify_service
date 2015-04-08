 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
 <%@ page import="com.jodo.notify.util.UrlUtil" %>
 <%@ include file="header.jsp" %> 

<!--main-container-part-->
<div id="content">
<!--breadcrumbs-->
  <div id="content-header">
    <div id="breadcrumb"> <a href="index.html" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a></div>
  </div>
<!--End-breadcrumbs-->

<!--Action boxes-->
  <div class="container-fluid">
    <div class="quick-actions_homepage">
      <ul class="quick-actions">
        <li class="bg_lb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=group"> <i class="icon-dashboard"></i> <span class="label label-important"></span> group管理 </a> </li>
        <li class="bg_lo "> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=product"> <i class="icon-th-list"></i> produt管理</a> </li>
         <li class="bg_ls"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=platform"> <i class="icon-fullscreen"></i> platform管理</a> </li>
        <li class="bg_ly"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=pkgmine"> <i class="icon-inbox"></i><span class="label label-success"></span> 包名配置 </a> </li>
        <li class="bg_lb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=index&method=syn"> <i class="icon-pencil"></i><span class="label label-success"></span>点击同步LDAP数据</a> </li>
      <li class="bg_lb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=index&method=johuoma"> <i class="icon-pencil"></i><span class="label label-success"></span>点击领取激活码</a> </li>
      </ul>
    </div>
<!--End-Action boxes-->    

<!--Chart-box-->    
    <div class="row-fluid">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-ok"></i></span>
            <h5>后台说明</h5>
          </div>
          <div class="widget-content">
            <div class="todo">
              <ul>
                <li class="clearfix">
                  <div class="txt"> group管理：能配置组合组员的关系.  <span class="date badge badge-warning">Today</span></div>
                  <div class="pull-right"><a class="tip" href="#" title="Edit Task"><i class="icon-pencil"></i></a> <a class="tip" href="#" title="Delete"><i class="icon-remove"></i></a> </div>
                </li>
                <li class="clearfix">
                  <div class="txt"> product管理:当有消息要发送时,在这里选择规则,系统识别后发送给各组对应的员工 .<span class="date badge badge-warning">Today</span> </div>
                  <div class="pull-right"> <a class="tip" href="#" title="Edit Task"><i class="icon-pencil"></i></a> <a class="tip" href="#" title="Delete"><i class="icon-remove"></i></a> </div>
                </li>
                <li class="clearfix">
                  <div class="txt"> platform管理：当有新的消息通知方式上线时,在这里设置平台参数. <span class="date badge badge-warning">Today</span></div>
                  <div class="pull-right"> <a class="tip" href="#" title="Edit Task"><i class="icon-pencil"></i></a> <a class="tip" href="#" title="Delete"><i class="icon-remove"></i></a> </div>
                </li>
                <li class="clearfix">
                  <div class="txt"> 包名管理：在这里配置google爬虫需要监测的的包名以及游戏名. <span class="date badge badge-info">2015-02-06</span> </div>
                  <div class="pull-right"> <a class="tip" href="#" title="Edit Task"><i class="icon-pencil"></i></a> <a class="tip" href="#" title="Delete"><i class="icon-remove"></i></a> </div>
                </li>
                <li class="clearfix">
                  <div class="txt"> 后台系统第一期上线啦！ <span class="date badge badge-important">点击查看新功能</span> </div>
                  <div class="pull-right"> <a class="tip" href="#" title="Edit Task"><i class="icon-pencil"></i></a> <a class="tip" href="#" title="Delete"><i class="icon-remove"></i></a> </div>
                </li>
              </ul>
            </div>
          </div>
        </div>   
 </div>
  </div>
</div>

<!--end-main-container-part-->
  <%@ include file="footer.jsp" %>
