package co.ufps.edu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.model.Tienda;

/**
 * Servlet implementation class indexController
 */
@WebServlet("/")
public class indexController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		index(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	private void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TiendaDao tiendaDao=new TiendaDao();
		List <Tienda> tiendas = tiendaDao.list();;
		request.getSession().setAttribute("tiendas", tiendas);	
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
