package com.we2.mailsend;
import java.io.File;
import java.util.Properties;
 
import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
 
public class MailExam {
    public static void main(String[] args){
        try{
            new MailExam();
        }catch(Exception e){
            System.out.println("Error");
        }
    }
    public MailExam() throws Exception{
    
        Properties props = new Properties(); 
        props.setProperty("mail.transport.protocol", "smtp"); 
        props.setProperty("mail.host", "smtp.gmail.com"); 
        props.put("mail.smtp.auth", "true"); 
        props.put("mail.smtp.port", "465"); 
        props.put("mail.smtp.socketFactory.port", "465"); 
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
        props.put("mail.smtp.socketFactory.fallback", "false"); 
        props.setProperty("mail.smtp.quitwait", "false"); 
         
        Authenticator auth = new Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication() { 
                return new PasswordAuthentication("jun0e86@gmail.com", "since2016@"); 
            }
        };
    
        Session session = Session.getDefaultInstance(props,auth);
         
        MimeMessage message = new MimeMessage(session); 
        message.setSender(new InternetAddress("jun0e86@gmail.com")); 
        message.setSubject("test"); 
 
        message.setRecipient(Message.RecipientType.TO, new InternetAddress("jun0e86@naver.com")); 
         
        Multipart mp = new MimeMultipart();
        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setText("잘 전송이 되었습니까? We2 회원여러분!!!!");
        mp.addBodyPart(mbp1);
 
        String filename = "C:/Users/jun/Downloads/eclipse저장소/MailEx01/img/2.jpg";
        if(filename != null){
            if(fileSizeCheck(filename)){
                MimeBodyPart mbp2 = new MimeBodyPart();
                FileDataSource fds = new FileDataSource(filename);
                mbp2.setDataHandler(new DataHandler(fds));
                mbp2.setFileName(MimeUtility.encodeText(fds.getName(), "UTF-8", "B"));
             
                mp.addBodyPart(mbp2);
            }else{
                throw new Exception("file size overflow !");
            }
        }
         
        MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
        mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
        mc.addMailcap("text/xml;; x-java-content-handler=com.sun.mail.handlers.text_xml");
        mc.addMailcap("text/plain;; x-java-content-handler=com.sun.mail.handlers.text_plain");
        mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
        mc.addMailcap("message/rfc822;; x-java-content-handler=com.sun.mail.handlers.message_rfc822");
        CommandMap.setDefaultCommandMap(mc);
         
        message.setContent(mp);
         
        Transport.send(message);
    }
     protected boolean fileSizeCheck(String filename) {
        if (new File(filename).length() > (1024 * 1024 * 2.5)) {
            return false;
        }
        return true;
    }
}
