package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.AlunoAvaliacao;

@Repository
public class AlunoAvaliacaoDao extends JpaDao<AlunoAvaliacao> {

	public AlunoAvaliacaoDao() {
		super(AlunoAvaliacao.class);
	}

}
