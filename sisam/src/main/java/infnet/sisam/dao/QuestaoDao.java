package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.GrupoQuestoes;
import infnet.sisam.model.Questao;

@Repository
public class QuestaoDao extends JpaDao<Questao> {

	public QuestaoDao() {
		super(Questao.class);
	}

	public List<Questao> listarPorGrupoQuestoes(GrupoQuestoes grupoQuestoes) {
		return em.createQuery("select q from Questao q where q.grupoQuestoes = :grupoQuestoes", Questao.class)
				.setParameter("grupoQuestoes", grupoQuestoes)
				.getResultList();
	}

}
