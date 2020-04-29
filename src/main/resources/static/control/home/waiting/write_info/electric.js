window.onload = function(){
    $("#inp1").focus(function () {
        $("#p1").text("允许值（220±22）V");
        $("#p1").removeClass("no").removeClass("is");
    });
    $("#inp1").blur(function () {
        if($(this).val()>198 && $(this).val()<242){
            $("#p1").text("√ 符合");
            $("#p1").removeClass("no").addClass("is");
        }else{
            $("#p1").text("× 不符合");
            $("#p1").removeClass("is").addClass("no");
        }
    });
    $("#inp2").focus(function () {
        $("#p2").text("允许值 ≤200 mΩ");
        $("#p2").removeClass("no").removeClass("is");
    });
    $("#inp2").blur(function () {
        if($(this).val()<=200 && $(this).val()!=""){
            $("#p2").text("√ 符合");
            $("#p2").removeClass("no").addClass("is")
        }else{
            $("#p2").text("× 不符合");
            $("#p2").removeClass("is").addClass("no")
        }
    });
    $("#inp3").focus(function () {
        $("#p3").text("允许值 ≥10 MΩ");
        $("#p3").removeClass("no").removeClass("is");
    });
    $("#inp3 ").blur(function () {
        if($(this).val() >= 10  || $(this).val() == "OL"){
            $("#p3").text("√ 符合");
            $("#p3").removeClass("no").addClass("is")
        }else{
            $("#p3").text("× 不符合");
            $("#p3").removeClass("is").addClass("no")
        }
    });
    $("#inp4").focus(function () {
        $("#p4").text("允许值 ≤500µA");
        $("#p4").removeClass("no").removeClass("is");
    });
    $("#inp4 ").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p4").text("√ 符合");
            $("#p4").removeClass("no").addClass("is")
        }else{
            $("#p4").text("× 不符合");
            $("#p4").removeClass("is").addClass("no")
        }
    });
    $("#inp5").focus(function () {
        $("#p5").text("允许值 ≤500µA");
        $("#p5").removeClass("no").removeClass("is");
    });
    $("#inp5").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p5").text("√ 符合");
            $("#p5").removeClass("no").addClass("is")
        }else{
            $("#p5").text("× 不符合");
            $("#p5").removeClass("is").addClass("no")
        }
    });
    $("#inp6").focus(function () {
        $("#p6").text("允许值 ≤1000µA");
        $("#p6").removeClass("no").removeClass("is");
    });
    $("#inp6").blur(function () {
        if($(this).val()<=1000 && $(this).val()!=""){
            $("#p6").text("√ 符合");
            $("#p6").removeClass("no").addClass("is")
        }else{
            $("#p6").text("× 不符合");
            $("#p6").removeClass("is").addClass("no")
        }
    });
    $("#inp7").focus(function () {
        $("#p7").text("允许值 ≤1000µA");
        $("#p7").removeClass("no").removeClass("is");
    });
    $("#inp7").blur(function () {
        if($(this).val()<=1000 && $(this).val()!=""){
            $("#p7").text("√ 符合");
            $("#p7").removeClass("no").addClass("is")
        }else{
            $("#p7").text("× 不符合");
            $("#p7").removeClass("is").addClass("no")
        }
    });
    $("#inp8").focus(function () {
        $("#p8").text("允许值 ≤100µA");
        $("#p8").removeClass("no").removeClass("is");
    });
    $("#inp8").blur(function () {
        if($(this).val()<=100 && $(this).val()!=""){
            $("#p8").text("√ 符合");
            $("#p8").removeClass("no").addClass("is")
        }else{
            $("#p8").text("× 不符合");
            $("#p8").removeClass("is").addClass("no")
        }
    });
    $("#inp9").focus(function () {
        $("#p9").text("允许值 ≤100µA");
        $("#p9").removeClass("no").removeClass("is");
    });
    $("#inp9").blur(function () {
        if($(this).val()<=100 && $(this).val()!=""){
            $("#p9").text("√ 符合");
            $("#p9").removeClass("no").addClass("is")
        }else{
            $("#p9").text("× 不符合");
            $("#p9").removeClass("is").addClass("no")
        }
    });
    $("#inp10").focus(function () {
        $("#p10").text("允许值 ≤500µA");
        $("#p10").removeClass("no").removeClass("is");
    });
    $("#inp10").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p10").text("√ 符合");
            $("#p10").removeClass("no").addClass("is")
        }else{
            $("#p10").text("× 不符合");
            $("#p10").removeClass("is").addClass("no")
        }
    });
    $("#inp11").focus(function () {
        $("#p11").text("允许值 ≤500µA");
        $("#p11").removeClass("no").removeClass("is");
    });
    $("#inp11").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p11").text("√ 符合");
            $("#p11").removeClass("no").addClass("is")
        }else{
            $("#p11").text("× 不符合");
            $("#p11").removeClass("is").addClass("no")
        }
    });
    $("#inp12").focus(function () {
        $("#p12").text("允许值 ≤500µA");
        $("#p12").removeClass("no").removeClass("is");
    });
    $("#inp12").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p12").text("√ 符合");
            $("#p12").removeClass("no").addClass("is")
        }else{
            $("#p12").text("× 不符合");
            $("#p12").removeClass("is").addClass("no")
        }
    });
    $("#inp13").focus(function () {
        $("#p13").text("允许值 ≤500µA");
        $("#p13").removeClass("no").removeClass("is");
    });
    $("#inp13").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p13").text("√ 符合");
            $("#p13").removeClass("no").addClass("is")
        }else{
            $("#p13").text("× 不符合");
            $("#p13").removeClass("is").addClass("no")
        }
    });
    $("#inp14").focus(function () {
        $("#p14").text("允许值 ≤100µA");
        $("#p14").removeClass("no").removeClass("is");
    });
    $("#inp14").blur(function () {
        if($(this).val()<=100 && $(this).val()!=""){
            $("#p14").text("√ 符合");
            $("#p14").removeClass("no").addClass("is")
        }else{
            $("#p14").text("× 不符合");
            $("#p14").removeClass("is").addClass("no")
        }
    });
    $("#inp15").focus(function () {
        $("#p15").text("允许值 ≤100µA");
        $("#p15").removeClass("no").removeClass("is");
    });
    $("#inp15").blur(function () {
        if($(this).val()<=100 && $(this).val()!=""){
            $("#p15").text("√ 符合");
            $("#p15").removeClass("no").addClass("is")
        }else{
            $("#p15").text("× 不符合");
            $("#p15").removeClass("is").addClass("no")
        }
    });
    $("#inp16").focus(function () {
        $("#p16").text("允许值 ≤500µA");
        $("#p16").removeClass("no").removeClass("is");
    });
    $("#inp16").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p16").text("√ 符合");
            $("#p16").removeClass("no").addClass("is")
        }else{
            $("#p16").text("× 不符合");
            $("#p16").removeClass("is").addClass("no")
        }
    });
    $("#inp17").focus(function () {
        $("#p17").text("允许值 ≤500µA");
        $("#p17").removeClass("no").removeClass("is");
    });
    $("#inp17").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p17").text("√ 符合");
            $("#p17").removeClass("no").addClass("is")
        }else{
            $("#p17").text("× 不符合");
            $("#p17").removeClass("is").addClass("no")
        }
    });
    $("#inp18").focus(function () {
        $("#p18").text("允许值 ≤500µA");
        $("#p18").removeClass("no").removeClass("is");
    });
    $("#inp18").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p18").text("√ 符合");
            $("#p18").removeClass("no").addClass("is")
        }else{
            $("#p18").text("× 不符合");
            $("#p18").removeClass("is").addClass("no")
        }
    });
    $("#inp19").focus(function () {
        $("#p19").text("允许值 ≤500µA");
        $("#p19").removeClass("no").removeClass("is");
    });
    $("#inp19").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p19").text("√ 符合");
            $("#p19").removeClass("no").addClass("is")
        }else{
            $("#p19").text("× 不符合");
            $("#p19").removeClass("is").addClass("no")
        }
    });
    $("#inp20").focus(function () {
        $("#p20").text("允许值 ≤500µA");
        $("#p20").removeClass("no").removeClass("is");
    });
    $("#inp20").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p20").text("√ 符合");
            $("#p20").removeClass("no").addClass("is")
        }else{
            $("#p20").text("× 不符合");
            $("#p20").removeClass("is").addClass("no")
        }
    });
    $("#inp21").focus(function () {
        $("#p21").text("允许值 ≤500µA");
        $("#p21").removeClass("no").removeClass("is");
    });
    $("#inp21").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p21").text("√ 符合");
            $("#p21").removeClass("no").addClass("is")
        }else{
            $("#p21").text("× 不符合");
            $("#p21").removeClass("is").addClass("no")
        }
    });
    $("#inp22").focus(function () {
        $("#p22").text("允许值 ≤500µA");
        $("#p22").removeClass("no").removeClass("is");
    });
    $("#inp22").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p22").text("√ 符合");
            $("#p22").removeClass("no").addClass("is")
        }else{
            $("#p22").text("× 不符合");
            $("#p22").removeClass("is").addClass("no")
        }
    });
    $("#inp23").focus(function () {
        $("#p23").text("允许值 ≤500µA");
        $("#p23").removeClass("no").removeClass("is");
    });
    $("#inp23").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p23").text("√ 符合");
            $("#p23").removeClass("no").addClass("is")
        }else{
            $("#p23").text("× 不符合");
            $("#p23").removeClass("is").addClass("no")
        }
    });
    $("#inp24").focus(function () {
        $("#p24").text("允许值 ≤500µA");
        $("#p24").removeClass("no").removeClass("is");
    });
    $("#inp24").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p24").text("√ 符合");
            $("#p24").removeClass("no").addClass("is")
        }else{
            $("#p24").text("× 不符合");
            $("#p24").removeClass("is").addClass("no")
        }
    });
    $("#inp25").focus(function () {
        $("#p25").text("允许值 ≤500µA");
        $("#p25").removeClass("no").removeClass("is");
    });
    $("#inp25").blur(function () {
        if($(this).val()<=500 && $(this).val()!=""){
            $("#p25").text("√ 符合");
            $("#p25").removeClass("no").addClass("is")
        }else{
            $("#p25").text("× 不符合");
            $("#p25").removeClass("is").addClass("no")
        }
    });
    $("#inp26").focus(function () {
        $("#p26").text("允许值 ≤10µA");
        $("#p26").removeClass("no").removeClass("is");
    });
    $("#inp26").blur(function () {
        if($(this).val()<=10 && $(this).val()!=""){
            $("#p26").text("√ 符合");
            $("#p26").removeClass("no").addClass("is")
        }else{
            $("#p26").text("× 不符合");
            $("#p26").removeClass("is").addClass("no")
        }
    });
    $("#inp27").focus(function () {
        $("#p27").text("允许值 ≤10µA");
        $("#p27").removeClass("no").removeClass("is");
    });
    $("#inp27").blur(function () {
        if($(this).val()<=10 && $(this).val()!=""){
            $("#p27").text("√ 符合");
            $("#p27").removeClass("no").addClass("is")
        }else{
            $("#p27").text("× 不符合");
            $("#p27").removeClass("is").addClass("no")
        }
    });
    $("#inp28").focus(function () {
        $("#p28").text("允许值 ≤50µA");
        $("#p28").removeClass("no").removeClass("is");
    });
    $("#inp28").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p28").text("√ 符合");
            $("#p28").removeClass("no").addClass("is")
        }else{
            $("#p28").text("× 不符合");
            $("#p28").removeClass("is").addClass("no")
        }
    });
    $("#inp29").focus(function () {
        $("#p29").text("允许值 ≤50µA");
        $("#p29").removeClass("no").removeClass("is");
    });
    $("#inp29").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p29").text("√ 符合");
            $("#p29").removeClass("no").addClass("is")
        }else{
            $("#p29").text("× 不符合");
            $("#p29").removeClass("is").addClass("no")
        }
    });
    $("#inp30").focus(function () {
        $("#p30").text("允许值 ≤50µA");
        $("#p30").removeClass("no").removeClass("is");
    });
    $("#inp30").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p30").text("√ 符合");
            $("#p30").removeClass("no").addClass("is")
        }else{
            $("#p30").text("× 不符合");
            $("#p30").removeClass("is").addClass("no")
        }
    });
    $("#inp31").focus(function () {
        $("#p31").text("允许值 ≤50µA");
        $("#p31").removeClass("no").removeClass("is");
    });
    $("#inp31").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p31").text("√ 符合");
            $("#p31").removeClass("no").addClass("is")
        }else{
            $("#p31").text("× 不符合");
            $("#p31").removeClass("is").addClass("no")
        }
    });
    $("#inp32").focus(function () {
        $("#p32").text("允许值 ≤10µA");
        $("#p32").removeClass("no").removeClass("is");
    });
    $("#inp32").blur(function () {
        if($(this).val()<=10 && $(this).val()!=""){
            $("#p32").text("√ 符合");
            $("#p32").removeClass("no").addClass("is")
        }else{
            $("#p32").text("× 不符合");
            $("#p32").removeClass("is").addClass("no")
        }
    });
    $("#inp33").focus(function () {
        $("#p33").text("允许值 ≤10µA");
        $("#p33").removeClass("no").removeClass("is");
    });
    $("#inp33").blur(function () {
        if($(this).val()<=10 && $(this).val()!=""){
            $("#p33").text("√ 符合");
            $("#p33").removeClass("no").addClass("is")
        }else{
            $("#p33").text("× 不符合");
            $("#p33").removeClass("is").addClass("no")
        }
    });
    $("#inp34").focus(function () {
        $("#p34").text("允许值 ≤50µA");
        $("#p34").removeClass("no").removeClass("is");
    });
    $("#inp34").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p34").text("√ 符合");
            $("#p34").removeClass("no").addClass("is")
        }else{
            $("#p34").text("× 不符合");
            $("#p34").removeClass("is").addClass("no")
        }
    });
    $("#inp35").focus(function () {
        $("#p35").text("允许值 ≤50µA");
        $("#p35").removeClass("no").removeClass("is");
    });
    $("#inp35").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p35").text("√ 符合");
            $("#p35").removeClass("no").addClass("is")
        }else{
            $("#p35").text("× 不符合");
            $("#p35").removeClass("is").addClass("no")
        }
    });
    $("#inp36").focus(function () {
        $("#p36").text("允许值 ≤50µA");
        $("#p36").removeClass("no").removeClass("is");
    });
    $("#inp36").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p36").text("√ 符合");
            $("#p36").removeClass("no").addClass("is")
        }else{
            $("#p36").text("× 不符合");
            $("#p36").removeClass("is").addClass("no")
        }
    });
    $("#inp37").focus(function () {
        $("#p37").text("允许值 ≤50µA");
        $("#p37").removeClass("no").removeClass("is");
    });
    $("#inp37").blur(function () {
        if($(this).val()<=50 && $(this).val()!=""){
            $("#p37").text("√ 符合");
            $("#p37").removeClass("no").addClass("is")
        }else{
            $("#p37").text("× 不符合");
            $("#p37").removeClass("is").addClass("no")
        }
    });
}