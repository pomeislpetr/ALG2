package utils;

import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


/**
 *
 * @author Pomeisl Petr
 */
public class Email {
    private static String filename = "test.txt";
    
    
    
    public static void main(String[] args) {
        // Recipient's email ID needs to be mentioned.
        String to = "petr.pomeisl@email.cz";

        // Sender's email ID needs to be mentioned
        String from = "ALG2.mail.2020@gmail.com";
        final String username = "alg2.mail.2020@gmail.com";
        final String password = "TULalg22020";
        
        // server odchozi posty - pro google k nalezeni na 
        String host = "smtp.gmail.com";
        
        Properties props = new Properties();
            props.put("mail.smtp.auth", "true"); //If true, attempt to authenticate the user using the AUTH command. 
                                                    //Defaults to false.
            props.put("mail.smtp.starttls.enable", "true"); //If true, enables the use of the STARTTLS command 
                                                                //(if supported by the server) to switch the connection 
                                                                //to a TLS-protected connection before issuing any login 
                                                                //commands. If the server does not support STARTTLS, 
                                                                //the connection continues without the use of TLS; 
                                                                //see the mail.smtp.starttls.required property to fail 
                                                                //if STARTTLS isn't supported. Note that an appropriate 
                                                                //trust store must configured so that the client will 
                                                                //trust the server's certificate. Defaults to false.
            props.put("mail.smtp.host", host); //The SMTP server to connect to.
            props.put("mail.smtp.port", "587"); //The SMTP server port to connect to, if the connect() method doesn't 
                                                    //explicitly specify one. Defaults to 25.
            props.put("mail.smtp.ssl.trust", "smtp.gmail.com"); //If set, and a socket factory hasn't been specified,
                                                                //enables use of a MailSSLSocketFactory. If set to "*",
                                                                //all hosts are trusted. If set to a whitespace 
                                                                //separated list of hosts, those hosts are trusted.
                                                                //Otherwise, trust depends on the certificate 
                                                                //the server presents.
//            props.put("mail.smtp.connectiontimeout", 300000);
                                                    
            // Get the Session object.
        Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });
        try {
	   // Create a default MimeMessage object.
	   Message message = new MimeMessage(session);
	
	   // Set From: header field of the header.
	   message.setFrom(new InternetAddress(from));
	
	   // Set To: header field of the header.
	   message.setRecipients(Message.RecipientType.TO,
               InternetAddress.parse(to));
	
	   // Set Subject: header field
	   message.setSubject("Testing Subject");
	
	   // Now set the actual message
           BodyPart messageBodyPart = new MimeBodyPart();
	   messageBodyPart.setText("testovaci mail pro semestralku");
           
           // Create a multipar message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filepath = ".\\src\\data\\" + filename;
            DataSource source = new FileDataSource(filepath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(filepath);
            multipart.addBodyPart(messageBodyPart);

            // Send the complete message parts
            message.setContent(multipart);

	   // Send message
	   Transport.send(message);

	   System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
         throw new RuntimeException(e);
      }
    }
}
