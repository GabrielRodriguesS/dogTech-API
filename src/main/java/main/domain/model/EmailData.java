package main.domain.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Builder
@Data
public class EmailData {

    public static final String from = "ongsjpa@gmail.com";
	private String to;
	private String subject;
	private List<Object> attachments;
	private Map<String, Object> model;

}