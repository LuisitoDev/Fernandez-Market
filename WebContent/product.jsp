<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.FernandezMarketProject.controllers.GeneralServlet"%>
<%@page import="java.math.BigDecimal"%>

<%
Productos_Model productoElegido = (Productos_Model) request.getAttribute("productoElegido");
pageContext.setAttribute("productoElegido", productoElegido);

List<Productos_Model> listaProductosRelacionados = (List<Productos_Model>) request
		.getAttribute("listaProductosRelacionados");
pageContext.setAttribute("listaProductosRelacionados", listaProductosRelacionados);
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
<link rel="stylesheet" href="css/product.css">
<link rel="stylesheet" href="css/carouselProductos.css">



</head>

<body class="page">
	<header  data-position="bottom" data-intro="Página de productos: aquí podrás ver los detalles de cada productos y agregarlos al carrito"
    class="sticky-top" style="z-index: 10000000">
		<!--             <div id="navbarPage" class="navbar-complete"></div> -->
		<jsp:include page="v_navbar.jsp"></jsp:include>
	</header>

    <section>
<!--         <div id = "v_subnavbar"></div> -->
        <jsp:include page="v_subnavbar.jsp"></jsp:include>        
    </section>

	<main>
		<!-- Filtro de busqueda y productos -->
		<div class="container-fluid p-0">

			<div data-position="bottom" 
            data-intro="Barra de título de la página, aquí te mostrará en que página te encuentras y navegar entre cada apartado más fácil" 
            class="row gx-0 my-4 producto-barra-titulo-fondo">
				<div class="col-11 mt-2 mx-auto pb-2">

					<a href="IndexPagina" class="producto-barra-titulo-enlace">Inicio</a>
					<i class="fas fa-angle-right producto-barra-titulo"></i>
					<!--                         TODO: TRAERME EL TITULO DE LA SUBCATEGORIA DEL PRODUCTO -->
					<a href="SubcategoriaProductos?IdSubcategoria=${productoElegido.getSubcategoriaProducto()}&numeroPagina=1"
						class="producto-barra-titulo-enlace">${productoElegido.getTituloSubcategoria()}</a> <i
						class="fas fa-angle-right producto-barra-titulo"></i>
					<h1 class="producto-barra-titulo">Producto</h1>
				</div>
			</div>



			<div class="producto-completo-fondo row gx-0 py-4 mt-3">
				 <div  data-position="left" data-intro="Detalles del producto:
                <ul>
                    <li>Nombre del producto</li>
                    <li>Marca</li>
                    <li>Precio antiguo</li>
                    <li>Precio antiguo<br>(si tiene descuento)</li>
                    <li>Descuento (si tiene)</li>
                    <li>Precio final</li>
                    <li>Cantidad en almacen</li>
                  </ul>"
				class="col-11 col-sm-6 col-md-11 mx-auto col-lg-8">
					<div class="row gx-0 px-3 py-3 producto-completo">

						<div
							class="d-none d-md-inline col-12 col-md-6 col-xl-5 mx-xl-auto">
							<img
								src="GeneralServlet?Imagen=Producto&Id=${productoElegido.getIdProducto()}"
								class="card-img-top w-100 producto-imagen" alt="...">
						</div>
						<div
							class="col-12 mt-md-3 col-md-5 ms-md-4 mt-md-0 mx-xl-auto col-xl-6">
							<h5 id = "producto-titulo-id" class="producto-titulo">${productoElegido.getNombreProducto()}</h5>
							<p class="producto-marca-label">Marca:</p>
							<p class="producto-marca">${productoElegido.getMarcaProductoTexto()}</p>

							<div class="d-flex d-md-none justify-content-center mt-4">
								<img
									src="GeneralServlet?Imagen=Producto&Id=${productoElegido.getIdProducto()}"
									class="card-img-top w-100 w-xs-100 w-sm-75 producto-imagen"
									alt="...">

							</div>


							<c:if
								test="${productoElegido.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
								<h5 class="producto-precio-anterior">$
									${productoElegido.getPrecioProducto()}</h5>
							</c:if>

							<h5  id = "producto-precio-final" class="producto-precio-final" value = "${productoElegido.getPrecioFinalProducto()}">$
								${productoElegido.getPrecioFinalProducto()}</h5>

							<c:if
								test="${productoElegido.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
								<h5 class="producto-precio-rebajado">Ahorra
									${productoElegido.getProcentajeDescuentoProducto()}%</h5>
							</c:if>

							
							<div  data-position="bottom"
                                data-intro="Para comprar un producto elegimos la cantidad de piezas y damos click al botón 'Agregar al carrito', la cantidad de piezas disponibles aparece en el recuadro blanco">

								<div class="input-group">
									<span class="input-group-text producto-cantidad-span px-2 w-75 w-xl-50">
                                        <p class="producto-cantidad-span-titulo my-0">Cant. En almacén: </p>
            	                        <p class = "producto-cantidad-span-cantidad ps-2  my-0">${productoElegido.getCantidadStockProducto()}</p>
                	                </span>
								</div>


								<div class="input-group mt-3">
