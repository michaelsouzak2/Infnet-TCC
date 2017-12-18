package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Curso;

@Repository
public class CursoDao extends JpaDao<Curso>{
	
	public CursoDao() {
		super(Curso.class);
	}
}
