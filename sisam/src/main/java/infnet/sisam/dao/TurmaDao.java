package infnet.sisam.dao;

import org.springframework.stereotype.Repository;

import infnet.sisam.model.Turma;

@Repository
public class TurmaDao extends JpaDao<Turma> {

	public TurmaDao() {
		super(Turma.class);
	}
}
