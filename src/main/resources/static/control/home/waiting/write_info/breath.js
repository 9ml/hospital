window.onload = function(){
// 潮气量
    // 400
    $("#cqzh13").blur(function(){
        $("#cqzhp11").val(((parseFloat($("#cqzh11").val())+parseFloat($("#cqzh12").val())+parseFloat($("#cqzh13").val()))/3).toFixed(1));
    });
    $("#cqzc13").blur(function(){
        $("#cqzcp12").val(((parseFloat($("#cqzc11").val())+parseFloat($("#cqzc12").val())+parseFloat($("#cqzc13").val()))/3).toFixed(1));
        $("#cqz1Swc").val(((parseFloat($("#cqzhp11").val())-parseFloat($("#cqzcp12").val()))/parseFloat($("#cqzcp12").val())).toFixed(1));
        if($("#cqz1Swc").val() >= 0 && $("#cqz1Swc").val() <= 60){
            $("#wc1").text("符合");
            $("#wc1").removeClass("no").addClass("is");
        }else{
            $("#wc1").text("不符合");
            $("#wc1").removeClass("is").addClass("no");
        }
    });
    // 600
    $("#cqzh23").blur(function(){
        $("#cqzhp21").val(((parseFloat($("#cqzh21").val())+parseFloat($("#cqzh22").val())+parseFloat($("#cqzh23").val()))/3).toFixed(1));
    });
    $("#cqzc23").blur(function(){
        $("#cqzcp22").val(((parseFloat($("#cqzc21").val())+parseFloat($("#cqzc22").val())+parseFloat($("#cqzc23").val()))/3).toFixed(1));
        $("#cqz2Swc").val(((parseFloat($("#cqzhp21").val())-parseFloat($("#cqzcp22").val()))/parseFloat($("#cqzcp22").val())).toFixed(1));
        if($("#cqz2Swc").val() >= 0 && $("#cqz2Swc").val() <= 90){
            $("#wc2").text("符合");
            $("#wc2").removeClass("no").addClass("is");
        }else{
            $("#wc2").text("不符合");
            $("#wc2").removeClass("is").addClass("no");
        }
    });
    // 800 
    $("#cqzh33").blur(function(){
        $("#cqzhp31").val(((parseFloat($("#cqzh31").val())+parseFloat($("#cqzh32").val())+parseFloat($("#cqzh33").val()))/3).toFixed(1));
    });
    $("#cqzc33").blur(function(){
        $("#cqzcp32").val(((parseFloat($("#cqzc31").val())+parseFloat($("#cqzc32").val())+parseFloat($("#cqzc33").val()))/3).toFixed(1));
        $("#cqz3Swc").val(((parseFloat($("#cqzhp31").val())-parseFloat($("#cqzcp32").val()))/parseFloat($("#cqzcp32").val())).toFixed(1));
        if($("#cqz3Swc").val() >= 0 && $("#cqz3Swc").val() <= 120){
            $("#wc3").text("符合");
            $("#wc3").removeClass("no").addClass("is");
        }else{
            $("#wc3").text("不符合");
            $("#wc3").removeClass("is").addClass("no");
        }
    });
// 强制通气频率
    // 10
    $("#qztqh13").blur(function(){
        $("#qztqhp11").val(((parseFloat($("#qztqh11").val())+parseFloat($("#qztqh12").val())+parseFloat($("#qztqh13").val()))/3).toFixed(1));
    });
    $("#qztqc13").blur(function(){
        $("#qztqcp12").val(((parseFloat($("#qztqc11").val())+parseFloat($("#qztqc12").val())+parseFloat($("#qztqc13").val()))/3).toFixed(1));
        $("#qztq1Swc").val(((parseFloat($("#qztqhp11").val())-parseFloat($("#qztqcp12").val()))/parseFloat($("#qztqcp12").val())).toFixed(1));
        if($("#qztq1Swc").val() >= 0 && $("#qztq1Swc").val() <= 1){
            $("#wc4").text("符合");
            $("#wc4").removeClass("no").addClass("is");
        }else{
            $("#wc4").text("不符合");
            $("#wc4").removeClass("is").addClass("no");
        }
    });
    // 25
    $("#qztqh23").blur(function(){
        $("#qztqhp21").val(((parseFloat($("#qztqh21").val())+parseFloat($("#qztqh22").val())+parseFloat($("#qztqh23").val()))/3).toFixed(1));
    });
    $("#qztqc23").blur(function(){
        $("#qztqcp22").val(((parseFloat($("#qztqc21").val())+parseFloat($("#qztqc22").val())+parseFloat($("#qztqc23").val()))/3).toFixed(1));
        $("#qztq2Swc").val(((parseFloat($("#qztqhp21").val())-parseFloat($("#qztqcp22").val()))/parseFloat($("#qztqcp22").val())).toFixed(1));
        if($("#qztq2Swc").val() >= 0 && $("#qztq2Swc").val() <= 2.5){
            $("#wc5").text("符合");
            $("#wc5").removeClass("no").addClass("is");
        }else{
            $("#wc5").text("不符合");
            $("#wc5").removeClass("is").addClass("no");
        }
    });
    // 40
    $("#qztqh33").blur(function(){
        $("#qztqhp31").val(((parseFloat($("#qztqh31").val())+parseFloat($("#qztqh32").val())+parseFloat($("#qztqh33").val()))/3).toFixed(1));
    });
    $("#qztqc33").blur(function(){
        $("#qztqcp32").val(((parseFloat($("#qztqc31").val())+parseFloat($("#qztqc32").val())+parseFloat($("#qztqc33").val()))/3).toFixed(1));
        $("#qztq3Swc").val(((parseFloat($("#qztqhp31").val())-parseFloat($("#qztqcp32").val()))/parseFloat($("#qztqcp32").val())).toFixed(1));
        if($("#qztq3Swc").val() >= 0 && $("#qztq3Swc").val() <= 4){
            $("#wc6").text("符合");
            $("#wc6").removeClass("no").addClass("is");
        }else{
            $("#wc6").text("不符合"); 
            $("#wc6").removeClass("is").addClass("no");
        }
    });
// 吸入氧浓度
    // 21
    $("#xryh13").blur(function(){
        $("#xryhp11").val(((parseFloat($("#xryh11").val())+parseFloat($("#xryh12").val())+parseFloat($("#xryh13").val()))/3).toFixed(1));
    });
    $("#xryc13").blur(function(){
        $("#xrycp12").val(((parseFloat($("#xryc11").val())+parseFloat($("#xryc12").val())+parseFloat($("#xryc13").val()))/3).toFixed(1));
        $("#xry1Swc").val((parseFloat($("#xryhp11").val())-parseFloat($("#xrycp12").val())).toFixed(1));
        if($("#xry1Swc").val() >= 0 && $("#xry1Swc").val() <= 1.05){
            $("#wc7").text("符合");
            $("#wc7").removeClass("no").addClass("is");
        }else{
            $("#wc7").text("不符合"); 
            $("#wc7").removeClass("is").addClass("no");
        }
    });
    // 60
    $("#xryh23").blur(function(){
        $("#xryhp21").val(((parseFloat($("#xryh21").val())+parseFloat($("#xryh22").val())+parseFloat($("#xryh23").val()))/3).toFixed(1));
    });
    $("#xryc23").blur(function(){
        $("#xrycp22").val(((parseFloat($("#xryc21").val())+parseFloat($("#xryc22").val())+parseFloat($("#xryc23").val()))/3).toFixed(1));
        $("#xry2Swc").val(parseFloat($("#xryhp21").val())-parseFloat($("#xrycp22").val()));
        if($("#xry2Swc").val() >= 0 && $("#xry2Swc").val() <= 3){
            $("#wc8").text("符合");
            $("#wc8").removeClass("no").addClass("is");
        }else{
            $("#wc8").text("不符合"); 
            $("#wc8").removeClass("is").addClass("no");
        }
    });
    // 100
    $("#xryh33").blur(function(){
        $("#xryhp31").val(((parseFloat($("#xryh31").val())+parseFloat($("#xryh32").val())+parseFloat($("#xryh33").val()))/3).toFixed(1));
    });
    $("#xryc33").blur(function(){
        $("#xrycp32").val(((parseFloat($("#xryc31").val())+parseFloat($("#xryc32").val())+parseFloat($("#xryc33").val()))/3).toFixed(1));
        $("#xry3Swc").val((parseFloat($("#xryhp31").val())-parseFloat($("#xrycp32").val())).toFixed(1));
        if($("#xry3Swc").val() >= 0 && $("#xry3Swc").val() <= 5){
            $("#wc9").text("符合");
            $("#wc9").removeClass("no").addClass("is");
        }else{
            $("#wc9").text("不符合"); 
            $("#wc9").removeClass("is").addClass("no");
        }
    });
// 吸气峰值压力
    // 10
    $("#xqfh13").blur(function(){
        $("#xqfhp11").val(((parseFloat($("#xqfh11").val())+parseFloat($("#xqfh12").val())+parseFloat($("#xqfh13").val()))/3).toFixed(1));
    });
    $("#xqfc13").blur(function(){
        $("#xqfcp12").val(((parseFloat($("#xqfc11").val())+parseFloat($("#xqfc12").val())+parseFloat($("#xqfc13").val()))/3).toFixed(1));
        $("#xqf1Swc").val((parseFloat($("#xqfhp11").val())-parseFloat($("#xqfcp12").val())).toFixed(1));
        if($("#xqf1Swc").val() >= 0 && $("#xqf1Swc").val() <= 3){
            $("#wc10").text("符合");
            $("#wc10").removeClass("no").addClass("is");
        }else{
            $("#wc10").text("不符合"); 
            $("#wc10").removeClass("is").addClass("no");
        }
    });
    // 20
    $("#xqfh23").blur(function(){
        $("#xqfhp21").val(((parseFloat($("#xqfh21").val())+parseFloat($("#xqfh22").val())+parseFloat($("#xqfh23").val()))/3).toFixed(1));
    });
    $("#xqfc23").blur(function(){
        $("#xqfcp22").val(((parseFloat($("#xqfc21").val())+parseFloat($("#xqfc22").val())+parseFloat($("#xqfc23").val()))/3).toFixed(1));
        $("#xqf2Swc").val((parseFloat($("#xqfhp21").val())-parseFloat($("#xqfcp22").val())).toFixed(1));
        if($("#xqf2Swc").val() >= 0 && $("#xqf2Swc").val() <= 3){
            $("#wc11").text("符合");
            $("#wc11").removeClass("no").addClass("is");
        }else{
            $("#wc11").text("不符合"); 
            $("#wc11").removeClass("is").addClass("no");
        }
    });
    // 30
    $("#xqfh33").blur(function(){
        $("#xqfhp31").val(((parseFloat($("#xqfh31").val())+parseFloat($("#xqfh32").val())+parseFloat($("#xqfh33").val()))/3).toFixed(1));
    });
    $("#xqfc33").blur(function(){
        $("#xqfcp32").val(((parseFloat($("#xqfc31").val())+parseFloat($("#xqfc32").val())+parseFloat($("#xqfc33").val()))/3).toFixed(1));
        $("#xqf3Swc").val((parseFloat($("#xqfhp31").val())-parseFloat($("#xqfcp32").val())).toFixed(1));
        if($("#xqf3Swc").val() >= 0 && $("#xqf3Swc").val() <= 3){
            $("#wc12").text("符合");
            $("#wc12").removeClass("no").addClass("is");
        }else{
            $("#wc12").text("不符合"); 
            $("#wc12").removeClass("is").addClass("no");
        }
    });
// 呼气末正压
    // 2
    $("#hqmh13").blur(function(){
        $("#hqmhp11").val(((parseFloat($("#hqmh12").val())+parseFloat($("#hqmh12").val())+parseFloat($("#hqmh13").val()))/3).toFixed(1));
    });
    $("#hqmc13").blur(function(){
        $("#hqmcp12").val(((parseFloat($("#hqmc11").val())+parseFloat($("#hqmc12").val())+parseFloat($("#hqmc13").val()))/3).toFixed(1));
        $("#hqm1Swc").val((parseFloat($("#hqmhp11").val())-parseFloat($("#hqmcp12").val())).toFixed(1));
        if($("#hqm1Swc").val() >= 0 && $("#hqm1Swc").val() <= 2){
            $("#wc13").text("符合");
            $("#wc13").removeClass("no").addClass("is");
        }else{
            $("#wc13").text("不符合"); 
            $("#wc13").removeClass("is").addClass("no");
        }
    });
    // 5
    $("#hqmh23").blur(function(){
        $("#hqmhp21").val(((parseFloat($("#hqmh21").val())+parseFloat($("#hqmh22").val())+parseFloat($("#hqmh23").val()))/3).toFixed(1));
    });
    $("#hqmc23").blur(function(){
        $("#hqmcp22").val(((parseFloat($("#hqmc21").val())+parseFloat($("#hqmc22").val())+parseFloat($("#hqmc23").val()))/3).toFixed(1));
        $("#hqm2Swc").val((parseFloat($("#hqmhp21").val())-parseFloat($("#hqmcp22").val())).toFixed(1));
        if($("#hqm2Swc").val() >= 0 && $("#hqm2Swc").val() <= 2){
            $("#wc14").text("符合");
            $("#wc14").removeClass("no").addClass("is");
        }else{
            $("#wc14").text("不符合"); 
            $("#wc14").removeClass("is").addClass("no");
        }
    });
    // 15
    $("#hqmh33").blur(function(){
        $("#hqmhp31").val(((parseFloat($("#hqmh31").val())+parseFloat($("#hqmh32").val())+parseFloat($("#hqmh33").val()))/3).toFixed(1));
    });
    $("#hqmc33").blur(function(){
        $("#hqmcp32").val(((parseFloat($("#hqmc31").val())+parseFloat($("#hqmc32").val())+parseFloat($("#hqmc33").val()))/3).toFixed(1));
        $("#hqm3Swc").val((parseFloat($("#hqmhp31").val())-parseFloat($("#hqmcp32").val())).toFixed(1));
        if($("#hqm3Swc").val() >= 0 && $("#hqm3Swc").val() <= 2){
            $("#wc15").text("符合");
            $("#wc15").removeClass("no").addClass("is");
        }else{
            $("#wc15").text("不符合"); 
            $("#wc15").removeClass("is").addClass("no");
        }
    });
}