<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%-- <%@page import = "com.FernandezProject.models.*" %> --%>
<%@page import="java.util.*"%>

<%
String usuarioIncorrecto = "false";
if(request.getAttribute("usuarioIncorrecto") != null)
	usuarioIncorrecto = request.getAttribute("usuarioIncorrecto").toString();
%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fernandez Market</title>


<link rel="stylesheet" href="Bootstrap/css/bootstrap.min.css" crossorigin = "anonymous">
<link rel="stylesheet" href="css/introjs.css">
<link rel="stylesheet" href="css/generalStyles.css">
<link rel="stylesheet" href="css/Autocomplete/jquery-ui.css">
<link rel="stylesheet" href="css/Autocomplete/jquery-ui.structure.css">
<link rel="stylesheet" href="css/Autocomplete/jquery-ui.theme.css">

<link rel="stylesheet" href="css/singUp&LoginStyles.css">
<link rel="stylesheet" href="css/widthme.css">




</script>
</head>

<body class="main-registro">
	<header  data-position="bottom"
	data-intro="Página de login: Aquí se ingresará el correo y contraseña del usuario para iniciar sesión">
		<!-- 			<div id="basicNavbarPage"></div> -->
<%-- 		<jsp:include page="v_basicNavbar.jsp"></jsp:include> --%>
		<jsp:include page="v_navbar.jsp"></jsp:include>
	</header>
	
	<section>
<!--         <div id = "v_subnavbar"></div> -->
        <jsp:include page="v_subnavbar.jsp"></jsp:include>
        
    </section>

	<main>
		<div class="container-fluid p-0">
			<div class="row gx-0 mt-5">
				<div  data-position="bottom"
				data-intro="Deben ser llenados los campos de correo y contraseña correctamente, de lo contrario no se podrá iniciar sesión"
				class="col-11 ps-3 pe-3 pt-3 pb-4 mx-auto col-md-5 col-lg-4 ps-lg-3 pe-lg-3 col-xl-3  formulario-registro">
					<div class="row  linea-bottom">
						<div class="col-12 mx-auto mb-2">
							<h2>Inicia sesión</h2>
						</div>
					</div>

					<form id="form_main-container" method="post" action="LoginUsuario" class = "form_main-container">
						<div class="row mt-2">

							<div class="col-12">
								<div class="row">
									<div class="col-12 mx-auto">
										<label for="email">Email:</label>
									</div>

									<div class="col-12 mt-1 mx-auto">
										<input class="form-control input-text-style w-100"
											type="email" name="email" required>
									</div>



									<div class="col-12 mt-4 mx-auto">
										<label for="password">Contraseña:</label>
									</div>

									<div class="col-12 mt-1 mx-auto">
										<input  id="pass_form" class="form-control input-text-style w-100"
											type="password" name="password" required>
									</div>

									<div class="col-12 mt-4 mx-auto">
										<p data-position="bottom"
										data-intro="Si la persona no tiene una cuenta puede crear una dando click en el texto remarcado"
										class="texto-sm-normal texto-md-normal">
											¿Aún no tienes cuenta? <a class="link" href="signUp.jsp"> ¡Crea
												una ahora mismo! </a>
										</p>
									</div>
								</div>
							</div>


						</div>
						<input id="usuarioIncorrecto" type="hidden" name="usuarioIncorrecto" value="<%=usuarioIncorrecto%>">
					</form>

					<div  data-position="bottom"
					data-intro="Una vez se hayan llenado los campos correspondientes, se dará click a este botón para iniciar sesión en la página"
					class="row mt-2 justify-content-center">
						<div class="col-8">
							<button id="button_main-container" form="form_main-container"
								class="button-ok w-100 py-2">Iniciar sesion</button>
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
</body>

	<script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous">
	<script src = "Bootstrap/js/popper.min.js"></script>
	<script src = "Bootstrap/js/bootstrap.min.js"></script>
	<script src="js/jquery.js"></script>
	<script src ="js/jquery.validate.min.js"></script>
	<script src="js/intro.js"></script>
    <script src="js/jquery-ui.js"></script>

	
	<script src="js/mainjquery.js"></script>
	<script src="js/autocomplete.js"></script>
	
</html>