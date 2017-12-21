package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.RespostaQuestaoDao;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.RespostaQuestao;

@Service
@Transactional
public class RespostaQuestaoService {

	@Autowired
	private RespostaQuestaoDao respostaQuestaoDao;
	
	public void salvar(RespostaQuestao respotaQuestao) {
		respostaQuestaoDao.salvar(respotaQuestao);
	}
	
	public List<RespostaQuestao> findByAvaliacao(Avaliacao avaliacao){
		return respostaQuestaoDao.findByAvaliacao(avaliacao);
	}
	
	public List<RespostaQuestao> listar() {
		return respostaQuestaoDao.findAll();
	}

	public RespostaQuestao buscar(Integer id) {
		return respostaQuestaoDao.buscar(id);
	}

	/*public void salvaRespostas(RespostaQuestao respostaQuestao) {
		RespostaQuestao resp = new RespostaQuestao();
		resp.setAluno(alunoAvaliacao.getAluno());
		resp.setAvaliacao(alunoAvaliacao.getAvaliacao());
		// resp.setQuestao(questao);
		resp.setResposta(null);
	}*/

}
