package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.TurmaDao;
import infnet.sisam.model.Turma;

@Service
@Transactional
public class TurmaService {

	@Autowired
	private TurmaDao turmaDao;

	public void salvar(Turma turma) {
		turmaDao.salvar(turma);
	}

	public List<Turma> listar() {
		return turmaDao.findAll();
	}

	public void atualizar(Turma turma) {
	
		turmaDao.atualizar(turma);
	}

	public Turma buscar(Integer id) {
		return turmaDao.buscar(id);
	}
	
	public void remover(Integer id) {
		turmaDao.excluir(turmaDao.buscar(id));
	}

}
