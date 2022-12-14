package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.FernandezMarketProject.utils.*;

import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.dao.PromocionDAO;
import com.FernandezMarketProject.dao.SubcategoriasDAO;
import com.FernandezMarketProject.dao.MarcaDAO;
import com.FernandezMarketProject.dao.CategoriasDAO;

import com.FernandezMarketProject.models.Productos_Model;
import com.FernandezMarketProject.models.Promociones_Model;
import com.FernandezMarketProject.models.Subcategorias_Model;
import com.FernandezMarketProject.models.Marcas_Model;
import com.FernandezMarketProject.models.Categorias_Model;

/**
 * Servlet implementation class indexPreguntas
 */
@WebServlet("/IndexPagina")
public class IndexPagina extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public IndexPagina() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		buscarProductosInteres(request, response);
		buscarSubcategorias(request, response);
		buscarProductosMasComprados(request, response);
		buscarMacas(request, response);
		buscarProductosNuevos(request, response);
		buscarPromociones(request, response);
		
		long IdUsuarioActivo = -1;
		if (request.getSession().getAttribute("IdUsuarioActivo") != null)
			IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
		
		
		request.setAttribute("IdUsuarioActivo", IdUsuarioActivo);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	

	private void buscarProductosInteres(HttpServletRequest request, HttpServletResponse response) {
		List<Productos_Model> listaProductosInteres = null;
		
		long IdUsuarioActivo = -1;
		if (request.getSession().getAttribute("IdUsuarioActivo") != null)
			IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
		
		Productos_Model productoAux = new Productos_Model();
		productoAux.setIdUsuario(IdUsuarioActivo);
        
        try {
        	listaProductosInteres = ProductoDAO.getProductos("INT", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaProductosInteres", listaProductosInteres);
	}
	
	private void buscarSubcategorias(HttpServletRequest request, HttpServletResponse response) {
		List<Subcategorias_Model> listaSubcategoria = null;
		
		Subcategorias_Model subcategoriaAux = new Subcategorias_Model();
        
        try {
        	listaSubcategoria = SubcategoriasDAO.getSubcategorias("X", subcategoriaAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaSubcategoria", listaSubcategoria);
	}
	
	private void buscarProductosMasComprados(HttpServletRequest request, HttpServletResponse response) {
		List<Productos_Model> listaProductosMasComprados = null;
		
		Productos_Model productoAux = new Productos_Model();
        
        try {
        	listaProductosMasComprados = ProductoDAO.getProductos("COM", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaProductosMasComprados", listaProductosMasComprados);
        
	}
	
	private void buscarMacas(HttpServletRequest request, HttpServletResponse response) {
		List<Marcas_Model> listaMarcas = null;
		
		Marcas_Model marcaAux = new Marcas_Model();
        
        try {
        	listaMarcas = MarcaDAO.getMarcas("X", marcaAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaMarcas", listaMarcas);
	}
	

	private void buscarProductosNuevos(HttpServletRequest request, HttpServletResponse response) {
		List<Productos_Model> listaProductosNuevos = null;
		
		Productos_Model productoAux = new Productos_Model();
        
        try {
        	listaProductosNuevos = ProductoDAO.getProductos("NUE", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaProductosNuevos", listaProductosNuevos);
	}
	

	private void buscarPromociones(HttpServletRequest request, HttpServletResponse response) {
		List<Promociones_Model> listaPromociones = null;
		
		Promociones_Model promocionAux = new Promociones_Model();
        
        try {
        	listaPromociones = PromocionDAO.getPromociones("X", promocionAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
        
        request.setAttribute("listaPromociones", listaPromociones);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}


}
