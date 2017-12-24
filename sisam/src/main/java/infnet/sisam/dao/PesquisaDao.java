package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Pesquisa;

@Repository
public class PesquisaDao extends JpaDao<Pesquisa>{

	public PesquisaDao() {
		super(Pesquisa.class);
	}
	
	public Boolean verificaPesquisaRespondida(Pesquisa pesquisa) {
		return getEm()
			.createNamedQuery("Pesquisa.verificaPesquisaRespondida", Boolean.class)
			.setParameter("avaliacaoId", pesquisa.getAvaliacao().getId()).setParameter("alunoId", pesquisa.getAluno().getId())
			.getSingleResult();
	}
	
	
}
