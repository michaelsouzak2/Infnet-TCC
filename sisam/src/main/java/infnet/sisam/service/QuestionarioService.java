package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.QuestionarioDao;
import infnet.sisam.model.Questionario;

@Service
@Transactional
public class QuestionarioService {

	@Autowired
	private QuestionarioDao  questionarioDao;
	
	public void salvar(Questionario questionario) {
		questionarioDao.salvar(questionario);
	}

	public List<Questionario> lista() {
		return questionarioDao.listar();
	}
	
	
	
}
