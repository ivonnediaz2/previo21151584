package co.ufps.edu.dao;
import co.ufps.edu.model.Tienda;
import co.ufps.edu.util.Conexion;

public class TiendaDao extends Conexion <Tienda> implements GenericDao<Tienda> {
	
	public TiendaDao() {
		super(Tienda.class);
	}

}
