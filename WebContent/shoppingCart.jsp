<!-- TODO: SI AQUI SE CAMBIA LA CANTIDAD DEL PRODUCTO, TENGO QUE CAMBIAR EL TOTAL DE CADA PRODUCTO -->
<!-- POR LO QUE DEBERE HACERLO CON AJAX -->
<!-- TODO: SI EL USUARIO NO HA INICIADO SESION, AL DAR CLICK AL BOTON MANDARLO A LOGIN, Y LUEGO A VENTANA DE PEDIDO (VER CASO SI DESPUES DE LOGIN SE VA A CREAR SESION) -->


<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="java.math.BigDecimal"%>

<%
List<Productos_Model> productosCarrito = (List<Productos_Model>) request.getAttribute("productosCarrito");
pageContext.setAttribute("productosCarrito", productosCarrito);

BigDecimal totalPedido = (BigDecimal) request.getAttribute("totalPedido");
pageContext.setAttribute("totalPedido", totalPedido);

BigDecimal cantidadPiezasTotales = (BigDecimal) request.getAttribute("cantidadPiezasTotales");
pageContext.setAttribute("cantidadPiezasTotales", cantidadPiezasTotales);

long IdUsuarioActivo = -1;
if (request.getSession().getAttribute("IdUsuarioActivo") != null){
	IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
}
pageContext.setAttribute("IdUsuarioActivo", IdUsuarioActivo);

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

<link rel="stylesheet" href="css/shoppingCart.css">




</head>

<body class="page">
	<header  data-position="bottom" data-intro="Carrito de compra: Aquí podrás ver todos los productos que has ido agregando, cambiar la cantidad de piezas, quitarlos del carrito, y finalizar la compra" 
    class="sticky-top" style="z-index: 10000000">
		<!-- fixed-top  -->
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
            data-intro="Barra de título de la página, aquí te mostrará en que página te encuentras y navegar entre cada apartado más fácil" 
            class="row gx-0 my-4 cart-barra-titulo-fondo">
				<div class="col-11 mt-2 mx-auto pb-2">

					<a href="IndexPagina" class="cart-barra-titulo-enlace">Inicio</a> <i
						class="fas fa-angle-right cart-barra-titulo"></i>
					<h1 class="cart-barra-titulo">Carrito de compra</h1>
					<i class="fas fa-angle-right cart-barra-titulo"></i> 
					<h1 class="cart-barra-titulo cart-barra-titulo-siguiente">Pedido</h1>

				</div>
			</div>

			<div class="row gx-0 justify-content-around">
                <div class="col-12 cart-carrito-page py-3 col-md-10 col-lg-9 col-xl-8">

					<div class="row gx-0 justify-content-center">
                        <div  data-position="right" 
                        data-intro="Lista de productos <br>en el carrito, <br>Para quitar uno haz click en la x<br>Para cambiar la cantidad<br>haz click en el campo" 
						class="col-12 col-md-11  mx-auto">
						
							
								<div id = "carritoVacioContenedor" class = "
								<c:if test="${not empty productosCarrito}">
									d-none							
	                           	</c:if>
								">
									<div class="row gx-0 mt-5 justify-content-center">
    		                            <div class="col-12 my-auto" align = "center">
        		                            <span class="cart-Icono d-inline"><i class="fas fa-cart-plus "></i></span>
            		                        <h1 class="cart-Titulo d-inline">¡Carrito vacio!</h1>
                		                </div>
                    		        </div>
		                            <div class="row gx-0 mb-5 justify-content-center">
    		                            <div class="col-11" align="center">
        		                            <p class="cart-Descripcion">Agrega más productos al carrito y regresa para realizar los pedidos</p>
            		                    </div>
                		            </div>
                	            </div>
                           
                            	<div id = "carritoProductosContenedor" class = "
									<c:if test="${empty productosCarrito}">
										d-none							
	                           		</c:if>
									">

    	                	       
									<div class="cart-carrito-compras row gx-0 py-2 
									
										<c:if test="${productosCarrito.size() < 5}">
											d-lg-none							
	                           			</c:if>
									">
										<div class="col-7 mx-auto col-sm-8 col-md-9 col-xl-8">
											<h1 class="cart-carrito-compras-texto">Carrito de compras</h1>
            	            	            <h2 class="cart-producto-precio-total-texto">Total:</h2>
        	            	                <h2 id = "totalPedidoPhone"  class="cart-producto-precio-total-cantidad">$${totalPedido}</h2>
    	            	                    <h2 id = "cantidadPiezasTotalesPhone" class="cart-producto-articulos-total-texto">(${cantidadPiezasTotales} artículos)</h2>
										</div>
										<!-- align = "center" -->
										<div class="col-4 my-auto px-2  col-sm-3  col-md-2 col-xl-3">
											<form 
												<c:if test="${IdUsuarioActivo != -1}">
													action = "CrearPedido" method = "get"
												</c:if>
												<c:if test="${IdUsuarioActivo == -1}">
													action = "LoginUsuario" method = "get"
												</c:if>
										
												>
										
										
												<c:if test="${IdUsuarioActivo == -1}">
													<input type="hidden" name="opcion" value="login">
													<input type="hidden" name="usuarioPedido" value="true">
												</c:if>
										
												<button class="btn button-ok w-100 py-2" type="submit" href="CrearPedido">
													Finalizar compra
												</button>
											</form>
										</div>
									</div>
	
									<c:forEach var="iProducto" items="${productosCarrito}">
										<c:set var="iProducto" value="${iProducto}" scope="request" />
										<jsp:include page="v_cartProduct.jsp"></jsp:include>
									</c:forEach>

    	        	                <div  data-position="top" 
	        	                    data-intro="Para finalizar la compra da click en el botón derecho<br>Para seguir viendo productos da click en el botón izquierdo" 
										class="cart-carrito-compras row gx-0 py-2 mt-3 d-none d-lg-flex">
										<div class="col-3 my-auto px-2 col-xl-2">
											<form action = "IndexPagina	" method = "get">
												<button class="btn cart-producto-button-volver w-100 py-2" type="submit" href="IndexPagina">
													Seguir comprando
												</button>
											</form>									
								
										</div>

										<div class="col-6 mx-auto my-auto col-xl-8 mx-xl-0"
											align="right">
											<h1 class="cart-producto-precio-total-texto">Total:</h1>
											<h1 id = "totalPedidoPC" class="cart-producto-precio-total-cantidad">$${totalPedido}</h1>
											<h2 id = "cantidadPiezasTotalesPC" class="cart-producto-articulos-total-texto">(${cantidadPiezasTotales} artículos)</h2>
										</div>
										<!-- align = "center" -->
										<div class="col-3 my-auto px-2 col-xl-2">
											<form 
												<c:if test="${IdUsuarioActivo != -1}">
													action = "CrearPedido" method = "get"
												</c:if>
												<c:if test="${IdUsuarioActivo == -1}">
													action = "LoginUsuario" method = "get"
												</c:if>
										
										
												>
										
												<c:if test="${IdUsuarioActivo == -1}">
													<input type="hidden" name="opcion" value="login">
													<input type="hidden" name="usuarioPedido" value="true">
												</c:if>
										
												<button class="btn button-ok w-100 py-2" type="submit" href="CrearPedido">
													Finalizar compra
												</button>
											</form>
									
										</div>
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
<script src="js/intro.js"></script>
<script src="js/jquery-ui.js"></script>

<script src="js/mainjquery.js"></script>
<script src="js/carrito.js"></script>
<script src="js/autocomplete.js"></script>

</html>