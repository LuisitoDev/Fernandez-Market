<%@ page language="java" contentType="text/html; UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>

<%
List<Subcategorias_Model> listaSubcategorias = (List<Subcategorias_Model>) request.getAttribute("listaSubcategorias");
pageContext.setAttribute("listaSubcategorias", listaSubcategorias);

List<Productos_Model> listaProductos = (List<Productos_Model>) request.getAttribute("listaProductos");
pageContext.setAttribute("listaProductos", listaProductos);

int idBoton = (int) request.getAttribute("idBoton");
pageContext.setAttribute("idBoton", idBoton);

int CantidadBotones = (int) request.getAttribute("CantidadBotones");
pageContext.setAttribute("CantidadBotones", CantidadBotones);

Subcategorias_Model subcategoriaElegida = (Subcategorias_Model) request.getAttribute("subcategoriaElegida");
pageContext.setAttribute("subcategoriaElegida", subcategoriaElegida);

int paginaFinal = (int) request.getAttribute("paginaFinal");
pageContext.setAttribute("paginaFinal", paginaFinal);


String nombreProducto = (String) request.getAttribute("nombreProducto");
pageContext.setAttribute("nombreProducto", nombreProducto);

String nombreProductoQuery = (String) request.getAttribute("nombreProductoQuery");
pageContext.setAttribute("nombreProductoQuery", nombreProductoQuery);
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


<link rel="stylesheet" href="css/Autocomplete/jquery-ui.css">
<link rel="stylesheet" href="css/Autocomplete/jquery-ui.structure.css">
<link rel="stylesheet" href="css/Autocomplete/jquery-ui.theme.css">

<link rel="stylesheet" href="css/generalStyles.css">
<link rel="stylesheet" href="css/widthme.css">
<link rel="stylesheet" href="css/carouselProductos.css">
<link rel="stylesheet" href="css/subcategoryProducts.css">
<link rel="stylesheet" href="css/introjs.css">

	
	
<c:if test="${not empty subcategoriaElegida}">
	<c:set var="idSubcategoriaElegida" value="${subcategoriaElegida.getIdSubcategoria()}" />
</c:if>
<c:if test="${empty subcategoriaElegida}"> 
	<c:set var="idSubcategoriaElegida" value="0" />
</c:if>
	
	
</head>

