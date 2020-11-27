package co.ufps.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.model.Tienda;

/**
 * Servlet implementation class TiendaController
 */
@WebServlet("/Tienda")
public class TiendaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TiendaController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action = request.getParameter("action");
		
		switch(action) {
		case "delete":
			eliminarTienda(request, response);
			break;
		
		case "update":
			actualizarTienda(request, response);
			
			break;
		case "new":
			showNewForm(request, response);
			break;
		case "insert":
			insertarTienda(request, response);
			break;
		
		
		default:
			index(request,response);	
				
		}
	}

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String path = request.getServletPath();
			String action = request.getParameter("action");
			switch (action) {
			case "insert":
				insertarTienda(request, response);
				break;
			default:
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}
	

	private void actualizarTienda(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void eliminarTienda(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void insertarTienda(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TiendaDao tiendaDao=new TiendaDao();
		Tienda tienda= new Tienda();
		tienda.setNombre(request.getParameter("nombre"));
		tienda.setPropietario(request.getParameter("propietario"));
		tienda.setWeb(request.getParameter("web"));
		tienda.setClave(request.getParameter("pass"));
		tienda.setDescripcion(request.getParameter("descripcion"));
		tienda.setEmail(request.getParameter("email"));
		tienda.setFacebook(request.getParameter("facebook"));
		tienda.setImagen(request.getParameter("imagen"));
		tienda.setLema(request.getParameter("lema"));
		
		
		Tienda tiendaDB = tiendaDao.findByField("email", tienda.getEmail());
		if (tiendaDB == null) {
			tiendaDao.insert(tienda);
			request.getRequestDispatcher("login.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registro.jsp");
		dispatcher.forward(request, response);
	}
	
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TiendaDao tiendaDao=new TiendaDao();
		List <Tienda> listatienda = tiendaDao.list();;
		request.getSession().setAttribute("listatienda", listatienda);	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	

}
