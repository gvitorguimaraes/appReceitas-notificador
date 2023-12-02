package br.com.org.recipenotifier.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

/**
 * Classe responsável em fazer o envio de email das notificações
 */

@Service
public class EmailService {
	/**
	@Autowired
	private JavaMailSender mailSender;
	
	@Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Set up Gmail config
        mailSender.setHost("${email.sender.host}");
        mailSender.setPort(2525);

        // Set up email config (using udeesa email)
        mailSender.setUsername("${email.sender.user}");
        mailSender.setPassword("${email.sender.password}");

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "${email.sender.debug}");
        return mailSender;
    }
	
	public void sendEmail(String toEmail, String subject, String body)
	{
		try 
		{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom("gabriel.guimaraes.1302796@sga.pucminas.br");
			message.setTo(toEmail);
			message.setSubject(subject);
			message.setText(body);
			
			mailSender.send(message);
			System.out.println("E-mail enviado!");
		}
		catch(Exception e)
		{
			System.out.println("Falha ao enviar o e-mail!");
			throw new IllegalStateException("failed to send email");
		}
	}
	
	**/
}
