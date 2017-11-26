package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Topico;
import infnet.sisam.service.TopicoService;

@Controller
@RequestMapping("/topicos")
public class TopicoController {

	@Autowired
	private TopicoService topicoService;

	@RequestMapping("/novo")
	public String novo() {
		return "topicos/novo";
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Topico topico, RedirectAttributes redirectAttributes) {
		topicoService.salvar(topico);
		redirectAttributes.addFlashAttribute("sucesso", "Tópico cadastro com sucesso");
		return new ModelAndView("redirect:/topicos");
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		List<Topico> topicos = topicoService.listar();
		ModelAndView modelAndView = new ModelAndView("topicos/lista");
		modelAndView.addObject("topicos", topicos);
		return modelAndView;
	}

	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable Integer id) {
		Topico topico = topicoService.buscar(id);
		ModelAndView modelAndView = new ModelAndView("topicos/detalhe");
		modelAndView.addObject("topico", topico);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Topico topico, RedirectAttributes redirectAttributes) {
		topicoService.atualizar(topico);
		redirectAttributes.addFlashAttribute("sucesso", "Tópico alterado com sucesso");
		return new ModelAndView("redirect:/topicos");
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		topicoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida");
		return new ModelAndView("redirect:/topicos");
	}

}
