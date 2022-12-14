package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.dao.UsuariosDAO;
import com.FernandezMarketProject.models.Pedidos_Model;
import com.FernandezMarketProject.models.Productos_Model;
import com.FernandezMarketProject.models.Usuarios_Model;
import java.math.BigDecimal;

/**
 * Servlet implementation class carritoProductos
 */
@WebServlet("/CarritoProductos")
public class CarritoProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarritoProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		RequestDispatcher dispatcher = null;
		
		
		
		try {
			getCarritoCompra(request, response);
			dispatcher = request.getRequestDispatcher("shoppingCart.jsp");
		} 
		catch(NullPointerException  e) {
			request.setAttribute("error", "Parece que no se encontro la subcategoria que estabas buscando");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} 
		catch(NumberFormatException  e) {
			request.setAttribute("error", "Error en el codigo del producto, asegurate que el codigo contenga solo números");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} 
		catch(Exception  e) { //Error inesperado
			request.setAttribute("error", "Error inesperado");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		finally {
			dispatcher.forward(request, response);
		}
	}

	private void getCarritoCompra(HttpServletRequest request, HttpServletResponse response) {
		List<Productos_Model> productosCarrito = (List<Productos_Model>)request.getSession().getAttribute("carritoProductos");

		request.setAttribute("productosCarrito", productosCarrito);

		BigDecimal totalPedido = new BigDecimal(0);

		BigDecimal cantidadPiezasAux = null;

		BigDecimal cantidadPiezasTotales = new BigDecimal(0);

		if (productosCarrito != null) {
			for (Productos_Model productoAux : productosCarrito) {
				cantidadPiezasAux = new BigDecimal(productoAux.getCantidadPiezasComprar());
				totalPedido = totalPedido.add(cantidadPiezasAux.multiply(productoAux.getPrecioFinalProducto()));
				cantidadPiezasTotales = cantidadPiezasTotales.add(new BigDecimal(productoAux.getCantidadPiezasComprar()));
			}
		}

		request.setAttribute("totalPedido", totalPedido);

		request.setAttribute("cantidadPiezasTotales", cantidadPiezasTotales);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = "";
		
		if (request.getParameter("opcion") != null) {
			opcion = request.getParameter("opcion");
		}
		
		switch(opcion) {
			case "eliminarProductoCarrito":
				eliminarProductoDelCarrito(request, response);
				break;
			
			case "conseguirCantidadStock":
				getCantidadStockProducto(request, response);
				break;
			
			case "cambiarCantidadProductos":
				cambiarCantidadProductos(request, response);
				break;
			
			default:
		}
		
//		doGet(request, response);
	}


	private void eliminarProductoDelCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {

		long IdProducto = 0;

		if (request.getParameter("IdProducto") != null) {
			IdProducto = Long.parseLong(request.getParameter("IdProducto"));
		}
		
		List<Productos_Model> carritoProductos = (List<Productos_Model>)request.getSession().getAttribute("carritoProductos");

		if (carritoProductos != null){
			
			for(int i = 0; i < carritoProductos.size(); i++) {
				if(carritoProductos.get(i).getIdProducto() == IdProducto) {
					carritoProductos.remove(i);
					break;
				}
			}
			
			request.getSession().setAttribute("carritoProductos", carritoProductos);
			
			
			BigDecimal totalPedido = new BigDecimal(0);
			BigDecimal cantidadPiezas = null;
			BigDecimal cantidadPiezasTotales = new BigDecimal(0);

			if (carritoProductos != null) {
				for (Productos_Model productoAux : carritoProductos) {
					cantidadPiezas = new BigDecimal(productoAux.getCantidadPiezasComprar());
					totalPedido = totalPedido.add(cantidadPiezas.multiply(productoAux.getPrecioFinalProducto()));
					cantidadPiezasTotales = cantidadPiezasTotales.add(new BigDecimal(productoAux.getCantidadPiezasComprar()));
				}
			}
			
			response.getWriter().print(totalPedido + "," + cantidadPiezasTotales);
			
		
		}
		
	}


	private void cambiarCantidadProductos(HttpServletRequest request, HttpServletResponse response) throws IOException {
		long IdProducto = 0;

		if (request.getParameter("IdProducto") != null) {
			IdProducto = Long.parseLong(request.getParameter("IdProducto"));
		}
		
		Productos_Model productoElegido = getProducto(request, response);
		
		short CantidadPiezas = 0;
		if (request.getParameter("CantidadPiezas") != null) {
			CantidadPiezas = Short.parseShort(request.getParameter("CantidadPiezas"));
		}
		
		
		if (CantidadPiezas < 1)
			CantidadPiezas = 1;
		if (CantidadPiezas > productoElegido.getCantidadStockProducto())
			CantidadPiezas = (short)productoElegido.getCantidadStockProducto();
			
		List<Productos_Model> carritoProductos = (List<Productos_Model>)request.getSession().getAttribute("carritoProductos");

		if (carritoProductos != null){
			
			for(int i = 0; i < carritoProductos.size(); i++) {
				if(carritoProductos.get(i).getIdProducto() == IdProducto) {
					carritoProductos.get(i).setCantidadPiezasComprar(CantidadPiezas);
					break;
				}
			}
			
			request.getSession().setAttribute("carritoProductos", carritoProductos);
			
			
			BigDecimal precioFinal = productoElegido.getPrecioFinalProducto();
			BigDecimal cantidadPiezas = new BigDecimal(CantidadPiezas); 
			BigDecimal precioFinalPorPiezas = precioFinal.multiply(cantidadPiezas);
			
			BigDecimal totalPedido = new BigDecimal(0);
			BigDecimal cantidadPiezasAux = null;
			BigDecimal cantidadPiezasTotales = new BigDecimal(0);

			if (carritoProductos != null) {
				for (Productos_Model productoAux : carritoProductos) {
					cantidadPiezasAux = new BigDecimal(productoAux.getCantidadPiezasComprar());
					totalPedido = totalPedido.add(cantidadPiezasAux.multiply(productoAux.getPrecioFinalProducto()));
					cantidadPiezasTotales = cantidadPiezasTotales.add(new BigDecimal(productoAux.getCantidadPiezasComprar()));
				}
			}
			
			response.getWriter().print(CantidadPiezas + "," +precioFinalPorPiezas + "," + totalPedido + "," + cantidadPiezasTotales);
			
		}
	}

	private void getCantidadStockProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Productos_Model productoElegido = getProducto(request, response);
		
		response.getWriter().print(productoElegido.getCantidadStockProducto());
	}

	
	
	private Productos_Model getProducto(HttpServletRequest request, HttpServletResponse response) {
		Productos_Model productoElegido = null;
		
		List<Productos_Model> listaProductosAux = null;
		Productos_Model productoAux = null;

		long IdProducto = 0;

		if (request.getParameter("IdProducto") != null) {
			IdProducto = Long.parseLong(request.getParameter("IdProducto"));
		}

		productoAux = new Productos_Model(IdProducto);

		try {
			listaProductosAux = ProductoDAO.getProductos("DP", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (listaProductosAux.size() > 0) {
			productoElegido = listaProductosAux.get(0);

		}
		
		return productoElegido;
	}

}
