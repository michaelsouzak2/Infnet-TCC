package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.GrupoQuestoes;

@Repository
public class GrupoQuestoesDao extends JpaDao<GrupoQuestoes> {
	
	public GrupoQuestoesDao() {
		super(GrupoQuestoes.class);
	}
	
}
