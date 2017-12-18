package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.TipoCurso;

@Repository
public class TipoCursoDao extends JpaDao<TipoCurso>{

	public TipoCursoDao() {
		super(TipoCurso.class);
	}
}
