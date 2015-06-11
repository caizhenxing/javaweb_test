//获取书
function getBooks(off, len) {

	if (off < 0 || len == 0) {
		alert("参数有误,请检查!");
	}

	var base_path = $("base").attr("href");
	var url_ = base_path + "/book/books.do?off=" + off + "&len=" + len;
	//alert('--:'+url);
	//$.getJSON(url_,null, callback);

	$.get(url_, callback);

}
//行点击事件
function cellClick(event) {

	if (event.target.id=='ope'){
		return;
	}
	var td = event.currentTarget.children[3];
	//alert('点了:'+td.textContent);
	var base_path = $("base").attr("href");
	location.href = 'bookContent/partview.do?bookid='+td.textContent;
}

function callback(data) {

	var d = data.replace(/&#034;/g, "\"");
	//var part = $("#part");
	//part.empty();
	var obj = jQuery.parseJSON(d);
	$("#len").val(obj.page.len);
	$("#off").val(obj.page.off);
	var books = obj.books;
	var trHtml = "<tr id=\"book_cell\" width=\"30%\" \onmouseover=\"this.style.backgroundColor='#ffff66';\"onmouseout=\"this.style.backgroundColor='#d4e3e5';\"></tr>";
	var tdHtml = "<td id=\"\"></td>";
	var tr = $(trHtml);
	var td = $(tdHtml);

	var table = $("#book_list_table");
	var oldRow = $("#book_cell");
	while (oldRow.length > 0) {
		oldRow.remove();
		oldRow = $("#book_cell");
	}
	for ( var i = 0; i < books.length; i++) {
		var book = books[i];
		var tmp = tr.clone();

		var tdId = td.clone();
		var tdName = td.clone();
		var tdOpe = td.clone();
		var tdbid = td.clone();

		tdId.append(book.bookid);
		tdName.append(book.name);
		tdOpe.append('编辑');
		tdbid.append(book.bookid);
		
		tdbid.hide();
		tdbid.attr('id','bookid');
		tdId.attr('id','bid');
		tdName.attr('id', 'name');
		tdOpe.attr('id', 'ope');
		
		tdId.attr('width','10%');
		tdOpe.attr('width','20%');
		tmp.append(tdId);
		tmp.append(tdName);
		tmp.append(tdOpe);
		tmp.append(tdbid);
		
		table.append(tmp);
	}
}

$(document).ready(function() {

	function get() {
		getBooks(0, 20);
	}
	get();
	//上一页
		$("#booklist_beforePage").click(
				function(event) {
					var len = $("#len");
					var off = $("#off");
					getBooks(parseInt(off.val(), 10) - parseInt(len.val(), 10),
							parseInt(len.val(), 10));
				});

		//下一页
		$("#booklist_nextPage").click(
				function(event) {
					var len = $("#len");
					var off = $("#off");
					getBooks(parseInt(off.val(), 10) + parseInt(len.val(), 10),
							parseInt(len.val(), 10));
				});
		$("#book_list_table").on('click', '#book_cell', cellClick);
	});