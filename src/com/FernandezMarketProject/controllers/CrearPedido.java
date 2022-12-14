package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FernandezMarketProject.dao.ComprasDAO;
import com.FernandezMarketProject.dao.PedidosDAO;
import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.models.Compras_Model;
import com.FernandezMarketProject.models.Pedidos_Model;
import com.FernandezMarketProject.models.Productos_Model;

/**
 * Servlet implementation class CrearPedido
 */
@WebServlet("/CrearPedido")
public class CrearPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			traerDireccionPedidoReciente(request, response);
			dispatcher = request.getRequestDispatcher("pedido.jsp");
		} catch(NullPointerException  e) {
			request.setAttribute("error", "Parece que no se encontro el producto que estabas buscando");
			dispatcher = request.getRequestDispatcher("error.jsp");
			
		} catch(NumberFormatException  e) {
			request.setAttribute("error", "Error en el codigo del producto, asegurate que el codigo contenga solo n�meros");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} catch(Exception  e) { //Error inesperado
			request.setAttribute("error", "Error inesperado");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		finally {
			dispatcher.forward(request, response);
		}		
		
	}

	private void traerDireccionPedidoReciente(HttpServletRequest request, HttpServletResponse response) {
		Pedidos_Model pedidoElegido = new Pedidos_Model();
		
		List<Pedidos_Model> listaPedidosAux = null;
		Pedidos_Model pedidoAux = null;

		
		if (request.getSession().getAttribute("IdUsuarioActivo") != null) {
			long IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
			
			pedidoAux = new Pedidos_Model();
			pedidoAux.setUsuarioPedido(IdUsuarioActivo);

			try {
				listaPedidosAux = PedidosDAO.getPedidos("NUE", pedidoAux);
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (listaPedidosAux.size() > 0) {
				pedidoElegido = listaPedidosAux.get(0);
				
				pedidoElegido.createDireccionCompleta();
			}
		}
		
		//TODO: ASEGURARME QUE SI MANDO EL PEDIDO VACIO, NO HAY PROBLEMA
		request.setAttribute("pedidoElegido", pedidoElegido);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			crearPedido(request, response);
			response.sendRedirect("PerfilUsuario");
		} catch(NullPointerException  e) {
			request.setAttribute("error", "Parece que no se encontro el producto que estabas buscando");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
			
		} catch(NumberFormatException  e) {
			request.setAttribute("error", "Error en el codigo del producto, asegurate que el codigo contenga solo n�meros");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		} catch(Exception  e) { //Error inesperado
			request.setAttribute("error", "Error inesperado");
			dispatcher = request.getRequestDispatcher("error.jsp");
			dispatcher.forward(request, response);
		}		
	}

	

	private void crearPedido(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		//TODO: VALIDAR QUE EL CARRITO NO ESTE VACIO
		request.setCharacterEncoding("UTF-8");

		Pedidos_Model pedidoNuevo = null;
		
		long IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
		String Calle = request.getParameter("Calle");
		String N_Int = request.getParameter("N_Int");
		String N_Ext = request.getParameter("N_Ext");
		String Colonia = request.getParameter("Colonia");
		String Estado = request.getParameter("Estado");
		String Municipio = request.getParameter("Municipio");
		String CP = request.getParameter("CP");
		
		String Direccion = 
				  Calle + ", "
				+ N_Int + " - "
				+ N_Ext + ", "
				+ Colonia + ", "				
				+ Municipio + ", "
				+ Estado + ", "
				+ CP;
		
				
		String Telefono = request.getParameter("Telefono");
		String Banco = request.getParameter("Banco");
		String NumCuenta = request.getParameter("NumCuenta");
		
		List<Productos_Model> productosCarrito = (List<Productos_Model>)request.getSession().getAttribute("carritoProductos");
		
		BigDecimal totalPedido = new BigDecimal(0);
			
		BigDecimal cantidadPiezas = null;
			
			
		for(Productos_Model productoAux : productosCarrito) {
			cantidadPiezas = new BigDecimal(productoAux.getCantidadPiezasComprar());
			totalPedido = totalPedido.add( cantidadPiezas.multiply(productoAux.getPrecioFinalProducto()) );
		}
			
		pedidoNuevo = new Pedidos_Model(Direccion, Telefono, Banco, NumCuenta, totalPedido, IdUsuarioActivo);
		
		try {
			PedidosDAO.insertUpdateDeletePedidos("I", pedidoNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		List<Pedidos_Model> listaPedidoAux = null;
		Pedidos_Model pedidoAux = new Pedidos_Model();
		pedidoAux.setUsuarioPedido(IdUsuarioActivo);
		
		try {
			listaPedidoAux = PedidosDAO.getPedidos("NUE", pedidoNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		crearCompras(productosCarrito, listaPedidoAux.get(0).getIdPedido());
		
		request.getSession().setAttribute("carritoProductos", null);
	}

	private void crearCompras(List<Productos_Model> productosCarrito, long idPedido) {
		Compras_Model compraAux = new Compras_Model();

		compraAux.setPedidoCompra(idPedido);
		
		
		
		for (Productos_Model iProducto : productosCarrito) {
			compraAux.setProductoCompra(iProducto.getIdProducto());
			compraAux.setCantidadPiezasCompra(iProducto.getCantidadPiezasComprar());
			compraAux.setPrecioProductoCompra(iProducto.getPrecioFinalProducto());
			
			try {
				ComprasDAO.insertUpdateDeleteCompras("I", compraAux);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
