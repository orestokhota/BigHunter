//Problem:don't have any interactivity
//Solution: need interactivity
 $("#registration").hide();
 $("#two").css("color","#FF8C00");
 $("#two").css("border-bottom","2px solid #fff");
//1. when user click on register #registration display block & login hide (default:login)
$("#one").click(function(){
  $("#one").css("color","#FF8C00");
   $("#one").css("border-bottom","2px solid #fff");
  $("#two").css("color","#FFF");
  $("#two").css("border-bottom","none");
  $("#login").hide(1000);
  $("#registration").show(1000);
});
$("#two").click(function(){
  $("#one").css("color","#FFF");
  $("#one").css("border-bottom","none");
  $("#two").css("color","#FF8C00");
   $("#two").css("border-bottom","2px solid #fff");
  $("#registration").hide(1000);
  $("#login").show(1000);
});
//2.Color of open tab will be #ff8C00