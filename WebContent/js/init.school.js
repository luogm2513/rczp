/**
 * 系统的一些初始化数据及其操作。 1.区域数据； 2.行业数据； 3.专业数据；
 * 
 * 基于jQuery实现，
 * 
 * @date 2014-04-01
 */
$(function() {
	var province = $('#province'), school = $('#school');
	if (province.length) {
		if(school.length){
			province.change(function() {
				School.asyncUpdateChildSelect.call(this, '/rczp/school/schoolJsonArray.htm', 'provinceId', school, true);
			});
		}
		// 加载省份数据
		AjaxPost('/rczp/school/provinceJsonArray.htm', null, function(list) {
			if (typeof (list) == "string") {
				list = eval(list);
			}
			var i = 0, size = list.length, opt = null;

			province.empty();
			province.append($('<option value="">==请选择==</option>'));

			for (; i < size; ++i) {
				opt = $('<option></option>');
				opt.val(list[i].provinceId);
				opt.text(list[i].provinceName || '');
				opt.attr('title', (list[i].provinceName || ''));
				province.append(opt);
			}
			if (province.attr(province.attr('name'))) {
				province.val(province.attr(province.attr('name')));
			}
			// province.change();

			var provinceVal = province.val() || province.attr(province.attr('name'));
			School.asyncUpdateChildSelect.call(province,
					'/rczp/school/schoolJsonArray.htm', 'provinceId=' + provinceVal, school,
					true, function(school) {
						var schoolId = school.attr('schoolId');
						// alert(sonId);
						school.children().each(
								function() {// 选择二级区域
									if (typeof schoolId == 'undefined'
											|| $.trim(schoolId) == '') {
										return false;
									}
									// alert(this.value)
									if ((schoolId == this.value)) {
										school.val(this.value);
										school.change();
										return false;
									}
								});
					});
		});
	}
});
var School = {
	asyncUpdateChildSelect : function(url, parentSelectName, jq_cselect,
			hasDef, callback) {
		// alert("2:"+$);
		var val = null, parentId = null, i = 0;
		if (this != School) {
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
				(this == School) ? "parentId" : ("parentId=" + val),
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
						opt.val(list[i].schoolId);
						opt.text(list[i].schoolName || '');
						opt.attr('title', (list[i].schoolName || ''));
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