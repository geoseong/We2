var btnRight2 = $(".btn_next>a");
var btnLeft2 = $(".btn_prev>a");    
var timer3 = setInterval("autoRight2()",3000);    
    
function autoLeft2(){    
    $(".main_slider").stop().animate({"left":"-100%"},500,function(){
        $(this).css({"left":"0px"});
        $(this).append($(this).children().eq(0));
    });    
}
  
function autoRight2(){
    $(".main_slider").stop().animate({"left":"100%"},500,function(){
        $(this).css({"left":"0px"});
        $(this).prepend($(this).children().eq(3));
    });
}
    
btnRight2.on("click",function(){
    if($(".main_slider").css("left")=="0px"){
        autoLeft2();
    }
//    btnStop2.hide();
    btnPlay2.show();
    clearInterval(timer3);
    return false;
}); 

btnLeft2.on("click",function(){
    if($(".main_slider").css("left")=="0px"){
        autoRight2();
    };
//    btnStop2.hide();
    btnPlay2.show();
    clearInterval(timer3);
    return false;
});
    
    
//btnStop2.children().on("click",function(){
//    clearInterval(timer3);
//    btnStop2.hide();
//    btnPlay2.show();
//    return false;
//});    

btnPlay2.children().on("click",function(){
    timer3 = setInterval("autoLeft2()",3000);
//    btnStop2.show();
    btnPlay2.hide();
    return false;
});     