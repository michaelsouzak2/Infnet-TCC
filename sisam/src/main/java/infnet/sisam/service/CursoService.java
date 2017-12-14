package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.CursoDao;
import infnet.sisam.model.Curso;

@Service
@Transactional
public class CursoService {

	@Autowired
	private CursoDao cursoDao;

	
	public void salvar(Curso curso) {
		cursoDao.salvar(curso);
	}

	public List<Curso> listar() {
		return cursoDao.findAll();
	}

	public void atualizar(Curso curso) {
		
		cursoDao.atualizar(curso);
	}

	public Curso buscar(Integer id) {
		return cursoDao.buscar(id);
	}
	
	public void remover(Integer id) {
		cursoDao.excluir(cursoDao.buscar(id));
	}

}
