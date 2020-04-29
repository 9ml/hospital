window.onload = function(){
    // 成人
    $("#Minp1").focus(function () {
        $("#Mp1").text("允许误差 ± 5%");
        $("#Mp1").removeClass("no").removeClass("is");
    });
    $("#Minp1").blur(function () {
        if($(this).val()>=28.5 && $(this).val()<=31.5){
            $("#Mp1").text("√ 符合");
            $("#Mp1").removeClass("no").addClass("is");
        }else{
            $("#Mp1").text("× 不符合");
            $("#Mp1").removeClass("is").addClass("no");
        }
    });

    $("#Minp2").focus(function () {
        $("#Mp2").text("允许误差 ± 5%");
        $("#Mp2").removeClass("no").removeClass("is");
    });
    $("#Minp2").blur(function () {
        if($(this).val()>=57 && $(this).val()<=63){
            $("#Mp2").text("√ 符合");
            $("#Mp2").removeClass("no").addClass("is");
        }else{
            $("#Mp2").text("× 不符合");
            $("#Mp2").removeClass("is").addClass("no");
        }
    });

    $("#Minp3").focus(function () {
        $("#Mp3").text("允许误差 ± 5%");
        $("#Mp3").removeClass("no").removeClass("is");
    });
    $("#Minp3").blur(function () {
        if($(this).val()>=95 && $(this).val()<=105){
            $("#Mp3").text("√ 符合");
            $("#Mp3").removeClass("no").addClass("is");
        }else{
            $("#Mp3").text("× 不符合");
            $("#Mp3").removeClass("is").addClass("no");
        }
    });

    $("#Minp4").focus(function () {
        $("#Mp4").text("允许误差 ± 5%");
        $("#Mp4").removeClass("no").removeClass("is");
    });
    $("#Minp4").blur(function () {
        if($(this).val()>=114 && $(this).val()<=126){
            $("#Mp4").text("√ 符合");
            $("#Mp4").removeClass("no").addClass("is");
        }else{
            $("#Mp4").text("× 不符合");
            $("#Mp4").removeClass("is").addClass("no");
        }
    });

    $("#Minp5").focus(function () {
        $("#Mp5").text("允许误差 ± 5%");
        $("#Mp5").removeClass("no").removeClass("is");
    });
    $("#Minp5").blur(function () {
        if($(this).val()>=171 && $(this).val()<=189){
            $("#Mp5").text("√ 符合");
            $("#Mp5").removeClass("no").addClass("is");
        }else{
            $("#Mp5").text("× 不符合");
            $("#Mp5").removeClass("is").addClass("no");
        }
    });

    $("#Minp6").focus(function () {
        $("#Mp6").text("允许误差 ± 5%");
        $("#Mp6").removeClass("no").removeClass("is");
    });
    $("#Minp6").blur(function () {
        if($(this).val()>=14.25 && $(this).val()<=15.75){
            $("#Mp6").text("√ 符合");
            $("#Mp6").removeClass("no").addClass("is");
        }else{
            $("#Mp6").text("× 不符合");
            $("#Mp6").removeClass("is").addClass("no");
        }
    });

    $("#Minp7").focus(function () {
        $("#Mp7").text("允许误差 ± 5%");
        $("#Mp7").removeClass("no").removeClass("is");
    });
    $("#Minp7").blur(function () {
        if($(this).val()>=19 && $(this).val()<=21){
            $("#Mp7").text("√ 符合");
            $("#Mp7").removeClass("no").addClass("is");
        }else{
            $("#Mp7").text("× 不符合");
            $("#Mp7").removeClass("is").addClass("no");
        }
    });

    $("#Minp8").focus(function () {
        $("#Mp8").text("允许误差 ± 5%");
        $("#Mp8").removeClass("no").removeClass("is");
    });
    $("#Minp8").blur(function () {
        if($(this).val()>=38 && $(this).val()<=42){
            $("#Mp8").text("√ 符合");
            $("#Mp8").removeClass("no").addClass("is");
        }else{
            $("#Mp8").text("× 不符合");
            $("#Mp8").removeClass("is").addClass("no");
        }
    });

    $("#Minp9").focus(function () {
        $("#Mp9").text("允许误差 ± 5%");
        $("#Mp9").removeClass("no").removeClass("is");
    });
    $("#Minp9").blur(function () {
        if($(this).val()>=57 && $(this).val()<=63){
            $("#Mp9").text("√ 符合");
            $("#Mp9").removeClass("no").addClass("is");
        }else{
            $("#Mp9").text("× 不符合");
            $("#Mp9").removeClass("is").addClass("no");
        }
    });

    $("#Minp10").focus(function () {
        $("#Mp10").text("允许误差 ± 5%");
        $("#Mp10").removeClass("no").removeClass("is");
    });
    $("#Minp10").blur(function () {
        if($(this).val()>=76 && $(this).val()<=84){
            $("#Mp10").text("√ 符合");
            $("#Mp10").removeClass("no").addClass("is");
        }else{
            $("#Mp10").text("× 不符合");
            $("#Mp10").removeClass("is").addClass("no");
        }
    });

    $("#MssyA1").focus(function () {
        $("#MssyA1P").text("8.5mmHg");
        $("#MssyA1P").removeClass("no").removeClass("is");
    });
    $("#MssyA2").focus(function () {
        $("#MssyA2P").text("8.5mmHg");
        $("#MssyA2P").removeClass("no").removeClass("is");
    });
    $("#MssyA3").focus(function () {
        $("#MssyA3P").text("8.5mmHg");
        $("#MssyA3P").removeClass("no").removeClass("is");
    });
    $("#MssyA3").blur(function () {
        var MssyMax = Math.max($("#MssyA1").val(),$("#MssyA2").val(),$("#MssyA3").val());
        var MssyMin = Math.min($("#MssyA1").val(),$("#MssyA2").val(),$("#MssyA3").val());
        if($("#MssyA1").val() != "" && $("#MssyA2").val() != "" && $("#MssyA3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MssyA1P").text("√ 符合");
            $("#MssyA1P").removeClass("no").addClass("is");
            $("#MssyA2P").text("√ 符合");
            $("#MssyA2P").removeClass("no").addClass("is");
            $("#MssyA3P").text("√ 符合");
            $("#MssyA3P").removeClass("no").addClass("is");
        }else{
            $("#MssyA1P").text("× 不符合");
            $("#MssyA1P").removeClass("is").addClass("no");
            $("#MssyA2P").text("× 不符合");
            $("#MssyA2P").removeClass("is").addClass("no");
            $("#MssyA3P").text("× 不符合");
            $("#MssyA3P").removeClass("is").addClass("no");
        }
    });

    $("#MszyA1").focus(function () {
        $("#MszyA1P").text("8.5mmHg");
        $("#MszyA1P").removeClass("no").removeClass("is");
    });
    $("#MszyA2").focus(function () {
        $("#MszyA2P").text("8.5mmHg");
        $("#MszyA2P").removeClass("no").removeClass("is");
    });
    $("#MszyA3").focus(function () {
        $("#MszyA3P").text("8.5mmHg");
        $("#MszyA3P").removeClass("no").removeClass("is");
    });
    $("#MszyA3").blur(function () {
        var MssyMax = Math.max($("#MszyA1").val(),$("#MszyA2").val(),$("#MszyA3").val());
        var MssyMin = Math.min($("#MszyA1").val(),$("#MszyA2").val(),$("#MszyA3").val());
        if($("#MszyA1").val() != "" && $("#MszyA2").val() != "" && $("#MszyA3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MszyA1P").text("√ 符合");
            $("#MszyA1P").removeClass("no").addClass("is");
            $("#MszyA2P").text("√ 符合");
            $("#MszyA2P").removeClass("no").addClass("is");
            $("#MszyA3P").text("√ 符合");
            $("#MszyA3P").removeClass("no").addClass("is");
        }else{
            $("#MszyA1P").text("× 不符合");
            $("#MszyA1P").removeClass("is").addClass("no");
            $("#MszyA2P").text("× 不符合");
            $("#MszyA2P").removeClass("is").addClass("no");
            $("#MszyA3P").text("× 不符合");
            $("#MszyA3P").removeClass("is").addClass("no");
        }
    });

    $("#MssyB1").focus(function () {
        $("#MssyB1P").text("8.5mmHg");
        $("#MssyB1P").removeClass("no").removeClass("is");
    });
    $("#MssyB2").focus(function () {
        $("#MssyB2P").text("8.5mmHg");
        $("#MssyB2P").removeClass("no").removeClass("is");
    });
    $("#MssyB3").focus(function () {
        $("#MssyB3P").text("8.5mmHg");
        $("#MssyB3P").removeClass("no").removeClass("is");
    });
    $("#MssyB3").blur(function () {
        var MssyMax = Math.max($("#MssyB1").val(),$("#MssyB2").val(),$("#MssyB3").val());
        var MssyMin = Math.min($("#MssyB1").val(),$("#MssyB2").val(),$("#MssyB3").val());
        if($("#MssyB1").val() != "" && $("#MssyB2").val() != "" && $("#MssyB3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MssyB1P").text("√ 符合");
            $("#MssyB1P").removeClass("no").addClass("is");
            $("#MssyB2P").text("√ 符合");
            $("#MssyB2P").removeClass("no").addClass("is");
            $("#MssyB3P").text("√ 符合");
            $("#MssyB3P").removeClass("no").addClass("is");
        }else{
            $("#MssyB1P").text("× 不符合");
            $("#MssyB1P").removeClass("is").addClass("no");
            $("#MssyB2P").text("× 不符合");
            $("#MssyB2P").removeClass("is").addClass("no");
            $("#MssyB3P").text("× 不符合");
            $("#MssyB3P").removeClass("is").addClass("no");
        }
    });

    $("#MszyB1").focus(function () {
        $("#MszyB1P").text("8.5mmHg");
        $("#MszyB1P").removeClass("no").removeClass("is");
    });
    $("#MszyB2").focus(function () {
        $("#MszyB2P").text("8.5mmHg");
        $("#MszyB2P").removeClass("no").removeClass("is");
    });
    $("#MszyB3").focus(function () {
        $("#MszyB3P").text("8.5mmHg");
        $("#MszyB3P").removeClass("no").removeClass("is");
    });
    $("#MszyB3").blur(function () {
        var MssyMax = Math.max($("#MszyB1").val(),$("#MszyB2").val(),$("#MszyB3").val());
        var MssyMin = Math.min($("#MszyB1").val(),$("#MszyB2").val(),$("#MszyB3").val());
        if($("#MszyB1").val() != "" && $("#MszyB2").val() != "" && $("#MszyB3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MszyB1P").text("√ 符合");
            $("#MszyB1P").removeClass("no").addClass("is");
            $("#MszyB2P").text("√ 符合");
            $("#MszyB2P").removeClass("no").addClass("is");
            $("#MszyB3P").text("√ 符合");
            $("#MszyB3P").removeClass("no").addClass("is");
        }else{
            $("#MszyB1P").text("× 不符合");
            $("#MszyB1P").removeClass("is").addClass("no");
            $("#MszyB2P").text("× 不符合");
            $("#MszyB2P").removeClass("is").addClass("no");
            $("#MszyB3P").text("× 不符合");
            $("#MszyB3P").removeClass("is").addClass("no");
        }
    });

    $("#MssyC1").focus(function () {
        $("#MssyC1P").text("8.5mmHg");
        $("#MssyC1P").removeClass("no").removeClass("is");
    });
    $("#MssyC2").focus(function () {
        $("#MssyC2P").text("8.5mmHg");
        $("#MssyC2P").removeClass("no").removeClass("is");
    });
    $("#MssyC3").focus(function () {
        $("#MssyC3P").text("8.5mmHg");
        $("#MssyC3P").removeClass("no").removeClass("is");
    });
    $("#MssyC3").blur(function () {
        var MssyMax = Math.max($("#MssyC1").val(),$("#MssyC2").val(),$("#MssyC3").val());
        var MssyMin = Math.min($("#MssyC1").val(),$("#MssyC2").val(),$("#MssyC3").val());
        if($("#MssyC1").val() != "" && $("#MssyC2").val() != "" && $("#MssyC3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MssyC1P").text("√ 符合");
            $("#MssyC1P").removeClass("no").addClass("is");
            $("#MssyC2P").text("√ 符合");
            $("#MssyC2P").removeClass("no").addClass("is");
            $("#MssyC3P").text("√ 符合");
            $("#MssyC3P").removeClass("no").addClass("is");
        }else{
            $("#MssyC1P").text("× 不符合");
            $("#MssyC1P").removeClass("is").addClass("no");
            $("#MssyC2P").text("× 不符合");
            $("#MssyC2P").removeClass("is").addClass("no");
            $("#MssyC3P").text("× 不符合");
            $("#MssyC3P").removeClass("is").addClass("no");
        }
    });

    $("#MszyC1").focus(function () {
        $("#MszyC1P").text("8.5mmHg");
        $("#MszyC1P").removeClass("no").removeClass("is");
    });
    $("#MszyC2").focus(function () {
        $("#MszyC2P").text("8.5mmHg");
        $("#MszyC2P").removeClass("no").removeClass("is");
    });
    $("#MszyC3").focus(function () {
        $("#MszyC3P").text("8.5mmHg");
        $("#MszyC3P").removeClass("no").removeClass("is");
    });
    $("#MszyC3").blur(function () {
        var MssyMax = Math.max($("#MszyC1").val(),$("#MszyC2").val(),$("#MszyC3").val());
        var MssyMin = Math.min($("#MszyC1").val(),$("#MszyC2").val(),$("#MszyC3").val());
        if($("#MszyC1").val() != "" && $("#MszyC2").val() != "" && $("#MszyC3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MszyC1P").text("√ 符合");
            $("#MszyC1P").removeClass("no").addClass("is");
            $("#MszyC2P").text("√ 符合");
            $("#MszyC2P").removeClass("no").addClass("is");
            $("#MszyC3P").text("√ 符合");
            $("#MszyC3P").removeClass("no").addClass("is");
        }else{
            $("#MszyC1P").text("× 不符合");
            $("#MszyC1P").removeClass("is").addClass("no");
            $("#MszyC2P").text("× 不符合");
            $("#MszyC2P").removeClass("is").addClass("no");
            $("#MszyC3P").text("× 不符合");
            $("#MszyC3P").removeClass("is").addClass("no");
        }
    });

    $("#MssyD1").focus(function () {
        $("#MssyD1P").text("8.5mmHg");
        $("#MssyD1P").removeClass("no").removeClass("is");
    });
    $("#MssyD2").focus(function () {
        $("#MssyD2P").text("8.5mmHg");
        $("#MssyD2P").removeClass("no").removeClass("is");
    });
    $("#MssyD3").focus(function () {
        $("#MssyD3P").text("8.5mmHg");
        $("#MssyD3P").removeClass("no").removeClass("is");
    });
    $("#MssyD3").blur(function () {
        var MssyMax = Math.max($("#MssyD1").val(),$("#MssyD2").val(),$("#MssyD3").val());
        var MssyMin = Math.min($("#MssyD1").val(),$("#MssyD2").val(),$("#MssyD3").val());
        if($("#MssyD1").val() != "" && $("#MssyD2").val() != "" && $("#MssyD3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MssyD1P").text("√ 符合");
            $("#MssyD1P").removeClass("no").addClass("is");
            $("#MssyD2P").text("√ 符合");
            $("#MssyD2P").removeClass("no").addClass("is");
            $("#MssyD3P").text("√ 符合");
            $("#MssyD3P").removeClass("no").addClass("is");
        }else{
            $("#MssyD1P").text("× 不符合");
            $("#MssyD1P").removeClass("is").addClass("no");
            $("#MssyD2P").text("× 不符合");
            $("#MssyD2P").removeClass("is").addClass("no");
            $("#MssyD3P").text("× 不符合");
            $("#MssyD3P").removeClass("is").addClass("no");
        }
    });

    $("#MszyD1").focus(function () {
        $("#MszyD1P").text("8.5mmHg");
        $("#MszyD1P").removeClass("no").removeClass("is");
    });
    $("#MszyD2").focus(function () {
        $("#MszyD2P").text("8.5mmHg");
        $("#MszyD2P").removeClass("no").removeClass("is");
    });
    $("#MszyD3").focus(function () {
        $("#MszyD3P").text("8.5mmHg");
        $("#MszyD3P").removeClass("no").removeClass("is");
    });
    $("#MszyD3").blur(function () {
        var MssyMax = Math.max($("#MszyD1").val(),$("#MszyD2").val(),$("#MszyD3").val());
        var MssyMin = Math.min($("#MszyD1").val(),$("#MszyD2").val(),$("#MszyD3").val());
        if($("#MszyD1").val() != "" && $("#MszyD2").val() != "" && $("#MszyD3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MszyD1P").text("√ 符合");
            $("#MszyD1P").removeClass("no").addClass("is");
            $("#MszyD2P").text("√ 符合");
            $("#MszyD2P").removeClass("no").addClass("is");
            $("#MszyD3P").text("√ 符合");
            $("#MszyD3P").removeClass("no").addClass("is");
        }else{
            $("#MszyD1P").text("× 不符合");
            $("#MszyD1P").removeClass("is").addClass("no");
            $("#MszyD2P").text("× 不符合");
            $("#MszyD2P").removeClass("is").addClass("no");
            $("#MszyD3P").text("× 不符合");
            $("#MszyD3P").removeClass("is").addClass("no");
        }
    });

    $("#MssyE1").focus(function () {
        $("#MssyE1P").text("8.5mmHg");
        $("#MssyE1P").removeClass("no").removeClass("is");
    });
    $("#MssyE2").focus(function () {
        $("#MssyE2P").text("8.5mmHg");
        $("#MssyE2P").removeClass("no").removeClass("is");
    });
    $("#MssyE3").focus(function () {
        $("#MssyE3P").text("8.5mmHg");
        $("#MssyE3P").removeClass("no").removeClass("is");
    });
    $("#MssyE3").blur(function () {
        var MssyMax = Math.max($("#MssyE1").val(),$("#MssyE2").val(),$("#MssyE3").val());
        var MssyMin = Math.min($("#MssyE1").val(),$("#MssyE2").val(),$("#MssyE3").val());
        if($("#MssyE1").val() != "" && $("#MssyE2").val() != "" && $("#MssyE3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MssyE1P").text("√ 符合");
            $("#MssyE1P").removeClass("no").addClass("is");
            $("#MssyE2P").text("√ 符合");
            $("#MssyE2P").removeClass("no").addClass("is");
            $("#MssyE3P").text("√ 符合");
            $("#MssyE3P").removeClass("no").addClass("is");
        }else{
            $("#MssyE1P").text("× 不符合");
            $("#MssyE1P").removeClass("is").addClass("no");
            $("#MssyE2P").text("× 不符合");
            $("#MssyE2P").removeClass("is").addClass("no");
            $("#MssyE3P").text("× 不符合");
            $("#MssyE3P").removeClass("is").addClass("no");
        }
    });

    $("#MszyE1").focus(function () {
        $("#MszyE1P").text("8.5mmHg");
        $("#MszyE1P").removeClass("no").removeClass("is");
    });
    $("#MszyE2").focus(function () {
        $("#MszyE2P").text("8.5mmHg");
        $("#MszyE2P").removeClass("no").removeClass("is");
    });
    $("#MszyE3").focus(function () {
        $("#MszyE3P").text("8.5mmHg");
        $("#MszyE3P").removeClass("no").removeClass("is");
    });
    $("#MszyE3").blur(function () {
        var MssyMax = Math.max($("#MszyE1").val(),$("#MszyE2").val(),$("#MszyE3").val());
        var MssyMin = Math.min($("#MszyE1").val(),$("#MszyE2").val(),$("#MszyE3").val());
        if($("#MszyE1").val() != "" && $("#MszyE2").val() != "" && $("#MszyE3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#MszyE1P").text("√ 符合");
            $("#MszyE1P").removeClass("no").addClass("is");
            $("#MszyE2P").text("√ 符合");
            $("#MszyE2P").removeClass("no").addClass("is");
            $("#MszyE3P").text("√ 符合");
            $("#MszyE3P").removeClass("no").addClass("is");
        }else{
            $("#MszyE1P").text("× 不符合");
            $("#MszyE1P").removeClass("is").addClass("no");
            $("#MszyE2P").text("× 不符合");
            $("#MszyE2P").removeClass("is").addClass("no");
            $("#MszyE3P").text("× 不符合");
            $("#MszyE3P").removeClass("is").addClass("no");
        }
    });

    $("#Minp11").focus(function () {
        $("#Mp11").text("允许误差 ± 3%");
        $("#Mp11").removeClass("no").removeClass("is");
    });
    $("#Minp11").blur(function () {
        if($(this).val()>=82.45 && $(this).val()<=87.55){
            $("#Mp11").text("√ 符合");
            $("#Mp11").removeClass("no").addClass("is");
        }else{
            $("#Mp11").text("× 不符合");
            $("#Mp11").removeClass("is").addClass("no");
        }
    });

    $("#Minp12").focus(function () {
        $("#Mp12").text("允许误差 ± 3%");
        $("#Mp12").removeClass("no").removeClass("is");
    });
    $("#Minp12").blur(function () {
        if($(this).val()>=85.36 && $(this).val()<=90.64){
            $("#Mp12").text("√ 符合");
            $("#Mp12").removeClass("no").addClass("is");
        }else{
            $("#Mp12").text("× 不符合");
            $("#Mp12").removeClass("is").addClass("no");
        }
    });

    $("#Minp13").focus(function () {
        $("#Mp13").text("允许误差 ± 3%");
        $("#Mp13").removeClass("no").removeClass("is");
    });
    $("#Minp13").blur(function () {
        if($(this).val()>=92.15 && $(this).val()<=97.85){
            $("#Mp13").text("√ 符合");
            $("#Mp13").removeClass("no").addClass("is");
        }else{
            $("#Mp13").text("× 不符合");
            $("#Mp13").removeClass("is").addClass("no");
        }
    });

    $("#Minp14").focus(function () {
        $("#Mp14").text("允许误差 ± 3%");
        $("#Mp14").removeClass("no").removeClass("is");
    });
    $("#Minp14").blur(function () {
        if($(this).val()>=95.06 && $(this).val()<=100.94){
            $("#Mp14").text("√ 符合");
            $("#Mp14").removeClass("no").addClass("is");
        }else{
            $("#Mp14").text("× 不符合");
            $("#Mp14").removeClass("is").addClass("no");
        }
    });

    $("#Minp15").focus(function () {
        $("#Mp15").text("允许误差 ± 3%");
        $("#Mp15").removeClass("no").removeClass("is");
    });
    $("#Minp15").blur(function () {
        if($(this).val()>=97 && $(this).val()<=103){
            $("#Mp15").text("√ 符合");
            $("#Mp15").removeClass("no").addClass("is");
        }else{
            $("#Mp15").text("× 不符合");
            $("#Mp15").removeClass("is").addClass("no");
        }
    });

    $("#Minp16").focus(function () {
        $("#Mp16").text("允许误差 ± 4 mmHg");
        $("#Mp16").removeClass("no").removeClass("is");
    });
    $("#Minp17").focus(function () {
        $("#Mp17").text("允许误差 ± 4 mmHg");
        $("#Mp17").removeClass("no").removeClass("is");
    });
    $("#Minp17").blur(function () {
        if(Math.abs($("#Minp16").val() - $("#Minp17").val())<= 4 && $("#Minp16").val() != "" && $("#Minp17").val() != ""){
            $("#Mp16").text("√ 符合");
            $("#Mp16").removeClass("no").addClass("is");
            $("#Mp17").text("√ 符合");
            $("#Mp17").removeClass("no").addClass("is");
        }else{
            $("#Mp16").text("× 不符合");
            $("#Mp16").removeClass("is").addClass("no");
            $("#Mp17").text("× 不符合");
            $("#Mp17").removeClass("is").addClass("no");
        }
    });

    $("#Minp18").focus(function () {
        $("#Mp18").text("<= 6 mmHg / min");
        $("#Mp18").removeClass("no").removeClass("is");
    });
    $("#Minp18").blur(function () {
        if($(this).val()<=6 && $(this).val() != ""){
            $("#Mp18").text("√ 符合");
            $("#Mp18").removeClass("no").addClass("is");
        }else{
            $("#Mp18").text("× 不符合");
            $("#Mp18").removeClass("is").addClass("no");
        }
    });
}