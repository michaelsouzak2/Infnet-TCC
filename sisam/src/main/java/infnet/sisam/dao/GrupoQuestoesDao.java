package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.GrupoQuestoes;

@Repository
public class GrupoQuestoesDao extends JpaDao<GrupoQuestoes> {
	
	public GrupoQuestoesDao() {
		super(GrupoQuestoes.class);
	}
	
	public List<GrupoQuestoes> listar(){
		return em.createQuery("select g from GrupoQuestoes g", GrupoQuestoes.class).getResultList();
	}
	
}
