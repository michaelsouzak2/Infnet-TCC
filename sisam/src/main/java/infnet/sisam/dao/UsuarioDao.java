package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Usuario;

@Repository
public class UsuarioDao extends JpaDao<Usuario> {
	
//	@PersistenceContext
//	protected EntityManager em;
	
//	public void salvar(Usuario entity) {
//		em.persist(entity);
//	}
	
	public UsuarioDao() {
		super(Usuario.class);
	}

}
