jQuery.noConflict();

function getCookie(name)
{
    var cookie = " " + document.cookie;
    var search = " " + name + "=";
    var setStr = null;
    var offset = 0;
    var end = 0;
    if (cookie.length > 0) {
        offset = cookie.indexOf(search);
        if (offset != -1) {
            offset += search.length;
            end = cookie.indexOf(";", offset)
            if (end == -1) {
                end = cookie.length;
            }
            setStr = unescape(cookie.substring(offset, end));
        }
    }
    return(setStr);
}

// Topmenu <ul> replace to <select>
function responsive(mainNavigation) {
	var $ = jQuery;
	var screenRes = $('.welcome_inn_demo').width();
	
	if ($('.menu-top select').length == 0) {
		/* Replace unordered list with a "select" element to be populated with options, and create a variable to select our new empty option menu */
		$('.menu-top').append('<select class="select_topmenu" id="topm-select" style="display:none;"></select>');
		var selectMenu = $('#topm-select');

		/* Navigate our nav clone for information needed to populate options */
		$(mainNavigation).children('ul').children('li').each(function () {

			/* Get top-level link and text */
			var href = $(this).children('a').attr('href');
			var text = $(this).children('a').text();

			/* Append this option to our "select" */
			if ($(this).is(".current-menu-item") && href != '#') {
				$(selectMenu).append('<option value="' + href + '" selected>' + text + '</option>');
			} else if (href == '#') {
				$(selectMenu).append('<option value="' + href + '" disabled="disabled">' + text + '</option>');
			} else {
				$(selectMenu).append('<option value="' + href + '">' + text + '</option>');
			}

			/* Check for "children" and navigate for more options if they exist */
			if ($(this).children('ul').length > 0) {
				$(this).children('ul').children('li').each(function () {

					/* Get child-level link and text */
					var href2 = $(this).children('a').attr('href');
					var text2 = $(this).children('a').text();

					/* Append this option to our "select" */
					if ($(this).is(".current-menu-item") && href2 != '#') {
						$(selectMenu).append('<option value="'+href2+'" selected> - '+text2+'</option>');
					} else if (href2 == '#') {
						$(selectMenu).append('<option value="'+href2+'" disabled="disabled"># '+text2+'</option>');
					} else {
						$(selectMenu).append('<option value="'+href2+'"> - '+text2+'</option>');
					}

					/* Check for "children" and navigate for more options if they exist */
					if ($(this).children('ul').length > 0) {
						$(this).children('ul').children('li').each(function () {

							/* Get child-level link and text */
							var href3 = $(this).children('a').attr('href');
							var text3 = $(this).children('a').text();

							/* Append this option to our "select" */
							if ($(this).is(".current-menu-item")) {
								$(selectMenu).append('<option value="' + href3 + '" class="select-current" selected> -- ' + text3 + '</option>');
							} else {
								$(selectMenu).append('<option value="' + href3 + '"> -- ' + text3 + '</option>');
							}

						});
					}
				});
			}
		});
	} 
	if(screenRes >= 750){
        $('.menu-top select:first').hide();
        $('.menu-top ul:first').show();      
    }else{
        $('.menu-top ul:first').hide();
        $('.menu-top select:first').show();             
    }

	/* When our select menu is changed, change the window location to match the value of the selected option. */
	$(selectMenu).change(function () {
		location = this.options[this.selectedIndex].value;
	});
}

jQuery(document).ready(function($) {
    jQuery('#tablet_responsive').click(function(e){
        e.preventDefault();
        document.cookie=  tf_script.TF_THEME_PREFIX + '_responsive_width' + "=480";
        location.reload();
    });
    jQuery('#phone_responsive').click(function(e){
        e.preventDefault();
        document.cookie=  tf_script.TF_THEME_PREFIX + '_responsive_width' + "=320";
        location.reload();
    });
    jQuery('#desktop_responsive').click(function(e){
        e.preventDefault();
        document.cookie=  tf_script.TF_THEME_PREFIX + '_responsive_width' + "=";
        location.reload();
    });
	
	var screenRes = $('.welcome_inn_demo').width();
	
	// topmenu replace to select
	var mainNavigation = $('.menu-top').clone();
	responsive(mainNavigation);
	// reload topmenu on Resize
    $(window).resize(function() {		
        var screenRes = $('.welcome_inn_demo').width();
        responsive(mainNavigation);
    });
	
	// dropdown menu
    $(".menu-top ul").parent("li").addClass("parent");
    $(".menu-top li:first-child").addClass("first");
    $(".menu-top li:last-child").addClass("last");
    $(".menu-top li:only-child").removeClass("last").addClass("only");	

    $("ul.tabs").tabs("> .tabcontent", {
        tabs: 'li'
    });

    $(".row .col:first-child").addClass("alpha");
	$(".row .col:last-child").addClass("omega"); 
	
// toggle content
	$(".toggle_content, .highlighter").hide();
	
	$("h3.toggle").toggle(function(){
		$(this).addClass("active");
		}, function () {
		$(this).removeClass("active");
	});
	
	$("h3.toggle").click(function(){
		$(this).next(".highlighter").slideToggle();
		$(this).next(".toggle_content").slideToggle();
	});

// pagination
	var islast = $(".pagination .inner a:last").hasClass('page_current');
	if(islast) $(".pagination .inner").css('padding-right','35px');

	if ($.browser.msie  && parseInt($.browser.version) == 7) {
	 	var ispageprev = $(".pagination .inner a").hasClass('page_prev');
		if(ispageprev) $(".pagination, .pagination .inner").css('padding-left','0px');
	}
	
// pricing table
    $(".table-price tr td:first-child").addClass("first_col");
	$(".table-price tbody tr:odd").addClass("odd");   


// gallery
	$(".gl_col_2 .gallery-item:nth-child(2n)").addClass("nomargin");
	$(".gl_col_3 .gallery-item:nth-child(3n)").addClass("nomargin");
	$(".gl_col_4 .gallery-item:nth-child(4n)").addClass("nomargin");

// PrettyPhoto
	if($('a[rel="prettyPhoto"]') && screenRes > 600) {        	
		$('a[rel^="prettyPhoto"]').prettyPhoto({animationSpeed:'slow', slideshow:3000, autoplay_slideshow: false, social_tools:false});	
    }

// comments scroll
	$('.link-top').click(function () {
		$('body,html').animate({
			scrollTop: 0
		},
		1500);
	});
	$('.link-bottom, .link-addcomment').click(function () {
		$('body,html').animate({
			scrollTop: $('#comments').offset().top
		},
		1500);
		return false;
	});

});


jQuery(document).ready(function($) {
     $(window).scroll(function () {  
         if ($(this).scrollTop() != 0) {  
             $('.link-top').fadeIn();  
         } else {  
             $('.link-top').fadeOut();  
         }  
     });  
     $('.link-top').click(function () {  
         $('body,html').animate({  
             scrollTop: 0  
         },  
         1500);  
     });  
 });


