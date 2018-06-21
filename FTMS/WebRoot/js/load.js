function hasClass(obj, cls) {
    return obj.className.match(new RegExp('(\\s|^)' + cls + '(\\s|$)'));
}

function addClass(obj, cls) {
    if (!this.hasClass(obj, cls)) obj.className += " " + cls;
}

function removeClass(obj, cls) {
    if (hasClass(obj, cls)) {
        var reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
        obj.className = obj.className.replace(reg, ' ');
    }
}

function showThis(number, divName, divID,aID) {
    var tarArr = document.getElementsByTagName("div");
    var count = 0;
    for (var i = 0; i < tarArr.length; i++) {
        if (tarArr[i].getAttribute("name") != null) {
            if (tarArr[i].getAttribute("name") == divName) {
                count++;
            }
        }
    }
    //将所有的name=divNumber的div都加上hiddendiv
    for (var j = 1; j <= count; j++) {
        var divEle = document.getElementById(divID + j);
        if (!hasClass(divEle, "hiddendiv"))
        { addClass(divEle, "hiddendiv"); }
		var tabA = document.getElementById(aID+j);
		if(hasClass(tabA,"a0"))
		{removeClass(tabA,"a0");
		addClass(tabA,"a1");}
    }
    //给当前的div移除hiddendiv
    var divThis = document.getElementById(divID + number);
    removeClass(divThis, "hiddendiv");
	var AThis=document.getElementById(aID+number);
	removeClass(AThis,"a1");
	addClass(AThis,"a0");
    document.getElementsByClassName();



}// JavaScript Document