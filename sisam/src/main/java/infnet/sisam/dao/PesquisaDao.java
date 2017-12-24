package infnet.sisam.dao;

import javax.persistence.NoResultException;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Pesquisa;

@Repository
public class PesquisaDao extends JpaDao<Pesquisa>{

	public PesquisaDao() {
		super(Pesquisa.class);
	}
	
	public Pesquisa verificaPesquisaRespondida(Pesquisa pesquisa) {
		try {
			return getEm()
					.createNamedQuery("Pesquisa.verificaPesquisaRespondida", Pesquisa.class)
					.setParameter("avaliacaoId", pesquisa.getAvaliacao().getId()).setParameter("alunoId", pesquisa.getAluno().getId())
					.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
		
	}
	
	
}
