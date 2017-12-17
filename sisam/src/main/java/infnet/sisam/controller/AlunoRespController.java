package infnet.sisam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.Aluno;
import infnet.sisam.model.Turma;
import infnet.sisam.service.AlunoService;
import infnet.sisam.service.TurmaService;

@Controller
@RequestMapping("/alunos")
public class AlunoRespController {
	
	@Autowired
	private AlunoService alunoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		List<Turma> turmas = turmaService.listar();
		ModelAndView modelAndView = new ModelAndView("alunos/novo");
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
	}
	
	@RequestMapping("/salvar")
	public ModelAndView gravar(Aluno aluno, RedirectAttributes redirectAttributes) {
		alunoService.salvar(aluno);
		redirectAttributes.addFlashAttribute("sucesso", "Novo aluno incluída.");
		return new ModelAndView("redirect:/alunos");
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Aluno> alunos = alunoService.listar();
		ModelAndView modelAndView = new ModelAndView("alunos/lista");
		modelAndView.addObject("alunos", alunos);
		return modelAndView;
	}
	
	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Aluno aluno, RedirectAttributes redirectAttributes) {
		alunoService.atualizar(aluno);
		redirectAttributes.addFlashAttribute("sucesso", "Atualização bem sucedida");
		return new ModelAndView("redirect:/alunos");
	}
	
	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("alunos/detalhe");
		Aluno aluno = alunoService.buscar(id);
		List<Turma> turmas = turmaService.listar();
		modelAndView.addObject("aluno", aluno);
		modelAndView.addObject("turmas", turmas);
		return modelAndView;
	}
	
	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		alunoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Remoção bem sucedida.");
		return new ModelAndView("redirect:/alunos");
	}
	
}
