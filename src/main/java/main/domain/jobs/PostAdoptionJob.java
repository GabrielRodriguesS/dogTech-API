package main.domain.jobs;

import main.service.AdoptionService;
import main.utils.EmailUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class PostAdoptionJob {
    @Autowired
    private AdoptionService adoptionService;
    @Autowired
    private EmailUtils emailUtils;

    @Scheduled(cron = "0 0 0 * * ?")
    public void sendingOrderFeedbackAdoption() {
        this.emailUtils.sendSimpleMessageToRequestFeedback(this.adoptionService.findAdoptionsToRequestFeedback());
    }
}
