package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Questionario;
import infnet.sisam.model.Topico;
import infnet.sisam.service.QuestionarioService;
import infnet.sisam.service.TopicoService;

@Controller
@RequestMapping("/questionarios")
public class QuestionarioAvalicacaoController {
	
	@Autowired
	private TopicoService topicoService;
	
	@Autowired
	private QuestionarioService querionarioService;

	@RequestMapping("/novo")
	public ModelAndView novo() {		
		ModelAndView modelAndView = new ModelAndView("questionarios/novo");
		List<Topico> topicos = topicoService.listar();
		modelAndView.addObject("topicos", topicos);
		return modelAndView;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvar(Questionario questionario, RedirectAttributes redirectAttributes) {
		querionarioService.salvar(questionario);
		redirectAttributes.addFlashAttribute("sucesso", "Questionário salvo com sucesso.");
		return new ModelAndView("redirect:/questionarios");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView modelAndView = new ModelAndView("questionarios/lista");
		List<Questionario> questionarios = querionarioService.lista();
		modelAndView.addObject("questionarios", questionarios);
		return modelAndView;
	}
	
}