<body class="page">
	<header  data-position="bottom" data-intro="Pagina de subcategorias: aqui podras encontrar todos los productos de la tienda"
    class = "sticky-top" style="    z-index: 10000000">
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
            data-intro="Barra de título de la página, aqui te mostrará en que página te encuentras y navegar entre cada apartado más fácil" 
			class="row gx-0 my-4 subcategoria-barra-titulo-fondo">
				<div class="col-11 mt-2 mx-auto pb-2">

					<a href="IndexPagina" class="subcategoria-barra-titulo-enlace">Inicio</a>
					<i class="fas fa-angle-right subcategoria-barra-titulo"></i>
					<h1 class="subcategoria-barra-titulo">
					<c:if test="${not empty subcategoriaElegida}">
						${subcategoriaElegida.getTituloSubcategoria()}
					</c:if>
						<c:if test="${empty subcategoriaElegida}">
						General
					</c:if>
					</h1>
				</div>
			</div>

			<div class="row gx-0">
				<div class="d-lg-none col-12">
					<!-- navbar navbar-expand-lg navbar-light sub-navbar -->
					<div class="subcategorias-contenedor-desplegar py-2 px-3">
						<div class="container-fluid d-flex justify-content-between">
							<h1 class="subcategorias-opcion-titulo my-2">Categorias</h1>

							<button class="btn subcategorias-boton-desplegar" type="button"
								data-bs-toggle="collapse" data-bs-target="#subcategoriesContent"
								aria-controls="subcategoriesContent" aria-expanded="false"
								aria-label="Toggle navigation">
								<i class="fas fa-bars"></i>
							</button>
						</div>
					</div>





					<div class="collapse subcategorias-contenedor-opciones"
						id="subcategoriesContent">
						<div class="row gx-0">
							<a href="SubcategoriaProductos?IdSubcategoria=0&numeroPagina=1${nombreProductoQuery}"
								class="subcategorias-opcion">
								<div
									class="col-12 mx-auto py-2 px-3 
                           		<c:if test="${empty subcategoriaElegida}">
									subcategorias-elegida
								</c:if>
                           	">
									General</div>
							</a>

							<c:forEach var="iSubcategoria" items="${listaSubcategorias}">



								<a href="SubcategoriaProductos?IdSubcategoria=${iSubcategoria.getIdSubcategoria()}&numeroPagina=1${nombreProductoQuery}"
									class="subcategorias-opcion">
									<div class="col-12 mx-auto py-2 px-3 
                            		<c:if test="${iSubcategoria.getIdSubcategoria() eq subcategoriaElegida.getIdSubcategoria()}">
										subcategorias-elegida
									</c:if>
                            	">
										${iSubcategoria.getTituloSubcategoria()}</div>
								</a>
							</c:forEach>
						</div>
					</div>
				</div>

                <div class="col-2 d-none d-lg-inline ms-5">
                    <div data-position="right" 
                    data-intro="Subcategorías de la página, puede filtrar todos sus productos por cada subcategoría haciendo click en una, o buscar en general">
						<div class="subcategorias-contenedor-desplegar py-2 px-3">
							<div class="container-fluid d-flex justify-content-between">
								<h1 class="subcategorias-opcion-titulo my-1">Subcategorias</h1>
							</div>
						</div>

						<div class="subcategorias-contenedor-opciones">
							<div class="row gx-0 ">

								<a href="SubcategoriaProductos?IdSubcategoria=0&numeroPagina=1${nombreProductoQuery}"
									class="subcategorias-opcion">
									<div
										class="col-12 mx-auto py-2 px-3 
            	               		<c:if test="${empty subcategoriaElegida}">
										subcategorias-elegida
									</c:if>
	                           	">
										General</div>
								</a>

								<c:forEach var="iSubcategoria" items="${listaSubcategorias}">
									<a href="SubcategoriaProductos?IdSubcategoria=${iSubcategoria.getIdSubcategoria()}&numeroPagina=1${nombreProductoQuery}"
										class="subcategorias-opcion">
										<div
											class="col-12 mx-auto py-2 px-3 
                            			<c:if test="${iSubcategoria.getIdSubcategoria() eq subcategoriaElegida.getIdSubcategoria()}">
											subcategorias-elegida
										</c:if>
                        	    	">
											${iSubcategoria.getTituloSubcategoria()}</div>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>
                </div>


				<div
					class="col-12 col-lg-9 mx-auto mb-3 subcategorias-contenedor-productos">
					<%-- TODO: ESTE DIV DE ABAJO SUPUESTAMENTE DEBE IR HASTA DESPUES DE PONER EL PRODUCTO, PERO IGUAL CREO QUE NO HAY PROBLEMA SI LO DEJO ASI (PENDIENTE REVISAER) --%>
                    <div  data-position="left" 
                    data-intro="Productos de la subcategoría elegida, puedes visualizar los detalles de cada uno dando click a la imagen y el título"
					class="row gx-0 justify-content-center align-items-center" style = "height: 100%">
					
						<c:if test="${not empty nombreProducto}">
							<div class="row gx-0 px-3 justify-content-center align-self-start">
								<div class="col-12 px-3 py-3 mt-3 subcategorias-busqueda-contenedor">
									<div class="d-flex justify-content-between">
										<div class="d-inline">
											<h1 class="subcategorias-busqueda-titulo">Producto buscado con nombre:</h1>
											<h1 class="subcategorias-busqueda-titulo-producto">${nombreProducto}</h1>
										</div>
										<a href="SubcategoriaProductos?IdSubcategoria=${idSubcategoriaElegida}&numeroPagina=1" class="text-end"><i class="fas fa-times-circle subcategorias-busqueda-titulo-eliminar"></i></a>
									</div>
								</div>
							</div>
						</c:if>
						
						<c:if test="${empty listaProductos}">

							<div class="subcategorias-contenedo-info align-items-center">

								<div class="row gx-0 mt-5 justify-content-center">
									<div class="col-12 my-auto" align="center">
										<span class="subcategorias-Icono d-inline">
											<i class="fas fa-shopping-cart"></i> 
										</span>
    	                                <h1 class="subcategorias-Titulo d-inline">No se encontraron productos
    	                                	
    	                                	<c:if test="${not empty nombreProducto}">
    	                                 	con el nombre
	                                        <p class = "subcategorias-busqueda-titulo-producto">"${nombreProducto}"</p>
	                                        </c:if>
                                    	</h1>
									</div>
								</div>
								<div class="row gx-0 justify-content-center">
									<div class="col-11" align="center">
										<p class="subcategorias-Descripcion">
											Intente buscar en otra categoría
											<c:if test="${not empty nombreProducto}">
											, o buscar con otro nombre
											</c:if>
											
										</p>
									</div>
								</div>
							</div>

						</c:if>
						
						<c:forEach var="iProducto" items="${listaProductos}">
							<div class="col-12 my-3 col-sm-6  col-lg-4">
								<!--                         <div id="cardProduct1"></div> -->
								<c:set var="iProducto" value="${iProducto}" scope="request" />
								<jsp:include page="v_cardProduct.jsp"></jsp:include>
							</div>
						</c:forEach>
						
						<div  data-position="bottom" data-intro="Botones de navegación para moverse entre las páginas y seguir buscando productos"
                   		 	class="paginacion d-flex justify-content-center mt-2 mb-3">
						<c:if test="${numeroPagina > 1 && CantidadBotones < paginaFinal}">
							<a href="SubcategoriaProductos?IdSubcategoria=${idSubcategoriaElegida}&numeroPagina=${numeroPagina - 1}${nombreProductoQuery}"
								class="btn btn-primary subcategorias-boton-paginacion ms-1  px-2 py-1 mx-sm-1  px-sm-3 py-sm-2">
								<i class="fas fa-arrow-left"></i>
							</a>
						</c:if>
						
						<c:if test="${CantidadBotones < paginaFinal && numeroPagina != 1}">
							<a href="SubcategoriaProductos?IdSubcategoria=${idSubcategoriaElegida}&numeroPagina=1${nombreProductoQuery}"
								class="btn btn-primary subcategorias-boton-paginacion ms-1  px-2 py-1 mx-sm-1 px-sm-3 py-sm-2">
								1...
							</a>
						</c:if>
						
						

						<c:if test="${CantidadBotones > 0}">
							<c:forEach begin="0" end="${CantidadBotones - 1}">
								<a href="SubcategoriaProductos?IdSubcategoria=${idSubcategoriaElegida}&numeroPagina=${idBoton}${nombreProductoQuery}"
									class="btn btn-primary subcategorias-boton-paginacion ms-1 px-2 py-1 mx-sm-1 px-sm-3 py-sm-2
									
									<c:if test="${idBoton == numeroPagina}">
										subcategorias-boton-paginacion-pagina
									</c:if>
									">
									${idBoton} </a>

								<c:set var="idBoton" value="${idBoton+1}" />
							</c:forEach>
						</c:if>
						
						
						<c:if test="${CantidadBotones < paginaFinal && (numeroPagina + CantidadBotones - 1) < paginaFinal}">
							<a href="SubcategoriaProductos?IdSubcategoria=${idSubcategoriaElegida}&numeroPagina=${paginaFinal}${nombreProductoQuery}"
								class="btn btn-primary subcategorias-boton-paginacion ms-1  px-2 py-1 mx-sm-1 px-sm-3 py-sm-2">
								...${paginaFinal}
							</a>
						</c:if>
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
	<script src="js/autocomplete.js"></script>

	
</html>