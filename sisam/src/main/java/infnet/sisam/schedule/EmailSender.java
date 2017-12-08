package infnet.sisam.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import infnet.sisam.dao.AvaliacaoDao;

@Component
public class EmailSender {

	@Autowired
	private MailSender sender;
	
	@Autowired
	private AvaliacaoDao avaliacaoDao;

	@Scheduled(cron = "0 0/5 14-15 * * ?", zone = "America/Sao_Paulo")
	public void init() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Scheduler acionado às :" + sdfDate.format(new Date()));
		
		avaliacaoDao.findAll();
		// verifica quem enviaremos email
		System.out.println("Email enviado para o aluno: xxx");
		SimpleMailMessage s = new SimpleMailMessage();
		s.setFrom("avaliacaoinfnettc@gmail.com");
		s.setTo("avaliacaoinfnettc@gmail.com");//s.setTo("raffamz@gmail.com");
		s.setText("Olá");
		sender.send(s);
		//se enviou email, ifnrom
		// LOG.debug("Término leitura Fila: " + sdfDate.format(new Date()));
	}
}
