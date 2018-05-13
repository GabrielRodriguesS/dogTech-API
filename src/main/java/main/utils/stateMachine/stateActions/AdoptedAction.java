package main.utils.stateMachine.stateActions;

import freemarker.template.utility.StringUtil;
import main.domain.model.Adoption;
import main.domain.model.Animal;
import main.domain.model.EmailData;
import main.domain.model.Person;
import main.domain.repository.AdoptionRepository;
import main.service.AnimalService;
import main.utils.EmailUtils;
import main.utils.TemplatesEnum;
import main.utils.stateMachine.StatesActions;
import main.utils.stateMachine.stateMachineEnums.States;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AdoptedAction implements StatesActions {
    @Override
    public Adoption action(Adoption adoption, AnimalService animalService, AdoptionRepository repository, EmailUtils emailUtils) {
        this.updateAnimal(adoption.getAnimalId(), animalService);
        adoption.setDateAdoption(new Date());
        List<Adoption> allAdoptionsRejected = repository.findByAnimalIdAndStatusEquals(
                adoption.getAnimalId(), States.WAITING);
        List<Person> allAdopters = allAdoptionsRejected.stream()
                .map(Adoption::getAdopter).collect(Collectors.toList());
        this.rejectAllAdoptions(allAdoptionsRejected, repository);
        emailUtils.sendSimplesMessageToRejectedAdoptions(allAdopters, adoption.getAnimalId().getName());
        this.sendApprovedEmailData(adoption.getAdopter().getEmail(), adoption.getAdopter().getName(),
                adoption.getAnimalId().getName(), emailUtils);
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
            a.setStatus(States.REJECTED);
            repository.save(a);
        });
    }
}
