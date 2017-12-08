package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Questionario;

@Repository
public class QuestionarioDao extends JpaDao<Questionario> {

	public QuestionarioDao() {
		super(Questionario.class);
	}
	
	public Questionario buscarPorId(Integer id) {
		return em.createQuery("select q from Questionario q where q.id = :id", Questionario.class)
				.setParameter("id", id)
				.getSingleResult();
	}

}
