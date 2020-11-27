package co.ufps.edu.dao;

import co.ufps.edu.util.Conexion;
import co.ufps.edu.model.Cliente;

public class ClienteDao extends Conexion<Cliente> implements GenericDao<Cliente> {

	public ClienteDao() {
		super(Cliente.class);
	}
}
