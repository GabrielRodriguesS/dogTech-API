package main.utils;

import org.springframework.mail.SimpleMailMessage;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmailData {

	private String to;
	private String subject;
	private String text;
	private SimpleMailMessage template;
	private String templateArgs;
	private String pathToAttachment;

}