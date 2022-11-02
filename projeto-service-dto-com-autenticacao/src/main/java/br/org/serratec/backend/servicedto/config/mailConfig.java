package br.org.serratec.backend.servicedto.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Configuration
public class mailConfig {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	public void sendEmail(String para, String assunto, String texto) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("gabrielsimoes703@gmail.com");
		message.setTo(para);
		message.setSubject(assunto);
		message.setText("Dados da inscrição: \n" + texto + "\n\n\nSerratec Residência de Software");
		javaMailSender.send(message);
	}

}
