package infnet.sisam.dao;

import infnet.sisam.model.Professor;

public class ProfessorDao extends JpaDao<Professor> {
	
	public ProfessorDao() {
		super(Professor.class);
	}

}
