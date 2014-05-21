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


function SetCookie (name,value,expires,path,domain,secure)
{
    var today = new Date();
    var date = new Date();
    date.setTime(expires*1000);
    document.cookie = name + "=" + escape (value) +
    ((expires) ? "; expires=" + date.toGMTString() : "") +
    ((path) ? "; path=" + path : "") +
    ((domain) ? "; domain=" + domain : "") +
    ((secure) ? "; secure" : "");
}


jQuery(window).load(function()
{
	var speed = 400;
	var tfusetoppanelshow = getCookie('tfusetoppanelshow');
	var tfuse_top_panel = jQuery("#tfuse-top-sliding-panel-container");
	jQuery("body").prepend(tfuse_top_panel);
	tfuse_top_panel.show();

	// slideup on page load
	if(tfusetoppanelshow == 'yes')
	{
		jQuery("#tfuse-top-sliding-panel-container").css({top:"-96px"});
		jQuery(this).removeClass("ajax-close-tfuse-top-slide").addClass("ajax-open-tfuse-top-slide");
	}
	else
	{
		jQuery(this).removeClass("ajax-open-tfuse-top-slide").addClass("ajax-close-tfuse-top-slide");
		jQuery("#tfuse-top-sliding-panel-container").animate({top:"-1px"}, 900);
		jQuery("#tfuse-top-sliding-panel-container").animate({top:"-1px"}, 2000);
		jQuery("#tfuse-top-sliding-panel-container").animate({top:"-96px"}, 900);
		jQuery(this).removeClass("ajax-close-tfuse-top-slide").addClass("ajax-open-tfuse-top-slide");
		document.cookie = "tfusetoppanelshow=yes; path=/";
	}

	jQuery(this).removeClass("ajax-close-tfuse-top-slide").addClass("ajax-open-tfuse-top-slide");

	//slid up/down top panel
	jQuery("#tfuse-top-sliding-panel-container #tfuse-top-sliding-panel-btn-slide").click(function()
	{
		document.cookie = "tfusetoppanelshow=yes; path=/";
		if( jQuery(this).hasClass("ajax-open-tfuse-top-slide") ) {
			jQuery("#tfuse-top-sliding-panel-container").animate({top:"-1px"}, speed);
			jQuery(this).removeClass("ajax-open-tfuse-top-slide").addClass("ajax-close-tfuse-top-slide");
		}
		else if ( jQuery(this).hasClass("ajax-close-tfuse-top-slide") )
		{
			jQuery("#tfuse-top-sliding-panel-container").animate({top:"-96px"}, speed);
			jQuery(this).removeClass("ajax-close-tfuse-top-slide").addClass("ajax-open-tfuse-top-slide");
		}
	});

	//slide up when click outside
	jQuery("#tfuse-top-sliding-panel-container").hover
	(
            function() {
                jQuery('body').unbind('click.themefuse');
            },
            function() {
                if( jQuery("#tfuse-top-sliding-panel-container #tfuse-top-sliding-panel-btn-slide").hasClass("ajax-close-tfuse-top-slide") )
                {
                    jQuery('body').one('click.themefuse',function()
                    {
                        jQuery(this).unbind('click.themefuse');
                        jQuery("#tfuse-top-sliding-panel-container").animate({top:"-96px"}, speed);
                        jQuery("#tfuse-top-sliding-panel-container #tfuse-top-sliding-panel-btn-slide").removeClass("ajax-close-tfuse-top-slide").addClass("ajax-open-tfuse-top-slide");
                    });
                }
            }
	);

	// slide up/down styles list
	jQuery(".tfuse-top-sliding-panel-dropdown dt a").click(function()
	{
            var dropID = jQuery(this).closest("dl").attr("id");
            jQuery("#"+dropID+" dd ul").slideToggle(200);
            jQuery("#"+dropID).mouseleave(function() {
                jQuery("#"+dropID+" dd ul").slideUp(200);
            });
	});

	// set default value
	//var tfusetoppanelshowtheme = getCookie('tfusetoppanelshowtheme'); //get from coockie selected theme
	var tfusetoppanelshowtheme = jQuery("#tfuse-top-sliding-panel-container-active-theme").text();
	if(tfusetoppanelshowtheme != null )
	{
            var fisrt_element = jQuery("#tfuse-top-sliding-panel-themelist li a[rel='"+tfusetoppanelshowtheme+"']");
	}
	else
	{
            var fisrt_element = jQuery("#tfuse-top-sliding-panel-themelist li:first-child a");
	}
        
	var default_value = fisrt_element.html();
	jQuery("#tftsp_currentTheme").html(default_value);

	var selected_theme = fisrt_element.attr("rel");

	if(jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme).length)
	{

            jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme).show();
            var selectedcolor = jQuery("#tfuse-top-sliding-panel-container-selected-color").text();
            if(!selectedcolor)
            {
                var selectedcolor = getCookie(selected_theme+'_style_demo'); //get from coockie selected color for specific theme
                if(selectedcolor != null) selectedcolor = selectedcolor.replace('.css','');
            }

            if(selectedcolor) var default_value2 = jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme+" ul li a[href*='color="+selectedcolor+"']").html();

            if(tfusetoppanelshowtheme == 'brandcrafters')
            {
                var bgcolor = getCookie(selected_theme+'_bgcolor');
                bgcolor = (bgcolor) ? bgcolor : '#414852';
                jQuery('div.tfuse-top-sliding-panel-select-style span.tfuse-top-sliding-panel-headerName').text('Header Backgrounds');
                jQuery('.header, .header_style2').css('backgroundColor', bgcolor);
                jQuery('#tfuse-top-sliding-panel-container dl.tfuse-top-sliding-panel-dropdown span.tfuse-top-sliding-panel-ico-color').css(
                    {
                        "background-color":bgcolor,
                        "height":"20px",
                        "width":"20px",
                        "margin":"5px 8px 0 5px"
                    }
                );

                var selectedbg = jQuery("#tfuse-top-sliding-panel-container-selected-bg").text();
                if(!selectedbg)
                {
                    var selectedbg = getCookie(selected_theme+'_style_demo'); //get from coockie selected color for specific theme
                }
                if(selectedbg)
                {
                    var bghtml = jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme+" ul li a[href*='bg="+selectedbg+"']");
                    var default_value2 = jQuery(bghtml).html()
                }

            }
		
		
            if(tfusetoppanelshowtheme == 'writer')
            {
                jQuery('div.tfuse-top-sliding-panel-select-style span.tfuse-top-sliding-panel-headerName').text('Header Backgrounds');
                jQuery('#tfuse-top-sliding-panel-container dl.tfuse-top-sliding-panel-dropdown span.tfuse-top-sliding-panel-ico-color').css(
                    {
                        "height":"20px",
                        "width":"20px",
                        "margin":"5px 8px 0 5px"
                    }
                );

                var selectedbg = jQuery("#tfuse-top-sliding-panel-container-selected-bg").text();
                if(!selectedbg)
                {
                    var selectedbg = getCookie(selected_theme+'_style_demo'); //get from coockie selected color for specific theme
                }
                if(selectedbg)
                {
                    var bghtml = jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme+" ul li a[href*='header_image="+selectedbg+"']");
                    var default_value2 = jQuery(bghtml).html()
                }

            }
		

            if( (tfusetoppanelshowtheme == 'welcomeinn') || (tfusetoppanelshowtheme == 'welcome-inn'))
            {
                var welcomeinnurl = window.location.href;
                var welcomeinnvar = tfusetoppanelshowtheme;
                if (welcomeinnurl.match(/welcomeinn1/))
                {
                    welcomeinnvar = 'welcomeinn1';
                }
                else if (welcomeinnurl.match(/welcomeinn2/))
                {
                    welcomeinnvar = 'welcomeinn2';
                }
                var default_value2 = jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme+" ul li a[href*='wp/"+welcomeinnvar+"']").html();
            }

            if(!default_value2) var default_value2 = jQuery("#tfuse-top-sliding-panel-stylelist #"+selected_theme+" ul li:first-child a").html();
            jQuery("#tfuse-top-sliding-panel-stylelist dt a span").html(default_value2);
	}
	else
	{
            jQuery(".tfuse-top-sliding-panel-select-style").hide();
	}

	//set buy link
	switch(selected_theme)
	{
            case 'art-gallery': buylink= "art-gallery";
            break;
            case 'bon-apetit': buylink = "bon-apetit";
            break;
            case 'creative-juice': buylink = "creative-juice";
            break;
            case 'exquisite': buylink= "exquisite-works";
            break;
            case 'siliconapp': buylink= "siliconapp";
            break;
            case 'c3': buylink= "clean-classy-corporate-wp-theme";
            break;
            case 'webstudio': buylink= "web-studio";
            break;
            case 'envision': buylink= "envison";
            break;
            case 'freshfolio': buylink= "freshfolio";
            break;
            case 'welcomeinn': buylink= "welcome-inn";
            break;
            case 'welcome-inn': buylink= "welcome-inn";
            break;
            case 'lifestyle': buylink= "lifestyle";
            break;
            case 'qlassik': buylink= "qlassik";
            break;
            case 'mobility-app': buylink= "mobilityapp";
            break;
            case 'brandcrafters': buylink= "brand-crafters";
            break;
            case 'writer': buylink= "writer";
            break;
            case 'medica': buylink= "medica";
            break;
            case 'sportedge': buylink= "sportedge";
            break;
            case 'videogrid': buylink= "videogrid";
            break;
            case 'photo-artist': buylink = "photo-artist";
            break;
            case 'coffee-lounge': buylink = "coffee-lounge-wordpress-theme";
            break;
            case 'cloudhost': buylink = "cloudhost-wordpress-theme";
            break;
            case 'the-practice': buylink = "lawyer-wordpress-theme";
            break;
            case 'homequest': buylink = "real-estate-wordpress-theme";
            break;
            case 'just-married': buylink = "wedding-wordpress-theme";
            break;
            case 'newssetter': buylink = "news-wordpress-theme";
            break;
            case 'gadgetry': buylink = "free-wordpress-theme";
            break;
            case 'my-journey': buylink = "blog-wordpress-theme";
            break;
			case 'voyage': buylink = "travel-wordpress-theme";
            break;			
			case 'pixelwhiz': buylink = "designer-wordpress-theme";
            break;
			case 'interakt': buylink = "agency-wordpress-theme";
            break;
			case 'conexus': buylink = "responsive-wordpress-theme";
            break;
			case 'the-muse': buylink = "inspiration-wordpress-theme";
            break;
			case 'metrovibes': buylink = "metro-wordpress-theme";
            break;
			case 'kiddoturf': buylink = "kids-wordpress-theme";
            break;
			case 'autotrader': buylink = "auto-wordpress-theme";
            break;
			case 'evangelist': buylink = "church-wordpress-theme";
            break;
			case 'collective': buylink = "professional-wordpress-theme";
            break;
			case 'beatheaven': buylink = "music-wordpress-theme";
            break;
            case 'freelancer': buylink = "one-page-wordpress-theme";
            break;
			case 'paradise-cove': buylink = "wordpress-hotel-theme";
            break;
			case 'tapptastic': buylink = "app-wordpress-theme";
            break;
            default:
                buylink = "photo-artist";
	}
	
	if(selected_theme!='gadgetry') jQuery(".tfuse-top-sliding-panel-link-buy").attr("href","http://themefuse.com/wp-themes-shop/"+buylink+"/buy/?ribbon=bybutton");
	
	//if(selected_theme!='my-journey' && selected_theme!='gadgetry') jQuery(".tfuse-top-sliding-panel-link-buy").attr("href","http://themefuse.com/wp-themes-shop/"+buylink+"/buy/?ribbon=bybutton");
	//if(selected_theme=='my-journey') jQuery(".tfuse-top-sliding-panel-link-buy").attr("href","http://themeforest.net/item/my-journey-wp-personal-blog-/145070/");
	
	if(selected_theme=='gadgetry') jQuery(".tfuse-top-sliding-panel-link-buy").attr("href","http://themefuse.com/wp-themes-shop/free-wordpress-theme/");
	if(selected_theme=='gadgetry') { jQuery(".tfuse-top-sliding-panel-buyBox").hide(); jQuery(".tfdownloadtheme").show(); }

	// select theme
	jQuery(".tfuse-top-sliding-panel-dropdown dd ul li a").click(function()
	{
		var dropID = jQuery(this).closest("dl").attr("id");
		var html = jQuery(this).html();
		//var rel = jQuery(this).attr("rel");
		//if(rel) document.cookie = "tfusetoppanelshowtheme="+rel+"; path=/"; //store in coockie selected theme name
		jQuery("#"+dropID+" dt a span").html(html);
		jQuery("#"+dropID+" dd ul").hide();
		jQuery("#"+dropID+" dd ul li a").removeClass("active");
		jQuery(this).addClass("active");   
		//return false;
	});

	var tfuse_link = window.location.href;
	tfuse_link = "http://www.stumbleupon.com/submit?url="+tfuse_link+"&title=Original WP Themes and CMS WordPress Templates by ThemeFuse";
	jQuery(".tfsbLink").attr("href",tfuse_link);
});

