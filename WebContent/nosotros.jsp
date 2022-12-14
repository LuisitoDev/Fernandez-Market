<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=<device-width>, initial-scale=1.0">
    <title>Fernandez Market</title>

    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/owlcarousel/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owlcarousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/introjs.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.structure.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.theme.css">

    <link rel="stylesheet" href="css/generalStyles.css">
    <link rel="stylesheet" href="css/widthme.css">
    <link rel="stylesheet" href="css/nosotros&sucursal.css">


    

</head>

<body class="page">

    <header data-position="bottom"
        data-intro="Página de Nosotros: En esta página se muestra toda la información relacionada de la tienda Fernandez Market."
        class="sticky-top"  style="z-index: 10000000">
<!--         <div id="navbarPage" class="navbar-complete"></div> -->
        <jsp:include page="v_navbar.jsp"></jsp:include>
    </header>

	<section>
<!--         <div id = "v_subnavbar"></div> -->
        <jsp:include page="v_subnavbar.jsp"></jsp:include>
    </section>

    <main>
        <div class="container-fluid p-0">
            <div class="row gx-0 my-4 nos_suc-barra-titulo-fondo">
                <div class="col-11 mt-2 mx-auto pb-2">

                    <a href="IndexPagina" class="nos_suc-barra-titulo-enlace">Inicio</a>
                    <i class="fas fa-angle-right nos_suc-barra-titulo"></i>
                    <h1 class="nos_suc-barra-titulo">Nosotros</h1>
                </div>
            </div>


            <div class="row gx-0 linea-top linea-bottom">
                <div class="nos_suc-contenedor col-12 mx-auto my-4 col-md-11 col-lg-9">
                    <div class="row gx-0">
                        <div class="col-11 col-sm-10 mx-auto mb-4">

                            <div class="row gx-0 linea-bottom">
                                <div class="col-12 mt-3 mb-2 mx-auto">
                                    <h1 class="nos_suc-titulo">FERNANDEZ MARKET 2019-2022</h1>
                                </div>
                            </div>

                            <div class="row gx-0">
                                <div class="col-12 mt-3 pb-2 mx-auto col-md-6 pe-md-3 mb-2 linea-bottom">
                                    <h2 class="nos_suc-subtitulos">Misión <i class="fas fa-chart-line"></i></h2>
                                    <p class="nos_suc-parrafos">Proveer un amplio surtido para el hogar, tienda o
                                        negocio de nuestros clientes
                                        poniendo a su disposición una extensa variedad de productos con precios bajos
                                        y un excelente servicio.</p>
                                </div>

                                <div class="col-12 mt-3 pb-2 mx-auto col-md-6 ps-md-3 mb-2 linea-bottom">
                                    <h2 class="nos_suc-subtitulos">Visión <i class="fas fa-eye"></i></h2>
                                    <p class="nos_suc-parrafos">Ser una empresa líder en México, reconocida por su
                                        excelente trato al cliente,
                                        amplio surtido y precios bajos.</p>

                                </div>

                                <div class="col-12 mt-3 mx-auto col-md-6 pe-md-3 mb-2 linea-bottom">
                                    <h2 class="nos_suc-subtitulos">Valores <i class="fas fa-user-friends"></i></h2>

                                    <ul style="list-style-type:none;  margin: 0px; padding: 10px; ">
                                        <li>
                                            <strong class="nos_suc-parrafos">Trabajo en equipo: </strong>
                                            <p class="nos_suc-parrafos">Buscar siempre el apoyo colectivo.</p>
                                        </li>
                                        <li>
                                            <strong class="nos_suc-parrafos">Responsabilidad: </strong>
                                            <p class="nos_suc-parrafos">Cuidar nuestro entorno social y de trabajo.</p>
                                        </li>
                                        <li>
                                            <strong class="nos_suc-parrafos">Honestidad: </strong>
                                            <p class="nos_suc-parrafos">Ser transparentes.</p>
                                        </li>
                                        <li>
                                            <strong class="nos_suc-parrafos">Calidad: </strong>
                                            <p class="nos_suc-parrafos">Buscar siempre hacer las cosas de la mejor
                                                manera posible.</p>
                                        </li>
                                        <li>
                                            <strong class="nos_suc-parrafos">Trabajo en equipo: </strong>
                                            <p class="nos_suc-parrafos">Buscar siempre el apoyo colectivo.</p>
                                        </li>
                                        <li>
                                            <strong class="nos_suc-parrafos">Alegría: </strong>
                                            <p class="nos_suc-parrafos">Buen ambiente de trabajo y llevar siempre una
                                                sonrisa.</p>
                                        </li>
                                    </ul>

                                </div>
                                <div class="col-12 py-4 mb-2 mx-auto col-md-6 px-3 linea-bottom" align = "center">
                                    <div class="nos_suc-imagen-div">
                                        <img src="img/Nosotros.png" class="card-img-top w-100 nos_suc-imagen"
                                            alt="...">
                                    </div>
									<form action = "sucursales.jsp" method = "get">
                                    	<button id="button_main-container" form="form_main-container"
                                    	class="mt-4 button-ok py-2">Ver sucursales</button>
									</form>
                                </div>

                                <div class="col-12 px-3 py-4 mb-2 mx-auto col-md-6 linea-bottom">
                                    <h2 class="nos_suc-subtitulos">Contacto <i class="fas fa-envelope-open"></i></h2>
                                    <a class="nos_suc-parrafos" style = "display: block;" href="mailto:ventas@fernandezmarket.com" >Ventas: ventas@fernandezmarket.com</a>
                                    <a class="nos_suc-parrafos" style = "display: block;" href="mailto:aracelypc@fernandezmarket.com" >Contacto: aracelypc@fernandezmarket.com</a>
                                    <a class="nos_suc-parrafos" style = "display: block;" href="mailto:urodriguez@fernandezmarket.com" >Trabajo: urodriguez@fernandezmarket.com</a>
                                </div>

                                <div class="col-12 px-3 py-4 mb-2 mx-auto col-md-6 linea-bottom">
                                    <h2 class="nos_suc-subtitulos">Telefono <i class="fas fa-phone-square"></i></h2>
                                    <a class="nos_suc-parrafos" style = "display: block;" href="tel:8183519037">81-8351-9037</a>
                                    <a class="nos_suc-parrafos" style = "display: block;" href="tel:81-1292-9300">81-1292-9300</a>
                                    <a class="nos_suc-parrafos" style = "display: block;" href="tel:81-1425-1200">81-1425-1200</a>
                                </div>

                               
                            </div>

                        </div>
                    </div>
                </div>
            </div>


        </div>
    </main>

    
        <!-- FOOTER -->
    <footer>
<!--         <div id="footerPage"></div> -->
        <jsp:include page="v_footer.jsp"></jsp:include>
    </footer>
</body>

    <script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
    
    <script src="Bootstrap/js/popper.min.js"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/owlcarousel/owl.carousel.min.js"></script>
    <script src="js/intro.js"></script>
    <script src="js/jquery-ui.js"></script>

    <script src="js/mainjquery.js"></script>
    <script src="js/autocomplete.js"></script>
</html>