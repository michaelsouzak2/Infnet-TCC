package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Aluno;

@Repository
public class AlunoDao extends JpaDao<Aluno> {
	
	public AlunoDao() {
		super(Aluno.class);
	}

	public List<Aluno> listar() {
		return em.createQuery("select u from Aluno u", Aluno.class).getResultList();
	}
}
