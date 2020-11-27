package co.ufps.edu.util;

import co.ufps.edu.dao.ClienteDao;
import co.ufps.edu.dao.ServicioDao;
import co.ufps.edu.dao.TiendaDao;
import co.ufps.edu.model.Cliente;
import co.ufps.edu.model.Servicio;
import co.ufps.edu.model.Tienda;

public class Prueba {
	

	
	public static void main(String[] args) {
		
		 ClienteDao clienteDao = new ClienteDao();
		 TiendaDao tiendaDao = new TiendaDao();
		 ServicioDao servicioDao = new ServicioDao();
		 
		 
		Cliente cliente = new Cliente();
		cliente.setNombre("Ivonne Diaz");
		cliente.setEmail("Ivone@gmail.com");
		cliente.setClave("IVones1234");
		clienteDao.insert(cliente);
		
		
		Tienda tienda = new Tienda();
		tienda.setFacebook("www.facebook.com/Helado");
		tienda.setNombre("Helados");
		tienda.setLema("El mas delicioso Helado");
		tienda.setDescripcion("Lo mejores Helados de cucuta");
		tienda.setEmail("Helado@gmail.com");
		tienda.setClave("Helado1234");
		tienda.setPropietario("Ivonne diaz");
		tienda.setWeb("www.Helado.com");
		tienda.setImagen("Helado");
		tiendaDao.insert(tienda);
		
		Servicio servicio = new Servicio();
		servicio.setNombre("Helado a domicilio");
		servicio.setDescripcion("te llega el helado a la puerta de tu casa ");
		servicio.setTiendaBean(tienda);
		servicioDao.insert(servicio);
		

	}

}