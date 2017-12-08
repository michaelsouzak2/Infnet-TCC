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
import infnet.sisam.model.Turma;

@Component
public class EmailSender {

	@Autowired
	private MailSender sender;

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@Scheduled(cron = "0 0/5 18-23 * * ?", zone = "America/Sao_Paulo")
	public void init() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Scheduler acionado às :" + sdfDate.format(new Date()));
		Date sysdate = new Date();
		List<Avaliacao> avaliacoes = avaliacaoDao.findAll();
		if (!avaliacoes.isEmpty()) {
			verificaAlunosParaSeremNotificados(sysdate, avaliacoes);
		} else {
			System.out.println("Não existem avaliações para envio de notificaão.");
		}

	}

	private void verificaAlunosParaSeremNotificados(Date sysdate, List<Avaliacao> avaliacoes) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (!avaliacao.getDataInicio().before(sysdate)) {
				if (!avaliacao.getTurmas().isEmpty()) {
					verificaTurmaParaNotificacao(avaliacao);
				} else {
					System.out.println("Não existem turmas para a avaliação: " + avaliacao.getId());
				}
			} else {
				System.out.println("Avaliação " + avaliacao.getId() + " ainda não deve ser executada.");
			}
		}
	}

	private void verificaTurmaParaNotificacao(Avaliacao avaliacao) {
		for (Turma turma : avaliacao.getTurmas()) {
			List<Aluno> alunosParticipantes = turma.getAlunos();
			envioNotificacao(avaliacao, alunosParticipantes);
		}
	}

	private void envioNotificacao(Avaliacao avaliacao, List<Aluno> alunosParticipantes) {
		for (Aluno aluno : alunosParticipantes) {
			System.out.println("Email enviado para o aluno: " + aluno.getNome());
			SimpleMailMessage s = new SimpleMailMessage();
			s.setFrom(Constantes.EMAIL_FROM);
			s.setTo(aluno.getEmail());
			s.setText("Olá," + aluno.getNome() + "\n Vc recebeu um email para poder iniciar sua avaliação.");
			try {
				sender.send(s);
			} catch (Exception e) {
				System.out.println("Ocorreu um erro ao enviar email para: " + aluno.getEmail());
			}
		}
	}
}
