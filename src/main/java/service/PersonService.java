package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Person;
import main.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository repository;

	public Person savePerson(Person person) {
		if (person.getPassword().equals("#")) { //lembrar de colocar td envio de senha vazio no cadastro manual com #
			String date = person.getDateOfBirth().toString();
			person.setPassword(date);
		}
		return this.repository.save(person);
	}
}
