package infnet.sisam.dao;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Avaliacao;

@Repository
public class AvaliacaoDao extends JpaDao<Avaliacao> {

	public AvaliacaoDao() {
		super(Avaliacao.class);
	}

	public List<Avaliacao> buscaAvaliacaoPendente(Calendar hoje) {
		return getEm()
				.createNamedQuery("Avaliacao.buscaAvaliacaoPendente", Avaliacao.class)
				.setParameter("dataHoje", hoje)
				.getResultList();
	}
}
