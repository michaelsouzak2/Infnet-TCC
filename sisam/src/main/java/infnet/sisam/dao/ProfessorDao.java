package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Professor;

@Repository
public class ProfessorDao extends JpaDao<Professor> {
	
	public ProfessorDao() {
		super(Professor.class);
	}
}
