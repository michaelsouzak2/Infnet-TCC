package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Curso;

@Repository
public class CursoDao extends JpaDao<Curso>{
	
	public CursoDao() {
		super(Curso.class);
	}

	public List<Curso> listar() {
		return em.createQuery("select u from Curso u", Curso.class).getResultList();
	}
}
