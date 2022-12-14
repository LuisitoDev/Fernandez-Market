package com.FernandezMarketProject.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.FernandezMarketProject.dao.CategoriasDAO;
import com.FernandezMarketProject.dao.MarcaDAO;
import com.FernandezMarketProject.dao.ProductoDAO;
import com.FernandezMarketProject.dao.PromocionDAO;
import com.FernandezMarketProject.dao.SubcategoriasDAO;
import com.FernandezMarketProject.dao.UsuariosDAO;
import com.FernandezMarketProject.models.Categorias_Model;
import com.FernandezMarketProject.models.Marcas_Model;
import com.FernandezMarketProject.models.Productos_Model;
import com.FernandezMarketProject.models.Promociones_Model;
import com.FernandezMarketProject.models.Subcategorias_Model;
import com.FernandezMarketProject.models.Usuarios_Model;

/**
 * Servlet implementation class generalServlet
 */
@WebServlet("/GeneralServlet")
public class GeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GeneralServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String Imagen = request.getParameter("Imagen");
		switch(Imagen) {
		case "Categoria":
			getCategoriaImagen(request, response);
			break;
			
		case "Subcategoria":
			getSubcategoriaImagen(request, response);
			break;
			
		case "Marca":
			getMarcaImagen(request, response);
			break;
			
		case "Producto":
			getProductoImagen(request, response);
			
			break;
		case "Promocion":
			getPromocionImagen(request, response);
			
			break;
			
			
		default:			
//			404 Not Found
		
		}
		
	}

	private void getCategoriaImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String imageName = "categoria.png"; // Returns "foo.png".
		List<Categorias_Model> categoriaElegido = null;

		byte IdCategoria = Byte.parseByte(request.getParameter("Id"));
		Categorias_Model categoriaAux = new Categorias_Model(IdCategoria);
		
		try {
			categoriaElegido = CategoriasDAO.getCategorias("S", categoriaAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (categoriaElegido.size() != 0) {
			if (categoriaElegido.get(0).getImagenCategoria() != null) {
				byte[] content = categoriaElegido.get(0).getImagenCategoria().readAllBytes();

				response.setContentType(getServletContext().getMimeType(imageName));
				response.setContentLength(content.length);
				response.getOutputStream().write(content);
			} 

		}
	}
	
	private void getSubcategoriaImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String imageName = "subcategoria.png"; // Returns "foo.png".
		List<Subcategorias_Model> subcategoriaElegido = null;

		short IdSubcategoria = Byte.parseByte(request.getParameter("Id"));
		Subcategorias_Model subcategoriaAux = new Subcategorias_Model(IdSubcategoria);
		
		try {
			subcategoriaElegido = SubcategoriasDAO.getSubcategorias("S", subcategoriaAux);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (subcategoriaElegido.size() != 0) {
			
			
			if (subcategoriaElegido.get(0).getImagenSubcategoria() != null) {
				byte[] content = subcategoriaElegido.get(0).getImagenSubcategoria().readAllBytes();

				response.setContentType(getServletContext().getMimeType(imageName));
				response.setContentLength(content.length);
				response.getOutputStream().write(content);
			} 

		}
	}
	
	
	private void getMarcaImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String imageName = "marca.png"; // Returns "foo.png".
		List<Marcas_Model> marcaElegida = null;
		

		int IdMarca = Integer.valueOf(request.getParameter("Id"));
		Marcas_Model marcaAux = new Marcas_Model(IdMarca);
		
		try {
			marcaElegida = MarcaDAO.getMarcas("S", marcaAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (marcaElegida.size() != 0) {
			if (marcaElegida.get(0).getImagenMarca() != null) {

				byte[] content = marcaElegida.get(0).getImagenMarca().readAllBytes();

				response.setContentType(getServletContext().getMimeType(imageName));
				response.setContentLength(content.length);
				response.getOutputStream().write(content);
			} 
		}
	}
	
	
	private void getProductoImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String imageName = "producto.png"; // Returns "foo.png".

		List<Productos_Model> productoElegido = null;

		long IdProducto = Long.parseLong(request.getParameter("Id"));
		Productos_Model productoAux = new Productos_Model(IdProducto);
		
		
		try {
			productoElegido = ProductoDAO.getProductos("S", productoAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (productoElegido.size() != 0) {
			if (productoElegido.get(0).getImagenProducto() != null) {

				byte[] content = productoElegido.get(0).getImagenProducto().readAllBytes();

				response.setContentType(getServletContext().getMimeType(imageName));
				response.setContentLength(content.length);
				response.getOutputStream().write(content);
			} 

		}
	}
	

	private void getPromocionImagen(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String imageName = "producto.png"; // Returns "foo.png".

		List<Promociones_Model> promocionElegida = null;

		int IdPromocion = Integer.parseInt(request.getParameter("Id"));
		Promociones_Model promocionAux = new Promociones_Model(IdPromocion);
		
		
		try {
			promocionElegida = PromocionDAO.getPromociones("S", promocionAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (promocionElegida.size() != 0) {
			if (promocionElegida.get(0).getImagenPromocion() != null) {

				byte[] content = promocionElegida.get(0).getImagenPromocion().readAllBytes();

				response.setContentType(getServletContext().getMimeType(imageName));
				response.setContentLength(content.length);
				response.getOutputStream().write(content);
			} 

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

	}
	
	public static Usuarios_Model getUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Usuarios_Model> usuarioElegido = null;
		Usuarios_Model usuarioAux = null;

		if (request.getSession().getAttribute("IdUsuarioActivo") != null) {
			long IdUsuarioActivo = (Long) request.getSession().getAttribute("IdUsuarioActivo");
			
			usuarioAux = new Usuarios_Model(IdUsuarioActivo);		
			
			try {
				usuarioElegido = UsuariosDAO.getUsuarios("S", usuarioAux);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (usuarioElegido != null)
			return usuarioElegido.get(0);
		else
			return null;
		
	}
	
	public static List<Subcategorias_Model>getSubcategorias() {
		List<Subcategorias_Model> listaSubcategorias = null;
		Subcategorias_Model subcatAux = new Subcategorias_Model();

		try {
			listaSubcategorias = SubcategoriasDAO.getSubcategorias("X", subcatAux);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return  listaSubcategorias;
	}

	public static int getCantidadProductosCarrito(HttpServletRequest request, HttpServletResponse response) {
		int cantidadProductosCarrito = 0;
		
		List<Productos_Model> listaProductosCarrito = (List<Productos_Model>)request.getSession().getAttribute("carritoProductos");
		
		if (listaProductosCarrito != null)
			cantidadProductosCarrito = listaProductosCarrito.size();
		
		return cantidadProductosCarrito;
	}
	
}
