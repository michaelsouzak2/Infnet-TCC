package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.GrupoQuestoes;
import infnet.sisam.model.Questionario;
import infnet.sisam.service.GrupoQuestoesService;
import infnet.sisam.service.QuestionarioService;

@Controller
@RequestMapping("/questionarios")
public class QuestionarioAvalicacaoController {
	
	@Autowired
	private GrupoQuestoesService grupoQuestoesService;
	
	@Autowired
	private QuestionarioService questionarioService;

	@Autowired
	private GrupoQuestoesService grupoQUestoesService;

	@RequestMapping("/novo")
	public ModelAndView novo() {		
		ModelAndView modelAndView = new ModelAndView("questionarios/novo");
		List<GrupoQuestoes> gruposQuestoes = grupoQuestoesService.listar();
		modelAndView.addObject("gruposQuestoes", gruposQuestoes);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Questionario questionario, RedirectAttributes redirectAttributes) {
		questionarioService.salvar(questionario);
		redirectAttributes.addFlashAttribute("sucesso", "Questionário salvo com sucesso.");
		return new ModelAndView("redirect:/questionarios");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("questionarios/lista");
		List<Questionario> questionarios = questionarioService.lista();
		modelAndView.addObject("questionarios", questionarios);
		return modelAndView;
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("questionarios/detalhe");
		Questionario questionario = questionarioService.buscarPorId(id);
		List<GrupoQuestoes> grupoQuestoes = grupoQUestoesService.listar();
		modelAndView.addObject("questionario", questionario);
		modelAndView.addObject("gruposQuestoes", grupoQuestoes);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Questionario questionario, RedirectAttributes redirectAttributes) {
		questionarioService.atualizar(questionario);
		redirectAttributes.addFlashAttribute("sucesso", "Questionário atualizado com sucesso.");
		return new ModelAndView("redirect:/questionarios");
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		questionarioService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Questionário removido com sucesso.");
		return new ModelAndView("redirect:/questionarios");
	}
	
}
