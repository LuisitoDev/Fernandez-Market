<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.FernandezMarketProject.controllers.GeneralServlet"%>
<%@page import ="java.math.BigDecimal" %>


<%
Productos_Model iProducto = (Productos_Model) request.getAttribute("iProducto");
pageContext.setAttribute("iProducto", iProducto);
%>

<div class="row gx-0 mt-3">
    <div class="col-12 cart-card-producto">
        <div class=" row gx-0">
           <div class="col-12 pe-1 pt-1 pe-md-2" align="end">
<!--             	<form id = "form_delete-main-container" action="CarritoProductos" method = "post"> -->
<%--             		<input name="IdProducto" type="hidden" value="${iProducto.getIdProducto()}"> --%>
<!--             		<button id = "cart-producto-eliminar-boton" class = "cart-producto-eliminar-boton" form = "form_delete-main-container"><i class="fas fa-times-circle cart-producto-eliminar"></i></button> -->
<!--             	</form> -->

					<input id = "IdProducto" name="IdProducto" type="hidden" value="${iProducto.getIdProducto()}">
<%-- 					<span id = "IdProducto" class = "d-none">${iProducto.getIdProducto()}</span> --%>
					<a id = "cart-producto-eliminar-boton" class = "cart-producto-eliminar-boton"><i class="fas fa-times-circle cart-producto-eliminar"></i></a>
            </div>
        </div>
         <div class="row gx-0 pt-1 pb-3 pb-md-0 ">
            <div class="col-2 px-1 col-xl-1" align="center">
                <a href="DetallesProducto?IdProducto=${iProducto.getIdProducto()}" class="cart-producto-imagen">
                    <img src="GeneralServlet?Imagen=Producto&Id=${iProducto.getIdProducto()}" class="w-100" alt="...">
                </a>
                <a href="GeneralServlet?Imagen=Producto&Id=${iProducto.getIdProducto()}" target = "_blank">
                    <i class="fas fa-expand cart-producto-imagen-expandir py-2 px-2"></i>
                </a>
            </div>
            <div class="col-6 col-sm-7 col-xl-8">
                <a class="cart-producto-titulo" href="DetallesProducto?IdProducto=${iProducto.getIdProducto()}">${iProducto.getNombreProducto()}</a>
                <br>
                <p class="cart-producto-marca-label">Marca: </p>
                <p class="cart-producto-marca">${iProducto.getMarcaProductoTexto()}</p>
                <br>
                <p class="cart-producto-stock-texto">En stock: </p>
                <p class="cart-producto-stock-cantidad">${iProducto.getCantidadStockProducto()}</p>
                
            </div>
           <div class="col-4 pe-1 col-sm-3  pe-md-3" align = "end">
                <div class="row gx-0">
                    <div class="col-12 mt-1">
                        <h5 class="cart-producto-precio">$${iProducto.getPrecioFinalProducto()}</h5>
                    </div>
                </div>
                <div class="row gx-0">
                    <div class="col-12" align = "end">
                        <h5 class="cart-producto-cantidad-texto">Cantidad:</h5>
                        
                        <input id = "IdProducto" name="IdProducto" type="hidden" value="${iProducto.getIdProducto()}">
                        <a id = "cart-producto-cantidad-agregar" tipo="sumar" class="cart-producto-cantidad-input-botones" href=""> + </a>
                        <input id = "CantidadPiezas" class="cart-producto-cantidad-input" type="number" id="quantity" name="quantity"
                                min="1" max="${iProducto.getCantidadStockProducto()}" value = "${iProducto.getCantidadPiezasComprar()}"  maxlength="4" >
                        <a id = "cart-producto-cantidad-restar"  tipo="restar" class="cart-producto-cantidad-input-botones" href=""> - </a>
                    </div>
                </div>
                
            </div>
        </div>
        <div class="cart-card-producto-total row gx-0">
            <div class="col-12 px-3 my-1" align = "end">
                <p class = "cart-producto-precio-articulos-texto">Total p/piezas:</p>
                <p id = "totalPorPiezasProducto${iProducto.getIdProducto()}" class = "cart-producto-precio-articulos-cantidad">$${iProducto.getTotalPorPiezas()}</p>
            </div>
        </div>
    </div>
</div>