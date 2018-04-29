package main.service;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import freemarker.template.TemplateException;
import main.model.Person;
import main.repository.PersonRepository;
import main.utils.EmailData;
import main.utils.EmailUtils;

@Service
public class PersonService {

	@Autowired
	private PersonRepository repository;
	@Autowired
	private EmailUtils emailUtil;

	public Person save(Person person) {
		if (person.getPassword().isEmpty()) {
			String date = person.getDateOfBirth().toString();
			person.setPassword(date);
		}
		return this.repository.save(person);
	}

	// TODO adicionar a url para acesasr a pagina via token
	public ResponseEntity<?> updatePassword(String email) throws MessagingException, IOException, TemplateException {
		Optional<Person> person = this.repository.findOneByEmailIgnoreCase(email);
		if (person.isPresent()) {
			person.get().setToken(this.getUUID());
			person.get().setDateToken(new Date());

			EmailData emailData = EmailData.builder().to(email).subject("Alteração de senha no Dogtech").build();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("name", person.get().getName().split(" ")[0].toUpperCase());
			model.put("link", "http://AINDA_NÃO_EXISTE_O_ENDPOINT_PARA_GERAR_O_LINK_AQUI.com");
			emailData.setModel(model);
			this.emailUtil.sendSimpleMessage(emailData);

			this.repository.save(person.get());
			return ResponseEntity.accepted().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}
	
	private String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
