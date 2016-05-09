/*var n=0;

var posLeft

var btnRight = $(".btn_next>a")

var btnLeft = $(".btn_prev>a")

var timer1 = setInterval("autoLeft()", 3000);

function autoLeft(){
    n++;
    if(n<4){
        posLeft = -100%*n;
        $(".main_slider").stop().animate({"left":posLeft},500);
    }else{
        n = 0;
        posLeft = -100%*n;
        $(".main_slider").stop().animate({"left":posLeft},500);
    }
};



function autoRight(){
    n--;
    if(n<0){
        n = 1;
        posLeft = -100%*n;
        $(".main_slider").stop().animate({"left":posLeft},500);
    }else{
        posLeft = -100%*n;
        $(".main_slider").stop().animate({"left":posLeft},500);
    }
};*/



$(".btn_prev>a").on("click",function(){
    $(".main_slider").stop().animate({"left":"-=100%"},500);
    $(this).parent().prev().children().preppend($(this).children().eq(3));
});

$(".btn_next>a").on("click",function(){
    $(".main_slider").stop().animate({"left":"+=100%"},500);
    $(this).parent().prev().append($(this).children().eq(0));
    //$(this).append($(this).children().eq(0));
});














