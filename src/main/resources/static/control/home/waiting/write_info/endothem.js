window.onload = function(){
// 输出功率
  // 单极电切
    // 75
    $("#djdqValue1").blur(function(){
        if($("#djdqValue1").val() >= 60 && $("#djdqValue1").val() <= 90){
            $("#is1").text("符合");
            $("#is1").removeClass("no").addClass("is");
        }else{
            $("#is1").text("不符合"); 
            $("#is1").removeClass("is").addClass("no");
        }
    });
    // 150
    $("#djdqValue2").blur(function(){
        if($("#djdqValue2").val() >= 120 && $("#djdqValue2").val() <= 180){
            $("#is2").text("符合");
            $("#is2").removeClass("no").addClass("is");
        }else{
            $("#is2").text("不符合"); 
            $("#is2").removeClass("is").addClass("no");
        }
    });
    // 220
    $("#djdqValue3").blur(function(){
        if($("#djdqValue3").val() >= 176 && $("#djdqValue3").val() <= 264){
            $("#is3").text("符合");
            $("#is3").removeClass("no").addClass("is");
        }else{
            $("#is3").text("不符合"); 
            $("#is3").removeClass("is").addClass("no");
        }
    });
    // 300
    $("#djdqValue4").blur(function(){
        if($("#djdqValue4").val() >= 240 && $("#djdqValue4").val() <= 360){
            $("#is4").text("符合");
            $("#is4").removeClass("no").addClass("is");
        }else{
            $("#is4").text("不符合"); 
            $("#is4").removeClass("is").addClass("no");
        }
    });
  // 单极电凝
    // 30
    $("#djdnValue1").blur(function(){
        if($("#djdnValue1").val() >= 27 && $("#djdnValue1").val() <= 33){
            $("#is5").text("符合");
            $("#is5").removeClass("no").addClass("is");
        }else{
            $("#is5").text("不符合"); 
            $("#is5").removeClass("is").addClass("no");
        }
    });
    // 60
    $("#djdnValue2").blur(function(){
        if($("#djdnValue2").val() >= 48 && $("#djdnValue2").val() <= 72){
            $("#is6").text("符合");
            $("#is6").removeClass("no").addClass("is");
        }else{
            $("#is6").text("不符合"); 
            $("#is6").removeClass("is").addClass("no");
        }
    });
    // 90
    $("#djdnValue3").blur(function(){
        if($("#djdnValue3").val() >= 72 && $("#djdnValue3").val() <= 108){
            $("#is7").text("符合");
            $("#is7").removeClass("no").addClass("is");
        }else{
            $("#is7").text("不符合"); 
            $("#is7").removeClass("is").addClass("no");
        }
    });
    // 120
    $("#djdnValue4").blur(function(){
        if($("#djdnValue4").val() >= 96 && $("#djdnValue4").val() <= 144){
            $("#is8").text("符合");
            $("#is8").removeClass("no").addClass("is");
        }else{
            $("#is8").text("不符合"); 
            $("#is8").removeClass("is").addClass("no");
        }
    });
  // 双极电凝
    // 13
    $("#sjdnValue1").blur(function(){
        if($("#sjdnValue1").val() >= 10.4 && $("#sjdnValue1").val() <= 15.6){
            $("#is9").text("符合");
            $("#is9").removeClass("no").addClass("is");
        }else{
            $("#is9").text("不符合"); 
            $("#is9").removeClass("is").addClass("no");
        }
    });
    // 25
    $("#sjdnValue2").blur(function(){
        if($("#sjdnValue2").val() >= 20 && $("#sjdnValue2").val() <= 30){
            $("#is10").text("符合");
            $("#is10").removeClass("no").addClass("is");
        }else{
            $("#is10").text("不符合"); 
            $("#is10").removeClass("is").addClass("no");
        }
    });
    // 38
    $("#sjdnValue3").blur(function(){
        if($("#sjdnValue3").val() >= 30.4 && $("#sjdnValue3").val() <= 45.6){
            $("#is11").text("符合");
            $("#is11").removeClass("no").addClass("is");
        }else{
            $("#is11").text("不符合"); 
            $("#is11").removeClass("is").addClass("no");
        }
    });
    // 50
    $("#sjdnValue4").blur(function(){
        if($("#sjdnValue4").val() >= 40 && $("#sjdnValue4").val() <= 60){
            $("#is12").text("符合");
            $("#is12").removeClass("no").addClass("is");
        }else{
            $("#is12").text("不符合"); 
            $("#is12").removeClass("is").addClass("no");
        }
    });
// 高频漏电
    // 手术电极高频漏电
    $("#ssldDjdq").blur(function(){
        if($("#ssldDjdq").val() > 0 && $("#ssldDjdq").val() <= 150){
            $("#is13").text("符合");
            $("#is13").removeClass("no").addClass("is");
        }else{
            $("#is13").text("不符合"); 
            $("#is13").removeClass("is").addClass("no");
        }
    });
    $("#ssldDjdn").blur(function(){
        if($("#ssldDjdn").val() > 0 && $("#ssldDjdn").val() <= 150){
            $("#is14").text("符合");
            $("#is14").removeClass("no").addClass("is");
        }else{
            $("#is14").text("不符合"); 
            $("#is14").removeClass("is").addClass("no");
        }
    });
    // 中性电极高频漏电
    $("#zxldDjdq").blur(function(){
        if($("#zxldDjdq").val() > 0 && $("#zxldDjdq").val() <= 150){
            $("#is15").text("符合");
            $("#is15").removeClass("no").addClass("is");
        }else{
            $("#is15").text("不符合"); 
            $("#is15").removeClass("is").addClass("no");
        }
    });
    $("#zxldDjdn").blur(function(){
        if($("#zxldDjdn").val() > 0 && $("#zxldDjdn").val() <= 150){
            $("#is16").text("符合");
            $("#is16").removeClass("no").addClass("is");
        }else{
            $("#is16").text("不符合"); 
            $("#is16").removeClass("is").addClass("no");
        }
    });
    // 双极电凝
    $("#ssldSjdn").blur(function(){
        if($("#ssldSjdn").val() > 0 && $("#ssldSjdn").val() <= 60){
            $("#is17").text("符合");
            $("#is17").removeClass("no").addClass("is");
        }else{
            $("#is17").text("不符合"); 
            $("#is17").removeClass("is").addClass("no");
        }
    });
    $("#zxldSjdn").blur(function(){
        if($("#zxldSjdn").val() > 0 && $("#zxldSjdn").val() <= 60){
            $("#is18").text("符合");
            $("#is18").removeClass("no").addClass("is");
        }else{
            $("#is18").text("不符合"); 
            $("#is18").removeClass("is").addClass("no");
        }
    });
}