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

import com.FernandezMarketProject.dao.UsuariosDAO;
import com.FernandezMarketProject.models.Usuarios_Model;
import com.FernandezMarketProject.utils.SendMail;

/**
 * Servlet implementation class LoginUsuario
 */
@WebServlet("/LoginUsuario")
public class LoginUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opcion = request.getParameter("opcion");
		
		
		switch (opcion) {
		case "login": {
			
			
			String usuarioPedido = request.getParameter("usuarioPedido");
			request.getSession().setAttribute("usuarioPedido", usuarioPedido);
			
			response.sendRedirect("login.jsp");
			
			
			break;
		}
		case "logout": {
			request.getSession().setAttribute("IdUsuarioActivo", null);
			response.sendRedirect("IndexPagina");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + opcion);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Usuarios_Model> listaUsuarios = buscarUsuario(request, response);

		if (listaUsuarios.isEmpty() == false) {
			        
			
			request.getSession().setAttribute("IdUsuarioActivo", listaUsuarios.get(0).getIdUsuario());

			String usuarioPedido = (String)request.getSession().getAttribute("usuarioPedido");
			
			
			if (usuarioPedido == null)
				response.sendRedirect("IndexPagina");
			else
				response.sendRedirect("CrearPedido");

		} else {
			request.setAttribute("usuarioIncorrecto", "true");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		     
	}
	
	private List<Usuarios_Model> buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");		
		List<Usuarios_Model> listaUsuarios = null;
		
		Usuarios_Model usuarioElegido = null;
        
        String CorreoUsuario = request.getParameter("email");
        String PasswordUsuario = request.getParameter("password");
       
        // Agregamos el usuario a la lista
        usuarioElegido = new Usuarios_Model(CorreoUsuario, PasswordUsuario);
        
        try {
        	 listaUsuarios = UsuariosDAO.getUsuarios("L",usuarioElegido);
		} catch (Exception e) {
			e.printStackTrace();
		}

        return listaUsuarios;
	}

}
