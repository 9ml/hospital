window.onload = function () {
    // 心率
    $("#Minp1,#Minp2,#Minp3,#Minp4,#Minp5,#Minp6").focus(function () {
        $mp = $(this).parent().find(".Mp");
        $mp.text("允许误差 ± 5%");
        $mp.removeClass("no").removeClass("is");
    });
    $("#Minp1,#Minp2,#Minp3,#Minp4,#Minp5,#Minp6").blur(function () {
        var val = ~~$(this).val() || 0;
        var defaultVal = $(this).data("default");
        var wc = val * 0.05 + 1;
        $mp = $(this).parent().find(".Mp");
        if (Math.abs(defaultVal - val) <= wc) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
    //呼吸频率
    $("#Minp7,#Minp8,#Minp9,#Minp10,#Minp11,#Minp12").focus(function () {
        $mp = $(this).parent().find(".Mp");
        $mp.text("允许误差 ± 5%");
        $mp.removeClass("no").removeClass("is");
    });
    $("#Minp7,#Minp8,#Minp9,#Minp10,#Minp11,#Minp12").blur(function () {
        var val = ~~$(this).val() || 0;
        var defaultVal = $(this).data("default");
        var wc = val * 0.05 + 1;
        $mp = $(this).parent().find(".Mp");
        if (Math.abs(defaultVal - val) <= wc) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
    //血氧饱和度
    $("#Minp13,#Minp14,#Minp15,#Minp16,#Minp17,#Minp18").focus(function () {
        $mp = $(this).parent().find(".Mp");
        $mp.text("允许误差 ± 3%");
        $mp.removeClass("no").removeClass("is");
    });
    $("#Minp13,#Minp14,#Minp15,#Minp16,#Minp17,#Minp18").blur(function () {
        var val = ~~$(this).val() || 0;
        var defaultVal = $(this).data("default");
        $mp = $(this).parent().find(".Mp");
        if (Math.abs(defaultVal - val) <= 3) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
    //无创血压
    $("#MssyA1,#MssyA2,#MssyA4,#MssyA5,#MssyA7,#MssyA8,#MssyA10,#MssyA11,#MssyA13,#MssyA14").focus(function () {
        var $item = $(this).parents(".layui-colla-content").find(".MssyAPAvg");
        $item.text("首次检测:± 3mmHg;使用中检测:±4mmHg");
        $item.removeClass("no").removeClass("is");
    });
    $("#MssyA1,#MssyA2,#MssyA4,#MssyA5,#MssyA7,#MssyA8,#MssyA10,#MssyA11,#MssyA13,#MssyA14").blur(function () {
        var $parent = $(this).parents(".layui-colla-content");
        var val1 = ~~$parent.find("input").eq(0).val();
        var val2 = ~~$parent.find("input").eq(1).val();
        var avg = (val1 + val2) / 2;
        if (avg) {
            $parent.find("input").eq(2).val(avg);
        }
        var val = avg;
        var defaultVal = $parent.find("input").eq(2).data("default");
        var $mp = $parent.find(".MssyAPAvg");
        if (Math.abs(defaultVal - val) <= 3) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
    //无创动态徐娅重复性
    $("#Minp19,#Minp20,#Minp21,#Minp122,#Minp23").focus(function () {
        $("#Mp18").text("允许误差：5mmHg");
        $("#Mp18").removeClass("no").removeClass("is");
    });
    $("#Minp19,#Minp20,#Minp21,#Minp122,#Minp23").blur(function () {
        var vals = [];
        $(".wcdtxy").each(function () {
            var val = $(this).val();
            if (!val) {
                return false;
            }
            if (val.indexOf("/") === -1) {
                return false;
            }
            vals.push(val);
        });
        if (vals.length !== 5) {
            $("#Mp18").text("× 不符合");
            $("#Mp18").removeClass("is").addClass("no");
            return;
        }
        var shouArr = [], shuArr = [];
        for (var i = 0; i < vals.length; i++) {
            shouArr.push(vals[i].split("/")[0]);
            shuArr.push(vals[i].split("/")[1]);
        }
        var shouMax = Math.max.apply(null, shouArr);
        var shouMin = Math.min.apply(null, shouArr);
        var shuMax = Math.max.apply(null, shuArr);
        var shuMin = Math.min.apply(null, shuArr);
        var shouCha = shouMax - shouMin;
        var shuCha = shuMax - shuMin;
        var cha = Math.max(shouCha, shuCha);
        if (cha / 2.33 <= 5) {
            $("#Mp18").text("√ 符合");
            $("#Mp18").removeClass("no").addClass("is");
        } else {
            $("#Mp18").text("× 不符合");
            $("#Mp18").removeClass("is").addClass("no");
        }
    });
    //气密性
    $("#MssyA17,#MssyA18,#MssyA20,#MssyA21").focus(function () {
        var $item = $(this).parents(".layui-colla-content").find(".MssyAPAvg");
        $item.text("6mmHg/min");
        $item.removeClass("no").removeClass("is");
    });
    $("#MssyA17,#MssyA18,#MssyA20,#MssyA21").blur(function () {
        var $parent = $(this).parents(".layui-colla-content");
        var val1 = ~~$parent.find("input").eq(0).val();
        var val2 = ~~$parent.find("input").eq(1).val();
        var avg = (val2 - val1) / 5;
        var $mp = $parent.find(".MssyAPAvg");
        if (avg <= 6) {
            $mp.text("√ 符合");
            $mp.removeClass("no").addClass("is");
        } else {
            $mp.text("× 不符合");
            $mp.removeClass("is").addClass("no");
        }
    });
}