<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>


<%
Usuarios_Model usuarioElegido = (Usuarios_Model) request.getAttribute("usuarioElegido");
pageContext.setAttribute("usuarioElegido", usuarioElegido);
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fernandez Market</title>

    <link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" crossorigin = "anonymous">
    <link rel="stylesheet" href="css/owlcarousel/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owlcarousel/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/introjs.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.structure.css">
    <link rel="stylesheet" href="css/Autocomplete/jquery-ui.theme.css">


    <link rel="stylesheet" href="css/generalStyles.css">
    <link rel="stylesheet" href="css/widthme.css">
    <link rel="stylesheet" href="css/editUser.css">


    

</head>

<body>

    <header  data-position="bottom"
        data-intro="Página de editar perfil: Esta página es similar a la página de registrarse, aquí se podra editar el perfil de cada usuario"
        class="sticky-top" style="z-index: 10000000">
<!--             <div id="navbarPage" class="navbar-complete"></div> -->
			<jsp:include page="v_navbar.jsp"></jsp:include>
    </header>
    
    <section>
<!--         <div id = "ventanaDisplayPhone"></div> -->
        <jsp:include page="v_subnavbar.jsp"></jsp:include>
    </section>
    

    <main>
        <div class="container-fluid p-0">

            <div class="row gx-0 mt-4">
                 <div  data-position="bottom"
                    data-intro="Aquí se actualizará la información de cada apartado siguiendo las mismas restricciones que en la página de registro. Los campos con un '*' rojo son obligatorios"
                    class="col-11 ps-3 pe-3 pt-3 pb-4 mx-auto col-lg-8 ps-lg-5 pe-lg-5 col-xl-6  formulario-registro">
                    <div class="row  linea-bottom">
                        <div class="col-12 mx-auto mx-md-3 mb-2">
                            <h2>Editar perfil</h2>
                        </div>
                    </div>

                    <form id="form_main-container" class = "form_main-container" method = "post" action = "EditarPerfilUsuario" >
                        <div class="row mt-2 ">
                            <div class="col-12 mt-2 col-md-6 linea-md-right">
                                <div class="row">
                                    <div class="col-12 mx-auto col-md-11">
                                        <label for="nombre" required>Nombres:</label>
                                    </div>

                                    <div class="col-12 mt-1 mx-auto col-md-11">
                                    	<input class="form-control input-text-style w-100" type="text"
											name="nombre" value = "${usuarioElegido.getNombreUsuario()}" required>
                                    </div>



                                    <div class="col-12 mt-4 mx-auto col-md-11">
                                        <label for="apellidoP" required>Apellido Paterno:</label>
                                    </div>

                                    <div class="col-12 mt-1 mx-auto col-md-11">
                                    	<input class="form-control input-text-style w-100" type="text"
											name="apellidoP" value = "${usuarioElegido.getApellidoPaternoUsuario()}" required>
                                    </div>



                                    <div class="col-12 mt-4 mx-auto col-md-11">
                                        <label for="apellidoM">Apellido Materno:</label>
                                    </div>

                                    <div class="col-12 mt-1 mx-auto col-md-11">
                                    	<input class="form-control input-text-style w-100" type="text"
											name="apellidoM" value = "${usuarioElegido.getApellidoMaternoUsuario()}">
                                    </div>
                                </div>
                            </div>



                            <div class="col-12 mt-4 col-md-6 mt-md-2">
                                <div class="row">
                                <div  data-position="bottom"
                                        data-intro="Como el usuario ya se encuentra registrado, el correo no se editará, por lo que se quedará igual">
                                        <div class="col-12 mx-auto  col-md-11">
                                            <label for="email">Email:</label>
                                        </div>

                                        <div class="col-12 mt-1 mx-auto col-md-11">
                                        	<input id="email" class="form-control input-text-style w-100"
					    						type="email" name="email" value = "${usuarioElegido.getCorreoUsuario()}" readonly>
                                        </div>
                                </div>


                                    <div class="col-12 mt-4 mx-auto col-md-11">
                                        <label for="password" required>Contraseña:</label>
                                    </div>

                                    <div class="col-12 mt-1 mx-auto col-md-11">
                                    	<input id="password" class="form-control input-text-style w-100"
											type="password" name="password" required>
                                    </div>



                                    <div class="col-12 mt-4 mx-auto col-md-11">
                                        <label for="passconfirm" required>Confirmar contraseña:</label>
                                    </div>

                                    <div class="col-12 mt-1 mx-auto col-md-11">
                                    	<input id="passconfirm" class="form-control input-text-style w-100"
											type="password" name="passconfirm" required>
                                    </div>
                                </div>
                            </div>


                        </div>
                    </form>

                    <div class="row mt-4 justify-content-center">
                         <div  data-position="bottom"
                        data-intro="Una vez se haya llenado toda la información, se dara click en este botón y todos los cambios serán correctamente actualizados"
                        class="col-8 col-md-4 ">
                        	<button id="button-edit_main-container" form="form_main-container"
								class="w-100 button-ok py-2">Editar perfil</button>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </main>

    <!-- FOOTER -->
    <footer>
<!--             <div id="basicFooterPage"></div> -->
			<jsp:include page="v_basicFooter.jsp"></jsp:include>
    </footer>
    </div>
</body>
    <script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
    <script src = "Bootstrap/js/popper.min.js"></script>
    <script src = "Bootstrap/js/bootstrap.min.js"></script>
    <script src="js/jquery.js"></script>
	<script src ="js/jquery.validate.min.js"></script>
    <script src="js/owlcarousel/owl.carousel.min.js"></script>    
    <script src="js/intro.js"></script>
    <script src="js/jquery-ui.js"></script>

    <script src="js/mainjquery.js"></script>
    <script src="js/autocomplete.js"></script>
</html>