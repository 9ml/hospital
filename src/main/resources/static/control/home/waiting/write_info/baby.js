    var AtaP = "";
    var At5sP = "";
window.onload = function(){
    $("#t5sWd15").blur(function(){
        var taP = ((parseFloat($("#txWd1").val()) + parseFloat($("#txWd2").val()) + parseFloat($("#txWd3").val()) + parseFloat($("#txWd4").val()) + parseFloat($("#txWd5").val()) + parseFloat($("#txWd6").val()) + parseFloat($("#txWd7").val()) + parseFloat($("#txWd8").val()) + parseFloat($("#txWd9").val()) + parseFloat($("#txWd10").val()) + parseFloat($("#txWd11").val()) + parseFloat($("#txWd12").val()) + parseFloat($("#txWd13").val()) + parseFloat($("#txWd14").val()) + parseFloat($("#txWd15").val()))/15).toFixed(2);
        var t5sP = ((parseFloat($("#t5sWd1").val()) + parseFloat($("#t5sWd2").val()) + parseFloat($("#t5sWd3").val()) + parseFloat($("#t5sWd4").val()) + parseFloat($("#t5sWd5").val()) + parseFloat($("#t5sWd6").val()) + parseFloat($("#t5sWd7").val()) + parseFloat($("#t5sWd8").val()) + parseFloat($("#t5sWd9").val()) + parseFloat($("#t5sWd10").val()) + parseFloat($("#t5sWd11").val()) + parseFloat($("#t5sWd12").val()) + parseFloat($("#t5sWd13").val()) + parseFloat($("#t5sWd14").val()) + parseFloat($("#t5sWd15").val()))/15).toFixed(2);
        AtaP = taP;
        At5sP = t5sP;
        // 显示平均温度 taP
        $("#wdtxa").val(taP);
        // 温度T5测量平均值T5a (℃)
        $("#wdt5").val(t5sP);
        //  温度偏差
        $("#wdpc").val((Math.abs(taP - t5sP)).toFixed(2));
        if($("#wdpc").val() <= 0.8){
            $("#wc1").text("符合");
            $("#wc1").removeClass("no").addClass("is");
        }else{
            $("#wc1").text("不符合");
            $("#wc1").removeClass("is").addClass("no");
        }
        // 波动度
        $("#bdd").val((Math.max(Math.abs(parseFloat($("#t5sWd1").val()) - At5sP),Math.abs(parseFloat($("#t5sWd2").val()) - At5sP),Math.abs(parseFloat($("#t5sWd3").val()) - At5sP),Math.abs(parseFloat($("#t5sWd4").val()) - At5sP),Math.abs(parseFloat($("#t5sWd5").val()) - At5sP),Math.abs(parseFloat($("#t5sWd6").val()) - At5sP),Math.abs(parseFloat($("#t5sWd7").val()) - At5sP),Math.abs(parseFloat($("#t5sWd8").val()) - At5sP),Math.abs(parseFloat($("#t5sWd9").val()) - At5sP),Math.abs(parseFloat($("#t5sWd10").val()) - At5sP),Math.abs(parseFloat($("#t5sWd11").val()) - At5sP),Math.abs(parseFloat($("#t5sWd12").val()) - At5sP),Math.abs(parseFloat($("#t5sWd13").val()) - At5sP),Math.abs(parseFloat($("#t5sWd14").val()) - At5sP),Math.abs(parseFloat($("#t5sWd15").val()) - At5sP))).toFixed(2));
        if($("#bdd").val() <= 0.8){
            $("#wc3").text("符合");
            $("#wc3").removeClass("no").addClass("is");
        }else{
            $("#wc3").text("不符合");
            $("#wc3").removeClass("is").addClass("no");
        }
    });
    $("#wdt4").blur(function(){
        // 均匀性
        $("#jyx").val((Math.max(Math.abs(parseFloat($("#wdt1").val()) - At5sP),Math.abs(parseFloat($("#wdt2").val()) - At5sP),Math.abs(parseFloat($("#wdt3").val()) - At5sP),Math.abs(parseFloat($("#wdt4").val()) - At5sP))).toFixed(2));
        if($("#jyx").val() <= 0.8){
            $("#wc2").text("符合");
            $("#wc2").removeClass("no").addClass("is");
        }else{
            $("#wc2").text("不符合");
            $("#wc2").removeClass("is").addClass("no");
        }
    });
    $("#kzwd").blur(function(){
        // 温控偏差
        var Mwkpc = parseFloat($("#kzwd").val()) - At5sP;
        $("#wkpc").val((Math.abs(Mwkpc)).toFixed(1));
        if($("#wkpc").val() <= 1.5){
            $("#wc4").text("符合");
            $("#wc4").removeClass("no").addClass("is");
        }else{
            $("#wc4").text("不符合");
            $("#wc4").removeClass("is").addClass("no");
        }
    });
    // 超调量
    $("#ctl").blur(function(){
        if($("#ctl").val() <= 2){
            $("#wc5").text("符合");
            $("#wc5").removeClass("no").addClass("is");
        }else{
            $("#wc5").text("不符合");
            $("#wc5").removeClass("is").addClass("no");
        }
    });
    // 空气流速
    $("#kqls").blur(function(){
        if($("#kqls").val() <= 0.35){
            $("#wc6").text("符合");
            $("#wc6").removeClass("no").addClass("is");
        }else{
            $("#wc6").text("不符合");
            $("#wc6").removeClass("is").addClass("no");
        }
    });
    // 噪声（报警激活状态）
    $("#zsbj").blur(function(){
        if($("#zsbj").val() <= 80){
            $("#wc7").text("符合");
            $("#wc7").removeClass("no").addClass("is");
        }else{
            $("#wc7").text("不符合");
            $("#wc7").removeClass("is").addClass("no");
        }
    });
    // 噪声（正常状态）
    $("#zszc").blur(function(){
        if($("#zszc").val() <= 60){
            $("#wc8").text("符合");
            $("#wc8").removeClass("no").addClass("is");
        }else{
            $("#wc8").text("不符合");
            $("#wc8").removeClass("is").addClass("no");
        }
    });
    // 金属部分
    $("#jsbf").blur(function(){
        if($("#jsbf").val() <= 40){
            $("#wc9").text("符合");
            $("#wc9").removeClass("no").addClass("is");
        }else{
            $("#wc9").text("不符合");
            $("#wc9").removeClass("is").addClass("no");
        }
    });
    // 床垫部分
    $("#cdbf").blur(function(){
        if($("#cdbf").val() <= 43){
            $("#wc10").text("符合");
            $("#wc10").removeClass("no").addClass("is");
        }else{
            $("#wc10").text("不符合");
            $("#wc10").removeClass("is").addClass("no");
        }
    });
    // 湿度偏差
    $("#sdcsz").blur(function(){
        var sdpc = (parseFloat($("#sdszz").val()) - parseFloat($("#sdcsz").val())).toFixed(2);
        if(Math.abs(sdpc) <= parseFloat($("#sdszz").val())*0.1){
            $("#wc11").text("符合");
            $("#wc11").removeClass("no").addClass("is");
        }else{
            $("#wc11").text("不符合");
            $("#wc11").removeClass("is").addClass("no");
        }
    });
}