<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.FernandezMarketProject.controllers.GeneralServlet"%>
<%@page import ="java.math.BigDecimal" %>


<%
Productos_Model iProducto = (Productos_Model) request.getAttribute("iPregunta");
pageContext.setAttribute("iProducto", iProducto);
%>

<div class="subcategorias-producto-card mx-3">

    
    <a href="DetallesProducto?IdProducto=${iProducto.getIdProducto()}" class = "subcategorias-producto-enlace">
        <div class="row gx-0 subcategorias-producto-imagen_precio">
            <div class="col-6">
                <img src="GeneralServlet?Imagen=Producto&Id=${iProducto.getIdProducto()}" class="w-100" alt="...">
            </div>


            <div class="col-5">
                <div class="row">
                    <div class="col-12">
                    	<c:if test="${iProducto.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
                        	<h5 class="subcategorias-producto-precio-anterior">$ ${iProducto.getPrecioProducto()}</h5>
                        </c:if>
                        
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <h5 class="subcategorias-producto-precio-final" descuento = "${iProducto.getDescuentoProducto()}">$ ${iProducto.getPrecioFinalProducto()}</h5>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                    	<c:if test="${iProducto.getDescuentoProducto().compareTo(BigDecimal.ZERO) == 1}">
                        	<h5 class="subcategorias-producto-precio-rebajado">Ahorra ${iProducto.getProcentajeDescuentoProducto()}%</h5>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </a>

    <div class="row">
        <div class="col-12">
            <div class="card-body subcategorias-card-producto-texto">

                <a class="subcategorias-producto-titulo" href="DetallesProducto?IdProducto=${iProducto.getIdProducto()}">${iProducto.getNombreProducto()}</a>
                <br>
                <div class="subcategorias-producto-marca-container">
                    <p class="subcategorias-producto-marca-label">Marca: </p>
                    <p class="subcategorias-producto-marca">${iProducto.getMarcaProductoTexto()}</p>
                </div>

            </div>
        </div>
    </div>

</div>