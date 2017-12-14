package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Curso;
import infnet.sisam.model.TipoCurso;
import infnet.sisam.service.CursoService;
import infnet.sisam.service.TipoCursoService;

@Controller
@RequestMapping("/cursos")
public class CursoController {
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private TipoCursoService tipoCursoService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("cursos/novo");
		List<TipoCurso> tipoCursos = tipoCursoService.listar();
		modelAndView.addObject("tipoCursos", tipoCursos);
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Curso curso, RedirectAttributes redirectAttributes) {
		cursoService.salvar(curso);
		redirectAttributes.addFlashAttribute("sucesso", "Novo curso incluído.");
		return new ModelAndView("redirect:/cursos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Curso> cursos = cursoService.listar();
		ModelAndView modelAndView = new ModelAndView("cursos/lista");
		modelAndView.addObject("cursos", cursos);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Curso curso, RedirectAttributes redirectAttributes) {
		cursoService.atualizar(curso);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/cursos");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("cursos/detalhe");
		Curso curso = cursoService.buscar(id);
		modelAndView.addObject("curso", curso);
		
		List<TipoCurso> tipoCursos = tipoCursoService.listar();
		modelAndView.addObject("tipoCursos", tipoCursos);
		
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		cursoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/cursos");
	}
	
}
