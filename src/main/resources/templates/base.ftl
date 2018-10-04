<#import "/spring.ftl" as spring />

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title>${title}</title>

    <!--

    Sentra Template

    http://www.templatemo.com/tm-518-sentra

    -->
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.png">

    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/bootstrap-theme.min.css">
    <link rel="stylesheet" href="/css/fontAwesome.css">
    <link rel="stylesheet" href="/css/light-box.css">
    <link rel="stylesheet" href="/css/owl-carousel.css">
    <link rel="stylesheet" href="/css/templatemo-style.css">
    <link rel="stylesheet" href="/css/detalles.css">

    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800" rel="stylesheet">

    <script src="/js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>

<body>



<header class="nav-down responsive-nav hidden-lg hidden-md">
    <button type="button" id="nav-toggle" class="navbar-toggle" data-toggle="collapse" data-target="#main-nav">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <!--/.navbar-header-->
    <div id="main-nav" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li><a href="/">Inicio</a></li>
                <li><a href="/client/">Clientes</a></li>
                <li><a href="/equipo/">Equipos</a></li>
                <li><a href="/alquiler/">Alquiler</a></li>
                <li><a href="#blog">Historial</a></li>
                <li><a href="#contact">Contact Us</a></li>
            </ul>
    </div>
</header>

<div class="sidebar-navigation hidde-sm hidden-xs">
    <div class="logo">
        <a href="/">Tarea #10</a>
    </div>
    <div class="menu-letra">
        <ul>
            <li>
                <a href="/" class="letra-color">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    Inicio
                </a>
            </li>
            <li>
                <a href="/client/" class="letra-color">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    Clientes
                </a>
            </li>
            <li>
                <a href="/equipo/" class="letra-color">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    Equipos
                </a>
            </li>
            <li>
                <a href="/alquiler/" class="letra-color">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    Alquiler
                </a>
            </li>
            <li>
                <a href="#blog">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    Historial
                </a>
            </li>
            <li>
                <a href="#contact">
                    <span class="rect"></span>
                    <span class="circle"></span>
                    Contact Us
                </a>
            </li>
        </ul>
    </div>
    <ul class="social-icons">
        <li><a href="#"><i class="fa fa-facebook"></i></a></li>
        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
        <li><a href="#"><i class="fa fa-rss"></i></a></li>
        <li><a href="#"><i class="fa fa-behance"></i></a></li>
    </ul>
</div>


<div class="page-content">
    <@page_body/>
    <section class="footer">
        <p>Copyright &copy; 2018. Design: <a href="http://templatemo.com/tm-518-sentra" target="_blank">Sentra</a> | Distribution: <a href="https://themewagon.com" target="_blank">ThemeWagon</a></p>
    </section>
</div>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script>window.jQuery || document.write('<script src="/js/vendor/jquery-1.11.2.min.js"><\/script>')</script>

<script src="/js/vendor/bootstrap.min.js"></script>

<script src="/js/plugins.js"></script>
<script src="/js/main.js"></script>

<script>
    // Hide Header on on scroll down
    var didScroll;
    var lastScrollTop = 0;
    var delta = 5;
    var navbarHeight = $('header').outerHeight();

    $(window).scroll(function(event){
        didScroll = true;
    });

    setInterval(function() {
        if (didScroll) {
            hasScrolled();
            didScroll = false;
        }
    }, 250);

    function hasScrolled() {
        var st = $(this).scrollTop();

        // Make sure they scroll more than delta
        if(Math.abs(lastScrollTop - st) <= delta)
            return;

        // If they scrolled down and are past the navbar, add class .nav-up.
        // This is necessary so you never see what is "behind" the navbar.
        if (st > lastScrollTop && st > navbarHeight){
            // Scroll Down
            $('header').removeClass('nav-down').addClass('nav-up');
        } else {
            // Scroll Up
            if(st + $(window).height() < $(document).height()) {
                $('header').removeClass('nav-up').addClass('nav-down');
            }
        }

        lastScrollTop = st;
    }
</script>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js" type="text/javascript"></script>

</body>
</html>