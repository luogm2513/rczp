/**
 * 系统的一些初始化数据及其操作。 1.区域数据； 2.行业数据； 3.专业数据；
 * 
 * 基于jQuery实现，
 * 
 * @date 2014-04-01
 */
$(function() {
	var first = $('#first_id'), second = $('#second_id'), third = $('#third_id');

	// 异步请求城市信息
	if (first.length && second.length) {
		if (third.length) {
			second.change(function() {
				Func.asyncUpdateChildSelect.call(this,
						'/rczp/func/jsonArray.htm', 'secondId', third, true,
						function(third) {
							third.children().each(
									function() {// 选择三级区域
										var thirdId = third.attr('thirdId');
										if (typeof thirdId == 'undefined' || $.trim(thirdId) == '') {
											return false;
										}
										if ((thirdId == this.value)) {
											third.val(this.value);
											return false;
										}
									});
						});
			});
		}

		// 加载第一层数据
		AjaxPost('/rczp/func/jsonArray.htm', null,
				function(list) {
					if (typeof (list) == "string") {
						list = eval(list);
					}
					var i = 0, size = list.length, opt = null;

					first.empty();
					first.append($('<option value="">==请选择==</option>'));

					for (; i < size; ++i) {
						opt = $('<option></option>');
						opt.val(list[i].id);
						opt.text(list[i].funcName || '');
						opt.attr('title', (list[i].funcName || ''));
						first.append(opt);
					}
					if (first.attr(first.attr('name'))) {
						first.val(first.attr(first.attr('name')));
					}
					// first.change();

					var firstVal = first.val()
							|| first.attr(first.attr('name'));
					Func.asyncUpdateChildSelect.call(first,
							'/rczp/func/jsonArray.htm', 'firstId='+ firstVal, 
							second, true, function(second) {
						var secondId = second.attr('secondId');
						second.children().each(
								function() {// 选择二级区域
									if (typeof secondId == 'undefined'
											|| $.trim(secondId) == '') {
										return false;
									}
									// alert(this.value)
									if ((secondId == this.value)) {
										second.val(this.value);
										second.change();
										return false;
									}
								});
					});
				});

		first.change(function() {
			Func.asyncUpdateChildSelect.call(this, '/rczp/func/jsonArray.htm', 'firstId', second, true);
		});

	}

});
var Func = {
	asyncUpdateChildSelect : function(url, parentSelectName, jq_cselect,
			hasDef, callback) {
		// alert("2:"+$);
		var val = null, parentId = null, i = 0;
		if (this != Func) {
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
				(this == Func) ? "parentId" : ("parentId=" + val),
				function(list) {
					if (typeof (list) == "string") {
						list = eval(list);
					}
					var i = 0, size = list.length, opt = null;

					jq_cselect.empty();
					if (hasDef) {
						jq_cselect.empty();
						jq_cselect.append($('<option value="">==请选择==</option>'));
					}
					for (; i < size; ++i) {
						opt = $('<option></option>');
						opt.val(list[i].id);
						opt.text(list[i].funcName || '');
						opt.attr('title', (list[i].funcName || ''));
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