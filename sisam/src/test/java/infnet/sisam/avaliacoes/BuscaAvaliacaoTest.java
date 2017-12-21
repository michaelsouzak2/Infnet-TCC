package infnet.sisam.avaliacoes;

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
@ActiveProfiles("dev")
public class BuscaAvaliacaoTest {

	@Autowired
	private AvaliacaoDao avaliacaoDao;
	
	@Test
	public void buscaAvaliacao() {
		
		Avaliacao av = avaliacaoDao.buscar(1);
		
		Assert.notNull(av);
	}
	
}
