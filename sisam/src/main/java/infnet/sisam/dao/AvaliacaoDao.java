package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Avaliacao;

@Repository
public class AvaliacaoDao extends JpaDao<Avaliacao> {

	public AvaliacaoDao() {
		super(Avaliacao.class);
	}

	public List<Avaliacao> buscaAvaliacaoPendente() {
		return getEm()
				.createNamedQuery("Avaliacao.buscaAvaliacaoPendente", Avaliacao.class)
				.getResultList();
	}
}
