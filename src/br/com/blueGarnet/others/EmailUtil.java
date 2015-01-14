package br.com.blueGarnet.others;
/*
 _     _             _____                       _   
| |   | |           / ____|                     | |  
| |__ | |_   _  ___| |  __  __ _ _ __ _ __   ___| |_ 
| '_ \| | | | |/ _ \ | |_ |/ _` | '__| '_ \ / _ \ __|
| |_) | | |_| |  __/ |__| | (_| | |  | | | |  __/ |_ 
|_.__/|_|\__,_|\___|\_____|\__,_|_|  |_| |_|\___|\__|

							  Fellipe Pimentel © 2014
										 www.fcode.co
*/


import java.io.File;
import java.util.Date;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
 
public class EmailUtil {
 
    /**
     * Utility method to send simple HTML email
     * @param session
     * @param toEmail
     * @param subject
     * @param body
     */
    public static void sendEmail(Session session, String toEmail, String subject, File arquivo){
        try
        {
          MimeMessage msg = new MimeMessage(session);
          //set message headers
          msg.setHeader("Content-Type", "text/plain; charset=UTF-8");
 
          msg.setFrom(new InternetAddress("financeiro@saojudastadeu.cnt.br", "Financeiro - Escritório Contábil SJT"));
 
          //msg.setReplyTo(InternetAddress.parse("no_reply@journaldev.com", false));
 
          msg.setSubject(subject, "UTF-8");
 
          msg.setSentDate(new Date());

          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
          
          MimeMultipart multipart = new MimeMultipart();
          // first part  (the html)
          BodyPart mbp1 = new MimeBodyPart();
          String htmlText =
        		  "<H1>Escritório Contábil São Judas Tadeu</H1>"+
        		  "Prezado Cliente,<br>"+
        		  "Segue em anexo boleto referente ao mês no título do e-mail.<br>"+
        		  "Caso haja qualquer dúvida com relação ao mesmo,<br>"+
        		  "favor entrar em contato com o Escritório.<br><br><br>"+
        		  "Agradecemos desde já,<br>"+
        		  "Escritório Contábil São Judas Tadeu.";
          mbp1.setContent(htmlText, "text/html; charset=UTF-8");

          // cria a segunda parte da mensagem
          MimeBodyPart mbp2 = new MimeBodyPart();

          // anexa o arquivo à mensagem
          FileDataSource fds = new FileDataSource(arquivo);
          mbp2.setDataHandler(new DataHandler(fds));
          mbp2.setFileName(fds.getName());
          // add it
          multipart.addBodyPart(mbp1);
          multipart.addBodyPart(mbp2);
          msg.setContent(multipart);
          
          Transport.send(msg); 
 
          System.out.println("E-mail enviado com sucesso!");
        }
        catch (Exception e) {
          e.printStackTrace();
        }
    }
}