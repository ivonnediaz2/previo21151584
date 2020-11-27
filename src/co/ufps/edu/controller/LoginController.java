package co.ufps.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.dao.ClienteDao;
import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.model.Cliente;
import co.ufps.edu.model.Tienda;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TiendaDao tiendaDao=new TiendaDao();
		ClienteDao clienteDao=new ClienteDao();
		
		
		Cliente cliente = clienteDao.findByField("email", request.getParameter("email"));
		if (cliente != null) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		Tienda tienda  = tiendaDao.findByField("email", request.getParameter("email"));
		if (tienda != null) {
			if(tienda.getClave().equals(request.getParameter("pass"))) {
				request.getSession().setAttribute("nombredetienda", tienda.getNombre());
				request.getSession().setAttribute("mensajeservicios", tienda.getServicios().size() > 0 ? "" : "se encuentran servicios registrados");
				request.getSession().setAttribute("servicios", tienda.getServicios());
				request.getRequestDispatcher("servicios.jsp").forward(request, response);
				return;
			}
			
		}
		List <Tienda> tiendas = tiendaDao.list();;
		request.getSession().setAttribute("tiendas", tiendas);	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
