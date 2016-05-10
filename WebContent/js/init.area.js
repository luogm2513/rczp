/**
 * 系统的一些初始化数据及其操作。 1.区域数据； 2.行业数据； 3.专业数据；
 * 
 * 基于jQuery实现，
 * 
 * @date 2014-04-01
 */
$(function() {
	var province = $('#province_id'), city = $('#city_id'), county = $('#county_id');

	// 异步请求城市信息
	if (province.length && city.length) {
		if (county.length) {
			city.change(function() {
				Area.asyncUpdateChildSelect.call(this,
						'/rczp/area/jsonArray.htm', 'cityId', county, true,
						function(county) {
							county.children().each(
									function() {// 选择三级区域
										var countyId = county.attr('countyId');
										if (typeof countyId == 'undefined' || $.trim(countyId) == '') {
											return false;
										}
										if ((countyId == this.value)) {
											county.val(this.value);
											return false;
										}
									});
						});
			});
		}

		// 加载省份数据
		AjaxPost('/rczp/area/jsonArray.htm', null,
				function(list) {
					if (typeof (list) == "string") {
						list = eval(list);
					}
					var i = 0, size = list.length, opt = null;

					province.empty();
					province.append($('<option value="">==请选择==</option>'));

					for (; i < size; ++i) {
						opt = $('<option></option>');
						opt.val(list[i].areaId);
						opt.text(list[i].areaName || '');
						opt.attr('title', (list[i].areaName || ''));
						province.append(opt);
					}
					if (province.attr(province.attr('name'))) {
						province.val(province.attr(province.attr('name')));
					}
					// province.change();

					var proVal = province.val()
							|| province.attr(province.attr('name'));
					Area.asyncUpdateChildSelect.call(province,
							'/rczp/area/jsonArray.htm', 'provinceId='+ proVal, 
							city, true, function(city) {
						var cityId = city.attr('cityId');
						// alert(cityId);
						city.children().each(
								function() {// 选择二级区域
									if (typeof cityId == 'undefined'
											|| $.trim(cityId) == '') {
										return false;
									}
									// alert(this.value)
									if ((cityId == this.value)) {
										city.val(this.value);
										city.change();
										return false;
									}
								});
					});
				});

		province.change(function() {
			Area.asyncUpdateChildSelect.call(this, '/rczp/area/jsonArray.htm', 'provinceId', city, true);
		});

	}

});
var Area = {
	asyncUpdateChildSelect : function(url, parentSelectName, jq_cselect,
			hasDef, callback) {
		// alert("2:"+$);
		var val = null, parentId = null, i = 0;
		if (this != Area) {
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
				(this == Area) ? "parentId" : ("parentId=" + val),
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
						opt.val(list[i].areaId);
						opt.text(list[i].areaName || '');
						opt.attr('title', (list[i].areaName || ''));
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