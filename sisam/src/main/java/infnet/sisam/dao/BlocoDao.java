package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Bloco;

@Repository
public class BlocoDao extends JpaDao<Bloco> {
	
	public BlocoDao() {
		super(Bloco.class);
	}
	
	public List<Bloco> listar() {
		return em.createQuery("select u from Bloco u", Bloco.class).getResultList();
	}
}
