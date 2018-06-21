	$.extend($.messager.defaults,{
	ok:"确定",
	cancel:"取消"
});
$(document).ready(function() {
	$("#level1").combobox({
		onChange : function(newValue, oldValue) {
			var data = [];
			switch (newValue) {
			case "果树管理":
				data.push({
					"text" : "果树嫁接技术",
					"value" : "果树嫁接技术",
					"selected" : true
				});
				data.push({
					"text" : "苹果栽培管理技术",
					"value" : "苹果栽培管理技术"
				});
				data.push({
					"text" : "猕猴桃栽培管理技术",
					"value" : "猕猴桃栽培管理技术"
				});
				data.push({
					"text" : "枣栽培管理技术（冬枣）",
					"value" : "枣栽培管理技术（冬枣）"
				});
				data.push({
					"text" : "核桃栽培管理技术",
					"value" : "核桃栽培管理技术"
				});
				data.push({
					"text" : "杂果栽培管理技术（桃、杏、樱桃）",
					"value" : "杂果栽培管理技术（桃、杏、樱桃）"
				});
				break;
			case "设施蔬菜":
				data.push({
					"text" : "设施蔬菜栽培管理技术",
					"value" : "设施蔬菜栽培管理技术",
					"selected" : true
				});
				break;
			case "畜牧养殖":
				data.push({
					"text" : "生猪饲养管理技术",
					"value" : "生猪饲养管理技术",
					"selected" : true
				});
				data.push({
					"text" : "奶山羊饲养管理技术",
					"value" : "奶山羊饲养管理技术"
				});
				data.push({
					"text" : "鸡饲养管理技术（肉鸡、蛋鸡）",
					"value" : "鸡饲养管理技术（肉鸡、蛋鸡）"
				});
				data.push({
					"text" : "兔饲养管理技术",
					"value" : "兔饲养管理技术"
				});
				data.push({
					"text" : "牛饲养管理技术（肉牛、奶牛）",
					"value" : "牛饲养管理技术（肉牛、奶牛）"
				});
				data.push({
					"text" : "动物疫病防治员",
					"value" : "动物疫病防治员"
				});
				data.push({
					"text" : "动物繁殖员",
					"value" : "动物繁殖员"
				});
				break;
			case "植物保护":
				data.push({
					"text" : "蔬菜植物保护工",
					"value" : "蔬菜植物保护工",
					"selected" : true
				});
				data.push({
					"text" : "农作物植物保护工",
					"value" : "农作物植物保护工"
				});
				data.push({
					"text" : "果树植物保护工",
					"value" : "果树植物保护工"
				});
				break;
			case "其它":
				data.push({
					"text" : "农作物种子繁殖员",
					"value" : "农作物种子繁殖员",
					"selected" : true
				});
				data.push({
					"text" : "花卉园艺",
					"value" : "花卉园艺师"
				});
				data.push({
					"text" : "绿化种苗工",
					"value" : "绿化种苗工"
				});
				data.push({
					"text" : "食用菌培养技术",
					"value" : "食用菌培养技术"
				});
				data.push({
					"text" : "农村经纪人",
					"value" : "农村经纪人"
				});
				break;
			default:
				break;
			}
			$("#profession1").combobox("loadData", data);
		}
	})
});
