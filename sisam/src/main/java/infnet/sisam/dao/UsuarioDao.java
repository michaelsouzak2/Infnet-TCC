package infnet.sisam.dao;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import infnet.sisam.model.Usuario;

@Repository
public class UsuarioDao extends JpaDao<Usuario> implements UserDetailsService {

	public UsuarioDao() {
		super(Usuario.class);
	}

	@Override
	public Usuario loadUserByUsername(String email) throws UsernameNotFoundException {
		List<Usuario> usuarios = em.createQuery("select u from Usuario u where u.email = :email", Usuario.class)
				.setParameter("email", email).getResultList();

		if (usuarios.isEmpty()) {
			throw new UsernameNotFoundException("Usuário " + email + " não foi encontrado.");
		}

		return usuarios.get(0);
	}

}
