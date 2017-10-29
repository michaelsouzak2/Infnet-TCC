package infnet.sisam.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.UsuarioDao;
import infnet.sisam.model.Usuario;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	private UsuarioDao usuarioDao;

	public void salvar(Usuario usuario) {
		usuarioDao.salvar(usuario);
	}

}
