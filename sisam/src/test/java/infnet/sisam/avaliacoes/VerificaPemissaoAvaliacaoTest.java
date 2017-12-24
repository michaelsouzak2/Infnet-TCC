package infnet.sisam.avaliacoes;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import infnet.sisam.configuration.datasource.JPAConfiguration;
import infnet.sisam.configuration.datasource.JPADevelopmentConfiguration;
import infnet.sisam.dao.PesquisaDao;
import infnet.sisam.model.Aluno;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Pesquisa;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfiguration.class, JPADevelopmentConfiguration.class, PesquisaDao.class })
@ActiveProfiles("dev")
public class VerificaPemissaoAvaliacaoTest {

	@Autowired
	private PesquisaDao dao;

	@Test
	@Transactional
	public void verificaPesquisaRespondida() {
		Boolean verificaPesquisaRespondida = dao.verificaPesquisaRespondida(new Pesquisa(new Aluno(3), new Avaliacao(1)));
		Assert.assertFalse(verificaPesquisaRespondida);
	}
}
