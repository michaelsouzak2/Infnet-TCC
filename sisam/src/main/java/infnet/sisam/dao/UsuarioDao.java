package infnet.sisam.dao;

import infnet.sisam.model.Usuario;

public class UsuarioDao extends JpaDao<Usuario> {

	public UsuarioDao() {
		super(Usuario.class);
	}

}
