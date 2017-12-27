package infnet.sisam.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Turma;

@Repository
public class TurmaDao extends JpaDao<Turma> {

	public TurmaDao() {
		super(Turma.class);
	}

	public List<Turma> buscarPelaAvaliacao(Avaliacao av) {
		return getEm().createQuery("select t from Turma t where t.avaliacao.id = :avId",Turma.class)
				.setParameter("avId", av.getId())
				.getResultList();
	}
}
