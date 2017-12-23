package infnet.sisam.avaliacoes;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import infnet.sisam.configuration.datasource.JPAConfiguration;
import infnet.sisam.configuration.datasource.JPADevelopmentConfiguration;
import infnet.sisam.dao.RespostaQuestaoDao;
import infnet.sisam.model.Aluno;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Likert;
import infnet.sisam.model.Questao;
import infnet.sisam.model.RespostaQuestao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfiguration.class, JPADevelopmentConfiguration.class, RespostaQuestaoDao.class })
@ActiveProfiles("dev")
public class GravarRespostaQuestaoTest {

	@Autowired
	private RespostaQuestaoDao dao;

	@Test
	@Transactional
	public void salvarEmMassa() {

		for (int i = 1; i <= 18; i++) {
			RespostaQuestao respostaQuestao = new RespostaQuestao();
			respostaQuestao.setId(i);
			respostaQuestao.setAluno(new Aluno(i));
			respostaQuestao.setAvaliacao(new Avaliacao(1));
			respostaQuestao.setQuestao(new Questao(i));

			if (i % 2 == 0) {
				respostaQuestao.setResposta(Likert.CONCORDO);
			} else if (i % 3 == 0) {
				respostaQuestao.setResposta(Likert.DISCORDO);
			} else if (i % 5 == 0) {
				respostaQuestao.setResposta(Likert.NAO_CONCORDO_NEM_DISCORDO);
			} else {
				respostaQuestao.setResposta(Likert.NAO_SEI_AVALIAR);

			}

			dao.salvar(respostaQuestao);
		}

		List<RespostaQuestao> respostas = dao.findByAvaliacao(new Avaliacao(1));

		Assert.notNull(respostas);

	}

}
