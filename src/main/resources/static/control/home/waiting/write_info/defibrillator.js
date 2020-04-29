window.onload = function(){
    // 最小能量值
    $("#sfnlValue1").blur(function(){
        $("#sfnlWc1").val(Math.abs(parseFloat($("#zxnl").val()) - parseFloat($("#sfnlValue1").val())).toFixed(1));
        if($("#sfnlWc1").val() >= 0 && $("#sfnlWc1").val() <= 4){
            $("#wc1").text("符合");
            $("#wc1").removeClass("no").addClass("is");
        }else{
            $("#wc1").text("不符合"); 
            $("#wc1").removeClass("is").addClass("no");
        }
    });
    // 30
    $("#sfnlValue2").blur(function(){
        $("#sfnlWc2").val(Math.abs(30 - parseFloat($("#sfnlValue2").val())).toFixed(1));
        if($("#sfnlWc2").val() >= 0 && $("#sfnlWc2").val() <= 4.5){
            $("#wc2").text("符合");
            $("#wc2").removeClass("no").addClass("is");
        }else{
            $("#wc2").text("不符合"); 
            $("#wc2").removeClass("is").addClass("no");
        }
    });
    // 50
    $("#sfnlValue3").blur(function(){
        $("#sfnlWc3").val(Math.abs(50 - parseFloat($("#sfnlValue3").val())).toFixed(1));
        if($("#sfnlWc3").val() >= 0 && $("#sfnlWc3").val() <= 7.5){
            $("#wc3").text("符合");
            $("#wc3").removeClass("no").addClass("is");
        }else{
            $("#wc3").text("不符合"); 
            $("#wc3").removeClass("is").addClass("no");
        }
    });
    // 最大能量值
    $("#sfnlValue6").blur(function(){
        $("#sfnlWc6").val(Math.abs(parseFloat($("#zdnl").val()) - parseFloat($("#sfnlValue6").val())).toFixed(1));
        if($("#sfnlWc6").val() >= 0 && $("#sfnlWc6").val() <= $("#zdnl").val()*0.15){
            $("#wc4").text("符合");
            $("#wc4").removeClass("no").addClass("is");
        }else{
            $("#wc4").text("不符合"); 
            $("#wc4").removeClass("is").addClass("no");
        }
    });
    // 100
    $("#sfnlValue4").blur(function(){
        $("#sfnlWc4").val(Math.abs(100 - parseFloat($("#sfnlValue4").val())).toFixed(1));
        if($("#sfnlWc4").val() >= 0 && $("#sfnlWc4").val() <= 15){
            $("#wc5").text("符合");
            $("#wc5").removeClass("no").addClass("is");
        }else{
            $("#wc5").text("不符合"); 
            $("#wc5").removeClass("is").addClass("no");
        }
    });
    // 200
    $("#sfnlValue5").blur(function(){
        $("#sfnlWc5").val(Math.abs(200 - parseFloat($("#sfnlValue5").val())).toFixed(1));
        if($("#sfnlWc5").val() >= 0 && $("#sfnlWc5").val() <= 30){
            $("#wc6").text("符合");
            $("#wc6").removeClass("no").addClass("is");
        }else{
            $("#wc6").text("不符合"); 
            $("#wc6").removeClass("is").addClass("no");
        }
    });
    // 20 前 中 后
    $("#sfnlValue73").blur(function(){
        $("#sfnlWc7").val(Math.abs(20 - ((parseFloat($("#sfnlValue71").val())+parseFloat($("#sfnlValue72").val())+parseInt($("#sfnlValue73").val()))/3).toFixed(1)).toFixed(1));
        if($("#sfnlWc7").val() >= 0 && $("#sfnlWc7").val() <= 4){
            $("#wc7").text("符合");
            $("#wc7").removeClass("no").addClass("is");
        }else{
            $("#wc7").text("不符合"); 
            $("#wc7").removeClass("is").addClass("no");
        }
    });
    // 200 前 中 后
    $("#sfnlValue83").blur(function(){
        $("#sfnlWc8").val(Math.abs(parseFloat($("#zdnl2").val()) - ((parseFloat($("#sfnlValue81").val())+parseFloat($("#sfnlValue82").val())+parseInt($("#sfnlValue83").val()))/3)).toFixed(1));
        if($("#sfnlWc8").val() >= 0 && $("#sfnlWc8").val() <= $("#zdnl2").val()*0.15){
            $("#wc8").text("符合");
            $("#wc8").removeClass("no").addClass("is");
        }else{
            $("#wc8").text("不符合"); 
            $("#wc8").removeClass("is").addClass("no");
        }
    });
    // 充电时间
    $("#cdsjValue").blur(function(){
        if($("#cdsjValue").val() > 0 && $("#cdsjValue").val() <= 20){
            $("#wc9").text("符合");
            $("#wc9").removeClass("no").addClass("is");
        }else{
            $("#wc9").text("不符合"); 
            $("#wc9").removeClass("is").addClass("no");
        }
    });
    // 同步延迟时间
    $("#tbmsSj").blur(function(){
        if($("#tbmsSj").val() > 0  && $("#tbmsSj").val() <= 60){
            $("#wc10").text("符合");
            $("#wc10").removeClass("no").addClass("is");
        }else{
            $("#wc10").text("不符合"); 
            $("#wc10").removeClass("is").addClass("no");
        }
    });
    // 心率示值
    // 30
    $("#xlszValue1").blur(function(){
        if($("#xlszValue1").val() >= 28  && $("#xlszValue1").val() <= 32){
            $("#xl1").text("符合");
            $("#xl1").removeClass("no").addClass("is");
        }else{
            $("#xl1").text("不符合");
            $("#xl1").removeClass("is").addClass("no");
        }
    });
    // 60
    $("#xlszValue2").blur(function(){
        if($("#xlszValue2").val() >= 57  && $("#xlszValue2").val() <= 63){
            $("#xl2").text("符合");
            $("#xl2").removeClass("no").addClass("is");
        }else{
            $("#xl2").text("不符合");
            $("#xl2").removeClass("is").addClass("no");
        }
    });
    // 100
    $("#xlszValue3").blur(function(){
        if($("#xlszValue3").val() >= 95  && $("#xlszValue3").val() <= 105){
            $("#xl3").text("符合");
            $("#xl3").removeClass("no").addClass("is");
        }else{
            $("#xl3").text("不符合");
            $("#xl3").removeClass("is").addClass("no");
        }
    });
    // 120
    $("#xlszValue4").blur(function(){
        if($("#xlszValue4").val() >= 114  && $("#xlszValue4").val() <= 126){
            $("#xl4").text("符合");
            $("#xl4").removeClass("no").addClass("is");
        }else{
            $("#xl4").text("不符合");
            $("#xl4").removeClass("is").addClass("no");
        }
    });
    // 180
    $("#xlszValue5").blur(function(){
        if($("#xlszValue5").val() >= 171  && $("#xlszValue5").val() <= 189){
            $("#xl5").text("符合");
            $("#xl5").removeClass("no").addClass("is");
        }else{
            $("#xl5").text("不符合");
            $("#xl5").removeClass("is").addClass("no");
        }
    });
}