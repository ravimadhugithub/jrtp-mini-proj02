package usermanagement.jrtp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService{

	@Autowired
	private JavaMailSender mailSender;
	
	@Override
	public boolean sendEmail(String subject, String body, String to) {

		SimpleMailMessage msg=new SimpleMailMessage();
		msg.setTo(to);
		msg.setText(body);
		msg.setSubject(subject);
		msg.setFrom("ravi.vemulawada@gmail.com");
		mailSender.send(msg);
		return true;
	}

}
