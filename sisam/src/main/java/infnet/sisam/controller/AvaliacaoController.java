package infnet.sisam.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.model.AlunoAvaliacao;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.GrupoQuestoes;
import infnet.sisam.model.Likert;
import infnet.sisam.model.Questao;
import infnet.sisam.model.Questionario;
import infnet.sisam.model.Usuario;
import infnet.sisam.service.AlunoAvaliacaoService;
import infnet.sisam.service.AvaliacaoService;
import infnet.sisam.service.QuestionarioService;
import infnet.sisam.service.TurmaService;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

	@Autowired
	private AvaliacaoService avaliacaoService;
	@Autowired
	private QuestionarioService questionarioService;
	@Autowired
	private TurmaService turmaService;
	@Autowired
	private AlunoAvaliacaoService alunoAvaliacaoService;
	@Autowired
	private FormattingConversionService mvcConversionService;

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
		modelAndView.addObject("turmas", turmaService.listar());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(@AuthenticationPrincipal Usuario usuario, Avaliacao avaliacao,
			RedirectAttributes redirectAttributes) {
		avaliacao.setAdministrador(usuario);
		avaliacaoService.salvar(avaliacao);
		redirectAttributes.addAttribute("sucesso", "Avaliação cadastrada com sucesso");
		return new ModelAndView("redirect:/avaliacoes");
	}

	@RequestMapping("/buscar/{id}")
	public ModelAndView buscar(@PathVariable Integer id) {
		ModelAndView modelAndView = new ModelAndView("avaliacoes/detalhe");
		Avaliacao avaliacao = avaliacaoService.buscar(id);
		List<Questionario> questionarios = questionarioService.lista();
		modelAndView.addObject("avaliacao", avaliacao)
				.addObject("dataInicio", mvcConversionService.convert(avaliacao.getDataInicio(), String.class))
				.addObject("dataFim", mvcConversionService.convert(avaliacao.getDataFim(), String.class))
				.addObject("questionarios", questionarios);
		return modelAndView;
	}

	@RequestMapping("/atualizar")
	public ModelAndView atualizar(Avaliacao avaliacao, RedirectAttributes redirectAttributes) {
		avaliacaoService.atualizar(avaliacao);
		redirectAttributes.addFlashAttribute("sucesso", "Avaliação atualizada com sucesso.");
		return new ModelAndView("redirect:/avaliacoes");
	}

	@RequestMapping("/remover/{id}")
	public ModelAndView remover(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		avaliacaoService.remover(id);
		redirectAttributes.addFlashAttribute("sucesso", "Avaliação removida com sucesso.");
		return new ModelAndView("redirect:/avaliacoes");
	}

	@RequestMapping("/responder/{avaliacaoId}/{alunoId}")
	public ModelAndView responderAvaliacao(@PathVariable Integer avaliacaoId, @PathVariable Integer alunoId,
			RedirectAttributes redirectAttributes) {
		// verificar se avaliação ainda está ativa
		// verificar antes se o aluno pode responder a avaliação ou se j á respondeu
		ModelAndView modelAndView = new ModelAndView("respostas/lista");
		AlunoAvaliacao alunoAvaliacao = avaliacaoService.verificaAcessoAvaliacaoAluno(alunoId, avaliacaoId);
		boolean isPermite = !alunoAvaliacao.getAvaliacaoRespondida();
		if (isPermite) {
			List<Questao> questoes = new ArrayList<Questao>();
			modelAndView.addObject("isPermite", isPermite);
			for (GrupoQuestoes grupo : alunoAvaliacao.getAvaliacao().getQuestionario().getGruposQuestoes()) {
				questoes = grupo.getQuestoes();
			}
			modelAndView.addObject("questoes", questoes);
			modelAndView.addObject("opcoes", Likert.values());
			modelAndView.addObject("idAvaliacao", avaliacaoId);
			modelAndView.addObject("idAluno", alunoId);
			modelAndView.addObject("alunoAvaliacao", alunoAvaliacao);
		}
		return modelAndView;
	}

	@RequestMapping("/finalizar")
	public ModelAndView finalizar(AlunoAvaliacao alunoAvaliacao, Integer idAluno, Integer idAvaliacao,
			RedirectAttributes redirectAttributes) {
		alunoAvaliacaoService.finalizarAlunoAvaliacao(alunoAvaliacao);
		redirectAttributes.addFlashAttribute("sucesso", "Avaliação respondida com sucesso.");
		return new ModelAndView("redirect:/respostas/resumo");
	}

}
