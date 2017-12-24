package infnet.sisam.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import infnet.sisam.dto.TokenDTO;
import infnet.sisam.helper.TokenHelper;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Likert;
import infnet.sisam.model.Pesquisa;
import infnet.sisam.model.Questionario;
import infnet.sisam.model.RespostaQuestao;
import infnet.sisam.service.AvaliacaoService;
import infnet.sisam.service.PesquisaService;
import infnet.sisam.service.RespostaQuestaoService;

@Controller
@RequestMapping("/pesquisa")
public class PesquisaController {

	@Autowired
	private RespostaQuestaoService respostaService;
	@Autowired
	private AvaliacaoService avaliacaoService;
	@Autowired
	private PesquisaService pesquisaService;
	@Autowired
	private TokenHelper tokenHelper;
	
	@RequestMapping("/{token}")
	public ModelAndView abrirFormulario(@PathVariable String token, RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView();
		
		TokenDTO tokenDTO = tokenHelper.getClearText(token);
		Pesquisa pesquisa = new Pesquisa(tokenDTO);
		Avaliacao avaliacao = avaliacaoService.buscar(pesquisa.getAvaliacao().getId());
		Boolean temPermissao = verificaPermissoes(avaliacao, pesquisa, redirectAttributes);
		
		if (temPermissao) {
			pesquisaService.salvar(pesquisa);
			Questionario questionario = avaliacao.getQuestionario();
			modelAndView.addObject("questionario", questionario)
						.addObject("opcoes", Likert.values())
						.addObject("idAvaliacao", pesquisa.getAvaliacao().getId())
						.addObject("idAluno", pesquisa.getAluno().getId())
						.addObject("pesquisa", pesquisa)
						.setViewName("pesquisa/formulario");
		} else {
			modelAndView.setViewName("accessDenied");
		}

		return modelAndView;
	}
	
	private Boolean verificaPermissoes(Avaliacao avaliacao, Pesquisa pesquisa, RedirectAttributes redirectAttributes) {
		return verificaPrazo(avaliacao, redirectAttributes) && 
				verificaPesquisaRespondida(pesquisa, redirectAttributes);
	}
	
	private Boolean verificaPrazo(Avaliacao avaliacao, RedirectAttributes redirectAttributes) {
		if(avaliacao.getDataFim().before(Calendar.getInstance())) {
			redirectAttributes.addFlashAttribute("message", "Pesquisa fora do prazo.");
			return false;
		}
		return true;
	}

	private Boolean verificaPesquisaRespondida(Pesquisa pesquisa, RedirectAttributes redirectAttributes) {
		if(pesquisaService.verificaPesquisaRespondida(pesquisa)) {
			redirectAttributes.addFlashAttribute("message", "Esta pesquisa já foi respondida.");
			return false;
		}
		return true;
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView salvarRespostas(Pesquisa alunoAvaliacao) {
		
		alunoAvaliacao.getQuestoesRespondidas().forEach(questao->{
			RespostaQuestao respostaQuestao = new RespostaQuestao();
			respostaQuestao.setAluno(alunoAvaliacao.getAluno());
			respostaQuestao.setAvaliacao(alunoAvaliacao.getAvaliacao());
			respostaQuestao.setQuestao(questao);
			respostaQuestao.setResposta(questao.getOpcao());
			respostaService.salvar(respostaQuestao);
		});
		pesquisaService.salvarRespostas(alunoAvaliacao);
		return new ModelAndView("redirect:/pesquisa/respondida");
	}
	
	@RequestMapping("/respondida")
	public String pesquisaRespondida() {
		return "pesquisa/ok";
	}
	
}
