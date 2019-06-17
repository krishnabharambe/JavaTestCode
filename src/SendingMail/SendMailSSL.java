/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SendingMail;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

class smail {

    public static void send(String from, String password, String to, String sub, String msg) {
        //Get properties object    
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        //get Session   
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(from, password);
                    }
                });
        //compose message    
        try {
            MimeMessage message = new MimeMessage(session);
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            //send message  
            Transport.send(message);
            System.out.println("message sent successfully");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }

    }
}

public class SendMailSSL {

    public static void main(String[] args) {
        //from,password,to,subject,message  
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String currdate = simpleDateFormat.format(new Date());

        String now = simpleDateFormat.format(new Date());

        if (currdate.equals(now)) {
            smail.send("poolworld001@gmail.com", "PersonalBook", "vraut6733@gmail.com", "hello javatpoint", "How r u?");

        }

        //change from, password and to  
    }
}
