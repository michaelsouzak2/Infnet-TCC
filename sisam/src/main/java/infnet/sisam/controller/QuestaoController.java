package infnet.sisam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Questao;
import infnet.sisam.service.QuestaoService;

@Controller
@RequestMapping("/questoes")
public class QuestaoController {

	@Autowired
	private QuestaoService questaoService;

	@RequestMapping("/novo")
	public String novo() {
		return "questoes/novo";
	}
	
	@RequestMapping("/salvar")
	public ModelAndView salvar(Questao questao, RedirectAttributes redirectAttributes) {
		questaoService.salvar(questao);
		redirectAttributes.addFlashAttribute("sucesso", "Questão foi salvada com sucesso.");
		return new ModelAndView("redirect:/questoes");
	}
	
}
