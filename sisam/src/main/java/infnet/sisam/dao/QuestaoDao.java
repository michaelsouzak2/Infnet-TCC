package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Questao;
import infnet.sisam.model.Topico;

@Repository
public class QuestaoDao extends JpaDao<Questao> {

	public QuestaoDao() {
		super(Questao.class);
	}

	public List<Questao> listar() {
		return em.createQuery("select q from Questao q", Questao.class).getResultList();
	}

	public List<Questao> listarPorTopico(Topico topico) {
		return em.createQuery("select q from Questao q where q.topico = :topico", Questao.class)
				.setParameter("topico", topico)
				.getResultList();
	}

}
