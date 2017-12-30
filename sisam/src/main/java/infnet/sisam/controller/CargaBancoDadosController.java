package infnet.sisam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import infnet.sisam.enumeration.PermissaoEnum;
import infnet.sisam.model.Permissao;
import infnet.sisam.model.Usuario;
import infnet.sisam.service.PermissaoService;
import infnet.sisam.service.UsuarioService;

@Controller
public class CargaBancoDadosController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PermissaoService permissaoService;
	
	/**
	 * Executar apenas no primeiro acesso ao sistema em produção.
	 * Este path não deve ser divulgado.
	 */
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
		
		
		Usuario usuario = new Usuario();
		usuario.setEmail("adm@infnet.edu.br");
		usuario.setNome("Administrador");
		usuario.setSenha("123456");
		usuario.setPermissao(roleAdmin);
		usuarioService.salvar(usuario);

		Usuario sec = new Usuario();
		sec.setEmail("maria@infnet.edu.br");
		sec.setNome("Maria");
		sec.setSenha("123456");
		sec.setPermissao(roleSec);
		usuarioService.salvar(sec);
		
		return "Carga inicial realizada com sucesso.";
		
	}
	
}
