package main.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.utility.StringUtil;
import main.domain.model.EmailData;
import main.domain.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

@Service
@EnableAsync
public class EmailUtils {

    @Autowired
    @Qualifier("javaMailSender")
    private JavaMailSender emailSender;
    @Autowired
    @Qualifier("freemakerConfig")
    private Configuration freemarkerConfig;

    @Async("asyncExecutor")
    public void sendSimpleMessage(EmailData mail, TemplatesEnum templateName) {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                    StandardCharsets.UTF_8.name());
            Template template = this.freemarkerConfig.getTemplate(templateName.getFileName());
            String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, mail.getModel());

            helper.setTo(mail.getTo());
            helper.setText(html, true);
            helper.setSubject(mail.getSubject());
            helper.setFrom(EmailData.from);

            this.emailSender.send(message);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    @Async("asyncExecutor")
    public void sendSimplesMessageToRejectedAdoptions(List<Person> personList, String animalName) {
        personList.stream().forEach(a -> {
            EmailData emailData = EmailData.builder().to(a.getEmail()).subject("Resposta ao pedido de adoção").build();
            Map<String, Object> model = new HashMap<>();
            model.put("name", StringUtil.capitalize(a.getName().split(" ")[0]));
            model.put("animal", animalName);
            emailData.setModel(model);
            sendSimpleMessage(emailData, TemplatesEnum.TEMPLATE_REJECTED_ADOPTION);
        });
    }

    @Bean
    public Executor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setBeanName("emailExecutor");
        executor.setThreadNamePrefix("EmailExecutor-");
        executor.initialize();
        return executor;
    }
}
