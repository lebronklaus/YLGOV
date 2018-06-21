$(function() {
	$('#ChinaMap').SVGMap({
		mapName : 'china',
		mapWidth : 600,
		mapHeight : 500,
		clickCallback : function(stateData, obj) {
			$(function() {
				parent.shengfen(obj.name);
			})
		}

	});
})