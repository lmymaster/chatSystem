// JavaScript Document

$(function(){

    //  if("placeholder" in document.createElement("input")){
    if(!0){
        $('.placeholder').each(function(){
            var _this = $(this);
            var txt = _this.val();
            _this.val(txt).focus(function () {
                if (_this.val() === _this.val()) {
                    _this.val("")
                }
            }).blur(function () {
                if (_this.val().length === 0) {
                    _this.val(txt)
                }
            })

        });
    }



    // 引入公共文件
    //$('body').prepend('<div id="head"></div>').append('<div id="foot"></div>').append('<div id="video_" style="display: none;"></div>');

    $('.e-classify').hover(function(){
        $('.e-classify').removeClass('on');
        $('.s-classify').hide();
        $(this).addClass('on').find('.s-classify').show();
    },function(){
        $('.e-classify').removeClass('on');
        $('.s-classify').hide();
    });

    if(true){
        $('.all-course,.course-classify').hover(function(){
            $('.course-classify').show();
        },function(){
            $('.course-classify').hide();
        });
    };
    var mh = $(window).height()-$('#head').height()-$('#foot').height()-35;
    //$('.content').css('min-height',mh);

    setTimeout(a,1000)
    function a(){
        var h = $("#iframe1").contents().height();
        $('#iframe1').height(h);
    };


    window.href = document.location.href;
    new nav('.nav3');
    function nav(target){
        $('a',target).removeClass('on').find('b').remove();
        $(target).children().each(function(){
            if(href.indexOf($(this).attr("href"))>=0){
                $(this).addClass("on").append('<b></b>');
            };
        });
    };


    // 菜单加on
    var navarr = [['vedio',3],['new',4],['hot',5]];
    for(var i = 0; i<navarr.length; i++){
        var h = location.href;
        if(h.indexOf(navarr[i][0])>=0){
            $('.nav li').eq((navarr[i][1])-1).find('a').addClass('on')
        }
    };


    /* 播放视频 */
    var btnvideo = [
        //'.list14 a'
    ];
    for(var i=0;i<btnvideo.length;i++){
        $(btnvideo[i]).click(function(e){
            e.preventDefault();
            $('.d-video').show();
            $('#video').attr('src','images/flowers.mp4');
        });
    };
    function playvideo(){
        $('.d-video').show();
        $('#video').attr('src','images/flowers.mp4');
    };

    var t = (new Date()).getTime()
    $('link').attr('href',$('link').attr('href')+'?a='+t)
});


function stopvideo(){
    $('.d-video').hide();
    $('#video').attr('src','');
};


$(document).ready(function(){
   $(".select").click(function(){
    $(".s-list").slideToggle("1000");
  });
   $(".s-list li").click(function(){
   var chirl_name=$(this).text();
   $(".s-list").hide();
   $("input.select").val(chirl_name);
  });
    //节取文本  2016-09-12 hhf
    jQuery.fn.limit=function(){
        var ai_str1 = $('.imfor').text(),ai_str2 = $('.list-2 p.name').text();
        var num_1 = 75,num_2 =10;
        if(ai_str1 .length>num_1){
            var sub_1 = ai_str1 .substring(0,75) + '......';
            $('.imfor').text(sub_1);
        }
        if(ai_str2 .length>num_2){
            var sub_2 = ai_str2 .substring(0,10) + '...';
            $('.list-2 p.name').text(sub_2);
        }

    }
    $(function(){
        $(document.body).limit();
    })





});










