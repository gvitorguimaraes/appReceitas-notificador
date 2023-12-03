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
	
	private final JavaMailSender mailSender;
	
	// E-mail que será utilizado para enviar as mensagens
	private static final String EMAIL_ENVIO = "gabriel.guimaraes.1302796@sga.pucminas.br";
	
	public EmailService(final JavaMailSender mailSender)
	{
		this.mailSender = mailSender;
	}
	
	public void sendEmail(String toEmail, String subject, String body)
	{
		try 
		{
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(EMAIL_ENVIO);
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
}
