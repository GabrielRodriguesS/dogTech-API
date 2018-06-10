package main.domain.stateMachine.stateActions;

import freemarker.template.utility.StringUtil;
import main.domain.model.Adoption;
import main.domain.model.Animal;
import main.domain.model.EmailData;
import main.domain.model.Person;
import main.domain.model.enums.TemplatesEnum;
import main.domain.repository.AdoptionRepository;
import main.domain.stateMachine.StatesActions;
import main.domain.stateMachine.stateMachineEnums.States;
import main.service.AnimalService;
import main.utils.EmailUtils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdoptedAction implements StatesActions {
    @Override
    public Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtils) {
        this.updateAnimal(adoption.getAnimal(), animalService);
        adoption.setDateAdoption(new Date());
        List<Adoption> allAdoptionsRejected = repository.findByAnimalIdAndStatusEquals(
                adoption.getAnimal(), States.WAITING);
        List<Person> allAdopters = allAdoptionsRejected.stream()
                .map(Adoption::getAdopter).collect(Collectors.toList());
        this.rejectAllAdoptions(allAdoptionsRejected, repository);
        emailUtils.sendSimpleMessageToRejectedAdoptions(allAdopters, adoption.getAnimal().getName());
        this.sendApprovedEmailData(adoption.getAdopter().getEmail(), adoption.getAdopter().getName(),
                adoption.getAnimal().getName(), emailUtils);
        return adoption;
    }

    private void sendApprovedEmailData(String email, String name, String animalName, EmailUtils emailUtils) {
        EmailData emailData = EmailData.builder().to(email).subject("Resposta ao pedido de adoção").build();
        Map<String, Object> model = new HashMap<>();
        model.put("name", StringUtil.capitalize(name.split(" ")[0]));
        model.put("animal", animalName);
        emailData.setModel(model);
        emailUtils.sendSimpleMessage(emailData, TemplatesEnum.TEMPLATE_APPROVED_ADOPTION);
    }

    private void updateAnimal(Animal animal, AnimalService animalService) {
        animal.setAvailable(false);
        animalService.save(animal);
    }

    private void rejectAllAdoptions(List<Adoption> adoptions, AdoptionRepository repository) {
        adoptions.stream().forEach(a -> {
            repository.updateState(a.getId(), States.REJECTED);
        });
    }
}
