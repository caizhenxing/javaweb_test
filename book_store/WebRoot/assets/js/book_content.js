function getContent(page, dump) {

	var len = $("#len");
	var bookid = $("#bookid");
	var off = $("#off");

	if (off < 0 || len == 0) {
		alert("参数有误,请检查!");
	}

	var l = parseInt(len.val());
	var o = parseInt(off.val());
	if (dump) {
		o = (page-1) * l;
	}else{
		o = o + (l * parseInt(page));
	}
	

	var offset = parseInt(off.val() == '' ? '0' : off.val(), 10) + l;
	var base_path = $("base").attr("href");
	var url = base_path + "bookContent/part.do?bookId=" + bookid.val()
			+ "&len=" + l + "&off=" + o + "&client=1";
	//window.alert("书id:"+bookid+ "起点:" + off+" 长度:"+len +"url"+url);
	$.get(url, function(data, status) {
		var d = data.replace(/&#034;/g, "\"");
		d = d.replace(/[\r\n]/g, "");
		var part = $("#part");
		part.empty();
		var obj = jQuery.parseJSON(d);
		var p = obj.part;

		$.base64.utf8encode = true;
		var d = ($.base64.atob(p, true));
		part.text(d);

		len.val(obj.page.len);
		bookid.val(obj.book.bookid);
		off.val(obj.page.off);
		$("#pagenum").val((obj.page.off / obj.page.len) + 1);
		$("#nextpage").attr('disabled', obj.page.end);
		$("#beforepage").attr('disabled', obj.page.off == 0);
		$('body,html').animate( {
			scrollTop : 0
		}, 10);
	});

}
$(document).ready(function() {
	getContent(0);
	$("#nextpage").click(function() {
		getContent(1);
	});
	$("#beforepage").click(function() {
		getContent(-1);
	});
	$("#gotopage").click(function() {

		var num = $("#pagenum");
		var n = parseInt(num.val(), 10);
		getContent(n, true);
	});
	$("#mainpage").click(function() {
		var base = $("#basePath");
		location.href = base.val() + "/book/bookview.do";
	})
});