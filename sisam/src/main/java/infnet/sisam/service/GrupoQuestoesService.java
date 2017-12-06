package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.GrupoQuestoesDao;
import infnet.sisam.model.GrupoQuestoes;

@Service
@Transactional
public class GrupoQuestoesService {

	@Autowired
	private GrupoQuestoesDao grupoQuestoesDao;

	public void salvar(GrupoQuestoes grupoQuestoes) {
		grupoQuestoesDao.salvar(grupoQuestoes);
	}
	
	public List<GrupoQuestoes> listar(){
		return grupoQuestoesDao.listar();
	}

	public GrupoQuestoes buscar(Integer id) {
		return grupoQuestoesDao.buscar(id);
	}

	public void remover(Integer id) {
		grupoQuestoesDao.excluir(grupoQuestoesDao.buscar(id));
	}

	public void atualizar(GrupoQuestoes grupoQuestoes) {
		grupoQuestoesDao.atualizar(grupoQuestoes);
	}

}
