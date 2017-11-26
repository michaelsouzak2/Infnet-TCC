package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Topico;

@Repository
public class TopicoDao extends JpaDao<Topico> {
	
	public TopicoDao() {
		super(Topico.class);
	}
	
	public List<Topico> listar(){
		return em.createQuery("select t from Topico t", Topico.class).getResultList();
	}
	
}
