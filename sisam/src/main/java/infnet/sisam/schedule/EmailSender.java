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
import infnet.sisam.model.Usuario;
import infnet.sisam.service.UsuarioService;

@Component
public class EmailSender {

	@Autowired
	private MailSender sender;

	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@Autowired
	private UsuarioService usuarioService;

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/5 * * * ?", zone = "America/Sao_Paulo")
	public void init() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Scheduler acionado às :" + sdfDate.format(new Date()));
		List<Avaliacao> avaliacoes = avaliacaoDao.getEm().createNamedQuery("Avaliacao.buscaAvaliacaoPendente")
				.setParameter("dataHoje", new Date()).getResultList();
		if (!avaliacoes.isEmpty()) {
			verificaAlunosParaSeremNotificados(avaliacoes);
		} else {
			System.out.println("Não existem avaliações para envio de notificação.");
		}
	}

	private void verificaAlunosParaSeremNotificados(List<Avaliacao> avaliacoes) {
		for (Avaliacao avaliacao : avaliacoes) {
			if (!avaliacao.getTurmas().isEmpty()) {
				for (Turma turma : avaliacao.getTurmas()) {
					for (Aluno aluno : turma.getAlunos()) {
						envioNotificacao(aluno, avaliacao.getId(), avaliacao.getConvite());
					}
				}
			}
		}
	}

	private void envioNotificacao(Aluno aluno, Integer idAvaliacao, Convite convite) {
		String linkAvaliacao = Constantes.URI_SERVIDOR + idAvaliacao + "/" + aluno.getId();
		String tratamentoAluno = aluno.getSexo().equals("M") ? "Prezado " : "Prezada ";
		try {
			Usuario usuario = criarUsuarioAluno(aluno);
			if (usuario != null) {
				SimpleMailMessage s = new SimpleMailMessage();
				s.setFrom(Constantes.EMAIL_FROM);
				s.setTo(aluno.getEmail());
				s.setSubject(convite.getTitulo());
				s.setText(tratamentoAluno + aluno.getNome() + ",\n" + convite.getMensagem()
						+ "\nSeguem seus dados de acesso para responder a avaliação\n" + "\nLink de acesso: "
						+ linkAvaliacao + "\n" + "Login: " + aluno.getEmail() + "\n" + "Senha:" + usuario.getSenha());
				sender.send(s);
			} else {
				System.out.println("Não foi possível gerar usuário para aluno");
			}
			System.out.println("Email enviado para o aluno: " + aluno.getNome());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro ao enviar email para: " + aluno.getEmail());
			System.out.println("Erro ao enviar email:\n " + e.getMessage());
		}
	}

	private Usuario criarUsuarioAluno(Aluno aluno) {
		return usuarioService.criarUsuarioParaAvaliacao(aluno);
	}
}
