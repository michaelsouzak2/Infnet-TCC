package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.enumeration.PermissaoEnum;
import infnet.sisam.model.Usuario;
import infnet.sisam.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("usuarios/novo");
		modelAndView.addObject("permissoes", PermissaoEnum.values());
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Usuario usuario, RedirectAttributes redirectAttributes) {
		usuarioService.salvar(usuario);
		redirectAttributes.addFlashAttribute("sucesso", "Novo usuário incluído.");
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuarios = usuarioService.listar();
		ModelAndView modelAndView = new ModelAndView("usuarios/lista");
		modelAndView.addObject("usuarios", usuarios);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Usuario usuario, String newPassword, RedirectAttributes redirectAttributes) {
		usuarioService.atualizar(usuario, newPassword);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/usuarios");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("usuarios/detalhe");
		Usuario usuario = usuarioService.buscar(id);
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("permissoes", PermissaoEnum.values());
		return modelAndView;
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Integer id) {
		usuarioService.remover(id);
		return new ModelAndView("redirect:/usuarios");
	}
	
}
