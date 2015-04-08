<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="header.jsp" %>
<%@ page import="com.jodo.notify.model.AdminSimpleUserModel" %>
<%@ page import="com.jodo.notify.model.AdminSimpleGroupModel" %>
<%@ page import="com.jodo.notify.model.AdminConfPlatformModel" %>
<%@ page import="com.jodo.notify.model.AdminConfUserModel" %>
<%@ page import="com.jodo.notify.model.AdminSimpleProductModel" %>
<%@ page import="com.jodo.notify.util.UrlUtil" %>

<%
AdminSimpleUserModel  confuser_user = (AdminSimpleUserModel)request.getAttribute("confuser_user");
List<AdminSimpleGroupModel> confuser_group = (List<AdminSimpleGroupModel>)request.getAttribute("confuser_group");
List<AdminConfPlatformModel> confuser_platform = (List<AdminConfPlatformModel>)request.getAttribute("confuser_platform");
List<AdminConfUserModel> conuser_confuser = (List<AdminConfUserModel>)request.getAttribute("conuser_confuser");
List<AdminSimpleProductModel> confuser_msg =(List<AdminSimpleProductModel>)request.getAttribute("confuser_msg");
%>
 <script>
function delete_group(group,uid) {
	if (confirm('确认删除这行记录么？')) {
		ajax('post', 'notifyadmin?page=group&method=delete', 'uid='+uid+'&'+'group='+group, function(data) {		
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
<style type="text/aVquickEdit">
#personalCard span,#personalCard div{
  action:  'notifyadmin?page=userinfo&userid='+"<%=confuser_user.getUserid()%>",
 params: 'var=' + element.id + '&val',
  condition: 1
}
#personalCard div {
  type: 'textarea'        
}
</style>


<!--main-container-part-->
<div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=index" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>  <a href="#" class="current">员工配置</a> </div>
    <h1>员工配置</h1>
  </div>
  <div class="container-fluid"><hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-briefcase"></i> </span>
            <h5 >员工详情</h5>
          </div>
          <div class="widget-content">
            <div class="row-fluid">
              <div class="span6">
                <table class="">
                  <tbody>
                    <tr>
                      <td><h4><%=confuser_user.getUsername() %></h4></td>
                    </tr>
                    <tr>
                      <td>公司 ：Jodo Game</td>
                    </tr>
                    <tr>
                      <td>Your Region/State</td>
                    </tr>
                    <tr>
                      <td>Mobile Phone: +8613662419500</td>
                    </tr>
                    <tr>
                      <td >开发组: <%=confuser_user.getUserid() %></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="span6">
              <form>
                <table class="table table-bordered table-invoice" id="personalCard">
                  <tbody>
                	<tr>
                      <td class="width30"><strong>平台标签</strong></td>
                      <td class="width60"><strong>员工配置</strong></td>
                    </tr>
                	<%for(int i = 0;i < conuser_confuser.size();i++ ) {%>
                    <tr>
                      <td class="width30"><%=conuser_confuser.get(i).getMethodlabel() %></td>
                      <td class="width30"><span id="<%=conuser_confuser.get(i).getMethodlabel() %>"><%=conuser_confuser.get(i).getUseraccount() %></span></td>
                    </tr>
                  	<%}%>
                    </tbody>
                  
                </table>
               </form>
              </div>
            </div>
            <div class="row-fluid">
              <div class="span12">
                <table class="table table-bordered table-invoice-full">
                  <thead>
                    <tr>
                      <th class="head0">公司产品</th>
                      <th class="head1">员工标签</th>
                      <th class="head0 right">通知标签</th>
                      <th class="head1 right">消息等级</th>
                      <th class="head0 right">信息汇总</th>
                    </tr>
                  </thead>
                  <tbody>
                  <%for(int i = 0;i < confuser_msg.size();i++ ) {%>
                    <tr>
                       <td><%=confuser_msg.get(i).getProduct() %></td>
                      <td><%=confuser_msg.get(i).getTag() %></td>
                      <td class="right"><%=confuser_msg.get(i).getMethodlabel() %></td>
                      <td class="right"><%=confuser_msg.get(i).getMinlevel() %></td>
                      <td class="right"><strong><%=confuser_msg.get(i).getAggr() %></strong></td> 
                    </tr>
             	 <%}%>	

                  </tbody>
                </table>
                <table class="table table-bordered table-invoice-full">
                  <tbody>
                    <tr>
                      <td class="msg-invoice" width="85%"><h4>更多配置: </h4>
                        <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=product" class="tip-bottom" title="product管理">product管理</a> |  <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=platform" class="tip-bottom" title="platform管理">platform管理</a> </td>
                    </tr>
                  </tbody>
                </table>
                <div class="pull-right">
                  <a class="btn btn-primary btn-large pull-right" href="#">保存更改</a> </div>
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
