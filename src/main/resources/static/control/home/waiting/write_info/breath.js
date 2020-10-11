window.onload = function () {
    //电气安全检测 获得光标检测公式
    $(document).on("focus", ".dqaqjc input[type=text]", function () {
        var dataTarget = $(this).attr("data-target");
        $(this).parent().find(".jcjgTip").text(dataTarget).removeClass("no").removeClass("is");
    });
    //电气安全检测 失去光标检测
    $(document).on("blur", ".dqaqjc input[type=text]", function () {
        var dataTarget = $(this).attr("data-target");
        var $tip = $(this).parent().find(".jcjgTip");
        var val = $(this).val();
        var gs = dataTarget.replace(/[^\d^>^≤^>^≥]/g, "").replace("≤", "<=").replace("≥", ">=");
        if (!!val && eval(val + gs)) {
            $tip.text("√ 符合");
            $tip.removeClass("no").addClass("is");
        } else {
            $tip.text("× 不符合");
            $tip.removeClass("is").addClass("no");
        }
        //检测所有的结果

    });
    //潮气量Vt
    $(document).on("blur", ".cqzjc input[type=text]", function () {
        var $group = $(this).parents(".group");
        var v = $group.find(".sign").text();
        //示值误差
        var v0 = ~~((~~$group.find("input[type=text]").eq(0).val() + ~~$group.find("input[type=text]").eq(1).val() + ~~$group.find("input[type=text]").eq(2).val()) / 3);
        $group.find("input[type=text]").eq(3).val(v0);
        var szwc = ((v0 - v) / v) * 100;
        $group.find("input[type=text]").eq(8).val(szwc + "%");
        //输出误差
        var vn = ~~((~~$group.find("input[type=text]").eq(4).val() + ~~$group.find("input[type=text]").eq(5).val() + ~~$group.find("input[type=text]").eq(6).val()) / 3);
        $group.find("input[type=text]").eq(7).val(vn);
        var scwc = ((vn - v) / v) * 100;
        $group.find("input[type=text]").eq(9).val(scwc + "%");
        var $szwcjc = $group.find("input[type=text]").eq(8).parent().find(".jcjgTip");
        var $scwcjc = $group.find("input[type=text]").eq(9).parent().find(".jcjgTip");

        if (Math.abs(szwc) <= 15) {
            $szwcjc.text("√ 符合");
            $szwcjc.removeClass("no").addClass("is");
        } else {
            $szwcjc.text("× 不符合");
            $szwcjc.removeClass("is").addClass("no");
        }
        if (Math.abs(scwc) <= 15) {
            $scwcjc.text("√ 符合");
            $scwcjc.removeClass("no").addClass("is");
        } else {
            $scwcjc.text("× 不符合");
            $scwcjc.removeClass("is").addClass("no");
        }
    });
    //强制通气频率
    $(document).on("blur", ".qztqpljc input[type=text]", function () {
        var $group = $(this).parents(".group");
        var v = $group.find(".sign").text();
        //示值误差
        var v0 = ~~((~~$group.find("input[type=text]").eq(0).val() + ~~$group.find("input[type=text]").eq(1).val() + ~~$group.find("input[type=text]").eq(2).val()) / 3);
        $group.find("input[type=text]").eq(3).val(v0);
        var szwc = ((v0 - v) / v) * 100;
        $group.find("input[type=text]").eq(8).val(szwc + "%");
        //输出误差
        var vn = ~~((~~$group.find("input[type=text]").eq(4).val() + ~~$group.find("input[type=text]").eq(5).val() + ~~$group.find("input[type=text]").eq(6).val()) / 3);
        $group.find("input[type=text]").eq(7).val(vn);
        var scwc = ((vn - v) / v) * 100;
        $group.find("input[type=text]").eq(9).val(scwc + "%");
        var $szwcjc = $group.find("input[type=text]").eq(8).parent().find(".jcjgTip");
        var $scwcjc = $group.find("input[type=text]").eq(9).parent().find(".jcjgTip");

        if (Math.abs(szwc) <= 10) {
            $szwcjc.text("√ 符合");
            $szwcjc.removeClass("no").addClass("is");
        } else {
            $szwcjc.text("× 不符合");
            $szwcjc.removeClass("is").addClass("no");
        }
        if (Math.abs(scwc) <= 10) {
            $scwcjc.text("√ 符合");
            $scwcjc.removeClass("no").addClass("is");
        } else {
            $scwcjc.text("× 不符合");
            $scwcjc.removeClass("is").addClass("no");
        }
    });
    //吸入氧浓度FiO2
    $(document).on("blur", ".xryndjc input[type=text]", function () {
        var $group = $(this).parents(".group");
        var v = $group.find(".sign").text();
        //示值误差
        var v0 = ~~((~~$group.find("input[type=text]").eq(0).val() + ~~$group.find("input[type=text]").eq(1).val() + ~~$group.find("input[type=text]").eq(2).val()) / 3);
        $group.find("input[type=text]").eq(3).val(v0);
        var szwc = v0 - v;
        $group.find("input[type=text]").eq(8).val(szwc + "%");
        //输出误差
        var vn = ~~((~~$group.find("input[type=text]").eq(4).val() + ~~$group.find("input[type=text]").eq(5).val() + ~~$group.find("input[type=text]").eq(6).val()) / 3);
        $group.find("input[type=text]").eq(7).val(vn);
        var scwc = vn - v;
        $group.find("input[type=text]").eq(9).val(scwc + "%");
        var $szwcjc = $group.find("input[type=text]").eq(8).parent().find(".jcjgTip");
        var $scwcjc = $group.find("input[type=text]").eq(9).parent().find(".jcjgTip");

        if (Math.abs(szwc) <= 5) {
            $szwcjc.text("√ 符合");
            $szwcjc.removeClass("no").addClass("is");
        } else {
            $szwcjc.text("× 不符合");
            $szwcjc.removeClass("is").addClass("no");
        }
        if (Math.abs(scwc) <= 5) {
            $scwcjc.text("√ 符合");
            $scwcjc.removeClass("no").addClass("is");
        } else {
            $scwcjc.text("× 不符合");
            $scwcjc.removeClass("is").addClass("no");
        }
    });
    //吸气峰值压力
    $(document).on("blur", ".xqfzyljc input[type=text]", function () {
        var $group = $(this).parents(".group");
        var v = $group.find(".sign").text();
        //示值误差
        var v0 = ~~((~~$group.find("input[type=text]").eq(0).val() + ~~$group.find("input[type=text]").eq(1).val() + ~~$group.find("input[type=text]").eq(2).val()) / 3);
        $group.find("input[type=text]").eq(3).val(v0);
        var szwc = v0 - v;
        $group.find("input[type=text]").eq(8).val(szwc + "%");
        //输出误差
        var vn = ~~((~~$group.find("input[type=text]").eq(4).val() + ~~$group.find("input[type=text]").eq(5).val() + ~~$group.find("input[type=text]").eq(6).val()) / 3);
        $group.find("input[type=text]").eq(7).val(vn);
        var scwc = vn - v;
        $group.find("input[type=text]").eq(9).val(scwc + "%");
        var $szwcjc = $group.find("input[type=text]").eq(8).parent().find(".jcjgTip");
        var $scwcjc = $group.find("input[type=text]").eq(9).parent().find(".jcjgTip");
        var zdycVal = $("#xqfzylZdyc1").val();
        var zdyc = (0.02 * zdycVal + 0.04 * vn) * 100;
        if (Math.abs(szwc) <= zdyc) {
            $szwcjc.text("√ 符合");
            $szwcjc.removeClass("no").addClass("is");
        } else {
            $szwcjc.text("× 不符合");
            $szwcjc.removeClass("is").addClass("no");
        }
        if (Math.abs(scwc) <= 5) {
            $scwcjc.text("√ 符合");
            $scwcjc.removeClass("no").addClass("is");
        } else {
            $scwcjc.text("× 不符合");
            $scwcjc.removeClass("is").addClass("no");
        }
    });
    //呼气末正压PEEP
    $(document).on("blur", ".hqmzyjc input[type=text]", function () {
        var $group = $(this).parents(".group");
        var v = $group.find(".sign").text();
        //示值误差
        var v0 = ~~((~~$group.find("input[type=text]").eq(0).val() + ~~$group.find("input[type=text]").eq(1).val() + ~~$group.find("input[type=text]").eq(2).val()) / 3);
        $group.find("input[type=text]").eq(3).val(v0);
        var szwc = v0 - v;
        $group.find("input[type=text]").eq(8).val(szwc + "%");
        //输出误差
        var vn = ~~((~~$group.find("input[type=text]").eq(4).val() + ~~$group.find("input[type=text]").eq(5).val() + ~~$group.find("input[type=text]").eq(6).val()) / 3);
        $group.find("input[type=text]").eq(7).val(vn);
        var scwc = vn - v;
        $group.find("input[type=text]").eq(9).val(scwc + "%");
        var $szwcjc = $group.find("input[type=text]").eq(8).parent().find(".jcjgTip");
        var $scwcjc = $group.find("input[type=text]").eq(9).parent().find(".jcjgTip");
        var zdycVal = $("#hqmzyZdyc1").val();
        var zdyc = (0.02 * zdycVal + 0.04 * vn) * 100;
        if (Math.abs(szwc) <= zdyc) {
            $szwcjc.text("√ 符合");
            $szwcjc.removeClass("no").addClass("is");
        } else {
            $szwcjc.text("× 不符合");
            $szwcjc.removeClass("is").addClass("no");
        }
        if (Math.abs(scwc) <= 5) {
            $scwcjc.text("√ 符合");
            $scwcjc.removeClass("no").addClass("is");
        } else {
            $scwcjc.text("× 不符合");
            $scwcjc.removeClass("is").addClass("no");
        }
    });
}