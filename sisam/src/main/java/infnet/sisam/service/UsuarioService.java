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
		return usuarioDao.findAll();
	}

	public void atualizar(Usuario usuario, String oldPassword) {
		
		//TODO MARRETA
		oldPassword = oldPassword.substring(1);
		
		if(!oldPassword.equals(usuario.getSenha())) {
			codificarPassword(usuario);
		}
		usuarioDao.atualizar(usuario);
	}

	public Usuario buscar(Integer id) {
		return usuarioDao.buscar(id);
	}
	
	public void remover(Integer id) {
		usuarioDao.excluir(usuarioDao.buscar(id));
	}
	
	private void codificarPassword(Usuario usuario) {
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
	}

}
