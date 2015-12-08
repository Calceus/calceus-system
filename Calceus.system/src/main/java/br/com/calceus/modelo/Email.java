package br.com.calceus.modelo;

import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

public class Email {

	public void enviarEmailFormatado(String emailDestino) {
		HtmlEmail email = new HtmlEmail();
		email.setSSLOnConnect(true);
		email.setStartTLSRequired(true);
		email.setHostName("smtp.mail.yahoo.com");
		email.setSslSmtpPort("465 ");
		email.setAuthentication("laercio_ferracini@yahoo.com.br", "Paarthurnax");
		// email.setAuthenticator( new DefaultAuthenticator(
		// "laercio_ferracini@yahoo.com.br" , "Paarthurnax" ) );
		try {
			email.setFrom("laercio_ferracini@yahoo.com.br", "Equipe Calceus");
			email.setDebug(true);
			email.setSubject("Bem Vindo");

			StringBuilder builder = new StringBuilder();
			builder.append("<h1>Cadastro realizado com sucesso</h1>");
			builder.append("<p>Bem vindo, <b>agora</b> você pode realizar suas compras.</p>");
			builder.append("<a href=\"http://wwww.calceusfootwear.com.br\">Calceus</a> <br> ");
			// builder.append("<img
			// src=\"http://www.botecodigital.info/wp-content/themes/boteco/img/logo.png\">");

			email.setHtmlMsg(builder.toString());
			email.addTo(emailDestino);
			System.out.println("Sending...");
			email.send();
			System.out.println("Email Send!");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}

	// o tratamento de excessoes foi simplificado (throws AddressException,
	// MessagingException)
	// para facilitar o entendimento do exemplo
	public void enviarEmail() throws AddressException, MessagingException {
		// objeto para definicao das propriedades de configuracao do provider
		Properties props = new Properties();
		// o valor "smtp.host.com.br" deve ser alterado para o seu servidor SMTP
		props.put("mail.com", "smtp.mail.com");
		// obtendo um Session com a configuração
		// do servidor SMTP definida em props
		Session session = Session.getDefaultInstance(props);
		// criando a mensagem
		MimeMessage message = new MimeMessage(session);
		// substituir pelos e-mails desejados
		Address from = new InternetAddress("calceus@mail.com");
		Address to = new InternetAddress("laercio_ferracini@yahoo.com.br");
		// configurando o remetente e o destinatario
		message.setFrom(from);
		message.addRecipient(RecipientType.TO, to);
		// configurando a data de envio, o assunto e o texto da mensagem
		message.setSentDate(new Date());
		message.setSubject("Assunto da mensagem");
		message.setText("Texto da mensagem!");
		// enviando
		Transport.send(message);
	}

	public void enviarEmail(String destinatario, String nome) {
		Mailling m = new Mailling("smtp.mail.com", "587");

		m.sendMail("calceus@mail.com", destinatario, "Bem vindo "+nome, "Caro(a) "+nome+" seu cadastro foi realizado com sucesso\nAcesse: " +"http://www.calceusfootwear.com\n\nEquipe Calceus");
	}
}
