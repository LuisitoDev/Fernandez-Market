package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FernandezMarketProject.dao.PedidosDAO;
import com.FernandezMarketProject.dao.UsuariosDAO;
import com.FernandezMarketProject.models.Pedidos_Model;
import com.FernandezMarketProject.models.Usuarios_Model;

/**
 * Servlet implementation class PerfilUsuario
 */
@WebServlet("/PerfilUsuario")
public class PerfilUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PerfilUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = null;
		try {
			
			getUsuario(request, response);
			dispatcher = request.getRequestDispatcher("profileUser.jsp");		
			
		} catch(IndexOutOfBoundsException e) {
			request.setAttribute("error", "¡Parece que el perfil de este usuario no existe!");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} catch(NumberFormatException e) {
			request.setAttribute("error", "Los perfiles no se buscan con caracteres, ten cuidado");
			dispatcher = request.getRequestDispatcher("error.jsp");
		} catch(Exception e) {
			request.setAttribute("error", "Error inesperado");
			dispatcher = request.getRequestDispatcher("error.jsp");
		}
		finally {
			dispatcher.forward(request, response);
		}
		
	}

	private void getUsuario(HttpServletRequest request, HttpServletResponse response) {
		List<Usuarios_Model> usuarioElegido = null;
		
		long IdUsuarioActivo = (Long)request.getSession().getAttribute("IdUsuarioActivo");
		Usuarios_Model usuarioAux = new Usuarios_Model(IdUsuarioActivo);
		
		try {
			usuarioElegido = UsuariosDAO.getUsuarios("S", usuarioAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("usuarioElegido", usuarioElegido.get(0));
		getPedidos(IdUsuarioActivo, request, response);
	}
	
	private void getPedidos(long IdUsuarioActivo, HttpServletRequest request, HttpServletResponse response) {
		List<Pedidos_Model> listaPedidos = null;
		Pedidos_Model pedidoAux = new Pedidos_Model();
		
		pedidoAux.setUsuarioPedido(IdUsuarioActivo);
		
		try {
			listaPedidos = PedidosDAO.getPedidos("USP", pedidoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		request.setAttribute("listaPedidos", listaPedidos);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
