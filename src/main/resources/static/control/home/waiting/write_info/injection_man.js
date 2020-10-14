window.onload = function () {
    // 流量测试点 —— 5 ml/h
    $(".group_llcsd5 input").blur(function () {
        var csz1 = ~~$("#lljcCsz1").val() || 0;
        var csz2 = ~~$("#lljcCsz2").val() || 0;
        var csz3 = ~~$("#lljcCsz3").val() || 0;
        var avg = ((csz1 + csz2 + csz3) / 3).toFixed(2);
        $("#lljcPjz1").val(avg);
        var wc = ((5 - avg) / avg) * 100;
        var $mp = $(".group_llcsd5 .mp");
        if (Math.abs(wc) <= 6) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
    // 流量测试点 —— 25 ml/h
    $(".group_llcsd25 input").blur(function () {
        var csz1 = ~~$("#lljcCsz4").val() || 0;
        var csz2 = ~~$("#lljcCsz5").val() || 0;
        var csz3 = ~~$("#lljcCsz6").val() || 0;
        var avg = ((csz1 + csz2 + csz3) / 3).toFixed(2);
        $("#lljcPjz2").val(avg);
        var wc = ((25 - avg) / avg) * 100;
        var $mp = $(".group_llcsd25 .mp");
        if (Math.abs(wc) <= 5) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
    //阻塞报警
    $(".group_zsbj input").blur(function () {
        var $group = $(this).parents(".group_zsbj").eq(0);
        var ylz = $group.find("input").eq(0);
        var csz = $group.find("input").eq(1);
        var wc1 = ((ylz - csz) / ylz) * 100;
        var wc2 = ylz - csz;
        var $mp = $group.find(".mp");
        if (Math.abs(wc2) <= 100 || Math.abs(wc1) <= 30) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
}