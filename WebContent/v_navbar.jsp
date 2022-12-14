<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.FernandezMarketProject.controllers.GeneralServlet"%>
<%@page import ="java.math.BigDecimal" %>

<%
Usuarios_Model usuarioElegido = GeneralServlet.getUsuario(request, response);
pageContext.setAttribute("usuarioElegido", usuarioElegido);

List<Subcategorias_Model> listaSubcategorias = GeneralServlet.getSubcategorias();
pageContext.setAttribute("listaSubcategorias", listaSubcategorias);

String visualizarOnboarding = (String) request.getAttribute("visualizarOnboarding");;
pageContext.setAttribute("visualizarOnboarding", visualizarOnboarding);

int cantidadProductosCarrito = GeneralServlet.getCantidadProductosCarrito(request, response);
pageContext.setAttribute("cantidadProductosCarrito", cantidadProductosCarrito);

%>


<div class="container-fluid p-0">

    <nav class="navbar navbar-light navbar-style">

        <div class="order-1 col-6 px-2 col-lg-3">
            <button class="navbar-toggler navbar-toggler-icon d-lg-none button-navbar-desplegar" type="button"
                data-bs-toggle="offcanvas" data-bs-target="#offcanvasExample" aria-controls="offcanvasExample">

            </button>
            <a class="navbar-brand px-1" href="IndexPagina">
                <img src="img/Logo.png" alt="" style="width: 120px">
            </a>
        </div>

        <div
			<c:if test="${not empty visualizarOnboarding}">         	
        		data-position="left"
            	data-intro="Buscador de productos, puede ingresar el nombre de un producto y dar click en el botón de la lupa para buscar todos los productos con un nombre similar"
            </c:if>
        class="order-3 col-12 px-2 mt-1 order-lg-2 col-lg-5  mt-lg-0  col-xl-4">
            <form class="d-flex justify-content-center"  action = "SubcategoriaProductos" method = "get"  autocomplete="off">
                <div class="navbar-search-bar col-12">
                 	<input name="IdSubcategoria" type="hidden" value="0">
                    <input name="numeroPagina" type="hidden" value="1">
                    <input id = "navbar-search-bar" class="navbar-search-bar-input" name = "nombreProducto" type="search" placeholder="Buscar producto"
                        aria-label="Buscar">
                    <button class="button-navbar-search p-0 mx-2" type="submit"><i class="fas fa-search"></i></button>
                </div>
            </form>
        </div>

        <div class="order-2 col-6 ps-2  order-lg-3 col-lg-3" align="end">
        	<div   
        		<c:if test="${not empty visualizarOnboarding}">
        		data-position="left"
                data-intro="Botón para iniciar sesión<br>Si ya te encuentras registrado podrás dar click para entrar a tu perfil"
                </c:if>
                style="display: inline;">
            
        	<c:if test="${not empty usuarioElegido}">
            	<a href="PerfilUsuario" class="link-navbar">
                	<h1 class = "label-navbar-sesion d-none d-xl-inline">Hola ${usuarioElegido.getNombreUsuario()}</h1>
                	<i class="fas fa-user button-navbar-icons mx-sm-1"></i>
            	</a>
			</c:if>
			<c:if test="${empty usuarioElegido}">
				<form action = "LoginUsuario" method = "get"  style="display: inline;">
					<input type="hidden" name="opcion" value="login">
					<button class="link-navbar invisible-button" type="submit">
						<h1 class="label-navbar-sesion d-none d-xl-inline">Iniciar sesion</h1>
                		<i class="fas fa-user button-navbar-icons mx-sm-1"></i>
					</button>
				</form>
                	
            	</a>
            </c:if>
            </div>
            <a 
            	<c:if test="${not empty visualizarOnboarding}">
	            	data-position="left"
    	        	data-intro="Botón ver el carrito de productos comprados"
            	</c:if>
            	
            href="CarritoProductos" class="link-navbar" id = "navbar-carrito-icono" >
                <i class="fas fa-shopping-cart button-navbar-icons  me-1 ms-sm-1 position-relative">
                    <span class='navbar-carrito-cantidad-span' id='navbar-carrito-cantidad-productos'> ${cantidadProductosCarrito} </span>
                </i>
            </a>
            
            <c:if test="${not empty usuarioElegido}">
                <div 
                    <c:if test="${not empty visualizarOnboarding}">
                		data-position="left"
                    	data-intro="Botón para iniciar sesión<br>Si ya te encuentras registrado podrás dar click para entrar a tu perfil"
                    </c:if>
                    
                    style="display: inline">
                	<form action = "LoginUsuario" method = "get"  style="display: inline;">
                		<input type="hidden" name="opcion" value="logout">
		    			<button class="link-navbar invisible-button" type="submit">
			    				<i class="fas fa-door-open  button-navbar-icons mx-sm-1"></i>
				    	</button>
				    </form>
                </div>
			</c:if>
			
            <a href="javascript:introJs().setOption().start();" class="link-navbar">
                <i class="far fa-question-circle me-1
                <c:if test="${empty usuarioElegido}">
                ms-2
                </c:if>
                
                "></i>
            </a>
        </div>

    </nav>


    <nav class="navbar navbar-expand-lg navbar-light sub-navbar d-none d-lg-flex">
        <div class="col-4 px-3">
            <button 
            	<c:if test="${not empty visualizarOnboarding}">
            		data-position="left"
            		data-intro="Botón que despliega las categorias de la tienda"
            	</c:if>
            	
            	class="sub-navbar-categorias-button categories-text" type="button" id="dropdownMenuButton1"
                data-bs-toggle="dropdown" aria-expanded="false">
                <i class="fas fa-bars"></i>
                <p style="display: inline;">Categorias</p>
            </button>
            <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
                <li><a class="dropdown-item navbar-categoria-opcion" href="SubcategoriaProductos?IdSubcategoria=0&numeroPagina=1">General</a></li>
                <li>
                    <hr class="dropdown-divider">
                </li>

				<c:forEach var="iSubcategoria" items="${listaSubcategorias}">
					<li><a class="dropdown-item navbar-categoria-opcion" href="SubcategoriaProductos?IdSubcategoria=${iSubcategoria.getIdSubcategoria()}&numeroPagina=1">${iSubcategoria.getTituloSubcategoria()}</a></li>
				</c:forEach>
            </ul>
        </div>

        <div class="col-8" align="end">
            <a 
           	<c:if test="${not empty visualizarOnboarding}">
            	data-position="bottom" 
            	data-intro="Botón para ir a la página de inicio"
            </c:if>
            
            class="nav-link categories-text" href="IndexPagina">
                Inicio 
            </a>
            <a 
            	<c:if test="${not empty visualizarOnboarding}">
            		data-position="bottom" 
            		data-intro="Botón para ir a la página 'Nosotros' donde se encuentra información de la tienda como su propósito y datos de contacto"
            	</c:if>
            	
            class="nav-link categories-text" href="nosotros.jsp">
                Nosotros 
            </a>
            <a 
				<c:if test="${not empty visualizarOnboarding}">
            		data-position="bottom" 
            		data-intro="Botón para ir a la página 'Sucursales' donde se encuentra información de cada sucursal, junto a su dirección y teléfono"
            	</c:if>
            	
             class="nav-link categories-text" href="sucursales.jsp">
                Sucursales 
            </a>
        </div>

    </nav>
</div>