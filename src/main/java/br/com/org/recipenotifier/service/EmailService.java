package br.com.org.recipenotifier.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Classe responsável em fazer o envio de email das notificações
 */

@Service
public class EmailService {
	
	private final JavaMailSender mailSender;
	
	// E-mail que será utilizado para enviar as mensagens
	private static final String EMAIL_ENVIO = "<seu e-mail aqui>";
	
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
			throw new IllegalStateException("Falha ao enviar e-mail");
		}
	}
}