<!-- 									<form id = "form_main-container" action="DetallesProducto" method="post"> -->
								
<!-- 									TODO: SI EL USUARIO NO SE ENCUNTRA REGISTRADO, LA OTRA ES QUE SI SE PUEDA HACER EL CARRITO, Y EN LA PAGINA DE PEDIDO INICIE SESION -->
									
											<c:if test="${productoElegido.getCantidadStockProducto() > 0}">
										
												<input id = "IdProducto" name="IdProducto" type="hidden" value="${productoElegido.getIdProducto()}">
<!-- 												id="button_main-container"  -->
												<button id = "producto-boton-agregar-carrito" class="btn btn-primary producto-boton me-3"
												class="btn btn-lg btn-danger" role="button" data-bs-toggle="popover" title="Dismissible popover" 
												data-bs-content="Producto agregado correctamente">
														Agregar al carrito 
												</button>
												
												
												<input id = "IdProducto" name="IdProducto" type="hidden" value="${iProducto.getIdProducto()}">
												<a class="producto-cantidad-input-botones" tipo="restar" href=""> - </a>
												<input id="CantidadPiezasProducto" name="cantidadPiezas" class="producto-cantidad-input" type="number" 
												min="1" max="${productoElegido.getCantidadStockProducto()}" value = "1" maxlength="4">
												<a class="producto-cantidad-input-botones" tipo="sumar" href=""> + </a>
											</c:if>
										
											<c:if test="${productoElegido.getCantidadStockProducto() == 0}">
												<p>*No hay piezas disponibles</p>
											</c:if>
<!-- 									</form> -->
								
								</div>	

                            </div>
						</div>
					</div>
				</div>
			</div>

		</div>

        <div  data-position="left" 
        data-intro="Después de haberlo agregado al carrito, podemos ver productos relacionados">

			<div class="row gx-0 mt-4 mb-3">
	            <div class="carousel-productos-titulo-fondo col-12 py-2 col-md-6 col-lg-4 " align="center">
        	        <h1 class="producto-barra-titulo-relacionados">Productos relacionados</h1>
    	        </div>
	        </div>

            <div class="container-fluid p-0">
				<!--                 <div id="carouselProductos"></div> -->
				<c:set var="listaProductosGenerales" value="${listaProductosRelacionados}" scope="request" />
				<jsp:include page="v_carouselProductos.jsp"></jsp:include>

			</div>
		
        </div>

		

        <div id="producto-agregado-view"  style="z-index: 10000010">
           
        </div>
        

	</main>

	<footer>
		<!--             <div id="footerPage"></div> -->
		<jsp:include page="v_footer.jsp"></jsp:include>
	</footer>
</body>


<script src="https://kit.fontawesome.com/d253da1760.js" crossorigin="anonymous"></script>
<script src = "Bootstrap/js/popper.min.js"></script>
<script src = "Bootstrap/js/bootstrap.min.js"></script>

<script src="js/jquery.js"></script>
<script src="js/owlcarousel/owl.carousel.min.js"></script>
<script src="js/owlJquery.js"></script>
<script src="js/intro.js"></script>
<script src="js/jquery-ui.js"></script>

<script src="js/mainjquery.js"></script>
<script src="js/carrito.js"></script>
<script src="js/autocomplete.js"></script>

</html>