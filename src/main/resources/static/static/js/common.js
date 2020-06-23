/*****************************************
 溢出省略文字、悬浮显示全文
 *****************************************/
$(document).on("mouseover", ".overflow,.user-table td", function () {
    var windowWidth = $(window).width() - 190;
    var containerLength = $(this)[0].clientWidth;
    var textLength = $(this)[0].scrollWidth;
    var text = $(this).text();
    var $ts = $(".ts");
    if ($ts.length === 0) {
        $('body').append("<div class='ts'></div>");
        $ts = $(".ts");
    }
    if (textLength > containerLength) {
        $ts.html(text);
        var top;
        if ($(window).height() - $(this).offset().top - $(this).height() < $ts.height()) {
            top = $(this).offset().top - $ts.height() + 20;
        } else {
            top = $(this).offset().top + $(this).height() + 20;
        }
        var left = $(this).offset().left;
        var width = $ts.width();
        var o_width = width + left - windowWidth;
        left = o_width > 0 ? left + $(this).width() - width : left + 22;
        $ts.attr("style", 'top:' + top + 'px' + ';' + 'left:' + left + 'px' + ';' + 'display:block');
    } else {
        $ts.hide();
    }
});
//移除关闭overflow窗口
$(document).on("mouseout", ".overflow,.user-table td", function () {
    $(".ts").hide();
});