package main.service;

import freemarker.template.utility.StringUtil;
import main.domain.model.EmailData;
import main.domain.model.Person;
import main.domain.model.enums.TemplatesEnum;
import main.domain.repository.PersonRepository;
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
    private EmailUtils emailUtils;

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
            this.sendEmail(person.get().getName(), email, "http://AINDA_NÃO_EXISTE_O_ENDPOINT_PARA_GERAR_O_LINK_AQUI.com");
            this.repository.save(person.get());
            return ResponseEntity.accepted().build();
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    public ResponseEntity<Person> findByToken(String token) {
        Person person = this.repository.findByToken(token);
        Duration duration = Duration.between(person.getDateToken().toInstant(), new Date().toInstant());
        if (duration.toHours() < 24) {
            return ResponseEntity.ok(person);
        }
        return ResponseEntity.badRequest().build();
    }

    private String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    private void sendEmail(String name, String email, String link) {
        EmailData emailData = EmailData.builder().to(email).subject("Alteração de senha no Dogtech").build();
        Map<String, Object> model = new HashMap<>();
        model.put("name", StringUtil.capitalize(name.split(" ")[0]));
        model.put("link", link);
        emailData.setModel(model);
        this.emailUtils.sendSimpleMessage(emailData, TemplatesEnum.TEMPLATE_UPDATE_PASSWORD);
    }
}
