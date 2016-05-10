function AjaxGet(url, func) {
	Ajax(url, '', 'GET', func, true);
}
function AjaxLoad(url, data, div, func) {
	Ajax(url, data, 'LOAD', function(data) {
		jQuery('#' + div).html(data);
		if (func) {
			func(data);
		}
	});
}
function AjaxAppend(url, data, div, func) {
	Ajax(url, data, 'LOAD', function(data) {
		jQuery('#' + div).append(data);
		if (func) {
			func(data);
		}
	});
}
function AjaxPost(url, data, func) {
	Ajax(url, data, 'POST', function(data) {
		if (func) {
			func(data);
		}
	});
}
function Ajax(url, data, type, func) {
	if (url.indexOf('?') == -1) {
		url += "?";
	} else
		url += "&";
	url += "timeStamp=" + new Date().getTime()

	if (type == 'GET') {
		jQuery.ajax({
			url : url,
			type : 'GET',
			data : data,
			cache : false,
			timeout : 5000,
			error : function() {
				alert('数据加载失败，可能是网络连接问题或者服务器错误。GET');
			},
			/*
			 * error:function(XMLHttpRequest, textStatus, errorThrown){
			 * alert(XMLHttpRequest.responseText) alert(textStatus)
			 * alert(errorThrown) },
			 */
			success : func,
			complete : function(XMLHttpRequest, textStatus) {
				var sessionstate = XMLHttpRequest
						.getResponseHeader("sessionstate"); // 通过XMLHttpRequest取得响应头，sessionstatus，
				if (sessionstate == "timeout") {
					relogin();
				}
			}
		});
	}else if(type=='LOAD')
 	{
 		jQuery.ajax({ url: url,
 			type: 'POST',
 			data: data,
 			dataType:"html",
 			cache: false,
 			timeout: 5000,
 			error: function() {
 				alert('数据加载失败，可能是网络连接问题或者服务器错误。LOAD');
 			},
 			/*error:function(XMLHttpRequest, textStatus, errorThrown){  
				alert(textStatus)
				alert(errorThrown)
			},*/
 			success: func,
 			complete:function(XMLHttpRequest, textStatus){
 				var sessionstate=XMLHttpRequest.getResponseHeader("sessionstate"); //通过XMLHttpRequest取得响应头，sessionstatus，  
 				if(sessionstate=="timeout"){
 					relogin();
                } 				
 			}
 		});
	} else if (type == 'POST') {
		// jQuery('.submit').each(function(){jQuery(this).attr('title',jQuery(this).html());jQuery(this).html('请稍候');jQuery(this).attr('disabled','disabled');});
		jQuery.ajax({
			url : url,
			type : 'POST',
			// data: j('#'+param).serialize(),
			data : data,
			cache : false,
			timeout : 5000,
			error : function() {
				//alert('数据加载失败，可能是网络连接问题或者服务器错误。POST');
			},
			/*
			 * error:function(XMLHttpRequest, textStatus, errorThrown){
			 * alert(textStatus) alert(errorThrown) },
			 */
			success : func,
			complete : function(XMLHttpRequest, textStatus) {
				var sessionstate = XMLHttpRequest
						.getResponseHeader("sessionstate"); // 通过XMLHttpRequest取得响应头，sessionstatus，
				if (sessionstate == "timeout") {
					relogin();
				}
			}
		});
	}
}
function AjaxPostForm(url, frm, cnfirm, needchecked) {
	var doit = true;
	if (needchecked == true) {
		if (!IsCheckedOne()) {
			alert('请至少选择一条记录');
			doit = false;
			return;
		}
	}
	if (cnfirm == true) {
		if (!confirm('你确定要执行该操作？')) {
			doit = false;
		}
	}
	if (doit) {
		if (url.indexOf('?') == -1) {
			url += "?";
		} else
			url += "&";
		url += "timeStamp=" + new Date().getTime()
		// Ajax(url, frm, 'POST', ShowResult, true);
		jQuery('.submit').each(function() {
			jQuery(this).attr('title', jQuery(this).html());
			jQuery(this).html('请稍候');
			jQuery(this).attr('disabled', 'disabled');
		});
		jQuery.ajax({
			url : url,
			type : 'POST',
			data : jQuery('#' + frm).serialize(),
			cache : false,
			// timeout: 20000,
			// error: function() { alert('数据加载失败，可能是网络连接问题或者服务器错误。'); },
			/**/error : function(XMLHttpRequest, textStatus, errorThrown) {
				alert(textStatus)
				alert(errorThrown)
			},
			success : ShowResult,
			complete : function() {
				jQuery('.submit').each(function() {
					jQuery(this).html(jQuery(this).attr('title'));
					jQuery(this).attr('disabled', false);
				});
			}
		});
	}
}
function PostForm(url, frm, func) {
	if (url.indexOf('?') == -1) {
		url += "?";
	} else
		url += "&";
	url += "timeStamp=" + new Date().getTime()
	// Ajax(url, frm, 'POST', ShowResult, true);
	jQuery('.submit').each(function() {
		jQuery(this).attr('title', jQuery(this).html());
		jQuery(this).html('请稍候');
		jQuery(this).attr('disabled', 'disabled');
	});
	jQuery.ajax({
		url : url,
		type : 'POST',
		data : jQuery('#' + frm).serialize(),
		cache : false,
		timeout : 20000,
		error : function() {
			alert('数据加载失败，可能是网络连接问题或者服务器错误。');
		},
		/*
		 * error:function(XMLHttpRequest, textStatus, errorThrown){
		 * alert(textStatus) alert(errorThrown) },
		 */
		success : func,
		complete : function() {
			jQuery('.submit').each(function() {
				jQuery(this).html(jQuery(this).attr('title'));
				jQuery(this).attr('disabled', false);
			});
		}
	});

}
