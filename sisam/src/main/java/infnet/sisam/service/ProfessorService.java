package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.ProfessorDao;
import infnet.sisam.model.Professor;

@Service
@Transactional
public class ProfessorService {

	@Autowired
	private ProfessorDao professorDao;

	public void salvar(Professor professor) {
		professorDao.salvar(professor);
	}

	public List<Professor> listar() {
		return professorDao.findAll();
	}

	public void atualizar(Professor professor) {
		
		professorDao.atualizar(professor);
	}

	public Professor buscar(Integer id) {
		return professorDao.buscar(id);
	}
	
	public void remover(Integer id) {
		professorDao.excluir(professorDao.buscar(id));
	}
	
}
