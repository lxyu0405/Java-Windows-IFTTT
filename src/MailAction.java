import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class MailAction {
	
	public static void SendMail(String srcID,String srcPassword,String desID,String mesContent)throws Exception{
		Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");    
        props.setProperty("mail.smtp.port", "465"); //gmail 
        props.setProperty("mail.smtp.auth", "true");   
        props.setProperty("mail.smtp.ssl.enable", "true");   
        props.setProperty("mail.smtp.connectiontimeout", "5000"); 
        
        final String usr = srcID;
        final String pwd = srcPassword;
        Session session = Session.getInstance(props, new Authenticator(){
        	protected PasswordAuthentication getPasswordAuthentication(){
        		return new PasswordAuthentication(usr,pwd);
        	}
        });
        session.setDebug(true);
        Transport transport = session.getTransport("smtps");
        transport.connect("smtp.gmail.com",usr,pwd);
        //message
        MimeMessage message = new MimeMessage(session);
        message.setContent(mesContent, "text/plain");
        message.setSubject("From IFTTT");
        //receiver 
        message.addRecipients(Message.RecipientType.TO, new InternetAddress[]{
        	new InternetAddress(desID)
        });
        
        message.saveChanges();
        
        Transport.send(message);
        System.out.println("email has been sent~");
        transport.close();
	}
	
	public static Folder SignIn(String srcID,String srcPassword){
		//System.out.println("get in the ReceiveMail fuction");
		String popServer = "imap.gmail.com";//gmail server
		Store store = null;
		Folder folder = null;
		Properties props = System.getProperties();
		props.setProperty("mail.store.protocol", "imaps");//email protocol
		
		Session session = Session.getDefaultInstance(props,null);
		//connect to server
		try {
			store = session.getStore("imaps");		
			//System.out.println(popServer+"  "+srcID+"   "+srcPassword);
			store.connect(popServer, srcID, srcPassword);
		//get folder list
			folder = store.getDefaultFolder();
		if(folder == null)
			throw new Exception("No default folder");
		}catch(Exception e){
			e.printStackTrace();
		}	
		return folder;
		}
		
	public static boolean CheckReceivedMail(Folder folder,Date date){
		try{
		folder = folder.getFolder("INBOX");
		folder.open(Folder.READ_ONLY);
		Message msgs[] = folder.getMessages();
		for(int i = msgs.length-1;i > msgs.length - 3;i--){
			System.out.println("looking through the inbox list: Message" + i);
			System.out.println(msgs[i].getSentDate());
			Date msgDate = msgs[i].getSentDate();
			if(msgDate.compareTo(date) > 0)
				return true;
		}
		folder.close(false);
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
		
	}
}
