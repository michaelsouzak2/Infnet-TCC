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
import infnet.sisam.model.TipoCurso;
import infnet.sisam.service.TipoCursoService;

@Controller
@RequestMapping("/tipocursos")
public class TipoCursoController {
	
	@Autowired
	private TipoCursoService tipoCursoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("tipocursos/novo");
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(TipoCurso tipoCurso, RedirectAttributes redirectAttributes) {
		tipoCursoService.salvar(tipoCurso);
		redirectAttributes.addFlashAttribute("sucesso", "Novo Tipo de Curso incluído.");
		return new ModelAndView("redirect:/tipocursos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<TipoCurso> tipoCursos = tipoCursoService.listar();
		ModelAndView modelAndView = new ModelAndView("tipocursos/lista");
		modelAndView.addObject("tipoCursos", tipoCursos);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(TipoCurso tipoCurso, RedirectAttributes redirectAttributes) {
		tipoCursoService.atualizar(tipoCurso);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/tipocursos");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("tipocursos/detalhe");
		TipoCurso tipoCurso = tipoCursoService.buscar(id);
		modelAndView.addObject("tipoCurso", tipoCurso);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		tipoCursoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/tipocursos");
	}
	
}
