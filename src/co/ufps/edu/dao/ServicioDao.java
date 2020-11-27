package co.ufps.edu.dao;
import co.ufps.edu.model.Servicio;
import co.ufps.edu.util.Conexion;
public class ServicioDao extends Conexion <Servicio> implements GenericDao<Servicio> {
	
	public ServicioDao() {
		super(Servicio.class);
		
	}

}
