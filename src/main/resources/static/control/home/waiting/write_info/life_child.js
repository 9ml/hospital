window.onload = function(){
    // 新生儿
    $("#Cinp1").focus(function () {
        $("#Cp1").text("允许误差 ± 5%");
        $("#Cp1").removeClass("no").removeClass("is");
    });
    $("#Cinp1").blur(function () {
        if($(this).val()>=28.5 && $(this).val()<=31.5){
            $("#Cp1").text("√ 符合");
            $("#Cp1").removeClass("no").addClass("is");
        }else{
            $("#Cp1").text("× 不符合");
            $("#Cp1").removeClass("is").addClass("no");
        }
    });

    $("#Cinp2").focus(function () {
        $("#Cp2").text("允许误差 ± 5%");
        $("#Cp2").removeClass("no").removeClass("is");
    });
    $("#Cinp2").blur(function () {
        if($(this).val()>=57 && $(this).val()<=63){
            $("#Cp2").text("√ 符合");
            $("#Cp2").removeClass("no").addClass("is");
        }else{
            $("#Cp2").text("× 不符合");
            $("#Cp2").removeClass("is").addClass("no");
        }
    });

    $("#Cinp3").focus(function () {
        $("#Cp3").text("允许误差 ± 5%");
        $("#Cp3").removeClass("no").removeClass("is");
    });
    $("#Cinp3").blur(function () {
        if($(this).val()>=95 && $(this).val()<=105){
            $("#Cp3").text("√ 符合");
            $("#Cp3").removeClass("no").addClass("is");
        }else{
            $("#Cp3").text("× 不符合");
            $("#Cp3").removeClass("is").addClass("no");
        }
    });

    $("#Cinp4").focus(function () {
        $("#Cp4").text("允许误差 ± 5%");
        $("#Cp4").removeClass("no").removeClass("is");
    });
    $("#Cinp4").blur(function () {
        if($(this).val()>=114 && $(this).val()<=126){
            $("#Cp4").text("√ 符合");
            $("#Cp4").removeClass("no").addClass("is");
        }else{
            $("#Cp4").text("× 不符合");
            $("#Cp4").removeClass("is").addClass("no");
        }
    });

    $("#Cinp5").focus(function () {
        $("#Cp5").text("允许误差 ± 5%");
        $("#Cp5").removeClass("no").removeClass("is");
    });
    $("#Cinp5").blur(function () {
        if($(this).val()>=171 && $(this).val()<=189){
            $("#Cp5").text("√ 符合");
            $("#Cp5").removeClass("no").addClass("is");
        }else{
            $("#Cp5").text("× 不符合");
            $("#Cp5").removeClass("is").addClass("no");
        }
    });

    $("#Cinp6").focus(function () {
        $("#Cp6").text("允许误差 ± 5%");
        $("#Cp6").removeClass("no").removeClass("is");
    });
    $("#Cinp6").blur(function () {
        if($(this).val()>=14.25 && $(this).val()<=15.75){
            $("#Cp6").text("√ 符合");
            $("#Cp6").removeClass("no").addClass("is");
        }else{
            $("#Cp6").text("× 不符合");
            $("#Cp6").removeClass("is").addClass("no");
        }
    });

    $("#Cinp7").focus(function () {
        $("#Cp7").text("允许误差 ± 5%");
        $("#Cp7").removeClass("no").removeClass("is");
    });
    $("#Cinp7").blur(function () {
        if($(this).val()>=19 && $(this).val()<=21){
            $("#Cp7").text("√ 符合");
            $("#Cp7").removeClass("no").addClass("is");
        }else{
            $("#Cp7").text("× 不符合");
            $("#Cp7").removeClass("is").addClass("no");
        }
    });

    $("#Cinp8").focus(function () {
        $("#Cp8").text("允许误差 ± 5%");
        $("#Cp8").removeClass("no").removeClass("is");
    });
    $("#Cinp8").blur(function () {
        if($(this).val()>=38 && $(this).val()<=42){
            $("#Cp8").text("√ 符合");
            $("#Cp8").removeClass("no").addClass("is");
        }else{
            $("#Cp8").text("× 不符合");
            $("#Cp8").removeClass("is").addClass("no");
        }
    });

    $("#Cinp9").focus(function () {
        $("#Cp9").text("允许误差 ± 5%");
        $("#Cp9").removeClass("no").removeClass("is");
    });
    $("#Cinp9").blur(function () {
        if($(this).val()>=57 && $(this).val()<=63){
            $("#Cp9").text("√ 符合");
            $("#Cp9").removeClass("no").addClass("is");
        }else{
            $("#Cp9").text("× 不符合");
            $("#Cp9").removeClass("is").addClass("no");
        }
    });

    $("#Cinp10").focus(function () {
        $("#Cp10").text("允许误差 ± 5%");
        $("#Cp10").removeClass("no").removeClass("is");
    });
    $("#Cinp10").blur(function () {
        if($(this).val()>=76 && $(this).val()<=84){
            $("#Cp10").text("√ 符合");
            $("#Cp10").removeClass("no").addClass("is");
        }else{
            $("#Cp10").text("× 不符合");
            $("#Cp10").removeClass("is").addClass("no");
        }
    });

    $("#CssyA1").focus(function () {
        $("#CssyA1P").text("8.5mmHg");
        $("#CssyA1P").removeClass("no").removeClass("is");
    });
    $("#CssyA2").focus(function () {
        $("#CssyA2P").text("8.5mmHg");
        $("#CssyA2P").removeClass("no").removeClass("is");
    });
    $("#CssyA3").focus(function () {
        $("#CssyA3P").text("8.5mmHg");
        $("#CssyA3P").removeClass("no").removeClass("is");
    });
    $("#CssyA3").blur(function () {
        var MssyMax = Math.max($("#CssyA1").val(),$("#CssyA2").val(),$("#CssyA3").val());
        var MssyMin = Math.min($("#CssyA1").val(),$("#CssyA2").val(),$("#CssyA3").val());
        if($("#CssyA1").val() != "" && $("#CssyA2").val() != "" && $("#CssyA3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CssyA1P").text("√ 符合");
            $("#CssyA1P").removeClass("no").addClass("is");
            $("#CssyA2P").text("√ 符合");
            $("#CssyA2P").removeClass("no").addClass("is");
            $("#CssyA3P").text("√ 符合");
            $("#CssyA3P").removeClass("no").addClass("is");
        }else{
            $("#CssyA1P").text("× 不符合");
            $("#CssyA1P").removeClass("is").addClass("no");
            $("#CssyA2P").text("× 不符合");
            $("#CssyA2P").removeClass("is").addClass("no");
            $("#CssyA3P").text("× 不符合");
            $("#CssyA3P").removeClass("is").addClass("no");
        }
    });

    $("#CszyA1").focus(function () {
        $("#CszyA1P").text("8.5mmHg");
        $("#CszyA1P").removeClass("no").removeClass("is");
    });
    $("#CszyA2").focus(function () {
        $("#CszyA2P").text("8.5mmHg");
        $("#CszyA2P").removeClass("no").removeClass("is");
    });
    $("#CszyA3").focus(function () {
        $("#CszyA3P").text("8.5mmHg");
        $("#CszyA3P").removeClass("no").removeClass("is");
    });
    $("#CszyA3").blur(function () {
        var MssyMax = Math.max($("#CszyA1").val(),$("#CszyA2").val(),$("#CszyA3").val());
        var MssyMin = Math.min($("#CszyA1").val(),$("#CszyA2").val(),$("#CszyA3").val());
        if($("#CszyA1").val() != "" && $("#CszyA2").val() != "" && $("#CszyA3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CszyA1P").text("√ 符合");
            $("#CszyA1P").removeClass("no").addClass("is");
            $("#CszyA2P").text("√ 符合");
            $("#CszyA2P").removeClass("no").addClass("is");
            $("#CszyA3P").text("√ 符合");
            $("#CszyA3P").removeClass("no").addClass("is");
        }else{
            $("#CszyA1P").text("× 不符合");
            $("#CszyA1P").removeClass("is").addClass("no");
            $("#CszyA2P").text("× 不符合");
            $("#CszyA2P").removeClass("is").addClass("no");
            $("#CszyA3P").text("× 不符合");
            $("#CszyA3P").removeClass("is").addClass("no");
        }
    });

    $("#CssyB1").focus(function () {
        $("#CssyB1P").text("8.5mmHg");
        $("#CssyB1P").removeClass("no").removeClass("is");
    });
    $("#CssyB2").focus(function () {
        $("#CssyB2P").text("8.5mmHg");
        $("#CssyB2P").removeClass("no").removeClass("is");
    });
    $("#CssyB3").focus(function () {
        $("#CssyB3P").text("8.5mmHg");
        $("#CssyB3P").removeClass("no").removeClass("is");
    });
    $("#CssyB3").blur(function () {
        var MssyMax = Math.max($("#CssyB1").val(),$("#CssyB2").val(),$("#CssyB3").val());
        var MssyMin = Math.min($("#CssyB1").val(),$("#CssyB2").val(),$("#CssyB3").val());
        if($("#CssyB1").val() != "" && $("#CssyB2").val() != "" && $("#CssyB3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CssyB1P").text("√ 符合");
            $("#CssyB1P").removeClass("no").addClass("is");
            $("#CssyB2P").text("√ 符合");
            $("#CssyB2P").removeClass("no").addClass("is");
            $("#CssyB3P").text("√ 符合");
            $("#CssyB3P").removeClass("no").addClass("is");
        }else{
            $("#CssyB1P").text("× 不符合");
            $("#CssyB1P").removeClass("is").addClass("no");
            $("#CssyB2P").text("× 不符合");
            $("#CssyB2P").removeClass("is").addClass("no");
            $("#CssyB3P").text("× 不符合");
            $("#CssyB3P").removeClass("is").addClass("no");
        }
    });

    $("#CszyB1").focus(function () {
        $("#CszyB1P").text("8.5mmHg");
        $("#CszyB1P").removeClass("no").removeClass("is");
    });
    $("#CszyB2").focus(function () {
        $("#CszyB2P").text("8.5mmHg");
        $("#CszyB2P").removeClass("no").removeClass("is");
    });
    $("#CszyB3").focus(function () {
        $("#CszyB3P").text("8.5mmHg");
        $("#CszyB3P").removeClass("no").removeClass("is");
    });
    $("#CszyB3").blur(function () {
        var MssyMax = Math.max($("#CszyB1").val(),$("#CszyB2").val(),$("#CszyB3").val());
        var MssyMin = Math.min($("#CszyB1").val(),$("#CszyB2").val(),$("#CszyB3").val());
        if($("#CszyB1").val() != "" && $("#CszyB2").val() != "" && $("#CszyB3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CszyB1P").text("√ 符合");
            $("#CszyB1P").removeClass("no").addClass("is");
            $("#CszyB2P").text("√ 符合");
            $("#CszyB2P").removeClass("no").addClass("is");
            $("#CszyB3P").text("√ 符合");
            $("#CszyB3P").removeClass("no").addClass("is");
        }else{
            $("#CszyB1P").text("× 不符合");
            $("#CszyB1P").removeClass("is").addClass("no");
            $("#CszyB2P").text("× 不符合");
            $("#CszyB2P").removeClass("is").addClass("no");
            $("#CszyB3P").text("× 不符合");
            $("#CszyB3P").removeClass("is").addClass("no");
        }
    });

    $("#CssyC1").focus(function () {
        $("#CssyC1P").text("8.5mmHg");
        $("#CssyC1P").removeClass("no").removeClass("is");
    });
    $("#CssyC2").focus(function () {
        $("#CssyC2P").text("8.5mmHg");
        $("#CssyC2P").removeClass("no").removeClass("is");
    });
    $("#CssyC3").focus(function () {
        $("#CssyC3P").text("8.5mmHg");
        $("#CssyC3P").removeClass("no").removeClass("is");
    });
    $("#CssyC3").blur(function () {
        var MssyMax = Math.max($("#CssyC1").val(),$("#CssyC2").val(),$("#CssyC3").val());
        var MssyMin = Math.min($("#CssyC1").val(),$("#CssyC2").val(),$("#CssyC3").val());
        if($("#CssyC1").val() != "" && $("#CssyC2").val() != "" && $("#CssyC3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CssyC1P").text("√ 符合");
            $("#CssyC1P").removeClass("no").addClass("is");
            $("#CssyC2P").text("√ 符合");
            $("#CssyC2P").removeClass("no").addClass("is");
            $("#CssyC3P").text("√ 符合");
            $("#CssyC3P").removeClass("no").addClass("is");
        }else{
            $("#CssyC1P").text("× 不符合");
            $("#CssyC1P").removeClass("is").addClass("no");
            $("#CssyC2P").text("× 不符合");
            $("#CssyC2P").removeClass("is").addClass("no");
            $("#CssyC3P").text("× 不符合");
            $("#CssyC3P").removeClass("is").addClass("no");
        }
    });

    $("#CszyC1").focus(function () {
        $("#CszyC1P").text("8.5mmHg");
        $("#CszyC1P").removeClass("no").removeClass("is");
    });
    $("#CszyC2").focus(function () {
        $("#CszyC2P").text("8.5mmHg");
        $("#CszyC2P").removeClass("no").removeClass("is");
    });
    $("#CszyC3").focus(function () {
        $("#CszyC3P").text("8.5mmHg");
        $("#CszyC3P").removeClass("no").removeClass("is");
    });
    $("#CszyC3").blur(function () {
        var MssyMax = Math.max($("#CszyC1").val(),$("#CszyC2").val(),$("#CszyC3").val());
        var MssyMin = Math.min($("#CszyC1").val(),$("#CszyC2").val(),$("#CszyC3").val());
        if($("#CszyC1").val() != "" && $("#CszyC2").val() != "" && $("#CszyC3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CszyC1P").text("√ 符合");
            $("#CszyC1P").removeClass("no").addClass("is");
            $("#CszyC2P").text("√ 符合");
            $("#CszyC2P").removeClass("no").addClass("is");
            $("#CszyC3P").text("√ 符合");
            $("#CszyC3P").removeClass("no").addClass("is");
        }else{
            $("#CszyC1P").text("× 不符合");
            $("#CszyC1P").removeClass("is").addClass("no");
            $("#CszyC2P").text("× 不符合");
            $("#CszyC2P").removeClass("is").addClass("no");
            $("#CszyC3P").text("× 不符合");
            $("#CszyC3P").removeClass("is").addClass("no");
        }
    });

    $("#CssyD1").focus(function () {
        $("#CssyD1P").text("8.5mmHg");
        $("#CssyD1P").removeClass("no").removeClass("is");
    });
    $("#CssyD2").focus(function () {
        $("#CssyD2P").text("8.5mmHg");
        $("#CssyD2P").removeClass("no").removeClass("is");
    });
    $("#CssyD3").focus(function () {
        $("#CssyD3P").text("8.5mmHg");
        $("#CssyD3P").removeClass("no").removeClass("is");
    });
    $("#CssyD3").blur(function () {
        var MssyMax = Math.max($("#CssyD1").val(),$("#CssyD2").val(),$("#CssyD3").val());
        var MssyMin = Math.min($("#CssyD1").val(),$("#CssyD2").val(),$("#CssyD3").val());
        if($("#CssyD1").val() != "" && $("#CssyD2").val() != "" && $("#CssyD3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CssyD1P").text("√ 符合");
            $("#CssyD1P").removeClass("no").addClass("is");
            $("#CssyD2P").text("√ 符合");
            $("#CssyD2P").removeClass("no").addClass("is");
            $("#CssyD3P").text("√ 符合");
            $("#CssyD3P").removeClass("no").addClass("is");
        }else{
            $("#CssyD1P").text("× 不符合");
            $("#CssyD1P").removeClass("is").addClass("no");
            $("#CssyD2P").text("× 不符合");
            $("#CssyD2P").removeClass("is").addClass("no");
            $("#CssyD3P").text("× 不符合");
            $("#CssyD3P").removeClass("is").addClass("no");
        }
    });

    $("#CszyD1").focus(function () {
        $("#CszyD1P").text("8.5mmHg");
        $("#CszyD1P").removeClass("no").removeClass("is");
    });
    $("#CszyD2").focus(function () {
        $("#CszyD2P").text("8.5mmHg");
        $("#CszyD2P").removeClass("no").removeClass("is");
    });
    $("#CszyD3").focus(function () {
        $("#CszyD3P").text("8.5mmHg");
        $("#CszyD3P").removeClass("no").removeClass("is");
    });
    $("#CszyD3").blur(function () {
        var MssyMax = Math.max($("#CszyD1").val(),$("#CszyD2").val(),$("#CszyD3").val());
        var MssyMin = Math.min($("#CszyD1").val(),$("#CszyD2").val(),$("#CszyD3").val());
        if($("#CszyD1").val() != "" && $("#CszyD2").val() != "" && $("#CszyD3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CszyD1P").text("√ 符合");
            $("#CszyD1P").removeClass("no").addClass("is");
            $("#CszyD2P").text("√ 符合");
            $("#CszyD2P").removeClass("no").addClass("is");
            $("#CszyD3P").text("√ 符合");
            $("#CszyD3P").removeClass("no").addClass("is");
        }else{
            $("#CszyD1P").text("× 不符合");
            $("#CszyD1P").removeClass("is").addClass("no");
            $("#CszyD2P").text("× 不符合");
            $("#CszyD2P").removeClass("is").addClass("no");
            $("#CszyD3P").text("× 不符合");
            $("#CszyD3P").removeClass("is").addClass("no");
        }
    });

    $("#CssyE1").focus(function () {
        $("#CssyE1P").text("8.5mmHg");
        $("#CssyE1P").removeClass("no").removeClass("is");
    });
    $("#CssyE2").focus(function () {
        $("#CssyE2P").text("8.5mmHg");
        $("#CssyE2P").removeClass("no").removeClass("is");
    });
    $("#CssyE3").focus(function () {
        $("#CssyE3P").text("8.5mmHg");
        $("#CssyE3P").removeClass("no").removeClass("is");
    });
    $("#CssyE3").blur(function () {
        var MssyMax = Math.max($("#CssyE1").val(),$("#CssyE2").val(),$("#CssyE3").val());
        var MssyMin = Math.min($("#CssyE1").val(),$("#CssyE2").val(),$("#CssyE3").val());
        if($("#CssyE1").val() != "" && $("#CssyE2").val() != "" && $("#CssyE3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CssyE1P").text("√ 符合");
            $("#CssyE1P").removeClass("no").addClass("is");
            $("#CssyE2P").text("√ 符合");
            $("#CssyE2P").removeClass("no").addClass("is");
            $("#CssyE3P").text("√ 符合");
            $("#CssyE3P").removeClass("no").addClass("is");
        }else{
            $("#CssyE1P").text("× 不符合");
            $("#CssyE1P").removeClass("is").addClass("no");
            $("#CssyE2P").text("× 不符合");
            $("#CssyE2P").removeClass("is").addClass("no");
            $("#CssyE3P").text("× 不符合");
            $("#CssyE3P").removeClass("is").addClass("no");
        }
    });

    $("#CszyE1").focus(function () {
        $("#CszyE1P").text("8.5mmHg");
        $("#CszyE1P").removeClass("no").removeClass("is");
    });
    $("#CszyE2").focus(function () {
        $("#CszyE2P").text("8.5mmHg");
        $("#CszyE2P").removeClass("no").removeClass("is");
    });
    $("#CszyE3").focus(function () {
        $("#CszyE3P").text("8.5mmHg");
        $("#CszyE3P").removeClass("no").removeClass("is");
    });
    $("#CszyE3").blur(function () {
        var MssyMax = Math.max($("#CszyE1").val(),$("#CszyE2").val(),$("#CszyE3").val());
        var MssyMin = Math.min($("#CszyE1").val(),$("#CszyE2").val(),$("#CszyE3").val());
        if($("#CszyE1").val() != "" && $("#CszyE2").val() != "" && $("#CszyE3").val() != "" && MssyMax - MssyMin <= 8.5){
            $("#CszyE1P").text("√ 符合");
            $("#CszyE1P").removeClass("no").addClass("is");
            $("#CszyE2P").text("√ 符合");
            $("#CszyE2P").removeClass("no").addClass("is");
            $("#CszyE3P").text("√ 符合");
            $("#CszyE3P").removeClass("no").addClass("is");
        }else{
            $("#CszyE1P").text("× 不符合");
            $("#CszyE1P").removeClass("is").addClass("no");
            $("#CszyE2P").text("× 不符合");
            $("#CszyE2P").removeClass("is").addClass("no");
            $("#CszyE3P").text("× 不符合");
            $("#CszyE3P").removeClass("is").addClass("no");
        }
    });

    $("#Cinp11").focus(function () {
        $("#Cp11").text("允许误差 ± 3%");
        $("#Cp11").removeClass("no").removeClass("is");
    });
    $("#Cinp11").blur(function () {
        if($(this).val()>=82.45 && $(this).val()<=87.55){
            $("#Cp11").text("√ 符合");
            $("#Cp11").removeClass("no").addClass("is");
        }else{
            $("#Cp11").text("× 不符合");
            $("#Cp11").removeClass("is").addClass("no");
        }
    });

    $("#Cinp12").focus(function () {
        $("#Cp12").text("允许误差 ± 3%");
        $("#Cp12").removeClass("no").removeClass("is");
    });
    $("#Cinp12").blur(function () {
        if($(this).val()>=85.36 && $(this).val()<=90.64){
            $("#Cp12").text("√ 符合");
            $("#Cp12").removeClass("no").addClass("is");
        }else{
            $("#Cp12").text("× 不符合");
            $("#Cp12").removeClass("is").addClass("no");
        }
    });

    $("#Cinp13").focus(function () {
        $("#Cp13").text("允许误差 ± 3%");
        $("#Cp13").removeClass("no").removeClass("is");
    });
    $("#Cinp13").blur(function () {
        if($(this).val()>=92.15 && $(this).val()<=97.85){
            $("#Cp13").text("√ 符合");
            $("#Cp13").removeClass("no").addClass("is");
        }else{
            $("#Cp13").text("× 不符合");
            $("#Cp13").removeClass("is").addClass("no");
        }
    });

    $("#Cinp14").focus(function () {
        $("#Cp14").text("允许误差 ± 3%");
        $("#Cp14").removeClass("no").removeClass("is");
    });
    $("#Cinp14").blur(function () {
        if($(this).val()>=95.06 && $(this).val()<=100.94){
            $("#Cp14").text("√ 符合");
            $("#Cp14").removeClass("no").addClass("is");
        }else{
            $("#Cp14").text("× 不符合");
            $("#Cp14").removeClass("is").addClass("no");
        }
    });

    $("#Cinp15").focus(function () {
        $("#Cp15").text("允许误差 ± 3%");
        $("#Cp15").removeClass("no").removeClass("is");
    });
    $("#Cinp15").blur(function () {
        if($(this).val()>=97 && $(this).val()<=103){
            $("#Cp15").text("√ 符合");
            $("#Cp15").removeClass("no").addClass("is");
        }else{
            $("#Cp15").text("× 不符合");
            $("#Cp15").removeClass("is").addClass("no");
        }
    });

    $("#Cinp16").focus(function () {
        $("#Cp16").text("允许误差 ± 3%");
        $("#Cp16").removeClass("no").removeClass("is");
    });
    $("#Cinp17").focus(function () {
        $("#Cp17").text("允许误差 ± 3%");
        $("#Cp17").removeClass("no").removeClass("is");
    });
    $("#Cinp17").blur(function () {
        if(Math.abs($("#Cinp16").val() - $("#Cinp17").val())<= 4 && $("#Cinp16").val() != "" && $("#Cinp17").val() != ""){
            $("#Cp16").text("√ 符合");
            $("#Cp16").removeClass("no").addClass("is");
            $("#Cp17").text("√ 符合");
            $("#Cp17").removeClass("no").addClass("is");
        }else{
            $("#Cp16").text("× 不符合");
            $("#Cp16").removeClass("is").addClass("no");
            $("#Cp17").text("× 不符合");
            $("#Cp17").removeClass("is").addClass("no");
        }
    });

    $("#Cinp18").focus(function () {
        $("#Cp18").text("<= 6 mmHg ");
        $("#Cp18").removeClass("no").removeClass("is");
    });
    $("#Cinp18").blur(function () {
        if($(this).val()<=6 && $(this).val() != ""){
            $("#Cp18").text("√ 符合");
            $("#Cp18").removeClass("no").addClass("is");
        }else{
            $("#Cp18").text("× 不符合");
            $("#Cp18").removeClass("is").addClass("no");
        }
    });
}