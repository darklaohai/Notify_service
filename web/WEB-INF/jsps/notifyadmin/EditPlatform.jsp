
<%@page import="com.jodo.notify.model.AdminConfPlatformModel"%>
<%@page import="com.jodo.notify.model.AdminSimpleUserModel"%>
<%@page import="java.util.List"%>
<%@ page import="com.jodo.notify.util.UrlUtil" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="header.jsp" %>

<%
List<AdminConfPlatformModel> adminPlatformlModels = (List<AdminConfPlatformModel>)request.getAttribute("adminPlatformlModels");
List<AdminSimpleUserModel> adminUserModels = (List<AdminSimpleUserModel>)request.getAttribute("adminUserModels");
List<AdminSimpleUserModel> adminUserModels1 = (List<AdminSimpleUserModel>)request.getAttribute("adminUserModels1");
String methodlabel = (String)request.getAttribute("methodlabel");
%>
 
 <script>
function delete_platform(ml) {
	if (confirm('确认删除这行记录么？')) {
		ajax('post', 'notifyadmin?page=platform&method=delete', 'methodlabel='+ml, function(data) {		
			var obj = eval('(' + data + ')');
		if (obj.msg =='success') {
				alert('删除成功');
					window.location.href = window.location.href;
			} else {
				alert('删除失败:' + obj.msg	);
			} 
		}, function() {
			alert('删除遇到错误');
		});
	}
}
</script>
<!--main-container-part-->
 <div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">platform管理</a> </div>
    <h1>platform管理</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>platform管理&nbsp&nbsp<a class="btn btn-info btn-mini" href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=platform&method=add"  >新增</a></h5>        
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>平台</th>
                  <th>平台名</th>
                  <th>平台账号</th>
                  <th>平台密码</th>
                  <th>通知url</th>
                  <th>端口</th>
                  <th>已配置人数</th>
                <!--   <th>未配置人数</th> -->
                  <th>查看</th>
                  <th>删除</th>
                </tr>	
              </thead>
              <tbody>
            <%for (int i = 0; i < adminPlatformlModels.size(); i++) { %> 
                <tr class="gradeX">
                  <td><%=adminPlatformlModels.get(i).getMethodlabel() %></td>
                  <td><%=adminPlatformlModels.get(i).getMethodname() %></td>
                  <td><%=adminPlatformlModels.get(i).getUsername() %></td>
                  <td><%=adminPlatformlModels.get(i).getPassword() %></td>
                  <td><%=adminPlatformlModels.get(i).getUrl() %></td>
                  <td><%=adminPlatformlModels.get(i).getPort() %></td>
                  <td><%=adminPlatformlModels.get(i).getMethodcount() %></td>
                  <td><a class="btn btn-info btn-mini"  href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=platform&methodlabel=<%=adminPlatformlModels.get(i).getMethodlabel()%>">查看</a></td>
                  <td><a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="delete_platform('<%=adminPlatformlModels.get(i).getMethodlabel() %>')" >删除该记录</a></td> 
                </tr>
             <%} %>
              </tbody>
            </table>
          </div>
        </div>
        <hr>
		<div id="info" class="widget-box" style="display:none">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>新增</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=platform&method=add" method="post" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">平台 :</label>
              <div class="controls">
                <input type="text"  id="methodlabel"   name="methodlabel"  class="span11" placeholder="Methodlabel">
              </div>
       		 </div>
        	<div class="control-group">
              <label class="control-label">平台名 :</label>
              <div class="controls">
                <input type="text" id="methodname"  name="methodname" class="span11" placeholder="Methodname">
              </div>
        	</div> 
        	<div class="control-group">
              <label class="control-label">平台账号:</label>
              <div class="controls">
                <input type="text"  id="username"  name="username" class="span11" placeholder="Account">
              </div>
        	</div> 
        	<div class="control-group">
               <label class="control-label">平台密码 :</label>
              <div class="controls">
                <input type="text"  id="password"  name="password" class="span11" placeholder="pwd">
              </div>
        	</div> 
        	<div class="control-group">
              <label class="control-label">url(没请忽略):</label>
              <div class="controls">
                <input type="text"  id="url"  name="url" class="span11" placeholder="Url">
              </div>
        	</div> 
        	<div class="control-group">
              <label class="control-label">端口(没请忽略):</label>
              <div class="controls">
                <input type="text" id="port"  name="port" class="span11" placeholder="Port">
              </div>
        	</div>        	       	                   
            <div class="form-actions">
              <button type="submit" class="btn btn-success">新增记录</button>
            </div>         
          </form>
        </div>
      </div>  
      <hr>
        <div id="info1" class="widget-box" style="display:none">
          <div class="widget-title"> <span class="icon"> <i class="icon-briefcase"></i> </span>
            <h5>人员管理 	</h5>
          </div>
          <div class="widget-content">
            <div class="row-fluid">
              <div class="span6">
             	 <h4><%=methodlabel %>:已配置人员</h4>
 				<ul class="thumbnails">
 	         <%for (int i = 0; i < adminUserModels.size(); i++) { %> 		  
              <li class="span2"> 
              	<p><a> <img src="img/imgbox1.jpg" alt=""> </a></p>
				<p align="center">
				<label><%=adminUserModels.get(i).getUsername() %>&nbsp<a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=userinfo&userid=<%=adminUserModels.get(i).getUserid() %>">查看</a></label>
              	</p>
                <div class="actions">
                	 <a title="" href="#"><i class="icon-pencil"></i></a>
						<a class="lightbox_trigger" href="img/imgbox3.jpg"><i class="icon-search"></i></a> 
				</div>
              </li>
               <%} %>     
            </ul>
              </div>
              
              <div class="span6">
                <h4><%=methodlabel %>:未配置人员</h4>
             <ul class="thumbnails">
        	<%for (int i = 0; i < adminUserModels1.size(); i++) { %> 
              <li class="span2"> 
              	<p><a> <img src="img/imgbox1.jpg" alt=""> </a></p>
				<p align="center">
				<label><%=adminUserModels1.get(i).getUsername() %>&nbsp<a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=userinfo&userid=<%=adminUserModels1.get(i).getUserid() %>">查看</a></label>
              	</p>
                <div class="actions">
                	 <a title="" href="#"><i class="icon-pencil"></i></a>
						<a class="lightbox_trigger" href="img/imgbox3.jpg"><i class="icon-search"></i></a> 
				</div>
              </li>
            <%} %>        
            </ul>                 		
              </div>
           </div>
          </div>
        </div>
      </div>
    </div>
</div>
</div>
<!--end-main-container-part-->

 <%@ include file="footer.jsp" %> 
 