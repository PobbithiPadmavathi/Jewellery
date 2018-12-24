$(function(){
  
    //Smooth scroll
    var $root = $('html, body');
    $('a').click(function(){
       $root.animate({
          scrollTop: $($.attr(this, 'href')).offset().top
       }, 800);
      return false;
    });

  
   //Sticky navigation on scroll.
      $(document).on('scroll', function(){
        if($(this).scrollTop() > 185){
            $('nav').addClass('nav-sticky');
        }else{
            $('nav').removeClass('nav-sticky');
        }
    });

  
    //Add active class to the nav on click.
    $('nav li a').click(function(){
    $('nav li a').removeClass('active');
    $(this).addClass('active');
    });

    $('nav li a').scroll(function(){
    $('nav li a').removeClass('active');
    $(this).addClass('active');
    });
  
   
  
});