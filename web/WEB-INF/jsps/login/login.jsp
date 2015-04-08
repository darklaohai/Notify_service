<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.jodo.notify.util.UrlUtil" %>

<!DOCTYPE html>
<html lang="zh_CN">
    
<head>
        <title>Matrix Admin</title><meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<link rel="stylesheet" href="<%=UrlUtil.getCdnPrefix(request)%>/css/bootstrap.min.css" />
		<link rel="stylesheet" href="<%=UrlUtil.getCdnPrefix(request)%>/css/bootstrap-responsive.min.css" />
        <link rel="stylesheet" href="<%=UrlUtil.getCdnPrefix(request)%>/css/matrix-login.css" />
        <link href="<%=UrlUtil.getCdnPrefix(request)%>/css/font-awesome.css" rel="stylesheet" />
		<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,700,800' rel='stylesheet' type='text/css'>

    </head>
    <body>
        <div id="loginbox">            
            <form id="loginform" class="form-vertical" action="<%=UrlUtil.getCdnPrefix(request)%>/login?method=login" method="post">
				 <div class="control-group normal_text"> <h3><img src="img/logo.png" alt="Logo" /></h3></div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lg"><i class="icon-user"></i></span><input name="username" id="username" type="text" placeholder="Username" />
                        </div>
                    </div>
                </div>
                <div class="control-group">
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_ly"><i class="icon-lock"></i></span><input  name="password" id="password" type="password" placeholder="Password" />
                        </div>
                    </div>
                </div>
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link btn btn-info" id="to-recover">Lost password?</a></span>
                    <span class="pull-right"><button type="submit" class="btn btn-success">Login</button></span>
                    <input type="hidden" name="t" />
                </div>
            </form>
             <form id="recoverform" action="/login?method=recover" class="form-vertical" method="post">
				<p class="normal_text">Enter your e-mail address below and we will send you instructions how to recover a password.</p>
				
                    <div class="controls">
                        <div class="main_input_box">
                            <span class="add-on bg_lo"><i class="icon-envelope"></i></span><input type="text" id="email"  placeholder="E-mail address" />
                        </div>
                    </div>
               
                <div class="form-actions">
                    <span class="pull-left"><a href="#" class="flip-link btn btn-success" id="to-login">&laquo; Back to login</a></span>
                    <span class="pull-right"><a><button type="submit" class="btn btn-info">Reecover</button></a></span>
                </div>
            </form>
        </div>
        
        <script src="<%=UrlUtil.getCdnPrefix(request)%>/js/jquery.min.js"></script>  
        <script src="<%=UrlUtil.getCdnPrefix(request)%>/js/matrix.login.js"></script> 
    </body>

</html>
