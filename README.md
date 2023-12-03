# Sistema Notificador - Plataforma de Receitas

Esse projeto consiste em um mini sistema que tem a função de notificar os usuários do sistema de receitas sempre que ocorre alguma operação na aplicação.
Na versão atual as notificações são enviadas por e-mail inicialmente somente para demonstrar a funcionalidade, mas a ideia conceitual seria que o sistema fosse capaz também de enviar notificações via WhatsApp, notificação do dispositivo no caso do aplicativo mobile e dentro do próprio app.
\n
> O sistema funciona utilizando mensageria com Kafka no EventHubs da Azure, o sistema de origem envia a mensagem para o EventHub no tópico especifico do sistema de notificação, o sistema de notificação recebe essa mensagem em formato de 'String', extrai os dados da mensagem e envia o e-mail.

### Formato da mensagem

> [Nome do usuário];[E-mail];[Assunto];[Mensagem]

(Os dados são separados por ';' e sem espaço entre eles.)

### Arquitetura

O sistema foi desenvolvido utilizando a linguagem Java 17 com SpringBoot 3.2.0, as mensagem são consumidas usando as bibliotecas do Kafka do proprio framework. O e-mail utilizado como exemplo para fazer os envios foi o da PUC via a plataforma SMTP2GO para ter acesso via SMTP.

### Requisitos para execução

- JDK, Java 17
- Maven
- IDE para executar a aplicação e subir o servidor TomCat

### Instalação

- Clonar ou fazer o download do projeto
- Importar como um projeto Maven em alguma IDE (Eclipse, IntelliJ, NetBeans, etc)
- Definir a classe 'RecipeNotifierApplication' para executar o sistema.
- Alterar as configurações de conexão com o EventHub no arquivo 'application.yml'
- Alterar e-mail de envio na variável constante 'EMAIL_ENVIO' no arquivo 'EmailService'.

- Ao ser carregado, o sistema ficara ativo e escutando na conexão com o EventHubs da Azure, sempre que houver uma mensagem ele irá ler e enviar o e-mail.