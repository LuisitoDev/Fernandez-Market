package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.models.Productos_Model;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class NavbarSearch
 */
@WebServlet("/NavbarSearch")
public class NavbarSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavbarSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF8"); // this line solves the problem
		response.setContentType("application/json");
		
		List<Productos_Model> listaProductos = getProductos(request, response);
		
		Gson gsonBuild = new GsonBuilder().disableHtmlEscaping().create();
		String json = gsonBuild.toJson(listaProductos);
		
		response.getWriter().write(json);
		
	}
	
	private List<Productos_Model> getProductos(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
		List<Productos_Model> listaProductos = null;
		Productos_Model productoAux = null;


		request.setCharacterEncoding("UTF-8");
		String nombreProducto = request.getParameter("nombreProducto");
		
		int numeroProducto = 0;
		short IdSubcategoriaElegida = 0;
		
		productoAux = new Productos_Model();
		
		
		productoAux.setSubcategoriaProducto(IdSubcategoriaElegida);
		productoAux.setNombreProducto(nombreProducto);
		productoAux.setNumeroProductoPagina(numeroProducto);
		
		try {
			listaProductos = ProductoDAO.getProductos("NAV", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return listaProductos;
	}

}
