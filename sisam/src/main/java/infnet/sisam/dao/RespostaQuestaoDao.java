package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.RespostaQuestao;

@Repository
public class RespostaQuestaoDao extends JpaDao<RespostaQuestao> {

	public RespostaQuestaoDao() {
		super(RespostaQuestao.class);
	}
	
	public List<RespostaQuestao> findByAvaliacao(Avaliacao avaliacao) {
		return getEm()
				.createQuery("select rq from RespostaQuestao rq where rq.avaliacao.id = :avaliacaoId", RespostaQuestao.class)
				.setParameter("avaliacaoId", avaliacao.getId())
				.getResultList();
	}
	
}
