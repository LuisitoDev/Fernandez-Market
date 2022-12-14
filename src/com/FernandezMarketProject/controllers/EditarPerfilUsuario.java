package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.FernandezMarketProject.dao.UsuariosDAO;
import com.FernandezMarketProject.models.Usuarios_Model;

/**
 * Servlet implementation class EditarPerfilUsuario
 */
@WebServlet("/EditarPerfilUsuario")
public class EditarPerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getUsuario(request, response);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("editUser.jsp");
		dispatcher.forward(request, response);
	}

	private void getUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuarios_Model> usuarioElegido = null;
		Usuarios_Model usuarioAux = null;

		long IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
		usuarioAux = new Usuarios_Model(IdUsuarioActivo);
		
		try {
			usuarioElegido = UsuariosDAO.getUsuarios("S", usuarioAux);
		} catch (Exception e) {
			
		}
		
		request.setAttribute("usuarioElegido", usuarioElegido.get(0)); 
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		actualizarUsuario(request, response);
		response.sendRedirect("PerfilUsuario");

	}
	
	
	private void actualizarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Usuarios_Model usuarioNuevo = null;

		long IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
		String NombreUsuario = request.getParameter("nombre");
		String ApellidoPaternoUsuario = request.getParameter("apellidoP");
		String ApellidoMaternoUsuario = request.getParameter("apellidoM");

		String PasswordUsuario = request.getParameter("password");

		// Agregamos el usuario a la lista
		usuarioNuevo = new Usuarios_Model(IdUsuarioActivo, NombreUsuario, ApellidoPaternoUsuario, ApellidoMaternoUsuario, PasswordUsuario);

		try {
			UsuariosDAO.insertUpdateDeleteUsuario("U", usuarioNuevo);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
