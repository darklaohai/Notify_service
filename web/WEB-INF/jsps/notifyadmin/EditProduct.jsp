<%@page import="com.jodo.notify.model.AdminSimpleProductModel"%>
<%@page import="com.jodo.notify.model.Admin_GroupProductRSModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ include file="header.jsp" %>
<%@ page import="com.jodo.notify.util.UrlUtil" %>
<%
List<AdminSimpleProductModel> adminProductModels = (List<AdminSimpleProductModel>)request.getAttribute("adminProductModels");
List<Admin_GroupProductRSModel> adminProductGroupModels = (List<Admin_GroupProductRSModel>)request.getAttribute("adminProductGroupModels");
List<Admin_GroupProductRSModel> adminProductGroupDetailModels = (List<Admin_GroupProductRSModel>)request.getAttribute("adminProductGroupDetailModels");
List<Admin_GroupProductRSModel> adminProductGroupDetailModels1 = (List<Admin_GroupProductRSModel>)request.getAttribute("adminProductGroupDetailModels1");
String product = (String)request.getAttribute("product"); 
Integer productid = (Integer)request.getAttribute("productid"); 

%>
 <script>
 
function update_product(productid,product,tag,methodlabel,minlevel) {
	if (confirm('是否更新这个组名？')) {
		ajax('post', 'notifyadmin?page=group&method=update', 'productid='+productid+'&'+'product='+product+'&'+'tag='+tag+'&'+'methodlabel='+methodlabel+'&'+'minlevel='+minlevel, function(data) {		
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

function delete_product(productid) {
	if (confirm('确认删除这个组么')) {
		ajax('post', 'notifyadmin?page=product&method=delete', 'productid='+productid, function(data) {		
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

function add_group(productid){
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
		ajax('post', 'notifyadmin?page=product&method=add_group', 'groupidstring='+value+'&'+'productid='+productid, function(data) {		
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

function delete_group(productid){
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
		ajax('post', 'notifyadmin?page=product&method=delete_group', 'groupidstring='+value+'&'+'productid='+productid, function(data) {		
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

function show_update(pid,pd,tg,label,level){
	show_u.style.display="block";
 	show_u.name = pid;
 	productid.value = pid;
	product.value=pd;
	tag.value=tg;
	minlevel.value=level;
	methodlabel.value=label;
	info1.style.display="none"; 
}

function show_add(){
	show_a.style.display="block";
	show_u.style.display="none";
	info.style.display="none"; 
	info1.style.display="none"; 
}

</script>

<!--main-container-part-->
 <div id="content">
  <div id="content-header">
    <div id="breadcrumb"> <a href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin" title="Go to Home" class="tip-bottom"><i class="icon-home"></i> Home</a>product管理<a href="#" class="current"></a> </div>
    <h1>product管理</h1>
  </div>
  <div class="container-fluid">
    <hr>
    <div class="row-fluid">
		<div class="span12">
        <div class="widget-box">
          <div class="widget-title"> <span class="icon"> <i class="icon-briefcase"></i> </span>
            <h5>product管理 	</h5>
          </div>
          <div class="widget-content">
            <div class="row-fluid">
              <div class="span9">
                <table class="">
                  <tbody>
                    <tr>
                      <td><h4>已有product&nbsp<a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="show_add()">新增</a></h4></td>
                    </tr>
                    <tr>
                      <td class="span3">已有product</td>
                      <td class="span3">配置数</td>
                      <td class="span3">操作</td>
                    </tr>
                    <%for (int i = 0; i < adminProductModels.size(); i++) { %>
                    <tr>
                      <td><%=adminProductModels.get(i).getProduct() %></td>
                      <td><%=adminProductModels.get(i).getProductcount()%></td>
                      <td><a class="btn btn-info btn-mini" href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=product&product=<%=adminProductModels.get(i).getProduct() %>">查看配置</a></td>       
                    </tr>
                    <%}%>
                  </tbody>
                </table>
              </div>
            </div>
            <hr>
            <div id="info" class="row-fluid" style="display:none">
              <div class="span12">
                <table class="table table-bordered table-invoice-full">
                  <thead>
                    <tr>
                      <th class="head0">product名称</th>
                      <th class="head0 right">通知类型</th>
                      <th class="head1 right">平台</th>
                      <th class="head0 right">危险级别</th>
                      <th class="head0 right">影响的组数</th>
                      <th class="head0 right">修改</th>
                      <th class="head0 right">删除</th>
                    </tr>
                  </thead>
                  <tbody>
                  <%for (int i = 0; i < adminProductGroupModels.size(); i++) { %>
                    <tr>
                      <td><%=adminProductGroupModels.get(i).getProduct() %></td>
                      <td><%=adminProductGroupModels.get(i).getTag() %></td>
                      <td class="right"><%=adminProductGroupModels.get(i).getMethodlabel() %></td>
                      <td class="right"><strong><%=adminProductGroupModels.get(i).getMinlevel() %></strong></td>
                      <td class="right"><%=adminProductGroupModels.get(i).getCoutngroup() %>&nbsp&nbsp&nbsp&nbsp&nbsp<span class="left"><a class="btn btn-info btn-mini" href="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=product&product=<%=adminProductGroupModels.get(i).getProduct()%>&productid=<%=adminProductGroupModels.get(i).getProductid()%>">查看</a></span></td>
                      <td><a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="show_update('<%=adminProductGroupModels.get(i).getProductid() %>','<%=adminProductGroupModels.get(i).getProduct() %>','<%=adminProductGroupModels.get(i).getTag() %>','<%=adminProductGroupModels.get(i).getMethodlabel() %>','<%=adminProductGroupModels.get(i).getMinlevel() %>')">修改记录</a></td>
                      <td><a class="btn btn-info btn-mini" href="javascript:void(0);" onclick="delete_product('<%=adminProductGroupModels.get(i).getProductid() %>')">删除记录</a></td>                  
                    </tr>
                    <%}%>
                  	  
                  </tbody>
                </table>

              </div>
            </div>
            <hr>
         <div id="show_a" class="widget-box" style="display:none">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>新增记录</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=product&method=add" method="post" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">product名称:</label>
              <div class="controls">
                <input type="text"  id="product_add" name="product_add"  class="span11" >
              </div>
       		 </div>
        	<div class="control-group">
              <label class="control-label">通知类型 :</label>
              <div class="controls">
                <input type="text" id="tag_add" name="tag_add" class="span11" >
              </div>
        	</div> 
        	<div class="control-group">
              <label class="control-label">平台:</label>
              <div class="controls">
                <input type="text" id="methodlabel_add" name="methodlabel_add" class="span11" >
              </div>
        	</div> 
        	<div class="control-group">
               <label class="control-label">危险级别 :</label>
              <div class="controls">
                <input type="text" id="minlevel_add" name="minlevel_add" class="span11" ">
              </div>
        	</div>        	       	                   
            <div class="form-actions">
              <button type="submit" class="btn btn-success">新增</button>
            </div>         
          </form>
      		  </div>
    		  </div> 
         <div id="show_u" class="widget-box" style="display:none">
        <div class="widget-title"> <span class="icon"> <i class="icon-align-justify"></i> </span>
          <h5>更新记录</h5>
        </div>
        <div class="widget-content nopadding">
          <form action="<%=UrlUtil.getCdnPrefix(request)%>/notifyadmin?page=product&method=update" method="post" class="form-horizontal">
          	<div class="control-group">
              <label class="control-label">product名称:</label>
              <div class="controls">
                <input type="text"  id="product"   name="product" class="span11" >
                <input type="hidden" id="productid"  name="productid"  class="span11" >
              </div>
       		 </div>
        	<div class="control-group">
              <label class="control-label">通知类型 :</label>
              <div class="controls">
                <input type="text" id="tag"  name="tag"  class="span11" >
              </div>
        	</div> 
        	<div class="control-group">
              <label class="control-label">平台:</label>
              <div class="controls">
                <input type="text" id="methodlabel" name="methodlabel"  class="span11" >
              </div>
        	</div> 
        	<div class="control-group">
               <label class="control-label">危险级别 :</label>
              <div class="controls">
                <input type="text" id="minlevel"  name="minlevel"  class="span11" ">
              </div>
        	</div>        	       	                   
            <div class="form-actions">
              <button type="submit" class="btn btn-success">保存记录</button>
            </div>         
          </form>
      		  </div>
    		  </div>           
            <div id="info1" class="row-fluid" style="display:none">
              <div class="span6">
             	 <h4><%=product %>:影响的组</h4>
 				<ul class="thumbnails">
 				<% for(int i=0;i<adminProductGroupDetailModels.size();i++) {%>
              <li class="span3"> 
              	<p><a> <img src="img/imgbox1.jpg" alt=""> </a></p>
				<p>
				<label>
				<input type="checkbox" name="radios_delete" checked="checked" value="<%=adminProductGroupDetailModels.get(i).getGroupid() %>" >
                  	<%=adminProductGroupDetailModels.get(i).getGroupname() %></label>
              	</p>
                <div class="actions">
                	 <a title="" href="#"><i class="icon-pencil"></i></a>
					<a class="lightbox_trigger" href="img/imgbox3.jpg"><i class="icon-search"></i></a> 
				</div>
              </li>
               	<%}%>
            </ul>
        	  		 <div class="control-group">
           				     <a href="javascript:void(0);" class="btn btn-success" onclick="delete_group('<%=productid %>')" >保存更改</a>
           				   </div> 

              </div>
              
              <div class="span6">
                <h4><%=product%>:未影响的组</h4>
             <ul class="thumbnails">
             <% for(int i=0;i<adminProductGroupDetailModels1.size();i++) {%>
              <li class="span3"> 
              	<p><a> <img src="img/imgbox1.jpg" alt=""> </a></p>
				<p>
				<label>
				<input type="checkbox" name="radios_add"   value="<%=adminProductGroupDetailModels1.get(i).getGroupid() %>" >
                  	<%=adminProductGroupDetailModels1.get(i).getGroupname() %></label>
              	</p>
                <div class="actions">
                	 <a title="" href="#"><i class="icon-pencil"></i></a>
						<a class="lightbox_trigger" href="img/imgbox3.jpg"><i class="icon-search"></i></a> 
				</div>
             </li>
              	<%}%>
            </ul>                 
        	  		 <div class="control-group">
           				     <a href="javascript:void(0);" class="btn btn-success" onclick="add_group('<%=productid %>')" >保存更改</a>
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
 