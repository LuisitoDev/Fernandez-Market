<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String emailEncontrado = "false";
if(request.getAttribute("emailEncontrado") != null)
	emailEncontrado = request.getAttribute("emailEncontrado").toString();
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
<link rel="stylesheet" href="css/singUp&LoginStyles.css">
<link rel="stylesheet" href="css/widthme.css">

</head>

<body class="main-registro">
    <header  data-position="bottom"
        data-intro="Página de registro: Aquí la persona podra llenar su información y crear un usuario para iniciar sesión en la página">
		            <%-- <div id="basicNavbarPage"></div> --%>
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
                    data-intro="En este apartado el usuario ingresará su información en cada campo siguiendo ciertas restricciones que se presenaran a continuacion. Los campos con un '*' rojo son obligatorios"
                    class="col-11 ps-3 pe-3 pt-3 pb-4 mx-auto col-lg-8 ps-lg-5 pe-lg-5 col-xl-6  formulario-registro">
					<div class="row  linea-bottom">
						<div class="col-12 mx-auto mx-md-3 mb-2">
							<h2>Crea tu cuenta</h2>
						</div>
					</div>

					<form id="form_main-container" class = "form_main-container" method="post" action="SignUpUsuarios">
						<div class="row mt-2 ">
							<div class="col-12 mt-2 col-md-6 linea-md-right">
								<div class="row">
									<div data-position="left"
                                        data-intro="El(Los) nombre(s) y apellidos solo deben llevar letras y espacios">
										<div class="col-12 mx-auto col-md-11">
											<label for="nombre" required>Nombres:</label>
										</div>

										<div class="col-12 mt-1 mx-auto col-md-11">
											<input class="form-control input-text-style w-100" type="text"
												name="nombre" required>
										</div>



										<div class="col-12 mt-4 mx-auto col-md-11">
											<label for="apellidoP" required>Apellido Paterno:</label>
										</div>

										<div class="col-12 mt-1 mx-auto col-md-11">
											<input class="form-control input-text-style w-100" type="text"
												name="apellidoP" required>
										</div>



										<div class="col-12 mt-4 mx-auto col-md-11">
											<label for="apellidoM">Apellido Materno:</label>
										</div>

										<div class="col-12 mt-1 mx-auto col-md-11">
											<input class="form-control input-text-style w-100" type="text"
												name="apellidoM">
										</div>
									</div>
								</div>
							</div>



							<div class="col-12 mt-4 col-md-6 mt-md-2">
								<div class="row">
									<div  data-position="bottom"
                                        data-intro="El email debe llevar el formato correcto: Ejemplo 'usuario@hotmail.com'">
										<div class="col-12 mx-auto  col-md-11">
											<label for="email" required>Email:</label>
										</div>

										<div class="col-12 mt-1 mx-auto col-md-11">
											<input id="email" class="form-control input-text-style w-100"
												type="email" name="email" required>
										</div>
									</div>



									<div  data-position="right"
                                        data-intro="La contraseña debe terner al menos 7 caracteres, la confirmación debe coincidir con la contraseña ingresada">

										<div class="col-12 mt-4 mx-auto col-md-11">
											<label for="password" required>Contraseña:</label>
										</div>

										<div class="col-12 mt-1 mx-auto col-md-11">
											<input id="password" class="form-control input-text-style w-100"
												type="password" name="password" required>
										</div>



										<div class="col-12 mt-4 mx-auto col-md-11">
											<label for="passconfirm" required>Confirmar
												contraseña:</label>
										</div>

										<div class="col-12 mt-1 mx-auto col-md-11">
											<input id="passconfirm" class="form-control input-text-style w-100"
												type="password" name="passconfirm" required>
										</div>
									
									</div>
								</div>
							</div>


						</div>

						<input id="emailEncontrado" type="hidden" name="emailEncontrado" value="<%=emailEncontrado%>">

					</form>

					<div class="row mt-4 justify-content-center">
                        <div  data-position="bottom"
                        data-intro="Una vez se haya llenado toda la información, se dara click en este botón y se creará una cuenta para el usuario"
						class="col-8 col-md-4 ">
							<button id="button-signup_main-container" form="form_main-container"
								class="w-100 button-ok py-2">Registrarme</button>
						</div>
					</div>
				</div>

			</div>
		</div>
	</main>

	<footer>
		<!--             <div id="basicFooterPage"></div> -->
		<jsp:include page="v_basicFooter.jsp"></jsp:include>
	</footer>
</body>

<script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
<script src="Bootstrap/js/popper.min.js"></script>
<script src="Bootstrap/js/bootstrap.min.js"></script>

<script src="js/jquery.js"></script>
<script src="js/intro.js"></script>
<script src="js/jquery-ui.js"></script>
<script src ="js/jquery.validate.min.js"></script>

<script src="js/mainjquery.js"></script>
<script src="js/autocomplete.js"></script>

</html>