(function($) {
	function pagerFilter(data) {
		if ($.isArray(data)) { // is array
			data = {
				total : data.length,
				rows : data
			}
		}
		var dg = $(this);
		var state = dg.data('datagrid');
		var opts = dg.datagrid('options');
		if (!state.allRows) {
			state.allRows = (data.rows);
		}
		var start = (opts.pageNumber - 1) * parseInt(opts.pageSize);
		var end = start + parseInt(opts.pageSize);
		data.rows = $.extend(true, [], state.allRows.slice(start, end));
		return data;
	}

	var loadDataMethod = $.fn.datagrid.methods.loadData;
	$.extend($.fn.datagrid.methods, {
		clientPaging : function(jq) {
			return jq.each(function() {
				var dg = $(this);
				var state = dg.data('datagrid');
				var opts = state.options;
				opts.loadFilter = pagerFilter;
				var onBeforeLoad = opts.onBeforeLoad;
				opts.onBeforeLoad = function(param) {
					state.allRows = null;
					return onBeforeLoad.call(this, param);
				}
				dg.datagrid('getPager').pagination({
					onSelectPage : function(pageNum, pageSize) {
						opts.pageNumber = pageNum;
						opts.pageSize = pageSize;
						$(this).pagination('refresh', {
							pageNumber : pageNum,
							pageSize : pageSize
						});
						dg.datagrid('loadData', state.allRows);
					}
				});
				$(this).datagrid('loadData', state.data);
				if (opts.url) {
					$(this).datagrid('reload');
				}
			});
		},
		loadData : function(jq, data) {
			jq.each(function() {
				$(this).data('datagrid').allRows = null;
			});
			return loadDataMethod.call($.fn.datagrid.methods, jq, data);
		},
		getAllRows : function(jq) {
			return jq.data('datagrid').allRows;
		}
	})
})(jQuery);

function getData() {
	var rows = [];
	for (var i = 1; i <= 800; i++) {
		var amount = Math.floor(Math.random() * 1000);
		var price = Math.floor(Math.random() * 1000);
		rows.push({
			inv : 'Inv No ' + i,
			date : $.fn.datebox.defaults.formatter(new Date()),
			name : 'Name ' + i,
			amount : amount,
			price : price,
			cost : amount * price,
			note : 'Note ' + i
		});
	}
	return rows;
}

$(function() {
	$('#dg').datagrid({
		data : getData()
	}).datagrid('clientPaging');
});
$(function(){
    $('#dg').datagrid({
    	view: detailview,
        detailFormatter: function(rowIndex, rowData){
        	if(rowData.questionType=="选择题"){
        		return '<table  style="border-width:0px;font-size:12px">'+
        		'<tr>' +
                '<td align="right"><b>题目要求：</b></td>' +
                '<td >' + rowData.question + '</td>' +
                '</tr>' +
        		'<tr>' +
                '<td align="right" ><b>A.</b></td>' +
                '<td >' + rowData.selectionA + '</td>' +
        		'<tr>' +
                '<td align="right"><b>B.</b></td>' +
                '<td >' + rowData.selectionB + '</td>' +
                '</tr>' +
        		'<tr>' +
                '<td align="right"><b>C.</b></td>' +
                '<td >' + rowData.selectionC + '</td>' +
                '</tr>' +
        		'<tr>' +
                '<td align="right"><b>D.</b></td>' +
                '<td >' + rowData.selectionD + '</td>' +
                '</tr>' +
        		'<tr>' +
                '<td align="right"><b>答案：</b></td>' +
                '<td >' + rowData.answer + '</td>' +
                '</tr>' +
                '</table>';
        		
        	}else {
        		
        		return '<table style="border-style: none;font-size:12px">'+
        		'<tr>' +
                '<td align="right"><b>题目要求：</b></td>' +
                '<td >' + rowData.question + '</td>' +
                '</tr>' +
        		'<tr>' +
                '<td align="right"><b>答案：</b></td>' +
                '<td >' + rowData.answer + '</td>' +
        		'<tr>' +
                '</table>';
        	}
        }
    });
});