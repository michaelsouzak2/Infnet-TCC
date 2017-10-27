package infnet.sisam.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.model.Usuario;

@Repository
@Transactional
public class UsuarioDao {//extends JpaDao<Usuario> {

	@PersistenceContext
	protected EntityManager em;
	
	
	public void salvar(Usuario u) {
		em.persist(u.getPerfil());
		em.persist(u);
}

//	public UsuarioDao() {
//		super(Usuario.class);
//	}

}
