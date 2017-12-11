package infnet.sisam.dao;

import infnet.sisam.model.Modulo;

public class ModuloDao extends JpaDao<Modulo> {
	
	public ModuloDao() {
		super(Modulo.class);
	}
}
