package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.QuestaoDao;
import infnet.sisam.model.Questao;
import infnet.sisam.model.GrupoQuestoes;

@Service
@Transactional
public class QuestaoService {

	@Autowired
	private QuestaoDao questaoDao;

	public void salvar(Questao questao) {
		questaoDao.salvar(questao);
	}

	public List<Questao> listar() {
		return questaoDao.listar();
	}

	public Questao buscar(Integer id) {
		return questaoDao.buscar(id);
	}

	public void atualizar(Questao questao) {
		questaoDao.atualizar(questao);
	}

	public void remover(Integer id) {
		questaoDao.excluir(questaoDao.buscar(id));
	}

	public List<Questao> listarPorGrupoQuestoes(GrupoQuestoes grupoQuestoes) {
		return questaoDao.listarPorGrupoQuestoes(grupoQuestoes);
	}

}
