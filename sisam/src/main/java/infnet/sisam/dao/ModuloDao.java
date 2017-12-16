package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Modulo;

@Repository
public class ModuloDao extends JpaDao<Modulo> {
	
	public ModuloDao() {
		super(Modulo.class);
	}
	
	public List<Modulo> listar() {
		return em.createQuery("select u from Modulo u", Modulo.class).getResultList();
	}	
}
