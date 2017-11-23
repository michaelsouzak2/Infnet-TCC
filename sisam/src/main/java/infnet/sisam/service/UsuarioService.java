package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.UsuarioDao;
import infnet.sisam.model.Usuario;

@Service
@Transactional
public class UsuarioService {

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public void salvar(Usuario usuario) {
		codificarPassword(usuario);
		usuarioDao.salvar(usuario);
	}

	public List<Usuario> listar() {
		return usuarioDao.listar();
	}

	public void atualizar(Usuario usuario, String newPassword) {
		if(!newPassword.equals(usuario.getSenha())) {
			usuario.setSenha(newPassword);
			codificarPassword(usuario);
		}
		usuarioDao.atualizar(usuario);
	}

	public Usuario buscar(Integer id) {
		return usuarioDao.buscar(id);
	}

	private void codificarPassword(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	}

}
