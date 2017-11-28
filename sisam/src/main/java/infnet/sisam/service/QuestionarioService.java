package infnet.sisam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import infnet.sisam.dao.QuestionarioDao;
import infnet.sisam.model.Questao;
import infnet.sisam.model.Questionario;

@Service
@Transactional
public class QuestionarioService {

	@Autowired
	private QuestionarioDao  questionarioDao;
	
	public void salvar(Questionario questionario) {
		try {
			
			for (int i = 0; i < questionario.getQuestoes().size(); i++) {
				if(questionario.getQuestoes().get(i).getId() == null) {
					questionario.getQuestoes().remove(i);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		questionarioDao.salvar(questionario);
	}

	public List<Questionario> lista() {
		return questionarioDao.listar();
	}
	
	
	
}
