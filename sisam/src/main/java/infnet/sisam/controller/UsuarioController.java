package infnet.sisam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import infnet.sisam.model.Usuario;
import infnet.sisam.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/usuario/novo")
	public String novo() {
		return "usuario/novo";
	}
	
	@RequestMapping("/usuario/salvar")
	public String grava(Usuario usuario) {
		usuarioService.salvar(usuario);
		return "usuario/ok";
	}
	
}
