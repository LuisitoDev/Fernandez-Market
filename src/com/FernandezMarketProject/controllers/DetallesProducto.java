package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.models.Productos_Model;

/**
 * Servlet implementation class DetallesProducto
 */
@WebServlet("/DetallesProducto")
public class DetallesProducto extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetallesProducto() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = null;
		try {
			boolean existeProducto = getDetallesProducto(request, response);
			
			if (existeProducto == true)
				dispatcher = request.getRequestDispatcher("product.jsp");
			else {
				request.setAttribute("error", "Parece que no se encontro el producto que estabas buscando");
				dispatcher = request.getRequestDispatcher("error.jsp");
			}
			
		} catch(NullPointerException  e) {
			request.setAttribute("error", "Parece que no se encontro el producto que estabas buscando");
			dispatcher = request.getRequestDispatcher("error.jsp");
			
		} catch(NumberFormatException  e) {
			request.setAttribute("error", "Error en el codigo del producto, asegurate que el codigo contenga solo numeros");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} catch(Exception  e) { //Error inesperado
			request.setAttribute("error", "Error inesperado");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		finally {
			dispatcher.forward(request, response);
		}
		
	}
	
	private boolean getDetallesProducto(HttpServletRequest request, HttpServletResponse response) {
		boolean existeProducto = false;
		
		Productos_Model productoElegido = getProducto(request, response);
		
		if (productoElegido != null ) {
			request.setAttribute("productoElegido", productoElegido);
			getListaProductosRelacionados(productoElegido, request, response);
			existeProducto = true;
		}
		else {	
			existeProducto = false;
		}
		
		return existeProducto;
		
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

	private void getListaProductosRelacionados(Productos_Model productoElegido, HttpServletRequest request,
			HttpServletResponse response) {
		List<Productos_Model> listaProductosRelacionados = null;
				        
        try {
        	listaProductosRelacionados = ProductoDAO.getProductos("REL", productoElegido);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaProductosRelacionados", listaProductosRelacionados);
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
			case "ingresarProducto":
				ingresarProductosAlCarrito(request, response);
				break;
			
			case "conseguirProducto":
				getWriterProducto(request, response);
				break;
			
			case "cambiarCantidadProductos":
				cambiarCantidadProductos(request, response);
				break;
			
			default:
		}
		

		//doGet(request, response);
		// Retroalimentacion de que los productos se agregaron correctamente y que se aumento el carrito de productos

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
			
		response.getWriter().print(CantidadPiezas);
	}

	private void ingresarProductosAlCarrito(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Productos_Model productoElegido = getProducto(request, response);

		short cantidadPiezas = Short.valueOf(request.getParameter("cantidadPiezas"));
		productoElegido.setCantidadPiezasComprar(cantidadPiezas);
		
		List<Productos_Model> carritoProductos = (List<Productos_Model>)request.getSession().getAttribute("carritoProductos");

		if (carritoProductos == null){
			carritoProductos = new ArrayList<Productos_Model>();
		}
		
		boolean productoRepetido = false;
		for(int i = 0; i < carritoProductos.size(); i++) {
			if(carritoProductos.get(i).getIdProducto() == productoElegido.getIdProducto()) {
				carritoProductos.get(i).setCantidadPiezasComprar(cantidadPiezas);
				productoRepetido = true;
				break;
			}
		}
		
		if (!productoRepetido) {
			carritoProductos.add(productoElegido);
		}
		
		request.getSession().setAttribute("carritoProductos", carritoProductos);
		
		response.getWriter().print(productoRepetido);
		
	}

	private void getWriterProducto(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Productos_Model productoElegido = getProducto(request, response);
		
		response.getWriter().print(productoElegido);
	}
	
	private void cambiarCantidadPiezas() {
		
	}
}
