package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Modulo;

@Repository
public class ModuloDao extends JpaDao<Modulo> {
	
	public ModuloDao() {
		super(Modulo.class);
	}
}
