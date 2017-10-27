package infnet.sisam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import infnet.sisam.dao.UsuarioDao;
import infnet.sisam.model.Usuario;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	@RequestMapping("/usuario/novo")
	public String novo() {
		return "usuario/novo";
	}
	
	@RequestMapping("/usuario/salvar")
	public String grava(Usuario usuario) {
		usuarioDao.salvar(usuario);
		return "usuario/ok";
	}
	
}
