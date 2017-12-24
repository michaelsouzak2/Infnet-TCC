package infnet.sisam.schedule;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Component;

import infnet.sisam.dao.AvaliacaoDao;
import infnet.sisam.dto.TokenDTO;
import infnet.sisam.helper.Constantes;
import infnet.sisam.helper.TokenHelper;
import infnet.sisam.helper.UrlProvider;
import infnet.sisam.model.Aluno;
import infnet.sisam.model.Pesquisa;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Convite;
import infnet.sisam.model.Turma;

/**
 * Verifica tarefa de envio de e-mail
 */
@Component
public class EmailSchedule {

	@Autowired
	private AvaliacaoDao avaliacaoService;
	@Autowired
	private FormattingConversionService conversionService;
	@Autowired
	private TokenHelper tokenHelper;
	@Autowired
	private MailSender sender;
	@Autowired
	private UrlProvider provider;
	
	private static final Logger LOGGER = Logger.getLogger(EmailSchedule.class);

//	@Scheduled(cron = "0 0/5 * * * ?", zone = "America/Sao_Paulo")
	public void init() {
		LOGGER.info("Scheduler acionado às : ".concat(conversionService.convert(Calendar.getInstance(), String.class)));
		List<Avaliacao> avaliacoes = avaliacaoService.buscaAvaliacaoPendente();
		if (!avaliacoes.isEmpty()) {
			checkStudentsToBeNotified(avaliacoes);
		}
	}

	private void checkStudentsToBeNotified(List<Avaliacao> avaliacoes) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (!avaliacao.getTurmas().isEmpty()) {
				for (Turma turma : avaliacao.getTurmas()) {
					for (Aluno aluno : turma.getAlunos()) {
						sendMail(new Pesquisa(aluno, avaliacao));
					}
				}
			}
		}
	}
	
	private void sendMail(Pesquisa alunoAvaliacao) {
		TokenDTO dto = new TokenDTO();
		dto.setAlunoId(alunoAvaliacao.getAluno().getId());
		dto.setAvaliacaoId(alunoAvaliacao.getAvaliacao().getId());
		
		String token = tokenHelper.encrypt(dto);
		String linkAvaliacao = provider.getUrl().concat(Constantes.PATH_PESQUISA).concat(token);
		String genero = alunoAvaliacao.getAluno().getSexo().equals("M") ? "Prezado " : "Prezada ";
		
		Aluno aluno = alunoAvaliacao.getAluno();
		Convite convite = alunoAvaliacao.getAvaliacao().getConvite();

		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(Constantes.EMAIL_FROM);
			message.setTo(aluno.getEmail());
			message.setSubject(convite.getTitulo());
			message.setText(
					genero.concat(aluno.getNome()).concat(",\n")
					.concat(convite.getMensagem()).concat("\n")
					.concat(linkAvaliacao)
				);
			sender.send(message);
		} catch (Exception e) {
			LOGGER.error("Ocorreu um erro ao enviar email para: " + aluno.getEmail() + "\nCausa: " + e.getMessage());
		}
	}

}
