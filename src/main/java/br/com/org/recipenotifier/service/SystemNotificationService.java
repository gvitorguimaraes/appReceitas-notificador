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
	
	static final String MENSAGEM_AVISO = "\n\n ** E-mail de teste enviado pelo sistema desenvolvido para a "
										+ "disciplina de Desenvolvimento de Aplicações Distribuidas, quaisquer informações enviadas podem "
										+ "ser desconsideradas servindo somente para testes da funcionalidade. **";
	
	/*
	* Método responsável por consumir as mensagens do EventHub
	*/
	@KafkaListener(topics = "${topics.subscriber}")
	public void receiveMessage(String message)
	{
		String[] dados = message.split(";");
		
		if(dados.length == 4)
		{
			String usuario = dados[0];
			String email = dados[1];
			String assunto = dados[2];
			String mensagem = dados[3];
			
			// Envia o e-mail de notificação para o e-mail do usuário
			emailService.sendEmail(email, assunto + " - " + usuario, message + MENSAGEM_AVISO);
			System.out.println("Mensagem recebida e enviada com sucesso!");
		}
		else 
		{
			//Temporario para teste
			System.out.println("Mensagem recebida no formato errado!");
			System.out.println("** Message: "+ message);
		}
	}
}
