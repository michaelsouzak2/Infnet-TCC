package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.RespostaQuestao;

@Repository
public class RespostaQuestaoDao extends JpaDao<RespostaQuestao> {

	public RespostaQuestaoDao() {
		super(RespostaQuestao.class);
	}

}
