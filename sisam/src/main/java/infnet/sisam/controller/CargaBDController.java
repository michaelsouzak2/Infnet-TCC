package infnet.sisam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import infnet.sisam.enumeration.PermissaoEnum;
import infnet.sisam.model.Permissao;
import infnet.sisam.model.Usuario;
import infnet.sisam.service.PermissaoService;
import infnet.sisam.service.UsuarioService;

@RequestMapping
public class CargaBDController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PermissaoService permissaoService;
	
	@ResponseBody
	@RequestMapping("/executarcargainicial")
	public String cargaInicialBD() {
		
		Permissao roleAdmin = new Permissao();
		roleAdmin.setId(1);
		roleAdmin.setNome(PermissaoEnum.ROLE_ADMINISTRADOR);
		permissaoService.salvar(roleAdmin);
		
		Permissao roleSec = new Permissao();
		roleSec.setId(2);
		roleSec.setNome(PermissaoEnum.ROLE_SECRETARIA);
		permissaoService.salvar(roleSec);
		
		Permissao roleAluno = new Permissao();
		roleAluno.setId(1);
		roleAluno.setNome(PermissaoEnum.ROLE_ALUNO);
		permissaoService.salvar(roleAluno);
		
		
		Usuario usuario = new Usuario();
		usuario.setEmail("adm@infnet.edu.br");
		usuario.setNome("Administrador");
	    usuario.setSenha("$2a$10$lt7pS7Kxxe5JfP.vjLNSyOXP11eHgh7RoPxo5fvvbMCZkCUss2DGu");
		usuario.setPermissao(roleAdmin);
		usuarioService.salvar(usuario);
		
		return "Carga inicial realizada com sucesso.";
		
	}
	
}
