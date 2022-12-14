package com.FernandezMarketProject.utils;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JOptionPane;

public class SendMail {

	public static void mandarCorreo(String recepient) throws MessagingException {
		 
		Properties properties = new Properties();
		
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		String myAccountemail = "fernandezmarketcorreo@gmail.com";
		String password = "sU8hlPtD";
		
		Session session = Session.getInstance(properties, new Authenticator(){
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(myAccountemail,password);
			}
			
		});
		
		Message message = prepareMessage(session,myAccountemail,recepient );
		
		Transport.send(message);
		
	}

	private static Message prepareMessage(Session session, String myAccountemail, String recepient){
	
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(myAccountemail));
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("¡Bienvenido a la familia Fernandez Market!");
			//message.setText("Bienvenido a Fernandez Market, estamos muy felices de que te hayas unido a nuestra familia");
			
			String html = "<div style = \"text-align: center\">"+
					""+
					"        <h1 style=\"background-color: rgb(231, 79, 13); color: whitesmoke; font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif; font-weight: 100; \">"+
					"            ¡Bienvenido a la familia Fernandez Market!</h1>"+
					"        <br>"+
					""+
					"        <span  style=\"display: inline; color:rgb(70, 70, 70); font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-weight: 500; font-size: 1.3em;\">"+
					"            ¡Estamos"+
					"        </span>"+
					""+
					"        <span  style=\"display: inline; color:rgb(255, 122, 65);  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-weight: 500; font-size: 1.3em;\">"+
					"            muy contentos</span>"+
					"        <span  style=\"display: inline; color:rgb(70, 70, 70); font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-weight: 500; font-size: 1.3em;\">"+
					"            de que te hayas unido a nuestra página!</span>"+
					"        "+
					"        <br><br>"+
					"        <span  style=\" color:rgb(70, 70, 70);  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-weight: 300; font-size: 1em;\">"+
					"            Puedes revisar la página cuando quieras y descubrir nuevas promociones y productos interesantes"+
					"        </span>"+
					"        <br><br><br>"+
					"        "+
					""+
					"        <a href = \"http://localhost:8080/Fernandez_Market_Project/IndexPagina\" style=\"    "+
					"         font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-weight: 300;"+
					"        color: tomato;"+
					"        \">"+
					"            Entrar a la tienda"+
					"        </a>"+
					"        "+
					"    </div>";
						

						

				
			
			message.setContent(html, "text/html");
			
			return message;
			
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}