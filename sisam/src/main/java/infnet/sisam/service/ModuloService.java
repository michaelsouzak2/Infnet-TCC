package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.ModuloDao;
import infnet.sisam.model.Modulo;

@Service
@Transactional
public class ModuloService {

	@Autowired
	private ModuloDao moduloDao;

	public void salvar(Modulo modulo) {
		moduloDao.salvar(modulo);
	}

	public List<Modulo> listar() {
		return moduloDao.findAll();
	}

	public void atualizar(Modulo modulo) {
		
		moduloDao.atualizar(modulo);
	}

	public Modulo buscar(Integer id) {
		return moduloDao.buscar(id);
	}
	
	public void remover(Integer id) {
		moduloDao.excluir(moduloDao.buscar(id));
	}
	
}
