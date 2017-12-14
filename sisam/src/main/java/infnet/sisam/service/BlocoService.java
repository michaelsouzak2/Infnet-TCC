package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.BlocoDao;
import infnet.sisam.model.Bloco;

@Service
@Transactional
public class BlocoService {

	@Autowired
	private BlocoDao blocoDao;

	
	public void salvar(Bloco bloco) {
		blocoDao.salvar(bloco);
	}

	public List<Bloco> listar() {
		return blocoDao.findAll();
	}

	public void atualizar(Bloco bloco) {
		
		blocoDao.atualizar(bloco);
	}

	public Bloco buscar(Integer id) {
		return blocoDao.buscar(id);
	}
	
	public void remover(Integer id) {
		blocoDao.excluir(blocoDao.buscar(id));
	}

}
