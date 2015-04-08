
<%@page import="com.jodo.notify.model.NameValueModel"%>
<%@page import="com.jodo.notify.model.AdminSimpleUserModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="header.jsp" %>

<%
List<NameValueModel> pkgminelistList = (List<NameValueModel>)request.getAttribute("pkgminelistList");
%>
 
 <script>
function delete_pkgmine(pn) {
	if (confirm('确认删除这行记录么？')) {
		ajax('post', 'notifyadmin?page=pkgmine&method=delete', 'pn='+pn, function(data) {		
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

function show_add(){
	info.style.display="block";
	info_update.style.display="none";
}

function show_update(name_key,name_value){
	info.style.display="none";
	info_update.style.display="block";
	var str= new Array();   
 	str = name_value.split("-");
	pn_update.value=name_key;
	gamename_update.value=str[0];
/* 	game_type_update.value=4;  */
}
</script>
<!--main-container-part-->
 <div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a> <a href="#" class="current">包名管理</a> </div>
    <h1>包名管理</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
      <div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"><i class="icon-th"></i></span>
            <h5>包名管理&nbsp&nbsp<a class="btn btn-info btn-mini" href="javascript:void(0)" onclick="show_add()"  >新增</a></h5>        
          </div>
          <div class="widget-content nopadding">
            <table class="table table-bordered data-table">
              <thead>
                <tr>
                  <th>包名</th>
                  <th>游戏名(游戏类型)</th>
                  <th>修改</th>
                  <th>删除</th>
                </tr>	
              </thead>
              <tbody>
	         <%for (int i = 0; i < pkgminelistList.size(); i++) { %> 
                <tr class="gradeX">
                  <td><%=pkgminelistList.get(i).getName() %></td>
                  <td><%=pkgminelistList.get(i).getValue() %></td>
                  <td><a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="show_update('<%=pkgminelistList.get(i).getName()%>','<%=pkgminelistList.get(i).getValue() %>')" >修改该记录</a></td> 
          		   <td><a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="delete_pkgmine('<%=pkgminelistList.get(i).getName()%>')" >删除该记录</a></td> 
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
          <form action="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=pkgmine&method=add" method="post" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">包名 :</label>
              <div class="controls">
                <input type="text"  id="pn"   name="pn"  class="span11" placeholder="pkgname">
              </div>
       		 </div>
        	<div class="control-group">
              <label class="control-label">游戏名 :</label>
              <div class="controls">
                <input type="text" id="gamename"  name="gamename" class="span11" placeholder="gamename">
              </div>
        	</div> 
			<div class="control-group">
				<label class="control-label">游戏名 :</label>
                <div class="controls" id="s2id_autogen1">   
                <select id="game_type" name="game_type" style="display: none;">
                  <option value="网络游戏">网络游戏</option>
                  <option value="单机游戏">单机游戏</option>
                  <option value="APP">APP</option>
                  <option value="其他">其他</option>
                </select>
              </div> 
            </div>     	       	                   
            <div class="form-actions">
              <button type="submit" class="btn btn-success">新增记录</button>
            </div>         
          </form>
        </div>
      </div>  
      
   	<div id="info_update" class="widget-box" style="display:none">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>修改</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=pkgmine&method=update" method="post" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">包名 :</label>
              <div class="controls">
                <input type="text"  id="pn_update"   name="pn"  class="span11" placeholder="pkgname">
              </div>
       		 </div>
        	<div class="control-group">
              <label class="control-label">游戏名 :</label>
              <div class="controls">
                <input type="text" id="gamename_update"  name="gamename" class="span11" placeholder="gamename">
              </div>
        	</div> 
			<div class="control-group">
				<label class="control-label">游戏名 :</label>
                <div class="controls" id="s2id_autogen1">   
                <select id="game_type_update" value="其他" name="game_type" style="display: none;">
                  <option value="网络游戏">网络游戏</option>
                  <option value="单机游戏">单机游戏</option>
                  <option value="APP">APP</option>
                  <option value="其他">其他</option>
                </select>
              </div> 
            </div>     	       	                   
            <div class="form-actions">
              <button type="submit" class="btn btn-success">保存记录</button>
            </div>         
          </form>
        </div>
      </div>  
   
   
      </div>
    </div>
</div>
</div>
<!--end-main-container-part-->

 <%@ include file="footer.jsp" %> 
 