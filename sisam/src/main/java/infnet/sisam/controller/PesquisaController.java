package infnet.sisam.controller;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import infnet.sisam.model.AlunoAvaliacao;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Likert;
import infnet.sisam.model.Questionario;
import infnet.sisam.model.RespostaQuestao;
import infnet.sisam.service.AlunoAvaliacaoService;
import infnet.sisam.service.AvaliacaoService;
import infnet.sisam.service.RespostaQuestaoService;

@Controller
@RequestMapping("/pesquisa")
public class PesquisaController {

	@Autowired
	private AlunoAvaliacaoService alunoAvaliacaoService;
	@Autowired
	private RespostaQuestaoService respostaService;
	@Autowired
	private AvaliacaoService avaliacaoService;
	
	// verificar se avaliação ainda está ativa
	// verificar antes se o aluno pode responder a avaliação ou se j á respondeu
	@RequestMapping("/responder/{hashAvaliacaoId}")
	public ModelAndView responderAvaliacao(@PathVariable String hashAvaliacaoId) {

		ModelAndView modelAndView = new ModelAndView();
		AlunoAvaliacao alunoAvaliacao = avaliacaoService.verificaAcessoAvaliacaoAluno(hashAvaliacaoId);
		boolean temPermissao = !alunoAvaliacao.getAvaliacaoRespondida();
		
		Avaliacao avaliacao = avaliacaoService.buscar(alunoAvaliacao.getAvaliacao().getId());
		
		if(avaliacao.getDataFim().before(Calendar.getInstance())) {
			temPermissao = false;
		}

		if (temPermissao) {
			Questionario questionario = avaliacao.getQuestionario();
			modelAndView.addObject("questionario", questionario).addObject("opcoes", Likert.values())
					.addObject("idAvaliacao", alunoAvaliacao.getAvaliacao().getId())
					.addObject("idAluno", alunoAvaliacao.getAluno().getId()).addObject("alunoAvaliacao", alunoAvaliacao)
					.setViewName("respostas/lista");
		} else {
			modelAndView.setViewName("accessDenied");
		}

		return modelAndView;
	}

	@RequestMapping("/responder/finalizar")
	public ModelAndView finalizar(AlunoAvaliacao alunoAvaliacao) {
		
		alunoAvaliacao.getQuestoesRespondidas().forEach(questao->{
			RespostaQuestao respostaQuestao = new RespostaQuestao();
			respostaQuestao.setAluno(alunoAvaliacao.getAluno());
			respostaQuestao.setAvaliacao(alunoAvaliacao.getAvaliacao());
			respostaQuestao.setQuestao(questao);
			respostaQuestao.setResposta(questao.getOpcao());
			respostaService.salvar(respostaQuestao);
		});
		alunoAvaliacaoService.finalizarAlunoAvaliacao(alunoAvaliacao);
		return new ModelAndView("redirect:/avaliacoes/responder/finalizado");
	}
	
	@RequestMapping("/responder/finalizado")
	public String finalizado() {
		return "respostas/resumo";
	}
	
}
