package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Permissao;

@Repository
public class PermissaoDao extends JpaDao<Permissao> {

	public PermissaoDao() {
		super(Permissao.class);
	}

}
