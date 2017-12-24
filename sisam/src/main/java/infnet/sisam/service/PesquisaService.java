package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.PesquisaDao;
import infnet.sisam.model.Pesquisa;

@Service
@Transactional
public class PesquisaService {

	@Autowired
	private PesquisaDao pesquisaDao;

	public void salvar(Pesquisa pesquisa) {
		pesquisa.setAvaliacaoRespondida(false);
		pesquisaDao.salvar(pesquisa);
	}

	public List<Pesquisa> listar() {
		return pesquisaDao.findAll();
	}

	public Pesquisa buscar(Integer id) {
		return pesquisaDao.buscar(id);
	}

	public void atualizar(Pesquisa pesquisa) {
		pesquisaDao.atualizar(pesquisa);
	}

	public void remover(Integer id) {
		pesquisaDao.excluir(pesquisaDao.buscar(id));
	}

	public Boolean verificaPesquisaRespondida(Pesquisa pesquisa) {
		return pesquisaDao.verificaPesquisaRespondida(pesquisa);
	}

	public void salvarRespostas(Pesquisa pesquisa) {
		pesquisa.setAvaliacaoRespondida(true);
		pesquisaDao.atualizar(pesquisa);
	}

}
