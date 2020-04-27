$(document).ready(function() {
	$(window).scroll(function() {
        if ($(this).scrollTop() != 0) {
          $(".backtop").fadeIn();
        } else {
          $(".backtop").fadeOut();
        }
      });

      $(".backtop").click(function() {
        $("body,html").animate(
          {
            scrollTop: 0
          },
          800
        );
      });
  });
