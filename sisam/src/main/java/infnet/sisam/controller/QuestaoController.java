package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Questao;
import infnet.sisam.model.GrupoQuestoes;
import infnet.sisam.service.QuestaoService;
import infnet.sisam.service.GrupoQuestoesService;

@Controller
@RequestMapping("/questoes")
public class QuestaoController {

	@Autowired
	private QuestaoService questaoService;
	
	@Autowired
	private GrupoQuestoesService grupoQuestoesService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("questoes/novo");
		List<GrupoQuestoes> gruposQuestoes = grupoQuestoesService.listar();
		modelAndView.addObject("gruposQuestoes", gruposQuestoes);
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Questao questao, RedirectAttributes redirectAttributes) {
		questaoService.salvar(questao);
		redirectAttributes.addFlashAttribute("sucesso", "Questão foi salvada com sucesso.");
		return new ModelAndView("redirect:/questoes");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Questao> questoes = questaoService.listar();
		List<GrupoQuestoes> gruposQuestoes = grupoQuestoesService.listar();
		ModelAndView modelAndView = new ModelAndView("questoes/lista");
		modelAndView.addObject("questoes", questoes);
		modelAndView.addObject("gruposQuestoes", gruposQuestoes);
		return modelAndView;
	}
	
	@RequestMapping("/listarPorGrupoQuestoes")
	public ModelAndView listarPorGrupoQuestoes(GrupoQuestoes grupoQuestoes, RedirectAttributes redirectAttributes) {
		List<Questao> questoes = questaoService.listarPorGrupoQuestoes(grupoQuestoes);
		List<GrupoQuestoes> gruposQuestoes = grupoQuestoesService.listar();
		ModelAndView modelAndView = new ModelAndView("questoes/lista");
		modelAndView.addObject("questoes", questoes);
		modelAndView.addObject("gruposQuestoes", gruposQuestoes);
		redirectAttributes.addFlashAttribute("grupoQuestoes", grupoQuestoes);
		return modelAndView;
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable Integer id) {
		Questao questao = questaoService.buscar(id);
		List<GrupoQuestoes> gruposQuestoes = grupoQuestoesService.listar();
		ModelAndView modelAndView = new ModelAndView("questoes/detalhe");
		modelAndView.addObject("questao", questao);
		modelAndView.addObject("gruposQuestoes", gruposQuestoes);
		return modelAndView;
	}

	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Questao questao, RedirectAttributes redirectAttributes) {
		questaoService.atualizar(questao);
		redirectAttributes.addFlashAttribute("sucesso", "Questão atualizada com sucesso.");
		return new ModelAndView("redirect:/questoes");
	}

	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		questaoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Questão removida com sucesso.");
		return new ModelAndView("redirect:/questoes");
	}

}