jQuery(document).ready(function($){

    var value = tf_script.TF_THEME_PREFIX + '_responsive_width';
    if(getCookie(value)=='480'){
        jQuery('.tablet').addClass('selected_tablet');
        jQuery('#phone_responsive').removeClass('selected_phone');
        jQuery('.desktop').removeClass('selected_desktop');
    }else if(getCookie(value)=='450' || getCookie(value)=='320'){
        jQuery('.desktop').removeClass('selected_desktop');
        jQuery('.tablet').removeClass('selected_tablet');
        jQuery('#phone_responsive').addClass('selected_phone');
    }else{
        jQuery('.tablet').removeClass('selected_tablet');
        jQuery('#phone_responsive').removeClass('selected_phone');
        jQuery('.desktop').addClass('selected_desktop');
    }

    jQuery('#tftsp_currentTheme').bind('click',function() {
        jQuery('.tfuse-top-sliding-panel-changeTheme').toggleClass('open');
    });
    
    jQuery(document).bind('click', function(x) {
        var $clicked = $(x.target);
        if (!$clicked.hasClass('themeSelect') && !$clicked.parent().hasClass('themeSelect') )
            jQuery('.tfuse-top-sliding-panel-changeTheme').removeClass('open');
    });
          
    // BeautyTips
    jQuery('.tfuse-top-sliding-panel-listThemes li').bt({
        contentSelector: "$(this).find('.tfuse-top-sliding-panel-tip img')",
        padding: '5px', 
        fill: '#000', 
        width: '251px',
        spikeLength: 5,
        height: '150px',
        cornerRadius: 4
    });
                
});