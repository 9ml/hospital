window.onload = function(){
    // 0.2
    $("#pjll1").blur(function(){
        if($("#pjll1").val() >= 0.18 && $("#pjll1").val() <= 0.22){
            $("#wc1").text("符合");
            $("#wc1").removeClass("no").addClass("is");
        }else{
            $("#wc1").text("不符合"); 
            $("#wc1").removeClass("is").addClass("no");
        }
    });
    // 8
    $("#pjll2").blur(function(){
        if($("#pjll2").val() >= 7.2 && $("#pjll2").val() <= 8.8){
            $("#wc2").text("符合");
            $("#wc2").removeClass("no").addClass("is");
        }else{
            $("#wc2").text("不符合"); 
            $("#wc2").removeClass("is").addClass("no");
        }
    });
    // H
    $("#bjylH").blur(function(){
        if($("#bjylH").val() >= ($("#bjszH").val() - ($("#bjszH").val()*0.2)) && $("#bjylH").val() <= ($("#bjszH").val() + ($("#bjszH").val()*0.2))){
            $("#wc3").text("符合");
            $("#wc3").removeClass("no").addClass("is");
        }else{
            $("#wc3").text("不符合"); 
            $("#wc3").removeClass("is").addClass("no");
        }
    });
    // M
    $("#bjylM").blur(function(){
        if($("#bjylM").val() >= ($("#bjszM").val() - ($("#bjszM").val()*0.2)) && $("#bjylM").val() <= ($("#bjszM").val() + ($("#bjszM").val()*0.2))){
            $("#wc4").text("符合");
            $("#wc4").removeClass("no").addClass("is");
        }else{
            $("#wc4").text("不符合"); 
            $("#wc4").removeClass("is").addClass("no");
        }
    });
    // L
    $("#bjylL").blur(function(){
        if($("#bjylL").val() >= 200 && $("#bjylL").val() <= 400){
            $("#wc5").text("符合");
            $("#wc5").removeClass("no").addClass("is");
        }else{
            $("#wc5").text("不符合"); 
            $("#wc5").removeClass("is").addClass("no");
        }
    });
}