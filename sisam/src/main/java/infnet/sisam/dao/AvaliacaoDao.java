package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Avaliacao;

@Repository
public class AvaliacaoDao extends JpaDao<Avaliacao> {

	public AvaliacaoDao() {
		super(Avaliacao.class);
	}
	
	public Avaliacao buscarPorId(Integer id) {
		return em.createQuery("select q from Avaliacao q where q.id = :id", Avaliacao.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
