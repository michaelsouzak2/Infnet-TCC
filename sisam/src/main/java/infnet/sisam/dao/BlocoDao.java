package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Bloco;

@Repository
public class BlocoDao extends JpaDao<Bloco> {
	
	public BlocoDao() {
		super(Bloco.class);
	}
}
