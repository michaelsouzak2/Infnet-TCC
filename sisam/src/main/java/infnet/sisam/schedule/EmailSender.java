package infnet.sisam.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import infnet.sisam.dao.AvaliacaoDao;
import infnet.sisam.helper.Constantes;
import infnet.sisam.model.Aluno;
import infnet.sisam.model.Avaliacao;
import infnet.sisam.model.Convite;
import infnet.sisam.model.Turma;

@Component
public class EmailSender {

	@Autowired
	private MailSender sender;

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/5 * * * ?", zone = "America/Sao_Paulo")
	public void init() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Scheduler acionado às :" + sdfDate.format(new Date()));
		List<Avaliacao> avaliacoes = avaliacaoDao.getEm().createNamedQuery("Avaliacao.buscaAvaliacaoPendente")
				.getResultList();
		if (!avaliacoes.isEmpty()) {
			verificaAlunosParaSeremNotificados(avaliacoes);
		} else {
			System.out.println("Não existem avaliações para envio de notificaão.");
		}
	}

	private void verificaAlunosParaSeremNotificados(List<Avaliacao> avaliacoes) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (!avaliacao.getTurmas().isEmpty()) {
				for (Turma turma : avaliacao.getTurmas()) {
					for (Aluno aluno : turma.getAlunos()) {
						envioNotificacao(aluno, avaliacao.getConvite());
					}
				}
			}
		}
	}

	private void envioNotificacao(Aluno aluno, Convite convite) {
		SimpleMailMessage s = new SimpleMailMessage();
		s.setFrom(Constantes.EMAIL_FROM);
		s.setTo(aluno.getEmail());
		s.setSubject(convite.getTitulo());
		s.setText("Olá," + aluno.getNome() + "\n" + convite.getMensagem());
		try {
			sender.send(s);
			System.out.println("Email enviado para o aluno: " + aluno.getNome());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao enviar email para: " + aluno.getEmail());
			System.out.println("Erro ao enviar email:\n " + e.getStackTrace());
		}
	}
}
