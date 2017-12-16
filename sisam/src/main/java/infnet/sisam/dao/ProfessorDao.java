package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Professor;

@Repository
public class ProfessorDao extends JpaDao<Professor> {
	
	public ProfessorDao() {
		super(Professor.class);
	}

	public List<Professor> listar() {
		return em.createQuery("select u from Professor u", Professor.class).getResultList();
	}
}
