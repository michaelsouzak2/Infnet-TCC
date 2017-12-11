package infnet.sisam.dao;

import infnet.sisam.model.Curso;

public class CursoDao extends JpaDao<Curso>{
	
	public CursoDao() {
		super(Curso.class);
	}

}
