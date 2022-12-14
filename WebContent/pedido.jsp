<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.FernandezMarketProject.controllers.GeneralServlet"%>
<%@page import="java.math.BigDecimal"%>

<%
Pedidos_Model pedidoElegido = (Pedidos_Model) request.getAttribute("pedidoElegido");
pageContext.setAttribute("pedidoElegido", pedidoElegido);

%>



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
<link rel="stylesheet" href="css/pedido.css">



</head>

<body class="page">
	<header  data-position="bottom"
    data-intro="Página de pedido: Aquí se llenarán unos datos necesarios para realizar el pedido y finalizar la compra"
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
			 <div data-position="bottom" 
            data-intro="Barra de título de la página: Aquí te mostrará en que página te encuentras y navegar entre cada apartado más fácil" 
            class="row gx-0 my-4 pedido-barra-titulo-fondo">
				<div class="col-11 mt-2 mx-auto pb-2">

					<a href="IndexPagina" class="pedido-barra-titulo-enlace">Inicio</a>
					<i class="fas fa-angle-right pedido-barra-titulo"></i> <a
						href="CarritoProductos" class="pedido-barra-titulo-enlace">Carrito
						de compra</a> <i class="fas fa-angle-right pedido-barra-titulo"></i>
					<h1 class="pedido-barra-titulo">Pedido</h1>
				</div>
			</div>


			<div class="row gx-0 linea-top linea-bottom">
				<div  data-position="bottom"
                data-intro="En este apartado se escribira en cada campo la información correspondiente, dentro de cada campo viene un ejemplo de como ira la información"
                class="pedido-contenedor col-11 mx-auto my-4 col-sm-11 col-lg-10 col-xl-7">
					<div class="row gx-0 mt-3">
						<div class="col-11 mx-auto col-sm-10">

							<div class="row  linea-bottom">
								<div class="col-12 mx-auto mx-md-3 mb-2">
									<h2 class="pedido-titulo">Domicilio y metodo de pago</h2>
								</div>
							</div>

							<div class="row gx-0 mt-2 mb-4">
								<form id = "form_main-container" class = "form_main-container" method="post" action="CrearPedido">
                                <div  data-position="bottom"
                                data-intro="Se llenará información sobre el domicilio y contacto, en los campos 'Numero Int/Ext', 'Telefono' y 'Código postal' deben ser ingresados puros numeros"
									class="col-12">
										<div class="row gx-0">
											<div class="col-12 mt-2 mx-auto col-md-6 linea-md-right">
												<div class="row gx-0">
													<div class="col-12 mx-auto col-md-11">
														<label for="Calle" required>Calle:</label>
													</div>

													<div class="col-12 mt-1 mx-auto col-md-11">
														<input class="form-control pedido-input-text w-100"
															type="text" name="Calle" value = "${pedidoElegido.getCalle()}" required>
													</div>

													<div class="col-12 mt-4 mx-auto col-md-11">
														<div class="row gx-0 justify-content-between">
															<div class="col-6 pe-2">
																<label for="N_Int" required>Numero interior:</label>
															</div>
															<div class="col-6 ps-2">
																<label for="N_Ext">Numero exterior:</label>
															</div>
														</div>

														<div class="row gx-0  justify-content-between">
															<div class="col-6 pe-2 mt-1">
																<input class="form-control pedido-input-text w-100"
																	type="text" name="N_Int" value = "${pedidoElegido.getN_Int()}" required>
															</div>

															<div class="col-6 ps-2 mt-1">
																<input class="form-control pedido-input-text w-100"
																	type="text" name="N_Ext" value = "${pedidoElegido.getN_Ext()}" required>
															</div>
														</div>
													</div>

													<div class="col-12 mt-4 mx-auto col-md-11">
														<label for="Colonia" required>Colonia:</label>
													</div>

													<div class="col-12 mt-1 mx-auto col-md-11">
														<input class="form-control pedido-input-text w-100"
															type="text" name="Colonia" value = "${pedidoElegido.getColonia()}" required>
													</div>


												</div>
											</div>



											<div class="col-12 mt-4 mx-auto col-md-6 mt-md-2">
												<div class="row gx-0">

													<div class="col-12 mx-auto col-md-11">
														<label for="Estado" required>Estado:</label>
													</div>

													<div class="col-12 mt-1 mx-auto col-md-11">
														<select name="Estado" class="pedido-input-select">
															<option value='Aguascalientes'
															<c:if test="${pedidoElegido.getEstado() == 'Aguascalientes'}">
																selected="selected"
															</c:if>
															>Aguascalientes</option>
															<option value="Baja California"
															<c:if test="${pedidoElegido.getEstado() == 'Baja California'}">
																selected="selected"
															</c:if>
															>Baja California</option>
															<option value="Baja California Sur"
															<c:if test="${pedidoElegido.getEstado() == 'Baja California Sur'}">
																selected="selected"
															</c:if>
															>Baja
																California Sur</option>
															<option value="Campeche"
															<c:if test="${pedidoElegido.getEstado() == 'Campeche'}">
																selected="selected"
															</c:if>
															>Campeche</option>
															<option value="Chiapas"
															<c:if test="${pedidoElegido.getEstado() == 'Chiapas'}">
																selected="selected"
															</c:if>
															>Chiapas</option>
															<option value="Chihuahua"
															<c:if test="${pedidoElegido.getEstado() == 'Chihuahua'}">
																selected="selected"
															</c:if>
															>Chihuahua</option>
															<option value="Estado de México"
															<c:if test="${pedidoElegido.getEstado() == 'Estado de México'}">
																selected="selected"
															</c:if>
															>Estado de México</option>
															<option value="Coahuila"
															<c:if test="${pedidoElegido.getEstado() == 'Coahuila'}">
																selected="selected"
															</c:if>
															>Coahuila</option>
															<option value="Colima"
															<c:if test="${pedidoElegido.getEstado() == 'Colima'}">
																selected="selected"
															</c:if>
															>Colima</option>
															<option value="Durango"
															<c:if test="${pedidoElegido.getEstado() == 'Durango'}">
																selected="selected"
															</c:if>
															>Durango</option>
															<option value="Ciudad de México"
															<c:if test="${pedidoElegido.getEstado() == 'Ciudad de México'}">
																selected="selected"
															</c:if>
															>Ciudad de México</option>
															<option value="Guanajuato"
															<c:if test="${pedidoElegido.getEstado() == 'Guanajuato'}">
																selected="selected"
															</c:if>
															>Guanajuato</option>
															<option value="Guerrero"
															<c:if test="${pedidoElegido.getEstado() == 'Guerrero'}">
																selected="selected"
															</c:if>
															>Guerrero</option>
															<option value="Hidalgo"
															<c:if test="${pedidoElegido.getEstado() == 'Hidalgo'}">
																selected="selected"
															</c:if>
															>Hidalgo</option>
															<option value="Jalisco"
															<c:if test="${pedidoElegido.getEstado() == 'Jalisco'}">
																selected="selected"
															</c:if>
															>Jalisco</option>
															<option value="Michoacán"
															<c:if test="${pedidoElegido.getEstado() == 'Michoacán'}">
																selected="selected"
															</c:if>
															>Michoacán</option>
															<option value="Morelos"
															<c:if test="${pedidoElegido.getEstado() == 'Morelos'}">
																selected="selected"
															</c:if>
															>Morelos</option>
															<option value="Nayarit"
															<c:if test="${pedidoElegido.getEstado() == 'Nayarit'}">
																selected="selected"
															</c:if>
															>Nayarit</option>
															<option value="Nuevo León"
															<c:if test="${pedidoElegido.getEstado() == 'Nuevo León'}">
																selected="selected"
															</c:if>
															>Nuevo León</option>
															<option value="Oaxaca"
															<c:if test="${pedidoElegido.getEstado() == 'Oaxaca'}">
																selected="selected"
															</c:if>
															>Oaxaca</option>
															<option value="Puebla"
															<c:if test="${pedidoElegido.getEstado() == 'Puebla'}">
																selected="selected"
															</c:if>
															>Puebla</option>
															<option value="Querétaro"
															<c:if test="${pedidoElegido.getEstado() == 'Querétaro'}">
																selected="selected"
															</c:if>
															>Querétaro</option>
															<option value="Quintana Roo"
															<c:if test="${pedidoElegido.getEstado() == 'Quintana Roo'}">
																selected="selected"
															</c:if>
															>Quintana Roo</option>
															<option value="San Luis Potosí"
															<c:if test="${pedidoElegido.getEstado() == 'San Luis Potosí'}">
																selected="selected"
															</c:if>
															>San Luis Potosí</option>
															<option value="Sinaloa"
															<c:if test="${pedidoElegido.getEstado() == 'Sinaloa'}">
																selected="selected"
															</c:if>
															>Sinaloa</option>
															<option value="Sonora"
															<c:if test="${pedidoElegido.getEstado() == 'Sonora'}">
																selected="selected"
															</c:if>
															>Sonora</option>
															<option value="Tabasco"
															<c:if test="${pedidoElegido.getEstado() == 'Tabasco'}">
																selected="selected"
															</c:if>
															>Tabasco</option>
															<option value="Tamaulipas"
															<c:if test="${pedidoElegido.getEstado() == 'Tamaulipas'}">
																selected="selected"
															</c:if>
															>Tamaulipas</option>
															<option value="Tlaxcala"
															<c:if test="${pedidoElegido.getEstado() == 'Tlaxcala'}">
																selected="selected"
															</c:if>
															>Tlaxcala</option>
															<option value="Veracruz"
															<c:if test="${pedidoElegido.getEstado() == 'Veracruz'}">
																selected="selected"
															</c:if>
															>Veracruz</option>
															<option value="Yucatán"
															<c:if test="${pedidoElegido.getEstado() == 'Yucatán'}">
																selected="selected"
															</c:if>
															>Yucatán</option>
															<option value="Zacatecas"
															<c:if test="${pedidoElegido.getEstado() == 'Zacatecas'}">
																selected="selected"
															</c:if>
															>Zacatecas</option>
														</select>
													</div>

													<div class="col-12 mx-auto mt-4  col-md-11">
														<label for="Municipio" required>Municipio:</label>
													</div>

													<div class="col-12 mt-1 mx-auto col-md-11">
														<input class="form-control pedido-input-text w-100"
															type="text" name="Municipio" value = "${pedidoElegido.getMunicipio()}" required>
													</div>

													<div class="col-12 mt-4 mx-auto col-md-11">
														<div class="row gx-0 justify-content-between">
															<div class="col-6 pe-2">
																<label for="Telefono" required>Teléfono (10 digitos):</label>
															</div>
															<div class="col-6 ps-2">
																<label for="CP" required>Codigo postal:</label>
															</div>
														</div>

														<div class="row gx-0  justify-content-between">
															<div class="col-6 pe-2 mt-1">
																<input class="form-control pedido-input-text w-100"
																	type="text" name="Telefono" value = "${pedidoElegido.getTelefonoClientePedido()}" required>
															</div>

															<div class="col-6 ps-2 mt-1">
																<input class="form-control pedido-input-text w-100"
																	type="text" name="CP" value = "${pedidoElegido.getCP()}" required>
															</div>
														</div>
													</div>
												</div>
											</div>
										</div>
									</div>


									<div class="col-12">
										<div  data-position="bottom"
	                                    data-intro="Se llenará información el metodo de pago, en el campo 'Numero de cuenta' deben ser ingresados puros numeros"
										class="row gx-0 mt-4 linea-top">
											<div class="col-12 mx-auto mt-3 col-md-6  linea-md-right">
												<div class="col-12 mx-auto col-md-11">
													<label for="Banco" required>Banco:</label>
												</div>

												<div class="col-12 mt-1 mx-auto col-md-11">
													<input class="form-control pedido-input-text w-100"
														type="text" name="Banco" value = "${pedidoElegido.getBancoClientePedido()}" required>
												</div>
											</div>

											<div class="col-12 mt-3 mx-auto col-md-6 ">
												<div class="col-12 mx-auto col-md-11">
													<label for="NumCuenta" required>Numero de cuenta:</label>
												</div>

												<div class="col-12 mt-1 mx-auto col-md-11">
													<input class="form-control pedido-input-text w-100"
														type="text" name="NumCuenta" value = "${pedidoElegido.getNumCuentaClientePedido()}" required>
												</div>
											</div>
										</div>
									</div>

								</form>
								
                                <div  data-position="bottom"
                                data-intro="Finalmente, se dara click en el botón para finalizar la compra"
								class="col-8 mt-4 mx-auto col-sm-5 col-md-5 col-lg-4">
								
									<button id="button-pedido_main-container" form="form_main-container"
										class="btn button-ok w-100 py-2" type="submit" href="#">
										Finalizar compra</button>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>


		</div>
	</main>

	<footer>
		<!--             <div id="footerPage"></div> -->
		<jsp:include page="v_footer.jsp"></jsp:include>
	</footer>
</body>


	<script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
	<script src="Bootstrap/js/popper.min.js"></script>
	<script src="Bootstrap/js/bootstrap.min.js"></script>

	<script src="js/jquery.js"></script>
	<script src="js/owlcarousel/owl.carousel.min.js"></script>
	<script src ="js/jquery.validate.min.js"></script>
	<script src="js/intro.js"></script>
    <script src="js/jquery-ui.js"></script>

	<script src="js/mainjquery.js"></script>
	<script src="js/autocomplete.js"></script>

</html>