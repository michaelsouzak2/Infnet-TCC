package infnet.sisam.avaliacoes;

import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import infnet.sisam.configuration.JPAConfiguration;
import infnet.sisam.dao.AvaliacaoDao;
import infnet.sisam.model.Avaliacao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfiguration.class, AvaliacaoDao.class})
@ActiveProfiles("dev")//Trocar para o profile de teste e configurar um DataSource de teste.
public class AvaliacaoPendenteTest {
	
	@Autowired
	private AvaliacaoDao avaliacaoDao;
	
	@Test
	public void recuperaAvaliacoesPendentes() {

		List<Avaliacao> avaliacoes = avaliacaoDao.buscaAvaliacaoPendente(Calendar.getInstance());
		
		Assert.notNull(avaliacoes);
	}

}
