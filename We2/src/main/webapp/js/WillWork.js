
$(".modal_bg").hide();
$(".second_body1").hide();
$(".second_body2").hide();
$(".second_body3").hide();
$(".second_body4").hide();
$(".second_body5").hide();

//멤버1을 클릭했을 때
$("#member1").click(function(){
	$(".modal_bg").show();
	$(".second_body1").show();
});

//멤버2를 클릭했을 때
$("#member2").click(function(){
	$(".modal_bg").show();
	$(".second_body2").show();
});
//멤버3을 클릭했을 때
$("#member3").click(function(){
	$(".modal_bg").show();
	$(".second_body3").show();
});
//멤버4를 클릭했을 때 
$("#member4").click(function(){
	$(".modal_bg").show();
	$(".second_body4").show();
});

//멤버5를 클릭했을 때
$("#member5").click(function(){
	$(".modal_bg").show();
	$(".second_body5").show();
});

$(".modal_bg").click(function(){
	$(".second_body1").hide();
	$(".second_body2").hide();
	$(".second_body3").hide();
	$(".second_body4").hide();
	$(".second_body5").hide();
	$(".modal_bg").hide();
	$(".first_main").show();
});
