package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Avaliacao;

@Repository
public class AvaliacaoDao extends JpaDao<Avaliacao> {

	public AvaliacaoDao() {
		super(Avaliacao.class);
	}
}
