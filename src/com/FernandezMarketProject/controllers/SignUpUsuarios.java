package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.FernandezMarketProject.dao.UsuariosDAO;
import com.FernandezMarketProject.models.Usuarios_Model;
import com.FernandezMarketProject.utils.SendMail;

/**
 * Servlet implementation class SignUpUsuarios
 */
@WebServlet("/SignUpUsuarios")
public class SignUpUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUpUsuarios() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean usuarioRepetido = verificarEmail(request, response);
		if (usuarioRepetido == true) {
			request.setAttribute("emailEncontrado", "true");
			RequestDispatcher dispatcher = request.getRequestDispatcher("signUp.jsp");
			dispatcher.forward(request, response);
		} 
		else if (usuarioRepetido == false) {
			try {
				insertarUsuario(request, response);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (MessagingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("login.jsp");
		}
	}

	private boolean verificarEmail(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		boolean isUsuarioRepetido = false;
		List<Usuarios_Model> usernameEncontrado = null;
		String Email = request.getParameter("email");
		
		Usuarios_Model usuarioNuevo = new Usuarios_Model();
		usuarioNuevo.setCorreoUsuario(Email);
		
		try {
			usernameEncontrado = UsuariosDAO.getUsuarios("V", usuarioNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (usernameEncontrado.isEmpty()) {
			isUsuarioRepetido = false;
		}
		else {
			isUsuarioRepetido = true;
		}
		
		return isUsuarioRepetido;
	}

	private void insertarUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, MessagingException {

		request.setCharacterEncoding("UTF-8");
		Usuarios_Model usuarioNuevo = null;

		String NombreUsuario = request.getParameter("nombre");
		String ApellidoPaternoUsuario = request.getParameter("apellidoP");
		String ApellidoMaternoUsuario = request.getParameter("apellidoM");

		
		String CorreoUsuario = request.getParameter("email");
		String PasswordUsuario = request.getParameter("password");

		// Agregamos el usuario a la lista
		usuarioNuevo = new Usuarios_Model(NombreUsuario, ApellidoPaternoUsuario, ApellidoMaternoUsuario,
									CorreoUsuario, PasswordUsuario);

		try {
			UsuariosDAO.insertUpdateDeleteUsuario("I", usuarioNuevo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		SendMail.mandarCorreo(CorreoUsuario);

	}

}
