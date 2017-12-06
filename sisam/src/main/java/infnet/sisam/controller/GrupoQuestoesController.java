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
import infnet.sisam.service.GrupoQuestoesService;

@Controller
@RequestMapping("/grupoQuestoes")
public class GrupoQuestoesController {

	@Autowired
	private GrupoQuestoesService grupoQuestoesService;

	@RequestMapping("/novo")
	public String novo() {
		return "grupoQuestoes/novo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(GrupoQuestoes grupoQuestoes, RedirectAttributes redirectAttributes) {
		grupoQuestoesService.salvar(grupoQuestoes);
		redirectAttributes.addFlashAttribute("sucesso", "Grupo de questões cadastro com sucesso");
		return new ModelAndView("redirect:/grupoQuestoes");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<GrupoQuestoes> gruposQuestoes = grupoQuestoesService.listar();
		ModelAndView modelAndView = new ModelAndView("grupoQuestoes/lista");
		modelAndView.addObject("gruposQuestoes", gruposQuestoes);
		return modelAndView;
	}

	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable Integer id) {
		GrupoQuestoes grupoQuestoes = grupoQuestoesService.buscar(id);
		ModelAndView modelAndView = new ModelAndView("grupoQuestoes/detalhe");
		modelAndView.addObject("grupoQuestoes", grupoQuestoes);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(GrupoQuestoes grupoQuestoes, RedirectAttributes redirectAttributes) {
		grupoQuestoesService.atualizar(grupoQuestoes);
		redirectAttributes.addFlashAttribute("sucesso", "Grupo de questões alterado com sucesso.");
		return new ModelAndView("redirect:/grupoQuestoes");
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		grupoQuestoesService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/grupoQuestoes");
	}
	
}
