package fr.adaming.service;

import java.io.OutputStream;
import java.io.ByteArrayOutputStream; 

import java.io.OutputStream; 

import java.util.Properties; 

 

import javax.activation.DataHandler; 

import javax.activation.DataSource; 

import javax.mail.Authenticator; 

import javax.mail.Message; 

import javax.mail.PasswordAuthentication; 

import javax.mail.Session; 

import javax.mail.Transport; 

import javax.mail.internet.InternetAddress; 

import javax.mail.internet.MimeBodyPart; 

import javax.mail.internet.MimeMessage; 

import javax.mail.internet.MimeMultipart; 

import javax.mail.util.ByteArrayDataSource; 

 

import org.springframework.stereotype.Service; 

 

import com.lowagie.text.Chunk; 

import com.lowagie.text.Document; 

import com.lowagie.text.Paragraph; 

import com.lowagie.text.pdf.PdfWriter; 

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.model.Client;

@Service("mlService")
@Transactional
public class MailServiceImpl implements IMailService{

	/** 

	 * création de l'email : on définit l'adresse emetrice (+mdp) et on récupere les informations sur les serveurs 

	 * @param cl 

	 * @param objetMail 

	 * @param corpsMail 

	 * @param nomPDF 

	 * @param corpsPDF 

	 */ 

	@Override 

	public void email(Client cl, String objetMail, String corpsMail, String nomPDF, String corpsPDF) { 

	final String username = "cancer.mail974@gmail.com"; 

	final String password = "GmailBM97450"; 

	 

	Properties props = new Properties(); 

	props.put("mail.smtp.auth", "true"); 

	props.put("mail.smtp.starttls.enable", "true"); 

	props.put("mail.smtp.host", "smtp.gmail.com"); 

	props.put("mail.smtp.port", "587"); 

	 

	// on récupère la session 

	Session session = Session.getInstance(props, new Authenticator() { 

	protected PasswordAuthentication getPasswordAuthentication() { 

	return new PasswordAuthentication(username, password); 

	} 

	}); 

	 

	ByteArrayOutputStream outputStream = null; 

	 

	//mise en forme des éléments de l'email 

	try { 

	// construct the text body part 

	MimeBodyPart textBodyPart = new MimeBodyPart(); 

	textBodyPart.setText(corpsMail); 

	 

	// now write the PDF content to the output stream 

	outputStream = new ByteArrayOutputStream(); 

	writePdf(outputStream, corpsPDF); 

	byte[] bytes = outputStream.toByteArray(); 

	 

	// construct the pdf body part 

	DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf"); 

	MimeBodyPart pdfBodyPart = new MimeBodyPart(); 

	pdfBodyPart.setDataHandler(new DataHandler(dataSource)); 

	pdfBodyPart.setFileName(nomPDF + ".pdf"); 

	 

	// construct the mime multi part 

	MimeMultipart mimeMultipart = new MimeMultipart(); 

	mimeMultipart.addBodyPart(textBodyPart); 

	mimeMultipart.addBodyPart(pdfBodyPart); 

	 

	// create the sender/recipient addresses 

	InternetAddress iaSender = new InternetAddress(username); 

	InternetAddress iaRecipient = new InternetAddress("valentinchiron@free.fr"); 

	 

	// construct the mime message 

	MimeMessage mimeMessage = new MimeMessage(session); 

	mimeMessage.setSender(iaSender); 

	mimeMessage.setSubject(objetMail); 

	mimeMessage.setRecipient(Message.RecipientType.TO, iaRecipient); 

	mimeMessage.setContent(mimeMultipart); 

	 

	// send off the email 

	Transport.send(mimeMessage); 

	 

	System.out.println("mail envoyé"); 

	 

	} catch (Exception ex) { 

	ex.printStackTrace(); 

	} finally { 

	// clean off 

	if (null != outputStream) { 

	try { 

	outputStream.close(); 

	outputStream = null; 

	} catch (Exception ex) { 

	} 

	} 

	} 

	} 

	 

	/** 

	 * Writes the content of a PDF file (using iText API) to the 

	 * {@link OutputStream}. 

	 *  

	 * @param outputStream 

	 *            {@link OutputStream}. 

	 * @throws Exception 

	 */ 

	@Override 

	public void writePdf(OutputStream outputStream, String corpsPDF) throws Exception { 

	Document document = new Document(); 

	PdfWriter.getInstance(document, outputStream); 

	 

	document.open(); 

	 

	document.addTitle("Facture Belle ile"); 

	document.addSubject("Votre facture Belle ile"); 

	document.addKeywords("Commande, Belle ile"); 

	document.addAuthor("Belle ile"); 

	document.addCreator("Belle ile"); 

	 

	Paragraph paragraph = new Paragraph(); 

	paragraph.add(new Chunk(corpsPDF)); 

	document.add(paragraph); 

	 

	document.close(); 

	} 

	 

	 

	} 
