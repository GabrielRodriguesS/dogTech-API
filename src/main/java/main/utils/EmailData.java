package main.utils;

import java.util.List;
import java.util.Map;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmailData {

	static final String from = "ongsjpa@gmail.com";
	private String to;
	private String subject;
	private List<Object> attachments;
	private Map<String, Object> model;

}