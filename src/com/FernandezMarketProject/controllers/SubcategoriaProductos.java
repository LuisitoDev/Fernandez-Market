package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.dao.SubcategoriasDAO;
import com.FernandezMarketProject.models.Productos_Model;
import com.FernandezMarketProject.models.Subcategorias_Model;

/**
 * Servlet implementation class SubcategoriaProductos
 */
@WebServlet("/SubcategoriaProductos")
public class SubcategoriaProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubcategoriaProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		
		try {
			
			
			
			boolean existeSubcategoria = getListaSubcategorias(request, response);
			if (existeSubcategoria == true)
				dispatcher = request.getRequestDispatcher("subcategoryProducts.jsp");
			else {
				request.setAttribute("error", "Parece que no se encontro la subcategoria que estabas buscando");
				dispatcher = request.getRequestDispatcher("error.jsp");
			}
		} catch(NullPointerException  e) {
			request.setAttribute("error", "Parece que no se encontro la subcategoria que estabas buscando");
			dispatcher = request.getRequestDispatcher("error.jsp");
			
		} catch(NumberFormatException  e) {
			request.setAttribute("error", "Error en el codigo, asegurate que el codigo contenga solo numeros");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} catch(Exception  e) { //Error inesperado
			request.setAttribute("error", "Error inesperado");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		finally {
			dispatcher.forward(request, response);
		}
		
	}
	

	private boolean getListaSubcategorias(HttpServletRequest request, HttpServletResponse response) {
		boolean existeSubcategoria = false;
		
		List<Subcategorias_Model> listaSubcategorias = null;
		Subcategorias_Model subcategoriaElegida = new Subcategorias_Model();
	       
        try {
        	listaSubcategorias = SubcategoriasDAO.getSubcategorias("X", subcategoriaElegida);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        short IdSubcategoriaElegida = 0;

		if (request.getParameter("IdSubcategoria") != null) {
			IdSubcategoriaElegida = Short.parseShort(request.getParameter("IdSubcategoria"));
			
			if (IdSubcategoriaElegida == 0) {
				existeSubcategoria = true;
			}
			else {
				for(Subcategorias_Model subAux: listaSubcategorias) {
					
		        	if (IdSubcategoriaElegida == subAux.getIdSubcategoria()) {
		        		request.setAttribute("subcategoriaElegida", subAux);
		        		existeSubcategoria = true;
		        		break;
		        	}
		        } 
			}
			
			
			if (existeSubcategoria == true) {
				request.setAttribute("listaSubcategorias", listaSubcategorias);
				getProductoSubcategoriaElegida(IdSubcategoriaElegida, request, response);
			}
			 
		}
		

		 return existeSubcategoria;
	}
	
	private void getProductoSubcategoriaElegida(short IdSubcategoriaElegida, HttpServletRequest request, HttpServletResponse response) {
		List<Productos_Model> listaProductos = null;
		Productos_Model productoAux = null;

		int numeroProducto = 0;
		int numeroPagina = 1;
		if (request.getParameter("numeroPagina") != null) {
			numeroPagina = Integer.valueOf(request.getParameter("numeroPagina"));
			if (numeroPagina <= 0)
				numeroPagina = 1;
				
			request.setAttribute("numeroPagina", numeroPagina);
			numeroProducto = 12 * (numeroPagina - 1);
		}
		
		//request.setCharacterEncoding("UTF-8");
		String nombreProducto = request.getParameter("nombreProducto");
        request.setAttribute("nombreProducto", nombreProducto);
		
		
		productoAux = new Productos_Model();
		
		
		productoAux.setSubcategoriaProducto(IdSubcategoriaElegida);
		productoAux.setNombreProducto(nombreProducto);
		productoAux.setNumeroProductoPagina(numeroProducto);
		
		try {
			listaProductos = ProductoDAO.getProductos("BPS", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listaProductos", listaProductos);
		
		if (nombreProducto != null) {
			nombreProducto = "&nombreProducto=" + nombreProducto;
		}
		request.setAttribute("nombreProductoQuery", nombreProducto);
		
		getCantidadProductosSubcategoria(numeroPagina, IdSubcategoriaElegida, request, response);
	}

	private void getCantidadProductosSubcategoria(int numeroPagina, short IdSubcategoriaElegida, HttpServletRequest request, HttpServletResponse response) {
		List<Subcategorias_Model> listaSubcategoriasAux = null;
		Subcategorias_Model subcategoriaAux = new Subcategorias_Model(IdSubcategoriaElegida);
		String nombreProducto = request.getParameter("nombreProducto");
		subcategoriaAux.setNombreProducto(nombreProducto);
		
        try {
        	listaSubcategoriasAux = SubcategoriasDAO.getSubcategorias("CPR", subcategoriaAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        short CantidadProductos = 0;
        
        if (listaSubcategoriasAux.size() > 0)
        	CantidadProductos = listaSubcategoriasAux.get(0).getCantidadProductos();
        
        int idBoton = 0;
        int paginaFinal = CantidadProductos/12;
        
        if (CantidadProductos % 12 != 0)
        	paginaFinal+=1; 
        
        int CantidadBotones = 4;
        
        if (CantidadBotones > paginaFinal) {
        	CantidadBotones = paginaFinal;

        }
        
        if ((numeroPagina + CantidadBotones - 1) >= paginaFinal) {
        	idBoton = paginaFinal - CantidadBotones + 1;
    	}
        else {
        	idBoton = numeroPagina;
        }
        
        
        request.setAttribute("paginaFinal", paginaFinal);
        request.setAttribute("idBoton", idBoton);
        request.setAttribute("CantidadBotones", CantidadBotones);
        request.setAttribute("numeroPagina", numeroPagina);
        
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
