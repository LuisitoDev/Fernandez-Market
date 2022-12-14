<%@ page language="java" contentType="text/html; UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="com.FernandezMarketProject.models.*"%>
<%@page import="java.util.*"%>
<%@page import="com.FernandezMarketProject.controllers.GeneralServlet"%>
<%@page import ="java.math.BigDecimal" %>


<%
Pedidos_Model iPedido = (Pedidos_Model) request.getAttribute("iPedido");
pageContext.setAttribute("iPedido", iPedido);
%>

<div class="row gx-0 mt-3">
    <a class = "profileUser-pedido-card-pedido" data-bs-toggle="collapse" href="#multiCollapse${iPedido.getIdPedido()}" role="button" aria-expanded="false"
        aria-controls="multiCollapse${iPedido.getIdPedido()}">
        <div class="col-12">
            <div class="row gx-0 linea-bottom">
                <div class="col-12 px-3 my-1">
                    <h1 class="profileUser-pedido-card-pedido-titulo" href="">Id Pedido: ${iPedido.getIdPedido()} / ${iPedido.getFechaCreacionPedido()}</h1>
                </div>
            </div>

            <div class="row gx-0 pt-1 pb-1 pb-md-0 collapse multi-collapse" id="multiCollapse${iPedido.getIdPedido()}">
                <div class="col-12 px-3 my-1">


                    <h1 class="profileUser-pedido-card-pedido-descipcion-titulo" href="">Domicilio pedido:</h1>
                    <h1 class="profileUser-pedido-card-pedido-descipcion" href="">${iPedido.getDomicilioPedido()}</h1>
                    <br>
                    <h1 class="profileUser-pedido-card-pedido-descipcion-titulo" href="">Forma de pago: </h1>
                    <h1 class="profileUser-pedido-card-pedido-descipcion" href="">Cuenta ${iPedido.getBancoClientePedido()}</h1>
                </div>

            </div>

            <div class="cart-card-producto-total row gx-0">
                <div class="col-12  px-3 my-1" align="end">
                    <p class="profileUser-pedido-card-pedido-precio-articulos-texto">Total:</p>
                    <p class="profileUser-pedido-card-pedido-precio-articulos-cantidad">$ ${iPedido.getPrecioTotalPedido()}</p>
                </div>
            </div>

        </div>
    </a>
</div>