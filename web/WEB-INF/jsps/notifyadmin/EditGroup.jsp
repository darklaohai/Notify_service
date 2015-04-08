<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="header.jsp" %>
<%@ page import="com.jodo.notify.model.Admin_GroupUserRSModel" %>
<%@ page import="com.jodo.notify.model.AdminSimpleUserModel" %>
<%
List<Admin_GroupUserRSModel> adminGroupModels = (List<Admin_GroupUserRSModel>)request.getAttribute("adminGroupModels");
List<AdminSimpleUserModel> adminUserModels = (List<AdminSimpleUserModel>)request.getAttribute("adminUserModels");
List<AdminSimpleUserModel> adminUserModels1 = (List<AdminSimpleUserModel>)request.getAttribute("adminUserModels1");
Integer groupid = (Integer)request.getAttribute("groupid");
String groupname = (String)request.getAttribute("groupname");
%>

 <script>

 
function update_group() {
	var groupid = groupname_update.name;
	var groupname =  groupname_update.value; 
	if (confirm('是否更新这个组名？')) {
		ajax('post', 'notifyadmin?page=group&method=update', 'groupid='+groupid+'&'+'groupname='+groupname, function(data) {		
			var obj = eval('(' + data + ')');
		if (obj.msg =='success') {
				alert('更新成功');
					window.location.href = window.location.href;
			} else {
				alert('更新失败:' + obj.msg	);
			} 
		}, function() {
			alert('更新遇到错误');
		});
	}
}
function delete_group(groupid) {
	if (confirm('确认删除这个组么')) {
		ajax('post', 'notifyadmin?page=group&method=delete', 'groupid='+groupid, function(data) {		
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

function add_user(groupid){
    var id = document.getElementsByName('radios_add');
    var value = new String();
    for(var i = 0; i < id.length; i++){
        if(id[i].checked){
      		if(value==""){
        		value=id[i].value;
      		}else{
      			value=value+"_"+id[i].value;
      		}
    	} 
    } 
		ajax('post', 'notifyadmin?page=group&method=add_user', 'uidstring='+value+'&'+'groupid='+groupid, function(data) {		
			var obj = eval('(' + data + ')');
			if (obj.msg =='success') {
				alert('保存成功');
					window.location.href = window.location.href;
			}else{
				alert('保存失败:' + obj.msg);
			}
		}, function() {
			alert('保存遇到错误');
		});
}

function delete_user(groupid){
    var id = document.getElementsByName('radios_delete');
    var value = new String();
    for(var i = 0; i < id.length; i++){
      	if(!id[i].checked){
    		if(value==""){
      			value=id[i].value;
    		}else{
    			value=value+"_"+id[i].value;
    		}
    	}
    }
		ajax('post', 'notifyadmin?page=group&method=delete_user', 'uidstring='+value+'&'+'groupid='+groupid, function(data) {		
			var obj = eval('(' + data + ')');
		if (obj.msg =='success') {
				alert('保存成功');
					window.location.href = window.location.href;
			} else {
				alert('保存失败:' + obj.msg	);
			} 
		}, function() {
			alert('保存遇到错误');
		});
}


function show_add(){
	show_u.style.display="block";
	show_u1.style.display="none";
	info.style.display="none";
	info1.style.display="none";
}

function show_update(groupid,groupname){
	show_u.style.display="none";
	show_u1.style.display="block";
	groupname_update.name=groupid;
	groupname_update.value=groupname;
	info.style.display="none";
	info1.style.display="none";
}

</script>



<!--main-container-part-->
 <div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>Group	管理<a href="#" class="current"></a> </div>
    <h1>Group管理</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
		<div class="span12">
       
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-briefcase"></i> </span>
            <h5>Group管理 	</h5>
          </div>
          <div class="widget-content">
            <div class="row-fluid">
              <div class="span9">
                <table class="">
                  <tbody>
                    <tr>
                      <td><h4>当前小组&nbsp<a class="btn btn-info btn-mini"  onclick="show_add()">新增</a></h4></td>
                    </tr>
                    <tr>
                      <td class="span3">当前小组</td>
                      <td class="span3">人数</td>
                      <td class="span3">操作1</td>
                      <td class="span3">操作2</td>
                      <td class="span3">操作3</td>        
                    </tr>
                    <%for (int i = 0; i < adminGroupModels.size(); i++) { %>
                    <tr>
                      <td><%=adminGroupModels.get(i).getGroupname() %></td>
                      <td><%=adminGroupModels.get(i).getUsercount() %></td>
                      <td><a class="btn btn-info btn-mini" href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=group&groupid=<%=adminGroupModels.get(i).getGroupid() %>">查看小组人</a></td>
                      <td><a class="btn btn-info btn-mini"  onclick="show_update('<%=adminGroupModels.get(i).getGroupid() %>','<%=adminGroupModels.get(i).getGroupname() %>')">修改小组名</a></td>
                      <td><a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="delete_group('<%=adminGroupModels.get(i).getGroupid() %>')">删除该小组</a></td>
                    </tr>
                    <%}%>
                  </tbody>
                </table>
         		<form action="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=group&method=add" method="post" class="form-horizontal">
          			<div class="" id="show_u" style="display:none" >
           		  		 <div class="" >
           		 		    <input type="text" id="groupname" name="groupname"   placeholder=" ">
           				     <button type="submit" class="btn btn-success">新增小组</button>
           				   </div>
       				</div>          
         		
         		
          			<div class="" id="show_u1" style="display:none">
           		  		 <div class="" >
           		 		    <input type="text" id="groupname_update"  placeholder=" ">
           				     <a href="javascript:void(0);" class="btn btn-success"  onclick="update_group()">保存更改</a>
           				 </div>
       				</div>          
         		</form>
              </div>
              </div>
              <hr>
            <div id="info" class="row-fluid" style="display:none">
            
              <div class="span6">
             	 <h4><%=groupname%>：已有人员</h4>
 			<ul class="thumbnails">
            	<% for(int i=0;i<adminUserModels.size();i++) {%>
            	
              	<li class="span2"> 
              	<p><a> <img src="img/imgbox1.jpg" alt=""> </a></p>
				<p>
				<label>
				<input type="checkbox" name="radios_delete" checked="checked" value="<%=adminUserModels.get(i).getUid() %>">
                 <%=adminUserModels.get(i).getUsername() %></label>
              	</p>
                <div class="actions">
                	 <a title="" href="#"><i class="icon-pencil"></i></a>
						<a class="lightbox_trigger" href="img/imgbox3.jpg"><i class="icon-search"></i></a> 
				</div>
              	</li>
              	<%}%>
            </ul>
           		  		 <div class="control-group">
           				     <a  href="javascript:void(0);" class="btn btn-success" onclick="delete_user('<%=groupid %>')" >保存更改</a>
           				   </div>
              </div>
              
              <div class="span6">
                <h4><%=groupname%>:未有人员</h4>
             <ul class="thumbnails">
             <% for(int i=0;i<adminUserModels1.size();i++) {%>
              <li class="span2"> 
              	<p><a> <img src="img/imgbox1.jpg" alt=""> </a></p>
				<p>
				<label>
				<input type="checkbox" name="radios_add" value="<%=adminUserModels1.get(i).getUid() %>" >
                  	<%=adminUserModels1.get(i).getUsername() %></label>
              	</p>
                <div class="actions">
                	 <a title="" href="#"><i class="icon-pencil"></i></a>
						<a class="lightbox_trigger" href="img/imgbox3.jpg"><i class="icon-search"></i></a> 
				</div>
              </li>
              <%} %>
            </ul>                 
        	  		 <div class="control-group">
           				     <a href="javascript:void(0);" class="btn btn-success" onclick="add_user('<%=groupid %>')">保存更改</a>
           				   </div>
         	   		
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
