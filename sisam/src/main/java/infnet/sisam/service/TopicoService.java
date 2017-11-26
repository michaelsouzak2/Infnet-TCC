package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.TopicoDao;
import infnet.sisam.model.Topico;

@Service
@Transactional
public class TopicoService {

	@Autowired
	private TopicoDao topicoDao;

	public void salvar(Topico topico) {
		topicoDao.salvar(topico);
	}
	
	public List<Topico> listar(){
		return topicoDao.listar();
	}

	public Topico buscar(Integer id) {
		return topicoDao.buscar(id);
	}

	public void remover(Integer id) {
		topicoDao.excluir(topicoDao.buscar(id));
	}

	public void atualizar(Topico topico) {
		topicoDao.atualizar(topico);
	}

}
