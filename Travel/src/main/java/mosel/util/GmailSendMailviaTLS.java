package mosel.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class GmailSendMailviaTLS {
	/**
	 * 寄件
	 * @param toEmailAddress 收件地址
	 * @param subject 主旨
	 * @param contnet 寄信內容
	 */
 public static void sendEmail(String toEmailAddress, String subject, String contnet) {
	 		System.out.println("寄送email開始.");
  String host = "smtp.gmail.com";
  int port = 587;
  final String username = "LoveInInNest@gmail.com";
  final String password = "ininlove";//your password

  Properties props = new Properties();
  props.put("mail.smtp.host", host);
  props.put("mail.smtp.auth", "true");
  props.put("mail.smtp.starttls.enable", "true");
  props.put("mail.smtp.port", port);
  props.put("mail.smtp.ssl.trust", "*");
  Session session = Session.getInstance(props, new Authenticator() {
   protected PasswordAuthentication getPasswordAuthentication() {
    return new PasswordAuthentication(username, password);
   }
  });

  try {

   Message message = new MimeMessage(session);
   message.setFrom(new InternetAddress("LoveInInNest@gmail.com"));
   message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmailAddress));
   message.setSubject(subject);
   message.setText(contnet);

   Transport transport = session.getTransport("smtp");
   transport.connect(host, port, username, password);

   Transport.send(message);

   System.out.println("寄送email結束.");

  } catch (MessagingException e) {
   throw new RuntimeException(e);
  }
 }
}