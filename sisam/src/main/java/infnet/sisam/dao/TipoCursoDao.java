package infnet.sisam.dao;

import java.util.List;

import infnet.sisam.model.TipoCurso;

public class TipoCursoDao extends JpaDao<TipoCurso>{

	public TipoCursoDao() {
		super(TipoCurso.class);
	}

	public List<TipoCurso> listar() {
		return em.createQuery("select u from TipoCurso u", TipoCurso.class).getResultList();
	}
}
