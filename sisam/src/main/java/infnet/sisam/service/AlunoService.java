package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.AlunoDao;
import infnet.sisam.model.Aluno;

@Service
@Transactional
public class AlunoService {

	@Autowired
	private AlunoDao alunoDao;

	public void salvar(Aluno aluno) {
		alunoDao.salvar(aluno);
	}

	public List<Aluno> listar() {
		return alunoDao.findAll();
	}

	public void atualizar(Aluno aluno) {
	
		alunoDao.atualizar(aluno);
	}

	public Aluno buscar(Integer id) {
		return alunoDao.buscar(id);
	}
	
	public void remover(Integer id) {
		alunoDao.excluir(alunoDao.buscar(id));
	}

}
