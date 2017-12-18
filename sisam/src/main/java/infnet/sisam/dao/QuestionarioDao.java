package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Questionario;

@Repository
public class QuestionarioDao extends JpaDao<Questionario> {

	public QuestionarioDao() {
		super(Questionario.class);
	}

}
