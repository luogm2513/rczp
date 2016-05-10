/**
 * 系统的一些初始化数据及其操作。 1.区域数据； 2.行业数据； 3.专业数据；
 * 
 * 基于jQuery实现，
 * 
 * @date 2014-04-01
 */
$(function() {
	var parent = $('#parent_id'), son = $('#son_id');
	if (parent.length) {
		if(son.length){
			parent.change(function() {
				Trade.asyncUpdateChildSelect.call(this, '/rczp/trade/jsonArray.htm', 'parentId', son, true);
			});
		}
		// 加载父行业数据
		AjaxPost('/rczp/trade/jsonArray.htm', null, function(list) {
			if (typeof (list) == "string") {
				list = eval(list);
			}
			var i = 0, size = list.length, opt = null;

			parent.empty();
			parent.append($('<option value="">==请选择==</option>'));

			for (; i < size; ++i) {
				opt = $('<option></option>');
				opt.val(list[i].id);
				opt.text(list[i].tradeName || '');
				opt.attr('title', (list[i].tradeName || ''));
				parent.append(opt);
			}
			if (parent.attr(parent.attr('name'))) {
				parent.val(parent.attr(parent.attr('name')));
			}
			// province.change();

			var parentVal = parent.val() || parent.attr(parent.attr('name'));
			Trade.asyncUpdateChildSelect.call(parent,
					'/rczp/trade/jsonArray.htm', 'parentId=' + parentVal, son,
					true, function(son) {
						var sonId = son.attr('sonId');
						// alert(sonId);
						son.children().each(
								function() {// 选择二级区域
									if (typeof sonId == 'undefined'
											|| $.trim(sonId) == '') {
										return false;
									}
									// alert(this.value)
									if ((sonId == this.value)) {
										son.val(this.value);
										son.change();
										return false;
									}
								});
					});
		});

	}
	
})

var Trade = {
	asyncUpdateChildSelect : function(url, parentSelectName, jq_cselect,
			hasDef, callback) {
		// alert("2:"+$);
		var val = null, parentId = null, i = 0;
		if (this != Trade) {
			val = $(this).val() || $(this).attr($(this).attr('name'));
		}
		if (!val) {
			jq_cselect.empty();
			if (hasDef) {
				jq_cselect.append($('<option value="">==请选择==</option>'));
			}
			// 以下代码兼容选项可选的父级select
			i = parentSelectName.indexOf('=');
			if (i > 0) {
				parentId = $.trim(parentSelectName.slice(0, i));
			} else {
				parentId = $.trim(parentSelectName);
			}
			parentId = parentId.slice(0, -2) + "_id";

			if ($.trim($('#' + parentId).val()) === '') {
				return;
			}
		}
		// alert(parentId+':'+val);
		AjaxPost(
				url,
				(this == Trade) ? "parentId" : ("parentId=" + val),
				function(list) {
					if (typeof (list) == "string") {
						list = eval(list);
					}
					var i = 0, size = list.length, opt = null;

					jq_cselect.empty();
					if (hasDef) {
						jq_cselect.empty();
						jq_cselect
								.append($('<option value="">==请选择==</option>'));
					}
					for (; i < size; ++i) {
						opt = $('<option></option>');
						opt.val(list[i].id);
						opt.text(list[i].tradeName || '');
						opt.attr('title', (list[i].tradeName || ''));
						jq_cselect.append(opt);
					}
					jq_cselect.change();
					// alert(jq_cselect.attr('name')+":"+jq_cselect.val());

					if (callback && typeof callback == "function") {
						// alert('callback');
						callback(jq_cselect);
					}
				});
	}
}
