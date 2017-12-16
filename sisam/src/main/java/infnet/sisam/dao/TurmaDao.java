package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Turma;

@Repository
public class TurmaDao extends JpaDao<Turma> {
	
	public TurmaDao() {
		super(Turma.class);
	}

	public List<Turma> listar() {
		return em.createQuery("select u from Turma u", Turma.class).getResultList();
	}
}
