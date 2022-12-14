<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import = "com.FernandezMarketProject.models.*" %>
<%@page import = "java.util.*" %>


<%
String error = request.getAttribute("error").toString();
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fernandez Market</title>

    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" crossorigin="anonymous">
    <link rel="stylesheet" href="css/introjs.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.structure.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.theme.css">
    
    <link rel="stylesheet" href="css/generalStyles.css">
    <link rel="stylesheet" href="css/error.css">
    <link rel="stylesheet" href="css/widthme.css">
</head>

<body class="main-registro">

    <header data-position="bottom"
        data-intro="Página de error: Si al momento de navegar hubo un error en la página, aquí se reflejara cuál fue ese error.">
        <!-- <div id="basicNavbarPage"></div> -->
<!--         <div id="navbarPage"></div> -->
        <jsp:include page="v_navbar.jsp"></jsp:include>
    </header>

    <section>
        <div id="v_subnavbar"></div>
    </section>

    <main>
        <div class="container-fluid p-0 ">
            <div class="error-contenedor">

                <div class="row gx-0 justify-content-center">
                    <div class="col-11">
                        <div class="row gx-0 justify-content-center">
                            <div class="col-3 pe-2 my-auto col-lg-4 " align = "end">
                                <span class="error-Icono"><i class="far fa-frown"></i></span>
                            </div>
        
                            <div class="col-9 my-auto col-lg-8 " align = "begin">
                                <h1 class="error-Titulo ">¡Parece que hubo un error!</h1>
                            </div>
                        </div>
                    </div>
                    

                </div>
                <div class="row gx-0 justify-content-center">
                    <div class="col-11" align="center">
                        <p class="error-Subtitulo">Sera mejor regresar...</p>
                    </div>
                </div>

                <div class="row gx-0 justify-content-center">
                    <div class="col-11" align="center">
                        <p class="error-Descripcion">Tipo de error: ${error}</p>
                    </div>
                </div>
            </div>

        </div>
    </main>

    <!-- FOOTER -->
    <footer>
<!--         <div id="basicFooterPage"></div> -->
        <jsp:include page="v_basicFooter.jsp"></jsp:include>
    </footer>
</body>
    <script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
    <script src="Bootstrap/js/popper.min.js"></script>
    <script src="Bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
    <script src="js/intro.js"></script>
    <script src="js/jquery-ui.js"></script>
    
    <script src="js/mainjquery.js"></script>
    <script src="js/autocomplete.js"></script>
</html>