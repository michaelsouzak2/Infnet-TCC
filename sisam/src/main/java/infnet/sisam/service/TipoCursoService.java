package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.TipoCursoDao;
import infnet.sisam.model.TipoCurso;

@Service
@Transactional
public class TipoCursoService {

	@Autowired
	private TipoCursoDao tipoCursoDao;

	public void salvar(TipoCurso tipoCurso) {
		tipoCursoDao.salvar(tipoCurso);
	}

	public List<TipoCurso> listar() {
		return tipoCursoDao.listar();
	}

	public void atualizar(TipoCurso tipoCurso) {
		
		tipoCursoDao.atualizar(tipoCurso);
	}

	public TipoCurso buscar(Integer id) {
		return tipoCursoDao.buscar(id);
	}
	
	public void remover(Integer id) {
		tipoCursoDao.excluir(tipoCursoDao.buscar(id));
	}
	
}
