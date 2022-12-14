<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>


<%
Usuarios_Model usuarioElegido = (Usuarios_Model)request.getAttribute("usuarioElegido");
pageContext.setAttribute("usuarioElegido", usuarioElegido);

List<Pedidos_Model> listaPedidos = (List<Pedidos_Model>) request.getAttribute("listaPedidos");
pageContext.setAttribute("listaPedidos", listaPedidos);


%>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<link rel="stylesheet" href="css/editUser.css">
<link rel="stylesheet" href="css/profileUser.css">
<link rel="stylesheet" href="css/shoppingCart.css">



</head>

<body class="page">
	<header  data-position="bottom"
    data-intro="Página de perfil: En esta página se podrá ver información del usuario y sus pedidos"
    class = "sticky-top" style="z-index: 10000000">
		<!--             <div id="navbarPage" class="navbar-complete"></div> -->
		<jsp:include page="v_navbar.jsp"></jsp:include>
	</header>

    <section>
<!--         <div id = "v_subnavbar"></div> -->
        <jsp:include page="v_subnavbar.jsp"></jsp:include>
    </section>

	<main>
		<div class="container-fluid p-0">
			<div   data-position="bottom" 
            data-intro="Barra de título de la página, aquí te mostrará en que página te encuentras y navegar entre cada apartado más fácil" 
            class="row gx-0 my-4 profileUser-barra-titulo-fondo">
				<div class="col-11 mt-2 mx-auto pb-2">
					<a href="IndexPagina" class="profileUser-barra-titulo-enlace">Inicio</a> <i
						class="fas fa-angle-right profileUser-barra-titulo"></i>
					<h1 class="profileUser-barra-titulo">Perfil de Usuario</h1>
				</div>
			</div>


			<div class="row gx-0">
				<div class="col-12"></div>
			</div>
			<div class="row gx-0 pt-4 pb-4 mt-2 linea-top justify-content-evenly">
				<div class="col-11 col-sm-9 col-md-8 col-lg-4 col-xl-3">

					<div class="profileUser-formulario-registro row gx-0 ">
						<div  data-position="bottom"
                        data-intro="En este apartado se muestra la información del usuario, su nombre completo y el email registrado"
						class="col-12 mx-auto px-3 pb-4">


							<div class="row gx-0 linea-bottom">
								<div class="col-12 mx-auto my-2">
									<h2 class="profileUser-titulo-vista">Perfil</h2>
								</div>
							</div>

							<div class="row gx-0">
								<div class="col-12 mt-3 mx-auto">
									<label for="name">Nombre completo:</label>
								</div>

								<div class="col-12 mt-1 mx-auto">
									<!-- input-type-style -->
									<input class="form-control input-text-style w-100" type="text"
										name="name" value = "${usuarioElegido.getNombreCompletoUsuario()}" readonly>
								</div>

								<div class="col-12 mt-4 mx-auto">
									<label for="email">Email:</label>
								</div>

								<div class="col-12 mt-1 mx-auto">
									<input class="form-control input-text-style w-100" type="email"
										name="email"  value = "${usuarioElegido.getCorreoUsuario()}" readonly>
								</div>




								<div  data-position="bottom"
                                data-intro="Si se desea actualizar la información del usuario se puede dar click al botón 'Editar perfil'"
								class="row mt-4 justify-content-center">
									<div class="col-8 col-md-4 col-lg-7">
										<button id="button_main-container" form="form_main-container"
											class="w-100 button-ok py-2"><a href = "EditarPerfilUsuario" style = "color: rgb(250,250,250);">Editar perfil</a></button>
									</div>
								</div>

							</div>
						</div>
					</div>

				</div>

				<div class="col-11 mt-4 col-sm-9 col-md-8 col-lg-6 mt-lg-0 col-xl-7">
					<div class="row gx-0">
						<div  data-position="bottom"
                        data-intro="En este apartado se visualizarán todos los pedidos que el usuario ha realizado, junto a la información principal. Si se desea saber más detalles del pedido se puede dar click a cada uno y se desplegarán los detalles de este"
						class="col-12 px-3 pb-4 profileUser-formulario-registro">
							<div class="row gx-0 linea-bottom">
								<div class="col-12 mx-auto my-2">
									<h2 class="profileUser-titulo-vista">Mis pedidos</h2>
								</div>
							</div>
							
							<c:forEach var="iPedido" items="${listaPedidos}">
								<c:set var="iPedido" value="${iPedido}" scope="request"/>
								<jsp:include page="v_cardPedido.jsp"></jsp:include>
							</c:forEach>
							
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

	<!-- FOOTER -->
	<footer>
<!-- 		<div id="basicFooterPage"></div> -->
		<jsp:include page="v_basicFooter.jsp"></jsp:include>
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