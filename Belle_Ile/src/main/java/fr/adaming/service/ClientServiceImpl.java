package fr.adaming.service;

import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDao;
import fr.adaming.model.Client;

@Service("clService")
@Transactional
public class ClientServiceImpl implements IClientService {

	
	
	/*
	 * Association uml en java
	 */
	@Autowired
	private IClientDao cDao;

	/*
	 * setter
	 */
	public void setcDao(IClientDao cDao) {
		this.cDao = cDao;
	}
	
	
	

	@Override
	public Client addCl(Client c) {
		
		return cDao.addCl(c);
	}

	@Override
	public int deleteCl(Client c) {
		
		return cDao.deleteCl(c);
	}

	@Override
	public int updateCl(Client c) {
		
		return cDao.updateCl(c);
	}

	@Override
	public List<Client> searchAllCl() {
		
		return cDao.searchAllCl();
	}

	@Override
	public Client searchByIdCl(Client c) {
		
		return cDao.searchByIdCl(c);
	}
	
	@Override
	public void sendMail(Client c, String messageMail) {

		final String username = "cancer.mail974@gmail.com";
		final String password = "GmailBM97450";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		// Get Session object.
		Session session = Session.getInstance(props, new Authenticator() {
		protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(username, password);
		}
		});

		try {

		// Create a default MimeMessage object.
		Message message = new MimeMessage(session);

		// Set From: header field of the header.
		message.setFrom(new InternetAddress(username));

		// Set To: header field of the header.		
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress("valentinchiron@free.fr")); //"valentinchiron@free.fr"

		// Set Subject: header field
		message.setSubject("Belle Ile");

		// Now set the actual message
		message.setText("Chère Madame/Monsieur, " + messageMail);

		// Send message
		Transport.send(message);

		System.out.println("Sent message successfully....");

		} catch (MessagingException e) {
		throw new RuntimeException(e);
		}
		}
	
	
	
	
	
	
	
	
	

}
