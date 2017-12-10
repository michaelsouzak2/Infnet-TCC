package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.AvaliacaoDao;
import infnet.sisam.model.Avaliacao;

@Service
@Transactional
public class AvaliacaoService {

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	public List<Avaliacao> listar(){
		return avaliacaoDao.findAll();
	}

	public void salvar(Avaliacao avaliacao) {
		avaliacaoDao.salvar(avaliacao);
	}
	
}
