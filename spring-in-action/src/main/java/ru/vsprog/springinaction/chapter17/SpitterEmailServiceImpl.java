package ru.vsprog.springinaction.chapter17;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.velocity.VelocityEngineUtils;
import ru.vsprog.springinaction.chapter7.Spittle;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Component
public class SpitterEmailServiceImpl implements SpitterEmailService {
    public void sendSpittleEmail(String to, Spittle spittle) {
        sendSimpleSpittleEmail(to, spittle);
    }

    public void sendSimpleSpittleEmail(String to, Spittle spittle) {
        SimpleMailMessage message = new SimpleMailMessage();

        String spitterName = (String) spittle.getSpitter().getFullName();
        message.setFrom("noreply@spitter.com");
        message.setTo(to);
        message.setSubject("New spittle from " + spitterName);

        message.setText(spitterName + " says: " +
                spittle.getText());

        mailSender.send(message);
    }

    public void sendSpittleEmailWithAttachment(
            String to, Spittle spittle) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper =
                new MimeMessageHelper(message, true);

        String spitterName = (String) spittle.getSpitter().getFullName();
        helper.setFrom("noreply@spitter.com");
        helper.setTo(to);
        helper.setSubject("New spittle from " + spitterName);

        helper.setText(spitterName + " says: " + spittle.getText());

        FileSystemResource couponImage =
                new FileSystemResource("/collateral/coupon.png");
        helper.addAttachment("Coupon.png", couponImage);

        mailSender.send(message);
    }

    public void sendRichSpitterEmail(String to, Spittle spittle) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setFrom("noreply@spitter.com");
        helper.setTo("craig@habuma.com");
        helper.setSubject("New spittle from " +
                spittle.getSpitter().getFullName());

        helper.setText("<html><body><img src='cid:spitterLogo'>" +
                "<h4>" + spittle.getSpitter().getFullName() + " says...</h4>" +
                "<i>" + spittle.getText() + "</i>" +
                "</body></html>", true);

        ClassPathResource image = new ClassPathResource("spitter_logo_50.png");
        helper.addInline("spitterLogo", image);
        mailSender.send(message);
    }

    public void sendTemplatedEmail(String to, Spittle spittle)
            throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        String spitterName = (String) spittle.getSpitter().getFullName();
        helper.setFrom("noreply@spitter.com");
        helper.setTo("craig@habuma.com");
        helper.setSubject("New spittle from " + spitterName);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("spitterName", spitterName);
        model.put("spittleText", spittle.getText());
        String emailText =
                VelocityEngineUtils.mergeTemplateIntoString(
                        velocityEngine,
                        "emailTemplate.vm",
                        model);

        helper.setText(emailText, true);

        ClassPathResource image = new ClassPathResource("spitter_logo_50.png");
        helper.addInline("spitterLogo", image);
        mailSender.send(message);
    }

    @Autowired
    JavaMailSender mailSender;

    @Autowired
    VelocityEngine velocityEngine;
}
