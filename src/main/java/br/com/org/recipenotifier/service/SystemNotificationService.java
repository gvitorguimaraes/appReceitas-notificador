package br.com.org.recipenotifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Classe utilizada para gerenciar os eventos recebidos e direcionar os envios
 */

@Service
public class SystemNotificationService{
	
	@Autowired
	private EmailService emailService;
	
	@KafkaListener(topics = "${topics.subscriber}")
	public void receiveMessage(String message)
	{
		// Implementar logica para acionar o envio de e-mail **
		
		//emailService.sendEmail("gabrielvitogalo2@gmail.com", "TESTE ENVIO SISTEMA", message);
		
		//Temporario para teste
		System.out.println("Consumer Message: "+ message);
	}
}
