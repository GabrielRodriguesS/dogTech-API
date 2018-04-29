package main.service;

import freemarker.template.utility.StringUtil;
import main.model.Person;
import main.repository.PersonRepository;
import main.utils.EmailData;
import main.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

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
    public ResponseEntity<?> requestUpdatePassword(String email) {
        Optional<Person> person = this.repository.findOneByEmailIgnoreCase(email);
        if (person.isPresent()) {
            person.get().setToken(this.getUUID());
            person.get().setDateToken(new Date());

            EmailData emailData = EmailData.builder().to(email).subject("Alteração de senha no Dogtech").build();
            Map<String, Object> model = new HashMap<>();
            model.put("name", StringUtil.capitalize(person.get().getName().split(" ")[0]));
            model.put("link", "http://AINDA_NÃO_EXISTE_O_ENDPOINT_PARA_GERAR_O_LINK_AQUI.com");
            emailData.setModel(model);
            this.emailUtil.sendSimpleMessage(emailData);

            this.repository.save(person.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    // TODO descobrir se é melhor retornar null ou outra coisa caso o token tenha vencido
    public Person findByToken(String token) {
        Person person = this.repository.findByToken(token);
        Duration duration = Duration.between(person.getDateToken().toInstant(), new Date().toInstant());
        if (duration.toHours() < 24) {
            return person;
        } else {
            return null;
        }
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }


}
