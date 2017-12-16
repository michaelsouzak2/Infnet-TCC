package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Professor;
import infnet.sisam.service.ProfessorService;

@Controller
@RequestMapping("/professores")
public class ProfessorController {
	
	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("professores/novo");
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Professor professor, RedirectAttributes redirectAttributes) {
		professorService.salvar(professor);
		redirectAttributes.addFlashAttribute("sucesso", "Novo professor incluído.");
		return new ModelAndView("redirect:/professores");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Professor> professores = professorService.listar();
		ModelAndView modelAndView = new ModelAndView("professores/lista");
		modelAndView.addObject("professores", professores);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Professor professor, RedirectAttributes redirectAttributes) {
		professorService.atualizar(professor);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/professores");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("professores/detalhe");
		Professor professor = professorService.buscar(id);
		modelAndView.addObject("professor", professor);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		professorService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/professores");
	}
	
}
