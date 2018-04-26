package main.utils;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

@Component
@EnableAsync
public class EmailUtils {

	@Autowired
	private JavaMailSender emailSender;

	public void sendSimpleMessage(EmailData emailData) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(emailData.getTo());
			message.setSubject(emailData.getSubject());
			message.setText(emailData.getText());

			this.emailSender.send(message);
		} catch (MailException exception) {
			exception.printStackTrace();
		}
	}

	public void sendSimpleMessageUsingTemplate(EmailData emailData) {
		emailData.setText(String.format(emailData.getText(), emailData.getTemplateArgs()));
		sendSimpleMessage(emailData);
	}

	public void sendMessageWithAttachment(EmailData emailData) {
		try {
			MimeMessage message = emailSender.createMimeMessage();
			// pass 'true' to the constructor to create a multipart message
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setTo(emailData.getTo());
			helper.setSubject(emailData.getSubject());
			helper.setText(emailData.getText());

			FileSystemResource file = new FileSystemResource(new File(emailData.getPathToAttachment()));
			helper.addAttachment("Invoice", file);

			this.emailSender.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

}
