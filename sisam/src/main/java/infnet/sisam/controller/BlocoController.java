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
import infnet.sisam.model.Curso;
import infnet.sisam.service.BlocoService;
import infnet.sisam.service.CursoService;

@Controller
@RequestMapping("/blocos")
public class BlocoController {
	
	@Autowired
	private BlocoService blocoService;
	
	@Autowired
	private CursoService cursoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("blocos/novo");
		List<Curso> cursos = cursoService.listar();
		modelAndView.addObject("cursos", cursos);
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Bloco bloco, RedirectAttributes redirectAttributes) {
		blocoService.salvar(bloco);
		redirectAttributes.addFlashAttribute("sucesso", "Novo bloco incluído.");
		return new ModelAndView("redirect:/blocos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Bloco> blocos = blocoService.listar();
		ModelAndView modelAndView = new ModelAndView("blocos/lista");
		modelAndView.addObject("blocos", blocos);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Bloco bloco, RedirectAttributes redirectAttributes) {
		blocoService.atualizar(bloco);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/blocos");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("blocos/detalhe");
		Bloco bloco = blocoService.buscar(id);
		List<Curso> cursos = cursoService.listar();
		modelAndView.addObject("bloco", bloco);
		modelAndView.addObject("cursos", cursos);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		blocoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/blocos");
	}
	
}
