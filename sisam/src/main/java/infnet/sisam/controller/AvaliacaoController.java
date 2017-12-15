package infnet.sisam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Questionario;
import infnet.sisam.model.Turma;
import infnet.sisam.model.Usuario;
import infnet.sisam.service.AvaliacaoService;
import infnet.sisam.service.QuestionarioService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;

	@Autowired
	private QuestionarioService questionarioService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Avaliacao> avaliacoes = avaliacaoService.listar();
		ModelAndView modelAndView = new ModelAndView("avaliacoes/lista");
		modelAndView.addObject("avaliacoes", avaliacoes);
		return modelAndView;
	}

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("avaliacoes/novo");
		List<Questionario> questionarios = questionarioService.lista();
		modelAndView.addObject("questionarios", questionarios);
		modelAndView.addObject("turmas", buildTurmas());
		return modelAndView;
	}
	
	private List<Turma> buildTurmas(){
		List<Turma> turmas = new ArrayList<Turma>();
		for (int i = 1; i <= 10; i++) {
			Turma turma = new Turma();
			turma.setId(i);
			turma.setDescricao("Turma " + i);
			turmas.add(turma);
		}
		return turmas;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Avaliacao avaliacao, RedirectAttributes redirectAttributes) {
		Usuario administrador = (Usuario) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		avaliacao.setAdministrador(administrador);
		//TODO SALVAR TURMA
		avaliacaoService.salvar(avaliacao);
		redirectAttributes.addAttribute("sucesso", "Avaliação cadastrada com sucesso");
		return new ModelAndView("redirect:/avaliacoes");
	}

}
