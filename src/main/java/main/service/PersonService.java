package main.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import main.model.Person;
import main.repository.PersonRepository;
import main.utils.EmailUtils;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;
	@Autowired
	public EmailUtils emailUtil;

	public Person save(Person person) {
		if (person.getPassword().isEmpty()) {
			String date = person.getDateOfBirth().toString();
			person.setPassword(date);
		}
		return this.repository.save(person);
	}

	@Autowired
	public ResponseEntity<Person> updatePassword(String email) {
		Optional<Person> person = this.repository.findByEmail(email);
		if (person.isPresent()) {
			person.get().setToken(this.getUUID());
			person.get().setDateToken(new Date());
			this.emailUtil.sendSimpleMessage(email, "Troca de senha", getEmailBody(person.get()));
			return ResponseEntity.accepted().build();
		} else {
			return ResponseEntity.noContent().build();
		}
	}

	// TODO adicionar a url para acesasr a pagina via token
	private String getEmailBody(Person person) {
		return "Olá recebemos um pedido de alteração de senha no DogTech, acesse o link abaixo para alterar sua senha:\n%s\n";
	}

	private String getUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}

}
