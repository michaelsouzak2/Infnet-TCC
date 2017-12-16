package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Bloco;
import infnet.sisam.model.Modulo;
import infnet.sisam.service.BlocoService;
import infnet.sisam.service.ModuloService;

@Controller
@RequestMapping("/modulos")
public class ModuloController {
	
	@Autowired
	private ModuloService moduloService;

	@Autowired
	private BlocoService blocoService;

	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		List<Modulo> modulos = moduloService.listar();
		List<Bloco> blocos = blocoService.listar();
		ModelAndView modelAndView = new ModelAndView("modulos/novo");
		modelAndView.addObject("modulos", modulos);
		modelAndView.addObject("blocos", blocos);
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Modulo modulo, RedirectAttributes redirectAttributes) {
		moduloService.salvar(modulo);
		redirectAttributes.addFlashAttribute("sucesso", "Novo modulo incluído.");
		return new ModelAndView("redirect:/modulos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Modulo> modulos = moduloService.listar();
		ModelAndView modelAndView = new ModelAndView("modulos/lista");
		modelAndView.addObject("modulos", modulos);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Modulo modulo, String oldPassword, RedirectAttributes redirectAttributes) {
		moduloService.atualizar(modulo);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/modulos");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("modulos/detalhe");
		Modulo modulo = moduloService.buscar(id);
		List<Bloco> blocos = blocoService.listar();
		modelAndView.addObject("modulo", modulo);
		modelAndView.addObject("blocos", blocos);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		moduloService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/modulos");
	}
	
}
