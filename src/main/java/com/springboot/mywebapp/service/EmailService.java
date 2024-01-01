package com.springboot.mywebapp.service;

import com.springboot.mywebapp.modal.MailRequest;
import com.springboot.mywebapp.modal.MailResponse;
import freemarker.template.Configuration;
import freemarker.template.Template;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender sender;
    @Autowired
    private Configuration config;

    public MailResponse sendEmail(MailRequest request, Map<String,Object> model) {
        MailResponse response = new MailResponse();
        MimeMessage message = sender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
            helper.addAttachment("union_union_all.png", new ClassPathResource("union_union_all.png"));
            Template t = config.getTemplate("email-template.ftl");
            String htmlString = FreeMarkerTemplateUtils.processTemplateIntoString(t,model);
            helper.setTo(request.getTo());
            helper.setText(htmlString, true);
            helper.setSubject(request.getSubject());
            helper.setFrom(request.getFrom());
            sender.send(message);
            response.setMessage("Mail Send to: "+ request.getTo());
            response.setStatus(Boolean.TRUE);


        } catch (Exception e) {
            response.setMessage("Mail Send failure::"+ e.getMessage());
        }

        return response;
    }
}
