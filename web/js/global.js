function ajax(method, url, params, onSuccess, onError) {
	var xmlhttp;
	if (window.ActiveXObject) {
		xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		}
	}
	xmlhttp.timeout = 10000;
	xmlhttp.onreadystatechange = onreadystatechange;
	if (/post/i.test(method)) {
		xmlhttp.open("POST", url, true);
		xmlhttp.setRequestHeader('Content-type', 'application/x-www-form-urlencoded');
		xmlhttp.send(params);
	} else {
		xmlhttp.open("GET", url + (null != params ? '?' + params : ''), true);
		xmlhttp.send();
	}
	function onreadystatechange() {
		if (xmlhttp.readyState == 4) {
			if (xmlhttp.status == 200) {
				if (null != onSuccess && onSuccess instanceof Function) {
					onSuccess(xmlhttp.responseText);
				}
			} else {
				if (null != onError && onError instanceof Function) {
					onError(xmlhttp.status, xmlhttp.statusText);
				}
			}
		}
	}
}

function getCookie(c_name)
{
	if (document.cookie.length>0)
	{
		c_start=document.cookie.indexOf(c_name + "=");
		if (c_start!=-1)
		{ 
			c_start=c_start + c_name.length+1;
			c_end=document.cookie.indexOf(";",c_start);
			if (c_end==-1) c_end=document.cookie.length;
			return unescape(document.cookie.substring(c_start,c_end));
		} 
	}
	return "";
}

function setCookie(c_name,value,expiredays,path)
{
	var exdate=new Date();
	var exp=null;
	if(expiredays!=null&&expiredays>0){
		exdate.setDate(exdate.getDate()+expiredays);
		exp=exdate.toGMTString();
	}else{
		exp='0';
	}
	var p=null;
	if(path!=null){
		p=';path='+path;
	}
	document.cookie=c_name+ "=" +escape(value)+((expiredays==null) ? "" : ";expires="+exp+p);
}

function addEvent( obj, type, fn ) {
	if ( obj.attachEvent ) {
		obj['e'+type+fn] = fn;
		obj[type+fn] = function(){obj['e'+type+fn]( window.event );}
		obj.attachEvent( 'on'+type, obj[type+fn] );
	} else
		obj.addEventListener( type, fn, false );
}
function removeEvent( obj, type, fn ) {
	if ( obj.detachEvent ) {
		obj.detachEvent( 'on'+type, obj[type+fn] );
		obj[type+fn] = null;
	} else
		obj.removeEventListener( type, fn, false );
}

function initErrorBar() {	
	var $btns = document.getElementsByClassName('btn');
	for (var i = 0; i < $btns.length; i++) {
		addEvent($btns[i], 'click', function() {
			hideError();
		});
	}
	var $inputs = document.getElementsByTagName('input');
	for (var i = 0; i < $inputs.length; i++) {
		addEvent($inputs[i], 'click', function() {
			hideError();
		});
	}
}
var errorTimer = null;
function showError(errormsg) {
	hideError();
	var $toolbar = document.getElementsByClassName('toolbar')[0];
	$toolbar.className += ' error0';
	errorTimer = setTimeout(function() {
		$toolbar.className = $toolbar.className.replace(/error0/g, '') + ' error';
	}, 500);
	var $h1 = document.getElementsByTagName('h1')[0];
	$h1.setAttribute('data-content', $h1.innerText);
	$h1.innerText = errormsg;
}
function hideError() {
	if (null != errorTimer) {
		clearTimeout(errorTimer);
		errorTimer = null;
	}
	var $toolbar = document.getElementsByClassName('toolbar')[0];
	$toolbar.className = $toolbar.className.replace(/error/g, '').replace(/error0/g, '');
	var $h1 = document.getElementsByTagName('h1')[0];
	if (null != $h1.getAttribute('data-content')) {
		$h1.innerText = $h1.getAttribute('data-content');
		$h1.removeAttribute('data-content');
	}
}