package infnet.sisam.schedule;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EmailSender {

	@Autowired
	private MailSender sender;

	@Scheduled(cron = "* */5 * * * *", zone = "America/Sao_Paulo")
	public void init() {
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		System.out.println("Teste schedule:" + sdfDate.format(new Date()));
		// verifica quem enviaremos email
		SimpleMailMessage s = new SimpleMailMessage();
		s.setFrom("avaliacaoinfnettc@gmail.com");
		s.setTo("avaliacaoinfnettc@gmail.com");//s.setTo("raffamz@gmail.com");
		s.setText("Olá");
		sender.send(s);
		// LOG.debug("Término leitura Fila: " + sdfDate.format(new Date()));
	}
}
