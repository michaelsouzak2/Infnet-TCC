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
import infnet.sisam.model.Topico;
import infnet.sisam.service.QuestaoService;
import infnet.sisam.service.TopicoService;

@Controller
@RequestMapping("/questoes")
public class QuestaoController {

	@Autowired
	private QuestaoService questaoService;
	
	@Autowired
	private TopicoService topicoService;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView modelAndView = new ModelAndView("questoes/novo");
		List<Topico> topicos = topicoService.listar();
		modelAndView.addObject("topicos", topicos);
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
		List<Topico> topicos = topicoService.listar();
		ModelAndView modelAndView = new ModelAndView("questoes/lista");
		modelAndView.addObject("questoes", questoes);
		modelAndView.addObject("topicos", topicos);
		return modelAndView;
	}
	
	@RequestMapping("/listarPorTopico")
	public ModelAndView listarPorTopico(Topico topico, RedirectAttributes redirectAttributes) {
		List<Questao> questoes = questaoService.listarPorTopico(topico);
		List<Topico> topicos = topicoService.listar();
		ModelAndView modelAndView = new ModelAndView("questoes/lista");
		modelAndView.addObject("questoes", questoes);
		modelAndView.addObject("topicos", topicos);
		redirectAttributes.addFlashAttribute("topico", topico);
		return modelAndView;
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable Integer id) {
		Questao questao = questaoService.buscar(id);
		List<Topico> topicos = topicoService.listar();
		ModelAndView modelAndView = new ModelAndView("questoes/detalhe");
		modelAndView.addObject("questao", questao);
		modelAndView.addObject("topicos", topicos);
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
