package main.service;

import main.domain.dto.PersonDTO;
import main.domain.model.Person;
import main.domain.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> user = this.personRepository.findOneByEmailIgnoreCase(username);
        if (user.isPresent()) {
            return new PersonDTO(user.get());
        }
        throw new UsernameNotFoundException(username);

    }
}
