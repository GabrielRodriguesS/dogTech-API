package main.domain.jobs;

import main.service.AdoptionService;
import main.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.stream.Collectors;

@Component
@EnableScheduling
public class PostAdoptionJob {
    @Autowired
    private AdoptionService adoptionService;
    @Autowired
    private EmailUtils emailUtils;

    @Scheduled(cron = "0 0 0 * * ?")
    public void sendingOrderFeedbackAdoption() {
        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime fifteenDaysAgo = now.plusDays(-15);
        this.emailUtils.sendSimpleMessageToRequestFeedback(
                this.adoptionService.findAdoptionsWithStateAdopted()
                        .stream().filter(
                        a -> a.getDateAdoption().toInstant().isBefore(fifteenDaysAgo.toInstant()))
                        .collect(Collectors.toList()));
    }
}
